/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.sergiogomez.DAO.Modelo;

/**
 *
 * @author Sergio
 */
public class Libros {
    private int id;
    private String titulo;
    private String ISBN;
    private int idprestamo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(int idprestamo) {
        this.idprestamo = idprestamo;
    }

    public Libros(int id, String titulo, String ISBN, int idprestamo) {
        this.id = id;
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.idprestamo = idprestamo;
    }

    public Libros() {
    }
       
}
