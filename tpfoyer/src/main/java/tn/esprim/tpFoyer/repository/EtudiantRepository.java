package tn.esprim.tpFoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprim.tpFoyer.entity.Etudiant;

@Repository

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
