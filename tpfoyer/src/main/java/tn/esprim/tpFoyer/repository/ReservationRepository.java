package tn.esprim.tpFoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprim.tpFoyer.entity.Reservation;

@Repository

public interface ReservationRepository  extends JpaRepository<Reservation,Long> {
}
