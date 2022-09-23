package br.ce.wcaquino.appium.page;

import org.openqa.selenium.By;

import br.ce.wcaquino.appium.core.BasePage;
import br.ce.wcaquino.appium.core.DriverFactory;
//import io.appium.java_client.android.AndroidTouchAction;
//import io.appium.java_client.touch.LongPressOptions;
//import io.appium.java_client.touch.offset.ElementOption;

public class CliquesPage extends BasePage {
	
	public void cliqueLongo() {
		cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
		/*
		AndroidTouchAction touch = new AndroidTouchAction(DriverFactory.getDriver());
        touch.longPress(LongPressOptions.longPressOptions()
        		.withElement(ElementOption.element(DriverFactory.getDriver().findElement(By.xpath("//*[@text='Clique Longo']")))))
        		.perform();
		 */
	}
	
	public String obterTexto() {
		return DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText(); 
	}

}
