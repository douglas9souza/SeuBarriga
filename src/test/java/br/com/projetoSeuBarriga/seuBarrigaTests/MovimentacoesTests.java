package br.com.projetoSeuBarriga.seuBarrigaTests;

import br.com.projetoSeuBarriga.pageBase.LoginPage;
import br.com.projetoSeuBarriga.pageBase.MovimentacoesPage;
import br.com.projetoSeuBarriga.utils.WebDriverUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class MovimentacoesTests {

    public static WebDriver driver = WebDriverUtil.openBrowser();
    MovimentacoesPage movPage = new MovimentacoesPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Before
    public void login(){
        this.loginPage.fazerLogin();
    }

    @After
    public void fecharNavegador() {
        driver.quit();
    }

    @Test
    public void testeCriarMovimentacaoComSucesso(){
        this.movPage.clicarCriarMovimentacao();
        this.movPage.selecionarTipoDaMovimentacao();
        this.movPage.setDataDaMovimentacao();
        this.movPage.setDataDoPagamento();
        this.movPage.setDescricao();
        this.movPage.setInteressado();
        this.movPage.setValor("500");
        this.movPage.salvarMovimentacao();
        this.movPage.validarMensagemDeMovimentacaoComSucesso();
    }

    @Test
    public void testeCampoValorComCaractereInvalido(){
        this.movPage.clicarCriarMovimentacao();
        this.movPage.selecionarTipoDaMovimentacao();
        this.movPage.setDataDaMovimentacao();
        this.movPage.setDataDoPagamento();
        this.movPage.setDescricao();
        this.movPage.setInteressado();
        this.movPage.setValor("abcdefgh");
        this.movPage.salvarMovimentacao();
        this.movPage.validarMensagemCampoValorCaracterInvalido();
    }

    @Test
    public void testeDataDaMovimentacaoObrigatorio(){
        this.movPage.clicarCriarMovimentacao();
        this.movPage.selecionarTipoDaMovimentacao();
        this.movPage.setDataDoPagamento();
        this.movPage.setDescricao();
        this.movPage.setInteressado();
        this.movPage.setValor("500");
        this.movPage.salvarMovimentacao();
        this.movPage.validarMensagemCampoObrigatorioDataDaMovimentacao();
    }

    @Test
    public void testeDataDePagamentoObrigatorio(){
        this.movPage.clicarCriarMovimentacao();
        this.movPage.selecionarTipoDaMovimentacao();
        this.movPage.setDataDaMovimentacao();
        this.movPage.setDescricao();
        this.movPage.setInteressado();
        this.movPage.setValor("500");
        this.movPage.salvarMovimentacao();
        this.movPage.validarMensagemCampoObrigatorioDataDoPagamento();
    }

    @Test
    public void testeDescricaoObrigatoria(){
        this.movPage.clicarCriarMovimentacao();
        this.movPage.selecionarTipoDaMovimentacao();
        this.movPage.setDataDaMovimentacao();
        this.movPage.setDataDoPagamento();
        this.movPage.setInteressado();
        this.movPage.setValor("500");
        this.movPage.salvarMovimentacao();
        this.movPage.validarMensagemCampoObrigatorioDescricao();
    }

    @Test
    public void testeInteressadoObrigatorio(){
        this.movPage.clicarCriarMovimentacao();
        this.movPage.selecionarTipoDaMovimentacao();
        this.movPage.setDataDaMovimentacao();
        this.movPage.setDataDoPagamento();
        this.movPage.setDescricao();
        this.movPage.setValor("500");
        this.movPage.salvarMovimentacao();
        this.movPage.validarMensagemCampoObrigatorioInteressado();
    }

    @Test
    public void testeValorObrigatorio(){
        this.movPage.clicarCriarMovimentacao();
        this.movPage.selecionarTipoDaMovimentacao();
        this.movPage.setDataDaMovimentacao();
        this.movPage.setDataDoPagamento();
        this.movPage.setDescricao();
        this.movPage.setInteressado();
        this.movPage.salvarMovimentacao();
        this.movPage.validarMensagemCampoObrigatorioValor();
    }
}
