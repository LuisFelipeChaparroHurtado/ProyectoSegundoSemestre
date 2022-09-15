/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA MOSTRAR INFORMACION 
    DE PILOTOS
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
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import logica.Aerolinea;

public class Mostrar_ListaTPiloto extends javax.swing.JFrame implements ActionListener{

    private Aerolinea aerolinea;
    private JScrollPane scroll;
    private JLabel titulo;
    private JButton volver;
    private JTextArea areaTexto;

    public Mostrar_ListaTPiloto(Aerolinea aerolinea) {
        
        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y IMAGEN
         this.aerolinea = aerolinea;
        //SE INCIALIZA EL JSCROLL Y SE COLOCA UN TITULO
        scroll = new JScrollPane();
        this.setTitle("LISTA TRABAJADOR 'PILOTO'");
        
        //SE INICIALIZA EL AREA EN EL CUAL INGRESAREMOS LA INFORMACIÓN
        areaTexto = new JTextArea(80, 40);
        setSize(500, 500);
        setLocationRelativeTo(null);
        areaTexto.setBackground(Color.BLACK);
        areaTexto.setForeground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //TITULO
        titulo = new JLabel("LISTA PILOTOS", SwingConstants.CENTER);
        titulo.setBounds(80, 10, 300, 30);
        titulo.setFont(new Font("arial", Font.BOLD, 15));
        titulo.setForeground(Color.WHITE);
        
        //BOTON
        volver = new JButton("X");
        volver.setBounds(390, 10, 50, 30);
        volver.setFont(new Font("arial", Font.BOLD, 15));
        volver.setForeground(Color.WHITE);
        volver.setOpaque(true);
        volver.setBackground(Color.RED);
        volver.addActionListener(this);

        // Agregando el scrollpane al area de texto
        areaTexto.setText(aerolinea.mostrar_LPiloto());
        areaTexto.add(titulo);
        areaTexto.add(volver);
        scroll.setViewportView(areaTexto);
        // Agregando a la ventana el contenedor scrollpane

        add(scroll, BorderLayout.CENTER);
        setVisible(true);
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
        if (e.getSource() == volver) {
            InformacionTrabajadores info = new InformacionTrabajadores(aerolinea);
             info.setUndecorated(true);
            info.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            info.setVisible(true);
            dispose();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
