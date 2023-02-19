package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;

import org.junit.jupiter.api.Assertions;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {
	private Leilao leilao;
	private Lance lance;
	
	@Dado("um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario, BigDecimal.TEN);
	}

	@Quando("propoe ao leilao")
	public void quando_propoe_ao_leilao() {
		leilao = new Leilao("Tablet XPTO");
		leilao.propoe(lance);
	}
	@Entao("o lance eh aceito")
	public void entao_o_lance_eh_aceito() {
		Assertions.assertEquals(1, leilao.getLances().size());
		Assertions.assertEquals( BigDecimal.TEN, leilao.getLances().get(0).getValor());
		
	}

}
