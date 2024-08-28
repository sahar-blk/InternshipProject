package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.Ticket;
import com.sahar.supportticketback.entities.Worker;
import com.sahar.supportticketback.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService implements IWorkerService{

    @Autowired
    private WorkerRepository workerRepository;
    //chercher un agent par id
    @Override
    public Worker getUserById(Long id) {

        Optional<Worker> optionalUser = workerRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {

            System.out.println("User not found");
            return null;
        }
    }
    //liste de tous les agents
    @Override
    public List<Worker> getAllUsers() {
        return workerRepository.findAll();

    }
    //chercher un agent par son nom
    @Override
    public Worker getWorkerByUsername(String username) {
        Worker t= workerRepository.findByUsername(  username);
        return t;

    }
}
