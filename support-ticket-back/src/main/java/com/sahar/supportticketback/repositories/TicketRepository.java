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
    @Query("SELECT a FROM Ticket a WHERE a.etat= : etatTicket")
    List<Ticket> findByEtatTicket(String etatTicket);
    List<Ticket> findByAssignedTo(Worker worker);

}
