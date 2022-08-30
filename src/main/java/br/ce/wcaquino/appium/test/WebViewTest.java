package br.ce.wcaquino.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.WebViewPage;

public class WebViewTest extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	
	@After
	public void tearDownContextoWeb() throws InterruptedException {
		Thread.sleep(3000);
		page.sairContextoWeb();
	}

	@Test
	public void deveFazerLogin() throws InterruptedException {
		menu.acessarSeuBHibrido();
		Thread.sleep(2000);
		page.entrarContextoWeb();
		page.setEmail("qualidadevia2022@gmail.com");
		page.setSenha("123456");
		page.clicarEntrar();
		Assert.assertEquals("Bem vindo, User QA!", page.getTitle());
	}
}