package tn.esprim.tpFoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprim.tpFoyer.entity.Reservation;

import java.util.Date;
import java.util.List;

@Repository

public interface ReservationRepository  extends JpaRepository<Reservation,Long> {
    @Query("SELECT r FROM Chambre c " +
            "JOIN c.reservations r " +
            "JOIN c.bloc b " +
            "JOIN b.foyer f " +
            "JOIN f.universite u " +
            "WHERE r.anneeUniversitaire = :anneeUniversite " +
            "AND u.nomUniversite = :nomUniversite")
    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite( @Param("anneeUniversite") Date anneeUniversitaire,
                                                               @Param("nomUniversite") String nomUniversite);
}
