package org.example.sky.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String ville;

    // ✅ Relation OneToOne avec Abonnement
    @OneToOne(mappedBy = "skieur", cascade = CascadeType.ALL)
    private Abonnement abonnement;

    // ✅ Relation OneToMany avec Inscription
    @OneToMany(mappedBy = "skieur", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;

    // ✅ Relation ManyToMany avec Piste
    @ManyToMany
    @JoinTable(
            name = "skieur_piste",
            joinColumns = @JoinColumn(name = "skieur_id"),
            inverseJoinColumns = @JoinColumn(name = "piste_id")
    )
    private List<Piste> pistes;

    // ✅ Relation ManyToMany avec Moniteur
    @ManyToMany
    @JoinTable(
            name = "skieur_moniteur",
            joinColumns = @JoinColumn(name = "skieur_id"),
            inverseJoinColumns = @JoinColumn(name = "moniteur_id")
    )
    private List<Moniteur> moniteurs;

    // ❌ AUCUNE relation avec Cours (supprimé complètement)
}