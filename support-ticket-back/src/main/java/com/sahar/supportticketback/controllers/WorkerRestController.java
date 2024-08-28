package com.sahar.supportticketback.controllers;

import com.sahar.supportticketback.entities.Ticket;
import com.sahar.supportticketback.entities.Worker;
import com.sahar.supportticketback.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/supportticket")

public class WorkerRestController {
    @Autowired
    private WorkerService workerService;
    //chercher un agent par par id
    @GetMapping("/getWorker/{id}")
    public ResponseEntity<Worker> getWorker(@PathVariable Long id) {
        Worker worker=workerService.getUserById(id);
        return ResponseEntity.ok(worker);

    }
    //liste de tous les agents
    @GetMapping("/getAllWorkers")
    public ResponseEntity<List<Worker>> getAllUsers() {
        List<Worker> users = workerService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    //chercher un agent par son nom
    @GetMapping("/GetWorkerByUsername/{username}")
    public ResponseEntity<Worker> getWorkerByUsername(@PathVariable String username) {
        Worker w=workerService.getWorkerByUsername(username);
        return ResponseEntity.ok(w);
    }

}

