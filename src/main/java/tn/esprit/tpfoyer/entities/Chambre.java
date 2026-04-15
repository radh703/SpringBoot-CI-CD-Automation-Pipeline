package tn.esprit.tpfoyer.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Chambre {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long idChambre;

  @Positive(message = "numeroChambre must be positive")
  private long numeroChambre;

  @NotNull(message = "typeC is required")
  @Enumerated(EnumType.STRING)
  private TypeChambre typeC;





}
