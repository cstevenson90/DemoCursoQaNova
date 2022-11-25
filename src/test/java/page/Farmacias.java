package page;

import java.util.Date;

public class Farmacias {
    Date fecha;
    int local_id;
    int fk_region;
    int fk_comuna;
    int fk_localidad;
    String local_nombre;
    String comuna_nombre;
    String localidad_nombre;
    String local_direccion;
    String funcionamiento_hora_apertura;
    String funcionamiento_hora_cierre;
    String local_telefono;
    String local_lat;
    String local_lng;
    String funcionamiento_dia;

    public Farmacias(Date fecha, int local_id, int fk_region, int fk_comuna, int fk_localidad, String local_nombre, String comuna_nombre, String localidad_nombre, String local_direccion, String funcionamiento_hora_apertura, String funcionamiento_hora_cierre, String local_telefono, String local_lat, String local_lng, String funcionamiento_dia) {
        this.fecha = fecha;
        this.local_id = local_id;
        this.fk_region = fk_region;
        this.fk_comuna = fk_comuna;
        this.fk_localidad = fk_localidad;
        this.local_nombre = local_nombre;
        this.comuna_nombre = comuna_nombre;
        this.localidad_nombre = localidad_nombre;
        this.local_direccion = local_direccion;
        this.funcionamiento_hora_apertura = funcionamiento_hora_apertura;
        this.funcionamiento_hora_cierre = funcionamiento_hora_cierre;
        this.local_telefono = local_telefono;
        this.local_lat = local_lat;
        this.local_lng = local_lng;
        this.funcionamiento_dia = funcionamiento_dia;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getLocal_id() {
        return local_id;
    }

    public int getFk_region() {
        return fk_region;
    }

    public int getFk_comuna() {
        return fk_comuna;
    }

    public int getFk_localidad() {
        return fk_localidad;
    }

    public String getLocal_nombre() {
        return local_nombre;
    }

    public String getComuna_nombre() {
        return comuna_nombre;
    }

    public String getLocalidad_nombre() {
        return localidad_nombre;
    }

    public String getLocal_direccion() {
        return local_direccion;
    }

    public String getFuncionamiento_hora_apertura() {
        return funcionamiento_hora_apertura;
    }

    public String getFuncionamiento_hora_cierre() {
        return funcionamiento_hora_cierre;
    }

    public String getLocal_telefono() {
        return local_telefono;
    }

    public String getLocal_lat() {
        return local_lat;
    }

    public String getLocal_lng() {
        return local_lng;
    }

    public String getFuncionamiento_dia() {
        return funcionamiento_dia;
    }
}
