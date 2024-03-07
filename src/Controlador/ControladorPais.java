/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Pais;
import Modelo.PaisDAO;
import Vista.IF_Pais;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author augusto.ojeda
 */
public class ControladorPais extends IF_Pais implements ActionListener {
    
    Menu m = new Menu();
    Pais pais = new Pais();
    PaisDAO dao = new PaisDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    IF_Pais internalFrame;
    
    public ControladorPais(IF_Pais internalFrame){
        this.btnAgregar.addActionListener(this);
        this.btnListar.addActionListener(this);
        this.btnBuscar.addActionListener(this);
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == btnAgregar ){
            String nombre = txtNom.getText();
            pais.setNombre(nombre);
            
            int r = dao.Insertar(pais);

        }
        
        if(e.getSource() == btnListar){
            limpiarTabla();
            listarT(tabla);
        }
        
        if(e.getSource() == btnBuscar){
 
                limpiarTabla();
                BuscarT(tabla);
            
        }
        
        if(e.getSource() == btnDelete){
            eliminar();
            limpiarTabla();
            listarT(tabla); 
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
