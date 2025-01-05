package tn.esprim.tpFoyer.service;

import tn.esprim.tpFoyer.entity.Universite;

import java.util.List;

public interface IUniversiteService {

    public List<Universite> retrieveAllUniversites();
    public Universite retrieveUniversite(Long idUniversite);
    public Universite addUniversite(Universite u);
    public Universite updateUniversite(Universite uni);

    //service avancee

    public Universite affcterFoyerAUniversite(long idFoyer, String nomUniversite);
    public Universite desaffecterFoyerAUniversite(long idUniversite);

}
