/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca.sergiogomez.DAO;

import biblioteca.sergiogomez.DAO.Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sergio
 */
public class ClaseDAO {
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
    
    public boolean comprobarUsuario(String nombre, String contrasena){
        boolean valido=false;
        try {           
            String consulta="select contrasena from usuarios where nombre=?";
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
    
    public Usuario obtenerUsuario(String nombre) throws SQLException{
        Usuario usuario;
        String consulta="select id,nombre,apellido,direccion,telefono,email from usuarios where nombre=?";
        PreparedStatement stmt = connection.prepareStatement(consulta);
        stmt.setString(1, nombre);
        ResultSet rs = stmt.executeQuery();  
        rs.next();
        usuario=new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
        return usuario;
    }
}
