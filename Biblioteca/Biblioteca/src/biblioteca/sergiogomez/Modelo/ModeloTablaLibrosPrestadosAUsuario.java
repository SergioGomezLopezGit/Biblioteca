/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.sergiogomez.Modelo;

import biblioteca.sergiogomez.vista.Principal;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Sergio
 */
public class ModeloTablaLibrosPrestadosAUsuario extends AbstractTableModel {
    private final String[] columna= new String [] {"Titulo","ISBN"};
    private ArrayList<Libro> libros;

    public ModeloTablaLibrosPrestadosAUsuario(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public int getRowCount() {
        return libros.size();
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
                obj=libros.get(rowIndex).getTitulo();
                break;
            case 1:
                obj=libros.get(rowIndex).getISBN();
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
