package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PropondoLanceSteps {

	private Leilao leilao;
	private Lance lance;
	private ArrayList<Lance> lista;
	
	@Before
	public void setup() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Tablet XPTO");
	}
	
	@After
	public void tearDown() {
		System.out.println("after");
	}
	
	@Dado("um lance valido")
	public void dado_um_lance_valido() {
		Usuario usuario = new Usuario("fulano");
		lance = new Lance(usuario , BigDecimal.TEN);
	}

	@Quando("propoe ao leilao")
	public void quando_propoe_ao_leilao() {
		leilao.propoe(lance);
	}
	
	@Entao("o lance eh aceito")
	public void entao_o_lance_eh_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
	}
	
//	@Dado("varios lances validos")
//	public void varios_lances_validos() {
//		Usuario usuario = new Usuario("fulano");
//		lance10 = new Lance(usuario , BigDecimal.TEN);
//		Usuario usuario2 = new Usuario("beltrano");
//		lance15 = new Lance(usuario2 , BigDecimal.valueOf(15));
//		leilao = new Leilao("Tablet XPTO");
//	}
	
	@Dado("um lance de {double} reais do usuario {string}")
	public void um_lance_de_reais_do_usuario_fulano(Double valor, String nomeUsuario) {
		Lance lance = new Lance(new Usuario(nomeUsuario), BigDecimal.valueOf(valor));
		lista.add(lance);
	}

	@Quando("propoe varios lances ao leilao")
	public void propoe_varios_lances_ao_leilao() {
		this.lista.forEach(lance -> leilao.propoe(lance));
	}
	@Entao("os lances sao aceitos")
	public void os_lances_sao_aceitos() {
		Assert.assertEquals(lista.size(), leilao.getLances().size());
		Assert.assertEquals(lista.get(0).getValor(), leilao.getLances().get(0).getValor());
		Assert.assertEquals(lista.get(1).getValor(), leilao.getLances().get(1).getValor());
	}
}