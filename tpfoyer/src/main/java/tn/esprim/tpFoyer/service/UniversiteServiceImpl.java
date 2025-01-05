package tn.esprim.tpFoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprim.tpFoyer.entity.Universite;
import tn.esprim.tpFoyer.repository.UniversiteRepository;

import java.util.List;

@Service
//@AllArgsConstructor

public class UniversiteServiceImpl implements IUniversiteService{
    @Autowired
    private UniversiteRepository universiteRepository;


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
}
