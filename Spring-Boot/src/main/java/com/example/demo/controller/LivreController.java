package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Livre;
import com.example.demo.repos.LivreRepo;
import com.example.demo.service.LivreService;

import lombok.AllArgsConstructor;

@RestController @RequestMapping("/emsi_api")
public class LivreController {
	@Autowired
	LivreService livreSevice;
	
	@GetMapping("/livres")
	public List<Livre> getAllLivres(){
		return livreSevice.getAllLivres();
	}
	
	@GetMapping("/livre/{id}")
	public Livre getLivres(@PathVariable("id") Integer id){
		return livreSevice.getLivre(id);
	}
	@PostMapping("/create")
	public void newLivre(@RequestBody Livre livre) {
		livreSevice.newLivre(livre);
	}
	
	@PutMapping("/update/{id}")
	public void updateLivre(@RequestBody Livre livre,@PathVariable("id") Integer id) {
		livreSevice.updateLivre(livre,id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLivre(@PathVariable("id") Integer id) {
		livreSevice.deleteLivre(id);
	}
	
	
	

}
