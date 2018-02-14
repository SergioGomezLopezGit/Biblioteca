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
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Libro> prestamos;

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Libro> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(ArrayList<Libro> prestamos) {
        this.prestamos = prestamos;
    }

    
    
    public Biblioteca() {
    }

    public Biblioteca(ArrayList<Libro> libros, ArrayList<Usuario> usuarios, ArrayList<Libro> prestamos) {
        this.libros = new ArrayList<Libro>();
        this.usuarios = new ArrayList<Usuario>();
        this.prestamos = new ArrayList<Libro>();
    }
     
}
