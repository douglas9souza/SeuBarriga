package br.com.projetoSeuBarriga.seuBarrigaTests;

import br.com.projetoSeuBarriga.pageBase.LoginPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import br.com.projetoSeuBarriga.pageBase.ContasPage;
import br.com.projetoSeuBarriga.utils.WebDriverUtil;


public class ContasTests {

    public static WebDriver driver = WebDriverUtil.openBrowser();
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
        this.loginPage.fazerLogin();
        this.contasPage.adicionarConta();
        this.contasPage.clicarBotaoSalvarConta();
        this.contasPage.validarContaCriadaSemSucesso();
    }

    @Test
    public void testeAdicionarContaComSucesso(){
        this.loginPage.fazerLogin();
        this.contasPage.adicionarConta();
        this.contasPage.setNomeConta();
        this.contasPage.clicarBotaoSalvarConta();
        this.contasPage.validarContaCriadaComSucesso();
    }

    @Test
    public void testeListarAsContas(){
        this.loginPage.fazerLogin();
        this.contasPage.listarContas();
        this.contasPage.validarListaDeContas();
    }

    @Test
    public void testeAlterarConta(){
        this.loginPage.fazerLogin();
        this.contasPage.editarConta();
    }

    @Test
    public void testeExcluirConta(){
        this.loginPage.fazerLogin();
        this.contasPage.excluirConta();
    }




}
