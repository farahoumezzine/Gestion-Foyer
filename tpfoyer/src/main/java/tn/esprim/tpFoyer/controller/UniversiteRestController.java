package tn.esprim.tpFoyer.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprim.tpFoyer.entity.Universite;
import tn.esprim.tpFoyer.service.IUniversiteService;

import java.util.List;

@RestController
@RequestMapping("/universite")
//@AllArgsConstructor
public class UniversiteRestController {
    @Autowired
    private IUniversiteService universiteService;

    @GetMapping("/retrieveUniversite")
    public List<Universite> retrieveAllUniversites() {
        return universiteService.retrieveAllUniversites();
    }

    @GetMapping("/retrieveUniversite/{idUniversite}")
    public Universite retrieveUniversiteById(@PathVariable Long idUniversite) {
        return universiteService.retrieveUniversite(idUniversite);
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite u) {
        return universiteService.addUniversite(u);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite uni) {
        return universiteService.updateUniversite(uni);
    }

    @PostMapping("/affecter-foyer/{idFoyer}/{nomUniversite}")
    public Universite affcterFoyerAUniversite(@PathVariable("idFoyer") long idFoyer,@PathVariable("nomUniversite") String nomUniversite) {
        return universiteService.affcterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PostMapping("/desaffecter-foyer/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable("idUniversite") long idUniversite) {
        return universiteService.desaffecterFoyerAUniversite(idUniversite);
    }

}