/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA DAR DOS OPCIONES AL 
    USUARIO PARA ELEGIR QUE OPCIÓN  DESEA ELEJIR (ACTUALIZAR TRABAJADORES O ACTUALIZAR VUELOS)
 */
package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import logica.Aerolinea;


public class Actualizar_Datos extends javax.swing.JFrame implements ActionListener{
    
    //SE INICIALIZA ATRIBUTOS ESPECIFICOS DE EL JFRAME
    private Aerolinea aerolinea;
    private JLabel titulo;
    private JButton actualizarVuelo;
    private JButton actualizarTrabajador;
    private JButton volver;
    
    public Actualizar_Datos(Aerolinea aerolinea) {
        
        this.aerolinea=aerolinea;
        
        //SE CREA PANEL SE LE DA TITULO Y TAMAÑO
        JPanel panel = new JPanel();
        panel.setLayout(null);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("ACTUALIZAR");
        panel.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, panel);
        
        //SE CREA TITULO SE LE DA TAMAÑO COLOR Y FONDO
        titulo = new JLabel("ACTUALIZAR DATOS", SwingConstants.CENTER);
        titulo.setBounds(0, 40, 500, 40);
        titulo.setFont(new Font("arial", Font.BOLD, 17));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);
        
        //SE CREA BOTONES. SE DA TAMAÑO, COLOR DE BOTON Y DE LETRA
        
        actualizarVuelo = new JButton("ACTUALIZAR VUELOS");
        actualizarVuelo.setBounds(130, 200, 250, 30);
        actualizarVuelo.setFont(new Font("arial", Font.BOLD, 15));
        actualizarVuelo.setForeground(Color.BLACK);
        actualizarVuelo.addActionListener(this);
        
        actualizarTrabajador = new JButton("ACTUALIZAR TRABAJADORES");
        actualizarTrabajador.setBounds(130, 250, 250, 30);
        actualizarTrabajador.setFont(new Font("arial", Font.BOLD, 15));
        actualizarTrabajador.setForeground(Color.BLACK);
        actualizarTrabajador.addActionListener(this);
        
        volver = new JButton("VOLVER");
        volver.setBounds(200, 440, 100, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.setForeground(Color.WHITE);
        volver.setOpaque(true);
        volver.setBackground(Color.RED);
        volver.addActionListener(this);
        
        //SE AGREGAN ATRIBUTOS CREADOS (BOTONES, TITULOS) AL PANEL
        panel.add(titulo);
        panel.add(actualizarVuelo);
        panel.add(actualizarTrabajador);
        panel.add(volver);
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
        if(e.getSource() == volver){
            opcionesAerolinea v = new opcionesAerolinea(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
        }
        if(e.getSource() == actualizarVuelo){
            Actualizar_Vuelos v = new Actualizar_Vuelos(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
            
            JOptionPane.showMessageDialog(null, "HAGA CLICK EN MOSTRAR CODIGOS"
            + "\nINGRESE EL NUMERO DE VUELO (1 O 2 ETC) QUE DESEA ACTUALIZAR EN EL ESPACIO"
            + "\nDE TEXTO DE BUSCAR CODIGO. SEGÚN EL NUMERO DE VUELO");
        }
        if(e.getSource() == actualizarTrabajador){
            Actualizar_Trabajadores v = new Actualizar_Trabajadores(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
            
            JOptionPane.showMessageDialog(null, "HAGA CLICK EN MOSTRAR CEDULAS"
            + "\nINGRESE EL NUMERO EN EL QUE SE UBICA EL TRABAJADOR (1 O 2 ETC) QUE DESEA ACTUALIZAR, EN EL ESPACIO"
            + "\nDE TEXTO DE BUSCAR CODIGO. SEGÚN EL NUMERO DE VUELO");
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
