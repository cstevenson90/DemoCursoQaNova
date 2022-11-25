package page;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import utils.DriverContext;
import utils.Reporte.EstadoPrueba;
import utils.Reporte.PdfQaNovaReports;

import javax.naming.directory.DirContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LeerJson {
    public LeerJson(){

    }
    public List recuperarJson() throws IOException {
        String url = "https://farmanet.minsal.cl/index.php/ws/getlocalesturnos";
        InputStream is = new URL(url).openStream();
        Gson gson = new Gson();
        String fichero = "";
        List<Farmacias> farmacias = null;
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String lineas;
            while ((lineas = rd.readLine()) != null) {
                fichero = fichero + lineas;
            }
            Type listadoFarmacias = new TypeToken<List<Farmacias>>() {}.getType();
            farmacias = gson.fromJson(fichero, listadoFarmacias);
            System.out.println("result\u00f3");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return farmacias;


    }
    public void generarReporte() throws IOException {
        List<Farmacias> farmacias = recuperarJson();
        String urlMaps = "https://www.google.cl/maps/@";
        String url;
        for (Farmacias f : farmacias){
            url = urlMaps + f.getLocal_lat() + "," + f.getLocal_lng() + "17z";
            DriverContext.getDriver().get(url);
            DriverContext.getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            PdfQaNovaReports.addWebReportImage("Farmacia " + f.getLocal_nombre() + " de " + f.getComuna_nombre(), f.getLocal_nombre() + " ubicaci\u00f3n en la comuna de " + f.getComuna_nombre(), EstadoPrueba.DONE,false);
        }
    }
}
