package com.Tests;

import com.ExtendReport.ExtentFactory;
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

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RegristroTests {


    static WebDriver driver;
    static WebDriverWait wait;
    RegistroPage registrar;
    HomePage home;
    static ExtentSparkReporter spark = new ExtentSparkReporter("target/REPORTES.html");
    static ExtentReports extent;
    ExtentTest test;


    @BeforeAll
    public void setUpDriver(){
        driver= registrar.setup();
        registrar.url("https://parabank.parasoft.com/parabank/index.htm");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        extent = ExtentFactory.getInstance();
        extent.attachReporter(spark);
    }

    @Test
    public void testRegistro() {
        test = extent.createTest("Test registro de usuario");
        test.log(Status.INFO, "Iniciamoos el Test");
        home= new HomePage(driver);
        home.clickLinkRegistrarPage();

        test.log(Status.PASS, "Seleccionamos Registro");
        registrar = new RegistroPage(driver);

        test.log(Status.PASS, "Colocamos el nombre");
        registrar.campoNombre("Carlos");

        test.log(Status.PASS, "Colocamos el apellido");
        registrar.campoApellido("Julios");

        test.log(Status.PASS, "Colocamos la direccion");
        registrar.campoDireccion("El rascador");

        test.log(Status.PASS, "Colocamos la ciudad");
        registrar.campoCiudad("Quilla");

        test.log(Status.PASS, "Colocamos el estado");
        registrar.campoEstado("Atlantico");

        test.log(Status.PASS, "Colocamos el Zip Code");
        registrar.campoCode("1544424344");

        test.log(Status.PASS, "Colocamos el numero telefonico");
        registrar.campoTelefono("1544424344");

        test.log(Status.PASS, "Colocamos el SSN");
        registrar.campoSsn("1544424344");

        test.log(Status.PASS, "Colocamos nuestro nombre de usuario");
        registrar.campoUserName("CarlosJulio777777");


        test.log(Status.PASS, "Colocamos nuestra contraseña");
        registrar.campoPassword("12345");

        test.log(Status.PASS, "Reconfirmamos la contraseña");
        registrar.confirmarPassword("12345");


        test.log(Status.PASS, "Seleccionamos el boton REGISTER para registrarnos");
        registrar.doClick();
        String result = registrar.checkMessage();
        System.out.println(result);
        assertTrue(result.contains("Your account was created successfully. You are now logged in."));

        System.out.println("Resultado obtenido: " + result);
    }
    @AfterAll
    public void exit(){
       extent.flush();
      registrar.exit();
   }


}
