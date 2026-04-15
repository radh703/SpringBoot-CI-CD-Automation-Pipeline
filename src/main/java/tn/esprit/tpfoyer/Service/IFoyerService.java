package tn.esprit.tpfoyer.Service;

import tn.esprit.tpfoyer.entities.Foyer;

import java.util.List;

public interface IFoyerService {
  public List<Foyer> retiveAllFoyers();
  public Foyer retriveFoyer (Long idFoyer);
  public Foyer  addFoyer(Foyer f);
  public void removeFoyer(Long idFoyer);
  public Foyer modifyFoyer(Foyer foyer);


}
