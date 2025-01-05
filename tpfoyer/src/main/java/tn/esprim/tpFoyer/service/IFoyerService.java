package tn.esprim.tpFoyer.service;

import tn.esprim.tpFoyer.entity.Foyer;

import java.util.List;

public interface IFoyerService {
    public List<Foyer> retrieveAllFoyers();
    public Foyer addFoyer(Foyer f);
    public Foyer updateFoyer(Foyer f);
    public Foyer retrieveFoyer(Long idFoyer);
    public void removeFoyer(long idFoyer);

    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, long idUniversite);
}
