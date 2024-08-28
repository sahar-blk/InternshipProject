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
@Table(name = "AssuranceHabitation")
public class AssuranceHabitation {
    private static final long serialVersionUID =1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "JustificatifDomicile")
    private String JustificatifDomicile;

    @Column(name = "ÉtatDesLieux")
    private String ÉtatDesLieux;

    @Column(name = "ActeDePropriété")
    private String ActeDePropriété;

    @Column(name = "InventaireDesBiensAssurés")
    private String InventaireDesBiensAssurés;

    @Column(name = "ContratDeLocation")
    private String ContratDeLocation;

    @Column(name = "PhotographiesDesBiensDeValeur")
    private String PhotographiesDesBiensDeValeur;
    @OneToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public AssuranceHabitation() {

    }
}
