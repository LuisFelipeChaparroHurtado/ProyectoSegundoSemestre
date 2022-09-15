/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 02/06/2020
 * DESCRIPCIÓN: Se necesita gestionar la información de una Aerolínea. 
    La Aerolínea  debe manejar los vuelos por tipo (Nacional, internacional, 
    de pasajeros, de carga, mixto, humanitario).  De cada vuelo se debe conocer 
    su código, horario designado, capacidad/peso y precio, y se deben conocer las 
    características propias de cada tipo de vuelo.  
    Asimismo se debe tener un control sobre los trabajadores (pilotos y azafatos) 
    para conocer la actividad que cada uno debe hacer, su salario y datos personales.
    De los pilotos se debe conocer además las rutas que hace y de los azafatos qué 
    turno tiene (de 2 o 3 días) y su trabajo en el vuelo (comida, seguridad, atención 
    a pasajeros). La Aerolínea debe saber qué personal viaja en cada vuelo y cada vuelo qué ruta cubre. 
    Por lo tanto, se debe tener control de las rutas cubiertas por la aerolínea 
    (origen, destino, código, tiempo de vuelo) y de la comida a ofrecer (tipo –desayuno, almuerzo, cena– y peso
 */
package menu;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import javax.swing.JRootPane;
import logica.Aerolinea;
import logica.AtencionCliente;
import logica.Comida;
import logica.Seguridad;
import resources.Archivo;

public class Menu {

    private Aerolinea aerolinea;
    private Archivo archi;
    private Scanner keyboard;

    public Menu() {
        //SE INICIALIZAN LOS ATRIBUTOS DE LA CLASE MENU
        aerolinea = new Aerolinea();
        archi = new Archivo("src\\resources\\", "Archivo_Proyecto.txt");
        aerolinea.llenarRutas();
        aerolinea.llenarPasajeros();
        aerolinea.llenarCarga();
        aerolinea.llenarHumanitario();
        aerolinea.llenarMixto();
        aerolinea.llenarListaAzafata();
        aerolinea.llenarListaPilotos();

        keyboard = new Scanner(System.in);
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public Scanner getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Scanner keyboard) {
        this.keyboard = keyboard;
    }

    public Archivo getArchi() {
        return archi;
    }

    public void setArchi(Archivo archi) {
        this.archi = archi;
    }

    public static void main(String[] args) {
        try {
            //SE INICIALIZA EL PROGRAMA CON ARCHIVOS CREADOS Y LEIDOS

            Menu menu = new Menu();
            menu.archi.escribirArchivo2("");
            menu.aerolinea.setListaAzafata(menu.archi.leerArchivoC(menu.aerolinea.getListaAzafata()));
            menu.aerolinea.setListaAzafata(menu.archi.leerArchivoSe(menu.aerolinea.getListaAzafata()));
            menu.aerolinea.setListaAzafata(menu.archi.leerArchivoAten(menu.aerolinea.getListaAzafata()));

            //SE INICIALIZA LA INTERFACE GRAFICA AL IGUAL QUE LA CONSOLA
            Login loginProyecto = new Login(menu.getAerolinea());
            loginProyecto.setUndecorated(true);
            loginProyecto.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            loginProyecto.setVisible(true);
            menu.menuPrincipal();

        } catch (Exception e) {
            System.err.println("Error" + e.toString());
        }
    }

    public void menuPrincipal() {
        //MENU PRINCIPAL
        try {

            System.out.println("\n---------------------------------------------------------\n"
                    + "                      AEROLINEA\n"
                    + "               INGENIERIA EN SISTEMAS\n"
                    + "       CREADO POR: LUIS FELIPE CHAPARRO HURTADO\n"
                    + "---------------------------------------------------------\n\n"
                    + "INGRESE LA OPCION QUE DESEA EJECUTAR:\n\n"
                    + " - (1) Vuelo\n"
                    + " - (2) Trabajador\n"
                    + " - (3) Agregar ruta\n"
                    + " - (4) Buscar Vuelos\n"
                    + " - (5) Buscar Pilotos\n"
                    + " - (6) Buscar Azafatas\n"
                    + " - (7) Actualizar Vuelos\n"
                    + " - (8) Actualizar Trabajadores\n"
                    + " - (9) Generar archivo vuelos(TXT)\n"
                    + " - (10) Generar archivo trabajadores (TXT)\n"
                    + " - (11) Mostrar ruta\n"
                    + " - (12) Registrar Trabajo\n"
                    + " - (0) Salir");

            int opt = keyboard.nextInt();
            if (opt == 1) {
                menuNext();
            } else if (opt == 2) {
                agregarTrabajador();
            } else if (opt == 3) {
                agregar_Ruta();
            } else if (opt == 4) {
                menuBuscar();
            } else if (opt == 5) {
                buscar_Piloto();
                menuPrincipal();
            } else if (opt == 6) {
                buscar_Azafata();
            } else if (opt == 7) {
                menuActualizarVuelos();
            } else if (opt == 8) {
                menuActualizarTrabajadores();
            } else if (opt == 9) {
                generarTxtVuelos();
                menuPrincipal();
            } else if (opt == 10) {
                generarTxtTrabajadores();
                menuPrincipal();
            } else if (opt == 11) {
                aerolinea.mostrarRuta();
            } else if (opt == 12) {
                registrarTrabajo();
                menuPrincipal();
            }

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void menuActualizarVuelos() {
        //MENU DE VUELOS
        try {
            System.out.println("INGRESE LA OPCION QUE DESEA REALIZAR\n"
                    + " - (1) Actualizar vuelo de pasajeros\n"
                    + " - (2) Actualizar vuelo de carga\n"
                    + " - (3) Actualizar vuelo humanitario\n"
                    + " - (4) Actualizar vuelo mixto\n"
                    + " - (0) Volver");
            int se = keyboard.nextInt();
            if (se == 1) {
                actualizar_DatosVueloPasajero();
                menuActualizarVuelos();
            } else if (se == 2) {
                actualizar_DatosVueloCarga();
                menuActualizarVuelos();
            } else if (se == 3) {
                actualizar_DatosVueloHuman();
                menuActualizarVuelos();
            } else if (se == 4) {
                actualizar_DatosVueloMixto();
                menuActualizarVuelos();
            } else if (se == 0) {
                menuPrincipal();
            }
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void menuActualizarTrabajadores() {
        //MENU DE TRABAJADORES
        try {
            System.out.println("INGRESE LA OPCION QUE DESEA REALIZAR\n"
                    + " - (1) Actualizar pilotos\n"
                    + " - (2) Actualizar azafatas\n"
                    + " - (0) Volver");
            int se = keyboard.nextInt();
            if (se == 1) {
                actualizar_DatosPiloto();
                menuActualizarTrabajadores();
            } else if (se == 2) {
                menuAzafatas();
                menuActualizarTrabajadores();
            } else if (se == 0) {
                menuPrincipal();
            }
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void menuAzafatas() {
        //MENU DE ACTUALIZAR AZAFATAS
        try {
            System.out.println("INGRESE LA OPCION QUE DESEA REALIZAR\n"
                    + " - (1) Actualizar azafatas (Comida)\n"
                    + " - (2) Actualizar azafatas (Seguridad)\n"
                    + " - (3) Actualizar azafatas (Atencion al cliente)\n"
                    + " - (0) Volver");
            int se = keyboard.nextInt();
            if (se == 1) {
                actualizar_AzafataComida();
                menuAzafatas();
            } else if (se == 2) {
                actualizar_AzafataSeguridad();
                menuAzafatas();
            } else if (se == 3) {
                actualizar_AzafataAtencionClien();
                menuAzafatas();
            } else if (se == 0) {
                menuActualizarTrabajadores();
            }

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void menuNext() {
        //MENU DE AGREGAR VUELOS
        try {
            System.out.println("\nINGRESE LA OPCION QUE DESEA REALIZAR:\n"
                    + " - (1) Ingresar vuelo de pasajeros\n"
                    + " - (2) Ingresar vuelo de carga\n"
                    + " - (3) Ingresar vuelo humanitario\n"
                    + " - (4) Ingresar vuelo mixto\n"
                    + " - (5) Mostrar vuelos\n"
                    + " - (0) Volver menu principal");

            int option = keyboard.nextInt();

            if (option == 1) {
                agregarVueloPasajeros();
            } else if (option == 2) {
                agregarVueloDeCarga();
            } else if (option == 3) {
                agregarVueloHumanitario();
            } else if (option == 4) {
                agregarVueloMixto();
            } else if (option == 5) {
                menu_MostrarVuelos();
                menuNext();
            } else if (option == 0) {
                menuPrincipal();
            }

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void menu_MostrarVuelos() {
        //MENU MOSTRAR VUELOS
        try {
            System.out.println("\nINGRESE LA OPCION QUE DESEA REALIZAR:\n"
                    + " - (1) Mostrar vuelo de pasajeros\n"
                    + " - (2) Mostrar vuelo de carga\n"
                    + " - (3) Mostrar vuelo humanitario\n"
                    + " - (4) Mostrar vuelo mixto\n"
                    + " - (0) Volver");

            int op = keyboard.nextInt();

            if (op == 1) {
                aerolinea.mostrarVPasajeros();
                menu_MostrarVuelos();
            } else if (op == 2) {
                aerolinea.mostrarVCarga();
                menu_MostrarVuelos();
            } else if (op == 3) {
                aerolinea.mostrarVHumanitario();
                menu_MostrarVuelos();
            } else if (op == 4) {
                aerolinea.mostrarVMixto();
                menu_MostrarVuelos();
            } else if (op == 0) {
                menuNext();
            }
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void agregarVueloPasajeros() {
        //AGREGAR VUELO PASAJEROS
        try {

            System.out.println("Ingrese la cantidad de pasajeros");
            int cantidadP = keyboard.nextInt();
            System.out.println("Ingrese el codigo del vuelo");
            int codigoV = keyboard.nextInt();
            System.out.println("Ingrese la fecha y hora del vuelo"
                    + " Digite la fecha de ingreso al parqueadero en formato MM-dd-yyyy (02-10-2021-12-05)");
            String horarioVuelo = keyboard.next();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm"); // Creamos un formato de fecha
            Date fecha = format.parse(horarioVuelo);
            System.out.println("Ingrese la clase de vuelo: \n"
                    + " - Nacional\n"
                    + " - Internacional");
            String clase = keyboard.next();
            agregar_Ruta();
            int numRuta = aerolinea.getListaRutas().size();
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            int codRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
            String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
            System.out.println("Ingrese el precio del vuelo");
            int precio = keyboard.nextInt();

            aerolinea.agregarListaVuePasajeros(cantidadP, ruta, codigoV, fecha, clase, codRuta, tiempoVuelo, precio);
            System.out.println("\n\n-----------------EL VUELO FUE AGREGADO CORRECTAMENTE------------------------\n\n");
            menuNext();

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void agregarVueloDeCarga() {
        //AGREGAR VUELO DE CARGA
        try {

            System.out.println("Ingrese el nombre del producto");
            String nombreP = keyboard.next();
            System.out.println("Ingrese el peso de la carga");
            int peso = keyboard.nextInt();
            System.out.println("Ingrese el codigo del vuelo");
            int codigoV = keyboard.nextInt();
            System.out.println("Ingrese la fecha y hora del vuelo"
                    + " Digite la fecha de ingreso al parqueadero en formato MM-dd-yyyy (02-10-2021-02-12)");
            String horarioVuelo = keyboard.next();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm"); // Creamos un formato de fecha
            Date horario = format.parse(horarioVuelo);
            System.out.println("Ingrese la clase de vuelo: "
                    + " \n- Nacional\n"
                    + " \n- Internacional");
            String clase = keyboard.next();
            agregar_Ruta();
            int numRuta = aerolinea.getListaRutas().size();
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            int codRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
            String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
            System.out.println("Ingrese el precio del vuelo");
            int precio = keyboard.nextInt();

            aerolinea.agregarListaVueDeCarga(nombreP, peso, ruta, codigoV, horario, clase, codRuta, tiempoVuelo, precio);
            System.out.println("\n\n-----------------EL VUELO FUE AGREGADO CORRECTAMENTE------------------------\n\n");
            menuNext();

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void agregarVueloHumanitario() {
        //AGREGAR VUELO HUMANITARIO
        try {

            System.out.println("Ingrese la descripcion de la mision humanitaria");
            String mision = keyboard.next();
            System.out.println("Ingrese el numero de personas de mision humanitaria");
            int numeroPH = keyboard.nextInt();
            System.out.println("Ingrese el codigo del vuelo");
            int codigoV = keyboard.nextInt();
            System.out.println("Ingrese la fecha y hora del vuelo"
                    + " Digite la fecha de ingreso al parqueadero en formato MM-dd-yyyy (02-10-2021-02-12)");
            String horarioVuelo = keyboard.next();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm"); // Creamos un formato de fecha
            Date horario = format.parse(horarioVuelo);
            System.out.println("Ingrese la clase de vuelo: "
                    + " \n- Nacional\n"
                    + " \n- Internacional");
            String clase = keyboard.next();
            agregar_Ruta();
            int numRuta = aerolinea.getListaRutas().size();
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            int codRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
            String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();

            aerolinea.agregarListaVueloHuman(mision, numeroPH, ruta, codigoV, horario, clase, codRuta, tiempoVuelo);
            System.out.println("\n\n-----------------EL VUELO FUE AGREGADO CORRECTAMENTE------------------------\n\n");
            menuNext();

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void agregarVueloMixto() {
        //AGREGAR VUELO MIXTO
        try {

            System.out.println("Ingrese el tipo de vuelo\n"
                    + " - Humanitario\n"
                    + " - De Pasajeros\n"
                    + " - De carga");

            String descripcion = keyboard.next();
            System.out.println("Ingrese el codigo del vuelo");
            int codigoV = keyboard.nextInt();
            System.out.println("Ingrese la fecha y hora del vuelo"
                    + " Digite la fecha de ingreso al parqueadero en formato MM-dd-yyyy (02-10-2021-02-12)");
            String horarioVuelo = keyboard.next();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm"); // Creamos un formato de fecha
            Date horario = format.parse(horarioVuelo);
            System.out.println("Ingrese la clase de vuelo: "
                    + " \n- Nacional"
                    + " \n- Internacional");
            String clase = keyboard.next();
            agregar_Ruta();
            int numRuta = aerolinea.getListaRutas().size();
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            int codRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
            String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
            System.out.println("Ingrese el precio del vuelo");
            int precio = keyboard.nextInt();

            aerolinea.agregarListaVueloMixto(descripcion, ruta, codigoV, horario, clase, codRuta, tiempoVuelo, precio);
            System.out.println("\n\n-----------------EL VUELO FUE AGREGADO CORRECTAMENTE------------------------\n\n");
            menuNext();

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void agregarTrabajador() {
        //MENU AGREGAR TRABAJADOR Y MOSTRAR INFORMACION TRABAJADORES POR TIPO
        try {
            System.out.println("\nSeleccione la opcion de trabajador que quiere agregar\n"
                    + " - (1) Piloto\n"
                    + " - (2) Azafata\n"
                    + " - (3) Mostrar pilotos\n"
                    + " - (4) Mostrar azafata\n"
                    + " - (0) Vover");

            int opt = keyboard.nextInt();

            if (opt == 1) {
                agregarPiloto();
            } else if (opt == 2) {
                agregarAzafata();
            } else if (opt == 3) {
                aerolinea.mostrarPiloto();
                agregarTrabajador();
            } else if (opt == 4) {
                aerolinea.mostrarListAzafatas();
                agregarTrabajador();
            } else if (opt == 0) {
                menuPrincipal();
            }
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void agregarPiloto() {
        //AGREGAR PILOTO
        agregar_Ruta();
        int numRuta = aerolinea.getListaRutas().size();
        String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
        System.out.println("Ingrese el sueldo del piloto");
        String sueldo = keyboard.next();
        System.out.println("Ingrese el nombre del piloto");
        String nombre = keyboard.next();
        System.out.println("Ingrese el apellido del piloto");
        String apellido = keyboard.next();
        System.out.println("Ingrese la edad del piloto");
        int edad = keyboard.nextInt();
        System.out.println("Ingrese el numero de documento del piloto");
        int cc = keyboard.nextInt();

        aerolinea.agregarListaPiloto(ruta, sueldo, nombre, apellido, edad, cc);
        System.out.println("\n\n-----------------LOS DATOS FUERON AGREGADOS CORRECTAMENTE------------------------\n\n");
        agregarTrabajador();
    }

    public void agregarAzafata() {
        //MENU AGREGAR AZAFATA
        try {
            System.out.println("\nIngrese el tipo de labor de la azafata\n"
                    + " - (1) De comidas\n"
                    + " - (2) Atención al cliente\n"
                    + " - (3) Seguridad\n"
                    + " - (0) Volver");

            int slet = keyboard.nextInt();
            if (slet == 1) {
                agregarAzafataComida();
            } else if (slet == 2) {
                agregarAzafataAtencionCli();
            } else if (slet == 3) {
                agregarAzafataSeguridad();
            } else if (slet == 0) {
                agregarTrabajador();
            }
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }

    }

    public void agregarAzafataComida() {
        //AGREGAR AZAFATA COMIDA
        try {
            agregar_Ruta();
            int numRuta = aerolinea.getListaRutas().size();
            String rutaAzafata = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            System.out.println("Ingrese el sueldo de la Azafata");
            String sueldoAzafata = keyboard.next();
            System.out.println("Ingrese el turno de la Azafata");
            String turno = keyboard.next();
            System.out.println("Ingrese el nombre de la Azafata");
            String nombreAzafata = keyboard.next();
            System.out.println("Ingrese el apellido de la Azafata");
            String apellidoAzafata = keyboard.next();
            System.out.println("Ingrese la edad de la Azafata");
            int edadAzafata = keyboard.nextInt();
            System.out.println("Ingrese el numero de documento de la Azafata");
            int cc = keyboard.nextInt();

            aerolinea.agregarListaAzafataComida(rutaAzafata, sueldoAzafata, turno, nombreAzafata, apellidoAzafata, edadAzafata, cc);
            System.out.println("\n\n-----------------LOS DATOS FUERON AGREGADOS CORRECTAMENTE------------------------\n\n");
            agregarAzafata();
        } catch (Exception e) {

        }
    }

    public void agregarAzafataAtencionCli() {
        //AGREGAR AZAFATA ATENCIÓN AL CLIENTE
        agregar_Ruta();
        int numRuta = aerolinea.getListaRutas().size();
        String rutaAzafata = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
        System.out.println("Ingrese el sueldo de la Azafata");
        String sueldoAzafata = keyboard.next();
        System.out.println("Ingrese el turno de la Azafata");
        String turno = keyboard.next();
        System.out.println("Ingrese el nombre de la Azafata");
        String nombreAzafata = keyboard.next();
        System.out.println("Ingrese el apellido de la Azafata");
        String apellidoAzafata = keyboard.next();
        System.out.println("Ingrese la edad de la Azafata");
        int edadAzafata = keyboard.nextInt();
        System.out.println("Ingrese el numero de documento de la Azafata");
        int cc = keyboard.nextInt();

        aerolinea.agregarListaAzafataAtencion(rutaAzafata, sueldoAzafata, turno, nombreAzafata, apellidoAzafata, edadAzafata, cc);
        System.out.println("\n\n-----------------LOS DATOS FUERON AGREGADOS CORRECTAMENTE------------------------\n\n");
        agregarAzafata();
    }

    public void agregarAzafataSeguridad() {
        //AGREGAR AZAFATA DE SEGURIDAD
        try {
            agregar_Ruta();
            int numRuta = aerolinea.getListaRutas().size();
            String rutaAzafata = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();

            System.out.println("Ingrese el sueldo de la Azafata");
            String sueldoAzafata = keyboard.next();
            System.out.println("Ingrese el turno de la Azafata");
            String turno = keyboard.next();
            System.out.println("Ingrese el nombre de la Azafata");
            String nombreAzafata = keyboard.next();
            System.out.println("Ingrese el apellido de la Azafata");
            String apellidoAzafata = keyboard.next();
            System.out.println("Ingrese la edad de la Azafata");
            int edadAzafata = keyboard.nextInt();
            System.out.println("Ingrese el numero de documento de la Azafata");
            int cc = keyboard.nextInt();

            aerolinea.agregarListaAzafataSeguridad(rutaAzafata, sueldoAzafata, turno, nombreAzafata, apellidoAzafata, edadAzafata, cc);
            System.out.println("\n\n-----------------LOS DATOS FUERON AGREGADOS CORRECTAMENTE------------------------\n\n");
            agregarAzafata();
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void menuBuscar() {
        //MENU BUSCAR VUELOS
        try {

            System.out.println("\nINGRESE LA OPCION QUE DESEA REALIZAR:\n"
                    + " - (1) Buscar vuelo de pasajeros\n"
                    + " - (2) Buscar vuelo de carga\n"
                    + " - (3) Buscar vuelo humanitario\n"
                    + " - (4) Buscar vuelo mixto\n"
                    + " - (0) Volver");

            int op = keyboard.nextInt();

            if (op == 1) {
                buscar_VueloPasajeros();
                menuBuscar();
            } else if (op == 2) {
                buscar_VueloCarga();
                menuBuscar();
            } else if (op == 3) {
                buscar_VueloHumanitario();
                menuBuscar();
            } else if (op == 4) {
                buscar_VueloMixto();
                menuBuscar();
            } else if (op == 0) {
                menuPrincipal();
            }
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void buscar_VueloPasajeros() {
        //BUSCAR VUELO DE PASAJEROS
        try {
            aerolinea.mostrarCodigoVueloPasajeros();
            System.out.println("\nIngrese el codigo de la ruta que desea buscar");
            int codigo = keyboard.nextInt();
            aerolinea.Buscar_VueloPasa(codigo);
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void buscar_VueloCarga() {
        //BUSCAR VUELO DE CARGA
        try {
            aerolinea.mostrarCodigoVueloCarga();
            System.out.println("\nIngrese el codigo de la ruta que desea buscar");
            int codigo = keyboard.nextInt();

            aerolinea.Buscar_VueloCarg(codigo);
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void buscar_VueloHumanitario() {
        //BUSCAR VUELO HUMANITARIO
        try {
            aerolinea.mostrarCodigoVueloHuman();
            System.out.println("\nIngrese el codigo de la ruta que desea buscar");
            int codigo = keyboard.nextInt();

            aerolinea.Buscar_VueloHum(codigo);
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void buscar_VueloMixto() {
        //BUSCAR VUELO MIXTO
        try {
            aerolinea.mostrarCodigoVueloMixto();
            System.out.println("\nIngrese el codigo de la ruta que desea buscar");
            int codigo = keyboard.nextInt();

            aerolinea.Buscar_VueloMix(codigo);
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void buscar_Piloto() {
        //BUSCAR PILOTO
        try {
            aerolinea.Buscar_Piloto(0);
            System.out.println("\nIngrese el documento del trabajador que desea buscar");
            int cc = keyboard.nextInt();
            aerolinea.Buscar_Piloto(cc);
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void buscar_Azafata() {
        //MENU BUSCAR TIPOS DE AZAFATA
        try {

            System.out.println("\nINGRESE LA OPCION QUE DESEA REALIZAR:\n"
                    + " - (1) Buscar azafata de comida\n"
                    + " - (2) Buscar azafata de seguridad\n"
                    + " - (3) Buscar azafata de atención al cliente\n"
                    + " - (0) Volver");

            int op = keyboard.nextInt();

            if (op == 1) {
                buscar_AzafataC();
                buscar_Azafata();
            } else if (op == 2) {
                buscar_AzafataS();
                buscar_Azafata();
            } else if (op == 3) {
                buscar_AzafataA();
                buscar_Azafata();
            } else if (op == 0) {
                menuPrincipal();
            }
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public int buscar_AzafataC() {
        //BUSCAR CEDULA DE AZAFATA COMIDA
        aerolinea.mostrar_AzafataComida();
        System.out.println("\nIngrese el documento del trabajador que desea buscar");
        int cc = keyboard.nextInt();
        return aerolinea.buscar_AzafataComida(cc);

    }

    public int buscar_AzafataS() {
        //BUSCAR CEDULA AZAFATA SEGURIDAD
        aerolinea.mostrar_AzafataSeguridad();
        System.out.println("\nIngrese el documento del trabajador que desea buscar");
        int cc = keyboard.nextInt();

        return aerolinea.buscar_AzafataSeguridad(cc);

    }

    public int buscar_AzafataA() {
        //BUSCAR AZAFATA ATENCION AL CLIENTE
        aerolinea.mostrar_AzafataAtencion();
        System.out.println("\nIngrese el documento del trabajador que desea buscar");
        int cc = keyboard.nextInt();

        return aerolinea.buscar_AzafataAtencion(cc);

    }

    public void actualizar_DatosVueloPasajero() {
        //ACTUALIZAR DATOS DE VUELO DE PASAJEROS
        try {

            aerolinea.mostrarCodigoVueloPasajeros();
            System.out.println("\nIngrese la opcion, para actualizar los datos del vuelo.");
            int actualizar = keyboard.nextInt();

            System.out.println("\nIngrese la nueva cantidad de pasajeros");
            int cantidadP = keyboard.nextInt();
            System.out.println("Ingrese el nuevo codigo del vuelo");
            int codigoV = keyboard.nextInt();
            aerolinea.mostrarCRuta();
            System.out.println("Ingrese el número de la ruta que desea");
            int numRuta = keyboard.nextInt();
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            int codRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
            String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();

            System.out.println("Ingrese la nueva fecha y hora del vuelo"
                    + " Digite la fecha de ingreso al parqueadero en formato MM-dd-yyyy (02-10-2021-02-12)");
            String horarioVuelo = keyboard.next();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm"); // Creamos un formato de fecha
            Date fecha = format.parse(horarioVuelo);
            System.out.println("Ingrese la nueva clase de vuelo: "
                    + "\n - Nacional"
                    + "\n - Internacional");
            String clase = keyboard.next();
            System.out.println("Ingrese el nuevo precio del vuelo");
            int precio = keyboard.nextInt();

            aerolinea.actualizar_DatosVueloPasaje(actualizar, cantidadP, ruta, fecha, clase, codigoV, codRuta, tiempoVuelo, precio);

            System.out.println("\n\n-----------------SU VUELO FUE ACTUALIZADO CORRECTAMENTE------------------------\n\n");

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void actualizar_DatosVueloCarga() {
        //ACTUALIZAR DATOS DE VUELO DE CARGA
        try {

            aerolinea.mostrarCodigoVueloCarga();
            System.out.println("\nIngrese la opcion, para actualizar los datos del vuelo.\n");
            int actualizar = keyboard.nextInt();

            System.out.println("Ingrese el nombre del producto");
            String nombreP = keyboard.next();
            System.out.println("Ingrese el peso de la carga");
            int peso = keyboard.nextInt();
            System.out.println("Ingrese el nuevo codigo del vuelo");
            int codigoV = keyboard.nextInt();
            System.out.println("Ingrese la fecha y hora del vuelo"
                    + " Digite la fecha de ingreso al parqueadero en formato MM-dd-yyyy (02-10-2021-12-30)");
            String horarioVuelo = keyboard.next();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm"); // Creamos un formato de fecha
            Date horario = format.parse(horarioVuelo);
            System.out.println("Ingrese la clase de vuelo: "
                    + " \n- Nacional"
                    + " \n- Internacional");
            String clase = keyboard.next();
            aerolinea.mostrarCRuta();
            System.out.println("Ingrese el número de la ruta que desea");
            int numRuta = keyboard.nextInt();
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            int codRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
            String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
            System.out.println("Ingrese el precio del vuelo");
            int precio = keyboard.nextInt();

            aerolinea.actualizar_DatosVueloCarga(actualizar, nombreP, peso, horario, clase, ruta, codigoV, codRuta, tiempoVuelo, precio);

            System.out.println("\n\n-----------------SU VUELO FUE ACTUALIZADO CORRECTAMENTE------------------------\n\n");

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void actualizar_DatosVueloHuman() {
        //ACTUALIZAR DATOS DE VUELO HUMANITARIO
        try {

            aerolinea.mostrarCodigoVueloHuman();
            System.out.println("\nIngrese la opcion, para actualizar los datos del vuelo.\n");
            int actualizar = keyboard.nextInt();

            System.out.println("Ingrese la descripcion de la mision humanitaria");
            String mision = keyboard.next();
            System.out.println("Ingrese el numero de personas de mision humanitaria");
            int numeroPH = keyboard.nextInt();
            System.out.println("Ingrese el nuevo codigo del vuelo");
            int codigoV = keyboard.nextInt();
            System.out.println("Ingrese la fecha y hora del vuelo"
                    + " Digite la fecha de ingreso al parqueadero en formato MM-dd-yyyy (02-10-2021-12-30)");
            String horarioVuelo = keyboard.next();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm"); // Creamos un formato de fecha
            Date horario = format.parse(horarioVuelo);
            System.out.println("Ingrese la clase de vuelo: "
                    + " \n- Nacional"
                    + " \n- Internacional");
            String clase = keyboard.next();
            aerolinea.mostrarCRuta();
            System.out.println("Ingrese el número de la ruta que desea");
            int numRuta = keyboard.nextInt();
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            int codRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
            String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();

            aerolinea.actualizar_DatosVueloHuman(actualizar, mision, numeroPH, ruta, codigoV, horario, clase, codRuta, tiempoVuelo, 0);

            System.out.println("\n\n-----------------SU VUELO FUE ACTUALIZADO CORRECTAMENTE------------------------\n\n");

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void actualizar_DatosVueloMixto() {
        //ACTUALIZAR DATOS DE VUELO MIXTO
        try {

            aerolinea.mostrarCodigoVueloMixto();
            System.out.println("Ingrese la opcion, para actualizar los datos del vuelo.\n");
            int actualizar = keyboard.nextInt();

            System.out.println("Ingrese el tipo de vuelo\n"
                    + " - Humanitario\n"
                    + " - De Pasajeros\n"
                    + " - De carga");

            String descripcion = keyboard.next();
            System.out.println("Ingrese el nuevo codigo del vuelo");
            int codigoV = keyboard.nextInt();
            System.out.println("\nIngrese la fecha y hora del vuelo"
                    + " Digite la fecha en formato MM-dd-yyyy (02-10-2021-12-30)");
            String horarioVuelo = keyboard.next();
            SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm"); // Creamos un formato de fecha
            Date horario = format.parse(horarioVuelo);
            System.out.println("Ingrese la clase de vuelo: "
                    + " \n- Nacional"
                    + " \n- Internacional");
            String clase = keyboard.next();
            aerolinea.mostrarCRuta();
            System.out.println("Ingrese el número de la ruta que desea");
            int numRuta = keyboard.nextInt();
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            int codRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
            String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
            System.out.println("Ingrese el precio del vuelo");
            int precio = keyboard.nextInt();

            aerolinea.actualizar_DatosVueloMixto(actualizar, descripcion, horario, clase, ruta, codigoV, codRuta, tiempoVuelo, precio);

            System.out.println("\n\n-----------------SU VUELO FUE ACTUALIZADO CORRECTAMENTE------------------------\n\n");

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void actualizar_DatosPiloto() {
        //ACTUALIZAR DATOS DE PILOTO
        try {

            System.out.println("\nIngrese la opcion, para actualizar los datos del piloto.\n");
            aerolinea.actualizar_DatosPiloto();

            int actualizar = keyboard.nextInt();

            aerolinea.mostrarCRuta();
            System.out.println("Ingrese el número de la ruta que desea");
            int numRuta = keyboard.nextInt();
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            System.out.println("Ingrese el nuevo sueldo del piloto");
            String sueldo = keyboard.next();
            System.out.println("Ingrese el nuevo nombre del piloto");
            String nombre = keyboard.next();
            System.out.println("Ingrese el nuevo apellido del piloto");
            String apellido = keyboard.next();
            System.out.println("Ingrese la nueva edad del piloto");
            int edad = keyboard.nextInt();
            System.out.println("Ingrese el nuevo numero de documento del piloto");
            int cc = keyboard.nextInt();

            aerolinea.actualizarPiloto(actualizar, ruta, sueldo, nombre, apellido, edad, cc);

            System.out.println("\n\n-----------------LOS DATOS DE PILOTO FUE ACTUALIZADO CORRECTAMENTE------------------------\n\n");
            menuPrincipal();

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void actualizar_AzafataComida() {
        //ACTUALIZAR DATOS DE AZAFATA DE COMIDA
        try {

            System.out.println("\nIngrese la opcion, para actualizar los datos del azafata.\n");
            aerolinea.mostrar_AzafataComida();

            int actualizar = keyboard.nextInt();

            aerolinea.mostrarCRuta();
            System.out.println("Ingrese el número de la ruta que desea");
            int numRuta = keyboard.nextInt();
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            System.out.println("Ingrese el nuevo sueldo de la azafata");
            String sueldo = keyboard.next();
            System.out.println("Ingrese el nuevo nombre de la azafata");
            String nombre = keyboard.next();
            System.out.println("Ingrese el nuevo apellido de la azafata");
            String apellido = keyboard.next();
            System.out.println("Ingrese la nueva edad de la azafata");
            int edad = keyboard.nextInt();
            System.out.println("Ingrese el nuevo turno de la azafata");
            String turno = keyboard.next();
            System.out.println("Ingrese el nuevo numero de documento de la azafata");
            int cc = keyboard.nextInt();

            aerolinea.actualizar_DatosAzafataCo(actualizar, ruta, sueldo, nombre, apellido, edad, turno, cc);

            System.out.println("\n\n-----------------LOS DATOS DE PILOTO FUE ACTUALIZADO CORRECTAMENTE------------------------\n\n");
            menuPrincipal();

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void actualizar_AzafataSeguridad() {
        //ACTUALIZAR DATOS DE AZAFATA DE SEGURIDAD
        try {

            System.out.println("\nIngrese la opcion, para actualizar los datos del azafata.\n");
            aerolinea.mostrar_AzafataSeguridad();

            int actualizar = keyboard.nextInt();

            aerolinea.mostrarCRuta();
            System.out.println("Ingrese el número de la ruta que desea");
            int numRuta = keyboard.nextInt();
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            System.out.println("Ingrese el nuevo sueldo del azafata");
            String sueldo = keyboard.next();
            System.out.println("Ingrese el nuevo nombre del azafata");
            String nombre = keyboard.next();
            System.out.println("Ingrese el nuevo apellido del azafata");
            String apellido = keyboard.next();
            System.out.println("Ingrese la nueva edad del azafata");
            int edad = keyboard.nextInt();
            System.out.println("Ingrese el nuevo turno de la azafata");
            String turno = keyboard.next();
            System.out.println("Ingrese el nuevo numero de documento del azafata");
            int cc = keyboard.nextInt();

            aerolinea.actualizar_DatosAzafataSeg(actualizar, ruta, sueldo, nombre, apellido, edad, turno, cc);
            System.out.println("\n\n-----------------LOS DATOS DE PILOTO FUE ACTUALIZADO CORRECTAMENTE------------------------\n\n");
            menuPrincipal();

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void actualizar_AzafataAtencionClien() {
        //ACTUALIZAR DATOS DE AZAFATA DE ATENCION AL CLIENTE
        try {

            System.out.println("\nIngrese la opcion, para actualizar los datos del azafata.\n");
            aerolinea.mostrar_AzafataAtencion();

            int actualizar = keyboard.nextInt();

            aerolinea.mostrarCRuta();
            System.out.println("Ingrese el número de la ruta que desea");
            int numRuta = keyboard.nextInt();
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            System.out.println("Ingrese el nuevo sueldo del azafata");
            String sueldo = keyboard.next();
            System.out.println("Ingrese el nuevo nombre del azafata");
            String nombre = keyboard.next();
            System.out.println("Ingrese el nuevo apellido del azafata");
            String apellido = keyboard.next();
            System.out.println("Ingrese la nueva edad del azafata");
            int edad = keyboard.nextInt();
            System.out.println("Ingrese el nuevo turno de la azafata");
            String turno = keyboard.next();
            System.out.println("Ingrese el nuevo numero de documento del azafata");
            int cc = keyboard.nextInt();

            aerolinea.actualizar_DatosAzafataAten(actualizar, ruta, sueldo, nombre, apellido, edad, turno, cc);

            System.out.println("\n\n-----------------LOS DATOS DE PILOTO FUE ACTUALIZADO CORRECTAMENTE------------------------\n\n");
            menuPrincipal();

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void agregar_Ruta() {
        //AGREGAR RUTA
        try {

            System.out.println("NUEVA RUTA: \n"
                    + "  - Ingrese el origen de la ruta (Pais/región)");
            String origen = keyboard.next();
            System.out.println("Ingrese el destino de la ruta (Pais/región)");
            String destino = keyboard.next();
            System.out.println("Ingrese el codigo de Ruta");
            int codigoRuta = keyboard.nextInt();
            System.out.println("Ingrese el tiempo de la Ruta");
            String tiempoR = keyboard.next();

            aerolinea.agregarListaRutas(origen, destino, codigoRuta, tiempoR);

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void registrarTrabajo() {
        //MENU REGISTRAR TRABAJO
        try {
            System.out.println("Seleccione la opcion que desea realizar "
                    + "\n - (1) Registrar Labor Azafata Comida"
                    + "\n - (2) Registrar Labor Azafata Seguridad"
                    + "\n - (3) Registrar Labor Azafata Atención al Cliente"
                    + "\n - (0) Volver");

            int opcion = keyboard.nextInt();

            if (opcion == 1) {
                registrarTrabajoAzC();
            } else if (opcion == 2) {
                registrarTrabajoAzS();
            } else if (opcion == 3) {
                registrarTrabajoAzAten();
            }else if(opcion == 0){
                menuPrincipal();
            }
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }
    
    public int buscar_AzaComidaLabor() {
        //BUSCAR CEDULA DONDE EL TRABAJO SEA NULO DE AZAFATA COMIDA
        aerolinea.mostrar_laborC();
        System.out.println("\nIngrese el documento del trabajador que desea buscar");
        int cc = keyboard.nextInt();
        return aerolinea.buscar_AzafataComida(cc);

    }
    
    public int buscar_AzaSeguridadLabor() {
        //BUSCAR CEDULA DONDE EL TRABAJO SEA NULO DE AZAFATA SEGURIDAD
        aerolinea.mostrar_laborS();
        System.out.println("\nIngrese el documento del trabajador que desea buscar");
        int cc = keyboard.nextInt();
        return aerolinea.buscar_AzafataSeguridad(cc);

    }
    
    public int buscar_AzaAtencionLabor() {
        //BUSCAR CEDULA DONDE EL TRABAJO SEA NULO DE AZAFATA ATENCION AL CLIENTE
        aerolinea.mostrar_laborAten();
        System.out.println("\nIngrese el documento del trabajador que desea buscar");
        int cc = keyboard.nextInt();
        return aerolinea.buscar_AzafataAtencion(cc);

    }

    public void registrarTrabajoAzC() {
        //REGISTRAR TRABAJO AZAFATA DE COMIDA
        try {

            int posicion = buscar_AzaComidaLabor();
            System.out.println("\n\nIngrese el tipo de plato que desea ingresar");
            String tipoC = keyboard.next();
            System.out.println("Ingrese el plato que desea ingresar");
            String plato = keyboard.next();
            System.out.println("Ingrese el horario en el cual desea ingresar esta labor"
                    + " Digite la fecha en formato MM-dd-yyyy (02-10-2021-12-30)");
            String hora = keyboard.next();

            ((Comida) aerolinea.getListaAzafata().get(posicion)).setPlato(plato);
            ((Comida) aerolinea.getListaAzafata().get(posicion)).setTipoComida(tipoC);
            ((Comida) aerolinea.getListaAzafata().get(posicion)).setHorarioComida(hora);

            aerolinea.getListaAzafata().get(posicion).registrarTrabajo();
            System.out.println("\n\n-------------REGISTRO CON EXITO LA LABOR DE AZAFATA COMIDA------------\n");
            System.out.println(((Comida) aerolinea.getListaAzafata().get(posicion)).getResultado()+"\n");
            registrarTrabajo();
            
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void registrarTrabajoAzS() {
        //REGISTRAR TRABAJO DE AZAFATA SEGURIDAD
        try {

            int posicion = buscar_AzaSeguridadLabor();
            System.out.println("\nIngrese el horario en el cual desea ingresar las intrucciones"
                    + " Digite la fecha en formato MM-dd-yyyy-H-Min (02-10-2021-12-30)");
            String hora = keyboard.next();

            System.out.println("Ingrese: \n"
                    + " - (Si) Si el chequeo de puertas es correcto"
                    + "\n - (No) Si el chequeo de puertas no es correcto");

            String chequeo = keyboard.next();

            ((Seguridad) aerolinea.getListaAzafata().get(posicion)).setHorarioInstrucci(hora);
            ((Seguridad) aerolinea.getListaAzafata().get(posicion)).setChequeoPuertas(chequeo);

            aerolinea.getListaAzafata().get(posicion).registrarTrabajo();
            System.out.println("\n\n-------------REGISTRO CON EXITO LA LABOR DE AZAFATA SEGURIDAD------------\n");
            System.out.println(((Seguridad) aerolinea.getListaAzafata().get(posicion)).getResultado()+"\n");
            registrarTrabajo();

        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void registrarTrabajoAzAten() {
        //REGISTRAR AZAFATA DE ATENCION AL CLIENTE
        try {

            int posicion = buscar_AzaAtencionLabor();
            System.out.println("\nIngrese el horario en el cual desea ingresar la atención al cliente"
                    + " Digite la fecha en formato MM-dd-yyyy-H-Min (02-10-2021-12-30)");
            String hora = keyboard.next();;

            ((AtencionCliente) aerolinea.getListaAzafata().get(posicion)).setHoraAtencion(hora);
            aerolinea.getListaAzafata().get(posicion).registrarTrabajo();
            System.out.println("\n\n-------------REGISTRO CON EXITO LA LABOR DE AZAFATA ATENCIÓN AL CLIENTE------------\n");
            System.out.println(((AtencionCliente) aerolinea.getListaAzafata().get(posicion)).getResultado()+"\n");
            registrarTrabajo();
            
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void generarTxtVuelos() {
        //SE GENERA ARCHIVO TXT DE TODO TIPO DE VUELOS
        try {
            List<String> vuelo = new ArrayList<String>();
            aerolinea.generarTxtVuelos(vuelo);

            for (String item : vuelo) {
                archi.escribirArchivo(item);
            }

            System.out.println("-----------DATOS EXPORTADOS CORRECTAMENTE A ARCHIVO DE TEXTO------------------");
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

    public void generarTxtTrabajadores() {
        //SE GENERA ARCHIVO TXT DE TODO TIPO DE TRABAJOR 
        try {
            List<String> trabajadores = new ArrayList<String>();
            aerolinea.generarTxtTrab(trabajadores);

            for (String item : trabajadores) {
                archi.escribirArchivo(item);
            }

            System.out.println("-----------DATOS EXPORTADOS CORRECTAMENTE A ARCHIVO DE TEXTO------------------");
        } catch (Exception e) {
            System.err.println("Error. Aborted system in: " + e.toString());
        }
    }

}
