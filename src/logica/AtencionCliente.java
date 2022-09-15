/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA CLASE AZAFATA ATENCIÓN AL CLIENTE LA CUAL HEREDA DE AZAFATA 
 */
package logica;


public class AtencionCliente extends Azafata{
    
    private String horaAtencion;
    private String resultado; 
    
    public AtencionCliente (String horaAtencion,String resultado){
        //SE CREA ATRIBUTOS PERSONALES PARA CADA TIPO DE AZAFATA.
        this.horaAtencion=horaAtencion;
        this.resultado=resultado;
    }
    public AtencionCliente(String rutasDesignada,String sueldo, String turno, String nombre, String apellido, int edad, int cedula) {
        //SE HEREDA ATRIBUTOS DE CLASE AZAFATA
        super(rutasDesignada,sueldo, turno, nombre, apellido, edad, cedula);
    }

    public AtencionCliente() {
        super();
    }

    public String getHoraAtencion() {
        return horaAtencion;
    }

    public void setHoraAtencion(String horaAtencion) {
        this.horaAtencion = horaAtencion;
    } 

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    @Override
    public void registrarTrabajo() {
        this.resultado="HORARIO DE ATENCIÓN: "+horaAtencion;
    }
    
    
}
