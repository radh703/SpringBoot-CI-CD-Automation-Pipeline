package tn.esprit.tpfoyer.Control;

import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Service.IEtudiantService;
import tn.esprit.tpfoyer.entities.Etudiant;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
  private final IEtudiantService etudiantService;
  // http://localhost:8089/tpfoyer/etudiant/retrieve-all-etudiants
  @GetMapping("/retrieve-all-etudiants")
  public List<Etudiant> getEtudiants() {
    return etudiantService.retrieveAllEtudiants();
  }
  // http://localhost:8089/tpfoyer/etudiant/retrieve-etudiant/8
  @GetMapping("/retrieve-etudiant/{etudiant-id}")
  public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long chId) {
    return etudiantService.retrieveEtudiant(chId);
  }
  // http://localhost:8089/tpfoyer/etudiant/add-etudiant
  @PostMapping("/add-etudiant")
  public Etudiant addEtudiant(@Valid @RequestBody Etudiant e) {
    return etudiantService.addEtudiant(e);
  }

  // http://localhost:8089/tpfoyer/etudiant/remove-etudiant/{etudiant-id}
  @DeleteMapping("/remove-etudiant/{etudiant-id}")
  public void removeEtudiant(@PathVariable("etudiant-id") Long chId) {
    etudiantService.removeEtudiant(chId);
  }

  // http://localhost:8089/tpfoyer/etudiant/modify-etudiant
  @PutMapping("/modify-etudiant")
  public Etudiant modifyEtudiant(@Valid @RequestBody Etudiant e) {
    return etudiantService.modifyEtudiant(e);
  }
}
