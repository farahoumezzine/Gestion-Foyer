package tn.esprim.tpFoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprim.tpFoyer.entity.Chambre;

import java.util.List;

@Repository
public interface ChambreRepository  extends JpaRepository<Chambre,Long> {
    List<Chambre> findAllByNumeroChambre(List<Long> numeroChambre);
}
