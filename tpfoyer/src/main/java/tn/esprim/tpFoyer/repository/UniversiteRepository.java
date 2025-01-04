package tn.esprim.tpFoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprim.tpFoyer.entity.Universite;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
}
