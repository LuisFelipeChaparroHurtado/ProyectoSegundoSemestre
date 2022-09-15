/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA QUE SE PUEDA INGRESAR DATOS 
    MOSTRAR RUTAS, CEDULAS Y DEMAS DATOS PARA QUE EL USUARIO PUEDA ACTUALIZAR 
 */
package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import logica.Aerolinea;
import logica.AtencionCliente;
import logica.Comida;
import logica.Piloto;
import logica.Seguridad;

public class Actualizar_Trabajadores extends javax.swing.JFrame implements ActionListener {

    //SE CREA ATRIBUTOS ESPECIFICOS(BOTONES,TITULOS,JFIELD,DESPLEGABLE)
    private Aerolinea aerolinea;
    private Comida comida;
    private Seguridad seguridad;
    private AtencionCliente atenCliente;
    private Piloto piloto;
    
    private JLabel titulo;
    private JLabel buscarA;
    private JLabel ruta;
    private JLabel sueldo;
    private JLabel turno;
    private JLabel nombre;
    private JLabel apellido;
    private JLabel edad;
    private JLabel documento;
    
    private JTextField tRuta;
    private JTextField tbuscar;
    private JTextField tSueldo;
    private JTextField tTurno;
    private JTextField tNombre;
    private JTextField tApellido;
    private JTextField tEdad;
    private JTextField tDocumento;
    
    private JButton actualizar;
    private JButton volver;
    private JButton mostrarRuta;
    private JButton buscar;
    private JButton mostrarCedula;
    
    private JComboBox desplegable;
    private Component comprobar;
    private Boolean verificar;

    public Actualizar_Trabajadores(Aerolinea aerolinea) {
        //initComponents();
        
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
        titulo = new JLabel("ACTUALIZAR AZAFATAS", SwingConstants.CENTER);
        titulo.setFont(new Font("arial", Font.BOLD, 18));
        titulo.setBounds(0, 30, 820, 40);
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);
        
        buscarA = new JLabel("NÚMERO DE AZAFATA/PILOTO: ", SwingConstants.RIGHT);
        buscarA.setFont(new Font("arial", 1, 14));
        buscarA.setBounds(290, 110, 165, 30);
        buscarA.setForeground(Color.WHITE);

        ruta = new JLabel("NÚMERO DE RUTA: ", SwingConstants.RIGHT);
        ruta.setFont(new Font("arial", 1, 14));
        ruta.setBounds(290, 150, 165, 30);
        ruta.setForeground(Color.WHITE);

        nombre = new JLabel("NOMBRE: ", SwingConstants.RIGHT);
        nombre.setFont(new Font("arial", 1, 14));
        nombre.setBounds(290, 190, 165, 30);
        nombre.setForeground(Color.WHITE);

        apellido = new JLabel("APELLIDO: ", SwingConstants.RIGHT);
        apellido.setFont(new Font("arial", 1, 14));
        apellido.setBounds(290, 230, 165, 30);
        apellido.setForeground(Color.WHITE);

        sueldo = new JLabel("SUELDO: ", SwingConstants.RIGHT);
        sueldo.setFont(new Font("arial", 1, 14));
        sueldo.setBounds(290, 270, 165, 30);
        sueldo.setForeground(Color.WHITE);

        edad = new JLabel("EDAD: ", SwingConstants.RIGHT);
        edad.setFont(new Font("arial", 1, 14));
        edad.setBounds(290, 310, 165, 30);
        edad.setForeground(Color.WHITE);

        documento = new JLabel("DOCUMENTO: ", SwingConstants.RIGHT);
        documento.setFont(new Font("arial", 1, 14));
        documento.setBounds(290, 350, 165, 30);
        documento.setForeground(Color.WHITE);

        turno = new JLabel("TURNO(N°+DIAS): ", SwingConstants.RIGHT);
        turno.setFont(new Font("arial", 1, 14));
        turno.setBounds(290, 390, 165, 30);
        turno.setForeground(Color.WHITE);
        
        
        //JFIELD (TEXTO)
        tbuscar = new JTextField();
        tbuscar.setBounds(490, 110, 165, 30);

        tRuta = new JTextField();
        tRuta.setBounds(490, 150, 165, 30);

        tNombre = new JTextField();
        tNombre.setBounds(490, 190, 165, 30);

        tApellido = new JTextField();
        tApellido.setBounds(490, 230, 165, 30);

        tSueldo = new JTextField();
        tSueldo.setBounds(490, 270, 165, 30);

        tEdad = new JTextField();
        tEdad.setBounds(490, 310, 165, 30);

        tDocumento = new JTextField();
        tDocumento.setBounds(490, 350, 165, 30);

        tTurno = new JTextField();
        tTurno.setBounds(490, 390, 165, 30);

        //BOTONES
        
        actualizar = new JButton("ACTUALIZAR");
        actualizar.setBounds(80, 460, 200, 30);
        actualizar.setFont(new Font("arial", Font.BOLD, 15));
        actualizar.setForeground(Color.WHITE);
        actualizar.setOpaque(true);
        actualizar.setBackground(Color.RED);
        actualizar.addActionListener(this);

        mostrarRuta = new JButton("RUTAS");
        mostrarRuta.setBounds(680, 150, 100, 30);
        mostrarRuta.setFont(new Font("arial", Font.BOLD, 15));
        mostrarRuta.setForeground(Color.WHITE);
        mostrarRuta.setOpaque(true);
        mostrarRuta.setBackground(Color.RED);
        mostrarRuta.addActionListener(this);

        buscar = new JButton("BUSCAR");
        buscar.setBounds(680, 110, 100, 30);
        buscar.setFont(new Font("arial", Font.BOLD, 15));
        buscar.addActionListener(this);
        buscar.setForeground(Color.WHITE);
        buscar.setOpaque(true);
        buscar.setBackground(Color.RED);

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
        
        //COMBOBOX
        String vectorG[] = {"", "                 " + comida.getClass().getSimpleName(), "              " + seguridad.getClass().getSimpleName(), "           " + atenCliente.getClass().getSimpleName(), "                   " + piloto.getClass().getSimpleName()};
        desplegable = new JComboBox(vectorG);
        desplegable.addActionListener(this);
        desplegable.setBounds(110, 240, 150, 30);
        
        //SE AGREGAN ATRIBUTOS AL PANEL
        azafata.add(ruta);
        azafata.add(sueldo);
        azafata.add(nombre);
        azafata.add(apellido);
        azafata.add(edad);
        azafata.add(documento);
        azafata.add(buscarA);
        azafata.add(tbuscar);
        azafata.add(tTurno);
        azafata.add(tRuta);
        azafata.add(tSueldo);
        azafata.add(tNombre);
        azafata.add(tApellido);
        azafata.add(tEdad);
        azafata.add(tDocumento);
        azafata.add(turno);
        azafata.add(titulo);
        azafata.add(actualizar);
        azafata.add(desplegable);
        azafata.add(mostrarRuta);
        azafata.add(mostrarCedula);
        azafata.add(buscar);
        azafata.add(volver);
        
        /*SE INHABILITAN ALGUNOS ESPACIOS DE TEXTOS. DEBE SER COMPROBADO QUE EL 
        DATO SEA PERTENEZCA A LISTA ESPECIFICA*/
        if (!verificar) {
            tRuta.setEditable(false);
            tNombre.setEditable(false);
            tTurno.setEditable(false);
            tApellido.setEditable(false);
            tSueldo.setEditable(false);
            tEdad.setEditable(false);
            tDocumento.setEditable(false);
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
                CodigosAzafataC v = new CodigosAzafataC(aerolinea);
                v.setVisible(true);

            }
        }
        if (desplegable.getSelectedItem().toString().equals("              " + seguridad.getClass().getSimpleName())) {
            if (e.getSource() == mostrarCedula) {
                CodigosAzafataS v = new CodigosAzafataS(aerolinea);
                v.setVisible(true);

            }
        }
        if (desplegable.getSelectedItem().toString().equals("           " + atenCliente.getClass().getSimpleName())) {
            if (e.getSource() == mostrarCedula) {
                CodigosAzafataAten v = new CodigosAzafataAten(aerolinea);
                v.setVisible(true);

            }
        }
        if (desplegable.getSelectedItem().toString().equals("                   " + piloto.getClass().getSimpleName())) {
            if (e.getSource() == mostrarCedula) {
                CodigoPiloto v = new CodigoPiloto(aerolinea);
                v.setVisible(true);

            }
        }
        
        /*SE VALIDA SI EL CAMPO SELECCIONADO CORRESPONDE A ESA CLASE PUEDA INGRESAR DATOS AL TEXTO*/
        if (desplegable.getSelectedItem().toString().equals("                 " + comida.getClass().getSimpleName())) {

            titulo.setText("ACTUALIZAR AZAFATAS DE COMIDA");
            //SE BUSCA LA POSICIÓN DE LA CEDULA SI PERTENECE O NO A LA DE LA LISTA DE AZAFATA DE COMIDA
            if (e.getSource() == buscar) {
                tbuscar.setEditable(true);
                int actualizar = Integer.valueOf(tbuscar.getText());
                
                for (int i = 0; i < aerolinea.getListaAzafata().size(); i++) {
                    if (desplegable.getSelectedItem().toString().equals("                 " + aerolinea.getListaAzafata().get(i).getClass().getSimpleName())) {
                        if ((actualizar - 1) == i) {
                            JOptionPane.showMessageDialog(null, "OPCIÓN CORRECTA!!");
                            verificar = true;
                            tRuta.setEditable(true);
                            tNombre.setEditable(true);
                            tTurno.setEditable(true);
                            tSueldo.setEditable(true);
                            tApellido.setEditable(true);
                            tEdad.setEditable(true);
                            tDocumento.setEditable(true);
                            break;
                        }
                    }
                }

                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                    tbuscar.setText("");
                }
            }
            //SE AGREGA TDDOS LOS DATOS INGRESADOS A LA LISTA(CORRECTAMENTE INGRESADOS)
            if (e.getSource() == actualizar) {
                tbuscar.setEditable(true);
                int actualizar = Integer.valueOf(tbuscar.getText());
                int numRuta = Integer.valueOf(tRuta.getText());
                String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
                String nombre = tNombre.getText();
                String apellido = tApellido.getText();
                String sueldo = tSueldo.getText();
                int edad = Integer.valueOf(tEdad.getText());
                int documento = Integer.valueOf(tDocumento.getText());
                String turno = tTurno.getText();

                aerolinea.getListaAzafata().get(actualizar - 1).getCedula();
                Comida nuevaAzaC = new Comida(ruta, sueldo, turno, nombre, apellido, edad, documento);
                aerolinea.getListaAzafata().set(actualizar - 1, nuevaAzaC);

                JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
                //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
                tRuta.setText("");
                tSueldo.setText("");
                tTurno.setText("");
                tNombre.setText("");
                tApellido.setText("");
                tEdad.setText("");
                tDocumento.setText("");
                tbuscar.setText("");
            }
        }
        
        /*SE VALIDA SI EL CAMPO SELECCIONADO CORRESPONDE A ESA CLASE PUEDA INGRESAR DATOS AL TEXTO*/
        if (desplegable.getSelectedItem().toString().equals("              " + seguridad.getClass().getSimpleName())) {

            titulo.setText("ACTUALIZAR AZAFATAS DE SEGURIDAD");
             //SE BUSCA LA POSICIÓN DE LA CEDULA SI PERTENECE O NO A LA DE LA LISTA DE AZAFATA DE SEGURIDAD
             if (e.getSource() == buscar) {
                tbuscar.setEditable(true);
                int actualizar = Integer.valueOf(tbuscar.getText());

                for (int i = 0; i < aerolinea.getListaAzafata().size(); i++) {
                    if (desplegable.getSelectedItem().toString().equals("              " + aerolinea.getListaAzafata().get(i).getClass().getSimpleName())) {
                        if ((actualizar - 1) == i) {
                            JOptionPane.showMessageDialog(null, "OPCIÓN CORRECTA!!");
                            verificar = true;
                            tRuta.setEditable(true);
                            tNombre.setEditable(true);
                            tTurno.setEditable(true);
                            tSueldo.setEditable(true);
                            tApellido.setEditable(true);
                            tEdad.setEditable(true);
                            tDocumento.setEditable(true);
                            break;
                        }
                    }
                }

                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                    tbuscar.setText("");
                }
            }
             //SE AGREGA TODOS LOS DATOS INGRESADOS A LA LISTA(CORRECTAMENTE INGRESADOS)
            if (e.getSource() == actualizar) {
                tbuscar.setEditable(true);
                int actualizar = Integer.valueOf(tbuscar.getText());
                int numRuta = Integer.valueOf(tRuta.getText());
                String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
                String nombre = tNombre.getText();
                String apellido = tApellido.getText();
                String sueldo = tSueldo.getText();
                int edad = Integer.valueOf(tEdad.getText());
                int documento = Integer.valueOf(tDocumento.getText());
                String turno = tTurno.getText();

                aerolinea.getListaAzafata().get(actualizar - 1).getCedula();
                Seguridad nuevaAzaS = new Seguridad(ruta, sueldo, turno, nombre, apellido, edad, documento);
                aerolinea.getListaAzafata().set(actualizar - 1, nuevaAzaS);

                JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
                
                //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
                tRuta.setText("");
                tSueldo.setText("");
                tTurno.setText("");
                tNombre.setText("");
                tApellido.setText("");
                tEdad.setText("");
                tDocumento.setText("");
                tbuscar.setText("");
            }

        }
        
        /*SE VALIDA SI EL CAMPO SELECCIONADO CORRESPONDE A ESA CLASE PUEDA INGRESAR DATOS AL TEXTO*/
        if (desplegable.getSelectedItem().toString().equals("           " + atenCliente.getClass().getSimpleName())) {

            titulo.setText("ACTUALIZAR AZAFATAS DE ATENCION AL CLIENTE");
             //SE BUSCA LA POSICIÓN DE LA CEDULA SI PERTENECE O NO A LA DE LA LISTA DE AZAFATA DE ATENCION AL CLIENTE
            if (e.getSource() == buscar) {
                tbuscar.setEditable(true);
                int actualizar = Integer.valueOf(tbuscar.getText());

                for (int i = 0; i < aerolinea.getListaAzafata().size(); i++) {
                    if (desplegable.getSelectedItem().toString().equals("           " + aerolinea.getListaAzafata().get(i).getClass().getSimpleName())) {
                        if ((actualizar - 1) == i) {
                            JOptionPane.showMessageDialog(null, "OPCIÓN CORRECTA!!");
                            verificar = true;
                            tRuta.setEditable(true);
                            tNombre.setEditable(true);
                            tTurno.setEditable(true);
                            tSueldo.setEditable(true);
                            tApellido.setEditable(true);
                            tEdad.setEditable(true);
                            tDocumento.setEditable(true);
                            break;
                        }
                    }
                }

                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                    tbuscar.setText("");
                }
            }
            //SE AGREGA TDDOS LOS DATOS INGRESADOS A LA LISTA(CORRECTAMENTE INGRESADOS)
            if (e.getSource() == actualizar) {
                tbuscar.setEditable(true);
                int actualizar = Integer.valueOf(tbuscar.getText());
                int numRuta = Integer.valueOf(tRuta.getText());
                String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
                String nombre = tNombre.getText();
                String apellido = tApellido.getText();
                String sueldo = tSueldo.getText();
                int edad = Integer.valueOf(tEdad.getText());
                int documento = Integer.valueOf(tDocumento.getText());
                String turno = tTurno.getText();

                aerolinea.getListaAzafata().get(actualizar - 1).getCedula();
                AtencionCliente nuevaAzaAte = new AtencionCliente(ruta, sueldo, turno, nombre, apellido, edad, documento);
                aerolinea.getListaAzafata().set(actualizar - 1, nuevaAzaAte);

                JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
                //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
                tRuta.setText("");
                tSueldo.setText("");
                tTurno.setText("");
                tNombre.setText("");
                tApellido.setText("");
                tEdad.setText("");
                tDocumento.setText("");
                tbuscar.setText("");
            }

        }
        
        /*SE VALIDA SI EL CAMPO SELECCIONADO CORRESPONDE A ESA CLASE PUEDA INGRESAR DATOS AL TEXTO*/
        if (desplegable.getSelectedItem().toString().equals("                   " + piloto.getClass().getSimpleName())) {

            turno.setText("NO TIENE TURNO ");
            turno.setForeground(Color.RED);
            titulo.setText("ACTUALIZAR PILOTO DE AERONAVE");
            //SE BUSCA LA POSICIÓN DE LA CEDULA SI PERTENECE O NO A LA DE LA LISTA DE PILOTOS
            if (e.getSource() == buscar) {
                tbuscar.setEditable(true);
                int actualizar = Integer.valueOf(tbuscar.getText());

                for (int i = 0; i < aerolinea.getListaPilotos().size(); i++) {
                    if (desplegable.getSelectedItem().toString().equals("                   " + aerolinea.getListaPilotos().get(i).getClass().getSimpleName())) {
                        if ((actualizar - 1) == i) {
                            JOptionPane.showMessageDialog(null, "OPCIÓN CORRECTA!!");
                            verificar = true;
                            tRuta.setEditable(true);
                            tNombre.setEditable(true);
                            tTurno.setEditable(false);
                            tSueldo.setEditable(true);
                            tApellido.setEditable(true);
                            tEdad.setEditable(true);
                            tDocumento.setEditable(true);
                            break;
                        }
                    }
                }

                if (verificar == false) {
                    JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                    tbuscar.setText("");
                }
            }
            //SE AGREGA TDDOS LOS DATOS INGRESADOS A LA LISTA(CORRECTAMENTE INGRESADOS)
            if (e.getSource() == actualizar) {
                tbuscar.setEditable(true);
                int actualizar = Integer.valueOf(tbuscar.getText());
                int numRuta = Integer.valueOf(tRuta.getText());
                String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
                String nombre = tNombre.getText();
                String apellido = tApellido.getText();
                String sueldo = tSueldo.getText();
                int edad = Integer.valueOf(tEdad.getText());
                int documento = Integer.valueOf(tDocumento.getText());

                aerolinea.getListaPilotos().get(actualizar - 1).getCedula();
                Piloto nuevoPiloto = new Piloto(ruta, sueldo, nombre, apellido, edad, documento);
                aerolinea.getListaPilotos().set(actualizar - 1, nuevoPiloto);

                JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
                //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
                tRuta.setText("");
                tSueldo.setText("");
                tTurno.setText("");
                tNombre.setText("");
                tApellido.setText("");
                tEdad.setText("");
                tDocumento.setText("");
                tbuscar.setText("");
            }

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

        if (e.getSource() == volver) {
            Actualizar_Datos v = new Actualizar_Datos(aerolinea);
            v.setUndecorated(true);
            v.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            v.setVisible(true);
            dispose();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
