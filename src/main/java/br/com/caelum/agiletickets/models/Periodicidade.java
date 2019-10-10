package br.com.caelum.agiletickets.models;

import br.com.caelum.agiletickets.domain.precos.CalculadorDePreco;
import br.com.caelum.agiletickets.domain.precos.CalculadorDePrecoBallet;
import br.com.caelum.agiletickets.domain.precos.CalculadorDePrecoCinema;
import br.com.caelum.agiletickets.domain.precos.CalculadorDePrecoOrquestra;
import br.com.caelum.agiletickets.domain.precos.CalculadorDePrecoShow;
import br.com.caelum.agiletickets.domain.precos.CalculadorDePrecoTeatro;

public enum Periodicidade {
	
	DIARIA(new CalculaPeriodicidadeDiaria()), 
	SEMANAL(new CalculaPeriodicidadeSemanal());
	
	
	private final CalculaPeriodicidadeSessao calculaPeriodicidadeSessao;
	
	private Periodicidade(CalculaPeriodicidadeSessao calculaPeriodicidadeSessao) {
		this.calculaPeriodicidadeSessao = calculaPeriodicidadeSessao;
	}
	
	public CalculaPeriodicidadeSessao getCalculaPeriodicidadeSessao() {
		return this.calculaPeriodicidadeSessao;
	}
}
