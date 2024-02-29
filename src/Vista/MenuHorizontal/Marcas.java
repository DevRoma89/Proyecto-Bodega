/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.MenuHorizontal;

import Vista.MenuVertical.Inicio;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author augusto.ojeda
 */
public class Marcas extends javax.swing.JPanel {

    /**
     * Creates new form CargaDatos
     */
    public Marcas() {
        initComponents();
    }

    private void ShowJPanel(JPanel p){
    
       
        p.setSize(880, 420);
        p.setLocation(0,0);
        
        contenido.removeAll();
        contenido.add(p, BorderLayout.CENTER);
        contenido.revalidate();
        contenido.repaint();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        contenido = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contenido.setMinimumSize(new java.awt.Dimension(880, 420));
        contenido.setPreferredSize(new java.awt.Dimension(880, 420));

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        jLabel4.setText("jLabel4");

        jButton1.setText("ATRAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenidoLayout = new javax.swing.GroupLayout(contenido);
        contenido.setLayout(contenidoLayout);
        contenidoLayout.setHorizontalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel1)
                .addGap(518, 518, 518)
                .addComponent(jLabel2))
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel3)
                .addGap(315, 315, 315)
                .addComponent(jLabel4))
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jButton1))
        );
        contenidoLayout.setVerticalGroup(
            contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenidoLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(contenidoLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel2)))
                .addGap(117, 117, 117)
                .addGroup(contenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(162, 162, 162)
                .addComponent(jButton1))
        );

        add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    ShowJPanel(new Inicio());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenido;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
