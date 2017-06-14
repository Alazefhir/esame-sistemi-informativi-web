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
	private String nome;

	@Column (nullable = false)
	private String descrizione;
	
	@ManyToOne (cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REFRESH})
	private Autore autore;
	
	public Opera (){}

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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
	
	@Override
	public String toString(){
		
		return "Nome: " + this.nome + " Descrizione: " + this.descrizione + " id: " + this.id + " autore: " + 
				 this.autore.toStringPlain();
	}

	public String toStringPlain() {
		
		return "Nome: " + this.nome + " Descrizione: " + this.descrizione + " id: " + this.id ;
	}
	
	@PreRemove
	public void preremove(){
		
		this.autore.getOpera().remove(this);
		
	}
}
