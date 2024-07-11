import React, { useState } from 'react';
import './CreateTicket.css';

function CreateTicket() {
  const [problemType, setProblemType] = useState<string>('');
  const [priority, setPriority] = useState<string>('');
  const [clientName, setClientName] = useState<string>('');
  const [problemSubject, setProblemSubject] = useState<string>('');

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    const ticket = { problemType, priority, clientName, problemSubject };
    console.log(ticket);

    fetch('http://localhost:8080/supportticket/ajouterTicket', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(ticket)
    })
      .then(response => {
        if (response.ok) {
          return response.text().then(text => {
            return text ? JSON.parse(text) : {}; // Handle empty response
          });
        } else {
          throw new Error('Network response was not ok');
        }
      })
      .then(data => {
        console.log('New Ticket added:', data);
      })
      .catch(error => {
        console.error('There was a problem with the fetch operation:', error);
      });
  };

  return (
    <div className="container">
      <h1>Création des tickets de support</h1>
      <div className="form-container">
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>Type de probleme:</label>
            <input
              type="text"
              value={problemType}
              onChange={(e) => setProblemType(e.target.value)}
            />
          </div>
          <div className="form-group">
            <div className="priority-buttons">
              <label>Priorité:</label>
              <button
                type="button"
                className={`priority-button ${priority === 'Elevée' ? 'high' : ''}`}
                onClick={() => setPriority('Elevée')}
              >
                Elevée
              </button>
              <button
                type="button"
                className={`priority-button ${priority === 'Modérée' ? 'moderate' : ''}`}
                onClick={() => setPriority('Modérée')}
              >
                Modérée
              </button>
              <button
                type="button"
                className={`priority-button ${priority === 'Basse' ? 'low' : ''}`}
                onClick={() => setPriority('Basse')}
              >
                Basse
              </button>
            </div>
          </div>
          <div className="form-group">
            <label>Nom du client:</label>
            <input
              type="text"
              value={clientName}
              onChange={(e) => setClientName(e.target.value)}
            />
          </div>
          <div className="form-group">
            <label>Sujet du Probleme:</label>
            <textarea
              value={problemSubject}
              onChange={(e) => setProblemSubject(e.target.value)}
            />
          </div>
          <button type="submit" className="submit-button">Appliquer</button>
        </form>
      </div>
    </div>
  );
}

export default CreateTicket;
