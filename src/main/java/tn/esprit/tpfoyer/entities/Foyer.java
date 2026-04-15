package tn.esprit.tpfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFoyer;

    @NotBlank(message = "nomFoyer is required")
    @Size(max = 120, message = "nomFoyer must be at most 120 characters")
    String nomFoyer;

    @Positive(message = "capaciteFoyer must be positive")
    long capaciteFoyer;


}
