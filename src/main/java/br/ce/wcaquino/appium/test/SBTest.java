package br.ce.wcaquino.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.appium.core.BaseTest;
import br.ce.wcaquino.appium.page.MenuPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBContasPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBHomePage;
import br.ce.wcaquino.appium.page.seuBarriga.SBLoginPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBMenuPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBMovimentacaoPage;
import br.ce.wcaquino.appium.page.seuBarriga.SBResumoPage;

public class SBTest extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SBMenuPage menuSB = new SBMenuPage(); 
	private SBLoginPage login = new SBLoginPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();

	@Before
	public void setup() {
		menu.acessarSeuBNativo();
		login.setEmail("testeappium@uol.com");
		login.setSenha("1");
		login.entrar();
	}
	
	@Test
	public void inserirConta() {
		menuSB.clicarAbaContas();
		contas.setConta("Conta Aut Massa de Teste");
		contas.salvar();
		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
	
	@Test
	public void deveExcluirConta() {
		menuSB.clicarAbaContas();
		contas.selecionarConta("Conta Aut Massa de Teste");
		contas.excluir();
		Assert.assertTrue(contas.existeElementoPorTexto("Conta excluída com sucesso"));
	}
	
	@Test
	public void deveValidarInclusaoMov() {
		menuSB.clicarMovimentacao();
		
		//Validar descricao
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Descrição é um campo obrigatório"));
		
		//validar interessado
		mov.setDescricao("Campo Desc");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Interessado é um campo obrigatório"));
		
		//validar valor
		mov.setInteressado("Campo Interessado");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Valor é um campo obrigatório"));
		
		//validar conta
		mov.setValor("1500");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Conta é um campo obrigatório"));
		
		//inserir com sucesso
		mov.setConta("Conta para alterar");
		mov.salvar();
		Assert.assertTrue(mov.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
	}
	
	@Test
	public void deveAtualizarSaldoAoExcluirMovimentacao() throws InterruptedException {
		
		//home.obterSaldoConta("Conta para saldo");
		//Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
		menuSB.clicarResumo();
		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
		Assert.assertTrue(resumo.existeElementoPorTexto("Movimentação removida com sucesso!"));
		menuSB.clicarHome();
		Thread.sleep(1000);
		home.scroll(0.25, 0.9);
		//Assert.assertEquals("-1000.00", home.obterSaldoConta("Conta para saldo"));
		
	}
	
	
}
