/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA CLASE TRABAJADOR LA CUAL HEREDA DE PERSONA 
 */
package logica;

public class Trabajador extends Persona{
    
    private String rutasDesignada;
    private String sueldo;
    

    public Trabajador(String rutasDesignada, String sueldo, String nombre, String apellido, int edad, int cedula) {
        //SE HEREDA ATRIBUTOS Y SE INICIALIZA ATRIBUTOS PERSONALES DE ESTA CLASE.
        super(nombre, apellido, edad, cedula);
        this.sueldo=sueldo;
        this.rutasDesignada=rutasDesignada;
    }

    public Trabajador() {
        super();
    }

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }
    
    public String getRutasDesignada() {
        return rutasDesignada;
    }

    public void setRutasDesignada(String rutasDesignada) {
        this.rutasDesignada = rutasDesignada;
    }
    
    
}
