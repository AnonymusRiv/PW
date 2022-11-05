package es.uco.pw.business.managers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Clase encargada de gestionar las conexiones con la base de datos
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class DBmanager {
    
    private static DBmanager instance = null;
    
    private String url="jdbc:mysql://oraclepr.uco.es:3306/p02ritac";
    private String user="p02ritac";
    private String password="PracticaPW";
    
    private String getUsuarioQuery;
    private String registrarUsuarioQuery;
    private String deleteUsuarioQuery;
    private String deleteReservasFromUsuarioQuery;
    private String modificarUsuarioQuery;
    
    private String getReservasQuery;
    private String modifyReservasQuery;
    private String deleteReservasQuery;
    private String addReservasQuery;
    

    protected Connection connection = null;
    
    /**
     * Constructor del DBmanager
     * @param none
     */

    private DBmanager() {
      Properties prop = new Properties();
      String filename = "config.properties";
      try {
        BufferedReader reader = new BufferedReader(
          new FileReader(new File(filename))
        );
        prop.load(reader);

        url = prop.getProperty("url");
        user = prop.getProperty("user");
        password = prop.getProperty("password");
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
      
      prop = new Properties();
      filename = "sql.properties";
      try {
        BufferedReader reader = new BufferedReader(
          new FileReader(new File(filename))
        );
        prop.load(reader);
        
        getUsuarioQuery = prop.getProperty("getUsuarios");
        registrarUsuarioQuery=prop.getProperty("registrarUsuario");
        deleteUsuarioQuery=prop.getProperty("deleteUsuario");
        deleteReservasFromUsuarioQuery=prop.getProperty("deleteReservasFromUsuario");
        modificarUsuarioQuery=prop.getProperty("modificarUsuario");
        
        
        getReservasQuery = prop.getProperty("getReservas");
        modifyReservasQuery = prop.getProperty("modifyReservas");
        deleteReservasQuery = prop.getProperty("deleteReservas");
        addReservasQuery = prop.getProperty("addReservas");
        
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
          e.printStackTrace();
      }
    }

    public Connection getConnection(){

        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Database connection successfully opened!");
        } 
        catch (SQLException e) {
            System.err.println("Connection to MySQL has failed!");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        }
        return this.connection;
    }

    public void closeConnection() {
        try {
            if(this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
                System.out.println("Database connection successfully closed!");
            }
        } catch (SQLException e) {
            System.err.println("Error while trying to close the connection.");
            e.printStackTrace();
        }
    }
    
    /**
     * Método público encargado de devolver
     * la única instancia de la clase
     * @param none
     * @return DataBaseManager Instancia de la clase
     */

    public static DBmanager getInstance() {
      if (instance == null) {
        instance = new DBmanager();
      }
      return instance;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getUsuarioQuery() {
      return getUsuarioQuery;
    }

    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setUsuarioQuery(String getUserQuery) {
      this.getUsuarioQuery = getUserQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getRegistrarUsuarioQuery() {
      return registrarUsuarioQuery;
    }

    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setRegistrarUsuarioQuery(String registrarUsuarioQuery) {
      this.registrarUsuarioQuery = registrarUsuarioQuery;
    }

    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getDeleteUsuarioQuery() {
      return deleteUsuarioQuery;
    }

    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setDeleteUsuarioQuery(String deleteUsuario) {
      this.deleteUsuarioQuery = deleteUsuario;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getDeleteReservasFromUsuarioQuery() {
        return deleteReservasFromUsuarioQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setDeleteReservasFromUsuarioQuery(String deleteReservasFromUsuario) {
        this.deleteReservasFromUsuarioQuery = deleteReservasFromUsuario;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */
    
    public String getModificarUsuarioQuery() {
        return modificarUsuarioQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */
    
    public void setModificarUsuarioQuery(String modificarUsuarioQuery) {
        this.modificarUsuarioQuery = modificarUsuarioQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getReservasQuery() {
      return getReservasQuery;
    }

    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setReservasQuery(String getReservasQuery) {
      this.getReservasQuery = getReservasQuery;
    }

    /**
    * Método público para obtener una query
    * @param none
    * @return String Query buscada
    */

    public String getModifyReservasQuery() {
      return modifyReservasQuery;
    }

    /**
    * Método público para modificar una query
    * @param String Query a modificar
    * @return none
    */

    public void setModifyReservasQuery(String modifyReservasQuery) {
      this.modifyReservasQuery = modifyReservasQuery;
    }

    /**
    * Método público para obtener una query
    * @param none
    * @return String Query buscada
    */

    public String getDeleteReservasQuery() {
      return deleteReservasQuery;
    }

    /**
    * Método público para modificar una query
    * @param String Query a modificar
    * @return none
    */

    public void setDeleteReservasQuery(String deleteReservasQuery) {
      this.deleteReservasQuery = deleteReservasQuery;
    }

    /**
    * Método público para obtener una query
    * @param none
    * @return String Query buscada
    */

    public String getAddReservasQuery() {
      return addReservasQuery;
    }

    /**
    * Método público para modificar una query
    * @param String Query a modificar
    * @return none
    */

    public void setAddReservasQuery(String addReservasQuery) {
      this.addReservasQuery = addReservasQuery;
    }

}