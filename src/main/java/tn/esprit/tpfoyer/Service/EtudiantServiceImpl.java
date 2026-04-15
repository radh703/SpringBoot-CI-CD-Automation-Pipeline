package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Repository.EtudiantRepository;
import tn.esprit.tpfoyer.entities.Etudiant;
import tn.esprit.tpfoyer.exception.ResourceNotFoundException;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService{
  private final EtudiantRepository etudiantRepository;

  @Override
  public List<Etudiant> retrieveAllEtudiants() {
    return etudiantRepository.findAll();
  }


  @Override
  public Etudiant retrieveEtudiant(Long idEtudiant) {
    return etudiantRepository.findById(idEtudiant)
        .orElseThrow(() -> new ResourceNotFoundException("Etudiant not found with id: " + idEtudiant));
  }


  @Override
  public Etudiant addEtudiant(Etudiant e) {
    return etudiantRepository.save(e);
  }


  @Override
  public void removeEtudiant(Long idEtudiant) {
    etudiantRepository.deleteById(idEtudiant);
  }

  @Override
  public Etudiant modifyEtudiant(Etudiant etudiant) {
    return etudiantRepository.save(etudiant);
  }
}
