package br.ce.wcaquino.appium.test;

import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.DragNDropPage;
import br.ce.wcaquino.appium.page.MenuPage;

public class DragNDropTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private DragNDropPage page = new DragNDropPage();
	
	@Test
	public void deveEfeturarDragNDrop() {
		menu.scroll(0.9, 0.1);
		menu.acessarDragNDrop();
		
		//page.obterLista();
		
		
	}

}
