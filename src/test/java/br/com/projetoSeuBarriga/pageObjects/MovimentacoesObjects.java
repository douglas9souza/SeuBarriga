package br.com.projetoSeuBarriga.pageObjects;

import br.com.projetoSeuBarriga.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MovimentacoesObjects extends BasePage {
    public MovimentacoesObjects(WebDriver driver) {
        super(driver);
    }

    public WebElement getCriarMovimentacao(){
        return driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[3]/a"));
    }

    public WebElement getTipoDaMovimentacao(){
        return driver.findElement(By.id("tipo"));
    }

    public WebElement getDataDaMovimentacao(){
        return driver.findElement(By.id("data_transacao"));
    }

    public WebElement getDataDoPagamento(){
        return driver.findElement(By.id("data_pagamento"));
    }

    public WebElement getDescricao(){
        return driver.findElement(By.id("descricao"));
    }

    public WebElement getInteressado(){
        return driver.findElement(By.id("interessado"));
    }

    public WebElement getValor(){
        return driver.findElement(By.id("valor"));
    }

    public WebElement getConta(){
        return driver.findElement(By.id("conta"));
    }

    public WebElement getAlertaProblemaMovimentacoes(){
        return driver.findElement(By.xpath("/html/body/div[1]"));
    }

    public WebElement getAlertaSucessoMovimentacoes(){
        return driver.findElement(By.cssSelector("body > div.alert.alert-success"));
    }

    public WebElement getBotaoSalvarMovimentacao(){
        return driver.findElement(By.cssSelector("body > div.col-lg-10 > form > div.btn-group > button"));
    }

}
