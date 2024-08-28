package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.AssuranceAutomobile;
import com.sahar.supportticketback.repositories.AssuranceAutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssuranceAutoService  implements IAssuranceAutoService {

    @Autowired
    private AssuranceAutoRepository assuranceAutoRepository;

    @Override
    public void ajouterAssuranceAuto(AssuranceAutomobile assuranceAutomobile) {
        assuranceAutoRepository.save(assuranceAutomobile);

    }

    @Override
    public void supprimerAssuranceAuto(AssuranceAutomobile assuranceAutomobile) {
            assuranceAutoRepository.delete(assuranceAutomobile);
    }

    @Override
    public Optional<AssuranceAutomobile> getAssuranceAuto(Long id) {
        return assuranceAutoRepository.findById(id);
    }



    @Override
    public List<AssuranceAutomobile> getAllAssuranceAuto() {
        List <AssuranceAutomobile> l= assuranceAutoRepository.findAll();
        return l;
    }
}
