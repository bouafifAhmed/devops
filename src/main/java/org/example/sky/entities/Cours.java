package org.example.sky.entities;

import org.example.sky.entities.Support;
import org.example.sky.entities.TypeCours;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCours;

    private int niveau;

    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;

    @Enumerated(EnumType.STRING)
    private Support support;

    private Float prix;
    private int creneau;

    // ✅ Relation ManyToOne avec Moniteur
    @ManyToOne
    @JoinColumn(name = "moniteur_id")
    private Moniteur moniteur;

    // ✅ Relation ManyToOne avec Piste
    @ManyToOne
    @JoinColumn(name = "piste_id")
    private Piste piste;

    // ✅ Relation OneToMany avec Inscription
    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;

    // ❌ AUCUNE relation avec Skieur (supprimé complètement)
}