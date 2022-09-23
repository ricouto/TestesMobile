package br.ce.wcaquino.appium.page.seuBarriga;

import br.ce.wcaquino.appium.core.BasePage;

public class SBMenuPage extends BasePage {
	
	public void clicarAbaContas() {
		clicarPorTexto("CONTAS");
	}
	
	public void clicarMovimentacao() {
		clicarPorTexto("MOV...");
	}
	
	public void clicarResumo() {
		clicarPorTexto("Resumo");
	}
	
	public void clicarHome() {
		clicarPorTexto("Home");
	}
}