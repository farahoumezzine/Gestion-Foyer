package tn.esprim.tpFoyer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprim.tpFoyer.entity.Bloc;
import tn.esprim.tpFoyer.service.IBlocService;

import java.util.List;

@RestController
@RequestMapping("/bloc")
public class BlocRestController {
    @Autowired
    private IBlocService blocService;

    @GetMapping("/retrieve-all-chambres")
    public List<Bloc> retrieveAllBlocs() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        return listBlocs;
    }

    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long idBloc) {
        Bloc bloc = blocService.retrieveBloc(idBloc);
        return bloc;
    }

    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long idBloc) {
        blocService.removeBloc(idBloc);
    }

    @PutMapping("/update-bloc")
    public Bloc updateBloc(@RequestBody Bloc b ) {
        Bloc bloc  = blocService.updateBloc(b);
        return bloc;
    }

    //Use @RequestParam when you want to retrieve simple parameters from the URL or form data.
    //Use @RequestBody when you want to read complex objects passed in the body of the request.
    @PutMapping("/affecterChambresABloc")
    public Bloc affecterChambresABloc(@RequestParam("numChambres") List<Long> numChambres,@RequestParam("idBloc") Long idBloc){
       return blocService.affecterChambresABloc(numChambres,idBloc);
    }

}
