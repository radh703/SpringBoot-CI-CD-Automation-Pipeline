package tn.esprit.tpfoyer.Control;

import lombok.AllArgsConstructor;
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
  IChambreService chambreService;
  // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
  @GetMapping("/retrieve-all-chambres")
  public List<Chambre> getChambres() {
    List<Chambre> listChambres = chambreService.retiveAllChambres();
    return listChambres;
  }
  // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
  @GetMapping("/retrieve-chambre/{chambre-id}")
  public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
    Chambre chambre = chambreService.retriveChambre(chId);
    return chambre;}
  // http://localhost:8089/tpfoyer/chambre/add-chambre
  @PostMapping("/add-chambre")
  public Chambre addChambre(@RequestBody Chambre c) {
      Chambre chambre = chambreService.addChambre(c);
      return chambre;
    }
// http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
      chambreService.removeChambre(chId);
    }
// http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
      Chambre chambre = chambreService.modifyChambre(c);
      return chambre;
    }






    @GetMapping("/retrieve-chambre-selon type/{tc}")
    public List<Chambre> trouverChSelonTC(@PathVariable("tc")TypeChambre tc)
    {
        return chambreService.recupererChambresSelonType(tc);
    }
}

