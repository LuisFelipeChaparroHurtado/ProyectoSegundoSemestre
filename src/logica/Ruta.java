/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA CLASE RUTA LA CUAL SERA INDEPENDIENTE Y NO EXTENDERA A NINGUNA OTRA CLASE. 
    SE DEBE TENER CONTROL DE LAS RUTAS CUBIERTAS POR LA AEROLÍNEA (ORIGEN, DESTINO, CÓDIGO, TIEMPO DE VUELO
 */
package logica;

public class Ruta {
    
    private String origen;
    private String destino;
    private int codigo;
    private String tiempoVuelo;

    public Ruta(String origen, String destino,int codigo,String tiempoVuelo) {
        this.origen = origen;
        this.destino = destino;
        this.codigo=codigo;
        this.tiempoVuelo=tiempoVuelo;
    }

    public Ruta() {
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTiempoVuelo() {
        return tiempoVuelo;
    }

    public void setTiempoVuelo(String tiempoVuelo) {
        this.tiempoVuelo = tiempoVuelo;
    }
    
    
}
