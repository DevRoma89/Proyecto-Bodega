/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC.Controlador;

import MVC.Modelo.Pais;
import MVC.Modelo.DAO.PaisDAO;
import MVC.Vista.IF_Pais;
import MVC.Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author augusto.ojeda
 */
public class ControladorPais extends IF_Pais implements ActionListener , ListSelectionListener {
    

    Pais pais = new Pais();
    PaisDAO dao = new PaisDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    IF_Pais internalFrame;
    
    public ControladorPais(IF_Pais internalFrame){
        this.btnAgregar.addActionListener(this);
        this.btnListar.addActionListener(this);
        this.btnBuscar.addActionListener(this);
        this.btnDelete.addActionListener(this);
        this.btnNuevo.addActionListener(this);
        this.btnEditar.addActionListener(this);
        this.btnActualizar.addActionListener(this);
        this.tabla.getSelectionModel().addListSelectionListener(this);
        
      
    }
     @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()){
            int fliaSeleccionada = tabla.getSelectedRow();
            if(fliaSeleccionada != -1){
            txtId.setText((String) tabla.getValueAt(fliaSeleccionada, 0).toString() ); // Obtener el valor de la columna 1
            txtNom.setText((String) tabla.getValueAt(fliaSeleccionada, 1).toString() );
            btnDelete.setEnabled(true);
            btnEditar.setEnabled(true);
            btnAgregar.setEnabled(false);
            btnActualizar.setEnabled(false);
            campo(2);
         }
           
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == btnAgregar ){
            
       
            pais.setNombre(txtNom.getText());
            
            int r = dao.Insertar(pais);
            campo(1);
            limpiarTabla();
            listarT(tabla);
           

        }
        
        if(e.getSource() == btnListar){
            limpiarTabla();
            listarT(tabla);
            
        }
        
        if(e.getSource() == btnBuscar){
 
                limpiarTabla();
                BuscarT(tabla);  
                campo(3);
                btnEditar.setEnabled(false);
                btnDelete.setEnabled(false);
        }
        
        if(e.getSource() == btnActualizar){
                actualizar();
                limpiarTabla();
                BuscarT(tabla);
        }
        
        if(e.getSource() == btnDelete){
           
            eliminar();
            limpiarTabla();
            listarT(tabla);  
            campo(3);
           
        }
        
        if (e.getSource() == btnNuevo){
           campo(1);
           tabla.clearSelection();
           btnAgregar.setEnabled(true);
           btnDelete.setEnabled(false);
           btnEditar.setEnabled(false);
           btnActualizar.setEnabled(false);
        }
        
        if (e.getSource() == btnEditar){
            campo(4);
            btnActualizar.setEnabled(true);
            btnDelete.setEnabled(false);
            tabla.clearSelection();
        
        }
        
        
    }
    
    public void campo(int opcion){
        
        if(opcion == 1 ){
            txtId.setText("");
            txtNom.setText("");
            txtNom.setEditable(true);
            txtNom.requestFocus();
        }else if (opcion == 2 ){
            txtNom.setEditable(false);
            txtId.setEditable(false);
          
            
        }else if (opcion == 3 ){
             txtId.setText("");
            txtNom.setText("");
            txtNom.setEditable(false);
            txtId.setEditable(false);
        }else if (opcion == 4 ){
         txtNom.setEditable(true);
            txtNom.requestFocus();
        }
        
    
    }
    
    public void actualizar(){
    
        int id = Integer.parseInt(txtId.getText());
        String nombre = txtNom.getText();
        
        dao.Actualizar(id, nombre);
        
        
    }
    
    public void eliminar(){
    
        int fila = tabla.getSelectedRow();
        if (fila == -1 ){
         JOptionPane.showMessageDialog(null,"Debe Seleccionar una Fila...!!!");
        }else {
            int id = Integer.parseInt((String) tabla.getValueAt(fila, 0).toString());
            dao.eliminar(id);
            
            
        }
    
    }
    
    public void listarT(JTable tabla){
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Pais> lista =dao.listar();
        Object[] objeto = new Object[2];
        for (int i = 0 ; i < lista.size(); i++ ){
            objeto[0] = lista.get(i).getIdPais();
            objeto[1] = lista.get(i).getNombre();
            modelo.addRow(objeto);
        }
    
    }
    
    public void BuscarT(JTable tabla){
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        String buscar = txtBusqueda.getText();
        List<Pais> lista =dao.buscar(buscar);
        Object[] objeto = new Object[2];
        for (int i = 0 ; i < lista.size(); i++ ){
            objeto[0] = lista.get(i).getIdPais();
            objeto[1] = lista.get(i).getNombre();
            modelo.addRow(objeto);
        }
    
    }
    
    void limpiarTabla() {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

   
    
    
    
    
    
  
    
    
}
