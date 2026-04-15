package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Repository.ChambreRepository;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;
import tn.esprit.tpfoyer.exception.ResourceNotFoundException;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreServiceImpl implements  IChambreService {
  private final ChambreRepository chambreRepository;


  @Override
  public List<Chambre> retrieveAllChambres() {
    return chambreRepository.findAll();
  }


  @Override
  public Chambre retrieveChambre(Long idChambre) {
    return chambreRepository.findById(idChambre)
        .orElseThrow(() -> new ResourceNotFoundException("Chambre not found with id: " + idChambre));
  }


  @Override
  public Chambre addChambre(Chambre c) {
    return chambreRepository.save(c);
  }

  @Override
  public void removeChambre(Long idChambre) {
    chambreRepository.deleteById(idChambre);
  }




  @Override
  public Chambre modifyChambre(Chambre chambre) {
    return chambreRepository.save(chambre);
  }


  @Override
  public List<Chambre> retrieveChambresByType(TypeChambre tc) {
    return chambreRepository.findAllByTypeC(tc);
  }

}
