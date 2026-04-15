package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Repository.EtudiantRepository;
import tn.esprit.tpfoyer.entities.Etudiant;

import java.util.List;
@Service
@AllArgsConstructor
public class EtudiantServiceImpl implements IEtudiantService{
  EtudiantRepository etudiantrepository;

  public List<Etudiant> retiveAlletudiants() {
    return etudiantrepository.findAll();
  }


  public Etudiant retriveetudiant(Long idEtudiant) {
    return etudiantrepository.findById(idEtudiant).get();
  }


  public Etudiant addetudiant(Etudiant e) {
    return etudiantrepository.save(e);
  }


  public void removeetudiant(Long idEtudiant) {
    etudiantrepository.deleteById(idEtudiant);
  }

  @Override
  public Etudiant modifyetudiant(Etudiant etudiant) {
    return etudiantrepository.save(etudiant);
  }
}
