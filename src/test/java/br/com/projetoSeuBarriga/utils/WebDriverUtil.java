package br.com.projetoSeuBarriga.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class WebDriverUtil {
    public static WebDriver openBrowser() {
        final WebDriver driver;
        String url = "https://seubarriga.wcaquino.me/login";
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }
}