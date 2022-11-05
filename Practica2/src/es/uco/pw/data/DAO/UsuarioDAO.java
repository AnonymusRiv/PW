package es.uco.pw.data.DAO;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;

//import com.mysql.jdbc.ResultSet;
import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.business.managers.DBmanager;

/**
 * DAO para usuarios que hace uso de la base de datos con una conexión via JDBC
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class UsuarioDAO {
    
    /**
     * Devuelve todos los usuarios de la base de datos
     * @param none
     * @return Lista de usuarios
     */
    
    public ArrayList<UsuarioDTO> getUsuarios() {
        ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
        try {
            DBmanager DBm = DBmanager.getInstance();
            Connection connection = DBm.getConnection();
            
            String query = DBm.getUsuarioQuery();
            
            Statement stmt = connection.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                /*java.sql.Timestamp timetamp = rs.getTimestamp("dateOfBirth"); // O/P: DD:MM:YYYY HH:mm:ss
                java.util.Date dateOfBirth = new java.util.Date(timetamp.getTime());*/
                String dateOfBirth = rs.getString("dateOfBirth");
                java.sql.Timestamp timetamp2 = rs.getTimestamp("inscription"); // O/P: DD:MM:YYYY HH:mm:ss
                java.util.Date inscription = new java.util.Date(timetamp2.getTime());
                String email = rs.getString("email");
                
                usuarios.add(new UsuarioDTO(name,dateOfBirth,inscription,email));
            }

            if (stmt != null){ 
                stmt.close(); 
            }
            DBm.closeConnection();
        } catch (Exception e){
            System.err.println(e);
            e.printStackTrace();
        }
        return usuarios;
    }
    
    /**
     * Registra un usuario en el sistema
     * @param name
     * @param dateOfBirth
     * @param registerDate
     * @param email
     * @return none
     */
    
    public void registrarUsuario(String name, String dateOfBirth, String registerDate, String email) {
        try{
            DBmanager DBm = DBmanager.getInstance();
            Connection connection = DBm.getConnection();
        
            String query= MessageFormat.format(DBm.getRegistrarUsuarioQuery(), "'", name,"'","'", email,"'","'", dateOfBirth,"'","'",registerDate,"'");

            System.out.print(name);
            System.out.print(email);
            System.out.print(dateOfBirth);
            System.out.print(registerDate);
            System.out.print(query);
            
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            if (stmt != null) {
                stmt.close();
            }
        
        }catch (Exception e) {
        System.err.println(e);
        e.printStackTrace();
      }
    }
    
    /**
     * Borra un usuario del sistema
     * @param email
     * @return none
     */
    
    public void deleteUsuario(String email) {
        try {
            DBmanager DBm = DBmanager.getInstance();
            Connection connection = DBm.getConnection();
        
            Statement stmt = connection.createStatement();
            String query= MessageFormat.format(DBm.getDeleteUsuarioQuery(), "'",email,"'");
            
            stmt.executeUpdate(query);
            query=MessageFormat.format(DBm.getDeleteReservasFromUsuarioQuery(), "'",email,"'");
            stmt.executeUpdate(query);
            if (stmt != null) {
                stmt.close();
            }
          } catch (Exception e) {
          System.err.println(e);
          e.printStackTrace();
        }
    }
    
    /**
     * Modifica un usuario del sistema
     * @param email
     * @return none
     */
    
    public void modificarUsuario(UsuarioDTO usuario) {
        try {
            DBmanager DBm = DBmanager.getInstance();
            Connection connection = DBm.getConnection();
        
            String query= MessageFormat.format(DBm.getModificarUsuarioQuery(),"'",usuario.getName(),"'","'",usuario.getDateOfBirth(),"'","'",usuario.getInscription(),"'","'",usuario.getEmail(),"'");
            
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            if (stmt != null) {
                stmt.close();
            }
          } catch (Exception e) {
          System.err.println(e);
          e.printStackTrace();
        }
    }
    
}