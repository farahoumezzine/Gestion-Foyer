package tn.esprim.tpFoyer.service;

import tn.esprim.tpFoyer.entity.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation updateReservation(Reservation res);
    public Reservation retrieveReservation(String idReservation);
    public Reservation ajouterReservation (long idBloc, long cinEtudiant) ;
    public Reservation annulerReservation(long cinEtudiant);

    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite);
}
