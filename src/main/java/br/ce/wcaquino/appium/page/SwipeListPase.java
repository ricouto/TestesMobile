package br.ce.wcaquino.appium.page;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;
import org.openqa.selenium.By;
import br.ce.wcaquino.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class SwipeListPase extends BasePage {

	public void swipeListRight(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.9, 0.1);
	}
	
	public void swipeListLeft(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.1, 0.9);
	}
	
	public void clicarBotaoMais() throws InterruptedException {
		
		MobileElement botao = getDriver().findElement(By.xpath("//android.widget.TextView[@text='(+)']/.."));
		
		new TouchAction<>(getDriver())
		.tap(TapOptions.tapOptions()
		.withElement(ElementOption.element(botao, 50, 0)))
		.release()
		.perform();
	}
}