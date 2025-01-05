package tn.esprim.tpFoyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprim.tpFoyer.entity.Foyer;
import tn.esprim.tpFoyer.service.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("/foyer")
public class FoyerRestController {


    @Autowired
    private IFoyerService FoyerService;

    @GetMapping("/all-foyers")
    public List<Foyer> retrieveAllFoyers() {
        List<Foyer> listFoyer = FoyerService.retrieveAllFoyers();
        return listFoyer;
    }

    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        Foyer foyer = FoyerService.addFoyer(f);
        return foyer;
    }

    @PutMapping("/update-foyer")
    public Foyer updateFoyer (@RequestBody Foyer f) {
        Foyer foyer = FoyerService.updateFoyer(f);
        return foyer;
    }

    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long idFoyer) {
        Foyer foyer = FoyerService.retrieveFoyer(idFoyer);
        return foyer;
    }

    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long idFoyer) {

        FoyerService.removeFoyer(idFoyer);
    }

    @PostMapping("/add/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable long idUniversite) {
        return FoyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}
