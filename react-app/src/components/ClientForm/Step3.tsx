import React, { useState } from 'react';
import './Step3.css';

interface Document {
  typeContrat: string;
  file: File | null;
}

interface Step3Props {
  formData: {
    documents: Document[];
  };
  setFormData: React.Dispatch<React.SetStateAction<any>>;
}

const Step3: React.FC<Step3Props> = ({ formData, setFormData }) => {
  const [documents, setDocuments] = useState<Document[]>([
    { typeContrat: '', file: null },
  ]);

  const availableContractTypes = [
    { value: 'auto', label: 'Assurance automobile' },
    { value: 'habitation', label: 'Assurance habitation' },
    { value: 'vie', label: 'Assurance vie' },
    { value: 'sante', label: 'Assurance santé' },
    { value: 'professionnelle', label: 'Assurance professionnelle' },
  ];

  const addDocument = () => {
    // Add a new empty document entry
    setDocuments([...documents, { typeContrat: '', file: null }]);
  };

  const handleDocumentChange = (index: number, field: keyof Document, value: any) => {
    const newDocuments = [...documents];
    newDocuments[index][field] = value;
    setDocuments(newDocuments);
    setFormData({ ...formData, documents: newDocuments });
  };

  // Filter out already selected contract types
  const getFilteredContractTypes = (index: number) => {
    return availableContractTypes.filter(
      (type) => !documents.some((doc, docIndex) => docIndex !== index && doc.typeContrat === type.value)
    );
  };

  return (
    <div className="stepthree-container">
      <h2>Documents Requis par Contrat d'Assurance</h2>

      {documents.map((document, index) => (
        <div className="form-group" key={index}>
          <div>
            <label>Type de Contrat</label>
            <select
              value={document.typeContrat}
              onChange={(e) =>
                handleDocumentChange(index, 'typeContrat', e.target.value)
              }
            >
              <option value="">Sélectionnez un type de contrat</option>
              {getFilteredContractTypes(index).map((type) => (
                <option key={type.value} value={type.value}>
                  {type.label}
                </option>
              ))}
            </select>
          </div>
          <div>
            <label>Fichier</label>
            <input
              type="file"
              onChange={(e) =>
                handleDocumentChange(index, 'file', e.target.files ? e.target.files[0] : null)
              }
            />
          </div>
        </div>
      ))}

      <button className="ajoutdoc" onClick={addDocument}>
        Ajouter Document
      </button>

      <ul>
        {formData.documents.map((doc, index) => (
          <li key={index}>
            {doc.typeContrat} - {doc.file?.name}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Step3;
