package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.AlertaPage;
import br.ce.wcaquino.appium.page.MenuPage;


public class AlertTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage alerta = new AlertaPage();
	
	@Before
	public void acessarAlerta() {
		menu.acessarAlerta();
	}
	
	@Test
	public void deveConfirmarAlerta() {
		alerta.clicarAlertaConfirma();
		
		Assert.assertEquals("Info", alerta.obterTitulo());
		Assert.assertEquals("Confirma a operação?", alerta.obterMensagem());
		
		alerta.confirmar();
		
		Assert.assertEquals("Confirmado", alerta.obterMensagem());
		
		alerta.sair();
	}
	
	@Test
	public void deveClicarForaDoAlerta() throws InterruptedException {
		//Thread.sleep(500);
		alerta.clicarAlertaSimples();
		Thread.sleep(1000);
		alerta.clicarForaCaixa();
		//Thread.sleep(5000);
		System.out.println(menu.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
		Assert.assertFalse(menu.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}
}