package com.sahar.supportticketback.repositories;

import com.sahar.supportticketback.entities.Ticket;
import com.sahar.supportticketback.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {
    //chercher un agent par son nom
    Worker findByUsername(String username);

}

