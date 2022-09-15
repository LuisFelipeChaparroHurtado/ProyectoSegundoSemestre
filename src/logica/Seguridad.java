/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA CLASE AZAFATA ATENCIÓN AL CLIENTE LA CUAL HEREDA DE AZAFATA 
 */
package logica;

public class Seguridad extends Azafata{

    private String horarioInstrucci;
    private String chequeoPuertas;
    private String resultado;
    
    public void Seguridad(String horarioInstrucci,String chequeoPuertas,String resultado){
        //SE CREA ATRIBUTOS PERSONALES PARA CADA TIPO DE AZAFATA.
        this.horarioInstrucci=horarioInstrucci;
        this.chequeoPuertas=chequeoPuertas;
        this.resultado=resultado;
        
    }
    public Seguridad(String rutasDesignada, String sueldo, String turno, String nombre, String apellido, int edad, int cedula) {
        //SE HEREDA ATRIBUTOS DE CLASE AZAFATA
        super(rutasDesignada, sueldo, turno, nombre, apellido, edad, cedula); 
    }
    
    public Seguridad() {
        super();
    }

    public String getHorarioInstrucci() {
        return horarioInstrucci;
    }

    public void setHorarioInstrucci(String horarioInstrucci) {
        this.horarioInstrucci = horarioInstrucci;
    }

    public String getChequeoPuertas() {
        return chequeoPuertas;
    }

    public void setChequeoPuertas(String chequeoPuertas) {
        this.chequeoPuertas = chequeoPuertas;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    
    @Override
    public void registrarTrabajo() {
       
        this.resultado ="\nHORARIO DE INSTRUCCIONES: "+horarioInstrucci
                +"\nCHEQUEO DE PUERTAS: "+chequeoPuertas;
        
    }  
}
