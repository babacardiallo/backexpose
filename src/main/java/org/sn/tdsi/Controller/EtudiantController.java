package org.sn.tdsi.Controller;

import org.sn.tdsi.entiites.Etudiant;
import org.sn.tdsi.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping("/getAll")
    public List<Etudiant> GetAll(){
        return  etudiantService.getAllEtudiant();
    }

    @PostMapping("/save")
    public Etudiant Add(@RequestBody Etudiant etudiant) {
        return etudiantService.saveEtudiant(etudiant);
    }

    @PostMapping("/delete")
    public void Delete(@RequestBody Etudiant etudiant){
        etudiantService.deleteEtudiant(etudiant);
    }

    @PostMapping("/update")
    public Etudiant Update(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }

}
