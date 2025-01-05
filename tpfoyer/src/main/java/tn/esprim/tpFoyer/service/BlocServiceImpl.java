package tn.esprim.tpFoyer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import tn.esprim.tpFoyer.entity.Bloc;
import tn.esprim.tpFoyer.entity.Chambre;
import tn.esprim.tpFoyer.repository.BlocRepository;
import tn.esprim.tpFoyer.repository.ChambreRepository;

import java.util.List;

@Service
@Slf4j

public class BlocServiceImpl implements IBlocService{

    @Autowired
    private BlocRepository blocRepository;
    @Autowired
    private ChambreRepository chambreRepository;

    public List<Bloc> retrieveAllBlocs() {

        return blocRepository.findAll();
    }
    public Bloc retrieveBloc(Long idBloc) {

        return blocRepository.findById(idBloc).get();
    }
    public Bloc addBloc(Bloc b) {
        return blocRepository.save(b);
    }
    public void removeBloc(Long idBloc) {

        blocRepository.deleteById(idBloc);
    }
    public Bloc updateBloc(Bloc b) {

        return blocRepository.save(b);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) {
        //recuperer id du bloc
        Bloc bloc = blocRepository.findById(idBloc).orElseThrow(()-> new RuntimeException("Bloc not found"));
        //recuperer les chambres  par numero
        List<Chambre> chambres = chambreRepository.findAllByNumeroChambre(numChambre);
        if (chambres.size() != numChambre.size()) {
            throw new RuntimeException("Les chambres ne correspondent pas au nombre de chambres fournis");
        }

        //verifier que les chambres ne sont pas déjà affectées à un autre bloc
        for (Chambre chambre : chambres){
            if (chambre.getBloc() !=null && chambre.getBloc().getIdBloc() !=idBloc){
                throw new RuntimeException("Chambre déjà affectée à un autre bloc");
            }
        }


        for (Chambre chambre : chambres){
            chambre.setBloc(bloc);
        }

        chambreRepository.saveAll(chambres);
        return bloc;
    }



}
