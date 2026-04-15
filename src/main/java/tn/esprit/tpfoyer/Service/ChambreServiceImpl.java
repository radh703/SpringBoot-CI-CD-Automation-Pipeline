package tn.esprit.tpfoyer.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.Repository.ChambreRepository;
import tn.esprit.tpfoyer.entities.Chambre;
import tn.esprit.tpfoyer.entities.TypeChambre;

import java.util.List;
@Service
@AllArgsConstructor
public class ChambreServiceImpl implements  IChambreService {
  ChambreRepository chambrerepository;


  public List<Chambre> retiveAllChambres() {
    return chambrerepository.findAll();
  }


  public Chambre retriveChambre(Long idChambre) {
    return chambrerepository.findById(idChambre).get();
  }


  public Chambre addChambre(Chambre c) {
    return chambrerepository.save(c);
  }

  @Override
  public void removeChambre(Long idChambre) {
    chambrerepository.deleteById(idChambre);
  }




  @Override
  public Chambre modifyChambre(Chambre chambre) {
    return chambrerepository.save(chambre);
  }





    public List<Chambre> recupererChambresSelonType (TypeChambre tc){

    return chambrerepository.findAllByTypeC(tc);
    }


}
