package org.example.sky.services;

import org.example.sky.entities.Moniteur;
import java.util.List;

public interface IMoniteurService {
    List<Moniteur> retrieveAllMoniteurs();

    Moniteur addMoniteur(Moniteur moniteur);

    Moniteur updateMoniteur(Moniteur moniteur);

    Moniteur retrieveMoniteur(Long numMoniteur);

    void removeMoniteur(Long numMoniteur);
}
