package br.com.projetoSeuBarriga.pageBase;

import br.com.projetoSeuBarriga.data.GeradorDeValoresRandomicos;
import br.com.projetoSeuBarriga.pageObjects.ContasObjects;
import br.com.projetoSeuBarriga.utils.BasePage;
import org.openqa.selenium.WebDriver;

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

    public String validarLabelContaListaDeContas(){
        return pageObjects.getLabelContas().getText();
    }


    public String validarLabelAcoesListaDeContas(){
        return pageObjects.getLabelAcoes().getText();
    }

    public void setNomeConta(){
        pageObjects.getNomeConta().sendKeys(valoresRandomicos.getValoresNome());
    }

    public void clicarBotaoSalvarConta(){
        pageObjects.getBotaoSalvarConta().click();
    }

    public String validarContaCriadaComSucesso(){
        return pageObjects.getAlertaSucesso().getText();
    }

    public String validarContaCriadaSemSucesso(){
        return pageObjects.getAlertaProblema().getText();
    }

    public void editarConta(){
        listarContas();
        pageObjects.getEditarConta().click();
        pageObjects.getNomeConta().clear();
        pageObjects.getNomeConta().sendKeys(valoresRandomicos.getValoresNome());
        pageObjects.getBotaoSalvarConta().click();
    }

    public String validarMensagemContaAlteradaComSucesso(){
        return pageObjects.getAlertaSucesso().getText();
    }

//    public String criarContaParaExcluir(){
//        adicionarConta();
//        setNomeConta();
//        String conta = pageObjects.getNomeConta().getText();
//        clicarBotaoSalvarConta();
//
//        return conta;
//    }

    public void excluirConta(){
        //criarContaParaExcluir();
        listarContas();
        pageObjects.getExcluirConta().click();
    }

    public String validarMensagemContaRemovidaComSucesso(){
        return pageObjects.getAlertaSucesso().getText();
    }

}
