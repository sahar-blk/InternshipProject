package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.AssuranceProfessionnelle;

import java.util.List;
import java.util.Optional;

public interface IAssuranceProService {
    public void ajouterAssurancePro(AssuranceProfessionnelle assuranceProfessionnelle);
    public void supprimerAssurancePro(AssuranceProfessionnelle assuranceProfessionnelle);
    public Optional<AssuranceProfessionnelle> getAssurancePro(Long id);
    public List<AssuranceProfessionnelle> getAllAssurancePro();
}
