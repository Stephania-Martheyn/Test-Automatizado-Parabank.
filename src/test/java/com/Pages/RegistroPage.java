package com.Pages;

import com.Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
 // ESTEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE

public class RegistroPage extends Base {

    WebDriver driver;
    WebDriverWait wait;

    public RegistroPage (WebDriver driver) {
        this.driver = driver;
    }

// ---------------------------------------Registro ----------------------------------------------
    public void campoNombre(String name) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer.firstName")));
        WebElement nameInput = driver.findElement(By.id("customer.firstName"));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void campoApellido(String lastName) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer.lastName")));
        WebElement lastNameInput = driver.findElement(By.id("customer.lastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void campoDireccion(String address) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer.address.street")));
        WebElement lastNameInput = driver.findElement(By.id("customer.address.street"));
        lastNameInput.clear();
        lastNameInput.sendKeys(address);
    }
    public void campoCiudad(String city) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer.address.city")));
        WebElement lastNameInput = driver.findElement(By.id("customer.address.city"));
        lastNameInput.clear();
        lastNameInput.sendKeys(city);
    }
    public void campoEstado(String state) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer.address.state")));
        WebElement lastNameInput = driver.findElement(By.id("customer.address.state"));
        lastNameInput.clear();
        lastNameInput.sendKeys(state);
    }
    public void campoCode(String zipCode) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer.address.zipCode")));
        WebElement lastNameInput = driver.findElement(By.id("customer.address.zipCode"));
        lastNameInput.clear();
        lastNameInput.sendKeys(zipCode);
    }

    public void campoTelefono(String phone) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer.phoneNumber")));
        WebElement phoneInput = driver.findElement(By.id("customer.phoneNumber"));
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void campoSsn(String ssn) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer.ssn")));
        WebElement phoneInput = driver.findElement(By.id("customer.ssn"));
        phoneInput.clear();
        phoneInput.sendKeys(ssn);
    }

    public void campoUserName(String userName) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer.username")));
        WebElement passwordInput = driver.findElement(By.id("customer.username"));
        passwordInput.clear();
        passwordInput.sendKeys(userName);
    }
    public void campoPassword(String password) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("customer.password")));
        WebElement passwordInput = driver.findElement(By.id("customer.password"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void confirmarPassword(String password) {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("repeatedPassword")));
        WebElement pass2Input = driver.findElement(By.id("repeatedPassword"));
        pass2Input.clear();
        pass2Input.sendKeys(password);
    }

    public void doClick() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")));
        WebElement registroButton = driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
        registroButton.click();
    }


    public String checkMessage() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div[2]/p")));
        WebElement message = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/p"));

        String mensaje = message.getText();
        return mensaje;
    }


}
