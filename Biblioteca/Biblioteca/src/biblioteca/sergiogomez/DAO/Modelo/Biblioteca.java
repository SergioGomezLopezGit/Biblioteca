/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.sergiogomez.DAO.Modelo;

import java.util.ArrayList;

/**
 *
 * @author Sergio
 */
public class Biblioteca {
    private ArrayList<Libros> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Libros> prestamos;

    public ArrayList<Libros> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libros> libros) {
        this.libros = libros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Libros> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Libros> prestamos) {
        this.prestamos = prestamos;
    }

    
    
    public Biblioteca() {
    }

    public Biblioteca(ArrayList<Libros> libros, ArrayList<Usuario> usuarios, ArrayList<Libros> prestamos) {
        this.libros = new ArrayList<Libros>();
        this.usuarios = new ArrayList<Usuario>();
        this.prestamos = new ArrayList<Libros>();
    }
     
}
