
package MVC.Controlador;

import MVC.Modelo.Ciudad;
import MVC.Modelo.DAO.CiudadDAO;
import MVC.Vista.IF_Ciudad;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ControladorCiudad extends IF_Ciudad implements ActionListener, ListSelectionListener {

    Ciudad ciudad = new Ciudad();
    CiudadDAO dao = new CiudadDAO();
    
    
    
    
    public ControladorCiudad(IF_Ciudad InternalFrame){
        
        
        cargarCB();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void cargarCB (){
    
        dao.CB_Pais(comboId, comboNombre);
         String NombreSeleccionado = (String) comboNombre.getSelectedItem();
    
    }
    
}
