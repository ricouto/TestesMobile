package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.core.DriverFactory;
import br.ce.wcaquino.appium.page.MenuPage;

public class OpcaoEscondida extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		System.out.println("ae ae ae");
		
		menu.scroll(0.9, 0.1);
		menu.clicarPorTexto("Opção bem escondida");
		Assert.assertEquals("Você achou essa opção", menu.obterMensagem());
		menu.clicarPorTexto("OK");
		
	}

}
