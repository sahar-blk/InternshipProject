package com.sahar.supportticketback.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "Ticket")

public class Ticket {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    @Column(name = "probType")
    private  String probType;

    @Column(name = "priorite")
    private  String priorite;

    @Column(name = "nomClient")
    private  String nomClient;

    @Column(name = "probleme")
    private  String probleme;

    @Column(name = "etat")
    private  String etat;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Worker assignedTo;




    //mettre par defaut l'etat du ticket en attente lors de la creation
    public Ticket(){
        this.etat = "en attente";

    }





}

