/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA MOSTRAR OPCIONES DE 
    PODER ELEJIR QUE ES LO QUE SE DESEA BUSCAR
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
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import logica.Aerolinea;

public class Buscar extends javax.swing.JFrame implements ActionListener{
    
    private Aerolinea aerolinea;
    private JButton mostrarVuelo;
    private JButton mostrarTrabajador;
    private JButton volver;
    private JLabel titulo;
  
    public Buscar(Aerolinea aerolinea) {
        //initComponents();
        
        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y IMAGEN
        this.aerolinea=aerolinea;
        
        //SE INICIALIZA PANEL Y SE LE DA TAMAÑO
        JPanel panel = new JPanel();
        panel.setLayout(null);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("BUSCAR");
        panel.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, panel);
        
        //TITULOS
        titulo = new JLabel("BUSCAR", SwingConstants.CENTER);
        titulo.setBounds(0, 40, 500, 40);
        titulo.setFont(new Font("arial", Font.BOLD, 17));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);
        
        //BOTONES
        mostrarVuelo = new JButton("BUSCAR VUELOS");
        mostrarVuelo.setBounds(130, 200, 250, 30);
        mostrarVuelo.setFont(new Font("arial", Font.BOLD, 15));
        mostrarVuelo.setForeground(Color.BLACK);
        mostrarVuelo.addActionListener(this);
        
        mostrarTrabajador = new JButton("BUSCAR TRABAJADORES");
        mostrarTrabajador.setBounds(130, 250, 250, 30);
        mostrarTrabajador.setFont(new Font("arial", Font.BOLD, 15));
        mostrarTrabajador.setForeground(Color.BLACK);
        mostrarTrabajador.addActionListener(this);
        
        volver = new JButton("VOLVER");
        volver.setBounds(200, 440, 100, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.setForeground(Color.WHITE);
        volver.setOpaque(true);
        volver.setBackground(Color.RED);
        volver.addActionListener(this);
        
        //SE AGREGAN LOS ATRIBUTOS AL PANEL 
        panel.add(titulo);
        panel.add(mostrarVuelo);
        panel.add(mostrarTrabajador);
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
        if(e.getSource() == mostrarVuelo){
            BuscarVuelo v = new BuscarVuelo(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
        }
        if(e.getSource() == mostrarTrabajador){
            BuscarTrabajador v = new BuscarTrabajador(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
