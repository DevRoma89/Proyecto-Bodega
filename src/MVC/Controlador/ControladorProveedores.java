package MVC.Controlador;

import MVC.Modelo.Ciudad;
import MVC.Modelo.DAO.ProveedorDAO;
import MVC.Modelo.Proveedor;
import MVC.Vista.IF_Proveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ControladorProveedores extends IF_Proveedor implements ActionListener, ListSelectionListener {
    Proveedor proveedor = new Proveedor();
    ProveedorDAO dao = new ProveedorDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    
    
    public ControladorProveedores(IF_Proveedor InternalFrame){
        cargarCB();
        this.comboCiudad.addActionListener(this);
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
        if( e.getSource() == btnNuevo){
           campo(1);
        }
        
        if( e.getSource() == btnAgregar){
            Agregar();
            campo(3);
        }
        //Read
        if( e.getSource() == btnListar){
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
        
        //Update 
        if(e.getSource() == btnEditar){
        
            campo(4);
            btnActualizar.setEnabled(true);
            
        }
        
        if( e.getSource() == btnActualizar){
        
            Actualizar(proveedor);
        
        }
        
        
        
        
        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
       
        if (!e.getValueIsAdjusting()){
            int fliaSeleccionada = tabla.getSelectedRow();
            if(fliaSeleccionada != -1){
            txtId.setText((String) tabla.getValueAt(fliaSeleccionada, 0).toString() ); // Obtener el valor de la columna 1
            txtNom.setText((String) tabla.getValueAt(fliaSeleccionada, 1).toString() );
            txtRUC.setText((String) tabla.getValueAt(fliaSeleccionada, 2).toString() );
            txtContacto.setText((String) tabla.getValueAt(fliaSeleccionada, 3).toString() );
            txtSitioW.setText((String) tabla.getValueAt(fliaSeleccionada, 4).toString() );
            comboCiudad.setSelectedItem((String) tabla.getValueAt(fliaSeleccionada, 5).toString() );
            btnDelete.setEnabled(true);
            btnEditar.setEnabled(true);
            btnAgregar.setEnabled(false);
            btnActualizar.setEnabled(false);
            comboCiudad.setEnabled(false);
            campo(2);
         }
           
        }
        
    }
    
    
    //Create 
    public void Agregar(){
        
        proveedor.setNombreProveedor(txtNom.getText());
        proveedor.setRUC(txtRUC.getText());
        proveedor.setContacto(txtContacto.getText());
        proveedor.setSitioWeb(txtSitioW.getText());
        proveedor.setIdCiudad((int) comboId.getSelectedItem());
        
        dao.Insertar(proveedor);
    
    }
    //Read
    
    
    //Update
    
    public void Actualizar (Proveedor proveedor){
        
            proveedor.setNombreProveedor(txtNom.getText());
            proveedor.setRUC(txtRUC.getText());
            proveedor.setContacto(txtContacto.getText());
            proveedor.setSitioWeb(txtSitioW.getText());
            proveedor.setIdCiudad(Integer.parseInt((String) comboId.getSelectedItem().toString()));
            proveedor.setIdProveedor(Integer.parseInt((txtId.getText())));
        
        dao.Actualizar(proveedor);
    
    }
    
    
    
    //AUX
    public void campo(int opcion){
        
        if(opcion == 1 ){
            txtId.setText("");
            txtNom.setText("");
            txtRUC.setText("");
            txtContacto.setText("");
            txtSitioW.setText("");
            txtNom.setEditable(true);
            txtRUC.setEditable(true);
            txtContacto.setEditable(true);
            txtSitioW.setEditable(true);
            txtRUC.requestFocus();
        }else if (opcion == 2 ){
            txtNom.setEditable(false);
            txtId.setEditable(false);
          
            
        }else if (opcion == 3 ){
            txtId.setText("");
            txtNom.setText("");
            txtRUC.setText("");
            txtContacto.setText("");
            txtSitioW.setText("");
            txtNom.setEditable(false);
            txtId.setEditable(false);
        }else if (opcion == 4 ){
         txtNom.setEditable(true);
         comboCiudad.setEnabled(true);
         txtRUC.setEditable(true);
         txtContacto.setEditable(true);
         txtSitioW.setEditable(true);
            txtRUC.requestFocus();
        }
        
    
    }
    
    
    void limpiarTabla() {
        for (int i = 0; i < tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }
    
    
    public void cargarCB (){
    
       dao.CB_Ciudad(comboId, comboCiudad);
        
         
    
    }
    
    public void listarT(JTable tabla){
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Proveedor> lista =dao.Listar();
        Object[] objeto = new Object[6];
        for (int i = 0 ; i < lista.size(); i++ ){
            objeto[0] = lista.get(i).getIdProveedor();
            objeto[1] = lista.get(i).getNombreProveedor();
            objeto[2] = lista.get(i).getRUC();
            objeto[3] = lista.get(i).getContacto();
            objeto[4] = lista.get(i).getSitioWeb();
            objeto[5] = lista.get(i).getNombreCiudad();
            
            modelo.addRow(objeto);
        }
    
    }
    
    public void BuscarT(JTable tabla){
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        String buscar = txtBusqueda.getText();
        List<Proveedor> lista =dao.Buscar(buscar);
        Object[] objeto = new Object[6];
        for (int i = 0 ; i < lista.size(); i++ ){
            objeto[0] = lista.get(i).getIdProveedor();
            objeto[1] = lista.get(i).getNombreProveedor();
            objeto[2] = lista.get(i).getRUC();
            objeto[3] = lista.get(i).getContacto();
            objeto[4] = lista.get(i).getSitioWeb();
            objeto[5] = lista.get(i).getNombreCiudad();
            
            modelo.addRow(objeto);
        }
    
    }
    
}
