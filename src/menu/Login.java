/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO EL LOGIN DE LA AEROLINEA CON UN PASSWORD Y UN USUARIO 
    LOS CUALES TAN SOLO LO TIENEN EL ADMINITRADOR MANTENIENTO UNA SEGURIDAD.
 */
package menu;

import java.awt.*;
import javax.swing.*;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logica.Aerolinea;

public class Login extends javax.swing.JFrame implements ActionListener {

    private Button ingresar, salir;
    private JLabel iniciarSesion;
    private JLabel titulo;
    private JLabel nombreU;
    private JLabel nombreC;
    private JTextField usuario;
    private JPasswordField password;
    private Component confirmation;
    private Aerolinea aerolinea;

    public Login(Aerolinea aerolinea) {
      //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y IMAGEN
        
        this.aerolinea=aerolinea;
        
        //SE INICIALIZA PANEL Y SE LE DA TAMAÑO
        JPanel panel = new JPanel();
        panel.setLayout(null);
        setSize(500, 500);
        setLocationRelativeTo(null);
        panel.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, panel);
        
        //TITULO
        iniciarSesion = new JLabel("INICIAR SESIÓN", SwingConstants.CENTER);
        iniciarSesion.setBounds(0, 20, 500, 40);
        iniciarSesion.setFont(new Font("arial", Font.BOLD, 20));
        iniciarSesion.setForeground(Color.WHITE);
        iniciarSesion.setOpaque(true);
        iniciarSesion.setBackground(Color.RED);
        
        titulo = new JLabel("", SwingConstants.CENTER);
        titulo.setBounds(0, 480, 500, 10);
        titulo.setFont(new Font("arial", Font.BOLD, 20));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);
        
        nombreU = new JLabel("USUARIO: ", SwingConstants.CENTER);
        nombreU.setBounds(133, 110, 200, 30);
        nombreU.setFont(new Font("arial", Font.BOLD, 15));
        nombreU.setForeground(Color.WHITE);
        
        nombreC = new JLabel("CONTRASEÑA: ", SwingConstants.CENTER);
        nombreC.setBounds(150, 210, 200, 30);
        nombreC.setFont(new Font("arial", Font.BOLD, 15));
        nombreC.setForeground(Color.WHITE);
        
        //IMAGEN PASSWORD
        ImageIcon icono = new ImageIcon("src\\resources\\Contraseña.png");
        JLabel imagenC = new JLabel();
        imagenC.setBounds(95, 240, 70, 50);
        imagenC.setIcon(new ImageIcon(icono.getImage().getScaledInstance(imagenC.getWidth(), imagenC.getHeight(), Image.SCALE_SMOOTH)));
        
        //IMAGEN USUARIO
        ImageIcon icono2 = new ImageIcon("src\\resources\\Usuario.png");
        JLabel imagenU = new JLabel();
        imagenU.setBounds(95, 140, 70, 50);
        imagenU.setIcon(new ImageIcon(icono2.getImage().getScaledInstance(imagenC.getWidth(), imagenC.getHeight(), Image.SCALE_SMOOTH)));
        
        //JTEXTFIELD (ESPACIO DE TEXTO)
        usuario = new JTextField("", SwingConstants.CENTER);
        usuario.setBounds(195, 150, 200, 30);
        
        //JPASSWORD (ESPACIO DE TEXTO QUE LO CONVIERTE EN TIPO PASSWORD)
        password = new JPasswordField("", SwingConstants.CENTER);
        password.setBounds(195, 245, 200, 30);
        
        //BOTONES
        ingresar = new Button("LOGIN");
        ingresar.setBounds(70, 340, 350, 40);
        ingresar.setFont(new Font("arial", Font.BOLD, 15));
        ingresar.setBackground(Color.RED);
        ingresar.setForeground(Color.WHITE);
        ingresar.addActionListener(this);

        salir = new Button("SALIR");
        salir.setBounds(70, 390, 350, 40);
        salir.setFont(new Font("arial", Font.BOLD, 15));
        salir.setBackground(Color.RED);
        salir.setForeground(Color.WHITE);
        salir.addActionListener(this);
        
        //SE  AGREGA LOS ATRIBUTOS A EL PANEL
        panel.add(iniciarSesion);
        panel.add(titulo);
        panel.add(nombreU);
        panel.add(nombreC);
        panel.add(usuario);
        panel.add(password);
        panel.add(imagenU);
        panel.add(imagenC);
        panel.add(ingresar);
        panel.add(salir);

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
        
        //SE DA ACCION A LA OPCION DE INGRESAR PARA ASI COMPARAR SI LA CONTRASEÑA Y EL PASSWORD ESTA CORRECTO
        if (e.getSource() == ingresar) {
            String usu = "Admin";
            String contra = "admin";
            String pass = new String(password.getPassword());
            //SE COMPARA LOS ESPACIOS DE TEXTOS CON LA CONTRASEÑA Y USUARIO QUE ESTA PREDETERMINADA
            if (usuario.getText().equals(usu) && pass.equals(contra)) {
                //SE ENVIA A UN JFRAME DE LA PLATAFORMA PRINCIPAL
                opcionesAerolinea inicio = new opcionesAerolinea(aerolinea);
                inicio.setUndecorated(true);
                inicio.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
                inicio.setVisible(true);
                dispose();
                
            } else {
                //SI ALGUNO DE LOS DATOS ESTAN ERRONEOS BOTE UN MENSAJE DE ERROR.Y LOS TEXTOS DE BORREN.
                JOptionPane.showMessageDialog(this, "USUARIO / CONTRASEÑA INCORRECTA");
                usuario.setText("");
                password.setText("");
            }
        }

        if (e.getSource() == salir) {
            //SE VERIFICA SI EL USUARIO DESEA SALIR.
            Object[] opciones = {"ACEPTAR", "CANCELAR"};
            int eleccion = JOptionPane.showOptionDialog(confirmation, "DESEA SALIR DEL SISTEMA", "CONFIRMACIÓN",
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
