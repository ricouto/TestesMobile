package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AlertaPage;
import br.ce.wcaquino.appium.page.MenuPage;


public class AlertTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage alerta = new AlertaPage();
	
	@Test
	public void deveConfirmarAlerta() {
		
		menu.acessarAlerta();
		alerta.clicarAlertaConfirma();
		
		Assert.assertEquals("Info", alerta.obterTitulo());
		Assert.assertEquals("Confirma a operação?", alerta.obterMensagem());
		
		alerta.confirmar();
		
		Assert.assertEquals("Confirmado", alerta.obterMensagem());
		
		alerta.sair();
	}
}