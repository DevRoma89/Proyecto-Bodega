/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.MenuVertical;


import Vista.MenuHorizontal.Articulo;
import Vista.MenuHorizontal.Ciudades;
import Vista.MenuHorizontal.Clientes;
import Vista.MenuHorizontal.Marcas;
import Vista.MenuHorizontal.Paises;
import Vista.MenuHorizontal.Proveedores;
import Vista.MenuHorizontal.Usuarios;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Ivan
 */
public class Inicio extends javax.swing.JPanel {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
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

        fondo = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnUsuarios = new javax.swing.JButton();
        btnPaises = new javax.swing.JButton();
        btnCiudades = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnMarcas = new javax.swing.JButton();
        btnArticulos = new javax.swing.JButton();
        contenido = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        fondo.setBackground(new java.awt.Color(255, 255, 255));
        fondo.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(3, 55, 192));
        jPanel1.setPreferredSize(new java.awt.Dimension(840, 40));

        btnUsuarios.setBackground(new java.awt.Color(3, 55, 192));
        btnUsuarios.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuarios.setText("USUARIOS");
        btnUsuarios.setBorderPainted(false);
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnPaises.setBackground(new java.awt.Color(3, 55, 192));
        btnPaises.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnPaises.setForeground(new java.awt.Color(255, 255, 255));
        btnPaises.setText("PAISES");
        btnPaises.setBorderPainted(false);
        btnPaises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaisesActionPerformed(evt);
            }
        });

        btnCiudades.setBackground(new java.awt.Color(3, 55, 192));
        btnCiudades.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnCiudades.setForeground(new java.awt.Color(255, 255, 255));
        btnCiudades.setText("CIUDADES");
        btnCiudades.setBorderPainted(false);
        btnCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCiudadesActionPerformed(evt);
            }
        });

        btnClientes.setBackground(new java.awt.Color(3, 55, 192));
        btnClientes.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(255, 255, 255));
        btnClientes.setText("CLIENTES");
        btnClientes.setBorderPainted(false);
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnProveedores.setBackground(new java.awt.Color(3, 55, 192));
        btnProveedores.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(255, 255, 255));
        btnProveedores.setText("PROVEEDORES");
        btnProveedores.setBorderPainted(false);
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnMarcas.setBackground(new java.awt.Color(3, 55, 192));
        btnMarcas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMarcas.setForeground(new java.awt.Color(255, 255, 255));
        btnMarcas.setText("MARCAS");
        btnMarcas.setBorderPainted(false);
        btnMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcasActionPerformed(evt);
            }
        });

        btnArticulos.setBackground(new java.awt.Color(3, 55, 192));
        btnArticulos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnArticulos.setForeground(new java.awt.Color(255, 255, 255));
        btnArticulos.setText("ARTICULOS");
        btnArticulos.setBorderPainted(false);
        btnArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticulosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnArticulos, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnMarcas, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnCiudades, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnPaises, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnMarcas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnPaises, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        contenido.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
            .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcasActionPerformed
        ShowJPanel(new Marcas());
    }//GEN-LAST:event_btnMarcasActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        ShowJPanel(new Clientes());
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
          ShowJPanel(new Proveedores());
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnPaisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaisesActionPerformed
            ShowJPanel(new Paises());
    }//GEN-LAST:event_btnPaisesActionPerformed

    private void btnArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticulosActionPerformed
        ShowJPanel(new Articulo());
    }//GEN-LAST:event_btnArticulosActionPerformed

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
            ShowJPanel(new Usuarios());
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCiudadesActionPerformed
           ShowJPanel(new Ciudades());
    }//GEN-LAST:event_btnCiudadesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArticulos;
    private javax.swing.JButton btnCiudades;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnMarcas;
    private javax.swing.JButton btnPaises;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JPanel contenido;
    private javax.swing.JPanel fondo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
