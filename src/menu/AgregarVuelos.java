/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA AGREGAR TODO TIPO DE VUELO 
 */
package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logica.Aerolinea;
import logica.DeCarga;
import logica.DePasajeros;
import logica.Humanitario;
import logica.Mixto;

public class AgregarVuelos extends javax.swing.JFrame implements ActionListener {

    private DePasajeros pasajeros;
    private DeCarga carga;
    private Humanitario human;
    private Mixto mix;
    private Aerolinea aerolinea;

    private JLabel titulo;
    private JLabel atrib1;
    private JLabel atrib2;
    private JLabel horario;
    private JLabel ruta;
    private JLabel claseV;
    private JLabel idV;
    private JLabel titulo2;
    private JLabel precio;
    
    private JTextField atri1;
    private JTextField atri2;
    private JTextField fecha1;
    private JTextField claV;
    private JTextField rutaT;
    private JTextField codigoV;
    private JTextField precioV;
    
    private Component comprobar;
    private JComboBox desplegable;
    
    private JButton agregar;
    private JButton volver;
    private JButton mostrarRutas;

    public AgregarVuelos(Aerolinea aerolinea) {
        
        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y IMAGEN
        
        this.aerolinea = aerolinea;
        pasajeros = new DePasajeros();
        carga = new DeCarga();
        human = new Humanitario();
        mix = new Mixto();
        desplegable = new JComboBox();
        
        //SE INICIALIZA PANEL Y SE LE DA TAMAÑO
        JPanel vuelo = new JPanel();
        vuelo.setLayout(null);
        setSize(820, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, vuelo);
        vuelo.setBackground(Color.BLACK);
        
        //TITULOS
        titulo = new JLabel("TIPO DE VUELOS", SwingConstants.CENTER);
        titulo.setFont(new Font("arial", Font.BOLD, 18));
        titulo.setIcon(new ImageIcon("src\\resources\\ima.jpg"));
        titulo.setBounds(0, 30, 820, 40);
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);
        
        titulo2 = new JLabel("", SwingConstants.CENTER);
        titulo2.setFont(new Font("arial", Font.BOLD, 18));
        titulo2.setBounds(0, 470, 820, 15);
        titulo2.setForeground(Color.WHITE);
        titulo2.setOpaque(true);
        titulo2.setBackground(Color.RED);

        atrib1 = new JLabel("", SwingConstants.RIGHT);
        atrib1.setFont(new Font("arial", 1, 14));
        atrib1.setBounds(226, 100, 190, 30);
        atrib1.setForeground(Color.WHITE);

        horario = new JLabel("HORARIO: ", SwingConstants.RIGHT);
        horario.setFont(new Font("arial", 1, 14));
        horario.setBounds(250, 140, 165, 30);
        horario.setForeground(Color.WHITE);

        ruta = new JLabel("RUTA: ", SwingConstants.RIGHT);
        ruta.setFont(new Font("arial", 1, 14));
        ruta.setBounds(250, 180, 165, 30);
        ruta.setBackground(Color.BLACK);
        ruta.setOpaque(true);
        ruta.setForeground(Color.WHITE);
        
        idV = new JLabel("CODIGO VUELO: ", SwingConstants.RIGHT);
        idV.setFont(new Font("arial", 1, 14));
        idV.setBounds(250, 220, 165, 30);
        idV.setForeground(Color.WHITE);

        precio = new JLabel("", SwingConstants.RIGHT);
        precio.setFont(new Font("arial", 1, 14));
        precio.setBounds(250, 260, 165, 30);
        precio.setForeground(Color.WHITE);

        claseV = new JLabel("CLASE DE VUELO: ", SwingConstants.RIGHT);
        claseV.setFont(new Font("arial", 1, 14));
        claseV.setBounds(250, 300, 165, 30);
        claseV.setForeground(Color.WHITE);
        
        atrib2 = new JLabel("", SwingConstants.RIGHT);
        atrib2.setFont(new Font("arial", 1, 14));
        atrib2.setBounds(250, 340, 165, 30);
        atrib2.setForeground(Color.WHITE);
        
        //JFIELDS (TEXTOS)
        atri1 = new JTextField();
        atri1.setBounds(460, 100, 165, 30);

        fecha1 = new JTextField();
        fecha1.setBounds(460, 140, 165, 30);
        
        rutaT = new JTextField();
        rutaT.setBounds(460, 180, 165, 30);
        
        codigoV = new JTextField();
        codigoV.setBounds(460, 220, 165, 30);

        precioV = new JTextField();
        precioV.setBounds(460, 260, 165, 30);

        claV = new JTextField();
        claV.setBounds(460, 300, 165, 30);

        atri2 = new JTextField();
        atri2.setBounds(460, 340, 165, 30);
        
        //BOTONES
        agregar = new JButton("AGREGAR");
        agregar.setBounds(170, 420, 200, 30);
        agregar.setFont(new Font("arial", Font.BOLD, 15));
        agregar.setForeground(Color.WHITE);
        agregar.setOpaque(true);
        agregar.setBackground(Color.RED);
        agregar.addActionListener(this);

        volver = new JButton("VOLVER");
        volver.setBounds(410, 420, 200, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.addActionListener(this);
        volver.setForeground(Color.WHITE);
        volver.setOpaque(true);
        volver.setBackground(Color.RED);
        
        mostrarRutas = new JButton("RUTAS");
        mostrarRutas.setBounds(640, 180, 150, 30);
        mostrarRutas.setFont(new Font("arial", Font.BOLD, 15));
        mostrarRutas.setForeground(Color.WHITE);
        mostrarRutas.setOpaque(true);
        mostrarRutas.setBackground(Color.RED);
        mostrarRutas.addActionListener(this);
        
        //COMBOBOX
        String vectorG[] = {"", "             " + pasajeros.getClass().getSimpleName(), "               " + carga.getClass().getSimpleName(), "             " + human.getClass().getSimpleName(), "                   " + mix.getClass().getSimpleName()};
        desplegable = new JComboBox(vectorG);
        desplegable.addActionListener(this);
        desplegable.setBounds(90, 200, 150, 30);

        //SE AGREGAN LOS ATRIBUTOS AL PANEL
        vuelo.add(titulo2);
        vuelo.add(atrib1);
        vuelo.add(atrib2);
        vuelo.add(claseV);
        vuelo.add(horario);
        vuelo.add(ruta);
        vuelo.add(idV);
        vuelo.add(precio);
        vuelo.add(atri1);
        vuelo.add(atri2);
        vuelo.add(fecha1);
        vuelo.add(claV);
        vuelo.add(rutaT);
        vuelo.add(codigoV);
        vuelo.add(precioV);
        vuelo.add(titulo);
        vuelo.add(agregar);
        vuelo.add(volver);
        vuelo.add(mostrarRutas);
        vuelo.add(desplegable);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            atri1.setEditable(true);
            fecha1.setEditable(true);
            rutaT.setEditable(true);
            claV.setEditable(true);
            codigoV.setEditable(true);
            precioV.setEditable(true);
            atri2.setEditable(true);
            
            //SE DA ACCION A LOS BOTONES LOS CUALES NOS DEJARA ENVIAR LA INFROMACION A LA LISTA 
            if (desplegable.getSelectedItem().toString().equals("             " + pasajeros.getClass().getSimpleName())) {
                precio.setText("PRECIO: ");
                precio.setForeground(Color.WHITE);
                titulo.setText("VUELO DE PASAJEROS");
                titulo.setBounds(0, 30, 820, 40);
                atrib1.setText("CANTIDAD DE PASAJEROS:");
                atri2.setEditable(false);
                if (e.getSource() == agregar) {

                    int cantidadP = Integer.valueOf(atri1.getText());
                    String clase = claV.getText();
                    String horario1 = fecha1.getText();
                    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm");
                    Date fecha = format.parse(horario1);
                    int numRuta = Integer.valueOf(rutaT.getText());
                    String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
                    int codigoRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
                    String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
                    int codigoVuelo = Integer.valueOf(codigoV.getText());
                    int precio = Integer.valueOf(precioV.getText());
                    aerolinea.agregarListaVuePasajeros(cantidadP, ruta, codigoVuelo, fecha, clase, codigoRuta, tiempoVuelo, precio);
                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");

                    atri1.setText("");
                    fecha1.setText("");
                    rutaT.setText("");
                    claV.setText("");
                    codigoV.setText("");
                    precioV.setText("");
                    atri2.setText("");
                    //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
                }
            }
            if (desplegable.getSelectedItem().toString().equals("               " + carga.getClass().getSimpleName())) {
                precio.setText("PRECIO: ");
                precio.setForeground(Color.WHITE);
                atri2.setEditable(true);
                titulo.setText("VUELO DE CARGA");
                titulo.setBounds(0, 30, 820, 40);
                atrib1.setText("NOMBRE PRODUCTOS: ");
                atrib2.setText("PESO TOTAL CARGA: ");

                if (e.getSource() == agregar) {

                    String nombreP = atri1.getText();
                    int peso = Integer.valueOf(atri2.getText());
                    int numRuta = Integer.valueOf(rutaT.getText());
                    String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
                    int codigoRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
                    String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
                    String horario = fecha1.getText();
                    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm");
                    Date fecha = format.parse(horario);
                    String clase = claV.getText();
                    int codigoVuelo = Integer.valueOf(codigoV.getText());
                    int precio = Integer.valueOf(precioV.getText());
                    aerolinea.agregarListaVueDeCarga(nombreP, peso, ruta,codigoVuelo, fecha, clase, codigoRuta,tiempoVuelo, precio);
                    
                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
                    
                    atri1.setText("");
                    fecha1.setText("");
                    rutaT.setText("");
                    claV.setText("");
                    codigoV.setText("");
                    precioV.setText("");
                    atri2.setText("");
                    //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
                }
            }
            if (desplegable.getSelectedItem().toString().equals("             " + human.getClass().getSimpleName())) {
                atri2.setEditable(true);
                precioV.setEditable(false);
                precio.setText("NO TIENE PRECIO ");
                precio.setForeground(Color.RED);
                titulo.setText("VUELO HUMANITARIO");
                titulo.setBounds(0, 30, 820, 40);
                atrib1.setText("MISION HUMANITARIA: ");
                atrib2.setText("N° DE PERSONAS: ");

                if (e.getSource() == agregar) {

                    String mision = atri1.getText();
                    int cantidadPH = Integer.valueOf(atri2.getText());
                    int numRuta = Integer.valueOf(rutaT.getText());
                    String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
                    int codigoRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
                    String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
                    String horario = fecha1.getText();
                    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm");
                    Date fecha = format.parse(horario);
                    String clase = claV.getText();
                    int codigoVuelo = Integer.valueOf(codigoV.getText());
                    aerolinea.agregarListaVueloHuman(mision, cantidadPH, ruta,codigoVuelo, fecha, clase, codigoRuta,tiempoVuelo);
                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
                    
                    atri1.setText("");
                    fecha1.setText("");
                    rutaT.setText("");
                    claV.setText("");
                    codigoV.setText("");
                    precioV.setText("");
                    atri2.setText("");
                    //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
                }

            }
            if (desplegable.getSelectedItem().toString().equals("                   " + mix.getClass().getSimpleName())) {
                precio.setText("PRECIO: ");
                precio.setForeground(Color.WHITE);
                atri2.setEditable(false);
                titulo.setText("VUELO MIXTO");
                titulo.setBounds(0, 30, 820, 40);
                atrib1.setText("DESCRIPCION CARGA: ");
                atrib2.setText("");

                if (e.getSource() == agregar) {

                    String tipoVuelo = atri1.getText();
                    int numRuta = Integer.valueOf(rutaT.getText());
                    String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
                    int codigoRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
                    String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
                    String horario = fecha1.getText();
                    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm");
                    Date fecha = format.parse(horario);
                    String clase = claV.getText();
                    int codigoVuelo = Integer.valueOf(codigoV.getText());
                    int precio = Integer.valueOf(precioV.getText());

                    aerolinea.agregarListaVueloMixto(tipoVuelo, ruta,codigoVuelo, fecha, clase, codigoRuta,tiempoVuelo, precio);
                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
                    
                    atri1.setText("");
                    fecha1.setText("");
                    rutaT.setText("");
                    claV.setText("");
                    codigoV.setText("");
                    precioV.setText("");
                    atri2.setText("");
                    //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
                }

            }
            
            //SE VERIFICA SI EL USUARIO DESEA VER LA LISTA DE LAS RUTAS
            if (e.getSource() == mostrarRutas) {
                Object[] opciones = {"ACEPTAR", "CANCELAR"};
                int eleccion = JOptionPane.showOptionDialog(comprobar, "DESEA VISUALIZAR RUTAS", "CONFIRMACIÓN",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, opciones, "ACEPTAR");

                if (eleccion == JOptionPane.YES_OPTION) {
                    MostrarRutas v = new MostrarRutas(aerolinea);
                    v.setVisible(true);
                }
            }
            if (e.getSource() == volver) {
                opcionesAerolinea v = new opcionesAerolinea(aerolinea);
                v.setUndecorated(true);
                v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
                v.setVisible(true);
                dispose();

            }
        } catch (ParseException ex) {

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
