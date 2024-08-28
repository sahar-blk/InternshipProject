package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.Ticket;
import com.sahar.supportticketback.entities.Worker;

import java.util.List;

public interface IWorkerService {
    public Worker getUserById(Long id) ;
    public List<Worker> getAllUsers();
    public Worker getWorkerByUsername(String username);



}
