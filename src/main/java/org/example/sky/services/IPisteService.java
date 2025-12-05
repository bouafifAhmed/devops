package org.example.sky.services;

import org.example.sky.entities.Piste;
import java.util.List;

public interface IPisteService {
    List<Piste> retrieveAllPistes();

    Piste addPiste(Piste piste);

    Piste updatePiste(Piste piste);

    Piste retrievePiste(Long numPiste);

    void removePiste(Long numPiste);
}
