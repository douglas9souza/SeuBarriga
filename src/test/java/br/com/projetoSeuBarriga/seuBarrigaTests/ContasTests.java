package br.com.projetoSeuBarriga.seuBarrigaTests;

import br.com.projetoSeuBarriga.pageBase.LoginPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import br.com.projetoSeuBarriga.pageBase.ContasPage;
import br.com.projetoSeuBarriga.utils.WebDriverUtil;


public class ContasTests {

    WebDriver driver = WebDriverUtil.openBrowser();
    ContasPage contasPage = new ContasPage(driver);
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
    public void testeAdicionarContaSemSucesso(){
        this.contasPage.adicionarConta();
        this.contasPage.clicarBotaoSalvarConta();

        Assert.assertEquals("Informe o nome da conta", this.contasPage.validarContaCriadaSemSucesso());
    }

    @Test
    public void testeAdicionarContaComSucesso(){
        this.contasPage.adicionarConta();
        this.contasPage.setNomeConta();
        this.contasPage.clicarBotaoSalvarConta();

        Assert.assertEquals("Conta adicionada com sucesso!", this.contasPage.validarContaCriadaComSucesso());
    }

    @Test
    public void testeListarAsContas(){
        this.contasPage.listarContas();

        Assert.assertEquals("Conta", contasPage.validarLabelContaListaDeContas());
        Assert.assertEquals("Ações", contasPage.validarLabelAcoesListaDeContas());
    }

    @Test
    public void testeAlterarConta(){
        this.contasPage.editarConta();

        Assert.assertEquals("Conta alterada com sucesso!", this.contasPage.validarMensagemContaAlteradaComSucesso());
    }

    @Test
    public void testeExcluirConta(){
        this.contasPage.excluirConta();

        Assert.assertEquals("Conta removida com sucesso!", this.contasPage.validarMensagemContaRemovidaComSucesso());
    }

}
