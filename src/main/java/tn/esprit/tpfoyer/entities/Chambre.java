package tn.esprit.tpfoyer.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long idChambre;
  private long numeroChambre;
  @Enumerated(EnumType.STRING)
  private TypeChambre typeC;





}
