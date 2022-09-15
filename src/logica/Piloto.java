/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA CLASE PILOTO LA CUAL SE EXTENDERA PARA CLASE DE TRABAJADOR.
 */
package logica;

public class Piloto extends Trabajador{

    public Piloto(String rutasDesignada, String sueldo, String nombre, String apellido, int edad, int cedula) {
        //SE HEREDA ATRIBUTOS DE CLASE TRABAJADOR
        super(rutasDesignada, sueldo, nombre, apellido, edad, cedula);
    }

    public Piloto() {
        super();
    }  
}
