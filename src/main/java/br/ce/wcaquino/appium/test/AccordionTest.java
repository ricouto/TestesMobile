package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AccordionPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class AccordionTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage accordion = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() throws InterruptedException {
		menu.acessarAccordion();
		accordion.clicarOpcao1();
		Thread.sleep(2000);
		Assert.assertEquals("Esta é a descrição da opção 1", accordion.obterMensagem());
	}
}