import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams, useNavigate } from 'react-router-dom';
import './AgentList.css';
import SearchInput from '../searchBar/SearchBar';

interface Worker {
    id: number;
    username: string;
    poste: string;
    role: string;
    profileImage: string;
}

const AgentList: React.FC = () => {
    const { ticketId } = useParams<{ ticketId: string }>(); // Get ticket ID from URL params
    const [workers, setWorkers] = useState<Worker[]>([]); // State to store workers
    const [filteredWorkers, setFilteredWorkers] = useState<Worker[]>([]); // State to store filtered workers
    const [selectedWorkerId, setSelectedWorkerId] = useState<number | null>(null); // State to store selected worker ID
    const navigate = useNavigate(); // Hook for navigation

    useEffect(() => {
        // Fetch workers from server
        axios.get('http://localhost:8080/supportticket/getAllWorkers')
            .then(response => {
                setWorkers(response.data);
                setFilteredWorkers(response.data); // Initialize filtered workers
            })
            .catch(error => console.error('Error fetching workers:', error));
    }, []);

    const handleWorkerClick = (id: number) => {
        setSelectedWorkerId(id); // Set selected worker ID
    };

    const handleAssignClick = async (workerId: number) => {
        if (ticketId) {
            try {
                // Assign worker to ticket
                const response = await axios.post('http://localhost:8080/supportticket/assignWorker', null, {
                    params: {
                        ticketId,
                        workerId,
                    },
                });
                console.log('Assign Worker Response:', response.data);
                navigate('/'); // Navigate to home route to display updated ticket lists
            } catch (error) {
                if (axios.isAxiosError(error)) {
                    console.error('Error assigning worker:', error.message);
                    if (error.response) {
                        // Server responded with a status code outside the 2xx range
                        console.error('Server Response:', error.response.data);
                    } else if (error.request) {
                        // Request was made but no response received
                        console.error('No Response:', error.request);
                    }
                } else {
                    console.error('Unknown Error:', error);
                }
            }
        } else {
            console.error('Ticket ID is missing.');
        }
    };

    const handleSearch = (query: string) => {
        const lowerCaseQuery = query.toLowerCase();
        const filtered = workers.filter(worker =>
            worker.username.toLowerCase().includes(lowerCaseQuery)
        );
        setFilteredWorkers(filtered); // Set filtered workers based on search query
    };

    return (
        <div className="worker-list">
            <div className="search-input-container">
                <SearchInput onSearch={handleSearch} /> {/* Search input component */}
            </div>
            <div className='agent-container'>
                {filteredWorkers.map(worker => (
                    <div
                        className={`worker-item ${selectedWorkerId === worker.id ? 'selected' : ''}`} // Highlight selected worker
                        key={worker.id}
                        onClick={() => handleWorkerClick(worker.id)} // Handle worker click
                    >
                        <img src={worker.profileImage} alt={worker.username} className="profile-image" /> {/* Worker profile image */}
                        <div className="worker-info">
                            <div className="worker-name">
                                {worker.username} {/* Worker username */}
                            </div>
                            <div className="worker-poste">{worker.poste} {/* Worker position */}</div>
                        </div>
                        <button className='assign' onClick={() => handleAssignClick(worker.id)}>Assigner</button> {/* Assign button */}
                    </div>
                ))}
            </div>
        </div>
    );
};

export default AgentList;
