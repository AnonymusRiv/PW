package es.uco.pw.data.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

//import com.mysql.jdbc.ResultSet;
import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.business.managers.DBmanager;
import es.uco.pw.data.common.DBConnection;

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
     * @return ArrayList<UserDTO> Vector con los usuarios de la base de datos
     */
    
    public ArrayList<UsuarioDTO> getUsuarios() {
        ArrayList<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
        try {
            DBConnection dbConnection = new DBConnection();
            Connection connection = dbConnection.getConnection();
            
            String query = DBmanager.getUsuarioQuery();
            
            Statement stmt = connection.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery(query);

            while (rs.next()) {
                String name = rs.getString("name");
                java.sql.Timestamp timetamp = rs.getTimestamp("dateOfBirth"); // O/P: DD:MM:YYYY HH:mm:ss
                java.util.Date dateOfBirth = new java.util.Date(timetamp.getTime());
                java.sql.Timestamp timetamp2 = rs.getTimestamp("inscription"); // O/P: DD:MM:YYYY HH:mm:ss
                java.util.Date inscription = new java.util.Date(timetamp2.getTime());
                String email = rs.getString("email");
                
                usuarios.add(new UsuarioDTO(name,dateOfBirth,inscription,email));
            }

            if (stmt != null){ 
                stmt.close(); 
            }
            dbConnection.closeConnection();
        } catch (Exception e){
            System.err.println(e);
            e.printStackTrace();
        }
        return usuarios;
    }
}