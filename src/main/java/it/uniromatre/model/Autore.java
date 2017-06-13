package it.uniromatre.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity

public class Autore {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private Long id;
	@Column (nullable = false)
	private String nome;
	@OneToMany (mappedBy = "autore",cascade = CascadeType.ALL)
	private List <Opera> opera;
	
	public Autore() {}
	
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

	public List<Opera> getOpera() {
		return opera;
	}

	public void setOpera(List<Opera> opera) {
		this.opera = opera;
	}
	
	public void setOpera (Opera opera){
		if (this.opera != null)
			this.opera.add(opera);
		else {
			this.opera = new ArrayList<Opera>();
			this.opera.add(opera);
		}
	}
	
}
