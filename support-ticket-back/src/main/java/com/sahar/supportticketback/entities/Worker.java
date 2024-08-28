package com.sahar.supportticketback.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "Worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nomWorker")
    private String username;
    @Column(name = "poste")
    private String poste;
    @Column(name = "role")
    private String role;
    @Column(name = "email")
    private String email;
    @Column(name = "photoProfil")
    private String photoProfil;
    @OneToMany( cascade = CascadeType.ALL)
    private Set<Client> clients;

    public Worker(){

    }



}

