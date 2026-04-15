package tn.esprit.tpfoyer;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.tpfoyer.Repository.EtudiantRepository;
import tn.esprit.tpfoyer.Service.EtudiantServiceImpl;
import tn.esprit.tpfoyer.entities.Etudiant;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class EtudiantServiceImplTest {

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private EtudiantServiceImpl etudiantServiceImpl;

    private Etudiant etudiant;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        // Initialize the Etudiant object for testing
        etudiant = new Etudiant();
        etudiant.setNomEt("Radhwen");
        etudiant.setPrenomEt("Essefi");
        etudiant.setCin(12345678L);
        etudiant.setEcole("Esprit");
        etudiant.setDatenaissance(new Date());
    }

    @Test
    void testAddEtudiant() {
        // Arrange
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(etudiant);

        // Act
        Etudiant savedEtudiant = etudiantServiceImpl.addetudiant(etudiant);

        // Assert
        assertNotNull(savedEtudiant);
        assertEquals("Radhwen", savedEtudiant.getNomEt());
        verify(etudiantRepository, times(1)).save(any(Etudiant.class));
    }

    @Test
    void testRetrieveAllEtudiants() {
        // Arrange
        when(etudiantRepository.findAll()).thenReturn(List.of(etudiant));

        // Act
        List<Etudiant> etudiants = etudiantServiceImpl.retiveAlletudiants();

        // Assert
        assertNotNull(etudiants);
        assertFalse(etudiants.isEmpty());
        verify(etudiantRepository, times(1)).findAll();
    }

    @Test
    void testRetrieveEtudiantById() {
        // Arrange
        Long etudiantId = 1L;
        when(etudiantRepository.findById(etudiantId)).thenReturn(Optional.of(etudiant));

        // Act
        Etudiant retrievedEtudiant = etudiantServiceImpl.retriveetudiant(etudiantId);

        // Assert
        assertNotNull(retrievedEtudiant);
        assertEquals("Radhwen", retrievedEtudiant.getNomEt());
        verify(etudiantRepository, times(1)).findById(etudiantId);
    }

    @Test
    void testModifyEtudiant() {
        // Arrange
        when(etudiantRepository.save(any(Etudiant.class))).thenReturn(etudiant);

        // Act
        Etudiant updatedEtudiant = etudiantServiceImpl.modifyetudiant(etudiant);

        // Assert
        assertNotNull(updatedEtudiant);
        assertEquals("Radhwen", updatedEtudiant.getNomEt());
        verify(etudiantRepository, times(1)).save(any(Etudiant.class));
    }

    @Test
    void testRemoveEtudiant() {
        // Arrange
        doNothing().when(etudiantRepository).deleteById(anyLong());

        // Act
        etudiantServiceImpl.removeetudiant(1L);

        // Assert
        verify(etudiantRepository, times(1)).deleteById(anyLong());
    }
}
