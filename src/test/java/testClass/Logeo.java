package testClass;

import org.openqa.selenium.WebDriver;
import page.*;
import utils.ReadProperties;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;
import utils.Utils;

import java.io.IOException;
import java.text.ParseException;

public class Logeo{

    private Login login;
    private CargaInformacion cargaInformacion;

    private MatrizInformacion matrizInformacion;

    private DescargarArchivos descargarArchivos;

    private CargarArchivos cargarArchivos;

    public Logeo(){

    }
    public void CasoLogin1(String usuario, String clave) throws ParseException, IOException {
        /*login = new Login();
        cargaInformacion = new CargaInformacion();
        matrizInformacion = new MatrizInformacion();
        descargarArchivos = new DescargarArchivos();
        cargarArchivos = new CargarArchivos();
        login.validarTextoUsuario("Nombre del usuario:");
        login.ingresarUsuario(usuario);
        login.ingresarClave(clave);
        login.clickBtnIngresar();
        cargaInformacion.recuperarTitulo();
        matrizInformacion.abrirMatrizInformacion();
        matrizInformacion.validarDespliegue();*/

        String ip = ReadProperties.readFromConfig("Propiedades.properties").getProperty("ipBaseDeDatos");
        String bd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("baseDeDatos");
        String usuarioBd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("usuarioBaseDeDatos");
        String claveBd = ReadProperties.readFromConfig("Propiedades.properties").getProperty("claveBaseDeDatos");
        String query = "select * from form where id = 1;";
        Utils.consultaBaseDeDatos(ip,bd,usuarioBd,claveBd,query);


        /*cargaInformacion.rellenarCampoTexto("Hola");
        cargaInformacion.rellenarCampoCorreo("cstevenson90@gmail.com");
        cargaInformacion.rellenarCampoTextArea("Texto largo");
        //cargaInformacion.rellenarFecha("01/01/2020");
        cargaInformacion.seleccionarFechaCalendario("2022-07-31");
        cargaInformacion.rellenarLista("valor 3");
        cargaInformacion.seleccionMultiple("2,3");
        cargaInformacion.seleccionRadioButton(2);
        cargaInformacion.clickBtnEnviar();
        matrizInformacion.validarTextoTitulo("Matriz de informaci\u00f3n");
        matrizInformacion.escribirFiltro("prueba");
        matrizInformacion.clickBtnFiltrar();
        matrizInformacion.recuperarDatosFiltrados();
        descargarArchivos.ingresarDescargarArchivos();
        descargarArchivos.validarDespliegue();
        descargarArchivos.validarTextoTitulo("Descarga de Archivos");
        //descargarArchivos.descargarPorBoton();
        //descargarArchivos.descargaPorLink();
        descargarArchivos.descargaPorImagen();*/



        /*cargarArchivos.ingresarCargarArchivos();
        cargarArchivos.validarDespliegue();
        cargarArchivos.validarTextoTitulo();
        cargarArchivos.cargarArchivo();
        cargarArchivos.clickBtnEnviar();
        matrizInformacion.validarDespliegue();
        PdfQaNovaReports.addReport("Archivo de carga", "Archivo cargado exitosamente", EstadoPrueba.PASSED, false);*/
    }

    public void json() throws IOException {
        LeerJson leerJson = new LeerJson();
        leerJson.generarReporte();
    }
}