
package MVC.Controlador;

import MVC.Modelo.Ciudad;
import MVC.Modelo.DAO.CiudadDAO;
import MVC.Vista.IF_Ciudad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public final class ControladorCiudad extends IF_Ciudad implements ActionListener, ListSelectionListener{
  
    Ciudad ciudad = new Ciudad();
    CiudadDAO dao = new CiudadDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    
    
    


    
    public ControladorCiudad(IF_Ciudad InternalFrame){
        cargarCB();
        this.comboNombre.addActionListener(this);
        this.btnNuevo.addActionListener(this);
        this.btnEditar.addActionListener(this);
        this.btnListar.addActionListener(this);
        this.btnAgregar.addActionListener(this);
        this.btnActualizar.addActionListener(this);
        this.btnDelete.addActionListener(this);
        this.btnBuscar.addActionListener(this);
        this.tabla.getSelectionModel().addListSelectionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Create
        
        if(e.getSource() == btnNuevo){
            campo(1);
            txtNom.setEditable(true);
            btnAgregar.setEnabled(true);
            comboNombre.setEnabled(true);
            
        }
        
        if(e.getSource() == btnAgregar){

            ciudad.setNombreCiudad(txtNom.getText());
            
            ciudad.setIdPais((int) comboId.getSelectedItem());
            
            dao.Insertar(ciudad);
            
            txtNom.setText("");
            limpiarTabla();
            listarT(tabla);
        
        }
        
        if(e.getSource() == comboNombre){
        
            int NombreSeleccionado = comboNombre.getSelectedIndex();
            comboId.setSelectedIndex(NombreSeleccionado);
        
        }
        //Read
        if(e.getSource()== btnListar){
            limpiarTabla();
            listarT(tabla);
        }
        
        if(e.getSource()== btnBuscar){
            limpiarTabla();
            BuscarT(tabla);  
            campo(3);
            btnEditar.setEnabled(false);
            btnDelete.setEnabled(false);
        
    }
        
        //Update
        
        if(e.getSource()== btnEditar){
        campo(4);
            btnActualizar.setEnabled(true);
            btnDelete.setEnabled(false);
            comboNombre.setEnabled(true);
            tabla.clearSelection();
        
    }
        
        if(e.getSource()== btnActualizar){
            actualizar();
            limpiarTabla();
            BuscarT(tabla);
        
    }
        //Delete
        
        if(e.getSource()== btnDelete){
        eliminar();
        limpiarTabla();
        listarT(tabla);  
        campo(3);
     
    }
        
        
        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
     if (!e.getValueIsAdjusting()){
            int fliaSeleccionada = tabla.getSelectedRow();
            if(fliaSeleccionada != -1){
            txtId.setText((String) tabla.getValueAt(fliaSeleccionada, 0).toString() ); // Obtener el valor de la columna 1
            txtNom.setText((String) tabla.getValueAt(fliaSeleccionada, 1).toString() );
         }
           
        }  
    }


    //AUX
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
    
    
    void limpiarTabla() {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
    
    public void cargarCB (){
    
        dao.CB_Pais(comboId, comboNombre);
        
         
    
    }

    

//Read
public void BuscarT(JTable tabla){
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        String buscar = txtBusqueda.getText();
        List<Ciudad> lista =dao.buscar(buscar);
        Object[] objeto = new Object[3];
        for (int i = 0 ; i < lista.size(); i++ ){
            objeto[0] = lista.get(i).getIdCiudad();
            objeto[1] = lista.get(i).getNombreCiudad();
            objeto[2] = lista.get(i).getNombrePais();
            modelo.addRow(objeto);
        }
    
    }
    
    public void listarT(JTable tabla){
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Ciudad> lista =dao.listar();
        Object[] objeto = new Object[3];
        for (int i = 0 ; i < lista.size(); i++ ){
            objeto[0] = lista.get(i).getIdCiudad();
            objeto[1] = lista.get(i).getNombreCiudad();
            objeto[2] = lista.get(i).getNombrePais();
            modelo.addRow(objeto);
        }
    
    }
    

//Update
    public void actualizar(){
    
        
        ciudad.setNombreCiudad( txtNom.getText());
        ciudad.setIdPais((int) comboId.getSelectedItem());
        ciudad.setIdCiudad(Integer.parseInt(txtId.getText()));
        dao.Actualizar(ciudad);
        
        
    }

//Delete
    public void eliminar(){
    
        int fila = tabla.getSelectedRow();
        if (fila == -1 ){
         JOptionPane.showMessageDialog(null,"Debe Seleccionar una Fila...!!!");
        }else {
            int id = Integer.parseInt((String) tabla.getValueAt(fila, 0).toString());
            dao.Eliminar(id);
           
            
        }
    
    }


}
