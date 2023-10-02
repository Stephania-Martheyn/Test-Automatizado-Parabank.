package com.Pages;

import com.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends Base {

    WebDriver driver;
    WebDriverWait wait;


    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    public void clickLinkRegistrarPage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a"))); // selecciono campo registar
        WebElement linkRegistar = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a"));
        linkRegistar.click();
    }

    public void clickAbrirNuevaCuentaPage() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"))); // Selecciono campo nombre de usario
        WebElement campoUserName = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
        campoUserName.click();
    }

    public void clickTransferirFondosPage() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"))); // Selecciono campo nombre de usario
        WebElement campoUserName = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
        campoUserName.click();
    }

    public void clickActividadCuentaPage() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"))); // Selecciono campo nombre de usario
        WebElement campoUserName = driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/form/div[1]/input"));
        campoUserName.click();
    }



}
