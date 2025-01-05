package tn.esprim.tpFoyer.service;

import tn.esprim.tpFoyer.entity.Bloc;

import java.util.List;

public interface IBlocService {
    public List<Bloc> retrieveAllBlocs();
    public Bloc retrieveBloc(Long idBloc);
    public Bloc addBloc(Bloc b);
    public void removeBloc(Long idBloc);
    public Bloc updateBloc(Bloc b);

    //service avancee
    public Bloc affecterChambresABloc(List<Long> numChambre, long idBloc) ;
}
