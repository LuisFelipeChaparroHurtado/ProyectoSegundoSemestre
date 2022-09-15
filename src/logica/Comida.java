/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA CLASE AZAFATA COMIDA LA CUAL HEREDA DE AZAFATA. 
 */
package logica;


public class Comida extends Azafata{
    
    private String plato;
    private String tipoComida;
    private String horarioComida;
    private String resultado;
    
    public Comida(String plato, String horarioComida,String tipoComida,String resultado){
        //SE INICIALIZA ATRIBUTOS ESPECIALES DE AZAFATA COMIDA 
        this.plato=plato;
        this.horarioComida=horarioComida;
        this.tipoComida=tipoComida;
        this.resultado=resultado;
    }
    
    public Comida(String rutasDesignada,String sueldo, String turno, String nombre, String apellido, int edad, int cedula) {
        super(rutasDesignada, sueldo, turno, nombre, apellido, edad, cedula);
    }

    public Comida() {
        super();
        
    }

    public String getPlato() {
        return plato;
    }

    public void setPlato(String plato) {
        this.plato = plato;
    }  

    public String getHorarioComida() {
        return horarioComida;
    }

    public void setHorarioComida(String horarioComida) {
        this.horarioComida = horarioComida;
    }

    public String getTipoComida() {
        return tipoComida;
    }

    public void setTipoComida(String tipoComida) {
        this.tipoComida = tipoComida;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    @Override
    public void registrarTrabajo() {       
        
        this.resultado="PLATO "+plato
                       +"\nTIPO DE COMIDA : "+tipoComida
                       +"\nHORARIO: "+horarioComida;
        
    }
    
   
}
