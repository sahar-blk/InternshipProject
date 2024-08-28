package com.sahar.supportticketback.services;

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
    @Override
    public Worker getUserById(Long id) {

        Optional<Worker> optionalUser = workerRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            // Handle the case where the user is not found
            System.out.println("User not found");
            return null; // or handle appropriately
        }
    }

    @Override
    public List<Worker> getAllUsers() {
        return workerRepository.findAll();

    }
}
