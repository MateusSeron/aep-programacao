package br.unicesumar.carro;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {
	
	@Id
	@Column(nullable=false)
	private String placa;
	private int ano;
	private String modelo;
	private String cor;
	
	public Carro() {
		
	}

	public String getPlaca() {
		return placa;
	}

	public int getAno() {
		return ano;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCor() {
		return cor;
	}
	
	
}
