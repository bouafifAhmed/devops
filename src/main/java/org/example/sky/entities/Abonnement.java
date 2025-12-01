package org.example.sky.entities;

import org.example.sky.entities.TypeAbonnement;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numAbon;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Float prixAbon;

    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbon;

    // ✅ Relation OneToOne avec Skieur
    @OneToOne
    @JoinColumn(name = "skieur_id")
    private Skieur skieur;
}