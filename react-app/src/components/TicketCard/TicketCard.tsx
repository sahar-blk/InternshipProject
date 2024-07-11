import React from "react";
import "./TicketCard.css"
import './TicketCard.css';

interface TicketData {
  problemText: string;
  tags: string[];
  priority: string;
}

const TicketCard: React.FC<TicketData> = ({ problemText, tags, priority }) => {
  return (
    <div className="card">
      <div className="header">
        <h2>Problème:</h2>
        <button className="assign">Assigner</button>
      </div>
      <p>{problemText}</p>
      <div className="tags">
        {tags.map((tag, index) => (
          <button key={index} className="tag">{tag}</button>
        ))}
        <button className="priority">{priority}</button>
      </div>
    </div>
  );
};

export default TicketCard;


