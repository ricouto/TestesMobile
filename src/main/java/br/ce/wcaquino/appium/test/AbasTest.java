package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AbasPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AbasTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AbasPage abas = new AbasPage();
	
	@Test
	public void deveInteragirComAbas() throws InterruptedException {
		menu.acessarAbas();
		abas.clicarAba1();
		Assert.assertEquals("Este é o conteúdo da Aba 1", abas.obterMensagem());
		abas.clicarAba2();
		Assert.assertEquals("Este é o conteúdo da Aba 2", abas.obterMensagem());
	} 
}