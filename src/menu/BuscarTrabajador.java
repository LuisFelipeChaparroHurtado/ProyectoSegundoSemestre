/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA MOSTRAR OPCIONES DE 
    PODER ELEJIR CUAL ES TIPO DE TRABAJADOR QUE SE DESEA BUSCAR
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

public class BuscarTrabajador extends javax.swing.JFrame implements ActionListener{
    
    private Aerolinea aerolinea;
    private JButton mostrarAzafata;
    private JButton mostrarPiloto;
    private JButton volver;
    private JLabel titulo;
  
    public BuscarTrabajador(Aerolinea aerolinea) {
        //initComponents();
        
        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y IMAGEN
        this.aerolinea=aerolinea;
        
        //SE INICIALIZA PANEL Y SE LE DA TAMAÑO
        JPanel panel = new JPanel();
        panel.setLayout(null);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("BUSCAR TRABAJADOR");
        panel.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, panel);
        
        //TITULOS
        titulo = new JLabel("BUSCAR TRABAJADOR", SwingConstants.CENTER);
        titulo.setBounds(0, 40, 500, 40);
        titulo.setFont(new Font("arial", Font.BOLD, 17));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);
        
        //BOTONES
        mostrarAzafata = new JButton("BUSCAR AZAFATAS");
        mostrarAzafata.setBounds(130, 200, 250, 30);
        mostrarAzafata.setFont(new Font("arial", Font.BOLD, 15));
        mostrarAzafata.setForeground(Color.BLACK);
        mostrarAzafata.addActionListener(this);
        
        mostrarPiloto = new JButton("BUSCAR PILOTOS");
        mostrarPiloto.setBounds(130, 250, 250, 30);
        mostrarPiloto.setFont(new Font("arial", Font.BOLD, 15));
        mostrarPiloto.setForeground(Color.BLACK);
        mostrarPiloto.addActionListener(this);
        
        volver = new JButton("VOLVER");
        volver.setBounds(200, 440, 100, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.setForeground(Color.WHITE);
        volver.setOpaque(true);
        volver.setBackground(Color.RED);
        volver.addActionListener(this);
        
        //SE AGREGAN LOS ATRIBUTOS AL PANEL
        panel.add(titulo);
        panel.add(mostrarAzafata);
        panel.add(mostrarPiloto);
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
            Buscar v = new Buscar(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
        }
        if(e.getSource() == mostrarAzafata){
            BuscarAzafata v = new BuscarAzafata(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
        }
        if(e.getSource() == mostrarPiloto){
            BuscarPiloto v = new BuscarPiloto(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
