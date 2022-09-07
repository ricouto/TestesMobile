package br.ce.wcaquino.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class SBContasPage extends BasePage {
	
	public void clicarAbaContas() {
		clicarPorTexto("CONTAS");
	}
	
	public void setConta(String conta) {
		escrever(By.className("android.widget.EditText"), conta);
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
}
