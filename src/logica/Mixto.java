/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA CLASE VUELO MIXTO LA CUAL HEREDA DE VUELO 
 */
package logica;

import java.util.Date;

public class Mixto extends Vuelo {

    private String tipoVuelo;

    public Mixto(String tipoVuelo, String ruta,int codigo, Date horario, String claseVuelo, int codigoRuta,String tiempoVuelo, int precio) {
        //SE HEREDA ATRIBUTOS DE VUELO Y SE CREA ATRIBUTOS ESPECIFICOS DE LA CLASE
        super(codigo,ruta, codigoRuta, tiempoVuelo, precio, horario, claseVuelo);
        this.tipoVuelo = tipoVuelo;
    }

    public Mixto() {
        super();
    }

    public String getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(String tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }

}
