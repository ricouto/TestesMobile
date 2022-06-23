package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SplashPage;


public class SplashTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage splash = new SplashPage(); 
	
	@Test
	public void deveAguardarSplahSumir() {
		
		menu.acessarSplash();
		
		splash.isTelaSplahVisivel();
		splash.aguardarSplashSumir();
		
		Assert.assertTrue(splash.existeElementoPorTexto("Formulário"));
		
	}

}
