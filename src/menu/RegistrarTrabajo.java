/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA QUE SE PUEDA REGISTRAR 
    ALGUNA LABOR PARA ALGUNA AZAFATA
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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logica.Aerolinea;
import logica.AtencionCliente;
import logica.Comida;
import logica.Piloto;
import logica.Seguridad;

public class RegistrarTrabajo extends javax.swing.JFrame implements ActionListener {

    //SE CREA ATRIBUTOS ESPECIFICOS(BOTONES,TITULOS,JFIELD,DESPLEGABLE)
    private Aerolinea aerolinea;
    private Comida comida;
    private Seguridad seguridad;
    private AtencionCliente atenCliente;
    private Piloto piloto;
    private JLabel titulo; 
    private JLabel atri1;
    private JLabel buscar;
    private JLabel atri2;
    private JLabel atri3;
    private JTextField buscarT;
    private JTextField atri1T;
    private JTextField atri2T;
    private JTextField atri3T;
    private JButton agregar;
    private JButton volver;
    private JButton mostrarCedula;
    private JButton buscarB;
    private JComboBox desplegable;
    private Boolean verificar;

    public RegistrarTrabajo(Aerolinea aerolinea) {

        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y COMBOBOX
        this.aerolinea = aerolinea;
        piloto = new Piloto();
        comida = new Comida();
        seguridad = new Seguridad();
        atenCliente = new AtencionCliente();
        verificar = false;

        JPanel azafata = new JPanel();

        azafata.setLayout(null);
        setSize(820, 530);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, azafata);
        azafata.setBackground(Color.BLACK);

        //TITULOS
        titulo = new JLabel("REGISTRAR TRABAJO", SwingConstants.CENTER);
        titulo.setFont(new Font("arial", Font.BOLD, 18));
        titulo.setBounds(0, 30, 820, 40);
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);

        buscar = new JLabel("N° AZAFATA(POS): ", SwingConstants.RIGHT);
        buscar.setFont(new Font("arial", 1, 14));
        buscar.setBounds(290, 240, 165, 30);
        buscar.setForeground(Color.WHITE);

        atri1 = new JLabel("", SwingConstants.RIGHT);
        atri1.setFont(new Font("arial", 1, 14));
        atri1.setBounds(290, 280, 165, 30);
        atri1.setForeground(Color.WHITE);

        atri2 = new JLabel("", SwingConstants.RIGHT);
        atri2.setFont(new Font("arial", 1, 14));
        atri2.setBounds(290, 320, 165, 30);
        atri2.setForeground(Color.WHITE);

        atri3 = new JLabel("", SwingConstants.RIGHT);
        atri3.setFont(new Font("arial", 1, 14));
        atri3.setBounds(290, 360, 165, 30);
        atri3.setForeground(Color.WHITE);

        //JFIELD (TEXTO)
        buscarT = new JTextField();
        buscarT.setBounds(490, 240, 165, 30);

        atri1T = new JTextField();
        atri1T.setBounds(490, 280, 165, 30);

        atri2T = new JTextField();
        atri2T.setBounds(490, 320, 165, 30);

        atri3T = new JTextField();
        atri3T.setBounds(490, 360, 165, 30);

        //BOTONES
        agregar = new JButton("REGISTRAR");
        agregar.setBounds(80, 460, 200, 30);
        agregar.setFont(new Font("arial", Font.BOLD, 15));
        agregar.setForeground(Color.WHITE);
        agregar.setOpaque(true);
        agregar.setBackground(Color.RED);
        agregar.addActionListener(this);

        buscarB = new JButton("BUSCAR");
        buscarB.setBounds(680, 240, 100, 30);
        buscarB.setFont(new Font("arial", Font.BOLD, 15));
        buscarB.addActionListener(this);
        buscarB.setForeground(Color.WHITE);
        buscarB.setOpaque(true);
        buscarB.setBackground(Color.RED);

        mostrarCedula = new JButton("MOSTRAR CEDULAS");
        mostrarCedula.setBounds(305, 460, 200, 30);
        mostrarCedula.setFont(new Font("arial", Font.BOLD, 15));
        mostrarCedula.addActionListener(this);
        mostrarCedula.setForeground(Color.WHITE);
        mostrarCedula.setOpaque(true);
        mostrarCedula.setBackground(Color.RED);

        volver = new JButton("VOLVER");
        volver.setBounds(530, 460, 200, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.addActionListener(this);
        volver.setForeground(Color.WHITE);
        volver.setOpaque(true);
        volver.setBackground(Color.RED);

        ImageIcon icono = new ImageIcon("src\\resources\\labor.jpg");
        JLabel imagen = new JLabel();
        imagen.setBounds(40, 120, 250, 250);
        imagen.setIcon(new ImageIcon(icono.getImage().getScaledInstance(imagen.getWidth(), imagen.getHeight(), Image.SCALE_SMOOTH)));

        //COMBOBOX
        String vectorG[] = {"", "                 " + comida.getClass().getSimpleName(), "              " + seguridad.getClass().getSimpleName(), "           " + atenCliente.getClass().getSimpleName()};
        desplegable = new JComboBox(vectorG);
        desplegable.addActionListener(this);
        desplegable.setBounds(495, 100, 150, 30);

        //SE AGREGAN ATRIBUTOS AL PANEL
        azafata.add(titulo);
        azafata.add(atri1);
        azafata.add(atri2);
        azafata.add(atri3);
        azafata.add(buscar);
        azafata.add(buscarT);
        azafata.add(atri1T);
        azafata.add(atri2T);
        azafata.add(atri3T);
        azafata.add(desplegable);
        azafata.add(mostrarCedula);
        azafata.add(imagen);
        azafata.add(agregar);
        azafata.add(buscarB);
        azafata.add(volver);

        /*SE INHABILITAN ALGUNOS ESPACIOS DE TEXTOS. DEBE SER COMPROBADO QUE EL 
        DATO SEA PERTENEZCA A LISTA ESPECIFICA*/
        if (!verificar) {
            atri1T.setEditable(false);
            atri2T.setEditable(false);
            atri3T.setEditable(false);
        }
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
        //SE HACE UNA VALIDACIÓN DEL CAMPO SELECCIONADO LUEGO SE MANDA A UN METODO JFRAME DONDE SE CREA UN JSCROLL
        if (desplegable.getSelectedItem().toString().equals("                 " + comida.getClass().getSimpleName())) {
            if (e.getSource() == mostrarCedula) {
                CodigoAzaLaborC v = new CodigoAzaLaborC(aerolinea);
                v.setVisible(true);

            }
        }
        if (desplegable.getSelectedItem().toString().equals("              " + seguridad.getClass().getSimpleName())) {
            if (e.getSource() == mostrarCedula) {
                CodigoAzaLaborS v = new CodigoAzaLaborS(aerolinea);
                v.setVisible(true);

            }
        }
        if (desplegable.getSelectedItem().toString().equals("           " + atenCliente.getClass().getSimpleName())) {
            if (e.getSource() == mostrarCedula) {
                CodigoAzaLaborAten v = new CodigoAzaLaborAten(aerolinea);
                v.setVisible(true);

            }
        }
        /*SE VALIDA SI EL CAMPO SELECCIONADO CORRESPONDE A ESA CLASE PUEDA INGRESAR DATOS AL TEXTO*/
        if (desplegable.getSelectedItem().toString().equals("                 " + comida.getClass().getSimpleName())) {

            atri1.setText("TIPO DE COMIDA: ");
            atri2.setText("PLATO: ");
            atri3.setText("HORARIO COMIDA: ");

            if (e.getSource() == buscarB) {
                buscarT.setEditable(true);
                int actualizar = Integer.valueOf(buscarT.getText());

                for (int i = 0; i < aerolinea.getListaAzafata().size(); i++) {
                    if (desplegable.getSelectedItem().toString().equals("                 " + aerolinea.getListaAzafata().get(i).getClass().getSimpleName())) {
                        if ((actualizar - 1) == i) {
                            if (((Comida) aerolinea.getListaAzafata().get(i)).getPlato() == null) {
                                JOptionPane.showMessageDialog(null, "ES CORRECTO EL NUMERO CEDULA DE LA AZAFATA!!");
                                verificar = true;
                                atri1T.setEditable(true);
                                atri2T.setEditable(true);
                                atri3T.setEditable(true);
                                break;
                            }
                        }
                    }
                }
                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                    buscarT.setText("");
                }
            }
            if (e.getSource() == agregar) {
                buscarT.setEditable(true);
                int actualizar = Integer.valueOf(buscarT.getText());

                String tipoComida = atri1T.getText();
                String plato = atri2T.getText();
                String horario = atri3T.getText();

                ((Comida) aerolinea.getListaAzafata().get(actualizar - 1)).setPlato(plato);
                ((Comida) aerolinea.getListaAzafata().get(actualizar - 1)).setTipoComida(tipoComida);
                ((Comida) aerolinea.getListaAzafata().get(actualizar - 1)).setHorarioComida(horario);
                JOptionPane.showMessageDialog(null, "REGISTRO DE TRABAJO EXITOSO");
                atri1T.setEditable(false);
                atri2T.setEditable(false);
                atri3T.setEditable(false);
                atri1T.setText("");
                atri2T.setText("");
                atri3T.setText("");
                buscarT.setText("");
                verificar = false;
            }

        }

        if (desplegable.getSelectedItem().toString().equals("              " + seguridad.getClass().getSimpleName())) {

            atri1.setText("H.INSTRUCCIONES: ");
            atri2.setText("CHEQUEO PUERTAS: ");
            atri3.setText("");
            if (e.getSource() == buscarB) {
                buscarT.setEditable(true);
                int actualizar = Integer.valueOf(buscarT.getText());

                for (int i = 0; i < aerolinea.getListaAzafata().size(); i++) {
                    if (desplegable.getSelectedItem().toString().equals("              " + aerolinea.getListaAzafata().get(i).getClass().getSimpleName())) {
                        if ((actualizar - 1) == i) {
                            if (((Seguridad) aerolinea.getListaAzafata().get(i)).getHorarioInstrucci() == null) {
                                JOptionPane.showMessageDialog(null, "ES CORRECTO EL NUMERO CEDULA DE LA AZAFATA!!");
                                verificar = true;
                                atri1T.setEditable(true);
                                atri2T.setEditable(true);
                                atri3T.setEditable(false);
                                break;
                            }
                        }
                    }
                }
                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                    buscarT.setText("");
                }
            }
            if (e.getSource() == agregar) {
                buscarT.setEditable(true);
                int actualizar = Integer.valueOf(buscarT.getText());

                String horario = atri1T.getText();
                String chequeo = atri2T.getText();

                ((Seguridad) aerolinea.getListaAzafata().get(actualizar - 1)).setHorarioInstrucci(horario);
                ((Seguridad) aerolinea.getListaAzafata().get(actualizar - 1)).setChequeoPuertas(chequeo);
                JOptionPane.showMessageDialog(null, "REGISTRO DE TRABAJO EXITOSO");
                atri1T.setEditable(false);
                atri2T.setEditable(false);
                atri3T.setEditable(false);
                buscarT.setText("");
                atri1T.setText("");
                atri2T.setText("");
                atri3T.setText("");
                verificar = false;
            }

        }

        if (desplegable.getSelectedItem().toString().equals("           " + atenCliente.getClass().getSimpleName())) {

            atri1.setText("HORA.ATENCION: ");
            atri2.setText("");
            atri3.setText("");
            if (e.getSource() == buscarB) {
                buscarT.setEditable(true);
                int actualizar = Integer.valueOf(buscarT.getText());

                for (int i = 0; i < aerolinea.getListaAzafata().size(); i++) {
                    if (desplegable.getSelectedItem().toString().equals("           " + aerolinea.getListaAzafata().get(i).getClass().getSimpleName())) {
                        if ((actualizar - 1) == i) {
                            if (((AtencionCliente) aerolinea.getListaAzafata().get(i)).getHoraAtencion() == null) {
                                JOptionPane.showMessageDialog(null, "ES CORRECTO EL NUMERO CEDULA DE LA AZAFATA!!");
                                verificar = true;
                                atri1T.setEditable(true);
                                atri2T.setEditable(false);
                                atri3T.setEditable(false);
                                break;
                            }
                        }
                    }
                }
                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                    buscarT.setText("");
                }
            }
            if (e.getSource() == agregar) {
                buscarT.setEditable(true);
                int actualizar = Integer.valueOf(buscarT.getText());

                String horario = atri1T.getText();

                ((AtencionCliente) aerolinea.getListaAzafata().get(actualizar - 1)).setHoraAtencion(horario);

                JOptionPane.showMessageDialog(null, "REGISTRO DE TRABAJO EXITOSO");
                atri1T.setEditable(false);
                atri2T.setEditable(false);
                atri3T.setEditable(false);
                buscarT.setText("");
                atri1T.setText("");
                atri2T.setText("");
                atri3T.setText("");
                verificar = false;
            }

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
