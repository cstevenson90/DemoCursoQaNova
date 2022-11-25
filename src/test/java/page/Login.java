package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Validaciones;

public class Login {

    @FindBy(xpath = "//label[@for='imUname']")
    WebElement labelUsuario;

    @FindBy(id = "imUname")
    WebElement inputUsuario;

    @FindBy(id = "imPwd")
    WebElement inputClave;

    /*@FindBy(className = "imLoginSubmit")
    WebElement btnIngresar;*/

    @FindBy(xpath = "//input[@value = 'Ingresar a Demo']")
    WebElement btnIngresar;

    //WebDriverWait webDriverWait;

    public Login(){
        PageFactory.initElements(DriverContext.getDriver(),this);
        //this.webDriverWait = new WebDriverWait(DriverContext.getDriver(),30);
    }
    public void ingresarUsuario(String usuario){
        //webDriverWait.until(ExpectedConditions.visibilityOf(inputUsuario));
        Validaciones.validarObjeto(inputUsuario, "input usuario");
        PdfQaNovaReports.addWebReportImage("Despliegue Login", "Login desplegado correctamente", EstadoPrueba.PASSED, false);
        inputUsuario.sendKeys(usuario);
    }

    public void ingresarClave(String clave){
        inputClave.sendKeys(clave);
    }

    public void clickBtnIngresar(){
        PdfQaNovaReports.addWebReportImage("Datos Login", "Se ingresa usuario y contrase\u00f1a", EstadoPrueba.PASSED,false);
        btnIngresar.click();
    }
    public void validarTextoUsuario (String texto){
        Validaciones.validarTexto(labelUsuario,texto);
    }
}