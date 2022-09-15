/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA QUE SE PUEDA DAR OPCIONES A PILOTO 
    MOSTRAR RUTAS, CODIGOS Y DEMAS DATOS PARA QUE EL USUARIO PUEDA AGREGAR UN NUEVO PILOTO O DATO
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logica.Aerolinea;

public class AgregarPiloto extends javax.swing.JFrame implements ActionListener {

    private Aerolinea aerolinea;
    private JLabel titulo;
    private JLabel ruta;
    private JLabel sueldo;
    private JLabel nombre;
    private JLabel apellido;
    private JLabel edad;
    private JLabel documento;
    private JTextField tRuta;
    private JTextField tSueldo;
    private JTextField tNombre;
    private JTextField tApellido;
    private JTextField tEdad;
    private JTextField tDocumento;
    private JButton agregar;
    private JButton volver;
    private JButton mostrarRuta;
    private Component comprobar;

    public AgregarPiloto(Aerolinea aerolinea) {
        //initComponents();
        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y IMAGEN
                
        this.aerolinea = aerolinea;
        
        //SE INICIALIZA PANEL Y SE LE DA TAMAÑO
        JPanel vuelo = new JPanel();
        vuelo.setLayout(null);
        setSize(800, 530);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, vuelo);
        vuelo.setBackground(Color.BLACK);
        
        //TITULOS
        titulo = new JLabel("AGREGAR PILOTO", SwingConstants.CENTER);
        titulo.setFont(new Font("arial", Font.BOLD, 18));
        titulo.setBounds(0, 30, 800, 40);
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);

        ruta = new JLabel("NÚMERO DE RUTA:", SwingConstants.RIGHT);
        ruta.setFont(new Font("arial", 1, 14));
        ruta.setBounds(310, 140, 190, 30);
        ruta.setForeground(Color.WHITE);

        sueldo = new JLabel("SUELDO", SwingConstants.RIGHT);
        sueldo.setFont(new Font("arial", 1, 14));
        sueldo.setBounds(310, 260, 190, 30);
        sueldo.setForeground(Color.WHITE);

        nombre = new JLabel("NOMBRE: ", SwingConstants.RIGHT);
        nombre.setFont(new Font("arial", 1, 14));
        nombre.setBounds(340, 180, 165, 30);
        nombre.setForeground(Color.WHITE);

        apellido = new JLabel("APELLIDO: ", SwingConstants.RIGHT);
        apellido.setFont(new Font("arial", 1, 14));
        apellido.setBounds(340, 220, 165, 30);
        apellido.setForeground(Color.WHITE);

        edad = new JLabel("EDAD: ", SwingConstants.RIGHT);
        edad.setFont(new Font("arial", 1, 14));
        edad.setBounds(340, 300, 165, 30);
        edad.setForeground(Color.WHITE);

        documento = new JLabel("DOCUMENTO: ", SwingConstants.RIGHT);
        documento.setFont(new Font("arial", 1, 14));
        documento.setBounds(340, 340, 165, 30);
        documento.setForeground(Color.WHITE);
        
        //JFIELD (TEXTOS)
        tRuta = new JTextField();
        tRuta.setBounds(540, 140, 165, 30);

        tNombre = new JTextField();
        tNombre.setBounds(540, 180, 165, 30);

        tApellido = new JTextField();
        tApellido.setBounds(540, 220, 165, 30);

        tSueldo = new JTextField();
        tSueldo.setBounds(540, 260, 165, 30);

        tEdad = new JTextField();
        tEdad.setBounds(540, 300, 165, 30);

        tDocumento = new JTextField();
        tDocumento.setBounds(540, 340, 165, 30);

        agregar = new JButton("AGREGAR");
        agregar.setBounds(80, 460, 200, 30);
        agregar.setFont(new Font("arial", Font.BOLD, 15));
        agregar.setForeground(Color.WHITE);
        agregar.setOpaque(true);
        agregar.setBackground(Color.RED);
        agregar.addActionListener(this);

        mostrarRuta = new JButton("MOSTRAR RUTA");
        mostrarRuta.setBounds(305, 460, 200, 30);
        mostrarRuta.setFont(new Font("arial", Font.BOLD, 15));
        mostrarRuta.setForeground(Color.WHITE);
        mostrarRuta.setOpaque(true);
        mostrarRuta.setBackground(Color.RED);
        mostrarRuta.addActionListener(this);

        volver = new JButton("VOLVER");
        volver.setBounds(530, 460, 200, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.addActionListener(this);
        volver.setForeground(Color.WHITE);
        volver.setOpaque(true);
        volver.setBackground(Color.RED);
        
        //IMAGEN
        ImageIcon icono = new ImageIcon("src\\resources\\piloto.jpg");
        JLabel imagen = new JLabel();
        imagen.setBounds(50, 110, 300, 300);
        imagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));
            
        //SE AGREGAN LOS ATRIBUTOS AL PANEL 
        vuelo.add(ruta);
        vuelo.add(sueldo);
        vuelo.add(nombre);
        vuelo.add(apellido);
        vuelo.add(edad);
        vuelo.add(documento);
        vuelo.add(tRuta);
        vuelo.add(tSueldo);
        vuelo.add(tNombre);
        vuelo.add(tApellido);
        vuelo.add(tEdad);
        vuelo.add(tDocumento);
        vuelo.add(imagen);
        vuelo.add(titulo);
        vuelo.add(agregar);
        vuelo.add(mostrarRuta);
        vuelo.add(volver);
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
        
        tRuta.setEditable(true);
        tSueldo.setEditable(true);
        tNombre.setEditable(true);
        tApellido.setEditable(true);
        tEdad.setEditable(true);
        tDocumento.setEditable(true);
        
        //SE AGREGA TODOS LOS DATOS INGRESADOS A LA LISTA(CORRECTAMENTE INGRESADOS)
        if (e.getSource() == agregar) {
            int numRuta = Integer.valueOf(tRuta.getText());
            String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
            String sueldo = tSueldo.getText();
            String nombre = tNombre.getText();
            String apellido = tApellido.getText();
            int edad = Integer.valueOf(tEdad.getText());
            int cc = Integer.valueOf(tDocumento.getText());
            aerolinea.agregarListaPiloto(ruta, sueldo, nombre, apellido, edad, cc);
            JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
            
            //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
            tRuta.setText("");
            tSueldo.setText("");
            tNombre.setText("");
            tApellido.setText("");
            tEdad.setText("");
            tDocumento.setText("");
        }
        if (e.getSource() == volver) {
            AgregarTrabajador v = new AgregarTrabajador(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();

        }
        
        //SE VERIFICA SI EL USUARIO DESEA VER LA LISTA DE LAS RUTAS
        if (e.getSource() == mostrarRuta) {
            Object[] opciones = {"ACEPTAR", "CANCELAR"};
            int eleccion = JOptionPane.showOptionDialog(comprobar, "DESEA VISUALIZAR RUTAS", "CONFIRMACIÓN",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, opciones, "ACEPTAR");

            if (eleccion == JOptionPane.YES_OPTION) {
                MostrarRutas v = new MostrarRutas(aerolinea);
                v.setVisible(true);
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
