package com.Pages;

import com.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActividadCuentaPage extends Base {
    WebDriver driver;
    WebDriverWait wait;

    public ActividadCuentaPage(WebDriver driver) {
        this.driver = driver;
    }

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

    public void doClickCampoResumenCuenta() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Accounts Overview"))); // Boton Abrir resumen de cuenta
        WebElement openCampo = driver.findElement(By.linkText("Accounts Overview"));
        openCampo.click();
        Thread.sleep(3000);
    }

    public boolean seVisualizaTexto() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td"))); // TEXTO
        WebElement textoVisible = driver.findElement(By.xpath("//*[@id=\"accountTable\"]/tfoot/tr/td"));
        return textoVisible.isDisplayed();

    }

    public void doClickEnCuenta() throws InterruptedException{

        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a"))); // una Cuenta del resumen de cuenta
        WebElement cuentaResumen = driver.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a"));
        Thread.sleep(3000);
        cuentaResumen.click();

    }

    public boolean seVisualizaTitulo() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/h1"))); // Titulo detalle de cuenta
        WebElement tituloDetalleCuenta = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div[1]/h1"));
        return tituloDetalleCuenta.isDisplayed();
    }


}
