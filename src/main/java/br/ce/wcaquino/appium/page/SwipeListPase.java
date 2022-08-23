package br.ce.wcaquino.appium.page;

import static br.ce.wcaquino.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.touch.TouchActions;

import br.ce.wcaquino.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;

public class SwipeListPase extends BasePage {

	public void swipeListRight(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.9, 0.1);
	}
	
	public void swipeListLeft(String opcao) {
		swipeElement(getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.1, 0.9);
	}
	
	public void clicarBotaoMais() throws InterruptedException {
		AndroidTouchAction touch = new AndroidTouchAction (getDriver());
		
		//MobileElement botao = getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
		MobileElement opc01 = getDriver().findElement(By.xpath("//*[@text='Opção 1']/.."));
		
		System.out.println(opc01.getSize());
		//System.out.println(botao.getSize());
		//System.out.println(botao.getSize().getWidth() / 2);
		double larguraBotaoOpc01Inicio = opc01.getSize().getWidth() + (opc01.getSize().getWidth() * 0.05);
		double larguraBotaoOpc01Fim = opc01.getSize().getWidth() + (opc01.getSize().getWidth() * 0.08);
		System.out.println(opc01.getSize().getWidth() +" / inicio "+ larguraBotaoOpc01Inicio +" / fim "+ larguraBotaoOpc01Fim );
		
		
		touch.tap(PointOption.point((int) larguraBotaoOpc01Inicio, (int) larguraBotaoOpc01Fim))
		.release()
	    .perform ();
		Thread.sleep(5000);
		
		/*@SuppressWarnings("rawtypes")
		TouchAction touchAction = new TouchAction(getDriver());
		touchAction.press(PointOption.point((int) larguraBotaoOpc01Inicio, (int) larguraBotaoOpc01Fim)).release().perform();
		
		
		
		new TouchAction(getDriver()).tap(getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.1, 0.9)
			.waitAction()
			.moveTo(PointOption.point(-50, 0))
			.release().perform();
		
		action.press(427, 878).waitAction(1000).moveTo(427,
				554).release().perform();
		*/
		
	}
	
}