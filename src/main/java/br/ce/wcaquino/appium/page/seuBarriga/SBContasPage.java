package br.ce.wcaquino.appium.page.seuBarriga;

import org.openqa.selenium.By;
import br.ce.wcaquino.appium.core.BasePage;

public class SBContasPage extends BasePage {
	
	public void setConta(String conta) {
		escrever(By.className("android.widget.EditText"), conta);
	}
	
	public void salvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void excluir() {
		clicarPorTexto("EXCLUIR");
	}
	
	public void selecionarConta(String conta) {
		cliqueLongo(By.xpath("//*[@text='"+conta+"']"));
	}
}