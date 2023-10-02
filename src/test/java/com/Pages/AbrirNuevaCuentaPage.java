package com.Pages;

import com.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbrirNuevaCuentaPage extends Base {
    WebDriver driver;
    WebDriverWait wait;

    public AbrirNuevaCuentaPage(WebDriver driver) {
        this.driver = driver;
    }

// ---------------------------------------Abrir Nueva Cuenta ----------------------------------------------
    public void campoUserName(String name) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input")));
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
        nameInput.clear();
        nameInput.sendKeys(name);
}

    public void campoPassword(String password) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input")));
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[2]/input"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }
        public void doClick() {

            wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"))); // Boton login
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[3]/input"));
            loginButton.click();
        }

    public void doClick2() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Open New Account"))); // Boton Abrir cuenta
        WebElement openCampo = driver.findElement(By.linkText("Open New Account"));
        openCampo.click();
    }

    public void doClick3() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"type\"]"))); // selecciona campo de opcion
        WebElement campoOption = driver.findElement(By.xpath("//*[@id=\"type\"]"));
        campoOption.click();
    }
    public void doClick4() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/select[1]"))); // selecciona opcion savings
        WebElement campoOptionSavings = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/select[1]"));
        campoOptionSavings.click();
    }

    public void doClick5() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(900000000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input"))); // selecciona boton abrir cuenta
        WebElement campoBotonAbrir = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div/input"));
        campoBotonAbrir.click();
    }


    public String checkMessage() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(900000000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]")));
        WebElement message = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/p[1]"));

        String mensaje = message.getText();
        return mensaje;
    }

}

