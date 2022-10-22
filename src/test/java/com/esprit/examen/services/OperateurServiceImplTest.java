package com.esprit.examen.services;

import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.OperateurRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperateurServiceImplTest {

    @Autowired
    private IOperateurService service;
    @MockBean
    private OperateurRepository repository;


    @Test
    public void retrieveAllOperateursTest() {
        when(repository.findAll()).thenReturn(Stream
                .of(new Operateur(1L,"aaa","ooo","1234"), new Operateur(2L,"sss","ddd","pwd")).collect(Collectors.toList()));
        assertEquals(2, service.retrieveAllOperateurs().size());
    }

    @Test
    public void updateOperateurTest() {
        Operateur operateur = new Operateur(3L,"fff","eee","pwd2");
        when(repository.save(operateur)).thenReturn(operateur);
        assertEquals(operateur,service.addOperateur(operateur));
    }

    @Test
    public void deleteOperateurTest() {
        Operateur operateur = new Operateur(3L,"fff","eee","pwd2");
        when(repository.findById(operateur.getIdOperateur())).thenReturn(Optional.of(operateur));
        service.deleteOperateur(operateur.getIdOperateur());
        verify(repository).deleteById(operateur.getIdOperateur());
    }

    @Test
    public void retrieveOperateurTest() {
        Operateur operateur = new Operateur(4L, "hhh", "ccc","www");
        repository.save(operateur);
        Operateur actualResult = service.retrieveOperateur(4L);
        assertEquals(operateur, actualResult);
    }
}