import React from 'react';
import Box from '@mui/material/Box';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';
import { Button, TextField } from '@mui/material';
import './Step1.css';

interface Step1Props {
  formData: {
    nom: string;
    prenom: string;
    dateNaissance: string;
    adresse: string;
    telephone: string;
    email: string;
    profession: string;
    employeur: string;
    adressePro: string;
    telephonePro: string;
    etatCivil: string;
    nomConjoint: string;
    nombreEnfants: string;
  };
  setFormData: React.Dispatch<React.SetStateAction<any>>;
}

const Step1: React.FC<Step1Props> = ({ formData, setFormData }) => {
  return (
    <>
      <div className='stepone-container'>
        <div className="section-container">
          <h2>Informations Personnelles</h2>
          <div className="informations-personnelles">
            <div>
              <label>Nom</label>
              <input
                type="text"
                value={formData.nom}
                onChange={(e) => setFormData({ ...formData, nom: e.target.value })}
                required
              />
            </div>
            <div>
              <label>Prenom</label>
              <input
                type="text"
                value={formData.prenom}
                onChange={(e) => setFormData({ ...formData, prenom: e.target.value })}
                required
              />
            </div>
            <div>
              <label>Date de naissance</label>
              <input
                type="date"
                value={formData.dateNaissance}
                onChange={(e) => setFormData({ ...formData, dateNaissance: e.target.value })}
                required
              />
            </div>
          </div>

          <div className="informations-personnelles">
            <div>
              <label>Adresse</label>
              <input
                type="text"
                value={formData.adresse}
                onChange={(e) => setFormData({ ...formData, adresse: e.target.value })}
                required
              />
            </div>
            <div>
              <label>Numéro de téléphone</label>
              <input
                type="text"
                value={formData.telephone}
                onChange={(e) => setFormData({ ...formData, telephone: e.target.value })}
                required
              />
            </div>
            <div>
              <label>Adresse email</label>
              <input
                type="text"
                value={formData.email}
                onChange={(e) => setFormData({ ...formData, email: e.target.value })}
                required
              />
            </div>
          </div>
        </div>

        <div className="section-container">
          <h2>Informations Professionnelles</h2>
          <div className='informations-professionnelles'>
          <div>
          <label>Profession</label>
          <input
            type="text"
            value={formData.profession}
            onChange={(e) => setFormData({ ...formData, profession: e.target.value })}
            required
          />
          </div>
          <div>
          <label>Nom de l'employeur</label>
          <input
            type="text"
            value={formData.employeur}
            onChange={(e) => setFormData({ ...formData, employeur: e.target.value })}
          />
          </div>
          </div>
          <div className='informations-professionnelles'>

          <div>
          <label>Adresse professionnelle</label>
          <input
            type="text"
            value={formData.adressePro}
            onChange={(e) => setFormData({ ...formData, adressePro: e.target.value })}
          />
          </div>
          <div>
          <label>Numéro de téléphone professionnel</label>
          <input
            type="text"
            value={formData.telephonePro}
            onChange={(e) => setFormData({ ...formData, telephonePro: e.target.value })}
          />
          </div>
          </div>
        </div>

        <div className="section-container">
          <h2>Informations Familiales</h2>
          <div className='informations-familiales'>
            <div className="form-control">
              <label>État civil</label>

              <FormControl fullWidth>
                <Select
                  value={formData.etatCivil}
                  onChange={(e) => setFormData({ ...formData, etatCivil: e.target.value })}
                  sx={{
                    height: '36px', // Ajustement de la hauteur
                    '& .MuiSelect-select': {
                      padding: '8px 12px', // Ajuster le padding
                      display: 'flex',
                      alignItems: 'center',
                    },
                  }}
                >
                  <MenuItem value="Célibataire">Célibataire</MenuItem>
                  <MenuItem value="Marié(e)">Marié(e)</MenuItem>
                  <MenuItem value="Divorcé(e)">Divorcé(e)</MenuItem>
                </Select>
              </FormControl>
            </div>
            <div>
              <label>Nom du conjoint</label>
              <input
                type="text"
                value={formData.nomConjoint}
                onChange={(e) => setFormData({ ...formData, nomConjoint: e.target.value })}
              />
            </div>
            <div className="form-control">
            <label>Montant de la prime</label>
            <input
              type="number"
              value={formData.nombreEnfants}
              onChange={(e) => setFormData({ ...formData, nombreEnfants: e.target.value })}
              required
            />
          </div>






           
          </div>
        </div>
      </div>
    </>
  );
};

export default Step1;
