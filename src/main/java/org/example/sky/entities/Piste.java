package org.example.sky.entities;

import org.example.sky.entities.Couleur;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;

    private String nomPiste;

    @Enumerated(EnumType.STRING)
    private Couleur couleur;

    private int longueur;
    private int pente;

    // ✅ Relation ManyToMany avec Skieur
    @ManyToMany(mappedBy = "pistes")
    private List<Skieur> skieurs;

    // ✅ Relation OneToMany avec Cours
    @OneToMany(mappedBy = "piste", cascade = CascadeType.ALL)
    private List<Cours> cours;
}