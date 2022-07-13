package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class AlertaPage extends BasePage {
	
	public void clicarAlertaConfirma() {
		clicarPorTexto("ALERTA CONFIRM");
	}
	public void clicarAlertaSimples() {
		System.out.println("cliquei AlertaSimples.....");
		clicarPorTexto("ALERTA SIMPLES");
	}
	public String obterTitulo() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	public String obterMensagem() {
		return obterTexto(By.id("android:id/message"));
	}
	public void confirmar() {
		clicarPorTexto("CONFIRMAR");
	}
	public void sair() {
		clicarPorTexto("SAIR");
	}
	public void clicarForaCaixa() {
		System.out.println("acao clicarForaCaixa ....");
		tap(100, 100);
	}
}