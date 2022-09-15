/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA CLASE VUELO DE PASAJEROS LA CUAL HEREDA DE VUELO 
 */
package logica;

import java.util.Date;

public class DePasajeros extends Vuelo{
   
    private int cantidadPasajeros;

    public DePasajeros(int cantidadPasajeros,String ruta,Date horario, String claseVuelo, int codigo, int codigoRuta,String tiempoVuelo, int precio) {
       //SE HEREDA ATRIBUTOS DE VUELO Y SE CREA ATRIBUTOS ESPECIFICOS DE LA CLASE
        super(codigo,ruta, codigoRuta, tiempoVuelo, precio, horario, claseVuelo);
         this.cantidadPasajeros=cantidadPasajeros;
    }

  
    public DePasajeros() {
        super();
    }

    public int getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(int cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

}
