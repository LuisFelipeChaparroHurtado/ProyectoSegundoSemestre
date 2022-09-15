/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE NECESITA GESTIONAR LA INFORMACIÓN DE UNA AEROLÍNEA.
    LA AEROLÍNEA  DEBE MANEJAR LOS VUELOS POR TIPO (NACIONAL, INTERNACIONAL, 
    DE PASAJEROS, DE CARGA, MIXTO, HUMANITARIO).
 */
package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Aerolinea {

    private List<Vuelo> listaVuelos;
    private List<Piloto> listaPilotos;
    private List<Azafata> listaAzafata;
    private List<Ruta> listaRutas;
    private Scanner keyboard;

    public Aerolinea() {

        /*SE INICIALIZA LOS ATRIBUTOS DE LA CLASE. LA CUAL CONTARA CON TODA LA INFORMACION DE VUELO, TRABAJADORES Y
    TODA ACTIVIDAD QUE REALICE LA AEROLINEA*/
        listaVuelos = new ArrayList<Vuelo>();
        listaPilotos = new ArrayList<Piloto>();
        listaAzafata = new ArrayList<Azafata>();
        listaRutas = new ArrayList<Ruta>();
        keyboard = new Scanner(System.in);
    }

    public List<Vuelo> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(List<Vuelo> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    public List<Piloto> getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(List<Piloto> listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public List<Azafata> getListaAzafata() {
        return listaAzafata;
    }

    public void setListaAzafata(List<Azafata> listaAzafata) {
        this.listaAzafata = listaAzafata;
    }

    public List<Ruta> getListaRutas() {
        return listaRutas;
    }

    public void setListaRutas(List<Ruta> listaRutas) {
        this.listaRutas = listaRutas;
    }

    public Scanner getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Scanner keyboard) {
        this.keyboard = keyboard;
    }

    public void agregarListaVuePasajeros(int cantidadP, String ruta, int codigoV, Date fecha, String clase, int codigoRuta, String tiempoVuelo, int precio) {
        /*SE AGREGA A LA LISTA PASAJEROS DATOS PEDIDOS POR TECLADO DESDE LA CONSOLA DEL PROGRAMA*/
        listaVuelos.add(new DePasajeros(cantidadP, ruta, fecha, clase, codigoV, codigoRuta, tiempoVuelo, precio));
    }

    public void agregarListaVueDeCarga(String nombreP, int peso, String ruta, int codigoV, Date fecha, String clase, int codigoRuta, String tiempoVuelo, int precio) {
        /*SE AGREGA A LA LISTA CARGA DATOS PEDIDOS POR TECLADO DESDE LA CONSOLA DEL PROGRAMA*/
        listaVuelos.add(new DeCarga(nombreP, peso, ruta, codigoV, fecha, clase, codigoRuta, tiempoVuelo, precio));
    }

    public void agregarListaVueloHuman(String mision, int cantidadPH, String ruta, int codigoV, Date fecha, String clase, int codigoRuta, String tiempoVuelo) {
        /*SE AGREGA A LA LISTA VUELO HUMANITARIO DATOS PEDIDOS POR TECLADO DESDE LA CONSOLA DEL PROGRAMA*/
        listaVuelos.add(new Humanitario(mision, cantidadPH, ruta, codigoV, codigoRuta, tiempoVuelo, 0, fecha, clase));
    }

    public void agregarListaVueloMixto(String tipoVuelo, String ruta, int codigoV, Date fecha, String clase, int codigoVuelo, String tiempoVuelo, int precio) {
        /*SE AGREGA A LA LISTA VUELO MIXTO DATOS PEDIDOS POR TECLADO DESDE LA CONSOLA DEL PROGRAMA*/
        listaVuelos.add(new Mixto(tipoVuelo, ruta, codigoV, fecha, clase, codigoVuelo, tiempoVuelo, precio));
    }

    public void agregarListaPiloto(String ruta, String sueldo, String nombre, String apellido, int edad, int cc) {
        /*SE AGREGA A LA LISTA PILOTOS DATOS PEDIDOS POR TECLADO DESDE LA CONSOLA DEL PROGRAMA*/
        listaPilotos.add(new Piloto(ruta, sueldo, nombre, apellido, edad, cc));
    }

    public void agregarListaAzafataComida(String rutaAzafata, String sueldoAzafata, String turno, String nombreAzafata, String apellidoAzafata, int edadAzafata, int cc) {
        /*SE AGREGA A LA LISTA AZAFATA COMIDA DATOS PEDIDOS POR TECLADO DESDE LA CONSOLA DEL PROGRAMA*/
        listaAzafata.add(new Comida(rutaAzafata, sueldoAzafata, turno, nombreAzafata, apellidoAzafata, edadAzafata, cc));
    }

    public void agregarListaAzafataAtencion(String rutaAzafata, String sueldoAzafata, String turno, String nombreAzafata, String apellidoAzafata, int edadAzafata, int cc) {
        /*SE AGREGA A LA LISTA AZAFATA ATENCION AL CLIENTE DATOS PEDIDOS POR TECLADO DESDE LA CONSOLA DEL PROGRAMA*/
        listaAzafata.add(new AtencionCliente(rutaAzafata, sueldoAzafata, turno, nombreAzafata, apellidoAzafata, edadAzafata, cc));
    }

    public void agregarListaAzafataSeguridad(String rutaAzafata, String sueldoAzafata, String turno, String nombreAzafata, String apellidoAzafata, int edadAzafata, int cc) {
        /*SE AGREGA A LA LISTA AZAFATA SEGURIDAD DATOS PEDIDOS POR TECLADO DESDE LA CONSOLA DEL PROGRAMA*/
        listaAzafata.add(new Seguridad(rutaAzafata, sueldoAzafata, turno, nombreAzafata, apellidoAzafata, edadAzafata, cc));
    }

    public void agregarListaRutas(String origen, String destino, int codigoR, String tiempoR) {
        /*SE AGREGA A LA LISTA DE LAS RUTAS LOS CUALES SON DATOS PEDIDOS POR TECLADO DESDE LA CONSOLA DEL PROGRAMA*/
        listaRutas.add(new Ruta(origen, destino, codigoR, tiempoR));
    }

    /*SE REALIZA LAS SIGUIENTES LINEAS DE CODIGO PARA LA INTERFACE GRAFICA*/
    public String mostrarPasa() {
        /*SE CREA UNA METODO TIPO STRING EN EL CUAL SE CREA LISTA LA CUAL CONTENDRA TODA LA INFORMACION 
        ACERCA DE LOS DATOS DE EL VUELO TIPO PASAJEROS. EL CUAL SE ENVIARA AL JFRAME*/

        List<String> vueloP = new ArrayList<String>();
        //SE MANDA POR PARAMETRO A EL METODO DE LISTA VUELO CORRESPONDIENTE
        vueloP = mostrarP(vueloP);
        String texto = "\n\n";

        for (String item : vueloP) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrarP(List<String> vueloPasa) {
        /*LISTA VUELO PASAJEROS*/
        for (int i = 0; i < listaVuelos.size(); i++) {

            if (listaVuelos.get(i).getClass().getSimpleName().equals("DePasajeros")) {

                vueloPasa.add("\nCANTIDAD PASAJEROS: " + ((DePasajeros) listaVuelos.get(i)).getCantidadPasajeros()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nTIPO DE VUELO: " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nPRECIO: " + listaVuelos.get(i).getPrecio() + "\n\n");
            }
        }

        return vueloPasa;
    }

    public String mostrarCar() {

        /*SE CREA UNA METODO TIPO STRING EN EL CUAL SE CREA LISTA LA CUAL CONTENDRA TODA LA INFORMACION 
        ACERCA DE LOS DATOS DE EL VUELO TIPO CARGA. EL CUAL SE ENVIARA AL JFRAME*/
        List<String> vueloC = new ArrayList<String>();
        //SE MANDA POR PARAMETRO A EL METODO DE LISTA VUELO CORRESPONDIENTE
        vueloC = mostrarCarga(vueloC);
        String texto = "\n\n";

        for (String item : vueloC) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrarCarga(List<String> vueloCarga) {

        /*LISTA VUELO CARGA*/
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("DeCarga")) {
                vueloCarga.add("\nNOMBRE PRODUCTO: " + ((DeCarga) listaVuelos.get(i)).getNombreProducto()
                        + "\nPESO: " + ((DeCarga) listaVuelos.get(i)).getPeso()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nTIPO DE VUELO: " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nPRECIO: " + listaVuelos.get(i).getPrecio() + "\n\n");
            }
        }

        return vueloCarga;
    }

    public String mostrarHum() {

        /*SE CREA UNA METODO TIPO STRING EN EL CUAL SE CREA LISTA LA CUAL CONTENDRA TODA LA INFORMACION 
        ACERCA DE LOS DATOS DE EL VUELO TIPO HUMANITARIO. EL CUAL SE ENVIARA AL JFRAME*/
        List<String> vueloHum = new ArrayList<String>();
        vueloHum = mostrarH(vueloHum);
        //SE MANDA POR PARAMETRO A EL METODO DE LISTA VUELO CORRESPONDIENTE
        String texto = "\n\n";

        for (String item : vueloHum) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrarH(List<String> vueloH) {

        /*LISTA VUELO HUMANITARIO*/
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("Humanitario")) {
                vueloH.add("\nDESCRIPCION: " + ((Humanitario) listaVuelos.get(i)).getDescriOperacion()
                        + "\nNUMERO DE PERSONAS: " + ((Humanitario) listaVuelos.get(i)).getCantidadPersonasH()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nTIPO DE VUELO: " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nVUELO NO TIENE PRECIO (GRATIS)\n\n");
            }
        }
        return vueloH;
    }

    public String mostrarMix() {

        /*SE CREA UNA METODO TIPO STRING EN EL CUAL SE CREA LISTA LA CUAL CONTENDRA TODA LA INFORMACION 
        ACERCA DE LOS DATOS DE EL VUELO TIPO MIXTO. EL CUAL SE ENVIARA AL JFRAME*/
        List<String> vueloMix = new ArrayList<String>();
        vueloMix = mostrarM(vueloMix);
        //SE MANDA POR PARAMETRO A EL METODO DE LISTA VUELO CORRESPONDIENTE
        String texto = "\n\n";

        for (String item : vueloMix) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrarM(List<String> vueloM) {

        /*LISTA VUELO MIXTO*/
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("Mixto")) {
                vueloM.add("\nTIPO VUELO: " + ((Mixto) listaVuelos.get(i)).getTipoVuelo()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nTIPO DE VUELO: " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nPRECIO: " + listaVuelos.get(i).getPrecio() + "\n\n");
            }
        }
        return vueloM;
    }

    public String mostrar_LPiloto() {

        /*SE CREA UNA METODO TIPO STRING EN EL CUAL SE CREA LISTA LA CUAL CONTENDRA TODA LA INFORMACION 
            ACERCA DE LOS DATOS DE EL TRABAJADOR TIPO PILOTO. EL CUAL SE ENVIARA AL JFRAME*/
        List<String> trabajadorPi = new ArrayList<String>();
        //SE MANDA POR PARAMETRO A EL METODO DE LISTA VUELO CORRESPONDIENTE
        trabajadorPi = mostrar_Piloto(trabajadorPi);
        String texto = "\n\n";

        for (String item : trabajadorPi) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_Piloto(List<String> trabajadorP) {

        /*LISTA PILOTO*/
        for (int i = 0; i < listaPilotos.size(); i++) {
            trabajadorP.add("\nRUTA: " + listaPilotos.get(i).getRutasDesignada()
                    + "\nSUELDO: " + listaPilotos.get(i).getSueldo()
                    + "\nNOMBRE: " + listaPilotos.get(i).getNombre()
                    + "\nAPELLIDO: " + listaPilotos.get(i).getApellido()
                    + "\nEDAD: " + listaPilotos.get(i).getEdad()
                    + "\nNUMERO DE DOCUMENTO: " + listaPilotos.get(i).getCedula() + "\n\n");
        }
        return trabajadorP;
    }

    public String mostrar_LAzafataC() {

        /*SE CREA UNA METODO TIPO STRING EN EL CUAL SE CREA LISTA LA CUAL CONTENDRA TODA LA INFORMACION 
            ACERCA DE LOS DATOS DE EL TRABAJADOR TIPO AZAFATA DE COMIDA. EL CUAL SE ENVIARA AL JFRAME*/
        List<String> trabajadorAzaC = new ArrayList<String>();
        //SE MANDA POR PARAMETRO A EL METODO DE LISTA AZAFATA COMIDA
        trabajadorAzaC = mostrar_AzafataC(trabajadorAzaC);
        String texto = "\n\n";

        for (String item : trabajadorAzaC) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_AzafataC(List<String> AzafataC) {

        /*LISTA AZAFATA COMIDA*/
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("Comida")) {
                AzafataC.add("\nCARGO DE " + listaAzafata.get(i).getClass().getSimpleName()
                        + "\nRUTA: " + listaAzafata.get(i).getRutasDesignada()
                        + "\nPLATO: " + ((Comida) listaAzafata.get(i)).getPlato()
                        + "\nHORARIO DE COMIDA: " + ((Comida) listaAzafata.get(i)).getHorarioComida()
                        + "\nTIPO DE COMIDA: " + ((Comida) listaAzafata.get(i)).getTipoComida()
                        + "\nSUELDO: " + listaAzafata.get(i).getSueldo()
                        + "\nTURNO: " + listaAzafata.get(i).getTurno()
                        + "\nNOMBRE: " + listaAzafata.get(i).getNombre()
                        + "\nAPELLIDO: " + listaAzafata.get(i).getApellido()
                        + "\nEDAD: " + listaAzafata.get(i).getEdad()
                        + "\nNUMERO DE DOCUMENTO: " + listaAzafata.get(i).getCedula() + "\n\n");
            }
        }
        return AzafataC;
    }

    public String mostrar_LAzafataS() {

        /*SE CREA UNA METODO TIPO STRING EN EL CUAL SE CREA LISTA LA CUAL CONTENDRA TODA LA INFORMACION 
            ACERCA DE LOS DATOS DE EL TRABAJADOR TIPO AZAFATA DE SEGURIDAD. EL CUAL SE ENVIARA AL JFRAME*/
        List<String> trabajadorAzaS = new ArrayList<String>();
        //SE MANDA POR PARAMETRO A EL METODO DE LISTA AZAFATA DE SEGURIDAD
        trabajadorAzaS = mostrar_AzafataS(trabajadorAzaS);
        String texto = "\n\n";

        for (String item : trabajadorAzaS) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_AzafataS(List<String> AzafataS) {

        /*LISTA AZAFATA SEGURIDAD*/
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("Seguridad")) {
                AzafataS.add("\nCARGO DE " + listaAzafata.get(i).getClass().getSimpleName()
                        + "\nRUTA: " + listaAzafata.get(i).getRutasDesignada()
                        + "\nHORA DE INSTRUCCIONES: " + ((Seguridad) listaAzafata.get(i)).getHorarioInstrucci()
                        + "\nCHEQUEO DE PUERTAS: " + ((Seguridad) listaAzafata.get(i)).getChequeoPuertas()
                        + "\nSUELDO: " + listaAzafata.get(i).getSueldo()
                        + "\nTURNO: " + listaAzafata.get(i).getTurno()
                        + "\nNOMBRE: " + listaAzafata.get(i).getNombre()
                        + "\nAPELLIDO: " + listaAzafata.get(i).getApellido()
                        + "\nEDAD: " + listaAzafata.get(i).getEdad()
                        + "\nNUMERO DE DOCUMENTO: " + listaAzafata.get(i).getCedula() + "\n\n");
            }
        }
        return AzafataS;
    }

    public String mostrar_LAzafataAten() {

        /*SE CREA UNA METODO TIPO STRING EN EL CUAL SE CREA LISTA LA CUAL CONTENDRA TODA LA INFORMACION 
            ACERCA DE LOS DATOS DE EL TRABAJADOR TIPO AZAFATA DE COMIDA. EL CUAL SE ENVIARA AL JFRAME*/
        List<String> trabajadorAzaAt = new ArrayList<String>();
        //SE MANDA POR PARAMETRO A EL METODO DE LISTA AZAFATA DE COMIDA
        trabajadorAzaAt = mostrar_AzafataAte(trabajadorAzaAt);
        String texto = "\n\n";

        for (String item : trabajadorAzaAt) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_AzafataAte(List<String> AzafataAte) {

        //LISTA AZAFATA DE ATENCION AL CLIENTE
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("AtencionCliente")) {
                AzafataAte.add("\nCARGO DE " + listaAzafata.get(i).getClass().getSimpleName()
                        + "\nRUTA: " + listaAzafata.get(i).getRutasDesignada()
                        + "\nHORA DE ATENCIÓN: " + ((AtencionCliente) listaAzafata.get(i)).getHoraAtencion()
                        + "\nSUELDO: " + listaAzafata.get(i).getSueldo()
                        + "\nTURNO: " + listaAzafata.get(i).getTurno()
                        + "\nNOMBRE: " + listaAzafata.get(i).getNombre()
                        + "\nAPELLIDO: " + listaAzafata.get(i).getApellido()
                        + "\nEDAD: " + listaAzafata.get(i).getEdad()
                        + "\nNUMERO DE DOCUMENTO: " + listaAzafata.get(i).getCedula() + "\n\n");
            }
        }
        return AzafataAte;
    }

    public String mostrar_CodigoVueloPasajeros() {

        //SE MUESTRA LOS CODIGOS DE TAN SOLO VUELO DE PASAJEROS Y SE GUARDAN EN UNA LISTA. PARA ENVIARLA COMO TIPO STRING A JFRAME
        List<String> codigoP = new ArrayList<String>();
        codigoP = mostrar_codigoP(codigoP);
        String texto = "\n    LOS CODIGOS VUELOS DE PASA. SON:\n\n";

        for (String item : codigoP) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_codigoP(List<String> codigoP) {

        //LISTA CODIGOS VUELO PASAJEROS
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("DePasajeros")) {
                codigoP.add("                " + (i + 1) + ". " + "CODIGO " + ((DePasajeros) listaVuelos.get(i)).getCodigo()+ "\n");
            }
        }
        return codigoP;
    }

    public String mostrar_CodigoVueloCarga() {

        //SE MUESTRA LOS CODIGOS DE TAN SOLO VUELO DE CARGA Y SE GUARDAN EN UNA LISTA. PARA ENVIARLA COMO TIPO STRING A JFRAME
        List<String> codigoC = new ArrayList<String>();
        codigoC = mostrar_codigoC(codigoC);
        String texto = "\n    LOS CODIGOS VUELOS DE CARGA SON:\n\n";

        for (String item : codigoC) {
            texto = texto + item;
            
        }

        return texto;
    }

    public List<String> mostrar_codigoC(List<String> CodigoC) {

        //LISTA CODIGOS VUELO CARGA
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("DeCarga")) {
                CodigoC.add("                " + (i + 1) + ". " + "CODIGO " + ((DeCarga) listaVuelos.get(i)).getCodigo() + "\n");
            }
        }
        return CodigoC;
    }

    public String mostrar_CodigoVueloHuman() {

        //SE MUESTRA LOS CODIGOS DE TAN SOLO VUELO DE HUMANITARIO Y SE GUARDAN EN UNA LISTA. PARA ENVIARLA COMO TIPO STRING A JFRAME
        List<String> codigoH = new ArrayList<String>();
        codigoH = mostrar_codigoH(codigoH);
        String texto = "\n    LOS CODIGOS VUELOS HUMA. SON:\n\n";

        for (String item : codigoH) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_codigoH(List<String> CodigoH) {

        //LISTA CODIGOS VUELO HUMANITARIO
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("Humanitario")) {
                CodigoH.add("                " + (i + 1) + ". " + "CODIGO " + ((Humanitario) listaVuelos.get(i)).getCodigo() + "\n");
            }
        }
        return CodigoH;
    }

    public String mostrar_CodigoVueloMixto() {

        //SE MUESTRA LOS CODIGOS DE TAN SOLO VUELO DE MIXTO Y SE GUARDAN EN UNA LISTA. PARA ENVIARLA COMO TIPO STRING A JFRAME
        List<String> codigoM = new ArrayList<String>();
        codigoM = mostrar_codigoM(codigoM);
        String texto = "\n   LOS CODIGOS VUELOS MIXTOS SON:\n\n";

        for (String item : codigoM) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_codigoM(List<String> CodigoC) {

        //LISTA CODIGOS VUELO MIXTO
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("Mixto")) {
                CodigoC.add("              " + (i + 1) + ". " + "CODIGO " + ((Mixto) listaVuelos.get(i)).getCodigo() + "\n");
            }
        }
        return CodigoC;
    }

    public String mostrar_CodigoAzafataC() {

        //SE MUESTRA LOS CODIGOS DE TAN SOLO AZAFATA COMIDA Y SE GUARDAN EN UNA LISTA. PARA ENVIARLA COMO TIPO STRING A JFRAME
        List<String> codigoAC = new ArrayList<String>();
        codigoAC = mostrar_CAzafataC(codigoAC);
        String texto = "\n      LAS AZAFATAS DE COMIDAS SON: \n\n";

        for (String item : codigoAC) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_CAzafataC(List<String> CodigoAzC) {

        //LISTA CODIGOS AZAFATA COMIDA
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("Comida")) {
                CodigoAzC.add("              " + (i + 1) + ". CEDULA " + listaAzafata.get(i).getCedula() + "\n");
            }
        }
        return CodigoAzC;
    }

    public String mostrar_CodigoAzafataS() {

        //SE MUESTRA LOS CODIGOS DE TAN SOLO AZAFATA SEGURIDAD Y SE GUARDAN EN UNA LISTA. PARA ENVIARLA COMO TIPO STRING A JFRAME
        List<String> codigoAS = new ArrayList<String>();
        codigoAS = mostrar_CAzafataS(codigoAS);
        String texto = "\n      LAS AZAFATAS DE SEGURIDAD SON: \n\n";

        for (String item : codigoAS) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_CAzafataS(List<String> CodigoAzS) {

        //LISTA CODIGOS AZAFATA SEGURIDAD
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("Seguridad")) {
                CodigoAzS.add("              " + (i + 1) + ". CEDULA " + listaAzafata.get(i).getCedula() + "\n");
            }
        }
        return CodigoAzS;
    }

    public String mostrar_CodigoAzafataAt() {

        //SE MUESTRA LOS CODIGOS DE TAN SOLO AZAFATA ATENCION AL CLIENTE Y SE GUARDAN EN UNA LISTA. PARA ENVIARLA COMO TIPO STRING A JFRAME
        List<String> codigoAAten = new ArrayList<String>();
        codigoAAten = mostrar_CAzafataAt(codigoAAten);
        String texto = "\n    LAS AZAFATAS DE ATEN. CLIENTE SON: \n\n";

        for (String item : codigoAAten) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_CAzafataAt(List<String> CodigoAzAt) {

        //LISTA CODIGOS AZAFATA ATENCION AL CLIENTE
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("AtencionCliente")) {
                CodigoAzAt.add("              " + (i + 1) + ". CEDULA " + listaAzafata.get(i).getCedula() + "\n");
            }
        }
        return CodigoAzAt;
    }

    public String mostrar_CodigoPiloto() {

        //SE MUESTRA LOS CODIGOS DE TAN SOLO PILOTOS Y SE GUARDAN EN UNA LISTA. PARA ENVIARLA COMO TIPO STRING A JFRAME
        List<String> codigoPiloto = new ArrayList<String>();
        codigoPiloto = mostrar_CPiloto(codigoPiloto);
        String texto = "\n       LOS PILOTOS SON: \n\n";

        for (String item : codigoPiloto) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_CPiloto(List<String> codigoPiloto) {

        //LISTA CODIGOS DE PILOTOS
        for (int i = 0; i < listaPilotos.size(); i++) {
            codigoPiloto.add("              " + (i + 1) + ". CEDULA " + listaPilotos.get(i).getCedula() + "\n");
        }
        return codigoPiloto;
    }

    public String mostrarRutas() {

        //SE MUESTRA LAS RUTAS Y SE GUARDAN EN UNA LISTA. PARA ENVIARLA COMO TIPO STRING A JFRAME
        List<String> rutas = new ArrayList<String>();
        rutas = mostrar_Rutas(rutas);
        String texto = "\n\n";

        for (String item : rutas) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_Rutas(List<String> rutas) {

        //LISTA RUTAS
        for (int i = 0; i < listaRutas.size(); i++) {
            rutas.add("\nNÚMERO DE RUTA: " + (i + 1)
                    + "\nORIGEN DEL VUELO: " + listaRutas.get(i).getOrigen()
                    + "\nDESTINO DEL VUELO: " + listaRutas.get(i).getDestino()
                    + "\nCODIGO DEL RUTA " + listaRutas.get(i).getCodigo()
                    + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo() + "\n\n");
        }
        return rutas;
    }

    public void generarTxtVuelos(List<String> vuelo) {

        /*SE GENERA TXT CON TODOS LOS DATOS DE LA LISTA VUELOS ATRIBUTOS DE CADA VUELO(DE PASAJEROS,DE CARGA, HUMANITARIO Y MIXTO)*/
        vuelo.add("LOS VUELOS SON: \n");
        for (int i = 0; i < listaVuelos.size(); i++) {

            if (listaVuelos.get(i).getClass().getSimpleName().equals("DePasajeros")) {

                vuelo.add("\nCANTIDAD PASAJEROS: " + ((DePasajeros) listaVuelos.get(i)).getCantidadPasajeros()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nTIPO DE VUELO: " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nPRECIO: " + listaVuelos.get(i).getPrecio() + "\n\n");
            } else if (listaVuelos.get(i).getClass().getSimpleName().equals("DeCarga")) {
                vuelo.add("\nNOMBRE PRODUCTO: " + ((DeCarga) listaVuelos.get(i)).getNombreProducto()
                        + "\nPESO: " + ((DeCarga) listaVuelos.get(i)).getPeso()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nTIPO DE VUELO: " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nPRECIO: " + listaVuelos.get(i).getPrecio() + "\n\n");
            } else if (listaVuelos.get(i).getClass().getSimpleName().equals("Humanitario")) {
                vuelo.add("\nDESCRIPCION: " + ((Humanitario) listaVuelos.get(i)).getDescriOperacion()
                        + "\nNUMERO DE PERSONAS: " + ((Humanitario) listaVuelos.get(i)).getCantidadPersonasH()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nTIPO DE VUELO: " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nVUELO NO TIENE PRECIO (GRATIS)\n\n");
            } else if (listaVuelos.get(i).getClass().getSimpleName().equals("Mixto")) {
                vuelo.add("\nTIPO VUELO: " + ((Mixto) listaVuelos.get(i)).getTipoVuelo()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nTIPO DE VUELO: " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nPRECIO: " + listaVuelos.get(i).getPrecio() + "\n\n");
            }
        }
    }

    public void generarTxtTrab(List<String> trabajadores) {
        /*SE GENERA TXT CON TODOS LOS DATOS DE LA LISTA DE AZAFATAS ATRIBUTOS DE CADA AZAFATA(DE COMIDA,DE SEGURIDAD Y ATENCIÓN AL CLIENTE)*/
        trabajadores.add("LAS AZAFATAS SON: \n\n");

        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("Comida")) {
                trabajadores.add("\nCARGO DE " + listaAzafata.get(i).getClass().getSimpleName()
                        + "\nRUTA: " + listaAzafata.get(i).getRutasDesignada()
                        + "\nPLATO: " + ((Comida) listaAzafata.get(i)).getPlato()
                        + "\nHORARIO DE COMIDA: " + ((Comida) listaAzafata.get(i)).getHorarioComida()
                        + "\nTIPO DE COMIDA: " + ((Comida) listaAzafata.get(i)).getTipoComida()
                        + "\nSUELDO: " + listaAzafata.get(i).getSueldo()
                        + "\nTURNO: " + listaAzafata.get(i).getTurno()
                        + "\nNOMBRE: " + listaAzafata.get(i).getNombre()
                        + "\nAPELLIDO: " + listaAzafata.get(i).getApellido()
                        + "\nEDAD: " + listaAzafata.get(i).getEdad()
                        + "\nNUMERO DE DOCUMENTO: " + listaAzafata.get(i).getCedula());
            } else if (listaAzafata.get(i).getClass().getSimpleName().equals("Seguridad")) {
                trabajadores.add("\nCARGO DE " + listaAzafata.get(i).getClass().getSimpleName()
                        + "\nRUTA: " + listaAzafata.get(i).getRutasDesignada()
                        + "\nHORA DE INSTRUCCIONES: " + ((Seguridad) listaAzafata.get(i)).getHorarioInstrucci()
                        + "\nCHEQUEO DE PUERTAS: " + ((Seguridad) listaAzafata.get(i)).getChequeoPuertas()
                        + "\nSUELDO: " + listaAzafata.get(i).getSueldo()
                        + "\nTURNO: " + listaAzafata.get(i).getTurno()
                        + "\nNOMBRE: " + listaAzafata.get(i).getNombre()
                        + "\nAPELLIDO: " + listaAzafata.get(i).getApellido()
                        + "\nEDAD: " + listaAzafata.get(i).getEdad()
                        + "\nNUMERO DE DOCUMENTO: " + listaAzafata.get(i).getCedula());
            } else if (listaAzafata.get(i).getClass().getSimpleName().equals("AtencionCliente")) {
                trabajadores.add("\nCARGO DE " + listaAzafata.get(i).getClass().getSimpleName()
                        + "\nRUTA: " + listaAzafata.get(i).getRutasDesignada()
                        + "\nHORA DE ATENCIÓN: " + ((AtencionCliente) listaAzafata.get(i)).getHoraAtencion()
                        + "\nSUELDO: " + listaAzafata.get(i).getSueldo()
                        + "\nTURNO: " + listaAzafata.get(i).getTurno()
                        + "\nNOMBRE: " + listaAzafata.get(i).getNombre()
                        + "\nAPELLIDO: " + listaAzafata.get(i).getApellido()
                        + "\nEDAD: " + listaAzafata.get(i).getEdad()
                        + "\nNUMERO DE DOCUMENTO: " + listaAzafata.get(i).getCedula());
            }
        }
        for (int i = 0; i < listaPilotos.size(); i++) {
            trabajadores.add("\nNOMBRE PILOTO: " + listaPilotos.get(i).getNombre()
                    + "\nAPELLIDO PILOTO: " + listaPilotos.get(i).getApellido()
                    + "\nRUTA: " + listaPilotos.get(i).getRutasDesignada()
                    + "\nSUELDO: " + listaPilotos.get(i).getSueldo()
                    + "\nEDAD: " + listaPilotos.get(i).getEdad()
                    + "\nNUMERO DE DOCUMENTO: " + listaPilotos.get(i).getCedula());
        }
    }
public String mostrar_CodC() {

        //SE MUESTRA LOS CODIGOS DE TAN SOLO PILOTOS Y SE GUARDAN EN UNA LISTA. PARA ENVIARLA COMO TIPO STRING A JFRAME
        List<String> comida = new ArrayList<String>();
        comida = mostrar_CJCROLL(comida);
        String texto = "\n\n   LAS AZAFATAS DE COMIDA SIN LABOR SON: \n\n\n";

        for (String item : comida) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_CJCROLL(List<String> comida) {

        //LISTA CODIGOS DE PILOTOS
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("Comida")) {
                if (((Comida) listaAzafata.get(i)).getPlato()== null) {
                    comida.add("\n                        " +(i+1)+".  "+ listaAzafata.get(i).getCedula());
                }
            }
        }
        return comida;
    }
        
 public String mostrar_CodS() {

        //SE MUESTRA LOS CODIGOS DE TAN SOLO PILOTOS Y SE GUARDAN EN UNA LISTA. PARA ENVIARLA COMO TIPO STRING A JFRAME
        List<String> seguridad = new ArrayList<String>();
        seguridad = mostrar_SJCROLL(seguridad);
        String texto = "\n\n   LAS AZAFATAS DE COMIDA SIN LABOR SON: \n\n\n";

        for (String item : seguridad) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_SJCROLL(List<String> seguridad) {

        //LISTA CODIGOS DE PILOTOS
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("Seguridad")) {
                if (((Seguridad) listaAzafata.get(i)).getHorarioInstrucci()== null) {
                    seguridad.add("\n                        " +(i+1)+".  "+ listaAzafata.get(i).getCedula());
                }
            }
        }
        return seguridad;
    }
    
    public String mostrar_CodAten() {

        //SE MUESTRA LOS CODIGOS DE TAN SOLO PILOTOS Y SE GUARDAN EN UNA LISTA. PARA ENVIARLA COMO TIPO STRING A JFRAME
        List<String> atencion = new ArrayList<String>();
        atencion = mostrar_AtenJCROLL(atencion);
        String texto = "\n\n   LAS AZAFATAS DE COMIDA SIN LABOR SON: \n\n\n";

        for (String item : atencion) {
            texto = texto + item;
        }

        return texto;
    }

    public List<String> mostrar_AtenJCROLL(List<String> atencion) {

        //LISTA CODIGOS DE PILOTOS
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("AtencionCliente")) {
                if (((AtencionCliente) listaAzafata.get(i)).getHoraAtencion()== null) {
                    atencion.add("\n                        " +(i+1)+".  "+ listaAzafata.get(i).getCedula());
                }
            }
        }
        return atencion;
    }
   
    /*SE REALIZA LAS SIGUIENTES LINEAS DE CODIGO PARA PODER MANEJAR EL PROGRAMA AL IGUAL POR CONSOLA*/
    public void mostrarVPasajeros() {

        //SE MUESTRA TODOS LOS ATRIBUTOS DE VUELO PASAJEROS CARGADO CON LA INFROMACION DIGITADA POR CONSOLA
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("DePasajeros")) {
                System.out.println("\nCANTIDAD PASAJEROS: " + ((DePasajeros) listaVuelos.get(i)).getCantidadPasajeros()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nVUELO " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nPRECIO: " + listaVuelos.get(i).getPrecio());
            }
        }
    }

    public void mostrarVCarga() {

        //SE MUESTRA TODOS LOS ATRIBUTOS DE VUELO CARGA CARGADO CON LA INFROMACION DIGITADA POR CONSOLA
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("DeCarga")) {
                System.out.println("\nNOMBRE PRODUCTO: " + ((DeCarga) listaVuelos.get(i)).getNombreProducto()
                        + "\nPESO: " + ((DeCarga) listaVuelos.get(i)).getPeso() + " TONELADAS"
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nVUELO " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nPRECIO: " + listaVuelos.get(i).getPrecio());
            }
        }
    }

    public void mostrarVHumanitario() {

        //SE MUESTRA TODOS LOS ATRIBUTOS DE VUELO HUMANITARIO CARGADO CON LA INFROMACION DIGITADA POR CONSOLA
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("Humanitario")) {
                System.out.println("\nDESCRIPCION: " + ((Humanitario) listaVuelos.get(i)).getDescriOperacion()
                        + "\nNUMERO DE PERSONAS: " + ((Humanitario) listaVuelos.get(i)).getCantidadPersonasH()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nVUELO " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nVUELO NO TIENE PRECIO (GRATIS)");
            }
        }
    }

    public void mostrarVMixto() {

        //SE MUESTRA TODOS LOS ATRIBUTOS DE VUELO MIXTO CARGADO CON LA INFROMACION DIGITADA POR CONSOLA
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("Mixto")) {
                System.out.println("\nTIPO VUELO: " + ((Mixto) listaVuelos.get(i)).getTipoVuelo()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nVUELO " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nPRECIO: " + listaVuelos.get(i).getPrecio());
            }
        }
    }

    public void mostrarPiloto() {

        //SE MUESTRA TODOS LOS ATRIBUTOS DE PILOTO CARGADO CON LA INFROMACION DIGITADA POR CONSOLA
        System.out.println("LOS PILOTOS SON: \n");

        for (int i = 0; i < listaPilotos.size(); i++) {
            System.out.println("\nRUTA: " + listaPilotos.get(i).getRutasDesignada()
                    + "\nSUELDO: " + listaPilotos.get(i).getSueldo()
                    + "\nNOMBRE: " + listaPilotos.get(i).getNombre()
                    + "\nAPELLIDO: " + listaPilotos.get(i).getApellido()
                    + "\nEDAD: " + listaPilotos.get(i).getEdad()
                    + "\nNUMERO DE DOCUMENTO: " + listaPilotos.get(i).getCedula());
        }
    }

    public void mostrarListAzafatas() {

        //SE MUESTRA TODOS LOS ATRIBUTOS DE AZAFATAS CARGADO CON LA INFROMACION DIGITADA POR CONSOLA
        System.out.println("LAS AZAFATAS SON: \n");

        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("Comida")) {
                System.out.println("\nCARGO DE " + listaAzafata.get(i).getClass().getSimpleName()
                        + "\nRUTA: " + listaAzafata.get(i).getRutasDesignada()
                        + "\nPLATO: " + ((Comida) listaAzafata.get(i)).getPlato()
                        + "\nHORARIO DE COMIDA: " + ((Comida) listaAzafata.get(i)).getHorarioComida()
                        + "\nTIPO DE COMIDA: " + ((Comida) listaAzafata.get(i)).getTipoComida()
                        + "\nSUELDO: " + listaAzafata.get(i).getSueldo()
                        + "\nTURNO: " + listaAzafata.get(i).getTurno()
                        + "\nNOMBRE: " + listaAzafata.get(i).getNombre()
                        + "\nAPELLIDO: " + listaAzafata.get(i).getApellido()
                        + "\nEDAD: " + listaAzafata.get(i).getEdad()
                        + "\nNUMERO DE DOCUMENTO: " + listaAzafata.get(i).getCedula());
            } else if (listaAzafata.get(i).getClass().getSimpleName().equals("Seguridad")) {
                System.out.println("\nCARGO DE " + listaAzafata.get(i).getClass().getSimpleName()
                        + "\nRUTA: " + listaAzafata.get(i).getRutasDesignada()
                        + "\nHORA DE INSTRUCCIONES: " + ((Seguridad) listaAzafata.get(i)).getHorarioInstrucci()
                        + "\nCHEQUEO DE PUERTAS: " + ((Seguridad) listaAzafata.get(i)).getChequeoPuertas()
                        + "\nSUELDO: " + listaAzafata.get(i).getSueldo()
                        + "\nTURNO: " + listaAzafata.get(i).getTurno()
                        + "\nNOMBRE: " + listaAzafata.get(i).getNombre()
                        + "\nAPELLIDO: " + listaAzafata.get(i).getApellido()
                        + "\nEDAD: " + listaAzafata.get(i).getEdad()
                        + "\nNUMERO DE DOCUMENTO: " + listaAzafata.get(i).getCedula());
            } else if (listaAzafata.get(i).getClass().getSimpleName().equals("AtencionCliente")) {
                System.out.println("\nCARGO DE " + listaAzafata.get(i).getClass().getSimpleName()
                        + "\nRUTA: " + listaAzafata.get(i).getRutasDesignada()
                        + "\nHORA DE ATENCIÓN: " + ((AtencionCliente) listaAzafata.get(i)).getHoraAtencion()
                        + "\nSUELDO: " + listaAzafata.get(i).getSueldo()
                        + "\nTURNO: " + listaAzafata.get(i).getTurno()
                        + "\nNOMBRE: " + listaAzafata.get(i).getNombre()
                        + "\nAPELLIDO: " + listaAzafata.get(i).getApellido()
                        + "\nEDAD: " + listaAzafata.get(i).getEdad()
                        + "\nNUMERO DE DOCUMENTO: " + listaAzafata.get(i).getCedula());
            }
        }
    }

    public void mostrarCodigoVuelos(int codigo) {

        //SE MUESTRA TODOS LOS CODIGOS DE LOS VUELOS
        System.out.println("LOS CODIGOS DE LOS VUELOS SON: \n");

        for (int i = 0; i < listaVuelos.size(); i++) {
            System.out.println((i + 1) + ". " + "CODIGO " + listaVuelos.get(i).getCodigo());
        }
    }

    public void mostrarCodigoVueloPasajeros() {

        //SE MUESTRA SOLAMENTE LOS CODIGOS DE EL VUELO DE PASAJEROS
        System.out.println("LOS CODIGOS DE LOS VUELOS SON: \n");

        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("DePasajeros")) {
                System.out.println((i + 1) + ". " + "CODIGO " + ((DePasajeros) listaVuelos.get(i)).getCodigo());
            }
        }
    }

    public void mostrarCodigoVueloCarga() {

        //SE MUESTRA SOLAMENTE LOS CODIGOS DE EL VUELO DE CARGA
        System.out.println("LOS CODIGOS DE LOS VUELOS SON: \n");

        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("DeCarga")) {
                System.out.println((i + 1) + ". " + "CODIGO " + ((DeCarga) listaVuelos.get(i)).getCodigo());
            }
        }
    }

    public void mostrarCodigoVueloHuman() {

        //SE MUESTRA SOLAMENTE LOS CODIGOS DE EL VUELO HUMANITARIO
        System.out.println("LOS CODIGOS DE LOS VUELOS SON: \n");

        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("Humanitario")) {
                System.out.println((i + 1) + ". " + "CODIGO " + ((Humanitario) listaVuelos.get(i)).getCodigo());
            }
        }
    }

    public void mostrarCodigoVueloMixto() {

        //SE MUESTRA SOLAMENTE LOS CODIGOS DE EL VUELO MIXTO
        System.out.println("LOS CODIGOS DE LOS VUELOS SON: \n");

        for (int i = 0; i < listaVuelos.size(); i++) {
            if (listaVuelos.get(i).getClass().getSimpleName().equals("Mixto")) {
                System.out.println((i + 1) + ". " + "CODIGO " + ((Mixto) listaVuelos.get(i)).getCodigo());
            }
        }
    }

    public void Buscar_VueloPasa(int codigo) {

        //SE VERIFICA SI EL DATO INGRESADO PARA BUSCAR VUELO ES CORRECTO MUESTRE LOS ATRIBUTOS DE ESA CLASE
        boolean verificar = true;
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (codigo == (((DePasajeros) listaVuelos.get(i)).getCodigo())) {
                System.out.println("\n\n--------------PERFECTO!!!!----------------\n"
                        + "\nCANTIDAD PASAJEROS: " + ((DePasajeros) listaVuelos.get(i)).getCantidadPasajeros()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nVUELO " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA " + listaVuelos.get(i).getHorario()
                        + "\nCLASE " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nPRECIO " + listaVuelos.get(i).getPrecio());
            }
            verificar = false;
        }
        if (verificar == true) {
            System.out.println("\n\n-----------LO SENTIMOS EL VUELO NO EXISTE-------------\n\n");
        }

    }

    public void Buscar_VueloCarg(int codigo) {

        //SE VERIFICA SI EL DATO INGRESADO PARA BUSCAR VUELO ES CORRECTO MUESTRE LOS ATRIBUTOS DE ESA CLASE
        boolean verificar = true;
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (codigo == (((DeCarga) listaVuelos.get(i)).getCodigo())) {
                System.out.println("\nNOMBRE PRODUCTO: " + ((DeCarga) listaVuelos.get(i)).getNombreProducto()
                        + "\nPESO: " + ((DeCarga) listaVuelos.get(i)).getPeso() + " TONELADAS"
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nVUELO " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nPRECIO: " + listaVuelos.get(i).getPrecio());

            }
            verificar = false;
        }
        if (verificar == true) {
            System.out.println("\n\n-----------LO SENTIMOS EL VUELO NO EXISTE-------------\n\n");
        }
    }

    public void Buscar_VueloHum(int codigo) {

        //SE VERIFICA SI EL DATO INGRESADO PARA BUSCAR VUELO ES CORRECTO MUESTRE LOS ATRIBUTOS DE ESA CLASE
        boolean verificar = true;
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (codigo == (((Humanitario) listaVuelos.get(i)).getCodigo())) {
                System.out.println("\nDESCRIPCION: " + ((Humanitario) listaVuelos.get(i)).getDescriOperacion()
                        + "\nNUMERO DE PERSONAS: " + ((Humanitario) listaVuelos.get(i)).getCantidadPersonasH()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nVUELO " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nVUELO NO TIENE PRECIO (GRATIS)");

            }
            verificar = false;
        }
        if (verificar == true) {
            System.out.println("\n\n-----------LO SENTIMOS EL VUELO NO EXISTE-------------\n\n");
        }

    }

    public void Buscar_VueloMix(int codigo) {

        //SE VERIFICA SI EL DATO INGRESADO PARA BUSCAR VUELO ES CORRECTO MUESTRE LOS ATRIBUTOS DE ESA CLASE
        boolean verificar = true;
        for (int i = 0; i < listaVuelos.size(); i++) {
            if (codigo == (((Mixto) listaVuelos.get(i)).getCodigo())) {
                System.out.println("\nTIPO VUELO: " + ((Mixto) listaVuelos.get(i)).getTipoVuelo()
                        + "\nRUTA: " + listaVuelos.get(i).getRuta()
                        + "\nCODIGO VUELO: " + listaVuelos.get(i).getCodigo()
                        + "\nVUELO " + listaVuelos.get(i).getClass().getSimpleName()
                        + "\nFECHA: " + listaVuelos.get(i).getHorario()
                        + "\nCLASE: " + listaVuelos.get(i).getClaseVuelo()
                        + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                        + "\nTIEMPO RUTA: " + listaVuelos.get(i).getTiempoVuelo()
                        + "\nPRECIO: " + listaVuelos.get(i).getPrecio());
            }
            verificar = false;
        }
        if (verificar == true) {
            System.out.println("\n\n-----------LO SENTIMOS EL VUELO NO EXISTE-------------\n\n");
        }
    }

    public void Buscar_Piloto(int cc) {
        try {
            //SE VERIFICA SI EL DATO INGRESADO PARA BUSCAR PILOTO ES CORRECTO MUESTRE LOS ATRIBUTOS DE ESA CLASE
            boolean falla = true;
            System.out.println("LOS PILOTOS SON: \n");
            for (int i = 0; i < listaPilotos.size(); i++) {
                System.out.println((i + 1) + ". " + listaPilotos.get(i).getCedula());
            }

            for (int i = 0; i < listaPilotos.size(); i++) {
                if (cc == listaPilotos.get(i).getCedula()) {
                    System.out.println("\n\n--------------PERFECTO!!!!----------------\n"
                            + "\nRUTA: " + listaPilotos.get(i).getRutasDesignada()
                            + "\nSUELDO: " + ((Piloto) listaPilotos.get(i)).getSueldo()
                            + "\nNOMBRE: " + listaPilotos.get(i).getNombre()
                            + "\nAPELLIDO: " + listaPilotos.get(i).getApellido()
                            + "\nEDAD: " + listaPilotos.get(i).getEdad()
                            + "\nNUMERO DE DOCUMENTO: " + listaPilotos.get(i).getCedula());
                }
                falla = false;
            }

            if (falla == true) {
                System.out.println("\n\n-----------LO SENTIMOS EL PILOTO NO EXISTE-------------\n\n");
            }

        } catch (Exception e) {
            System.err.println("Error. Aborted system is: " + e.toString());
        }
    }

    public void mostrar_AzafataComida() {

        //SE MUESTRA SOLAMENTE LOS CODIGOS DE LA AZAFATA COMIDA
        System.out.println("LAS AZAFATAS SON: \n");
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("Comida")) {
                System.out.println((i + 1) + ". " + listaAzafata.get(i).getCedula());
            }
        }
    }

    public void mostrar_AzafataSeguridad() {

        //SE MUESTRA SOLAMENTE LOS CODIGOS DE LA AZAFATA SEGURIDAD
        System.out.println("LAS AZAFATAS SON: \n");
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("Seguridad")) {
                System.out.println((i + 1) + ". " + listaAzafata.get(i).getCedula());
            }
        }
    }

    public void mostrar_AzafataAtencion() {

        //SE MUESTRA SOLAMENTE LOS CODIGOS DE LA AZAFATA DE ATENCION AL CLIENTE
        System.out.println("LAS AZAFATAS SON: \n");
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("AtencionCliente")) {
                System.out.println((i + 1) + ". " + listaAzafata.get(i).getCedula());
            }
        }
    }

    public int buscar_AzafataComida(int cc) {

        //SE VERIFICA SI EL DATO INGRESADO PARA BUSCAR AZAFATA COMIDA ES CORRECTO MUESTRE LOS ATRIBUTOS DE ESA CLASE 
        boolean falla = true;
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (cc == ((Comida) listaAzafata.get(i)).getCedula()) {
                System.out.println("\n\n--------------PERFECTO!!!!----------------\n"
                        + "\nCARGO DE " + listaAzafata.get(i).getClass().getSimpleName()
                        + "\nRUTA: " + listaAzafata.get(i).getRutasDesignada()
                        + "\nSUELDO: " + listaAzafata.get(i).getSueldo()
                        + "\nTURNO: " + listaAzafata.get(i).getTurno()
                        + "\nNOMBRE: " + listaAzafata.get(i).getNombre()
                        + "\nAPELLIDO: " + listaAzafata.get(i).getApellido()
                        + "\nEDAD: " + listaAzafata.get(i).getEdad()
                        + "\nNUMERO DE DOCUMENTO: " + listaAzafata.get(i).getCedula());
                return i;
            }
            falla = false;

        }

        if (falla == true) {
            System.out.println("\n\n-----------LO SENTIMOS EL AZAFATA NO EXISTE-------------\n\n");
        }
        return -1;
    }

    public int buscar_AzafataSeguridad(int cc) {

        //SE VERIFICA SI EL DATO INGRESADO PARA BUSCAR AZAFATA SEGURIDAD ES CORRECTO MUESTRE LOS ATRIBUTOS DE ESA CLASE 
        boolean falla = true;
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (cc == listaAzafata.get(i).getCedula()) {
                System.out.println("\n\n--------------PERFECTO!!!!----------------\n"
                        + "\nCARGO DE " + listaAzafata.get(i).getClass().getSimpleName()
                        + "\nRUTA: " + listaAzafata.get(i).getRutasDesignada()
                        + "\nSUELDO: " + listaAzafata.get(i).getSueldo()
                        + "\nTURNO: " + listaAzafata.get(i).getTurno()
                        + "\nNOMBRE: " + listaAzafata.get(i).getNombre()
                        + "\nAPELLIDO: " + listaAzafata.get(i).getApellido()
                        + "\nEDAD: " + listaAzafata.get(i).getEdad()
                        + "\nNUMERO DE DOCUMENTO: " + listaAzafata.get(i).getCedula());
                return i;
            }
            falla = false;
        }

        if (falla == true) {
            System.out.println("\n\n-----------LO SENTIMOS EL AZAFATA NO EXISTE-------------\n\n");
        }
        return -1;
    }

    public int buscar_AzafataAtencion(int cc) {

        //SE VERIFICA SI EL DATO INGRESADO PARA BUSCAR AZAFATA ATENCION AL CLIENTE ES CORRECTO MUESTRE LOS ATRIBUTOS DE ESA CLASE 
        boolean falla = true;
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (cc == listaAzafata.get(i).getCedula()) {
                System.out.println("\n\n--------------PERFECTO!!!!----------------\n"
                        + "\nCARGO DE " + listaAzafata.get(i).getClass().getSimpleName()
                        + "\nRUTA: " + listaAzafata.get(i).getRutasDesignada()
                        + "\nSUELDO: " + listaAzafata.get(i).getSueldo()
                        + "\nTURNO: " + listaAzafata.get(i).getTurno()
                        + "\nNOMBRE: " + listaAzafata.get(i).getNombre()
                        + "\nAPELLIDO: " + listaAzafata.get(i).getApellido()
                        + "\nEDAD: " + listaAzafata.get(i).getEdad()
                        + "\nNUMERO DE DOCUMENTO: " + listaAzafata.get(i).getCedula());
                return i;
            }
            falla = false;
        }

        if (falla == true) {
            System.out.println("\n\n-----------LO SENTIMOS EL AZAFATA NO EXISTE-------------\n\n");
        }
        return -1;
    }

    public void actualizar_DatosVueloPasaje(int actualizar, int cantidadP, String ruta, Date fecha, String clase, int codigoV, int codigoR, String tiempoVuelo, int precio) {
        try {

            //SE ENVIA POR PARAMETRO A LA POSICIÓN DEL VUELO QUE ESCOGIO UN NUEVO PARAMETRO DE CADA ATRIBUTO.
            System.out.println(listaVuelos.get(actualizar - 1).getCodigoRuta());
            DePasajeros nuevoVPasajero = new DePasajeros(cantidadP, ruta, fecha, clase, codigoV, codigoR, tiempoVuelo, precio);
            listaVuelos.set(actualizar - 1, nuevoVPasajero);

        } catch (Exception e) {
            System.err.println("Error. Aborted system is: " + e.toString());
        }
    }

    public void actualizar_DatosVueloCarga(int actualizar, String nombreP, int peso, Date fecha, String clase, String ruta, int codigoV, int codigoR, String tiempoVuelo, int precio) {
        try {

            //SE ENVIA POR PARAMETRO A LA POSICIÓN DEL VUELO QUE ESCOGIO UN NUEVO PARAMETRO DE CADA ATRIBUTO.
            System.out.println(listaVuelos.get(actualizar - 1).getCodigoRuta());
            DeCarga nuevoVCarga = new DeCarga(nombreP, peso, ruta, codigoV, fecha, clase, codigoR, tiempoVuelo, precio);
            listaVuelos.set(actualizar - 1, nuevoVCarga);
        } catch (Exception e) {
            System.err.println("Error. Aborted system is: " + e.toString());
        }
    }

    public void actualizar_DatosVueloHuman(int actualizar, String descriOperacion, int cantidadPersonasH, String ruta, int codigoV, Date horario, String claseVuelo, int codigoR, String tiempoVuelo, int precio) {
        try {

            //SE ENVIA POR PARAMETRO A LA POSICIÓN DEL VUELO QUE ESCOGIO UN NUEVO PARAMETRO DE CADA ATRIBUTO.
            System.out.println(listaVuelos.get(actualizar - 1).getCodigoRuta());
            Humanitario nuevoVHuman = new Humanitario(descriOperacion, cantidadPersonasH, ruta, codigoV, codigoR, tiempoVuelo, 0, horario, claseVuelo);
            listaVuelos.set(actualizar - 1, nuevoVHuman);
        } catch (Exception e) {
            System.err.println("Error. Aborted system is: " + e.toString());
        }
    }

    public void actualizar_DatosVueloMixto(int actualizar, String descripcion, Date horario, String clase, String ruta, int codigoV, int codigoR, String tiempoVuelo, int precio) {
        try {

            //SE ENVIA POR PARAMETRO A LA POSICIÓN DEL VUELO QUE ESCOGIO UN NUEVO PARAMETRO DE CADA ATRIBUTO.
            System.out.println(listaVuelos.get(actualizar - 1).getCodigoRuta());
            Mixto nuevoVMix = new Mixto(descripcion, ruta, codigoV, horario, clase, codigoR, tiempoVuelo, precio);
            listaVuelos.set(actualizar - 1, nuevoVMix);
        } catch (Exception e) {
            System.err.println("Error. Aborted system is: " + e.toString());
        }
    }

    public void actualizar_DatosPiloto() {
        try {
            //SE RECORRE LA LISTA DE PILOTOS PARA IMPRIMIR TAN SOLO LAS CEDULAS DE ELLOS.
            for (int i = 0; i < listaPilotos.size(); i++) {
                System.out.println((i + 1) + ". " + listaPilotos.get(i).getCedula());
            }
        } catch (Exception e) {
            System.err.println("Error. Aborted system is: " + e.toString());
        }
    }

    public void actualizarPiloto(int actualizar, String ruta, String sueldo, String nombre, String apellido, int edad, int cc) {

        //SE ENVIA POR PARAMETRO A LA POSICIÓN DEL PILOTO QUE ESCOGIO UN NUEVO PARAMETRO DE CADA ATRIBUTO.
        System.out.println(listaPilotos.get(actualizar - 1).getCedula());
        Piloto nuevoVPas = new Piloto(ruta, sueldo, nombre, apellido, edad, cc);
        listaPilotos.set(actualizar - 1, nuevoVPas);
    }

    public void actualizar_DatosAzafataCo(int actualizar, String ruta, String sueldo, String nombre, String apellido, int edad, String turno, int cc) {
        try {

            //SE ENVIA POR PARAMETRO A LA POSICIÓN DE LA AZAFATA COMIDA QUE ESCOGIO UN NUEVO PARAMETRO DE CADA ATRIBUTO.
            System.out.println(listaAzafata.get(actualizar - 1).getCedula());
            Azafata nuevoAza = new Comida(ruta, sueldo, turno, nombre, apellido, edad, cc);
            listaAzafata.set(actualizar - 1, nuevoAza);

        } catch (Exception e) {
            System.err.println("Error. Aborted system is: " + e.toString());
        }
    }

    public void actualizar_DatosAzafataSeg(int actualizar, String ruta, String sueldo, String nombre, String apellido, int edad, String turno, int cc) {
        try {

            //SE ENVIA POR PARAMETRO A LA POSICIÓN DE LA AZAFATA SEGURIDAD QUE ESCOGIO UN NUEVO PARAMETRO DE CADA ATRIBUTO.
            System.out.println(listaAzafata.get(actualizar - 1).getCedula());
            Azafata nuevoAza = new Seguridad(ruta, sueldo, turno, nombre, apellido, edad, cc);
            listaAzafata.set(actualizar - 1, nuevoAza);

        } catch (Exception e) {
            System.err.println("Error. Aborted system is: " + e.toString());
        }
    }

    public void actualizar_DatosAzafataAten(int actualizar, String ruta, String sueldo, String nombre, String apellido, int edad, String turno, int cc) {
        try {

            //SE ENVIA POR PARAMETRO A LA POSICIÓN DE LA AZAFATA ATENCION AL CLIENTE QUE ESCOGIO UN NUEVO PARAMETRO DE CADA ATRIBUTO.
            System.out.println(listaAzafata.get(actualizar - 1).getCedula());
            Azafata nuevoAza = new AtencionCliente(ruta, sueldo, turno, nombre, apellido, edad, cc);
            listaAzafata.set(actualizar - 1, nuevoAza);

        } catch (Exception e) {
            System.err.println("Error. Aborted system is: " + e.toString());
        }
    }

    public void mostrarRuta() {

        //SE MUESTRA LAS RUTAS 
        System.out.println("LAS RUTAS SON: ");
        for (int i = 0; i < listaRutas.size(); i++) {
            System.out.println("\nORIGEN DEL VUELO: " + listaRutas.get(i).getOrigen()
                    + "\nDESTINO DEL VUELO: " + listaRutas.get(i).getDestino()
                    + "\nCODIGO RUTA: " + listaVuelos.get(i).getCodigoRuta()
                    + "\nTIEMPO VUELO: " + listaVuelos.get(i).getTiempoVuelo());
        }
    }

    public void mostrarCRuta() {

        //SE MUESTRA LAS RUTAS 
        System.out.println("LAS RUTAS SON: \n");
        for (int i = 0; i < listaRutas.size(); i++) {
            System.out.println((i + 1) + ". CODIGO RUTA: " + listaRutas.get(i).getCodigo());
        }
    }

    public void mostrar_laborC() {

        //SE MUESTRA SOLAMENTE LOS CODIGOS DE LA AZAFATA COMIDA
        System.out.println("LAS AZAFATAS QUE NO TIENEN NINGUNA LABOR SON: \n");
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("Comida")) {
                if (((Comida) listaAzafata.get(i)).getPlato() == null) {
                    System.out.println("- " + listaAzafata.get(i).getCedula());
                }
            }
        }
    }

    public void mostrar_laborS() {

        //SE MUESTRA SOLAMENTE LOS CODIGOS DE LA AZAFATA COMIDA
        System.out.println("LAS AZAFATAS QUE NO TIENEN NINGUNA LABOR SON: \n");
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("Seguridad")) {
                if (((Seguridad) listaAzafata.get(i)).getHorarioInstrucci() == null) {
                    System.out.println("- " + listaAzafata.get(i).getCedula());
                }
            }
        }
    }

    public void mostrar_laborAten() {

        //SE MUESTRA SOLAMENTE LOS CODIGOS DE LA AZAFATA COMIDA
        System.out.println("LAS AZAFATAS QUE NO TIENEN NINGUNA LABOR SON: \n");
        for (int i = 0; i < listaAzafata.size(); i++) {
            if (listaAzafata.get(i).getClass().getSimpleName().equals("AtencionCliente")) {
                if (((AtencionCliente) listaAzafata.get(i)).getHoraAtencion() == null) {
                    System.out.println("- " + listaAzafata.get(i).getCedula());
                }
            }
        }
    }

    public void llenarPasajeros() {

        //SE LLENA LA LISTA DE VUELO DE PASAJEROS CON DATOS DEFINIDOS Y RUTAS YA CREADAS EN OTRO METODO
        listaVuelos.add(0, new DePasajeros(300, listaRutas.get(0).getOrigen() + "-" + listaRutas.get(0).getDestino(), new Date(120, 02, 16, 12, 00), "Nacional", 2501029, listaRutas.get(0).getCodigo(), listaRutas.get(0).getTiempoVuelo(), 300000));
        listaVuelos.add(1, new DePasajeros(300, listaRutas.get(1).getOrigen() + "-" + listaRutas.get(1).getDestino(), new Date(120, 02, 16, 11, 00), "Nacional", 2636734, listaRutas.get(1).getCodigo(), listaRutas.get(1).getTiempoVuelo(), 400000));
        listaVuelos.add(2, new DePasajeros(300, listaRutas.get(2).getOrigen() + "-" + listaRutas.get(2).getDestino(), new Date(120, 02, 16, 10, 00), "Nacional", 2772439, listaRutas.get(2).getCodigo(), listaRutas.get(2).getTiempoVuelo(), 800000));
        listaVuelos.add(3, new DePasajeros(300, listaRutas.get(3).getOrigen() + "-" + listaRutas.get(3).getDestino(), new Date(120, 02, 16, 02, 00), "Internacional", 2908144, listaRutas.get(3).getCodigo(), listaRutas.get(3).getTiempoVuelo(), 1600000));
        listaVuelos.add(4, new DePasajeros(300, listaRutas.get(4).getOrigen() + "-" + listaRutas.get(4).getDestino(), new Date(120, 02, 16, 12, 00), "Nacional", 3043849, listaRutas.get(4).getCodigo(), listaRutas.get(4).getTiempoVuelo(), 600000));
        listaVuelos.add(5, new DePasajeros(300, listaRutas.get(5).getOrigen() + "-" + listaRutas.get(5).getDestino(), new Date(120, 02, 16, 15, 00), "Internacional", 3179554, listaRutas.get(5).getCodigo(), listaRutas.get(5).getTiempoVuelo(), 1100000));
        listaVuelos.add(6, new DePasajeros(300, listaRutas.get(6).getOrigen() + "-" + listaRutas.get(6).getDestino(), new Date(120, 02, 16, 19, 00), "Internacional", 3315259, listaRutas.get(6).getCodigo(), listaRutas.get(6).getTiempoVuelo(), 1300000));
        listaVuelos.add(7, new DePasajeros(300, listaRutas.get(7).getOrigen() + "-" + listaRutas.get(7).getDestino(), new Date(120, 02, 16, 01, 00), "Nacional", 3450964, listaRutas.get(7).getCodigo(), listaRutas.get(7).getTiempoVuelo(), 300000));
        listaVuelos.add(8, new DePasajeros(300, listaRutas.get(8).getOrigen() + "-" + listaRutas.get(8).getDestino(), new Date(120, 02, 16, 05, 00), "Internacional", 3586669, listaRutas.get(8).getCodigo(), listaRutas.get(8).getTiempoVuelo(), 700000));
        listaVuelos.add(9, new DePasajeros(300, listaRutas.get(9).getOrigen() + "-" + listaRutas.get(9).getDestino(), new Date(120, 02, 16, 20, 00), "Nacional", 3722374, listaRutas.get(9).getCodigo(), listaRutas.get(9).getTiempoVuelo(), 500000));
    }

    public void llenarCarga() {

        //SE LLENA LA LISTA DE VUELO DE CARGA CON DATOS DEFINIDOS Y RUTAS YA CREADAS EN OTRO METODO
        listaVuelos.add(10, new DeCarga("Arroz, Hierro, Cemento", 180, listaRutas.get(0).getOrigen() + "-" + listaRutas.get(0).getDestino(), 3858079, new Date(120, 02, 16, 12, 00), "Nacional", listaRutas.get(0).getCodigo(), listaRutas.get(0).getTiempoVuelo(), 4000000));
        listaVuelos.add(11, new DeCarga("Oro, Mercancia ropa, Caña de azucar", 100, listaRutas.get(1).getOrigen() + "-" + listaRutas.get(1).getDestino(), 3993784, new Date(120, 02, 16, 2, 00), "Nacional", listaRutas.get(1).getCodigo(), listaRutas.get(1).getTiempoVuelo(), 1800000));
        listaVuelos.add(12, new DeCarga("Naranja, Cebolla, Papa", 190, listaRutas.get(2).getOrigen() + "-" + listaRutas.get(2).getDestino(), 4129489, new Date(120, 02, 16, 1, 00), "Nacional", listaRutas.get(2).getCodigo(), listaRutas.get(2).getTiempoVuelo(), 2000000));
        listaVuelos.add(13, new DeCarga("Hierro, Medicamentos, Panela", 250, listaRutas.get(3).getOrigen() + "-" + listaRutas.get(3).getDestino(), 4265194, new Date(120, 02, 16, 9, 00), "Internacional", listaRutas.get(3).getCodigo(), listaRutas.get(3).getTiempoVuelo(), 3200000));
        listaVuelos.add(14, new DeCarga("Trigo, Carbon, Esmeralda", 200, listaRutas.get(4).getOrigen() + "-" + listaRutas.get(4).getDestino(), 4400899, new Date(120, 02, 16, 8, 00), "Nacional", listaRutas.get(4).getCodigo(), listaRutas.get(4).getTiempoVuelo(), 1600000));
        listaVuelos.add(15, new DeCarga("Mercancia", 210, listaRutas.get(5).getOrigen() + "-" + listaRutas.get(5).getDestino(), 4536604, new Date(120, 02, 16, 11, 00), "Internacional", listaRutas.get(5).getCodigo(), listaRutas.get(5).getTiempoVuelo(), 2150000));
        listaVuelos.add(16, new DeCarga("Maiz, Trigo, Carbon", 140, listaRutas.get(6).getOrigen() + "-" + listaRutas.get(6).getDestino(), 4672309, new Date(120, 02, 16, 23, 00), "Internacional", listaRutas.get(6).getCodigo(), listaRutas.get(6).getTiempoVuelo(), 2800000));
        listaVuelos.add(17, new DeCarga("Cemento, Medicamentos", 130, listaRutas.get(7).getOrigen() + "-" + listaRutas.get(7).getDestino(), 4808014, new Date(120, 02, 16, 22, 00), "Nacional", listaRutas.get(7).getCodigo(), listaRutas.get(7).getTiempoVuelo(), 1100000));
        listaVuelos.add(18, new DeCarga("Carbn, Esmeraldas, Oro", 240, listaRutas.get(8).getOrigen() + "-" + listaRutas.get(8).getDestino(), 4943719, new Date(120, 02, 16, 21, 00), "Internacional", listaRutas.get(8).getCodigo(), listaRutas.get(8).getTiempoVuelo(), 6000000));
        listaVuelos.add(19, new DeCarga("Arroz", 190, "" + listaRutas.get(9).getOrigen() + "-" + listaRutas.get(9).getDestino(), 5079424, new Date(120, 02, 16, 00, 00), "Nacional", listaRutas.get(9).getCodigo(), listaRutas.get(9).getTiempoVuelo(), 1900000));
    }

    public void llenarHumanitario() {

        //SE LLENA LA LISTA DE VUELO HUMANITARIO CON DATOS DEFINIDOS Y RUTAS YA CREADAS EN OTRO METODO
        listaVuelos.add(20, new Humanitario("Coronavirus", 10, listaRutas.get(0).getOrigen() + "-" + listaRutas.get(0).getDestino(), 5215129, listaRutas.get(0).getCodigo(), listaRutas.get(0).getTiempoVuelo(), 0, new Date(120, 02, 16, 12, 00), "Nacional"));
        listaVuelos.add(21, new Humanitario("Coronavirus", 10, listaRutas.get(1).getOrigen() + "-" + listaRutas.get(1).getDestino(), 5350834, listaRutas.get(1).getCodigo(), listaRutas.get(1).getTiempoVuelo(), 0, new Date(120, 02, 16, 2, 00), "Nacional"));
        listaVuelos.add(22, new Humanitario("Coronavirus", 10, listaRutas.get(2).getOrigen() + "-" + listaRutas.get(2).getDestino(), 5486539, listaRutas.get(2).getCodigo(), listaRutas.get(2).getTiempoVuelo(), 0, new Date(120, 02, 16, 1, 00), "Nacional"));
        listaVuelos.add(23, new Humanitario("Coronavirus", 20, listaRutas.get(3).getOrigen() + "-" + listaRutas.get(3).getDestino(), 5622244, listaRutas.get(3).getCodigo(), listaRutas.get(3).getTiempoVuelo(), 0, new Date(120, 02, 16, 9, 00), "Internacional"));
        listaVuelos.add(24, new Humanitario("Coronavirus", 20, listaRutas.get(4).getOrigen() + "-" + listaRutas.get(4).getDestino(), 5757949, listaRutas.get(4).getCodigo(), listaRutas.get(4).getTiempoVuelo(), 0, new Date(120, 02, 16, 8, 00), "Nacional"));
        listaVuelos.add(25, new Humanitario("Coronavirus", 10, listaRutas.get(5).getOrigen() + "-" + listaRutas.get(5).getDestino(), 5893654, listaRutas.get(5).getCodigo(), listaRutas.get(5).getTiempoVuelo(), 0, new Date(120, 02, 16, 11, 00), "Internacional"));
        listaVuelos.add(26, new Humanitario("Coronavirus", 10, listaRutas.get(6).getOrigen() + "-" + listaRutas.get(6).getDestino(), 6029359, listaRutas.get(6).getCodigo(), listaRutas.get(6).getTiempoVuelo(), 0, new Date(120, 02, 16, 23, 00), "Internacional"));
        listaVuelos.add(27, new Humanitario("Coronavirus", 10, listaRutas.get(7).getOrigen() + "-" + listaRutas.get(7).getDestino(), 6165064, listaRutas.get(7).getCodigo(), listaRutas.get(7).getTiempoVuelo(), 0, new Date(120, 02, 16, 22, 00), "Nacional"));
        listaVuelos.add(28, new Humanitario("Coronavirus", 20, listaRutas.get(8).getOrigen() + "-" + listaRutas.get(8).getDestino(), 6300769, listaRutas.get(8).getCodigo(), listaRutas.get(8).getTiempoVuelo(), 0, new Date(120, 02, 16, 21, 00), "Internacional"));
        listaVuelos.add(29, new Humanitario("Coronavirus", 25, listaRutas.get(9).getOrigen() + "-" + listaRutas.get(9).getDestino(), 6436474, listaRutas.get(9).getCodigo(), listaRutas.get(9).getTiempoVuelo(), 0, new Date(120, 02, 16, 00, 00), "Nacional"));
    }

    public void llenarMixto() {

        //SE LLENA LA LISTA DE VUELO MIXTO CON DATOS DEFINIDOS Y RUTAS YA CREADAS EN OTRO METODO
        listaVuelos.add(30, new Mixto("PASAJEROS(10), CASOS HUMANITARIOS(0), CARGA(100 TON)", listaRutas.get(0).getOrigen() + "-" + listaRutas.get(0).getDestino(), 6572179, new Date(120, 02, 16, 12, 00), "Nacional", listaRutas.get(0).getCodigo(), listaRutas.get(0).getTiempoVuelo(), 1500000));
        listaVuelos.add(31, new Mixto("PASAJEROS(20), CASOS HUMANITARIOS(0), CARGA(200 TON)", listaRutas.get(1).getOrigen() + "-" + listaRutas.get(1).getDestino(), 6707884, new Date(120, 02, 16, 11, 00), "Nacional", listaRutas.get(1).getCodigo(), listaRutas.get(1).getTiempoVuelo(), 5000000));
        listaVuelos.add(32, new Mixto("PASAJEROS(10), CASOS HUMANITARIOS(2), CARGA(150 TON)", listaRutas.get(2).getOrigen() + "-" + listaRutas.get(2).getDestino(), 6843589, new Date(120, 02, 16, 10, 00), "Nacional", listaRutas.get(2).getCodigo(), listaRutas.get(2).getTiempoVuelo(), 300000));
        listaVuelos.add(33, new Mixto("PASAJEROS(15), CASOS HUMANITARIOS(0), CARGA(80 TON)", listaRutas.get(3).getOrigen() + "-" + listaRutas.get(3).getDestino(), 6979294, new Date(120, 02, 16, 22, 00), "Internacional", listaRutas.get(3).getCodigo(), listaRutas.get(3).getTiempoVuelo(), 25000000));
        listaVuelos.add(34, new Mixto("PASAJEROS(19), CASOS HUMANITARIOS(0), CARGA(10 TON)", listaRutas.get(4).getOrigen() + "-" + listaRutas.get(4).getDestino(), 7114999, new Date(120, 02, 16, 21, 00), "Nacional", listaRutas.get(4).getCodigo(), listaRutas.get(4).getTiempoVuelo(), 18000000));
        listaVuelos.add(35, new Mixto("PASAJEROS(50), CASOS HUMANITARIOS(3), CARGA(100 TON)", listaRutas.get(5).getOrigen() + "-" + listaRutas.get(5).getDestino(), 7250704, new Date(120, 02, 16, 21, 00), "Internacional", listaRutas.get(5).getCodigo(), listaRutas.get(5).getTiempoVuelo(), 29000000));
        listaVuelos.add(36, new Mixto("PASAJEROS(30), CASOS HUMANITARIOS(1), CARGA(50 TON)", listaRutas.get(6).getOrigen() + "-" + listaRutas.get(6).getDestino(), 7386409, new Date(120, 02, 16, 00, 00), "Internacional", listaRutas.get(6).getCodigo(), listaRutas.get(6).getTiempoVuelo(), 12000000));
        listaVuelos.add(37, new Mixto("PASAJEROS(40), CASOS HUMANITARIOS(1), CARGA(90 TON)", listaRutas.get(7).getOrigen() + "-" + listaRutas.get(7).getDestino(), 7522114, new Date(120, 02, 16, 22, 00), "Nacional", listaRutas.get(7).getCodigo(), listaRutas.get(7).getTiempoVuelo(), 9000000));
        listaVuelos.add(38, new Mixto("PASAJEROS(10), CASOS HUMANITARIOS(1), CARGA(100 TON)", listaRutas.get(8).getOrigen() + "-" + listaRutas.get(8).getDestino(), 7657819, new Date(120, 02, 16, 21, 00), "Internacional", listaRutas.get(8).getCodigo(), listaRutas.get(8).getTiempoVuelo(), 1400000));
        listaVuelos.add(39, new Mixto("PASAJEROS(5), CASOS HUMANITARIOS(10), CARGA(120 TON)", listaRutas.get(9).getOrigen() + "-" + listaRutas.get(9).getDestino(), 7793524, new Date(120, 02, 16, 00, 00), "Nacional", listaRutas.get(9).getCodigo(), listaRutas.get(9).getTiempoVuelo(), 500000));

    }

    public void llenarListaPilotos() {

        //SE LLENA LA LISTA DE PILOTOS CON DATOS DEFINIDOS Y RUTAS YA CREADAS EN OTRO METODO
        listaPilotos.add(new Piloto(listaRutas.get(0).getOrigen() + "-" + listaRutas.get(0).getDestino(), "10300000", "Manuel", "Silva", 28, 1057607137));
        listaPilotos.add(new Piloto(listaRutas.get(1).getOrigen() + "-" + listaRutas.get(1).getDestino(), "9300000", "Francisco", "Sierra", 32, 1057605250));
        listaPilotos.add(new Piloto(listaRutas.get(2).getOrigen() + "-" + listaRutas.get(2).getDestino(), "12300000", "Miguel", "Jara", 30, 1057607951));
        listaPilotos.add(new Piloto(listaRutas.get(3).getOrigen() + "-" + listaRutas.get(3).getDestino(), "20300000", "Rafaela", "Martin", 24, 1057601554));
        listaPilotos.add(new Piloto(listaRutas.get(4).getOrigen() + "-" + listaRutas.get(4).getDestino(), "5300000", "Luis", "Ortiz", 25, 1057608194));
        listaPilotos.add(new Piloto(listaRutas.get(5).getOrigen() + "-" + listaRutas.get(5).getDestino(), "17300000", "Antonia", "Martos", 23, 1057600994));
        listaPilotos.add(new Piloto(listaRutas.get(6).getOrigen() + "-" + listaRutas.get(6).getDestino(), "19600000", "José", "Varela", 27, 1057602043));
        listaPilotos.add(new Piloto(listaRutas.get(7).getOrigen() + "-" + listaRutas.get(7).getDestino(), "2300000", "Sergio", "Ojeda", 40, 1057608495));
        listaPilotos.add(new Piloto(listaRutas.get(8).getOrigen() + "-" + listaRutas.get(8).getDestino(), "3300000", "Sebastián", "Medina", 34, 1057602183));
        listaPilotos.add(new Piloto(listaRutas.get(9).getOrigen() + "-" + listaRutas.get(9).getDestino(), "9100000", "Antonio", "Rubio", 28, 1057604592));
    }

    public void llenarListaAzafata() {

        //SE LLENA LA LISTA DE AZAFATAS CON DATOS DEFINIDOS Y RUTAS YA CREADAS EN OTRO METODO
        listaAzafata.add(new Comida(listaRutas.get(0).getOrigen() + "-" + listaRutas.get(0).getDestino(), "7200000", "2 dias", "Rafaela", "Martin", 32, 1057546309));
        listaAzafata.add(new Comida(listaRutas.get(1).getOrigen() + "-" + listaRutas.get(1).getDestino(), "7510000", "2 dias", "Antonia", "Martos", 21, 1057600479));
        listaAzafata.add(new Comida(listaRutas.get(2).getOrigen() + "-" + listaRutas.get(2).getDestino(), "8000000", "2 dias", "Juana", "Guerrero", 29, 1057604933));
        listaAzafata.add(new Comida(listaRutas.get(3).getOrigen() + "-" + listaRutas.get(3).getDestino(), "9230000", "3 dias", "Juana", "Ferre", 24, 1057608147));
        listaAzafata.add(new Comida(listaRutas.get(4).getOrigen() + "-" + listaRutas.get(4).getDestino(), "4200000", "2 dias", "Elena", "Sánchez", 33, 1057605848));
        listaAzafata.add(new Comida(listaRutas.get(5).getOrigen() + "-" + listaRutas.get(5).getDestino(), "8600000", "3 dias", "Carmen", "Del Pino", 19, 1057608270));
        listaAzafata.add(new Comida(listaRutas.get(6).getOrigen() + "-" + listaRutas.get(6).getDestino(), "8290000", "3 dias", "María", "Ávila", 26, 1057603997));
        listaAzafata.add(new Comida(listaRutas.get(7).getOrigen() + "-" + listaRutas.get(7).getDestino(), "3200000", "2 dias", "Ana", "Uribe", 30, 1057601736));
        listaAzafata.add(new Comida(listaRutas.get(8).getOrigen() + "-" + listaRutas.get(8).getDestino(), "4200000", "2 dias", "Susana", "Casas", 31, 1057605095));
        listaAzafata.add(new Comida(listaRutas.get(9).getOrigen() + "-" + listaRutas.get(9).getDestino(), "6800000", "2 dias", "Josefa", "López", 34, 1057602043));

        listaAzafata.add(new Seguridad(listaRutas.get(0).getOrigen() + "-" + listaRutas.get(0).getDestino(), "6690000", "2 dias", "Paula", "Gamboa", 30, 1057603868));
        listaAzafata.add(new Seguridad(listaRutas.get(1).getOrigen() + "-" + listaRutas.get(1).getDestino(), "7410000", "2 dias", "Paula", "Valero", 20, 1057602658));
        listaAzafata.add(new Seguridad(listaRutas.get(2).getOrigen() + "-" + listaRutas.get(2).getDestino(), "51000000", "2 dias", "Lucia", "Díaz", 23, 1057601653));
        listaAzafata.add(new Seguridad(listaRutas.get(3).getOrigen() + "-" + listaRutas.get(3).getDestino(), "9050000", "3 dias", "Paula", "Lozano", 21, 1057603542));
        listaAzafata.add(new Seguridad(listaRutas.get(4).getOrigen() + "-" + listaRutas.get(4).getDestino(), "2900000", "2 dias", "Margarita", "Iriarte", 32, 1057602035));
        listaAzafata.add(new Seguridad(listaRutas.get(5).getOrigen() + "-" + listaRutas.get(5).getDestino(), "8300000", "3 dias", "Carmen", "Del Pino", 19, 1057603501));
        listaAzafata.add(new Seguridad(listaRutas.get(6).getOrigen() + "-" + listaRutas.get(6).getDestino(), "4290000", "3 dias", "Ana", "Rodríguez", 29, 1057603162));
        listaAzafata.add(new Seguridad(listaRutas.get(7).getOrigen() + "-" + listaRutas.get(7).getDestino(), "7200000", "2 dias", "Ana María", "Campos", 30, 1057602564));
        listaAzafata.add(new Seguridad(listaRutas.get(8).getOrigen() + "-" + listaRutas.get(8).getDestino(), "2200000", "2 dias", "Susana", "Casas", 35, 1057603839));
        listaAzafata.add(new Seguridad(listaRutas.get(9).getOrigen() + "-" + listaRutas.get(9).getDestino(), "6800000", "2 dias", "Catalina", "Ferre", 33, 1057602132));

        listaAzafata.add(new AtencionCliente(listaRutas.get(0).getOrigen() + "-" + listaRutas.get(0).getDestino(), "4200000", "2 dias", "Sandra", "Arenas", 20, 1057546309));
        listaAzafata.add(new AtencionCliente(listaRutas.get(1).getOrigen() + "-" + listaRutas.get(1).getDestino(), "5510000", "2 dias", "Elena", "Muriel", 18, 1057610479));
        listaAzafata.add(new AtencionCliente(listaRutas.get(2).getOrigen() + "-" + listaRutas.get(2).getDestino(), "6000000", "2 dias", "Carmen", "Navarrete", 28, 1047604933));
        listaAzafata.add(new AtencionCliente(listaRutas.get(3).getOrigen() + "-" + listaRutas.get(3).getDestino(), "9250000", "3 dias", "Elena", "Pastor", 19, 1057608147));
        listaAzafata.add(new AtencionCliente(listaRutas.get(4).getOrigen() + "-" + listaRutas.get(4).getDestino(), "3200000", "2 dias", "Rosa María", "Pastor", 31, 1053605848));
        listaAzafata.add(new AtencionCliente(listaRutas.get(5).getOrigen() + "-" + listaRutas.get(5).getDestino(), "5600000", "3 dias", "Laura", "Patiño", 30, 1057608370));
        listaAzafata.add(new AtencionCliente(listaRutas.get(6).getOrigen() + "-" + listaRutas.get(6).getDestino(), "4290000", "3 dias", "Elena", "Torres", 28, 1057613997));
        listaAzafata.add(new AtencionCliente(listaRutas.get(7).getOrigen() + "-" + listaRutas.get(7).getDestino(), "7200000", "2 dias", "María Luisa", "Fuentes", 31, 1157601736));
        listaAzafata.add(new AtencionCliente(listaRutas.get(8).getOrigen() + "-" + listaRutas.get(8).getDestino(), "5500000", "2 dias", "Sonia", "García", 31, 1257405095));
        listaAzafata.add(new AtencionCliente(listaRutas.get(9).getOrigen() + "-" + listaRutas.get(9).getDestino(), "6900000", "2 dias", "Carmen", "García", 39, 1058602043));

    }

    public void llenarRutas() {

        //SE LLENA LA LISTA DE RUTAS CON DATOS DEFINIDOS PARA PODER ASIGNAR ESTAS RUTAS A ALGUNOS DE LOS TRABAJADORES
        listaRutas.add(0, new Ruta("Bogota", "Medellin", 57609431, "2 horas"));
        listaRutas.add(1, new Ruta("Barranquilla", "Medellin", 57523568, "3 horas"));
        listaRutas.add(2, new Ruta("San Andres", "Leticia", 57437705, "4 horas"));
        listaRutas.add(3, new Ruta("El Dorado, Bogota", "España", 57351842, "12 horas"));
        listaRutas.add(4, new Ruta("Tunja", "Villavicencio", 57265979, "1 horas"));
        listaRutas.add(5, new Ruta("Medellin", "Buenos Aires, Argentina", 57180116, "6 horas"));
        listaRutas.add(6, new Ruta("Ibague, Tolima", "La Paz, Bolivia", 57094253, "8 horas"));
        listaRutas.add(7, new Ruta("Bogota", "Tunja", 57008390, "45 minutos"));
        listaRutas.add(8, new Ruta("Medellin", "Sogamoso", 56922527, "1 hora"));
        listaRutas.add(9, new Ruta("Cali", "Guajira", 56836664, "2 horas"));

    }

}
