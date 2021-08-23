package br.com.projetoSeuBarriga.pageObjects;

import br.com.projetoSeuBarriga.utils.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContasObjects extends BasePage {
    public ContasObjects(WebDriver driver) {
        super(driver);
    }


    public WebElement getContas(){
        return driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a"));
    }

    public WebElement getOpcaoAdicionarConta(){
        return driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li[1]/a"));
    }

    public WebElement getOpcaoListarContas(){
        return driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li[2]/a"));
    }

    public WebElement getNomeConta(){
        return driver.findElement(By.id("nome"));
    }

    public WebElement getBotaoSalvarConta(){
        return driver.findElement(By.cssSelector("body > div.col-lg-10 > form > div.btn-group > button"));
    }

    //Mensagem de sucesso
    public WebElement getAlertaSucesso(){
        return driver.findElement(By.cssSelector("body > div.alert.alert-success"));
    }

    //Mensagem de problema
    public WebElement getAlertaProblema(){
        return driver.findElement(By.cssSelector("body > div.alert.alert-danger"));
    }

    public WebElement getLabelContas(){
        return driver.findElement(By.cssSelector("#tabelaContas > thead > tr > th:nth-child(1)"));
    }

    public WebElement getLabelAcoes(){
        return driver.findElement(By.cssSelector("#tabelaContas > thead > tr > th:nth-child(2)"));
    }

    public WebElement getEditarConta(){
        return driver.findElement(By.cssSelector("#tabelaContas > tbody > tr > td:nth-child(2) > a:nth-child(1)"));
    }

    public WebElement getExcluirConta(){
        return driver.findElement(By.cssSelector("#tabelaContas > tbody > tr > td:nth-child(2) > a:nth-child(2)"));
    }

}
