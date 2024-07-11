import React from 'react';
import TicketCard from '../TicketCard/TicketCard';
import './SupportTicketManager.css';
import { useState, useEffect } from 'react';

interface TicketData {
  problemText: string;
  tags: string[];
  priority: string;
}

interface AppState {
  tickets: TicketData[];
  loading: boolean;
  error: string | null;
}

const SupportTicketManager: React.FC = () => {
    const [tickets, setTickets] = useState<TicketData[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);
  
    useEffect(() => {
      // Mock API call to fetch multiple tickets
      fetch('http://localhost:8080/supportticket/getAllTickets')
        .then(response => response.json())
        .then(data => {
          setTickets(data);
          setLoading(false);
        })
        .catch(error => {
          setError(error.message);
          setLoading(false);
        });
    }, []);
  
    if (loading) {
      return <div>Loading...</div>;
    }
  
    if (error) {
      return <div>Error: {error}</div>;
    }
  
    return (
      <div className="support-ticket-manager">
        <h1>Gestion des tickets de support</h1>
        <p>Créer et gérer des tickets de support</p>
        <h2>En attente</h2>
        <div className="ticket-list">
          {tickets.map((ticket, index) => (
            <TicketCard 
              key={index}
              problemText={ticket.problemText} 
              tags={ticket.tags} 
              priority={ticket.priority} 
            />
          ))}
        </div>
      </div>
    );
  };

export default SupportTicketManager;
