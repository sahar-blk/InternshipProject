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
@Table(name = "Client")
public class Client {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String prenom;

    @Column(name = "last_name")
    private String nom;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String telephone;

    @Column(name = "address")
    private String addresse;

    @Column(name = "birthdate")
    private String dateNaissance;

    @Column(name = "profession")
    private String profession;

    @Column(name = "employeur")
    private String employeur; // nom de l'employeur du client

    @Column(name = "adresse_pro")
    private String adressePro; // adresse client professionnel

    @Column(name = "telephone_pro")
    private String telephonePro; // num client professionnel

    @Column(name = "etat_civil")
    private String etatCivil;

    @Column(name = "nom_conjoint")
    private String nomConjoint;

    @Column(name = "nb_enfant")
    private Integer nombreEnfants;

    @Column(name = "type_contrat")
    private String typeContrat;

    @Column(name = "num_contrat")
    private Long numeroContrat;

    @Column(name = "nom_compagn")
    private String compagnieAssurance; // nom de la compagnie d'assurance

    @Column(name = "date_debut")
    private String dateDebut; // date debut de la couverture

    @Column(name = "date_fin")
    private String dateFin; // date fin de la couverture

    @Column(name = "montant_prime")
    private double montantPrime;

    @Column(name = "montant_couverture")
    private double montantCouverture;

    @Column(name = "franchise")
    private double Franchise;
    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private AssuranceVie assuranceVie;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private AssuranceSante assuranceSante;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private AssuranceProfessionnelle assuranceProfessionnelle;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private AssuranceAutomobile assuranceAutomobile;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private AssuranceHabitation assuranceHabitation;









    public Client() {

    }
}
