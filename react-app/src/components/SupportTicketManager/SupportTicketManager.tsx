import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { DndProvider } from 'react-dnd';
import { HTML5Backend } from 'react-dnd-html5-backend';
import Slider from 'react-slick';
import TicketCard from '../TicketCard/TicketCard';
import TicketCardTraitement from '../TicketCard/TicketCardTraitement';
import DropTargetComponent from '../DragAndDrop/DropTargetComponent';
import './SupportTicketManager.css';

interface Worker {
  username: string;
}

interface TicketData {
  id: number;
  probleme: string;
  priorite: string;
  probType: string;
  etat: string;
  assignedTo: Worker; // Optional, as it may be null
}

const SupportTicketManager: React.FC = () => {
  const [ticketsEnAttente, setTicketsEnAttente] = useState<TicketData[]>([]);
  const [ticketsEnCours, setTicketsEnCours] = useState<TicketData[]>([]);
  const [ticketsTermines, setTicketsTermines] = useState<TicketData[]>([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const navigate = useNavigate();

  useEffect(() => {
    const fetchTickets = async () => {
      try {
        const [enAttente, enCours, termines] = await Promise.all([
          axios.get('http://localhost:8080/supportticket/GetAllTicketsByEtat/En attente'),
          axios.get('http://localhost:8080/supportticket/GetAllTicketsByEtat/En cours'),
          axios.get('http://localhost:8080/supportticket/GetAllTicketsByEtat/Terminé')
        ]);

        setTicketsEnAttente(enAttente.data);
        setTicketsEnCours(enCours.data);
        setTicketsTermines(termines.data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchTickets();
  }, []);

  const handleStatusChange = async (ticket: TicketData, newStatus: string) => {
    try {
      const response = await axios.put(`http://localhost:8080/supportticket/updateTicketStatus/${ticket.id}`, {
        etat: newStatus,
      });

      setTicketsEnAttente((prev) => prev.filter(t => t.id !== ticket.id));
      setTicketsEnCours((prev) => prev.filter(t => t.id !== ticket.id));
      setTicketsTermines((prev) => prev.filter(t => t.id !== ticket.id));

      switch (newStatus) {
        case 'En attente':
          setTicketsEnAttente((prev) => [...prev, { ...ticket, etat: newStatus }]);
          break;
        case 'En cours':
          setTicketsEnCours((prev) => [...prev, { ...ticket, etat: newStatus }]);
          break;
        case 'Terminé':
          setTicketsTermines((prev) => [...prev, { ...ticket, etat: newStatus }]);
          break;
        default:
          break;
      }
    } catch (error) {
      console.error("Error updating ticket status", error.response?.data || error.message);
    }
  };

  const getSliderSettings = (tickets: TicketData[]) => {
    return {
      dots: true,
      infinite: false,
      speed: 500,
      slidesToShow: Math.min(tickets.length, 3),
      slidesToScroll: 1,
      adaptiveHeight: true,
      responsive: [
        {
          breakpoint: 1260,
          settings: {
            slidesToShow: 2,
            slidesToScroll: 1,
          }
        },
        {
          breakpoint: 900,
          settings: {
            slidesToShow: 1,
            slidesToScroll: 1,
          }
        }
      ]
    };
  };

  const handleCreateClick = () => {
    navigate(`/create-ticket`);
  };

  return (
    <DndProvider backend={HTML5Backend}>
      <div className="support-ticket-manager">
        <h1>Gestion des tickets de support</h1>
        <p>Créer et gérer des tickets de support</p>

        <DropTargetComponent status="En attente" onDrop={(ticket, newStatus) => handleStatusChange(ticket, newStatus)}>
          <div className='enAttente'>
            <div className="header">
              <h1>En attente</h1>
              <button className="custom-button" onClick={handleCreateClick}>
                <span className="custom-button-icon">+</span>
              </button>
            </div>
            {ticketsEnAttente.length > 0 ? (
              <Slider {...getSliderSettings(ticketsEnAttente)}>
                {ticketsEnAttente.map((ticket, index) => (
                  <div key={index} className="ticket-slide">
                    <TicketCard 
                      id={ticket.id}
                      probleme={ticket.probleme} 
                      probType={ticket.probType} 
                      priorite={ticket.priorite} 
                      assignedTo={ticket.assignedTo} // Pass assignedTo to TicketCard
                      onDrop={(newStatus) => handleStatusChange(ticket, newStatus)}
                    />
                  </div>
                ))}
              </Slider>
            ) : (
              <p>Aucun ticket en attente</p>
            )}
          </div>
        </DropTargetComponent>

        <DropTargetComponent status="En cours" onDrop={(ticket, newStatus) => handleStatusChange(ticket, newStatus)}>
          <div className='enCours'>
            <h1>En cours</h1>
            {ticketsEnCours.length > 0 ? (
              <Slider {...getSliderSettings(ticketsEnCours)}>
                {ticketsEnCours.map((ticket, index) => (
                  <div key={index} className="ticket-slide">
                    <TicketCardTraitement 
                      probleme={ticket.probleme} 
                      probType={ticket.probType} 
                      etat={ticket.etat} 
                      assignedTo={ticket.assignedTo}
                      onDrop={(newStatus) => handleStatusChange(ticket, newStatus)}
                    />
                  </div>
                ))}
              </Slider>
            ) : (
              <p>Aucun ticket en cours</p>
            )}
          </div>
        </DropTargetComponent>

        <DropTargetComponent status="Terminé" onDrop={(ticket, newStatus) => handleStatusChange(ticket, newStatus)}>
          <div className='termine'>
            <h1>Terminé</h1>
            {ticketsTermines.length > 0 ? (
              <Slider {...getSliderSettings(ticketsTermines)}>
                {ticketsTermines.map((ticket, index) => (
                  <div key={index} className="ticket-slide">
                    <TicketCardTraitement 
                      probleme={ticket.probleme} 
                      probType={ticket.probType} 
                      etat={ticket.etat} 
                      assignedTo={ticket.assignedTo}
                      onDrop={(newStatus) => handleStatusChange(ticket, newStatus)}
                    />
                  </div>
                ))}
              </Slider>
            ) : (
              <p>Aucun ticket terminé</p>
            )}
          </div>
        </DropTargetComponent>
      </div>
    </DndProvider>
  );
};

export default SupportTicketManager;
