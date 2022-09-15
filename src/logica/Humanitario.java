/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA CLASE VUELO HUMANITARIO LA CUAL HEREDA DE VUELO 
 */
package logica;

import java.util.Date;

public class Humanitario extends Vuelo {

    private String descriOperacion;
    private int cantidadPersonasH;

    public Humanitario(String descriOperacion, int cantidadPersonasH, String ruta,int codigo, int codigoRuta,String tiempoVuelo, int precio, Date horario, String claseVuelo) {
        //SE HEREDA ATRIBUTOS DE VUELO Y SE CREA ATRIBUTOS ESPECIFICOS DE LA CLASE
        super(codigo,ruta, codigoRuta, tiempoVuelo, precio, horario, claseVuelo);
        this.descriOperacion = descriOperacion;
        this.cantidadPersonasH = cantidadPersonasH;
    }

    public Humanitario() {
    }

    public String getDescriOperacion() {
        return descriOperacion;
    }

    public void setDescriOperacion(String descriOperacion) {
        this.descriOperacion = descriOperacion;
    }

    public int getCantidadPersonasH() {
        return cantidadPersonasH;
    }

    public void setCantidadPersonasH(int cantidadPersonasH) {
        this.cantidadPersonasH = cantidadPersonasH;
    }

}
