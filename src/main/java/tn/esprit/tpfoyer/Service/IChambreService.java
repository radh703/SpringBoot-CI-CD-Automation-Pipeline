package tn.esprit.tpfoyer.Service;

import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
  List<Chambre> retrieveAllChambres();

  Chambre retrieveChambre(Long idChambre);

  Chambre addChambre(Chambre chambre);

  void removeChambre(Long idChambre);

  Chambre modifyChambre(Chambre chambre);

  List<Chambre> retrieveChambresByType(TypeChambre typeChambre);
}