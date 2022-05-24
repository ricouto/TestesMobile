package br.ce.wcaquino.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ElementosCTAppiumTeste {
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Git_Automacao\\CursoAppium\\evidencias\\appTreinamento\\CTAppium_2_0.apk");
        
		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//passos
		//entrar no Formulario
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		for (MobileElement elemento: elementosEncontrados) {
			System.out.println(elemento.getText());
		}
		
		elementosEncontrados.get(1).click();

		//escrever "nome" e
		MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));//.sendKeys("Ricardo Couto");
		campoNome.sendKeys("Ricardo Couto");
		
		//verificar o nome
		String text = campoNome.getText();
		Assert.assertEquals("Ricardo Couto", text);
		
	    driver.quit();
	}

}
