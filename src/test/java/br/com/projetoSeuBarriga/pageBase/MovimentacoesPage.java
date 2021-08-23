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

    public void validarMensagemDeMovimentacaoComSucesso(){
        Assert.assertEquals("Movimentação adicionada com sucesso!",
                pageObjects.getAlertaSucessoMovimentacoes().getText());
    }

    public void validarMensagemCampoValorCaracterInvalido(){
        Assert.assertEquals("Valor deve ser um número",
                pageObjects.getAlertaProblemaMovimentacoes().getText());
    }

    public void validarMensagemCampoObrigatorioDataDaMovimentacao(){
        Assert.assertEquals("Data da Movimentação é obrigatório",
                pageObjects.getAlertaProblemaMovimentacoes().getText());
    }

    public void validarMensagemCampoObrigatorioDataDoPagamento(){
        Assert.assertEquals("Data do pagamento é obrigatório",
                pageObjects.getAlertaProblemaMovimentacoes().getText());
    }

    public void validarMensagemCampoObrigatorioDescricao(){
        Assert.assertEquals("Descrição é obrigatório",
                pageObjects.getAlertaProblemaMovimentacoes().getText());
    }

    public void validarMensagemCampoObrigatorioInteressado(){
        Assert.assertEquals("Interessado é obrigatório",
                pageObjects.getAlertaProblemaMovimentacoes().getText());
    }

    public void validarMensagemCampoObrigatorioValor(){
        Assert.assertEquals("Valor é obrigatório\n" + "Valor deve ser um número",
                pageObjects.getAlertaProblemaMovimentacoes().getText());
    }




}
