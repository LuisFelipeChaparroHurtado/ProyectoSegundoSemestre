/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA MOSTRAR OPCIONES DE 
    LA PAGINA PRINCIPAL DE LA AEROLINEA
 */
package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import logica.Aerolinea;

public class opcionesAerolinea extends javax.swing.JFrame implements ActionListener {

    private JLabel titulo1;
    private JLabel titulo2;
    private JButton agregarVuelo;
    private JButton agregarTrabajador;
    private JButton infoVuelos;
    private JButton infoTrabaja;
    private JButton buscar;
    private JButton actualizarDatos;
    private JButton agregarRuta;
    private JButton registrarT;
    private JButton generarTxt;
    private JButton salir;
    private Component comprobar;
    private Aerolinea aerolinea;

    public opcionesAerolinea(Aerolinea aerolinea) {

        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y IMAGEN
        this.aerolinea = aerolinea;

        //SE INICIALIZA PANEL Y SE LE DA TAMAÑO
        JPanel inicio = new JPanel();
        inicio.setLayout(null);
        setSize(800, 550);
        setLocationRelativeTo(null);
        inicio.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, inicio);

        //TITULOS
        titulo1 = new JLabel("BIENVENIDO A SU AEROLINEA", SwingConstants.CENTER);
        titulo1.setBounds(0, 30, 800, 50);
        titulo1.setFont(new Font("arial", Font.BOLD, 20));
        titulo1.setForeground(Color.WHITE);
        titulo1.setOpaque(true);
        titulo1.setBackground(Color.RED);
        titulo1.setOpaque(true);

        titulo2 = new JLabel("", SwingConstants.CENTER);
        titulo2.setBounds(0, 510, 800, 20);
        titulo2.setFont(new Font("arial", Font.BOLD, 20));
        titulo2.setForeground(Color.WHITE);
        titulo2.setOpaque(true);
        titulo2.setBackground(Color.RED);
        titulo2.setOpaque(true);

        //BOTONES
        agregarVuelo = new JButton("AGREGAR VUELO");
        agregarVuelo.setBounds(400, 100, 300, 30);
        agregarVuelo.setFont(new Font("arial", Font.BOLD, 15));
        agregarVuelo.addActionListener(this);

        agregarTrabajador = new JButton("AGREGAR TRABAJADOR");
        agregarTrabajador.setBounds(400, 140, 300, 30);
        agregarTrabajador.setFont(new Font("arial", Font.BOLD, 15));
        agregarTrabajador.addActionListener(this);

        infoVuelos = new JButton("INFORMACIÓN VUELOS");
        infoVuelos.setBounds(400, 180, 300, 30);
        infoVuelos.setFont(new Font("arial", Font.BOLD, 15));
        infoVuelos.addActionListener(this);

        infoTrabaja = new JButton("INFORMACIÓN TRABAJADORES");
        infoTrabaja.setBounds(400, 220, 300, 30);
        infoTrabaja.setFont(new Font("arial", Font.BOLD, 15));
        infoTrabaja.addActionListener(this);

        buscar = new JButton("BUSCAR");
        buscar.setBounds(400, 260, 300, 30);
        buscar.setFont(new Font("arial", Font.BOLD, 15));
        buscar.addActionListener(this);

        actualizarDatos = new JButton("ACTUALIZAR DATOS");
        actualizarDatos.setBounds(400, 300, 300, 30);
        actualizarDatos.setFont(new Font("arial", Font.BOLD, 15));
        actualizarDatos.addActionListener(this);

        agregarRuta = new JButton("AGREGAR RUTA");
        agregarRuta.setBounds(400, 340, 300, 30);
        agregarRuta.setFont(new Font("arial", Font.BOLD, 15));
        agregarRuta.addActionListener(this);

        registrarT = new JButton("REGISTRAR TRABAJO");
        registrarT.setBounds(400, 380, 300, 30);
        registrarT.setFont(new Font("arial", Font.BOLD, 15));
        registrarT.addActionListener(this);

        generarTxt = new JButton("GENERAR TXT");
        generarTxt.setIcon(new ImageIcon("src\\resources\\txt.png"));
        generarTxt.setBounds(400, 420, 300, 30);
        generarTxt.setFont(new Font("arial", Font.BOLD, 15));
        generarTxt.addActionListener(this);

        salir = new JButton("SALIR");
        salir.setBounds(400, 460, 300, 30);
        salir.setFont(new Font("arial", Font.BOLD, 15));
        salir.addActionListener(this);

        
        
        //IMAGEN
        ImageIcon icono = new ImageIcon("src\\resources\\avion.jpg");
        JLabel imagen = new JLabel();
        imagen.setBounds(50, 140, 300, 300);
        imagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));

        //SE AGREGAN LOS ATRIBUTOS AL PANEL
        inicio.add(titulo1);
        inicio.add(titulo2);
        inicio.add(agregarVuelo);
        inicio.add(agregarTrabajador);
        inicio.add(infoVuelos);
        inicio.add(infoTrabaja);
        inicio.add(buscar);
        inicio.add(actualizarDatos);
        inicio.add(agregarRuta);
        inicio.add(registrarT);
        inicio.add(generarTxt);
        inicio.add(salir);
        inicio.add(imagen);

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

        //SE DA ACCION A LOS BOTONES LOS CUALES NOS DIRIJIRAN A OTRAS CLASES ESPECIFICAS
        if (e.getSource() == agregarVuelo) {
            
            AgregarVuelos v = new AgregarVuelos(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();

        } else if (e.getSource() == agregarTrabajador) {

            AgregarTrabajador v = new AgregarTrabajador(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();

        } else if (e.getSource() == infoVuelos) {
            InformacionVuelos info = new InformacionVuelos(aerolinea);
            info.setUndecorated(true);
            info.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            info.setVisible(true);
            dispose();

        } else if (e.getSource() == infoTrabaja) {

            InformacionTrabajadores info = new InformacionTrabajadores(aerolinea);
            info.setUndecorated(true);
            info.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            info.setVisible(true);
            dispose();

        } else if (e.getSource() == buscar) {

            Buscar info = new Buscar(aerolinea);
            info.setUndecorated(true);
            info.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            info.setVisible(true);
            dispose();

        } else if (e.getSource() == actualizarDatos) {

            Actualizar_Datos info = new Actualizar_Datos(aerolinea);
            info.setUndecorated(true);
            info.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            info.setVisible(true);
            dispose();

        } else if (e.getSource() == agregarRuta) {
            AgregarRutas info = new AgregarRutas(aerolinea);
            info.setUndecorated(true);
            info.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            info.setVisible(true);
            dispose();
        } else if (e.getSource() == registrarT) {
            RegistrarTrabajo info = new RegistrarTrabajo(aerolinea);
            info.setUndecorated(true);
            info.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            info.setVisible(true);
            dispose();

        } else if (e.getSource() == generarTxt) {
            GenerarTxt info = new GenerarTxt(aerolinea);
            info.setUndecorated(true);
            info.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            info.setVisible(true);
            dispose();

        } else if (e.getSource() == salir) {
            //CONFIRMACIÓN DE SALIDA DE LA PLATAFORMA
            Object[] opciones = {"ACEPTAR", "CANCELAR"};
            int eleccion = JOptionPane.showOptionDialog(comprobar, "DESEA SALIR DEL SISTEMA", "CONFIRMACIÓN",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "ACEPTAR");

            if (eleccion == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
