package com.Tests;


import com.ExtendReport.ExtentFactory;
import com.Pages.AbrirNuevaCuentaPage;
import com.Pages.HomePage;
import com.Pages.TranferirFondosPage;
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
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@SpringBootConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TransferirFondosTest {


    static WebDriver driver;
    static WebDriverWait wait;
    AbrirNuevaCuentaPage Abrir;
    TranferirFondosPage Transferir;
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
    public void testTrasnferirFondos() throws InterruptedException {
        test = extent.createTest("Test para transferir fondos");
        test.log(Status.INFO, "Test para transferir fondos");
        home= new HomePage(driver);
        home.clickAbrirNuevaCuentaPage();

        test.log(Status.PASS, "Iniciar el Test");
        Abrir = new AbrirNuevaCuentaPage(driver);
        Transferir = new TranferirFondosPage(driver);


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





        //------------------- Parte 3 -----------

        test.log(Status.PASS, "Seleccionar el boton tranferir fondo");
        Transferir.doClick6();


        test.log(Status.PASS, "Colocar monto deseado");
        Transferir.campoMonto("16897");

        test.log(Status.PASS, "Seleccionar la cuenta default");
        Transferir.doClickCuentaDefault();


        test.log(Status.PASS, "Seleccionar la otra cuenta a transferir");
        Transferir.doClick7();

        test.log(Status.PASS, "Seleccionar boton transferir");
        Transferir.doClick8();


        test.log(Status.PASS, "Mensaje de transferencia exitosa");
        String result = Transferir.checkMessage2();
        System.out.println(result);

        assertTrue(result.contains("Transfer Complete!"));

    }
    @AfterAll
    public void exit(){
        extent.flush();
        Transferir.exit();
    }

}
