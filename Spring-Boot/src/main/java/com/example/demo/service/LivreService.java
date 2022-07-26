package com.example.demo.service;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepo;


@Service
public class LivreService {
	@Autowired
	LivreRepo livreRepository;
	
	public List<Livre> getAllLivres(){
		return livreRepository.findByOrderByTitreAsc();
	}
	public Livre getLivre(Integer id) {
		Livre newLivre=new Livre();
        Livre oldLivre=livreRepository.findById(id).get();
        BeanUtils.copyProperties(oldLivre,newLivre);
        oldLivre.setDateDernierConsultation(new Date());
        livreRepository.save(oldLivre);
        return newLivre;
	}
	
	public void newLivre(Livre livre) {
		livreRepository.save(livre);
	}
	
	public void updateLivre(Livre newlivre,Integer id) {
		Livre livre=livreRepository.findById(id).orElseThrow();
		
		livre.setTitre( newlivre.getTitre()!=null ? newlivre.getTitre() : livre.getTitre() );
		livre.setAuteur( newlivre.getAuteur()!=null ? newlivre.getAuteur() : livre.getAuteur() );
		livre.setNombrePages( newlivre.getNombrePages()!=null ? newlivre.getNombrePages() : livre.getNombrePages() );
		livre.setDisponible( newlivre.getDisponible()!=null ? newlivre.getDisponible() : livre.getDisponible() );
		livre.setDateDernierConsultation( newlivre.getDateDernierConsultation()!=null ? newlivre.getDateDernierConsultation() : livre.getDateDernierConsultation() );
		livre.setDateSortie( newlivre.getDateSortie()!=null ? newlivre.getDateSortie() : livre.getDateSortie() );
		livreRepository.save(livre); 
		
	}
	public void deleteLivre(Integer id){
		livreRepository.deleteById(id);
	}
}
