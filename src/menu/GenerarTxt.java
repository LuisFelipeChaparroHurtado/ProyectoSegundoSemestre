/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA MOSTRAR OPCIONES DE 
    PODER ELEJIR QUE ES LO QUE SE DESEA GENERAR (TXT DE VUELOS O TXT DE TRABAJADORES)
 */
package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingConstants;
import logica.Aerolinea;
import resources.Archivo;

public class GenerarTxt extends javax.swing.JFrame implements ActionListener {

    private JLabel titulo;
    private Aerolinea aerolinea;
    private Archivo archi;
    private String ubicacion;
    private String nombre;
    private JButton bGenerarV;
    private JButton bGenerarT;
    private JButton volver;

    public GenerarTxt(Aerolinea aerolinea) {

        //SE INICALIZA LOS ATRIBUTOS INGRESANDO SU UBIACION Y NOMBRE DEL ARCHIVO
        ubicacion = "src\\resources\\";
        nombre = "Archivo_Proyecto.txt";

        archi = new Archivo(ubicacion, nombre);
        archi.escribirArchivo2("");
        this.aerolinea = aerolinea;

        //SE INICIALIZA PANEL Y SE LE INGRESA UN NOMBRE, TAMAÑO Y POSICION
        JPanel panel = new JPanel();
        panel.setLayout(null);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panel.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, panel);

        //TITULO
        titulo = new JLabel("GENERAR INFORMACION EN TXT", SwingConstants.CENTER);
        titulo.setBounds(0, 40, 500, 40);
        titulo.setFont(new Font("arial", Font.BOLD, 18));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);

        //BOTONES
        bGenerarV = new JButton("GENERAR INFORMACION 'VUELOS'");
        bGenerarV.setBounds(50, 200, 400, 30);
        bGenerarV.setFont(new Font("arial", Font.BOLD, 15));
        bGenerarV.setForeground(Color.BLACK);
        bGenerarV.addActionListener(this);

        bGenerarT = new JButton("GENERAR INFORMACION 'TRABAJADORES'");
        bGenerarT.setBounds(50, 250, 400, 30);
        bGenerarT.setFont(new Font("arial", Font.BOLD, 15));
        bGenerarT.setForeground(Color.BLACK);
        bGenerarT.addActionListener(this);

        volver = new JButton("VOLVER");
        volver.setBounds(185, 440, 120, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.setForeground(Color.WHITE);
        volver.setBackground(Color.RED);
        volver.addActionListener(this);

        //SE AGREGAN LOS ATRIBUTOS AL PANEL
        panel.add(titulo);
        panel.add(bGenerarV);
        panel.add(bGenerarT);
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
        //SE DA ACCION A LOS BOTONES LOS CUALES NOS GENERARAN EL TXT
        if (e.getSource() == bGenerarV) {
            List<String> vuelo = new ArrayList<String>();
            aerolinea.generarTxtVuelos(vuelo);
            for (String item : vuelo) {
                archi.escribirArchivo(item);
            }
            JOptionPane.showMessageDialog(null, "DATOS EXPORTADOS CORRECTAMENTE A ARCHIVO DE TEXTO");

        } else if (e.getSource() == bGenerarT) {
            List<String> trabajadores = new ArrayList<String>();
            aerolinea.generarTxtTrab(trabajadores);
            for (String item : trabajadores) {
                archi.escribirArchivo(item);
            }
            JOptionPane.showMessageDialog(null, "DATOS EXPORTADOS CORRECTAMENTE A ARCHIVO DE TEXTO");
        } else if (e.getSource() == volver) {
            opcionesAerolinea v = new opcionesAerolinea(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
