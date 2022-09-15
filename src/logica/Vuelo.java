/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA CLASE VUELO LA CUAL HEREDARÁ A LOS TIPOS DE VUELO(DE PASAJEROS, DE CARGA, HUMANITARIO Y MIXTO) 
 */
package logica;

import java.util.Date;

public class Vuelo {

    private int codigo;
    private String ruta;
    private int codigoRuta;
    private String tiempoVuelo;
    private int precio;
    private Date horario;
    private String claseVuelo;
    

    public Vuelo(int codigo,String ruta, int codigoRuta,String tiempoVuelo, int precio, Date horario, String claseVuelo) {
        //SE INICALIZA LOS ATRIBUTOS CORRESPONDIENTES;
        this.codigo=codigo;
        this.ruta = ruta;
        this.codigoRuta = codigoRuta;
        this.tiempoVuelo=tiempoVuelo;
        this.precio = precio;
        this.horario = horario;
        this.claseVuelo = claseVuelo;
    }

   

    public Vuelo() {
        super();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public String getClaseVuelo() {
        return claseVuelo;
    }

    public void setClaseVuelo(String claseVuelo) {
        this.claseVuelo = claseVuelo;
    }

    public int getCodigoRuta() {
        return codigoRuta;
    }

    public void setCodigoRuta(int codigoRuta) {
        this.codigoRuta = codigoRuta;
    }

    public String getTiempoVuelo() {
        return tiempoVuelo;
    }

    public void setTiempoVuelo(String tiempoVuelo) {
        this.tiempoVuelo = tiempoVuelo;
    }

}
