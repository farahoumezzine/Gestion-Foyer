package tn.esprim.tpFoyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprim.tpFoyer.entity.Etudiant;
import tn.esprim.tpFoyer.repository.EtudiantRepository;

import java.util.List;

@Service

public class EtudiantServiceImpl implements IEtudiantService{

    @Autowired
    EtudiantRepository etudiantRepository;

    public List<Etudiant> retrieveAllEtudiants(){
        return etudiantRepository.findAll();
    }
    public List<Etudiant> addEtudiants(List<Etudiant>etudiants){
        return etudiantRepository.saveAll(etudiants);
    }
    public Etudiant updateEtudiant(Etudiant e){
        return etudiantRepository.save(e);
    }
    public Etudiant retrieveEtudiant(Long idEtudiant){
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    public void removeEtudiant(Long idEtudiant){
        etudiantRepository.deleteById(idEtudiant);
    }

}
