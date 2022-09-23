package br.ce.wcaquino.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;

public class SBResumoPage extends BasePage {
	
	public void excluirMovimentacao(String desc) {
		MobileElement el = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+desc+"']/.."));
		swipeElement(el, 0.9, 0.1);
		clicarPorTexto("Del");
	}

}
