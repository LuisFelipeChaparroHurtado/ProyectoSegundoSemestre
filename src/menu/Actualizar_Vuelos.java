/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA QUE SE PUEDA INGRESAR DATOS 
    MOSTRAR RUTAS, CODIGOS Y DEMAS DATOS PARA QUE EL USUARIO PUEDA ACTUALIZAR 
 */
package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import logica.DeCarga;
import logica.DePasajeros;
import logica.Humanitario;
import logica.Mixto;

public class Actualizar_Vuelos extends javax.swing.JFrame implements ActionListener {

    private DePasajeros pasajeros;
    private DeCarga carga;
    private Humanitario human;
    private Mixto mix;
    private Aerolinea aerolinea;
    
    private JLabel titulo;
    private JLabel buscaNC;
    private JLabel atrib1;
    private JLabel atrib2;
    private JLabel horario;
    private JLabel claseV;
    private JLabel ruta;
    private JLabel id;
    private JLabel precioT;
    
    private JTextField atri1;
    private JTextField tbuscaNC;
    private JTextField atri2;
    private JTextField fechaV;
    private JTextField claV;
    private JTextField rutaV;
    private JTextField codigo;
    private JTextField precioV;
    
    private Boolean verificar;
    private JComboBox desplegable;
    private Component comprobar;
    
    private JButton actualizar;
    private JButton volver;
    private JButton mostrarCodigos;
    private JButton mostrarRutas;
    private JButton buscar;

    public Actualizar_Vuelos(Aerolinea aerolinea) {
        //initComponents();

        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y COMBOBOX
        pasajeros = new DePasajeros();
        carga = new DeCarga();
        human = new Humanitario();
        mix = new Mixto();
        this.aerolinea = aerolinea;
        desplegable = new JComboBox();
        verificar = false;

        //SE INICIALIZA PANEL Y SE LE DA TAMAÑO
        JPanel vuelo = new JPanel();
        vuelo.setLayout(null);
        setSize(820, 530);
        setLocationRelativeTo(null);
        setTitle("ACTUALIZAR VUELOS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(BorderLayout.CENTER, vuelo);
        vuelo.setBackground(Color.BLACK);

        //TITULOS
        titulo = new JLabel("ACTUALIZAR VUELOS", SwingConstants.CENTER);
        titulo.setFont(new Font("arial", Font.BOLD, 18));
        titulo.setBounds(0, 30, 820, 40);
        titulo.setForeground(Color.WHITE);
        titulo.setOpaque(true);
        titulo.setBackground(Color.RED);

        buscaNC = new JLabel("NUMERO DE VUELO", SwingConstants.RIGHT);
        buscaNC.setFont(new Font("arial", 1, 14));
        buscaNC.setBounds(246, 100, 220, 30);
        buscaNC.setBackground(Color.BLACK);
        buscaNC.setOpaque(true);
        buscaNC.setForeground(Color.WHITE);

        atrib1 = new JLabel("", SwingConstants.RIGHT);
        atrib1.setFont(new Font("arial", 1, 14));
        atrib1.setBounds(246, 140, 220, 30);
        atrib1.setBackground(Color.BLACK);
        atrib1.setOpaque(true);
        atrib1.setForeground(Color.WHITE);

        horario = new JLabel("NUEVO HORARIO: ", SwingConstants.RIGHT);
        horario.setFont(new Font("arial", 1, 14));
        horario.setBounds(300, 180, 165, 30);
        horario.setBackground(Color.BLACK);
        horario.setOpaque(true);
        horario.setForeground(Color.WHITE);

        ruta = new JLabel("NUEVA RUTA: ", SwingConstants.RIGHT);
        ruta.setFont(new Font("arial", 1, 14));
        ruta.setBounds(300, 220, 165, 30);
        ruta.setBackground(Color.BLACK);
        ruta.setOpaque(true);
        ruta.setForeground(Color.WHITE);

        id = new JLabel("NUEVO CODIGO: ", SwingConstants.RIGHT);
        id.setFont(new Font("arial", 1, 14));
        id.setBounds(300, 260, 165, 30);
        id.setBackground(Color.BLACK);
        id.setOpaque(true);
        id.setForeground(Color.WHITE);

        precioT = new JLabel("", SwingConstants.RIGHT);
        precioT.setFont(new Font("arial", 1, 14));
        precioT.setBounds(300, 300, 165, 30);
        precioT.setBackground(Color.BLACK);
        precioT.setOpaque(true);
        precioT.setForeground(Color.WHITE);

        claseV = new JLabel("NUEVO CLASE DE VUELO: ", SwingConstants.RIGHT);
        claseV.setFont(new Font("arial", 1, 14));
        claseV.setBounds(246, 340, 220, 30);
        claseV.setBackground(Color.BLACK);
        claseV.setOpaque(true);
        claseV.setForeground(Color.WHITE);

        atrib2 = new JLabel("", SwingConstants.RIGHT);
        atrib2.setFont(new Font("arial", 1, 14));
        atrib2.setBounds(246, 380, 220, 30);
        atrib2.setBackground(Color.BLACK);
        atrib2.setOpaque(true);

        //JFIELD (TEXTOS)
        atrib2.setForeground(Color.WHITE);
        tbuscaNC = new JTextField();
        tbuscaNC.setBounds(500, 100, 165, 30);

        atri1 = new JTextField();
        atri1.setBounds(500, 140, 165, 30);

        fechaV = new JTextField();
        fechaV.setBounds(500, 180, 165, 30);

        rutaV = new JTextField();
        rutaV.setBounds(500, 220, 165, 30);

        codigo = new JTextField();
        codigo.setBounds(500, 260, 165, 30);

        precioV = new JTextField();
        precioV.setBounds(500, 300, 165, 30);

        claV = new JTextField();
        claV.setBounds(500, 340, 165, 30);

        atri2 = new JTextField();
        atri2.setBounds(500, 380, 165, 30);

        //BOTONES
        mostrarRutas = new JButton("RUTAS");
        mostrarRutas.setBounds(680, 220, 100, 30);
        mostrarRutas.setFont(new Font("arial", Font.BOLD, 15));
        mostrarRutas.setForeground(Color.WHITE);
        mostrarRutas.setOpaque(true);
        mostrarRutas.setBackground(Color.RED);
        mostrarRutas.addActionListener(this);

        buscar = new JButton("BUSCAR");
        buscar.setBounds(680, 100, 100, 30);
        buscar.setFont(new Font("arial", Font.BOLD, 15));
        buscar.addActionListener(this);
        buscar.setForeground(Color.WHITE);
        buscar.setOpaque(true);
        buscar.setBackground(Color.RED);

        actualizar = new JButton("ACTUALIZAR");
        actualizar.setBounds(80, 460, 200, 30);
        actualizar.setFont(new Font("arial", Font.BOLD, 15));
        actualizar.setForeground(Color.WHITE);
        actualizar.setOpaque(true);
        actualizar.setBackground(Color.RED);
        actualizar.addActionListener(this);

        mostrarCodigos = new JButton("MOSTRAR CODIGOS");
        mostrarCodigos.setBounds(305, 460, 200, 30);
        mostrarCodigos.setFont(new Font("arial", Font.BOLD, 15));
        mostrarCodigos.setForeground(Color.WHITE);
        mostrarCodigos.setOpaque(true);
        mostrarCodigos.setBackground(Color.RED);
        mostrarCodigos.addActionListener(this);

        volver = new JButton("VOLVER");
        volver.setBounds(530, 460, 200, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.addActionListener(this);
        volver.setForeground(Color.WHITE);
        volver.setOpaque(true);
        volver.setBackground(Color.RED);

        //COMBOBOX
        String vectorG[] = {"", "             " + pasajeros.getClass().getSimpleName(), "               " + carga.getClass().getSimpleName(), "              " + human.getClass().getSimpleName(), "                   " + mix.getClass().getSimpleName()};
        desplegable = new JComboBox(vectorG);
        desplegable.addActionListener(this);
        desplegable.setBounds(90, 200, 150, 30);

        //SE AGREGAN LOS ATRIBUTOS AL PANEL 
        vuelo.add(buscaNC);
        vuelo.add(tbuscaNC);
        vuelo.add(atrib1);
        vuelo.add(atrib2);
        vuelo.add(claseV);
        vuelo.add(horario);
        vuelo.add(ruta);
        vuelo.add(id);
        vuelo.add(precioT);
        vuelo.add(atri1);
        vuelo.add(atri2);
        vuelo.add(fechaV);
        vuelo.add(claV);
        vuelo.add(rutaV);
        vuelo.add(codigo);
        vuelo.add(precioV);
        vuelo.add(titulo);
        vuelo.add(actualizar);
        vuelo.add(mostrarRutas);
        vuelo.add(mostrarCodigos);
        vuelo.add(volver);
        vuelo.add(buscar);
        vuelo.add(desplegable);

        /*SE INHABILITAN ALGUNOS ESPACIOS DE TEXTOS. DEBE SER COMPROBADO QUE EL 
        DATO SEA PERTENEZCA A LISTA ESPECIFICA*/
        if (!verificar) {

            atri1.setEditable(false);
            fechaV.setEditable(false);
            rutaV.setEditable(false);
            claV.setEditable(false);
            codigo.setEditable(false);
            precioV.setEditable(false);
            atri2.setEditable(false);
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
        try {

            //SE HACE UNA VALIDACIÓN DEL CAMPO SELECCIONADO LUEGO SE MANDA A UN METODO JFRAME DONDE SE CREA UN JSCROLL
            if (desplegable.getSelectedItem().toString().equals("             " + pasajeros.getClass().getSimpleName())) {
                if (e.getSource() == mostrarCodigos) {
                    CodigoVueloPasajeros v = new CodigoVueloPasajeros(aerolinea);
                    v.setVisible(true);

                }
            }
            if (desplegable.getSelectedItem().toString().equals("               " + carga.getClass().getSimpleName())) {
                if (e.getSource() == mostrarCodigos) {
                    CodigoVueloCarga v = new CodigoVueloCarga(aerolinea);
                    v.setVisible(true);

                }
            }
            if (desplegable.getSelectedItem().toString().equals("              " + human.getClass().getSimpleName())) {
                if (e.getSource() == mostrarCodigos) {
                    CodigoVueloHuma v = new CodigoVueloHuma(aerolinea);
                    v.setVisible(true);

                }
            }
            if (desplegable.getSelectedItem().toString().equals("                   " + mix.getClass().getSimpleName())) {
                if (e.getSource() == mostrarCodigos) {
                    CodigoVueloMixto v = new CodigoVueloMixto(aerolinea);
                    v.setVisible(true);

                }
            }

            /*SE VALIDA SI EL CAMPO SELECCIONADO CORRESPONDE A ESA CLASE PUEDA INGRESAR DATOS AL TEXTO*/
            if (desplegable.getSelectedItem().toString().equals("             " + pasajeros.getClass().getSimpleName())) {

                atri2.setEditable(false);
                atrib1.setText("NUEVO CANTIDAD PASAJEROS: ");
                titulo.setText("VUELO DE PASAJEROS");
                titulo.setBounds(0, 30, 820, 40);
                atrib2.setText("");
                precioT.setText("NUEVO PRECIO: ");
                precioT.setForeground(Color.WHITE);
                
            //SE BUSCA LA POSICIÓN DE LA CEDULA SI PERTENECE O NO A LA DE LA LISTA DE AZAFATA DE COMIDA
                if (e.getSource() == buscar) {
                    tbuscaNC.setEditable(true);
                    int actualizar = Integer.valueOf(tbuscaNC.getText());

                    for (int i = 0; i < aerolinea.getListaVuelos().size(); i++) {
                        if (desplegable.getSelectedItem().toString().equals("             " + aerolinea.getListaVuelos().get(i).getClass().getSimpleName())) {
                            if ((actualizar - 1) == i) {
                                JOptionPane.showMessageDialog(null, "OPCIÓN CORRECTA. INGRESA LOS DATOS PARA ACTUALIZAR");
                                verificar = true;
                                atri1.setEditable(true);
                                fechaV.setEditable(true);
                                rutaV.setEditable(true);
                                claV.setEditable(true);
                                codigo.setEditable(true);
                                precioV.setEditable(true);
                                break;
                            }
                        }
                    }

                    if (verificar == false) {
                        JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                        tbuscaNC.setText("");
                    }
                }
                //SE AGREGA TODOS LOS DATOS INGRESADOS A LA LISTA(CORRECTAMENTE INGRESADOS)
                if (e.getSource() == actualizar) {
                    tbuscaNC.setEditable(true);
                    int actualizar = Integer.valueOf(tbuscaNC.getText());
                    int cantidadP = Integer.valueOf(atri1.getText());
                    String clase = claV.getText();
                    String horario1 = fechaV.getText();
                    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm");
                    Date fecha = format.parse(horario1);
                    int numRuta = Integer.valueOf(rutaV.getText());
                    String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
                    int codigoRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
                    String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
                    int codigoVuelo = Integer.valueOf(codigo.getText());
                    int precio = Integer.valueOf(precioV.getText());

                    aerolinea.getListaVuelos().get(actualizar - 1).getCodigo();
                    DePasajeros nuevoVPasajero = new DePasajeros(cantidadP, ruta, fecha, clase, codigoVuelo, codigoRuta, tiempoVuelo, precio);
                    aerolinea.getListaVuelos().set(actualizar - 1, nuevoVPasajero);

                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
                    //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
                    atri1.setText("");
                    fechaV.setText("");
                    rutaV.setText("");
                    claV.setText("");
                    codigo.setText("");
                    precioV.setText("");
                    atri2.setText("");
                    tbuscaNC.setText("");
                    precioT.setText("");
                }
                verificar = false;
            }
            
            /*SE VALIDA SI EL CAMPO SELECCIONADO CORRESPONDE A ESA CLASE PUEDA INGRESAR DATOS AL TEXTO*/
            if (desplegable.getSelectedItem().toString().equals("               " + carga.getClass().getSimpleName())) {

                titulo.setText("VUELO DE CARGA");
                titulo.setBounds(0, 30, 820, 40);
                atrib1.setText("NUEVO NOMBRE PRODUCTOS: ");
                atrib2.setText("NUEVO PESO TOTAL CARGA: ");
                precioT.setText("NUEVO PRECIO: ");
                precioT.setForeground(Color.WHITE);
                
                //SE BUSCA LA POSICIÓN DE LA CODIGO SI PERTENECE O NO A LA DE LA LISTA DE VUELO DE CARGA
                if (e.getSource() == buscar) {
                    tbuscaNC.setEditable(true);
                    int actualizar = Integer.valueOf(tbuscaNC.getText());
                    Boolean verificar = false;

                    for (int i = 0; i < aerolinea.getListaVuelos().size(); i++) {
                        if (desplegable.getSelectedItem().toString().equals("               " + aerolinea.getListaVuelos().get(i).getClass().getSimpleName())) {
                            if ((actualizar - 1) == i) {
                                JOptionPane.showMessageDialog(null, "OPCIÓN CORRECTA.INGRESA LOS DATOS PARA ACTUALIZAR");
                                verificar = true;
                                atri1.setEditable(true);
                                fechaV.setEditable(true);
                                rutaV.setEditable(true);
                                claV.setEditable(true);
                                codigo.setEditable(true);
                                precioV.setEditable(true);
                                atri2.setEditable(true);
                                break;
                            }
                        }
                    }

                    if (verificar == false) {
                        JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                        tbuscaNC.setText("");
                    }
                }
                //SE AGREGA TODOS LOS DATOS INGRESADOS A LA LISTA(CORRECTAMENTE INGRESADOS)
                if (e.getSource() == actualizar) {
                    tbuscaNC.setEditable(true);
                    int actualizar = Integer.valueOf(tbuscaNC.getText());
                    String nombreP = atri1.getText();
                    int peso = Integer.valueOf(atri2.getText());
                    String clase = claV.getText();
                    String horario1 = fechaV.getText();
                    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm");
                    Date fecha = format.parse(horario1);
                    int numRuta = Integer.valueOf(rutaV.getText());
                    String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
                    int codigoRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
                    String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
                    int codigoVuelo = Integer.valueOf(codigo.getText());
                    int precio = Integer.valueOf(precioV.getText());

                    aerolinea.getListaVuelos().get(actualizar - 1).getCodigo();
                    DeCarga nuevoVCarga = new DeCarga(nombreP, peso, ruta, codigoVuelo, fecha, clase, codigoRuta, tiempoVuelo, precio);
                    aerolinea.getListaVuelos().set(actualizar - 1, nuevoVCarga);

                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE.");
                    //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
                    tbuscaNC.setText("");
                    atri1.setText("");
                    fechaV.setText("");
                    rutaV.setText("");
                    claV.setText("");
                    codigo.setText("");
                    precioV.setText("");
                    atri2.setText("");
                    tbuscaNC.setText("");
                    precioT.setText("");
                }
                verificar = false;
            }
            
            //SE BUSCA LA POSICIÓN DE LA CODIGO SI PERTENECE O NO A LA DE LA LISTA DE VUELO HUMANITARIO
            if (desplegable.getSelectedItem().toString().equals("              " + human.getClass().getSimpleName())) {

                titulo.setText("VUELO HUMANITARIO");
                titulo.setBounds(0, 30, 820, 40);
                atrib1.setText("NUEVA MISION HUMANITARIA: ");
                atrib2.setText("NUEVO N° DE PERSONAS: ");
                precioT.setText("NO TIENE PRECIO ");
                precioT.setForeground(Color.RED);
                
                //SE AGREGA TODOS LOS DATOS INGRESADOS A LA LISTA(CORRECTAMENTE INGRESADOS)
                if (e.getSource() == buscar) {
                    tbuscaNC.setEditable(true);
                    int actualizar = Integer.valueOf(tbuscaNC.getText());
                    Boolean verificar = false;

                    for (int i = 0; i < aerolinea.getListaVuelos().size(); i++) {
                        if (desplegable.getSelectedItem().toString().equals("              " + aerolinea.getListaVuelos().get(i).getClass().getSimpleName())) {
                            if ((actualizar - 1) == i) {
                                JOptionPane.showMessageDialog(null, "OPCIÓN CORRECTA.INGRESA LOS DATOS PARA ACTUALIZAR");
                                verificar = true;
                                atri1.setEditable(true);
                                fechaV.setEditable(true);
                                rutaV.setEditable(true);
                                claV.setEditable(true);
                                codigo.setEditable(true);
                                precioV.setEditable(false);
                                atri2.setEditable(true);
                                break;
                            }
                        }
                    }

                    if (verificar == false) {
                        JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                        tbuscaNC.setText("");
                    }
                }
                
                //SE AGREGA TODOS LOS DATOS INGRESADOS A LA LISTA(CORRECTAMENTE INGRESADOS)
                if (e.getSource() == actualizar) {
                    tbuscaNC.setEditable(true);
                    int actualizar = Integer.valueOf(tbuscaNC.getText());
                    String mision = atri1.getText();
                    int numeroPH = Integer.valueOf(atri2.getText());
                    String clase = claV.getText();
                    String horario1 = fechaV.getText();
                    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm");
                    Date fecha = format.parse(horario1);
                    int numRuta = Integer.valueOf(rutaV.getText());
                    String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
                    int codigoRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
                    String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
                    int codigoVuelo = Integer.valueOf(codigo.getText());

                    aerolinea.getListaVuelos().get(actualizar - 1).getCodigo();
                    Humanitario nuevoVHum = new Humanitario(mision, numeroPH, ruta, codigoVuelo, codigoRuta, tiempoVuelo, 0, fecha, clase);
                    aerolinea.getListaVuelos().set(actualizar - 1, nuevoVHum);

                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
                    //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
                    tbuscaNC.setText("");
                    atri1.setText("");
                    fechaV.setText("");
                    rutaV.setText("");
                    claV.setText("");
                    codigo.setText("");
                    precioV.setText("");
                    atri2.setText("");
                    tbuscaNC.setText("");
                    precioT.setText("");
                }
                verificar = false;

            }
            
            //SE BUSCA LA POSICIÓN DE LA CODIGO SI PERTENECE O NO A LA DE LA LISTA DE VUELO MIXTO
            if (desplegable.getSelectedItem().toString().equals("                   " + mix.getClass().getSimpleName())) {
                
                
                atri2.setEditable(false);
                titulo.setText("VUELO MIXTO");
                titulo.setBounds(0, 30, 820, 40);
                atrib1.setText("NUEVA DESCRIPCION CARGA: ");
                atrib2.setText("");
                precioT.setText("NUEVO PRECIO: ");
                precioT.setForeground(Color.WHITE);
                
                //SE AGREGA TODOS LOS DATOS INGRESADOS A LA LISTA(CORRECTAMENTE INGRESADOS)
                if (e.getSource() == buscar) {
                    tbuscaNC.setEditable(true);
                    int actualizar = Integer.valueOf(tbuscaNC.getText());
                    Boolean verificar = false;

                    for (int i = 0; i < aerolinea.getListaVuelos().size(); i++) {
                        if (desplegable.getSelectedItem().toString().equals("                   " + aerolinea.getListaVuelos().get(i).getClass().getSimpleName())) {
                            if ((actualizar - 1) == i) {
                                JOptionPane.showMessageDialog(null, "OPCIÓN CORRECTA.INGRESA LOS DATOS PARA ACTUALIZAR");
                                verificar = true;
                                atri1.setEditable(true);
                                fechaV.setEditable(true);
                                rutaV.setEditable(true);
                                claV.setEditable(true);
                                codigo.setEditable(true);
                                precioV.setEditable(true);
                                atri2.setEditable(false);
                                break;
                            }
                        }
                    }

                    if (verificar == false) {
                        JOptionPane.showMessageDialog(null, "OPCIÓN INCORRECTA.DIGITA NUEVAMENTE EL NÚMERO DE VUELO");
                        tbuscaNC.setText("");
                    }
                }
                
                //SE AGREGA TODOS LOS DATOS INGRESADOS A LA LISTA(CORRECTAMENTE INGRESADOS)
                if (e.getSource() == actualizar) {

                    tbuscaNC.setEditable(true);
                    int actualizar = Integer.valueOf(tbuscaNC.getText());
                    String tipoVuelo = atri1.getText();
                    String clase = claV.getText();
                    String horario1 = fechaV.getText();
                    SimpleDateFormat format = new SimpleDateFormat("MM-dd-yyyy-kk-mm");
                    Date fecha = format.parse(horario1);
                    int numRuta = Integer.valueOf(rutaV.getText());
                    String ruta = aerolinea.getListaRutas().get(numRuta - 1).getOrigen() + "-" + aerolinea.getListaRutas().get(numRuta - 1).getDestino();
                    int codigoRuta = aerolinea.getListaRutas().get(numRuta - 1).getCodigo();
                    String tiempoVuelo = aerolinea.getListaRutas().get(numRuta - 1).getTiempoVuelo();
                    int codigoVuelo = Integer.valueOf(codigo.getText());
                    int precio = Integer.valueOf(precioV.getText());

                    aerolinea.getListaVuelos().get(actualizar - 1).getCodigo();
                    Mixto nuevoVMix = new Mixto(tipoVuelo, ruta, codigoVuelo, fecha, clase, codigoRuta, tiempoVuelo, precio);
                    aerolinea.getListaVuelos().set(actualizar - 1, nuevoVMix);

                    JOptionPane.showMessageDialog(null, "DATOS INGRESADOS CORRECTAMENTE");
                    //AL FINALIZAR EL PROCESO SE VACIAN LOS CAMPOS DE TEXTOS PARA QUE EL USUARIO PUEDA MANEJAR MEJOR EL PROGRAMA
                    tbuscaNC.setText("");
                    atri1.setText("");
                    fechaV.setText("");
                    rutaV.setText("");
                    claV.setText("");
                    codigo.setText("");
                    precioV.setText("");
                    atri2.setText("");
                    tbuscaNC.setText("");
                    precioT.setText("");

                }
                verificar = false;
            }
            
            //SE VERIFICA SI EL USUARIO DESEA VER LA LISTA DE LAS RUTAS
            if (e.getSource() == mostrarRutas) {
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
        } catch (ParseException ex) {

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
