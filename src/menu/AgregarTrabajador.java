/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA DAR DOS OPCIONES AL 
    USUARIO PARA ELEGIR QUE OPCIÓN  DESEA ELEJIR (AGREGAR PILOTO, AGREGAR 
    AZAFATA 'COMIDA', AZAFATA 'SEGURIDAD' Y AZAFATA 'ATENCIÓN AL CLIENTE')
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

public class AgregarTrabajador extends javax.swing.JFrame implements ActionListener {

    private JLabel titulo;
    private JButton volver;
    private JButton bPiloto;
    private JButton bAzafataC;
    private JButton bAzafataS;
    private JButton bAzafataAt;
    private Aerolinea aerolinea;

    public AgregarTrabajador(Aerolinea aerolinea) {
        //initComponents();
        this.aerolinea = aerolinea;
        
        //SE CREA PANEL SE LE DA TITULO Y TAMAÑO
        JPanel panel = new JPanel();
        panel.setLayout(null);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panel.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, panel);

        //TITULOS
        titulo = new JLabel("AGREGAR TRABAJADOR", SwingConstants.CENTER);
        titulo.setBounds(0, 40, 500, 40);
        titulo.setFont(new Font("arial", Font.BOLD, 18));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);
        
        //BOTONES
        bPiloto = new JButton("AGREGAR TRABAJADOR 'PILOTO'");
        bPiloto.setBounds(65, 150, 380, 30);
        bPiloto.setFont(new Font("arial", Font.BOLD, 15));
        bPiloto.setForeground(Color.BLACK);
        bPiloto.addActionListener(this);

        bAzafataC = new JButton("AGREGAR TRABAJADOR 'AZAFATA COMIDA'");
        bAzafataC.setBounds(65, 200, 380, 30);
        bAzafataC.setFont(new Font("arial", Font.BOLD, 15));
        bAzafataC.setForeground(Color.BLACK);
        bAzafataC.addActionListener(this);

        bAzafataS = new JButton("AGREGAR TRABAJADOR 'AZAFATA SEGURIDAD'");
        bAzafataS.setBounds(65, 250, 380, 30);
        bAzafataS.setFont(new Font("arial", Font.BOLD, 15));
        bAzafataS.setForeground(Color.BLACK);
        bAzafataS.addActionListener(this);

        bAzafataAt = new JButton("AGREGAR TRABAJADOR 'AZ.ATENCIÓN_CLIEN'");
        bAzafataAt.setBounds(65, 300, 380, 30);
        bAzafataAt.setFont(new Font("arial", Font.BOLD, 15));
        bAzafataAt.setForeground(Color.BLACK);
        bAzafataAt.addActionListener(this);

        volver = new JButton("VOLVER");
        volver.setBounds(185, 440, 120, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.setForeground(Color.WHITE);
        volver.setBackground(Color.RED);
        volver.addActionListener(this);
        
        //AGREGAR AL PANEL
        panel.add(titulo);
        panel.add(bPiloto);
        panel.add(bAzafataC);
        panel.add(bAzafataS);
        panel.add(bAzafataAt);
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
        if (e.getSource() == bPiloto) {
            AgregarPiloto v = new AgregarPiloto(aerolinea);  
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
        } else if (e.getSource() == bAzafataC) {
            Agregar_AzafataC v = new Agregar_AzafataC(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
        } else if (e.getSource() == bAzafataS) {
            Agregar_AzafataS v = new Agregar_AzafataS(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
        } else if (e.getSource() == bAzafataAt) {
            Agregar_AzafataAten v = new Agregar_AzafataAten(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
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
