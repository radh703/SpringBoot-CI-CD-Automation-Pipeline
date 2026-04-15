package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Repository.FoyerRepository;

import tn.esprit.tpfoyer.entities.Foyer;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements  IFoyerService {
  FoyerRepository foyerRepository;


  public List<Foyer> retiveAllFoyers() {
    return foyerRepository.findAll();
  }


  public Foyer retriveFoyer(Long idFoyer) {
    return foyerRepository.findById(idFoyer).get();
  }




  public Foyer addFoyer(Foyer f) {
    return foyerRepository.save(f);
  }


  public void removeFoyer(Long idFoyer) {
    foyerRepository.deleteById(idFoyer);

  }


  public Foyer modifyFoyer(Foyer foyer) {
    return foyerRepository.save(foyer);
  }


}
