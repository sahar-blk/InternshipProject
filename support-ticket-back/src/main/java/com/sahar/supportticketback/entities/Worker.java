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

    public Worker(){

    }



}
