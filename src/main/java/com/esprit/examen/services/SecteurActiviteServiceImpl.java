package com.esprit.examen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class SecteurActiviteServiceImpl implements ISecteurActiviteService{

	@Autowired
	SecteurActiviteRepository secteurActiviteRepository;
	@Override
	public List<SecteurActivite> retrieveAllSecteurActivite() {
		return (List<SecteurActivite>) secteurActiviteRepository.findAll();
	}

	@Override
	public SecteurActivite addSecteurActivite(SecteurActivite sa) {
		secteurActiviteRepository.save(sa);
		log.info("Secteur added susccefully");

		return sa;
	}

	@Override
	public void deleteSecteurActivite(Long id) {
		secteurActiviteRepository.deleteById(id);
		
	}

	@Override
	public SecteurActivite updateSecteurActivite(SecteurActivite sa) {
		secteurActiviteRepository.save(sa);
		log.info("Secteur updated susccefully");

		return sa;
	}

	@Override
	public SecteurActivite retrieveSecteurActivite(Long id) {
		SecteurActivite secteurActivite = secteurActiviteRepository.findById(id).orElse(null);
		return secteurActivite;
	}

}
