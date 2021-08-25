package br.com.projetoSeuBarriga.tests;

import br.com.projetoSeuBarriga.pageBase.LoginPage;
import br.com.projetoSeuBarriga.pageBase.MovimentacoesPage;
import br.com.projetoSeuBarriga.utils.WebDriverUtil;
import org.junit.*;
import org.openqa.selenium.WebDriver;


public class MovimentacoesTestes {

    WebDriver driver = WebDriverUtil.openBrowser();
    MovimentacoesPage movPage = new MovimentacoesPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Before
    public void iniciar(){
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

        Assert.assertEquals("Movimentação adicionada com sucesso!", this.movPage.validarMensagemDeMovimentacaoComSucesso());
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

        Assert.assertEquals("Valor deve ser um número", this.movPage.validarMensagemCampoValorCaracterInvalido());
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

        Assert.assertEquals("Data da Movimentação é obrigatório", this.movPage.validarMensagemCampoObrigatorioDataDaMovimentacao());
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

        Assert.assertEquals("Data do pagamento é obrigatório", this.movPage.validarMensagemCampoObrigatorioDataDoPagamento());
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

        Assert.assertEquals("Descrição é obrigatório", this.movPage.validarMensagemCampoObrigatorioDescricao());
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

        Assert.assertEquals("Interessado é obrigatório", this.movPage.validarMensagemCampoObrigatorioInteressado());
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

        Assert.assertEquals("Valor é obrigatório\n" + "Valor deve ser um número", this.movPage.validarMensagemCampoObrigatorioValor());
    }
}
