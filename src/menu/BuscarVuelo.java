/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA MOSTRAR OPCIONES DE 
    PODER ELEJIR CUAL ES TIPO DE VUELO QUE SE DESEA BUSCAR
 */
package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logica.Aerolinea;
import logica.DeCarga;
import logica.DePasajeros;
import logica.Humanitario;
import logica.Mixto;

public class BuscarVuelo extends javax.swing.JFrame implements ActionListener {

    private Aerolinea aerolinea;
    private DePasajeros pasajeros;
    private DeCarga carga;
    private Humanitario human;
    private Mixto mixto;
    private JLabel titulo;
    private JLabel id;
    private JButton buscar;
    private JButton volver;
    private JComboBox desplegable;
    private JTextArea area;
    private JTextField codigos;
    private Boolean verificar;

    public BuscarVuelo(Aerolinea aerolinea) {

        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y IMAGEN
        this.aerolinea = aerolinea;
        this.pasajeros = new DePasajeros();
        this.carga = new DeCarga();
        this.human = new Humanitario();
        this.mixto = new Mixto();
        verificar = false;

        //SE INICIALIZA PANEL Y SE LE DA TAMAÑO 
        JPanel panel = new JPanel();
        panel.setLayout(null);
        setSize(500, 510);
        setLocationRelativeTo(null);
        setTitle("BUSCAR VUELO");
        panel.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, panel);

        //TITULOS
        titulo = new JLabel("BUSCAR VUELO", SwingConstants.CENTER);
        titulo.setBounds(0, 40, 500, 40);
        titulo.setFont(new Font("arial", Font.BOLD, 16));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);

        id = new JLabel("INGRESE EL CODIGO DEL VUELO", SwingConstants.CENTER);
        id.setBounds(40, 380, 280, 25);
        id.setFont(new Font("arial", Font.BOLD, 15));
        id.setForeground(Color.WHITE);

        //BOTONES
        buscar = new JButton("BUSCAR");
        buscar.setBounds(130, 440, 100, 30);
        buscar.setFont(new Font("arial", Font.BOLD, 15));
        buscar.setForeground(Color.WHITE);
        buscar.setOpaque(true);
        buscar.setBackground(Color.RED);
        buscar.addActionListener(this);

        volver = new JButton("VOLVER");
        volver.setBounds(280, 440, 100, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.setForeground(Color.WHITE);
        volver.setOpaque(true);
        volver.setBackground(Color.RED);
        volver.addActionListener(this);

        //JTEXTAREA (TEXTOS)
        area = new JTextArea();
        area.setBounds(210, 110, 245, 230);

        codigos = new JTextField();
        codigos.setBounds(340, 382, 100, 20);

        //COMBOBOX
        desplegable = new JComboBox();
        String vectorG[] = {"", "             " + pasajeros.getClass().getSimpleName(), "               " + carga.getClass().getSimpleName(), "             " + human.getClass().getSimpleName(), "                   " + mixto.getClass().getSimpleName()};
        desplegable = new JComboBox(vectorG);
        desplegable.addActionListener(this);
        desplegable.setBounds(30, 200, 150, 30);

        //SE AGREGAN LOS ATRIBUTOS AL PANEL
        panel.add(desplegable);
        panel.add(titulo);
        panel.add(id);
        panel.add(buscar);
        panel.add(area);
        panel.add(codigos);
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

        //SE COMPARA CON EL DEPLEGABLE Y SI ES IGUAL A EL NOMBRE DE LA CLASE TRAERA ATRIBUTOS E INFROMACIÓN DE ESA CLASE 
        if (desplegable.getSelectedItem().toString().equals("             " + pasajeros.getClass().getSimpleName())) {
            area.setText(aerolinea.mostrar_CodigoVueloPasajeros());
            /*SE BUSCA DENTRO DE LA LISTA DE CODIGOS SI PERTENECE A ESA CLASE. 
            SI PERTENECE SE TRAE INFORMACION ESPECIFICA DE ESE TIPO DE VUELO*/
            if (e.getSource() == buscar) {
                verificar=false;
                codigos.setEditable(true);
                int codigoN = Integer.valueOf(codigos.getText());
                for (int i = 0; i < aerolinea.getListaVuelos().size(); i++) {
                    if (aerolinea.getListaVuelos().get(i).getClass().getSimpleName().equals("DePasajeros")) {
                        if (codigoN == (((DePasajeros) aerolinea.getListaVuelos().get(i)).getCodigo())) {
                            area.setText("\n\n\nCANTIDAD PASAJEROS: " + ((DePasajeros) aerolinea.getListaVuelos().get(i)).getCantidadPasajeros()
                                    + "\nRUTA: " + aerolinea.getListaVuelos().get(i).getRuta()
                                    + "\nCODIGO VUELO: " + aerolinea.getListaVuelos().get(i).getCodigo()
                                    + "\nTIPO DE VUELO: " + aerolinea.getListaVuelos().get(i).getClass().getSimpleName()
                                    + "\nFECHA: " + aerolinea.getListaVuelos().get(i).getHorario()
                                    + "\nCLASE: " + aerolinea.getListaVuelos().get(i).getClaseVuelo()
                                    + "\nCODIGO RUTA: " + aerolinea.getListaVuelos().get(i).getCodigoRuta()
                                    + "\nTIEMPO RUTA: " + aerolinea.getListaVuelos().get(i).getTiempoVuelo()
                                    + "\nPRECIO: " + aerolinea.getListaVuelos().get(i).getPrecio());
                            verificar = true;
                        }    
                    }
                }
                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                }
                codigos.setText("");
            }
        }
        if (desplegable.getSelectedItem().toString().equals("               " + carga.getClass().getSimpleName())) {
            codigos.setEditable(true);
            area.setText(aerolinea.mostrar_CodigoVueloCarga());
            /*SE BUSCA DENTRO DE LA LISTA DE CODIGOS SI PERTENECE A ESA CLASE. 
            SI PERTENECE SE TRAE INFORMACION ESPECIFICA DE ESE TIPO DE VUELO*/
            if (e.getSource() == buscar) {
                verificar = false;
                codigos.setEditable(true);
                int codigoN = Integer.valueOf(codigos.getText());
                for (int i = 0; i < aerolinea.getListaVuelos().size(); i++) {
                    if (aerolinea.getListaVuelos().get(i).getClass().getSimpleName().equals("DeCarga")) {
                        if (codigoN == (((DeCarga) aerolinea.getListaVuelos().get(i)).getCodigo())) {
                            area.setText("\n\n\nNOMBRE PRODUCTO: " + ((DeCarga) aerolinea.getListaVuelos().get(i)).getNombreProducto()
                                    + "\nPESO: " + ((DeCarga) aerolinea.getListaVuelos().get(i)).getPeso() + " TONELADAS"
                                    + "\nRUTA: " + aerolinea.getListaVuelos().get(i).getRuta()
                                    + "\nCODIGO VUELO: " + aerolinea.getListaVuelos().get(i).getCodigoRuta()
                                    + "\nVUELO " + aerolinea.getListaVuelos().get(i).getClass().getSimpleName()
                                    + "\nFECHA: " + aerolinea.getListaVuelos().get(i).getHorario()
                                    + "\nCLASE: " + aerolinea.getListaVuelos().get(i).getClaseVuelo()
                                    + "\nPRECIO: " + aerolinea.getListaVuelos().get(i).getPrecio()
                                    + "\nCODIGO RUTA: " + aerolinea.getListaVuelos().get(i).getCodigoRuta()
                                    + "\nTIEMPO RUTA: " + aerolinea.getListaVuelos().get(i).getTiempoVuelo());
                            verificar = true;
                        }
                    }
                }
                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                }
                codigos.setText("");
            }

        }
        if (desplegable.getSelectedItem().toString().equals("             " + human.getClass().getSimpleName())) {

            area.setText(aerolinea.mostrar_CodigoVueloHuman());
            /*SE BUSCA DENTRO DE LA LISTA DE CODIGOS SI PERTENECE A ESA CLASE. 
            SI PERTENECE SE TRAE INFORMACION ESPECIFICA DE ESE TIPO DE VUELO*/
            if (e.getSource() == buscar) {
                verificar = false;
                codigos.setEditable(true);
                int codigoN = Integer.valueOf(codigos.getText());
                for (int i = 0; i < aerolinea.getListaVuelos().size(); i++) {
                    if (aerolinea.getListaVuelos().get(i).getClass().getSimpleName().equals("Humanitario")) {
                        if (codigoN == (((Humanitario) aerolinea.getListaVuelos().get(i)).getCodigo())) {
                            area.setText("\n\nDESCRIPCION: " + ((Humanitario) aerolinea.getListaVuelos().get(i)).getDescriOperacion()
                                    + "\nNUMERO DE PERSONAS: " + ((Humanitario) aerolinea.getListaVuelos().get(i)).getCantidadPersonasH()
                                    + "\nRUTA: " + aerolinea.getListaVuelos().get(i).getRuta()
                                    + "\nCODIGO VUELO: " + aerolinea.getListaVuelos().get(i).getCodigoRuta()
                                    + "\nVUELO " + aerolinea.getListaVuelos().get(i).getClass().getSimpleName()
                                    + "\nFECHA: " + aerolinea.getListaVuelos().get(i).getHorario()
                                    + "\nCLASE: " + aerolinea.getListaVuelos().get(i).getClaseVuelo()
                                    + "\nCODIGO RUTA: " + aerolinea.getListaVuelos().get(i).getCodigoRuta()
                                    + "\nTIEMPO RUTA: " + aerolinea.getListaVuelos().get(i).getTiempoVuelo()
                                    + "\nVUELO NO TIENE PRECIO (GRATIS)");
                            verificar = true;
                        }
                    }
                }
                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                }
                codigos.setText("");
            }

        }
        if (desplegable.getSelectedItem().toString().equals("                   " + mixto.getClass().getSimpleName())) {
            codigos.setEditable(true);
            area.setText(aerolinea.mostrar_CodigoVueloMixto());
            /*SE BUSCA DENTRO DE LA LISTA DE CODIGOS SI PERTENECE A ESA CLASE. 
            SI PERTENECE SE TRAE INFORMACION ESPECIFICA DE ESE TIPO DE VUELO*/
            if (e.getSource() == buscar) {
                verificar = false;
                codigos.setEditable(true);
                int codigoN = Integer.valueOf(codigos.getText());
                for (int i = 0; i < aerolinea.getListaVuelos().size(); i++) {
                    if (aerolinea.getListaVuelos().get(i).getClass().getSimpleName().equals("Mixto")) {
                        if (codigoN == (((Mixto) aerolinea.getListaVuelos().get(i)).getCodigo())) {
                            area.setText("\n\n\nDESCRIPCIÓN VUELO MIXTO: " + ((Mixto) aerolinea.getListaVuelos().get(i)).getTipoVuelo()
                                    + "\nRUTA: " + aerolinea.getListaVuelos().get(i).getRuta()
                                    + "\nCODIGO VUELO: " + aerolinea.getListaVuelos().get(i).getCodigo()
                                    + "\nVUELO " + aerolinea.getListaVuelos().get(i).getClass().getSimpleName()
                                    + "\nFECHA: " + aerolinea.getListaVuelos().get(i).getHorario()
                                    + "\nCLASE: " + aerolinea.getListaVuelos().get(i).getClaseVuelo()
                                    + "\nPRECIO: " + aerolinea.getListaVuelos().get(i).getPrecio()
                                    + "\nCODIGO RUTA: " + aerolinea.getListaVuelos().get(i).getCodigoRuta()
                                    + "\nTIEMPO RUTA: " + aerolinea.getListaVuelos().get(i).getTiempoVuelo());
                            verificar = true;
                        }
                    }
                }
                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                }
                codigos.setText("");
            }
        }
        if (e.getSource() == volver) {
            Buscar v = new Buscar(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
