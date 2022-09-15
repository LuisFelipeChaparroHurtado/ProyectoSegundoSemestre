/*
 * AUTOR: LUIS FELIPE CHAPARRO HURTADO
 * FECHA: 03/06/2020
 * DESCRIPCIÓN: SE CREA LA CLASE JFRAME COMO INTERFACE PARA MOSTRAR EN UN JSCROLL 
    LOS CODIGOS ESPECIFICOS DE EL VUELO DE PASAJEROS
 */
package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import logica.Aerolinea;

public class CodigoVueloPasajeros extends javax.swing.JFrame{

    private Aerolinea aerolinea;
    private JScrollPane scroll;
    private JLabel titulo;
    private JTextArea areaTexto;

    public CodigoVueloPasajeros(Aerolinea aerolinea) {
        //SE INICIALIZA ATRIBUTOS Y SE DA COLOR,TAMAÑO Y FONDO A TITULOS, BOTONES Y IMAGEN
        this.aerolinea = aerolinea;
        
        //SE INCIALIZA EL JSCROLL Y SE COLOCA UN TITULO
        scroll = new JScrollPane();
        this.setTitle("CODIGOS");
        
        //SE INICIALIZA EL AREA EN EL CUAL INGRESAREMOS LA INFORMACIÓN
        areaTexto = new JTextArea(30, 10);
        setSize(300, 300);
        setLocationRelativeTo(null);
        areaTexto.setBackground(Color.BLACK);
        areaTexto.setForeground(Color.WHITE);
        
        //TITULO
        titulo = new JLabel("", SwingConstants.CENTER);
        titulo.setBounds(8, 10, 250, 30);
        titulo.setFont(new Font("arial", Font.BOLD, 15));
        titulo.setForeground(Color.WHITE);

        // Agregando el scrollpane al area de texto
        areaTexto.setText(aerolinea.mostrar_CodigoVueloPasajeros());
        areaTexto.add(titulo);
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
