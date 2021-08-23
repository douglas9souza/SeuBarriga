package br.com.projetoSeuBarriga.pageObjects;

import br.com.projetoSeuBarriga.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginObjects extends BasePage {

    public LoginObjects(WebDriver driver) { super(driver); }

    public WebElement getEmail(){
        return driver.findElement(By.id("email"));
    }

    public WebElement getPassword(){
        return driver.findElement(By.id("senha"));
    }

    public WebElement getBotaoEntrar(){
        return driver.findElement(By.cssSelector("body > div.jumbotron.col-lg-4 > form > button"));
    }


}
