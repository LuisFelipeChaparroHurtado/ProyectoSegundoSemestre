/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.AtencionCliente;
import logica.Azafata;
import logica.Comida;
import logica.Seguridad;
import menu.Menu;

public class Archivo {

    private String ubicacion;
    private String nombre;

    public Archivo(String ubicacion, String nombre) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
    }
    

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void cargarArchivo() {
        FileReader fr = null;
        try {
            //"C:\\archivo.txt"
            File archivo = new File(ubicacion + nombre);
            fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            // Lectura del archivo
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);

            }

        } catch (Exception ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void escribirArchivo(String texto) {

        FileWriter archivo = null;
        PrintWriter pw = null;
        try {
            archivo = new FileWriter(ubicacion + nombre, true);
            pw = new PrintWriter(archivo);
            pw.println(texto);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el archivo.
                if (null != archivo) {
                    archivo.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void escribirArchivo2(String texto) {
        FileWriter archivo = null;
        PrintWriter pw = null;
        try {
            archivo = new FileWriter(ubicacion + nombre);
            pw = new PrintWriter(archivo);

            pw.println("---------------------------------------------------------\n"
                    + "                     AEROLINEA\n"
                    + "               INGENIERIA EN SISTEMAS\n"
                    + "       CREADO POR: LUIS FELIPE CHAPARRO HURTADO\n"
                    + "---------------------------------------------------------\n\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para 
                // asegurarnos que se cierra el archivo.
                if (null != archivo) {
                    archivo.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }

    public List<Azafata> leerArchivoC(List<Azafata> azafata) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("src\\resources\\comida.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea = "";
            int pos = 0;

             while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                   ((Comida)azafata.get(pos)).setPlato(partes[0]);
                   ((Comida)azafata.get(pos)).setHorarioComida(partes[2]);
                   ((Comida)azafata.get(pos)).setTipoComida(partes[1]);
                pos++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return azafata;
    }
    
    public List<Azafata> leerArchivoSe(List<Azafata> azafata) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("src\\resources\\seguridad.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea = "";
            int pos = 10;

             while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                   ((Seguridad)azafata.get(pos)).setHorarioInstrucci(partes[0]);
                   ((Seguridad)azafata.get(pos)).setChequeoPuertas(partes[1]);
                pos++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return azafata;
    }
    
     public List<Azafata> leerArchivoAten(List<Azafata> azafata) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File("src\\resources\\atencionCliente.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea = "";
            int pos = 20;

             while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                   ((AtencionCliente)azafata.get(pos)).setHoraAtencion(partes[0]);
                pos++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return azafata;
    }
    
}
