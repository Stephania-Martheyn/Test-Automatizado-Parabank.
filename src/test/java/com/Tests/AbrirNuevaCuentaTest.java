package com.Tests;

import com.ExtendReport.ExtentFactory;
import com.Pages.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbrirNuevaCuentaTest {


    static WebDriver driver;
    static WebDriverWait wait;
    AbrirNuevaCuentaPage Abrir;
    HomePage home;
    static ExtentSparkReporter spark = new ExtentSparkReporter("target/REPORTES.html");
    static ExtentReports extent;
    ExtentTest test;


    @BeforeAll
    public void setUpDriver(){
        driver= Abrir.setup();
        Abrir.url("https://parabank.parasoft.com/parabank/index.htm");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        extent = ExtentFactory.getInstance();
        extent.attachReporter(spark);
    }
    @Test
    public void testNuevaCuenta() {
        test = extent.createTest("Test Abrir una nueva cuenta");
        test.log(Status.INFO, "Test Abrir una nueva cuenta");
        home= new HomePage(driver);
        home.clickAbrirNuevaCuentaPage();

        test.log(Status.PASS, "Iniciar el Test");
        Abrir = new AbrirNuevaCuentaPage(driver);


        test.log(Status.PASS, "Colocar nombre de usuario");
        Abrir.campoUserName("CarlosJulio777777");


        test.log(Status.PASS, "Colocar contraseña");
        Abrir.campoPassword("12345");

        test.log(Status.PASS, "Seleccionar el boton login");
        Abrir.doClick();

        //------------------- Parte 2 -----------

        test.log(Status.PASS, "Seleccionar el campo abrir cuenta");
        Abrir.doClick2();

        test.log(Status.PASS, "Seleccionar el campo de opcion deseada");
        Abrir.doClick3();

        test.log(Status.PASS, "Seleccionar el campo de opcion SAVINGS");
        Abrir.doClick4();

        test.log(Status.PASS, "Seleccionar el botom abrir cuenta");
        Abrir.doClick5();


        test.log(Status.PASS, "Mensaje correcto");
        String result = Abrir.checkMessage();
        System.out.println(result);
        assertTrue(result.contains("Congratulations, your account is now open."));

        System.out.println("Resultado obtenido: " + result);
    }
    @AfterAll
    public void exit(){
       extent.flush();
        Abrir.exit();
    }


}
