package tn.esprim.tpFoyer.service;

import tn.esprim.tpFoyer.entity.Chambre;

import java.util.List;

public interface IChambreService {

    public List<Chambre> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre updateChambre(Chambre chambre);
    public List<Chambre> getChambresParNomUniversite(String nomUniversite);

}
