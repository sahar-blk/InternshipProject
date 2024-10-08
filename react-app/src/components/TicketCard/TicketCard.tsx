import React from 'react';
import { useDrag } from 'react-dnd';
import { useNavigate } from 'react-router-dom';
import './TicketCard.css';

interface TicketData {
  id: number;
  probleme: string;
  priorite: string;
  probType: string;
  assignedTo: Worker; // Optional, as it may be null
  onDrop: (newStatus: string) => void;
}

const TicketCard: React.FC<TicketData> = ({ id, probleme, priorite, probType, assignedTo, onDrop }) => {
  const navigate = useNavigate();

  const [{ isDragging }, drag] = useDrag(() => ({
    type: 'ticket',
    item: assignedTo ? { id, status: 'En attente' } : undefined,
    canDrag: !!assignedTo, // Enable dragging only if assignedTo is present
    end: (item, monitor) => {
      const dropResult = monitor.getDropResult<{ status: string }>();
      if (item && dropResult) {
        onDrop(dropResult.status);
      }
    },
    collect: (monitor) => ({
      isDragging: monitor.isDragging(),
    }),
  }), [id, assignedTo]);

  const handleAssignClick = () => {
    navigate(`/assign-agent/${id}`);
  };

  return (
    <div ref={drag} className="card" style={{ opacity: isDragging ? 0.5 : 1 }}>
      <div className="header">
        <h2>Problème:</h2>

        {!assignedTo && ( // Show button only if not assigned
          <button className="bouton-assigner" onClick={handleAssignClick}>Assigner</button>
        )}
      </div>
      <p>{probleme}</p>
      <div className="tags">
        <div className="problem">{probType}</div>
        <div className="priority">{priorite}</div>
      </div>
    </div>
  );
};

export default TicketCard;
