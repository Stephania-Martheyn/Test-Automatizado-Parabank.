package com.Tests;


import com.ExtendReport.ExtentFactory;
import com.Pages.AbrirNuevaCuentaPage;
import com.Pages.ActividadCuentaPage;
import com.Pages.HomePage;
import com.Pages.RegistroPage;
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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ActividadCuentaTest {


    static WebDriver driver;
    static WebDriverWait wait;
    ActividadCuentaPage Actividad;
    HomePage home;
    static ExtentSparkReporter spark = new ExtentSparkReporter("target/REPORTES.html");
    static ExtentReports extent;
    ExtentTest test;


    @BeforeAll
    public void setUpDriver(){
        driver= Actividad.setup();
        Actividad.url("https://parabank.parasoft.com/parabank/index.htm");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        extent = ExtentFactory.getInstance();
        extent.attachReporter(spark);
    }

    @Test
    public void testNuevaCuenta() throws InterruptedException {
        test = extent.createTest("Test Actividad de cuenta");
        test.log(Status.INFO, "Test Actividad de cuenta");
        home= new HomePage(driver);
        home.clickAbrirNuevaCuentaPage();

        test.log(Status.PASS, "Iniciar el Test");
        Actividad = new ActividadCuentaPage(driver);

        test.log(Status.PASS, "Colocar nombre de usuario");
        Actividad.campoUserName("CarlosJulio777777");

        test.log(Status.PASS, "Colocar contraseña");
        Actividad.campoPassword("12345");

        test.log(Status.PASS, "Seleccionar el boton login");
        Actividad.doClick();

        //------------------- Parte 2 -----------

        test.log(Status.PASS, "Seleccionar el campo resumen de cuenta");
        Actividad.doClickCampoResumenCuenta();
        System.out.println(Actividad.seVisualizaTexto());
        assertTrue(Actividad.seVisualizaTexto());

        test.log(Status.PASS, "Seleccionar una cuenta del resumen de cuenta");
        Actividad.doClickEnCuenta();
        assertTrue(Actividad.seVisualizaTitulo());

    }

    @AfterAll
    public void exit(){
        extent.flush();
        Actividad.exit();
    }


}
