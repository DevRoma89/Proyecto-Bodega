package MVC.Controlador;

import MVC.Modelo.Articulo;
import MVC.Modelo.Compra;
import MVC.Modelo.DAO.ArticuloDAO;
import MVC.Modelo.DAO.CompraDAO;
import MVC.Modelo.DAO.ProveedorDAO;
import MVC.Modelo.Proveedor;
import MVC.Modelo.Usuario;
import MVC.Modelo.UsuarioActual;
import MVC.Vista.IF_Compra;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.omg.CORBA.COMM_FAILURE;

public class ControladorCompra extends IF_Compra implements ActionListener, ListSelectionListener, KeyListener {

    DefaultTableModel modelo = new DefaultTableModel();
    Usuario usuario = UsuarioActual.getUsuario();
    ProveedorDAO daoP = new ProveedorDAO();
    ArticuloDAO daoA = new ArticuloDAO();
    CompraDAO daoC = new CompraDAO();
    Compra compra = new Compra();

    LocalDate fechaActual = LocalDate.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String fechaFormateada = fechaActual.format(formatter);

    public ControladorCompra(IF_Compra InternalFrame) {
        this.txtFecha.setText(String.valueOf(fechaFormateada));
        this.txtIdUsuario.setText(String.valueOf(usuario.getIdUsuario()));
        this.txtNom2.setText(usuario.getUser());
        this.btnArticulo.addActionListener(this);
        this.btnEditar.addActionListener(this);
        this.btnActualizar.addActionListener(this);
        this.btnDelete.addActionListener(this);
        this.btnCabecera.addActionListener(this);
        this.tablaLista.getSelectionModel().addListSelectionListener(this);
        this.btnProveedor.addActionListener(this);
        modelo = (DefaultTableModel) tabla.getModel();
        this.txtListado.addKeyListener(this);
        this.btnAgregarDetalle.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnProveedor) {
            txtListado.setEditable(true);
            txtListado.requestFocus();
            BuscarT(tablaLista, "");
        }

        if (e.getSource() == btnCabecera) {
            if (!(txtIdProveedor.getText()).isEmpty()) {
                EstablecerCabecera();
                btnProveedor.setEnabled(false);
                txtListado.setEditable(false);
                btnCabecera.setEnabled(false);
                btnArticulo.setEnabled(true);
                limpiarTablaLista();
            } else {
                JOptionPane.showMessageDialog(null, "Eliga un proveedor");
            }
        }

        if (e.getSource() == btnArticulo) {
            txtListado.setEditable(true);
            txtListado.requestFocus();
            BuscarT(tablaLista, "");
            txtCantidad.setEditable(true);
            txtPrecio.setEditable(true);
            btnAgregarDetalle.setEnabled(true);
        }

        if (e.getSource() == btnAgregarDetalle) {

            if (!(txtCantidad.getText().isEmpty()) && !(txtPrecio.getText().isEmpty())) {
            
                 AgregarDetalle();
                 listarDetalle(tabla);
            
            }else{
                
                JOptionPane.showMessageDialog(null,"Complete los campos");
            
            }
           
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int fliaSeleccionada = tablaLista.getSelectedRow();
            if (btnProveedor.isEnabled()) {
                if (fliaSeleccionada != -1) {
                    txtIdProveedor.setText((String) tablaLista.getValueAt(fliaSeleccionada, 0).toString()); // Obtener el valor de la columna 1
                    txtNombreProveedor.setText((String) tablaLista.getValueAt(fliaSeleccionada, 1).toString());
                }
            }
            if (btnArticulo.isEnabled()) {
                txtIdArticulo.setText("");
                txtNombreArticulo.setText("");
                if (fliaSeleccionada != -1) {
                    txtIdArticulo.setText((String) tablaLista.getValueAt(fliaSeleccionada, 0).toString()); // Obtener el valor de la columna 1
                    txtNombreArticulo.setText((String) tablaLista.getValueAt(fliaSeleccionada, 1).toString());
                }
            }

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
            } else {
                limpiarTablaLista();
                listarT(tablaLista);
            }

        }
    }

    //Create
    public void EstablecerCabecera() {

        Compra compra = new Compra();
        compra.setIdUsuario(Integer.parseInt(txtIdUsuario.getText()));
        compra.setIdProveedor(Integer.parseInt(txtIdProveedor.getText()));

        int Id = daoC.InsertarCabecera(compra);

        txtIdCompra.setText("" + Id);

    }

    public void AgregarDetalle() {

        compra.setIdCompra(Integer.parseInt(txtIdCompra.getText()));
        compra.setFkIdArticulo(Integer.parseInt(txtIdArticulo.getText()));
        compra.setCantidadArticulo(Integer.parseInt(txtCantidad.getText()));
        compra.setPrecioArticulo(Double.parseDouble(txtPrecio.getText()));

        int cantidad = compra.getCantidadArticulo();
        double precio = compra.getPrecioArticulo();
        compra.setTotalDetalle(precio * cantidad);

        daoC.InsertarDetalle(compra);

    }

    //Read
    //Update
    //Delate
    public void BuscarT(JTable tabla, String buscar) {
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        if (btnProveedor.isEnabled()) {
            List<Proveedor> lista = daoP.Buscar2(buscar);
            Object[] objeto = new Object[2];
            for (int i = 0; i < lista.size(); i++) {
                objeto[0] = lista.get(i).getIdProveedor();
                objeto[1] = lista.get(i).getNombreProveedor();

                modelo.addRow(objeto);
            }
        }
        if (btnArticulo.isEnabled()) {
            List<Articulo> lista2 = daoA.Buscar2(buscar);
            Object[] objeto2 = new Object[2];
            for (int i = 0; i < lista2.size(); i++) {
                objeto2[0] = lista2.get(i).getIdArticulo();
                objeto2[1] = lista2.get(i).getNombre();

                modelo.addRow(objeto2);
            }

        }

    }

    public void listarT(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);

        if (btnProveedor.isEnabled()) {
            List<Proveedor> lista = daoP.Listar();
            Object[] objeto = new Object[2];
            for (int i = 0; i < lista.size(); i++) {
                objeto[0] = lista.get(i).getIdProveedor();
                objeto[1] = lista.get(i).getNombreProveedor();

                modelo.addRow(objeto);
            }
        }

        if (btnArticulo.isEnabled()) {
            List<Articulo> lista2 = daoA.Listar();
            Object[] objeto2 = new Object[2];
            for (int i = 0; i < lista2.size(); i++) {
                objeto2[0] = lista2.get(i).getIdArticulo();
                objeto2[1] = lista2.get(i).getNombre();

                modelo.addRow(objeto2);
            }
        }

    }

    public void listarDetalle(JTable tabla){
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Compra> lista =daoC.BuscarDetalle(compra);
        Object[] objeto = new Object[5];
        for (int i = 0 ; i < lista.size(); i++ ){
            objeto[0] = lista.get(i).getIdCompra();
            objeto[1] = lista.get(i).getNombreArticulo();
            objeto[2] = lista.get(i).getCantidadArticulo();
            objeto[3] = lista.get(i).getPrecioArticulo();
            objeto[4] = lista.get(i).getTotalDetalle();
            modelo.addRow(objeto);
        }
    
    }
    
    
    void limpiarTablaLista() {
        for (int i = 0; i < tablaLista.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

}
