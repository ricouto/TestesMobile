package br.ce.wcaquino.appium.page.seuBarriga;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;

public class SBHomePage extends BasePage {
	
	public void clicarReset() {
		clicarPorTexto("RESET");
	}
	
	public void obterSaldoConta(String conta) throws InterruptedException {
		System.out.println("passei - - " + conta);
		
		Thread.sleep(5000);
		System.out.println("passei - - " + obterTexto(By.xpath("//android.view.ViewGroup//android.widget.TextView/*[contains(text(),'"+conta+"')]"
				+ "/following-sibling::android.widget.TextView")));
		
		//System.out.println(obterTexto(By.className("//android.view.ViewGroup")("//*[contains(text(),'"+conta+"')]")));
		//return obterTexto(By.xpath("//*[contains(text(),'"+conta+"')]/following-sibling::android.widget.TextView"));
	}

}
