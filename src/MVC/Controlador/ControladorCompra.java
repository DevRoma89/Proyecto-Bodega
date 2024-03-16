package MVC.Controlador;

import MVC.Modelo.DAO.ProveedorDAO;
import MVC.Modelo.Proveedor;
import MVC.Modelo.Usuario;
import MVC.Modelo.UsuarioActual;
import MVC.Vista.IF_Compra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ControladorCompra extends IF_Compra implements ActionListener, ListSelectionListener, KeyListener {

    DefaultTableModel modelo = new DefaultTableModel();
    Usuario usuario = UsuarioActual.getUsuario();
    ProveedorDAO daoP = new ProveedorDAO();

    public ControladorCompra(IF_Compra InternalFrame) {

        this.txtNom2.setText(usuario.getUser());
        this.btnAgregar.addActionListener(this);
        this.btnEditar.addActionListener(this);
        this.btnActualizar.addActionListener(this);
        this.btnDelete.addActionListener(this);
        this.tabla.getSelectionModel().addListSelectionListener(this);
        this.btnProveedor.addActionListener(this);
        modelo = (DefaultTableModel) tabla.getModel();
        this.txtListado.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnProveedor) {

        }
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

    }

    public void BuscarT(JTable tabla, String buscar) {
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Proveedor> lista = daoP.Buscar2(buscar);
        Object[] objeto = new Object[2];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getIdProveedor();
            objeto[1] = lista.get(i).getNombreProveedor();
            
          
            modelo.addRow(objeto);
        }

    }
    
    public void listarT(JTable tabla){
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Proveedor> lista =daoP.Listar();
        Object[] objeto = new Object[6];
        for (int i = 0 ; i < lista.size(); i++ ){
            objeto[0] = lista.get(i).getIdProveedor();
            objeto[1] = lista.get(i).getNombreProveedor();
         ;
            
            modelo.addRow(objeto);
        }
    
    }

    void limpiarTablaLista() {
        for (int i = 0; i < tablaLista.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getSource() == txtListado) {
            String buscar = txtListado.getText();
            if (!buscar.isEmpty()) {
                limpiarTablaLista();
                BuscarT(tablaLista, buscar);
            }else{
                limpiarTablaLista();
                listarT(tablaLista);
            }

        }
    }

}
