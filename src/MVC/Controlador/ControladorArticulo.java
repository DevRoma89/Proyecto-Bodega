package MVC.Controlador;

import MVC.Modelo.Articulo;
import MVC.Modelo.DAO.ArticuloDAO;
import MVC.Vista.IF_Articulo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class ControladorArticulo extends IF_Articulo implements ActionListener, ListSelectionListener {

    Articulo articulo = new Articulo();
    ArticuloDAO dao = new ArticuloDAO();
    DefaultTableModel modelo = new DefaultTableModel();

    public ControladorArticulo(IF_Articulo InternalFrame) {
        CargarCB();
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

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int fliaSeleccionada = tabla.getSelectedRow();
            if (fliaSeleccionada != -1) {
                txtId.setText((String) tabla.getValueAt(fliaSeleccionada, 0).toString()); // Obtener el valor de la columna 1
                txtNom.setText((String) tabla.getValueAt(fliaSeleccionada, 1).toString());
                comboCiudad.setSelectedItem((String) tabla.getValueAt(fliaSeleccionada, 2).toString());
                btnDelete.setEnabled(true);
                btnEditar.setEnabled(true);
                btnAgregar.setEnabled(false);
                btnActualizar.setEnabled(false);
                comboCiudad.setEnabled(false);

            }

        }
    }

    public void CargarCB() {

        dao.CB_Marca(comboId, comboCiudad);

    }

}
