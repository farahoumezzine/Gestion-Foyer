package tn.esprim.tpFoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprim.tpFoyer.entity.Chambre;
import tn.esprim.tpFoyer.entity.TypeChambre;

import java.util.List;

@Repository
public interface ChambreRepository  extends JpaRepository<Chambre,Long> {
    List<Chambre> findAllByNumeroChambre(List<Long> numeroChambre);

    //Methode avec JPQL

    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    public List<Chambre> getChambresParBlocEtType(@Param("idBloc") long idBloc, @Param("typeC") TypeChambre typeC);

    // Méthode avec Spring Data Keywords
    //autre methode en utilisante keywords
    List<Chambre> getChambresParBlocEtTypeC(long idBloc, TypeChambre type);

}
