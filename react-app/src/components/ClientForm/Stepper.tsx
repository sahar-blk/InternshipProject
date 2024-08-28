import React from 'react';
import './Stepper.css';

interface StepperProps {
  currentStep: number;
}

const Stepper: React.FC<StepperProps> = ({ currentStep }) => {
  const steps = [
    'Informations de Base',
    'Informations sur les Contrats d\'Assurance',
    'Documents Requis par Contrat d\'Assurance',
  ];

  return (
    <div className="stepper">
      {steps.map((step, index) => (
        <div key={index} className={`step ${currentStep === index + 1 ? 'active' : ''}`}>
          <div className="step-name">{step}</div>
          <div className={`step-line ${currentStep === index + 1 ? 'active-line' : ''}`}></div>
        </div>
      ))}
    </div>
  );
};

export default Stepper;
