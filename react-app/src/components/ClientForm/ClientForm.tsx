import React, { useState } from 'react';
import Step1 from './Step1';
import Step2 from './Step2';
import Step3 from './Step3';
import Stepper from './Stepper';
import './ClientForm.css';

const ClientForm: React.FC = () => {
  const [currentStep, setCurrentStep] = useState(1);
  const [formData, setFormData] = useState({
    nom: '',
    prenom: '',
    dateNaissance: '',
    adresse: '',
    telephone: '',
    email: '',
    profession: '',
    employeur: '',
    adressePro: '',
    telephonePro: '',
    etatCivil: '',
    nomConjoint: '',
    nombreEnfants: '',
    typeContrat: '',
    numeroContrat: '',
    compagnieAssurance: '',
    dateDebut: '',
    dateFin: '',
    montantPrime: '',
    montantCouverture: '',
    franchise: '',
    documents: [],
  });

  const nextStep = () => setCurrentStep(currentStep + 1);
  const prevStep = () => setCurrentStep(currentStep - 1);

  const handleSubmit = () => {
    const formDataToSend = new FormData();

    // Append basic client data
    Object.keys(formData).forEach((key) => {
      if (key !== 'documents') {
        formDataToSend.append(key, (formData as any)[key]);
      }
    });

    // Append documents data
    formData.documents.forEach((doc, index) => {
      if (doc.file) {
        formDataToSend.append(`documents[${index}].typeContrat`, doc.typeContrat);
        formDataToSend.append(`documents[${index}].file`, doc.file);
      }
    });

    fetch('http://localhost:8080/supportticket/ajouterClient', {
      method: 'POST',
      body: formDataToSend,
    })
      .then((response) => response.json())
      .then((data) => console.log('Success:', data))
      .catch((error) => console.error('Error:', error));
  };

  return (
    <div className='containerForm'>
      <Stepper currentStep={currentStep} />
      {currentStep === 1 && <Step1 formData={formData} setFormData={setFormData} />}
      {currentStep === 2 && <Step2 formData={formData} setFormData={setFormData} />}
      {currentStep === 3 && <Step3 formData={formData} setFormData={setFormData} />}
      
      <div className='button-group'>
        {currentStep > 1 && (
          <button className='retour' onClick={prevStep}>
            ← Retour
          </button>
        )}
        {currentStep < 3 && (
          <button className='continuer' onClick={nextStep}>
            Continuer →
          </button>
        )}
        {currentStep === 3 && (
          <button className='valider' onClick={handleSubmit}>
            Valider
          </button>
        )}
      </div>
    </div>
  );
};

export default ClientForm;
