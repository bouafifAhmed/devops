package org.example.sky.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numInscription;

    private int numSemaine;

    // ✅ Relation ManyToOne avec Skieur
    @ManyToOne
    @JoinColumn(name = "skieur_id")
    private Skieur skieur;

    // ✅ Relation ManyToOne avec Cours
    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;
}