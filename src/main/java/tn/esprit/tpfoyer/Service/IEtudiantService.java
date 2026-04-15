package tn.esprit.tpfoyer.Service;

import tn.esprit.tpfoyer.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
  public List<Etudiant> retiveAlletudiants();
  public Etudiant retriveetudiant (Long idEtudiant);
  public Etudiant  addetudiant(Etudiant e);
  public void removeetudiant(Long idEtudiant);
  public Etudiant modifyetudiant(Etudiant etudiant);


}
