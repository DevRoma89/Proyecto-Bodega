package MVC.Controlador;

import MVC.Vista.IF_Compra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class ControladorCompra extends IF_Compra implements ActionListener, ListSelectionListener{
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ControladorCompra(IF_Compra InternalFrame){
    
        this.CbNomArt.addActionListener(this);
        this.btnAgregar.addActionListener(this);
        this.btnEditar.addActionListener(this);
        this.btnActualizar.addActionListener(this);
        this.btnDelete.addActionListener(this);
        this.tabla.getSelectionModel().addListSelectionListener(this);
    
        modelo = (DefaultTableModel) tabla.getModel();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAgregar){
            
       
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

}
