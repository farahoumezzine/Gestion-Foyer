package tn.esprim.tpFoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprim.tpFoyer.entity.Bloc;

@Repository

public interface BlocRepository extends JpaRepository<Bloc,Long> {
}
