/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.sergiogomez.DAO;

import biblioteca.sergiogomez.Modelo.Libro;
import biblioteca.sergiogomez.Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public final class ClaseDAO {
    private Connection connection;
    
    public ClaseDAO(){
        conexion();
    }
    
    public void conexion() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca","root","");
        } catch (SQLException ignore) {
            ignore.printStackTrace();
        }
    }
    
    public boolean cambiarContrasena(Usuario usuario,String contrasena){
        boolean valido=true;
        try {
            String consulta="UPDATE usuarios SET contrasena = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setInt(2, usuario.getId());
            stmt.setString(1, contrasena);
            int res=stmt.executeUpdate();
            if(res!=1){
                valido=false;
            }
        } catch (SQLException ex) {
            valido=false;
            ex.printStackTrace();
        }
        return valido;
    }
    
    public boolean comprobarUsuario(String nombre, String contrasena){
        boolean valido=false;
        try {           
            String consulta="select contrasena from usuarios where nombre_usuario=?";
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();  
            if(rs.absolute(1)){
                if(contrasena.equals(rs.getString(1))){
                    valido=true;
                }else{
                    valido=false;
                }
            }else{
                valido=false;
            }
        } catch (SQLException ex) {
            return false;
        }
        return valido;
    }
    
    public int nuevoIdUsuario(){
        int id=0;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select max(id) from usuarios");
            rs.absolute(1);
            id=rs.getInt(1)+1;
        } catch (SQLException ex) {
            Logger.getLogger(ClaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean existeUsuario(String nombre){
        boolean existe=false;
        try {           
            String consulta="select id from usuarios where nombre_usuario=?";
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, nombre);
            ResultSet rs = stmt.executeQuery();  
            existe = rs.absolute(1);
        } catch (SQLException ex) {
            return existe;
        }
        return existe;
    }
    
    public boolean existeLibro(String isbn){
        boolean existe=false;
        try {           
            String consulta="select ISBN from libros where ISBN=?";
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, isbn);
            ResultSet rs = stmt.executeQuery();  
            existe = rs.absolute(1);
        } catch (SQLException ex) {
            return existe;
        }
        return existe;
    }
    
    public ArrayList<Usuario> cargarUsuarios(){
        ArrayList<Usuario> fila=new ArrayList<Usuario>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select id,nombre_usuario, nombre, apellido, direccion, telefono, email, contrasena from usuarios");
            while (rs.next()) {
                fila.add(new Usuario(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8)));
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {}
        return fila;
    }
    
    public void addUsuario(Usuario usuario,String contrasena){
        try {
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate("INSERT INTO usuarios (id, carnet, Nombre, Apellido, Direccion, Telefono, Email, contrasena, Nombre_Usuario) "
                    + "VALUES ("+usuario.getId()+", '0', '"+usuario.getNombre()+"', '"+usuario.getApellido()+"', '"+usuario.getDireccion()+"', '"+usuario.getTelefono()+"', '"+usuario.getEmail()+"', '"+contrasena+"', '"+usuario.getNombreUsuario()+"');"); 
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void addLibro(Libro libro){
        try {
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate("INSERT INTO libros (titulo, isbn, idusuario) "
                    + "VALUES ('"+libro.getTitulo()+"', '"+libro.getISBN()+"', NULL);"); 
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Libro> cargarLibros(){
        ArrayList<Libro> fila=new ArrayList<Libro>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from libros");
            while (rs.next()) {
                fila.add(new Libro(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {}
        return fila;
    }
    
    public void borrarUsuario(int id){
        try {
            String consulta="delete from usuarios where id=?";
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setInt(1, id);
            int rs = stmt.executeUpdate();  
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void borrarLibro(String isbn){
        try {
            String consulta="delete from libros where isbn=?";
            PreparedStatement stmt = connection.prepareStatement(consulta);
            stmt.setString(1, isbn);
            int rs = stmt.executeUpdate();  
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public Usuario obtenerUsuario(String nombre) throws SQLException{
        Usuario usuario;
        String consulta="select id,nombre_usuario,nombre,apellido,direccion,telefono,email,contrasena from usuarios where nombre_usuario=?";
        PreparedStatement stmt = connection.prepareStatement(consulta);
        stmt.setString(1, nombre);
        ResultSet rs = stmt.executeQuery();  
        rs.next();
        usuario=new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8));
        return usuario;
    }
    
    public void actualizarUsuario(Usuario usuario){
        try {
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate("UPDATE usuarios SET nombre_usuario = '"+usuario.getNombreUsuario()+"', nombre = '"+usuario.getNombre()+"', apellido = '"+usuario.getApellido()+"', direccion = '"+usuario.getDireccion()+"', telefono = '"+usuario.getTelefono()+"', email = '"+usuario.getEmail()+"' WHERE id = "+usuario.getId()+";");
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void actualizarLibros(Libro libro){
        try {
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate("UPDATE libros SET titulo = '"+libro.getTitulo()+"' WHERE isbn = "+libro.getISBN()+";");
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Libro> cargarLibrosUsuairo(int id){
        ArrayList<Libro> fila=new ArrayList<Libro>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from libros where idusuario="+id+"");
            while (rs.next()) {
                fila.add(new Libro(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {}
        return fila;
    }
    
    public ArrayList<Libro> cargarLibrosSinPrestamo(){
        ArrayList<Libro> fila=new ArrayList<Libro>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("select * from libros where idusuario IS NULL");
            while (rs.next()) {
                fila.add(new Libro(rs.getString(1), rs.getString(2), rs.getInt(3)));
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {}
        return fila;
    }
        
    public void realizarReserva(int id,String titulo){
        try {
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate("UPDATE libros SET idusuario = "+id+" WHERE titulo = '"+titulo+"';");
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
       
    public void realizarDevolucion(int id,String titulo){
        try {
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate("UPDATE libros SET idusuario = NULL WHERE titulo = '"+titulo+"';");
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
