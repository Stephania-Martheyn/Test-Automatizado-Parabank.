package com.Pages;

import com.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TranferirFondosPage extends Base {

    WebDriver driver;
    WebDriverWait wait;

    public TranferirFondosPage(WebDriver driver) {
        this.driver = driver;
    }

    // --------------------------------------- Transferir fondos ----------------------------------------------


    public void doClick6() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(900000000));
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Transfer Funds"))); // Boton Abrir cuenta
        WebElement openCampoTransfer = driver.findElement(By.linkText("Transfer Funds"));
        openCampoTransfer.click();
        Thread.sleep(3000);

    }

    public void campoMonto(String monto) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(900000000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"amount\"]")));
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"amount\"]"));
        nameInput.clear();
        nameInput.sendKeys(monto);
    }

    public void doClickCuentaDefault(){

        wait = new WebDriverWait(driver, Duration.ofSeconds(900000000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[1]/select[1]"))); // selecciona cuenta default para tranferir fondos
        WebElement optionCuentaDefault = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[1]/select[1]"));
        optionCuentaDefault.click();
    }
    public void doClick7() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(900000000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[1]/select[2]"))); // selecciona otra cuenta para tranferir fondos
        WebElement optionTransferirOtraCuenta = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/form/div[1]/select[2]"));
        optionTransferirOtraCuenta.click();
    }

    public void doClick8() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(900000000));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input"))); // selecciona boton tranferir
        WebElement botonTransferir = driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/div/div/form/div[2]/input"));
        botonTransferir.click();
        Thread.sleep(3000);
    }

    public String checkMessage2() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(900000000));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1")));
        WebElement message2 = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/div/h1"));

        String mensaje2 = message2.getText();
        return mensaje2;
    }





}
