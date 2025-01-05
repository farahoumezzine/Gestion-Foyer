package tn.esprim.tpFoyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprim.tpFoyer.entity.*;
import tn.esprim.tpFoyer.repository.BlocRepository;
import tn.esprim.tpFoyer.repository.EtudiantRepository;
import tn.esprim.tpFoyer.repository.ReservationRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service

public class ReservationServiceImpl implements IReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    private BlocRepository blocRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    public List<Reservation> retrieveAllReservations(){

        return reservationRepository.findAll();
    }
    public Reservation updateReservation(Reservation res){

        return reservationRepository.save(res);
    }
    public Reservation retrieveReservation(String idReservation){

        return reservationRepository.findById(Long.valueOf(idReservation)).get();
    }
    @Override
    public Reservation ajouterReservation(long idBloc, long cinEtudiant) {
        // 1. Retrieve the student and bloc
        Etudiant etudiant = etudiantRepository.findById(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Etudiant not found with CIN: " + cinEtudiant));

        Bloc bloc = blocRepository.findById(idBloc)
                .orElseThrow(() -> new RuntimeException("Bloc not found with ID: " + idBloc));

        // 2. Find an available room in the bloc
        Set<Chambre> chambres = bloc.getChambres();

        Chambre availableChambre = null;

        for (Chambre chambre : chambres) {
            int maxCapacity = getMaxCapacityByType(chambre.getTypeC());
            int currentOccupancy = chambre.getReservations().size();

            if (currentOccupancy < maxCapacity) {
                availableChambre = chambre;
                break;
            }
        }

        if (availableChambre == null) {
            throw new RuntimeException("No available rooms in this bloc");
        }

        // 3. Create the reservation with the required format
        Reservation reservation = new Reservation();
        String numReservation = String.format("%d-%s-%d",
                availableChambre.getNumeroChambre(),
                bloc.getNomBloc(),
                LocalDate.now().getYear());

        reservation.setIdReservation(Long.valueOf(numReservation));
        reservation.setEstValide(true);
        reservation.setAnneeUniversitaire(new Date());

        // 4. Add the student to the reservation
        Set<Etudiant> etudiants = new HashSet<>();
        etudiants.add(etudiant);
        reservation.setEtudiants(etudiants);

        // 5. Add the reservation to the room
        availableChambre.getReservations().add(reservation);

        // 6. Save everything
        return reservationRepository.save(reservation);
    }

    private int getMaxCapacityByType(TypeChambre type) {
        switch (type) {
            case SIMPLE:
                return 1;
            case DOUBLE:
                return 2;
            case TRIPLE:
                return 3;
            default:
                return 0;
        }
    }

    public Reservation annulerReservation(long cinEtudiant){
        // 1. Find the student by CIN
        Etudiant etudiant = etudiantRepository.findById(cinEtudiant)
                .orElseThrow(() -> new RuntimeException("Etudiant not found with CIN: " + cinEtudiant));

        // 2. Get the student's valid reservation
        Reservation reservation = etudiant.getReservations().stream()
                .filter(r -> r.isEstValide())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No valid reservation found for student with CIN: " + cinEtudiant));

        // 3. Set reservation status to invalid
        reservation.setEstValide(false);

        // 4. Remove student from reservation
        reservation.getEtudiants().remove(etudiant);
        etudiant.getReservations().remove(reservation);

        // 5. Save the changes
        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return reservationRepository.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire, nomUniversite);
    }

}
