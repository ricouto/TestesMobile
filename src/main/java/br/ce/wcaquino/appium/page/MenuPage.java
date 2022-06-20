package br.ce.wcaquino.appium.page;

import br.ce.wcaquino.appium.core.DSL;

public class MenuPage {
	
	private DSL dsl = new DSL();

	public void acessarFormulario() {
		dsl.clicarPorTexto("Formulário");
	}
}
