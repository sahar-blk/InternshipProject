package com.sahar.supportticketback.services;

import com.sahar.supportticketback.entities.Ticket;
import com.sahar.supportticketback.entities.Worker;
import com.sahar.supportticketback.repositories.TicketRepository;
import com.sahar.supportticketback.repositories.WorkerRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements ITicketService{

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private JavaMailSender mailSender;


    @Override
    public void ajouterTicket(Ticket ticket) {
        ticket.setEtat("en attente");
        ticketRepository.save(ticket);


    }
    //chercher ticket par id
    @Override
    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }
    @Override
    public void supprimerTicket(Ticket ticket) {
        ticketRepository.delete(ticket);

    }

    @Override
    public void modifierTicket(Ticket ticket) {
        ticketRepository.save(ticket);


    }
    //liste de tous les tickets
    @Override
    public List<Ticket> getTickets() {
        List<Ticket> t= ticketRepository.findAll();
        return t;
    }
    //liste de tous les tickets par etat
    @Override
    public List<Ticket> getTicketsByEtat(String etat) {
        List<Ticket> t= ticketRepository.findByEtat(etat);

        return t;
    }
    //assigner un ticket a un agent
    @Override
    public void assignWorkerToTicket(Long ticketId, Long workerId) {
        // Fetch the ticket and worker from the repository
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(() -> new RuntimeException("Ticket not found"));
        Worker worker = workerRepository.findById(workerId).orElseThrow(() -> new RuntimeException("Worker not found"));

        //assigner un agent a un ticket et modifier l'etat du ticket
        ticket.setAssignedTo(worker);
      //  ticket.setEtat("En cours");
        ticketRepository.save(ticket);

        //Preparer la notification par email
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            String mailSubject = "New Ticket Assigned to You";
            String mailContent = "<p>Dear " + worker.getUsername() + ",</p>";
            mailContent += "<p>You have been assigned a new ticket with ID: " + ticketId + ".</p>";
            mailContent += "<p>Ticket Status: En cours</p>";
            mailContent += "<hr><img src='cid:logo'/>";

            helper.setTo(worker.getEmail());
            helper.setSubject(mailSubject);
            helper.setText(mailContent, true);



            // envoie email
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace(); // Handle exception properly
        }
    }

    @Override
    public void changeStateTicket(Ticket ticket) {
        if (ticket.getEtat().equals("en cours")) {
            ticket.setEtat("terminé");
            ticketRepository.save(ticket);
        }
    }
    //filter les tickets par priorite
    @Override
    public List<Ticket> getTicketByPriority(String priorite) {
        return ticketRepository.findByPriorite(priorite);
    }
    //changer l'etat du ticket lors du drag and drop
    @Override
    public void updateTicketStatus(Long id, String newEtat) throws Exception {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new Exception("Ticket not found"));
        ticket.setEtat(newEtat);
        ticketRepository.save(ticket);
    }



}




