package tn.esprit.tpfoyer.Control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Service.IEtudiantService;
import tn.esprit.tpfoyer.entities.Etudiant;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
  IEtudiantService etudiantService;
  // http://localhost:8089/tpfoyer/etudiant/retrieve-all-etudiants
  @GetMapping("/retrieve-all-etudiants")
  public List<Etudiant> getEtudiants() {
    List<Etudiant> listEtudiants = etudiantService.retiveAlletudiants();
    return listEtudiants;
  }
  // http://localhost:8089/tpfoyer/etudiant/retrieve-etudiant/8
  @GetMapping("/retrieve-etudiant/{etudiant-id}")
  public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long chId) {
    Etudiant etudiant = etudiantService.retriveetudiant(chId);
    return etudiant;}
  // http://localhost:8089/tpfoyer/etudiant/add-etudiant
  @PostMapping("/add-etudiant")
  public Etudiant addEtudiant(@RequestBody Etudiant e) {
      Etudiant etudiant = etudiantService.addetudiant(e);
      return etudiant;
    }
// http://localhost:8089/tpfoyer/etudiant/remove-etudiant/{etudiant-id}
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long chId) {
      etudiantService.removeetudiant(chId);
    }
// http://localhost:8089/tpfoyer/etudiant/modify-etudiant
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
      Etudiant etudiant = etudiantService.modifyetudiant(e);
      return etudiant;
    }}
