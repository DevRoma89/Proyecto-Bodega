
package MVC.Controlador;

import MVC.Modelo.Ciudad;
import MVC.Modelo.DAO.CiudadDAO;
import MVC.Vista.IF_Ciudad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public final class ControladorCiudad extends IF_Ciudad implements ActionListener, ListSelectionListener{
  
    Ciudad ciudad = new Ciudad();
    CiudadDAO dao = new CiudadDAO();
    
    


    
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
            txtNom1.setEditable(true);
            btnAgregar.setEnabled(true);
        }
        
        if(e.getSource() == btnAgregar){

            ciudad.setNombreCiudad(txtNom1.getText());
            System.out.println(ciudad.getNombreCiudad());
            //ciudad.setIdPais((int) comboId.getSelectedItem());
            
            //dao.Insertar(ciudad);
        
        }
        
        if(e.getSource() == comboNombre){
        
            int NombreSeleccionado = comboNombre.getSelectedIndex();
            comboId.setSelectedIndex(NombreSeleccionado);
        
        }
        //Read
        //Update
        //Delete
        
        
        
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
     
    }


    public void cargarCB (){
    
        dao.CB_Pais(comboId, comboNombre);
        
         
    
    }

   
    
}
