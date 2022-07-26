package br.ce.wcaquino.appium.page;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage {

	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void clicarCombo() {
		clicar(By.className("android.widget.Spinner"));
	}
	
	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarOpcaoCombo(String opcCombo) {
		clicar(By.xpath("//android.widget.CheckedTextView[@text='"+ opcCombo +"']"));
	}
	
	public void clicarCheck() {
		clicar(By.className("android.widget.CheckBox"));
	}
	
	public void clicarSwitch() {
		clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return isCheckMarcado(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch"));
	} 
	
	public void clicarSalvar() {
		clicar(MobileBy.AccessibilityId("save"));
	}
	
	public void clicarSeekBar(double posicao) {
		int delta = 3;
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		System.out.println(y);
		
		int xInicial = seek.getLocation().x + delta;
		//System.out.println("xInicial " + xInicial);
		//System.out.println(3 * delta);
		
		int x = (int) (xInicial + ((seek.getSize().width - 2 * delta ) * (posicao ) ));
		
		//System.out.println((seek.getSize().width - 3 * delta ) * posicao);
		
		//int x = (int) (xInicial + (seek.getSize().width * posicao));
		System.out.println(x);
		tap(x, y);
	}
	
	public void clicarSalvarDemorado() {
		clicar(By.xpath("//android.widget.Button/android.widget.TextView[@text='SALVAR DEMORADO']")); //android.widget.Button[@text='SALVAR DEMORADO']"
	}
	
	public By elementosSalvo() {
		return (By.xpath("//android.widget.TextView[@text]"));
	}
	
	public List<MobileElement> obterValoresLista() {
		return obterLista(By.xpath("//android.widget.TextView[@text]"));
	}
}
