package tn.esprim.tpFoyer.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import tn.esprim.tpFoyer.entity.*;
import tn.esprim.tpFoyer.repository.ChambreRepository;
import tn.esprim.tpFoyer.repository.UniversiteRepository;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;

@Service
@Slf4j
public class ChambreServiceImpl implements IChambreService{

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private UniversiteRepository universiteRepository;

    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }
    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }
    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        // 1. Find the university by name
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite)
                .orElseThrow(() -> new RuntimeException("University not found with name: " + nomUniversite));

        // 2. Get the foyer associated with the university
        Foyer foyer = universite.getFoyer();
        if (foyer == null) {
            return new ArrayList<>(); // Return empty list if university has no foyer
        }

        // 3. Get all blocs from the foyer
        Set<Bloc> blocs = foyer.getBlocs();
        
        // 4. Collect all chambers from all blocs
        List<Chambre> chambres = new ArrayList<>();
        for (Bloc bloc : blocs) {
            chambres.addAll(bloc.getChambres());
        }

        return chambres;
    }

    public List<Chambre> findChambresParBlocEtType(long idBloc, TypeChambre typeC) {
        // Utilisation de JPQL
        List<Chambre> chambresJPQL = chambreRepository.getChambresParBlocEtType(idBloc, typeC);

        // Utilisation Keywords
        //List<Chambre> chambresKeywords = chambreRepository.getChambresParBlocEtTypeC(idBloc, typeC);


        return chambresJPQL;
    }
}
