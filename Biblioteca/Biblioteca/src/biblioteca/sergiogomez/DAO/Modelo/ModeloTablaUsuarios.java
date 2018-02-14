/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.sergiogomez.DAO.Modelo;

import biblioteca.sergiogomez.vista.Principal;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sergio
 */
public class ModeloTablaUsuarios extends AbstractTableModel {
    private String[] columna= new String [] {"Nombre Usuario","Contraseña","Nombre", "Apellidos", "Direccion", "Telefono", "Email"};
    
    @Override
    public int getRowCount() {
        return Principal.getBiblioteca().getUsuarios().size();
    }

    @Override
    public int getColumnCount() {
        return columna.length;
    }

    @Override
    public String getColumnName(int col) {
        return columna[col];
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        super.setValueAt(aValue, rowIndex, columnIndex);
        fireTableDataChanged();       
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object obj=null;
        switch(columnIndex){
            case 0:
                obj=Principal.getBiblioteca().getUsuarios().get(rowIndex).getNombreUsuario();
                break;
            case 1:
                obj=Principal.getBiblioteca().getUsuarios().get(rowIndex).getContrasena();
                break;
            case 2:
                obj=Principal.getBiblioteca().getUsuarios().get(rowIndex).getNombre();
                break;
            case 3:
                obj=Principal.getBiblioteca().getUsuarios().get(rowIndex).getApellido();
                break;
            case 4:
                obj=Principal.getBiblioteca().getUsuarios().get(rowIndex).getDireccion();
                break;
            case 5:
                obj=Principal.getBiblioteca().getUsuarios().get(rowIndex).getTelefono();
                break;
            case 6:
                obj=Principal.getBiblioteca().getUsuarios().get(rowIndex).getEmail();
                break;
        }
        return obj;
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
            return java.lang.Object.class;
    }
    
}
