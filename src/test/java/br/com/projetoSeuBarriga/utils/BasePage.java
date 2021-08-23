package br.com.projetoSeuBarriga.utils;

import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitTo(int time){
        try {
            time *= 1000;
            Thread.sleep(time);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
