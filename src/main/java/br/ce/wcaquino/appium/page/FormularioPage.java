package br.ce.wcaquino.appium.page;

import java.util.List;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.DSL;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage {

	private DSL dsl = new DSL();
	
	public void escreverNome(String nome) {
		dsl.escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return dsl.obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void clicarCombo() {
		dsl.clicar(By.className("android.widget.Spinner"));
	}
	
	public void selecionarCombo(String valor) {
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterValorCombo() {
		return dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarOpcaoCombo(String opcCombo) {
		dsl.clicar(By.xpath("//android.widget.CheckedTextView[@text='"+ opcCombo +"']"));
	}
	
	public void clicarCheck() {
		dsl.clicar(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		dsl.clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return dsl.isCheckMarcado(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwitchMarcado() {
		return dsl.isCheckMarcado(MobileBy.AccessibilityId("switch"));
	} 
	
	public void clicarSalvar() {
		dsl.clicar(MobileBy.AccessibilityId("save"));
	}
	
	public List<MobileElement> obterValoresLista() {
		return dsl.obterLista(By.xpath("//android.widget.TextView[@text]"));
	}
}
