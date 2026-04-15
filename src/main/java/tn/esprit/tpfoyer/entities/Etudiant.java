package tn.esprit.tpfoyer.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long idEtudiant;
  private String nomEt;
  private String prenomEt;
  private long cin;
  private String ecole;
  private Date datenaissance;



}
