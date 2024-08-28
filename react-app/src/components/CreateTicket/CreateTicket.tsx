import React, { useState } from 'react';
import axios from 'axios';
import './CreateTicket.css';
import { useNavigate } from 'react-router-dom';

function CreateTicket() {
  // Component to create a support ticket
  const [probType, setProbType] = useState<string>(''); // State for problem type
  const [priorite, setPriorite] = useState<string>(''); // State for priority
  const [nomClient, setNomClient] = useState<string>(''); // State for client name
  const [probleme, setProbleme] = useState<string>(''); // State for problem description
  const navigate = useNavigate(); // Hook for navigation

  // Handle form submission
  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault(); // Prevent default form submission

    // Validate priority selection
    if (!priorite) {
      alert('Veuillez sélectionner une priorité.');
      return;
    }

    const ticket = { probType, priorite, nomClient, probleme }; // Create ticket object
    console.log('Form data:', ticket);

    // Post ticket to the server
    axios.post('http://localhost:8080/supportticket/ajouterTicket', ticket, {
      headers: { 'Content-Type': 'application/json' }
    })
      .then(response => {
        console.log('New Ticket added:', response.data);
        navigate('/'); // Navigate to the home route to display updated ticket lists
      })
      .catch(error => {
        console.error('There was a problem with the axios operation:', error);
      });
  };

  return (
    <div className="containerr">
      <h1>Création des tickets de support</h1>
      <div className="formulaire-container">
        <form onSubmit={handleSubmit}>
          <div className="form-groupe">
            <label>Type de problème:</label>
            <input
              type="text"
              value={probType}
              onChange={(e) => setProbType(e.target.value)} // Update problem type state on change
              required // Make input required
            />
          </div>
          <div className="form-groupe">
            <div className="priority-buttons">
              <label>Priorité:</label>
              <button
                type="button"
                className={`priority-button ${priorite === 'Elevée' ? 'high' : ''}`} // Highlight selected priority button
                onClick={() => setPriorite('Elevée')} // Set priority to 'Elevée'
              >
                Elevée
              </button>
              <button
                type="button"
                className={`priority-button ${priorite === 'Modérée' ? 'moderate' : ''}`} // Highlight selected priority button
                onClick={() => setPriorite('Modérée')} // Set priority to 'Modérée'
              >
                Modérée
              </button>
              <button
                type="button"
                className={`priority-button ${priorite === 'Basse' ? 'low' : ''}`} // Highlight selected priority button
                onClick={() => setPriorite('Basse')} // Set priority to 'Basse'
              >
                Basse
              </button>
            </div>
          </div>
          <div className="form-groupe">
            <label>Nom du client:</label>
            <input
              type="text"
              value={nomClient}
              onChange={(e) => setNomClient(e.target.value)} // Update client name state on change
              required // Make input required
            />
          </div>
          <div className="form-groupe">
            <label>Sujet du problème:</label>
            <textarea
              value={probleme}
              onChange={(e) => setProbleme(e.target.value)} // Update problem description state on change
              required // Make input required
            />
          </div>
          <button type="submit" className="submit-button">Appliquer</button>
        </form>
      </div>
    </div>
  );
}

export default CreateTicket;
