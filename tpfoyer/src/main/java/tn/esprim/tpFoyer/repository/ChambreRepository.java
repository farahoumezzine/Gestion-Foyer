package tn.esprim.tpFoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprim.tpFoyer.entity.Chambre;

@Repository
public interface ChambreRepository  extends JpaRepository<Chambre,Long> {
}
