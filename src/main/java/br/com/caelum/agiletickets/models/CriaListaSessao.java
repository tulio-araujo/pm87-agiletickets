package br.com.caelum.agiletickets.models;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public abstract class CriaListaSessao {
	
	protected abstract DateTime somaDataSessao(DateTime dataSessao) ;
	
	protected List<Sessao> criaSessao(Espetaculo espetaculo, LocalDate inicio, int qtdSessoes, LocalTime horario){
		
		DateTime dataSessao = inicio.toDateTime(horario);
		for (int i = 0; i < qtdSessoes; i++) {
			Sessao sessao = new Sessao();
			sessao.setEspetaculo(espetaculo);
			sessao.setInicio(dataSessao);
			espetaculo.getSessoes().add(sessao);
			dataSessao = somaDataSessao(dataSessao);
		}
		
		return espetaculo.getSessoes();
	}
}
