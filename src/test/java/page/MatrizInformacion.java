package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverContext;
import utils.Validaciones;

import java.util.ArrayList;
import java.util.List;
//import java.util.List;

public class MatrizInformacion {

    @FindBy(id = "imPgTitle")
    private WebElement titulo;

    @FindBy(id = "pluginAppObj_4_01_filter_field")
    private WebElement txtFiltro;

    @FindBy(id = "pluginAppObj_4_01_filter_button")
    private WebElement btnFiltrar;

    @FindBy(xpath = "//span[@class = 'jtable-page-number-next']")
    private WebElement btnPaginaSiguiente;

    @FindBy(xpath = "//span[@class = 'jtable-page-info']")
    private WebElement spanCantidad;

    @FindBy(xpath = "//table[@class = 'jtable']")
    private WebElement tabla;

    @FindBy(xpath = "//span[@class='imMnMnTextLabel' and text() = 'Matriz de informaci\u00f3n']") //\u00f3
    private WebElement btnMatrizInformacion;

    public MatrizInformacion(){
        PageFactory.initElements(DriverContext.getDriver(),this);
    }

    public void abrirMatrizInformacion() {
        btnMatrizInformacion.click();
    }

    public void validarDespliegue(){
        Validaciones.validarObjeto(titulo, "T\u00edtulo p\u00e1gina");
    }

    public void validarTextoTitulo(String texto){
        Validaciones.validarTexto(titulo, texto);
    }

    public void escribirFiltro(String filtro){
        txtFiltro.sendKeys(filtro);
    }

    public void clickBtnFiltrar(){
        btnFiltrar.click();
    }

    public List<String> recuperarDatosFiltrados(){
        WebElement cuerpo = tabla.findElement(By.tagName("tbody"));
        WebElement fila;
        List<String> datosFila = new ArrayList<String>();
        String datosColumna = "";
        for (int x = 0; x < cuerpo.findElements(By.tagName("tr")).size(); x++){
          fila = cuerpo.findElements(By.tagName("tr")).get(x);
          for (int y = 0; y < fila.findElements(By.tagName("td")).size(); y++){
              datosColumna = datosColumna + fila.findElements(By.tagName("td")).get(y).getText() + ";";
          }
          datosColumna = datosColumna.substring(0, datosColumna.length() - 1);
          System.out.println("Se recupera la fila nro " + (x+1) + ", con los siguientes datos: \n" + datosColumna);
          datosFila.add(datosColumna);
          datosColumna = "";
        }
        return datosFila;
    }


}















