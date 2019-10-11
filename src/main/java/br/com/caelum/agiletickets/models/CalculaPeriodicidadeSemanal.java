package br.com.caelum.agiletickets.models;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.Weeks;

public class CalculaPeriodicidadeSemanal extends CriaListaSessao implements CalculaPeriodicidadeSessao {

	@Override
	public List<Sessao> criaSessoes(Espetaculo espetaculo, LocalDate inicio, LocalDate fim, LocalTime horario) {
		
		int qtdSessoes = Weeks.weeksBetween(inicio, fim.plusWeeks(1)).getWeeks();
		return criaSessao(espetaculo, inicio, qtdSessoes, horario);
		
	}

	@Override
	protected DateTime somaDataSessao(DateTime dataSessao) {
		return dataSessao.plusWeeks(1);
	}

}
