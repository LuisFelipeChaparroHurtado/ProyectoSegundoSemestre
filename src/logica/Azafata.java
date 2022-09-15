/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE NECESITA GESTIONAR LA INFORMACIÓN DE AZAFATAS DE COMIDA, SEGURIDAD Y ATENCIÓN AL CLIENTE
    QUE TIENE ALGUNOS TIPOS DE VUELO. 
 */
package logica;

public abstract class Azafata extends Trabajador {
    
    private String turno;
    //SE HEREDA ATRIBUTOS DE LA CLASE TRABAJADOR
    public Azafata(String rutasDesignada, String sueldo, String turno, String nombre, String apellido, int edad, int cedula) {
        super(rutasDesignada, sueldo, nombre, apellido, edad, cedula);    
        this.turno=turno;
    }

    public Azafata() {
        super();
        
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
public abstract void registrarTrabajo();
  
}
