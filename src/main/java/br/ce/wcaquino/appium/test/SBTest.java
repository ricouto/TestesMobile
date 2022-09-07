package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBContasPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBLoginPage;

public class SBTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SBLoginPage login = new SBLoginPage();
	private SBContasPage contas = new SBContasPage();

	@Before
	public void setup() {
		menu.acessarSeuBNativo();
		login.setEmail("testeappium@uol.com");
		login.setSenha("1");
		login.entrar();
	}
	
	@Test
	public void inserirConta() {
		contas.clicarAbaContas();
		contas.setConta("Conta Aut Massa de Teste");
		contas.salvar();
		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
	
	
}
