package tn.esprit.tpfoyer.Service;

import tn.esprit.tpfoyer.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
  List<Etudiant> retrieveAllEtudiants();
  Etudiant retrieveEtudiant(Long idEtudiant);
  Etudiant addEtudiant(Etudiant etudiant);
  void removeEtudiant(Long idEtudiant);
  Etudiant modifyEtudiant(Etudiant etudiant);
}
