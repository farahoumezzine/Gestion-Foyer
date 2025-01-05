package tn.esprim.tpFoyer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprim.tpFoyer.entity.Bloc;
import tn.esprim.tpFoyer.entity.Foyer;
import tn.esprim.tpFoyer.entity.Universite;
import tn.esprim.tpFoyer.repository.BlocRepository;
import tn.esprim.tpFoyer.repository.FoyerRepository;
import tn.esprim.tpFoyer.repository.UniversiteRepository;

import java.util.List;

@Service
@Slf4j
public class FoyerServiceImpl implements IFoyerService{

    @Autowired
    FoyerRepository foyerRepository;

    @Autowired
    UniversiteRepository universiteRepository;

    @Autowired
    BlocRepository blocRepository;

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer).get();
    }

    @Override
    public void removeFoyer(long idFoyer) {
        foyerRepository.deleteById(idFoyer);

    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite){

        // récuperer l'université par son id
        Universite universite = universiteRepository.findById(idUniversite).orElseThrow(()
                -> new RuntimeException("Université not found" + idUniversite));

        // affecter l'université au foyer
        foyer.setUniversite(universite);
        if (foyer.getBlocs() != null){
            for (Bloc bloc : foyer.getBlocs()) {
                bloc.setFoyer(foyer);
            }
        }
        //sauvegarder le foyer avec ses blocs associes
        Foyer savedFoyer = foyerRepository.save(foyer);

        // associer le foyer a l'université
        universite.setFoyer(savedFoyer);
        universiteRepository.save(universite);

        return savedFoyer;

    }

}
