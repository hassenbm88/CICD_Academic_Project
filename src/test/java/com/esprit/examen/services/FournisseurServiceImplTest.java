package com.esprit.examen.services;

import com.esprit.examen.entities.DetailFournisseur;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;


import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {FournisseurServiceImpl.class})
@ExtendWith(SpringExtension.class)
public class FournisseurServiceImplTest {

    @MockBean
    private DetailFournisseurRepository detailFournisseurRepository;

    @MockBean
    private FournisseurRepository fournisseurRepository;

    @Autowired
    private FournisseurServiceImpl fournisseurServiceImpl;

    @MockBean
    private ProduitRepository produitRepository;

    @MockBean
    private SecteurActiviteRepository secteurActiviteRepository;



    @Test
    void testRetrieveFournisseur() {

        DetailFournisseur detailFournisseur = new DetailFournisseur();
        detailFournisseur.setAdresse("bizerte");
        detailFournisseur.setEmail("hassen.bm@esprit.tn");
        detailFournisseur.setFournisseur(new Fournisseur());


        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setDetailFournisseur(detailFournisseur);
        fournisseur.setIdFournisseur(1L);
        Optional<Fournisseur> ofResult = Optional.of(fournisseur);
        when(fournisseurRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(fournisseur, fournisseurServiceImpl.retrieveFournisseur(1L));
        verify(fournisseurRepository).findById((Long) any());
    }

    @Test
    void testAddFournisseur() {
        DetailFournisseur detailFournisseur = new DetailFournisseur();
        detailFournisseur.setEmail("hassen.bm@esprit.tn");
        detailFournisseur.setFournisseur(new Fournisseur());


        Fournisseur fournisseur = new Fournisseur();
        fournisseur.setCode("0000");
        fournisseur.setDetailFournisseur(detailFournisseur);
        assertSame(fournisseur, fournisseurServiceImpl.addFournisseur(fournisseur));
        verify(fournisseurRepository).save((Fournisseur) any());
    }






}
