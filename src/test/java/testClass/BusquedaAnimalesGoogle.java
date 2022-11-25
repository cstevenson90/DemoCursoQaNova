package testClass;

import org.openqa.selenium.WebDriver;
import page.Google;

public class BusquedaAnimalesGoogle {
    private Google google;

    public void busquedaPerro(WebDriver webDriver){
        google = new Google(webDriver);
        google.ingresarBusqueda("perro");
        google.clickBtnBuscar();
    }

    public void busquedaGato(WebDriver webDriver){
        google = new Google(webDriver);
        google.ingresarBusqueda("gato");
        google.clickBtnBuscar();
    }
}