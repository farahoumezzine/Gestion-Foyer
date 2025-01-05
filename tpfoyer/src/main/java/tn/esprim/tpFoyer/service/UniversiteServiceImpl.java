package tn.esprim.tpFoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprim.tpFoyer.entity.Foyer;
import tn.esprim.tpFoyer.entity.Universite;
import tn.esprim.tpFoyer.repository.FoyerRepository;
import tn.esprim.tpFoyer.repository.UniversiteRepository;

import java.util.List;

@Service
//@AllArgsConstructor

public class UniversiteServiceImpl implements IUniversiteService{
    @Autowired
    private UniversiteRepository universiteRepository;

    @Autowired
    private FoyerRepository foyerRepository;

    public List<Universite> retrieveAllUniversites() {
        return universiteRepository.findAll();
    }

    public Universite retrieveUniversite(Long idUniversite){
        return universiteRepository.findById(idUniversite).orElse(null);
    }

    public Universite addUniversite(Universite u){
        return universiteRepository.save(u);
    }


    public Universite updateUniversite(Universite uni){
        return universiteRepository.save(uni);
    }
    @Override
    public Universite affcterFoyerAUniversite(long idFoyer, String nomUniversite){
        //récuperer le foyer par son id
        Foyer foyer = foyerRepository.findById(idFoyer).orElseThrow(()
                -> new RuntimeException("Foyer not found" + idFoyer));
        //.orElse(null);


        //récupérer l'université par son nom
        Universite universite = universiteRepository.findByNomUniversite(nomUniversite).orElseThrow(()
                -> new RuntimeException("Universite not found" + nomUniversite));
        //.orElse(null);

        //verifier l'association entre foyer et l'universite
        if (foyer.getUniversite() != null || universite.getFoyer() != null) {
            throw new RuntimeException("Foyer déja associé à une université et vice versa");
        }

        //lier le foyer à l'université
        universite.setFoyer(foyer);
        foyer.setUniversite(universite);

        //sauvegarder les modifications
        universiteRepository.save(universite);
        foyerRepository.save(foyer);

        return universite;
    }

    @Override
    public Universite desaffecterFoyerAUniversite(long idUniversite) {
        //récupérer l'université par son id
        Universite universite = universiteRepository.findById(idUniversite).orElseThrow(()
                -> new RuntimeException("Universite not found" + idUniversite));
        //.orElse(null);

        //verifier l'association entre foyer et l'universite
        if (universite.getFoyer() == null) {
            throw new RuntimeException("Foyer déjà désaffecté de cette université");
        }

        //déslier le foyer de l'université
        //déslier le foyer de l'université
        Foyer foyer = universite.getFoyer();
        universite.setFoyer(null);
        foyer.setUniversite(null);

        //sauvegarder les modifications
        foyerRepository.save(foyer);
        universiteRepository.save(universite);

        return universite;


    }

    }
