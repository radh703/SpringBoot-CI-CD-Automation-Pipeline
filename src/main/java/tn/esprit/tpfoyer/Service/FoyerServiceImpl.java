package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Repository.FoyerRepository;

import tn.esprit.tpfoyer.entities.Foyer;
import tn.esprit.tpfoyer.exception.ResourceNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements  IFoyerService {
  private final FoyerRepository foyerRepository;


  @Override
  public List<Foyer> retrieveAllFoyers() {
    return foyerRepository.findAll();
  }


  @Override
  public Foyer retrieveFoyer(Long idFoyer) {
    return foyerRepository.findById(idFoyer)
        .orElseThrow(() -> new ResourceNotFoundException("Foyer not found with id: " + idFoyer));
  }

  @Override
  public Foyer addFoyer(Foyer f) {
    return foyerRepository.save(f);
  }


  @Override
  public void removeFoyer(Long idFoyer) {
    foyerRepository.deleteById(idFoyer);

  }


  @Override
  public Foyer modifyFoyer(Foyer foyer) {
    return foyerRepository.save(foyer);
  }


}
