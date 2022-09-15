/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA CLASE VUELO DE CARGA LA CUAL HEREDA DE VUELO 
 */
package logica;

import java.util.Date;

public class DeCarga extends Vuelo {

    private String nombreProducto;
    private int peso;

    public DeCarga(String nombreProducto,int peso,String ruta,int codigo,Date horario, String claseVuelo, int codigoRuta,String tiempoVuelo, int precio) {
        //SE HEREDA ATRIBUTOS DE VUELO Y SE CREA ATRIBUTOS ESPECIFICOS DE LA CLASE
        super(codigo,ruta, codigoRuta, tiempoVuelo, precio, horario, claseVuelo);
        this.nombreProducto = nombreProducto;
        this.peso = peso;
    }
    
    public DeCarga() {
        super();
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}