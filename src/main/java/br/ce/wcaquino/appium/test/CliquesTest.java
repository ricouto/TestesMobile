package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.CliquesPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class CliquesTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquesPage cliquesPage = new CliquesPage();
	
	@Before
	public void setup() {
		menu.acessarCliques();
	}
	
	@Test
	public void deveRealizarCliqueLongo() {
		cliquesPage.cliqueLongo();
		System.out.println("retorno clique Longo : " + cliquesPage.obterTexto());
		Assert.assertEquals("Clique Longo", cliquesPage.obterTexto());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		cliquesPage.clicarPorTexto("Clique duplo");
		cliquesPage.clicarPorTexto("Clique duplo");
		System.out.println("retorno duplo clique : " + cliquesPage.obterTexto());
		Assert.assertEquals("Duplo Clique", cliquesPage.obterTexto());
	}

}
