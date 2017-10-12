package br.unicesumar.cor;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cor {
	
	@Id
	@Column(length=36)
	private String id;
	private String nome;
	
	
	public Cor() {
		this.id = UUID.randomUUID().toString();
	}
	
	public Cor(String nome){
		this();
		this.nome = nome;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
}
