package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class AbasPage extends BasePage {
	
	public String obterMensagem() {
		return obterTexto(By.xpath("//android.view.ViewGroup//android.widget.TextView"));
	}
	
	public void clicarAba1() {
		clicarPorTexto("Aba 1");
	}
	
	public void clicarAba2() {
		clicarPorTexto("Aba 2");
	}
}