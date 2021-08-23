package br.com.projetoSeuBarriga.pageBase;

import br.com.projetoSeuBarriga.pageObjects.LoginObjects;
import br.com.projetoSeuBarriga.utils.BasePage;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) { super(driver); }

    LoginObjects pageObjects = new LoginObjects(driver);

    public void setEmail() {
        pageObjects.getEmail().sendKeys("douglasdominguesdesouza@gmail.com");
    }

    public void setPassword() {
        pageObjects.getPassword().sendKeys("123456");
    }

    public void clicarBotaoEntrar() {
        pageObjects.getBotaoEntrar().click();
    }

    public void fazerLogin(){
        setEmail();
        setPassword();
        clicarBotaoEntrar();
    }
}
