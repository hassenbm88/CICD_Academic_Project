package com.esprit.examen.services;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;

import java.util.HashSet;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CategorieProduitServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CategorieProduitServiceImplTest {
    @MockBean
    private CategorieProduitRepository categorieProduitRepository;

    @Autowired
    private CategorieProduitServiceImpl categorieProduitServiceImpl;

    /**
     * Method under test: {@link CategorieProduitServiceImpl#addCategorieProduit(CategorieProduit)}
     */
    @Test
    void testAddCategorieProduit() {
        CategorieProduit categorieProduit = new CategorieProduit();
        categorieProduit.setCodeCategorie("Code Categorie");
        categorieProduit.setIdCategorieProduit(1L);
        categorieProduit.setLibelleCategorie("Libelle Categorie");
        categorieProduit.setProduits(new HashSet<>());
        when(categorieProduitRepository.save((CategorieProduit) any())).thenReturn(categorieProduit);

        CategorieProduit categorieProduit1 = new CategorieProduit();
        categorieProduit1.setCodeCategorie("Code Categorie");
        categorieProduit1.setIdCategorieProduit(1L);
        categorieProduit1.setLibelleCategorie("Libelle Categorie");
        categorieProduit1.setProduits(new HashSet<>());
        assertSame(categorieProduit1, categorieProduitServiceImpl.addCategorieProduit(categorieProduit1));
        verify(categorieProduitRepository).save((CategorieProduit) any());
    }
}

