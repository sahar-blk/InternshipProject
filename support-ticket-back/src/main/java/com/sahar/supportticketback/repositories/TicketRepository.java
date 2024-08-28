package com.sahar.supportticketback.repositories;

import com.sahar.supportticketback.entities.Ticket;
import com.sahar.supportticketback.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {
    //chercher un ticket par son etat
    List<Ticket> findByEtat(String etat);
    //chercher la liste des tickets par agent
    List<Ticket> findByAssignedTo(Worker worker);
    List  <Ticket> findByPriorite(String priorite);


}

