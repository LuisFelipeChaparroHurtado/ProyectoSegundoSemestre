/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA MOSTRAR OPCIONES DE 
    PODER ELEJIR QUE INFORMACION DESEA SABER POR TIPO DE VUELO
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

public class InformacionVuelos extends javax.swing.JFrame implements ActionListener {

    private JLabel titulo;
    private JButton volver;
    private JButton bPasajeros;
    private JButton bCarga;
    private JButton bHuman;
    private JButton bMixto;
    private Aerolinea aerolinea;

    public InformacionVuelos(Aerolinea aerolinea) {
        
        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y IMAGEN
        this.aerolinea = aerolinea;

        //SE INICIALIZA PANEL Y SE LE DA TAMAÑO
        JPanel panel = new JPanel();
        panel.setLayout(null);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panel.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, panel);

        //TITULO
        titulo = new JLabel("INFORMACION DE VUELOS", SwingConstants.CENTER);
        titulo.setBounds(0, 40, 500, 40);
        titulo.setFont(new Font("arial", Font.BOLD, 18));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);

        //BOTONES
        bPasajeros = new JButton("LISTA VUELO DE PASAJEROS");
        bPasajeros.setBounds(95, 150, 300, 30);
        bPasajeros.setFont(new Font("arial", Font.BOLD, 15));
        bPasajeros.setForeground(Color.BLACK);
        bPasajeros.addActionListener(this);

        bCarga = new JButton("LISTA VUELO DE CARGA");
        bCarga.setBounds(95, 200, 300, 30);
        bCarga.setFont(new Font("arial", Font.BOLD, 15));
        bCarga.setForeground(Color.BLACK);
        bCarga.addActionListener(this);

        bHuman = new JButton("LISTA VUELO HUMANITARIO");
        bHuman.setBounds(95, 250, 300, 30);
        bHuman.setFont(new Font("arial", Font.BOLD, 15));
        bHuman.setForeground(Color.BLACK);
        bHuman.addActionListener(this);

        bMixto = new JButton("LISTA VUELO MIXTO");
        bMixto.setBounds(95, 300, 300, 30);
        bMixto.setFont(new Font("arial", Font.BOLD, 15));
        bMixto.setForeground(Color.BLACK);
        bMixto.addActionListener(this);

        volver = new JButton("VOLVER");
        volver.setBounds(185, 440, 120, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.setForeground(Color.BLACK);
        volver.setBackground(Color.RED);
        volver.addActionListener(this);
        
        //SE AGREGAN ATRIBUTOS A EL PANEL
        panel.add(titulo);
        panel.add(bPasajeros);
        panel.add(bCarga);
        panel.add(bHuman);
        panel.add(bMixto);
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
        if (e.getSource() == bPasajeros) {
            Mostrar_ListaVP v = new Mostrar_ListaVP(aerolinea);
            v.setVisible(true);
            dispose();
        } else if (e.getSource() == bCarga) {
            Mostrar_ListaVC v = new Mostrar_ListaVC(aerolinea);
            v.setVisible(true);
            dispose();
        } else if (e.getSource() == bHuman) {
            Mostrar_ListaVH v = new Mostrar_ListaVH(aerolinea);
            v.setVisible(true);
            dispose();
        } else if (e.getSource() == bMixto) {
            Mostrar_ListaVM v = new Mostrar_ListaVM(aerolinea);
            v.setVisible(true);
            dispose();
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
