package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.AssuranceAutomobile;
import com.sahar.supportticketback.entities.Ticket;

import java.util.List;
import java.util.Optional;

public interface IAssuranceAutoService {
    public void ajouterAssuranceAuto(AssuranceAutomobile assuranceAutomobile);
    public void supprimerAssuranceAuto(AssuranceAutomobile assuranceAutomobile);
    public Optional<AssuranceAutomobile> getAssuranceAuto(Long id);
    public List<AssuranceAutomobile> getAllAssuranceAuto();

}
