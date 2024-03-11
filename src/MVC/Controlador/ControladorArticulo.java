package MVC.Controlador;

import MVC.Modelo.Articulo;
import MVC.Modelo.Ciudad;
import MVC.Modelo.DAO.ArticuloDAO;
import MVC.Vista.IF_Articulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ControladorArticulo extends IF_Articulo implements ActionListener, ListSelectionListener {

    Articulo articulo = new Articulo();
    ArticuloDAO dao = new ArticuloDAO();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorArticulo(IF_Articulo InternalFrame) {
        CargarCB();
        this.comboMarca.addActionListener(this);
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

        if (e.getSource() == btnNuevo) {
            campo(1);
            txtNom.setEditable(true);
            btnAgregar.setEnabled(true);
            comboMarca.setEnabled(true);

        }

        if (e.getSource() == btnAgregar) {

            articulo.setNombre(txtNom.getText());

            articulo.setIdMarca((int) comboId.getSelectedItem());

            dao.Insertar(articulo);

            txtNom.setText("");
            limpiarTabla();
            listarT(tabla);

        }

        if (e.getSource() == comboMarca) {

            int NombreSeleccionado = comboMarca.getSelectedIndex();
            comboId.setSelectedIndex(NombreSeleccionado);

        }
        //Read
        if (e.getSource() == btnListar) {
            limpiarTabla();
            listarT(tabla);
        }

        if (e.getSource() == btnBuscar) {
            limpiarTabla();
            BuscarT(tabla);
            campo(3);
            btnEditar.setEnabled(false);
            btnDelete.setEnabled(false);

        }

        //Update
        if (e.getSource() == btnEditar) {
            campo(4);
            btnActualizar.setEnabled(true);
            btnDelete.setEnabled(false);
            comboMarca.setEnabled(true);
            tabla.clearSelection();

        }

        if (e.getSource() == btnActualizar) {
            actualizar();
            limpiarTabla();
            listarT(tabla);

        }
        //Delete

        if (e.getSource() == btnDelete) {
            eliminar();
            limpiarTabla();
            listarT(tabla);
            campo(3);

        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int fliaSeleccionada = tabla.getSelectedRow();
            if (fliaSeleccionada != -1) {
                txtId.setText((String) tabla.getValueAt(fliaSeleccionada, 0).toString()); // Obtener el valor de la columna 1
                txtNom.setText((String) tabla.getValueAt(fliaSeleccionada, 1).toString());
                comboMarca.setSelectedItem((String) tabla.getValueAt(fliaSeleccionada, 2).toString());
                btnDelete.setEnabled(true);
                btnEditar.setEnabled(true);
                btnAgregar.setEnabled(false);
                btnActualizar.setEnabled(false);
                comboMarca.setEnabled(false);

            }

        }
    }

    //Read
    public void BuscarT(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        String buscar = txtBusqueda.getText();
        List<Articulo> lista = dao.Buscar(buscar);
        Object[] objeto = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getIdArticulo();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getNombreMarca();
            modelo.addRow(objeto);
        }

    }

    public void listarT(JTable tabla) {
        modelo = (DefaultTableModel) tabla.getModel();
        tabla.setModel(modelo);
        List<Articulo> lista = dao.Listar();
        Object[] objeto = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getIdArticulo();
            objeto[1] = lista.get(i).getNombre();
            objeto[2] = lista.get(i).getNombreMarca();
            modelo.addRow(objeto);
        }

    }

//Update
    public void actualizar() {

        articulo.setNombre(txtNom.getText());
        articulo.setIdMarca((int) comboId.getSelectedItem());
        articulo.setIdArticulo(Integer.parseInt(txtId.getText()));
        System.out.println(articulo);
        dao.Actualizar(articulo);

    }

//Delete
    public void eliminar() {

        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe Seleccionar una Fila...!!!");
        } else {
            articulo.setIdArticulo(Integer.parseInt((String) tabla.getValueAt(fila, 0).toString()));
            dao.Eliminar(articulo);

        }

    }

    //AUX
    public void CargarCB() {

        dao.CB_Marca(comboId, comboMarca);

    }

    public void campo(int opcion) {
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
}
