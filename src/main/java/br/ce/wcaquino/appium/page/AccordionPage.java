package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class AccordionPage extends BasePage {
	
	public void clicarOpcao1() {
		clicarPorTexto("Opção 1");
	}
	
	public String obterMensagem() {
		return obterTexto(By.xpath("//*[@text='Opção 1']/../../following-sibling::android.view.ViewGroup/android.widget.TextView"));
		//return obterTexto(By.xpath("//*[@text='Esta é a descrição da opção 1']"));
	}

}