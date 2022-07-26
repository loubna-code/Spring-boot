package com.example.demo.entities;

import java.util.Date;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Entity @Table(name = "ETUDIANT_CENTRE")
@Data @AllArgsConstructor @NoArgsConstructor
public class Livre {
	@Id @GeneratedValue(strategy =GenerationType.AUTO)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String titre;
	
	@Column(nullable = false,updatable = false) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String maisonEdition;
	
	@Column(nullable = false)
	private Boolean disponible;
	
	@Temporal(TemporalType.TIMESTAMP) @Column(nullable = false) @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS")
	private Date dateSortie;
	
	@Column(nullable = false) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String auteur;
	
	@Column(nullable = false)
	private Integer nombrePages;
	
	@Column(nullable = false,unique = true,updatable = false) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private long isbn;
	
	@Temporal(TemporalType.TIMESTAMP) @CreationTimestamp @Column(nullable = false)  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Date dateDernierConsultation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getMaisonEdition() {
		return maisonEdition;
	}

	public void setMaisonEdition(String maisonEdition) {
		this.maisonEdition = maisonEdition;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}

	public Date getDateSortie() {
		return dateSortie;
	}

	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Integer getNombrePages() {
		return nombrePages;
	}

	public void setNombrePages(Integer nombrePages) {
		this.nombrePages = nombrePages;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public Date getDateDernierConsultation() {
		return dateDernierConsultation;
	}

	public void setDateDernierConsultation(Date dateDernierConsultation) {
		this.dateDernierConsultation = dateDernierConsultation;
	}
	

}


