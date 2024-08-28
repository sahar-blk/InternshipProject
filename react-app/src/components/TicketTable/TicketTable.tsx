import React, { useState, useEffect } from 'react';
import SearchInput from '../searchBar/SearchBar';
import TicketPopup from '../TicketCard/PopupCard'; // Import the new component
import './TicketTable.css';
import axios from 'axios';

interface Worker {
  id: number;
  username: string;
}

interface Ticket {
  id: number;
  probType: string;
  priorite: string;
  nomClient: string;
  probleme: string;
  etat: string;
  assignedTo: Worker | null;
}

const TicketTable: React.FC = () => {
  const [tickets, setTickets] = useState<Ticket[]>([]);
  const [searchQuery, setSearchQuery] = useState<string>('');
  const [selectedTicket, setSelectedTicket] = useState<Ticket | null>(null);

  useEffect(() => {
    fetchTickets();
  }, []);

  const fetchTickets = async () => {
    try {
      const response = await axios.get('http://localhost:8080/supportticket/getAllTickets');
      setTickets(response.data);
    } catch (error) {
      console.error('Error fetching tickets:', error);
    }
  };

  const filteredTickets = tickets.filter(ticket =>
    `${ticket.nomClient} ${ticket.probType}`.toLowerCase().includes(searchQuery.toLowerCase())
  );

  const handleButtonClick = (ticket: Ticket) => {
    setSelectedTicket(ticket);
  };

  const closePopup = () => {
    setSelectedTicket(null);
  };

  return (
    <>
      <div className='search-input'>
        <SearchInput onSearch={setSearchQuery} />
      </div>
      <div className="ticket-table-container">
        <table className="ticket-table">
          <thead>
            <tr>
              <th>Nom</th>
              <th>Prenom</th>
              <th>Type De Probleme</th>
              <th></th>
            </tr>
          </thead>
          <tbody>
            {filteredTickets.map(ticket => (
              <tr key={ticket.id}>
                <td>{ticket.nomClient.split(' ')[0]}</td>
                <td>{ticket.nomClient.split(' ')[1]}</td>
                <td>{ticket.probType}</td>
                <td><button className="arrow-button" onClick={() => handleButtonClick(ticket)}>→</button></td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      {selectedTicket && (
        <div className="popup-overlay">
          <div className="popup">
            <TicketPopup
              probleme={selectedTicket.probleme}
              probType={selectedTicket.probType}
              etat={selectedTicket.etat}
              closePopup={closePopup} // Pass the closePopup function as a prop
              assignedTo={selectedTicket.assignedTo || { id: 0, username: 'N/A' }} // Ensure assignedTo is passed correctly
            />
          </div>
        </div>
      )}
    </>
  );
};

export default TicketTable;
