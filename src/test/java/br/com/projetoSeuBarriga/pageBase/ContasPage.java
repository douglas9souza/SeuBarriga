package br.com.projetoSeuBarriga.pageBase;

import br.com.projetoSeuBarriga.data.GeradorDeValoresRandomicos;
import br.com.projetoSeuBarriga.pageObjects.ContasObjects;
import br.com.projetoSeuBarriga.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

public class ContasPage extends BasePage {
    public ContasPage(WebDriver driver) {
        super(driver);
    }

    ContasObjects pageObjects = new ContasObjects(driver);
    GeradorDeValoresRandomicos valoresRandomicos = new GeradorDeValoresRandomicos();

    public void adicionarConta(){
        pageObjects.getContas().click();
        pageObjects.getOpcaoAdicionarConta().click();
    }

    public void listarContas(){
        pageObjects.getContas().click();
        pageObjects.getOpcaoListarContas().click();
    }

    public void validarListaDeContas(){
        Assert.assertEquals("Conta", pageObjects.getLabelContas().getText());
        Assert.assertEquals("Ações", pageObjects.getLabelAcoes().getText());
    }

    public void setNomeConta(){
        pageObjects.getNomeConta().sendKeys(valoresRandomicos.getValoresNome());
    }

    public void clicarBotaoSalvarConta(){
        pageObjects.getBotaoSalvarConta().click();
    }

    public void validarContaCriadaComSucesso(){
        Assert.assertEquals("Conta adicionada com sucesso!",
                pageObjects.getAlertaSucesso().getText());
    }

    public void validarContaCriadaSemSucesso(){
        Assert.assertEquals("Informe o nome da conta",
                pageObjects.getAlertaProblema().getText());
    }

    public void editarConta(){
        listarContas();
        pageObjects.getEditarConta().click();
        pageObjects.getNomeConta().clear();
        pageObjects.getNomeConta().sendKeys(valoresRandomicos.getValoresNome());
        pageObjects.getBotaoSalvarConta().click();
        Assert.assertEquals("Conta alterada com sucesso!", pageObjects.getAlertaSucesso().getText());
    }

    public String criarContaParaExcluir(){
        adicionarConta();
        setNomeConta();
        String conta = pageObjects.getNomeConta().getText();
        clicarBotaoSalvarConta();

        return conta;
    }

    public void excluirConta(){
        criarContaParaExcluir();
        listarContas();
        pageObjects.getExcluirConta().click();
        Assert.assertEquals("Conta removida com sucesso!", pageObjects.getAlertaSucesso().getText());
    }



}
