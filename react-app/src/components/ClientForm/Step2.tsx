import React from 'react';
import './Step2.css';

interface Step2Props {
  formData: {
    typeContrat: string;
    numeroContrat: string;
    compagnieAssurance: string;
    dateDebut: string;
    dateFin: string;
    montantPrime: string;
    montantCouverture: string;
    franchise: string;
  };
  setFormData: React.Dispatch<React.SetStateAction<any>>;
}

const Step2: React.FC<Step2Props> = ({ formData, setFormData }) => {
  return (
    <div className='steptwo-container'>
      <div className="section-container">
        <h2>Informations sur les Contrats d'Assurance</h2>
        <div className="informations-contrats">
          <div className="form-control">
            <label>Type de Contrat</label>
            <select
              value={formData.typeContrat}
              onChange={(e) => setFormData({ ...formData, typeContrat: e.target.value })}
            >
              <option value="auto">Assurance automobile</option>
              <option value="habitation">Assurance habitation</option>
              <option value="vie">Assurance vie</option>
              <option value="sante">Assurance santé</option>
              <option value="professionnelle">Assurance professionnelle</option>
              <option value="autres">Autres (préciser)</option>
            </select>
          </div>

          <div className="form-control">
            <label>Numéro de contrat</label>
            <input
              type="text"
              value={formData.numeroContrat}
              onChange={(e) => setFormData({ ...formData, numeroContrat: e.target.value })}
              required
            />
          </div>

          <div className="form-control">
            <label>Compagnie d'assurance</label>
            <input
              type="text"
              value={formData.compagnieAssurance}
              onChange={(e) => setFormData({ ...formData, compagnieAssurance: e.target.value })}
              required
            />
          </div>

          <div className="form-control">
            <label>Date de début de la couverture</label>
            <input
              type="date"
              value={formData.dateDebut}
              onChange={(e) => setFormData({ ...formData, dateDebut: e.target.value })}
              required
            />
          </div>

          <div className="form-control">
            <label>Date de fin de la couverture</label>
            <input
              type="date"
              value={formData.dateFin}
              onChange={(e) => setFormData({ ...formData, dateFin: e.target.value })}
              required
            />
          </div>

          <div className="form-control">
            <label>Montant de la prime</label>
            <input
              type="number"
              value={formData.montantPrime}
              onChange={(e) => setFormData({ ...formData, montantPrime: e.target.value })}
              required
            />
          </div>














          <div className="form-control">
            <label>Montant de la couverture</label>
            <input
              type="number"
              value={formData.montantCouverture}
              onChange={(e) => setFormData({ ...formData, montantCouverture: e.target.value })}
              required
            />
          </div>

          <div className="form-control">
            <label>Franchise</label>
            <input
              type="text"
              value={formData.franchise}
              onChange={(e) => setFormData({ ...formData, franchise: e.target.value })}
              required
            />
          </div>







          

         
        </div>
      </div>
    </div>
  );
};

export default Step2;
