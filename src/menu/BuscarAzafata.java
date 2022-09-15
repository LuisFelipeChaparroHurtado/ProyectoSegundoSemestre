/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA BUSCAR ALGUNA AZAFATA MEDIANTE 
    EL NUMERO DE LA CEDULA DE CADA AZAFATA. 
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
import logica.AtencionCliente;
import logica.Comida;
import logica.Seguridad;

public class BuscarAzafata extends javax.swing.JFrame implements ActionListener {

    private Aerolinea aerolinea;
    private Comida comida;
    private Seguridad seguridad;
    private AtencionCliente atencion;
    private JLabel titulo;
    private JLabel id;
    private JButton buscar;
    private JButton volver;
    private JComboBox desplegable;
    private JTextArea area;
    private JTextField cedula;
    private Boolean verificar;

    public BuscarAzafata(Aerolinea aerolinea) {
        //initComponents();
        
        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y IMAGENES
        this.aerolinea = aerolinea;
        this.comida = new Comida();
        this.seguridad = new Seguridad();
        this.atencion = new AtencionCliente();
        verificar=false;
        
        //SE INCIALIZA EL PANEL Y SE LE DA TAMAÑO
        JPanel panel = new JPanel();
        panel.setLayout(null);
        setSize(500, 510);
        setLocationRelativeTo(null);
        setTitle("BUSCAR TRABAJADOR");
        panel.setBackground(Color.BLACK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, panel);
        
        //TITULOS
        titulo = new JLabel("BUSCAR AZAFATA", SwingConstants.CENTER);
        titulo.setBounds(0, 40, 500, 40);
        titulo.setFont(new Font("arial", Font.BOLD, 17));
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);

        id = new JLabel("INGRESE EL CODIGO DE LA AZAFATA", SwingConstants.CENTER);
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
        
        //JTEXT (TEXTO AREA)
        area = new JTextArea();
        area.setBounds(210, 110, 245, 230);

        cedula = new JTextField();
        cedula.setBounds(340, 380, 100, 20);
        
        //COMBOBOX
        desplegable = new JComboBox();
        String vectorG[] = {"", "                  " + comida.getClass().getSimpleName(), "                " + seguridad.getClass().getSimpleName(), "          " + atencion.getClass().getSimpleName()};
        desplegable = new JComboBox(vectorG);
        desplegable.addActionListener(this);
        desplegable.setBounds(30, 200, 150, 30);

        //SE AGREGAN LOS ATRIBUTOS AL PANEL
        panel.add(desplegable);
        panel.add(titulo);
        panel.add(id);
        panel.add(buscar);
        panel.add(area);
        panel.add(cedula);
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
        if (desplegable.getSelectedItem().toString().equals("                  " + comida.getClass().getSimpleName())) {
            area.setText(aerolinea.mostrar_CodigoAzafataC());
            /*SE BUSCA DENTRO DE LA LISTA DE CEDULAS SI PERTENECE A ESA CLASE. 
            SI PERTENECE SE TRAE INFORMACION ESPECIFICA DE ESA AZAFATA*/
            if (e.getSource() == buscar) {
                verificar=false;
                cedula.setEditable(true);
                int cc = Integer.valueOf(cedula.getText());
                for (int i = 0; i < aerolinea.getListaAzafata().size(); i++) {
                    if (cc == aerolinea.getListaAzafata().get(i).getCedula()) {
                        JOptionPane.showMessageDialog(null, "NUMERO CEDULA DE LA AZAFATA CORRECTO!!");
                        area.setText("\n\n----------------------PERFECTO!!!!-----------------------\n"
                                + "\nCARGO DE " + aerolinea.getListaAzafata().get(i).getClass().getSimpleName()
                                + "\nRUTA: " + aerolinea.getListaAzafata().get(i).getRutasDesignada()
                                + "\nSUELDO: " + aerolinea.getListaAzafata().get(i).getSueldo()
                                + "\nTURNO: " + aerolinea.getListaAzafata().get(i).getTurno()
                                + "\nNOMBRE: " + aerolinea.getListaAzafata().get(i).getNombre()
                                + "\nAPELLIDO: " + aerolinea.getListaAzafata().get(i).getApellido()
                                + "\nEDAD: " + aerolinea.getListaAzafata().get(i).getEdad()
                                + "\nNUMERO DE DOCUMENTO: " + aerolinea.getListaAzafata().get(i).getCedula());
                        verificar=true;
                    }
                }
                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL DOCUMENTO DE LA AZAFATA");
                }
                cedula.setText("");
            }
        }  
        if (desplegable.getSelectedItem().toString().equals("                " + seguridad.getClass().getSimpleName())) {
            area.setText(aerolinea.mostrar_CodigoAzafataS());
            /*SE BUSCA DENTRO DE LA LISTA DE CEDULAS SI PERTENECE A ESA CLASE. 
            SI PERTENECE SE TRAE INFORMACION ESPECIFICA DE ESA AZAFATA*/
            if (e.getSource() == buscar) {
                verificar=false;
                cedula.setEditable(true);
                int cc = Integer.valueOf(cedula.getText());
                for (int i = 0; i < aerolinea.getListaAzafata().size(); i++) {
                    if (cc == aerolinea.getListaAzafata().get(i).getCedula()) {
                        JOptionPane.showMessageDialog(null, "NUMERO CEDULA DE LA AZAFATA CORRECTO!!");
                        area.setText("\n\n----------------------PERFECTO!!!!-----------------------\n"
                                + "\nCARGO DE " + aerolinea.getListaAzafata().get(i).getClass().getSimpleName()
                                + "\nRUTA: " + aerolinea.getListaAzafata().get(i).getRutasDesignada()
                                + "\nSUELDO: " + aerolinea.getListaAzafata().get(i).getSueldo()
                                + "\nTURNO: " + aerolinea.getListaAzafata().get(i).getTurno()
                                + "\nNOMBRE: " + aerolinea.getListaAzafata().get(i).getNombre()
                                + "\nAPELLIDO: " + aerolinea.getListaAzafata().get(i).getApellido()
                                + "\nEDAD: " + aerolinea.getListaAzafata().get(i).getEdad()
                                + "\nNUMERO DE DOCUMENTO: " + aerolinea.getListaAzafata().get(i).getCedula());
                        verificar=true;
                    }
                }
                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL DOCUMENTO DE LA AZAFATA");
                }
                cedula.setText("");
            }

        } 
        if (desplegable.getSelectedItem().toString().equals("          " + atencion.getClass().getSimpleName())) {
            area.setText(aerolinea.mostrar_CodigoAzafataAt());
            /*SE BUSCA DENTRO DE LA LISTA DE CEDULAS SI PERTENECE A ESA CLASE. 
            SI PERTENECE SE TRAE INFORMACION ESPECIFICA DE ESA AZAFATA*/
            if (e.getSource() == buscar) {
                verificar=false;
                cedula.setEditable(true);
                int cc = Integer.valueOf(cedula.getText());
                for (int i = 0; i < aerolinea.getListaAzafata().size(); i++) {
                    if (cc == aerolinea.getListaAzafata().get(i).getCedula()) {
                        JOptionPane.showMessageDialog(null, "NUMERO CEDULA DE LA AZAFATA CORRECTO!!");
                        area.setText("\n\n----------------------PERFECTO!!!!-----------------------\n"
                                + "\nCARGO DE " + aerolinea.getListaAzafata().get(i).getClass().getSimpleName()
                                + "\nRUTA: " + aerolinea.getListaAzafata().get(i).getRutasDesignada()
                                + "\nSUELDO: " + aerolinea.getListaAzafata().get(i).getSueldo()
                                + "\nTURNO: " + aerolinea.getListaAzafata().get(i).getTurno()
                                + "\nNOMBRE: " + aerolinea.getListaAzafata().get(i).getNombre()
                                + "\nAPELLIDO: " + aerolinea.getListaAzafata().get(i).getApellido()
                                + "\nEDAD: " + aerolinea.getListaAzafata().get(i).getEdad()
                                + "\nNUMERO DE DOCUMENTO: " + aerolinea.getListaAzafata().get(i).getCedula());
                        verificar=true;
                    }
                }
                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL DOCUMENTO DE LA AZAFATA");
                }
                cedula.setText("");
            }
        }
        if (e.getSource() == volver) {
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
