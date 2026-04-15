package tn.esprit.tpfoyer.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private long idEtudiant;
  @NotBlank(message = "nomEt is required")
  @Size(max = 100, message = "nomEt must be at most 100 characters")
  private String nomEt;

  @NotBlank(message = "prenomEt is required")
  @Size(max = 100, message = "prenomEt must be at most 100 characters")
  private String prenomEt;

  @Positive(message = "cin must be positive")
  private long cin;

  @NotBlank(message = "ecole is required")
  @Size(max = 120, message = "ecole must be at most 120 characters")
  private String ecole;

  @NotNull(message = "datenaissance is required")
  @Past(message = "datenaissance must be in the past")
  private Date datenaissance;



}
