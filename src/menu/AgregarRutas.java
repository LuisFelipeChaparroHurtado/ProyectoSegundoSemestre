/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA QUE SE PUEDA DAR OPCIONES A RUTAS 
    MOSTRAR RUTAS, CODIGOS Y DEMAS DATOS PARA QUE EL USUARIO PUEDA AGREGAR UNA NUEVA RUTA
 */
package menu;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logica.Aerolinea;

public class AgregarRutas extends javax.swing.JFrame implements ActionListener {

    private JLabel titulo;
    private JLabel origen;
    private JLabel destino;
    private JLabel codigoR;
    private JLabel tiempo;
    private Aerolinea aerolinea;
    private JButton agregar;
    private JButton volver;
    private JButton mostrarR;
    private JTextField origenT;
    private JTextField destinoT;
    private JTextField codigoRT;
    private JTextField tiempoT;

    public AgregarRutas(Aerolinea aerolinea) {
        //initComponents();
        this.aerolinea = aerolinea;
        
        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y IMAGEN
        
        //SE INICIALIZA PANEL Y SE LE DA TAMAÑO
        JPanel panel = new JPanel();
        panel.setLayout(null);
        setSize(500, 530);
        setLocationRelativeTo(null);
        setTitle("RUTA");
        panel.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, panel);
        
        //TITULOS
        titulo = new JLabel("AGREGAR RUTA", SwingConstants.CENTER);
        titulo.setBounds(0, 40, 500, 40);
        titulo.setFont(new Font("arial", Font.BOLD, 18));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);

        origen = new JLabel("ORIGEN: ");
        origen.setFont(new Font("arial", Font.BOLD, 15));
        origen.setBounds(90, 110, 150, 40);
        origen.setForeground(Color.WHITE);
        
        destino = new JLabel("DESTINO: ");
        destino.setFont(new Font("arial", Font.BOLD, 15));
        destino.setBounds(90, 150, 150, 40);
        destino.setForeground(Color.WHITE);
        
        codigoR = new JLabel("CODIGO RUTA: ");
        codigoR.setFont(new Font("arial", Font.BOLD, 15));
        codigoR.setBounds(90, 190, 150, 40);
        codigoR.setForeground(Color.WHITE);
        
        tiempo = new JLabel("TIEMPO DE VUELO: ");
        tiempo.setFont(new Font("arial", Font.BOLD, 15));
        tiempo.setBounds(90, 230, 150, 40);
        tiempo.setForeground(Color.WHITE);

        origenT = new JTextField();
        origenT.setBounds(270, 110, 150, 30);
        
        destinoT = new JTextField();
        destinoT.setBounds(270, 150, 150, 30);
        
        codigoRT = new JTextField();
        codigoRT.setBounds(270, 190, 150, 30);
        
        tiempoT = new JTextField();
        tiempoT.setBounds(270, 230, 150, 30);
        
        //BOTONES
        agregar = new JButton("AGREGAR");
        agregar.setBounds(50, 465, 110, 30);
        agregar.setFont(new Font("arial", Font.BOLD, 15));
        agregar.setForeground(Color.WHITE);
        agregar.setOpaque(true);
        agregar.setBackground(Color.RED);
        agregar.addActionListener(this);
        
        mostrarR = new JButton("MOSTRAR RUTA");
        mostrarR.setBounds(180, 465, 160, 30);
        mostrarR.setFont(new Font("arial", Font.BOLD, 14));
        mostrarR.setForeground(Color.WHITE);
        mostrarR.setOpaque(true);
        mostrarR.setBackground(Color.RED);
        mostrarR.addActionListener(this);

        volver = new JButton("VOLVER");
        volver.setBounds(360, 465, 100, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.setForeground(Color.WHITE);
        volver.setOpaque(true);
        volver.setBackground(Color.RED);
        volver.addActionListener(this);
        
        //IMAGEN
        ImageIcon icono = new ImageIcon("src\\resources\\ruta.jpg");
        JLabel imagen = new JLabel();
        imagen.setBounds(185, 280, 150, 150);
        imagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
        
        
        //AGREGAR ATRIBUTOS AL PANEL
        panel.add(titulo);
        panel.add(origen);
        panel.add(codigoR);
        panel.add(tiempo);
        panel.add(destino);
        panel.add(origenT);
        panel.add(destinoT);
        panel.add(codigoRT);
        panel.add(tiempoT);
        panel.add(imagen);
        panel.add(agregar);
        panel.add(volver);
        panel.add(mostrarR);
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
        
        //SE AGREGA TODOS LOS DATOS INGRESADOS A LA LISTA(CORRECTAMENTE INGRESADOS)
        if (e.getSource() == agregar) {       
        String origen = origenT.getText();
        String destino = destinoT.getText();
        int codigo=Integer.valueOf(codigoRT.getText());
        String tiempov=tiempoT.getText();
        aerolinea.agregarListaRutas(origen, destino, codigo, tiempov);
        JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
        
        //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
        origenT.setText("");
        destinoT.setText("");
        codigoRT.setText("");
        tiempoT.setText("");
        }
        
        //SE MUESTRA LA LISTA DE RUTAS POR MEDIO DE UN JFRAME CON JCROLL
        if (e.getSource() == mostrarR) {
            MostrarRutas v = new MostrarRutas(aerolinea);
            v.setVisible(true);
        }
        if (e.getSource() == volver) {
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
