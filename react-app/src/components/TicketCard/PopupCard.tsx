import React from "react";
import "./popupCard.css";

interface Worker {
  username: string;
}

interface TicketData {
  probleme: string;
  probType: string;
  etat: string;
  closePopup: () => void;
  assignedTo: Worker;
}
// Popup card pour la partie historique pour voir le probleme
const TicketPopup: React.FC<TicketData> = ({ probleme, probType, etat, closePopup, assignedTo }) => {
  // Function to set CSS class based on status
  const getEtatClass = (etat: string) => {
    switch (etat.toLowerCase()) {
      case "en cours":
        return "etat orange";
      case "terminé":
        return "etat green";
      default:
        return "etat";
    }
  };

  return (
    <div className="card">
      <div className="close-container">
        <button className="close-button" onClick={closePopup}>×</button>
      </div>
      <div className="header">
        <h2>Problème:</h2>
        <div className={getEtatClass(etat)}>{etat}</div>
      </div>
      <p>{probleme}</p>
      <div className="tags">
        <div className="problem">{probType}</div>
        <p>Assigné à {assignedTo.username}</p>
      </div>
    </div>
  );
};

export default TicketPopup;
