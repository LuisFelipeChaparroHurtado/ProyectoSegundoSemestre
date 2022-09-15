/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA CLASE PERSONA LA CUAL SE EXTENDERA PARA CLASE DE TRABAJADOR.HEREDANDOLE LOS SIGUIENTES ATRIBUTOS. 
 */
package logica;

public class Persona {
    
    private String nombre;
    private String apellido;
    private int edad;
    private int cedula;

    public Persona(String nombre, String apellido, int edad, int cedula) {
        //SE INICIALIZA ATRIBUTOS ESPECIFICOS DE LA CLASE PERSONA. 
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cedula = cedula;
    }

    public Persona() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }
    
    
}
