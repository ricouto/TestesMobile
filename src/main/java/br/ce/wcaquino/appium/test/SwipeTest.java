package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.SwipeListPase;


public class SwipeTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SwipeListPase swipePage = new SwipeListPase();
	
	@Test
	public void deveRealizarSwipe() {
		
		menu.acessarSwipe();
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		menu.swipe(0.9, 0.1);
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));
		menu.clicarPorTexto("›");
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));
		menu.swipe(0.1, 0.9);
		menu.clicarPorTexto("‹");
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
	}
	
	@Test
	public void desafioSwipeList() throws InterruptedException {
		
		//clicar SwipeList
		menu.scroll(0.9, 0.1);
		menu.acessarSwipeList();
		
		//opc1 direita
		swipePage.swipeListRight("Opção 1");
		
		//clicar na opcao +
		swipePage.clicarBotaoMais();
		//menu.clicarPorTexto("(+)");
		
		/*
		//verificar opc+
		Assert.assertTrue(menu.existeElementoPorTexto("Opção 1 (+)"));
		
		//opc4 direita
		swipePage.swipeListRight("Opção 4");
		
		//clicar na opcao -
		menu.clicarPorTexto("(-)");
		
		//verificar opc-
		Assert.assertTrue(menu.existeElementoPorTexto("Opção 4 (-)"));
		
		//opc5 esquerta
		swipePage.swipeListRight("Opção 5");
		
		//verificar opc5
		Assert.assertTrue(menu.existeElementoPorTexto("Opção 5"));
		*/
	}

}
