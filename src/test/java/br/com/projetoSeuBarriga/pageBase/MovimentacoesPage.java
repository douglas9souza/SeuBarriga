package br.com.projetoSeuBarriga.pageBase;

import br.com.projetoSeuBarriga.data.GeradorDeValoresRandomicos;
import br.com.projetoSeuBarriga.pageObjects.MovimentacoesObjects;
import br.com.projetoSeuBarriga.utils.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MovimentacoesPage extends BasePage {
    public MovimentacoesPage(WebDriver driver) {
        super(driver);
    }

    MovimentacoesObjects pageObjects = new MovimentacoesObjects(driver);
    GeradorDeValoresRandomicos valoresRandomicos = new GeradorDeValoresRandomicos();

    public void clicarCriarMovimentacao(){
        pageObjects.getCriarMovimentacao().click();
    }

    public void selecionarTipoDaMovimentacao(){
        Select comboBox = new Select(pageObjects.getTipoDaMovimentacao());
        comboBox.selectByVisibleText("Receita");
    }

    public void setDataDaMovimentacao(){
        pageObjects.getDataDaMovimentacao().sendKeys("01/01/2021");
    }

    public void setDataDoPagamento(){
        pageObjects.getDataDoPagamento().sendKeys("05/01/2021");
    }

    public void setDescricao(){
        pageObjects.getDescricao().sendKeys("Isso é um teste!");
    }

    public void setInteressado(){
        pageObjects.getInteressado().sendKeys(valoresRandomicos.getValoresNome());
    }

    public void setValor(String valor){
        pageObjects.getValor().sendKeys(valor);
    }

    public void salvarMovimentacao(){
        pageObjects.getBotaoSalvarMovimentacao().click();
    }

    public String validarMensagemDeMovimentacaoComSucesso(){
                return pageObjects.getAlertaSucessoMovimentacoes().getText();
    }

    public String validarMensagemCampoValorCaracterInvalido(){
                return pageObjects.getAlertaProblemaMovimentacoes().getText();
    }

    public String validarMensagemCampoObrigatorioDataDaMovimentacao(){
                return pageObjects.getAlertaProblemaMovimentacoes().getText();
    }

    public String validarMensagemCampoObrigatorioDataDoPagamento(){
        return pageObjects.getAlertaProblemaMovimentacoes().getText();
    }

    public String validarMensagemCampoObrigatorioDescricao(){
        return pageObjects.getAlertaProblemaMovimentacoes().getText();
    }

    public String validarMensagemCampoObrigatorioInteressado(){
        return pageObjects.getAlertaProblemaMovimentacoes().getText();
    }

    public String  validarMensagemCampoObrigatorioValor(){
        return pageObjects.getAlertaProblemaMovimentacoes().getText();
    }




}
