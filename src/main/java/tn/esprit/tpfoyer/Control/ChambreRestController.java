package tn.esprit.tpfoyer.Control;

import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.Service.IChambreService;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;

import java.util.List;
//@Tag(name="gestion chambre")
@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
  private final IChambreService chambreService;
  // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
  @GetMapping("/retrieve-all-chambres")
  public List<Chambre> getChambres() {
    return chambreService.retrieveAllChambres();
  }
  // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
  @GetMapping("/retrieve-chambre/{chambre-id}")
  public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
    return chambreService.retrieveChambre(chId);
  }
  // http://localhost:8089/tpfoyer/chambre/add-chambre
  @PostMapping("/add-chambre")
  public Chambre addChambre(@Valid @RequestBody Chambre c) {
    return chambreService.addChambre(c);
  }

  // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
  @DeleteMapping("/remove-chambre/{chambre-id}")
  public void removeChambre(@PathVariable("chambre-id") Long chId) {
    chambreService.removeChambre(chId);
  }

  // http://localhost:8089/tpfoyer/chambre/modify-chambre
  @PutMapping("/modify-chambre")
  public Chambre modifyChambre(@Valid @RequestBody Chambre c) {
    return chambreService.modifyChambre(c);
  }

  // Endpoint path fixed to avoid invalid URL patterns containing spaces
  @GetMapping("/retrieve-chambre-selon-type/{tc}")
  public List<Chambre> trouverChSelonTC(@PathVariable("tc") TypeChambre tc) {
    return chambreService.retrieveChambresByType(tc);
  }
}

