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
    
    private String serverName;
    private String port;
    private String user;
    private String password;
    
    private static String getUsuarioQuery;
    

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

        serverName = prop.getProperty("serverName");
        port = prop.getProperty("port");
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
        
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
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

    public static String getUsuarioQuery() {
      return getUsuarioQuery;
    }

    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setUsuarioQuery(String getUserQuery) {
      DBmanager.getUsuarioQuery = getUserQuery;
    }

}