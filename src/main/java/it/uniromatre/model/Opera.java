package it.uniromatre.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PreRemove;

@Entity
public class Opera {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;

	@Column (nullable = false)
	private String titolo;
	
	@Column (nullable = false)
	private Integer anno;

	@Column (nullable = false)
	private String tecnica;
	
	@Column (nullable=false)
	private String dimensione;
	
	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Autore autore;
	
	public Opera (){}
	
	public Opera (String titolo, Integer anno, String tecnica, String dimensione, Autore autore) {
		this.titolo = titolo;
		this.anno = anno;
		this.tecnica = tecnica;
		this.dimensione = dimensione;
		this.autore = autore;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public String getDimensione() {
		return dimensione;
	}

	public void setDimensione(String dimensione) {
		this.dimensione = dimensione;
	}
	
	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
	@Override
	public String toString(){
		
		return "Titolo: " + this.titolo + " Anno: " + this.anno + "Tecnica: " + this.tecnica + "Dimensione: " + this.dimensione + "id: " + this.id + " autore: " + 
				 this.autore.toStringPlain();
	}

	public String toStringPlain() {
		
		return "Titolo: " + this.titolo + " Anno: " + this.anno + "Tecnica: " + this.tecnica + "Dimensione: " + this.dimensione + "id: " + this.id ;
	}
	
	@PreRemove
	public void preremove(){
		if (this.autore!=null)
			this.autore.getOpera().remove(this);
		
	}
}
