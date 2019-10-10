package br.com.caelum.agiletickets.domain.precos;

import java.math.BigDecimal;

import br.com.caelum.agiletickets.models.Sessao;
import br.com.caelum.agiletickets.models.TipoDeEspetaculo;

public class CalculadoraDePrecos {

	private static final int UMA_HORA_MIN = 60;
	private static final double PERCENTUAL_INGRESSO_50 = 0.50;
	private static final double PERCENTUAL_INGRESSSO_05 = 0.05;
	private static final BigDecimal PERCENTUAL_DESCONTO_20 = BigDecimal.valueOf(0.20);
	private static final BigDecimal PERCENTUAL_DESCONTO_10 = BigDecimal.valueOf(0.10);

	public static BigDecimal calcula(Sessao sessao, Integer quantidade) {
		BigDecimal preco;
	
	switch (sessao.getEspetaculo().getTipo()) {
	case CINEMA:
	case SHOW:
		preco = calculaDescontoPelaQuantidadeIngresso(sessao, PERCENTUAL_INGRESSSO_05, PERCENTUAL_DESCONTO_10);
		break;

	case BALLET:
	case ORQUESTRA:
		preco = calculaDescontoPelaQuantidadeIngresso(sessao, PERCENTUAL_INGRESSO_50, PERCENTUAL_DESCONTO_20);
		preco = calculaDescontoDuracao(sessao, preco);
		break;
	default:
		preco = sessao.getPreco();
		break;
	}
		
	/*
		if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.CINEMA) || sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.SHOW)) {
			//quando estiver acabando os ingressos... 
			if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= PERCENTUAL_INGRESSSO_05) { 
				preco = sessao.getPreco().add(sessao.getPreco().multiply(PERCENTUAL_DESCONTO_10));
			} else {
				preco = sessao.getPreco();
			}
		} else if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.BALLET)) {
			if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= PERCENTUAL_INGRESSO_50) { 
				preco = sessao.getPreco().add(sessao.getPreco().multiply(PERCENTUAL_DESCONTO_20));
			} else {
				preco = sessao.getPreco();
			}
			
			if(sessao.getDuracaoEmMinutos() > UMA_HORA_MIN){
				preco = preco.add(sessao.getPreco().multiply(PERCENTUAL_DESCONTO_10));
			}
		} else if(sessao.getEspetaculo().getTipo().equals(TipoDeEspetaculo.ORQUESTRA)) {
			if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= PERCENTUAL_INGRESSO_50) { 
				preco = sessao.getPreco().add(sessao.getPreco().multiply(PERCENTUAL_DESCONTO_20));
			} else {
				preco = sessao.getPreco();
			}

			if(sessao.getDuracaoEmMinutos() > UMA_HORA_MIN){
				preco = preco.add(sessao.getPreco().multiply(PERCENTUAL_DESCONTO_10));
			}
		}  else {
			preco = sessao.getPreco();
		} 
*/
		return preco.multiply(BigDecimal.valueOf(quantidade));
	}

	private static BigDecimal calculaDescontoDuracao(Sessao sessao, BigDecimal preco) {
		if(sessao.getDuracaoEmMinutos() > UMA_HORA_MIN){
			preco = preco.add(sessao.getPreco().multiply(PERCENTUAL_DESCONTO_10));
		}
		return preco;
	}

	private static BigDecimal calculaDescontoPelaQuantidadeIngresso(Sessao sessao, double percentualIngresso, BigDecimal percentualDesconto) {
		BigDecimal preco;
		if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= percentualIngresso) { 
			preco = sessao.getPreco().add(sessao.getPreco().multiply(percentualDesconto));
		} else {
			preco = sessao.getPreco();
		}
		return preco;
	}

}