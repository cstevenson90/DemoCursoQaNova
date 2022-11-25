package testSuite;

import com.itextpdf.text.pdf.ReaderProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import testClass.BusquedaAnimalesGoogle;
import testClass.Logeo;
import utils.Constants.Navegador;
import utils.DriverContext;
import utils.ReadProperties;
import utils.Reporte.PdfQaNovaReports;
import utils.Utils;


import java.io.IOException;
import java.text.ParseException;

public class Prueba {
    ChromeDriver webDriver;
    //String url = "http://google.cl"; -- PAGINA GOOGLE
    String url = ReadProperties.readFromConfig("Propiedades.properties").getProperty("url"); //PAGINA PILOTO QANOVA

    @BeforeTest
    public void setUp(){
        DriverContext.setUp(Navegador.Chrome, url);
        PdfQaNovaReports.createPDF();
    }

    @AfterTest
    public void closeDriver(){
        DriverContext.closeDriver();

    }

    @Test
    public void pruebaLogin() throws ParseException, IOException {
        Logeo logeo = new Logeo();
        String usuario = ReadProperties.readFromConfig("Propiedades.properties").getProperty("usuario");
        String clave = ReadProperties.readFromConfig("Propiedades.properties").getProperty("clave");
        logeo.CasoLogin1(usuario, clave);
        PdfQaNovaReports.closePDF();
        //Utils.enviarCorreo("cstevenson90@gmail.com");
    }

    @Test
    public void Json() throws IOException {
        Logeo logeo = new Logeo();
        logeo.json();
        PdfQaNovaReports.closePDF();
    }


}