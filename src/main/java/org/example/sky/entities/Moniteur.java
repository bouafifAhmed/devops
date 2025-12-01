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
public class Moniteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numMoniteur;

    private String nomM;
    private String prenomM;
    private LocalDate dateRecru;

    // ✅ Relation OneToMany avec Cours
    @OneToMany(mappedBy = "moniteur", cascade = CascadeType.ALL)
    private List<Cours> cours;

    // ✅ Relation ManyToMany avec Skieur
    @ManyToMany(mappedBy = "moniteurs")
    private List<Skieur> skieurs;
}