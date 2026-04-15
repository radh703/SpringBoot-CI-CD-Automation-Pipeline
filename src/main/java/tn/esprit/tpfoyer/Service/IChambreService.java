package tn.esprit.tpfoyer.Service;

import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;

import java.util.List;

public interface IChambreService {
  public List<Chambre> retiveAllChambres();

  public Chambre retriveChambre(Long idChambre);

  public Chambre addChambre(Chambre c);

  public void removeChambre(Long idChambre);

  public Chambre modifyChambre(Chambre chambre);



  public List<Chambre> recupererChambresSelonType(TypeChambre tc);
}