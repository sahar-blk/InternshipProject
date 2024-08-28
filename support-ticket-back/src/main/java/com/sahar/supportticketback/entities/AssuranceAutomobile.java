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
@Table(name = "AssuranceAutomobile")

public class AssuranceAutomobile {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "permisDeConduire")
    private String permisDeConduire;

    @Column(name = "certificatImmatriculation")
    private String certificatImmatriculation;

    @Column(name = "justificatifAchatVehicule")
    private String justificatifAchatVehicule;

    @Column(name = "releveInformations")
    private String releveInformations;

    @Column(name = "photographiesVehicule")
    private String photographiesVehicule;

    @Column(name = "certificatNonGage")
    private String certificatNonGage;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    // Constructor
    public AssuranceAutomobile() {}
}
