import React from 'react';
import { useDrag } from 'react-dnd';
import './TicketCradTraitement.css';

interface Worker {
  username: string;
}

interface TicketData {
  probleme: string;
  probType: string;
  etat: string;
  assignedTo?: Worker; // Make this optional if it might not always be provided
  onDrop: (newStatus: string) => void;
}

const TicketCardTraitement: React.FC<TicketData> = ({ probleme, probType, etat, assignedTo, onDrop }) => {
  const [{ isDragging }, drag] = useDrag(() => ({
    type: 'ticket',
    item: { id: undefined, status: etat }, // Use current status for dragging
    end: (item, monitor) => {
      const dropResult = monitor.getDropResult<{ status: string }>();
      if (item && dropResult) {
        onDrop(dropResult.status);
      }
    },
    collect: (monitor) => ({
      isDragging: monitor.isDragging(),
    }),
  }), [etat]);

  const getEtatClass = (etat: string) => {
    switch (etat.toLowerCase()) {
      case 'en cours':
        return 'etat orange';
      case 'terminé':
        return 'etat green';
      default:
        return 'etat';
    }
  };

  return (
    <div ref={drag} className="card" style={{ opacity: isDragging ? 0.5 : 1 }}>
      <div className="header">
        <h2>Problème:</h2>
        <div className={getEtatClass(etat)}>{etat}</div>
      </div>
      <p>{probleme}</p>
      <div className="tags">
        <div className="problem">{probType}</div>
        <p>Assigné à {assignedTo ? assignedTo.username : 'Non attribué'}</p>
      </div>
    </div>
  );
};


export default TicketCardTraitement;
