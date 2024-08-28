package com.sahar.supportticketback.controllers;

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
    @GetMapping("/getWorker/{id}")
    public ResponseEntity<Worker> getWorker(@PathVariable Long id) {
        Worker worker=workerService.getUserById(id);
        return ResponseEntity.ok(worker);

    }
    @GetMapping("/getAllWorkers")
    public ResponseEntity<List<Worker>> getAllUsers() {
        List<Worker> users = workerService.getAllUsers();
        return ResponseEntity.ok(users);
    }
}
