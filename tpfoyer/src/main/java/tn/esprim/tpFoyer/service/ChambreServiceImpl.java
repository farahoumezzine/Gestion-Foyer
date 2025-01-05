package tn.esprim.tpFoyer.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import tn.esprim.tpFoyer.entity.Chambre;
import tn.esprim.tpFoyer.repository.ChambreRepository;

import java.util.List;

@Service
@Slf4j
public class ChambreServiceImpl implements IChambreService{

    @Autowired
    private ChambreRepository chambreRepository;

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
}
