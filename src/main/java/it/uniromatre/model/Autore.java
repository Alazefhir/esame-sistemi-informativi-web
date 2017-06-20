package it.uniromatre.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;


@Entity

public class Autore {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	@Column (nullable = false)
	private String nome;

	@Column (nullable = false)
	private String cognome;
	@Column (nullable = false)
	private String nazionalita;
	@Column (nullable = false)
	private Date dataNascita;
	@Column (nullable = false)
	private Date dataMorte;

	@OneToMany (mappedBy = "autore",cascade = {CascadeType.REMOVE,CascadeType.REFRESH,CascadeType.PERSIST})
	private List <Opera> opera;
	
	public Autore() {}
	
	public Autore(String nome, String cognome, String nazionalita, Date dataNascita, Date dataMorte){
		this.nome = nome;
		this.cognome = cognome;
		this.nazionalita = nazionalita;
		this.dataNascita = dataNascita;
		this.dataMorte = dataMorte;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Date getDataMorte() {
		return dataMorte;
	}

	public void setDataMorte(Date dataMorte) {
		this.dataMorte = dataMorte;
	}

	public List<Opera> getOpera() {
		return opera;
	}

	public void setOpera(List<Opera> opera) {
		this.opera = opera;
	}
	
	public void setOpera (Opera opera){		
		if (this.opera != null && ! this.opera.contains(opera))
			this.opera.add(opera);
		else {
			this.opera = new ArrayList<Opera>();
			this.opera.add(opera);
		}
	}
	
	@Override
	public String toString(){
		return "nome: " + this.nome + " id: " + this.id +
				"cognome: " + this.cognome + "nazionalità: " + this.nazionalita +
				"data di nascita: " + this.dataNascita + 
				"data di morte: " + this.dataMorte; 
	}
	
	public String toStringPlain(){
String opereString = new String();
		
		for(Opera operaIterabile: this.opera){
			opereString = opereString + operaIterabile.toStringPlain();
		}
		
		return "nome: " + this.nome + " id: " + this.id + 
				" cognome: " + this.cognome + " nazionalità: " + this.nazionalita +
				" data di nascita: " + this.dataNascita + 
				" data di morte: " + this.dataMorte + 
				" opere autore: " + opereString;
	}
	
	@PreRemove
	public void preremove(){
		if (opera != null)
			for(Opera operaiterabile: opera)
				operaiterabile.setAutore(null);
	}
}
