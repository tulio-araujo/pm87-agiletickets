package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class CalculaPeriodicidadeDiaria extends CriaListaSessao implements CalculaPeriodicidadeSessao {

	@Override
	public List<Sessao> criaSessoes(Espetaculo espetaculo, LocalDate inicio, LocalDate fim, LocalTime horario) {
		
		int qtdSessoes = Days.daysBetween(inicio, fim.plusDays(1)).getDays();
		return criaSessao(espetaculo, inicio, qtdSessoes, horario);
		
		
	}

	@Override
	protected DateTime somaDataSessao(DateTime dataSessao) {
		return dataSessao.plusDays(1);
	}

}
