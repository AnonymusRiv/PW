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
    
    private String url;
    private String user;
    private String password;
    
    private String getUsuarioQuery;
    private String registrarUsuarioQuery;
    private String deleteUsuarioQuery;
    private String deleteReservasFromUsuarioQuery;
    private String modificarUsuarioQuery;
    
    private String reservaAdultosQuery;
    private String registrarReservaAdultosQuery;
    private String modificarReservaAdultosQuery;
    private String deleteReservaAdultosQuery;
    private String reservaFamiliarQuery;
    private String registrarReservaFamiliarQuery;
    private String modificarReservaFamiliarQuery;
    private String deleteReservaFamiliarQuery;
    private String reservaInfantilQuery;
    private String registrarReservaInfantilQuery;
    private String modificarReservaInfantilQuery;
    private String deleteReservaInfantilQuery;
    
    private String getPistaQuery;
    private String registrarPistaQuery;
    private String deletePistaQuery;
    private String deleteReservasFromPistaQuery;
    private String modificarPistaQuery;
    
    private String getKartsQuery;
    private String registrarKartsQuery;
    private String deleteKartQuery;
    private String modificarKartQuery;

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
        
        reservaAdultosQuery=prop.getProperty("getReservaAdultos");
        registrarReservaAdultosQuery=prop.getProperty("registrarReservaAdultos");
        modificarReservaAdultosQuery=prop.getProperty("modificarReservaAdultos");
        deleteReservaAdultosQuery=prop.getProperty("deleteReservaAdultos");
        reservaFamiliarQuery=prop.getProperty("getReservaFamiliar");
        registrarReservaFamiliarQuery=prop.getProperty("registrarReservaFamiliar");
        modificarReservaFamiliarQuery=prop.getProperty("modificarReservaFamiliar");
        deleteReservaFamiliarQuery=prop.getProperty("deleteReservaFamiliar");
        reservaInfantilQuery=prop.getProperty("getReservaInfantil");
        registrarReservaInfantilQuery=prop.getProperty("registrarReservaInfantil");
        modificarReservaInfantilQuery=prop.getProperty("modificarReservaInfantil");
        deleteReservaInfantilQuery=prop.getProperty("deleteReservaInfantil");
        
        getPistaQuery=prop.getProperty("getPista");
        registrarPistaQuery=prop.getProperty("registrarPista");
        deletePistaQuery=prop.getProperty("deletePista");
        deleteReservasFromPistaQuery=prop.getProperty("deleteReservasFromPista");
        modificarPistaQuery=prop.getProperty("modificarPista");
        
        getKartsQuery=prop.getProperty("getKarts");
        registrarKartsQuery=prop.getProperty("registrarKart");
        deleteKartQuery=prop.getProperty("deleteKart");
        modificarKartQuery=prop.getProperty("modificarKart");
        
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
    
    public String getReservasAdultosQuery() {
        return reservaAdultosQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setReservasAdultosQuery(String reservasAdultosQuery) {
        this.reservaAdultosQuery = reservasAdultosQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getRegistrarReservaAdultosQuery() {
        return registrarReservaAdultosQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setRegistrarReservaAdultosQuery(String registrarReservaAdultosQuery) {
        this.registrarReservaAdultosQuery = registrarReservaAdultosQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getModificarReservaAdultosQuery() {
        return modificarReservaAdultosQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setModificarReservaAdultosQuery(String modificarReservaAdultosQuery) {
        this.modificarReservaAdultosQuery = modificarReservaAdultosQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getDeleteReservaAdultosQuery() {
        return deleteReservaAdultosQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setDeleteReservaAdultosQuery(String deleteReservaAdultosQuery) {
        this.deleteReservaAdultosQuery = deleteReservaAdultosQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getReservaFamiliarQuery() {
        return reservaFamiliarQuery;
    }

    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setReservaFamiliarQuery(String reservaFamiliarQuery) {
        this.reservaFamiliarQuery = reservaFamiliarQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getRegistrarReservaFamiliarQuery() {
        return registrarReservaFamiliarQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setRegistrarReservaFamiliarQuery(String registrarReservaFamiliarQuery) {
        this.registrarReservaFamiliarQuery = registrarReservaFamiliarQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getModificarReservaFamiliarQuery() {
        return modificarReservaFamiliarQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setModificarReservaFamiliarQuery(String modificarReservaFamiliarQuery) {
        this.modificarReservaFamiliarQuery = modificarReservaFamiliarQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getDeleteReservaFamiliarQuery() {
        return deleteReservaFamiliarQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setDeleteReservaFamiliarQuery(String deleteReservaFamiliarQuery) {
        this.deleteReservaFamiliarQuery = deleteReservaFamiliarQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getReservaInfantilQuery() {
        return reservaInfantilQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setReservaInfantilQuery(String reservaInfantilQuery) {
        this.reservaInfantilQuery = reservaInfantilQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getRegistrarReservaInfantilQuery() {
        return registrarReservaInfantilQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setRegistrarReservaInfantilQuery(String registrarReservaInfantilQuery) {
        this.registrarReservaInfantilQuery = registrarReservaInfantilQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getModificarReservaInfantilQuery() {
        return modificarReservaInfantilQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setModificarReservaInfantilQuery(String modificarReservaInfantilQuery) {
        this.modificarReservaInfantilQuery = modificarReservaInfantilQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getDeleteReservaInfantilQuery() {
        return deleteReservaInfantilQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setDeleteReservaInfantilQuery(String deleteReservaInfantilQuery) {
        this.deleteReservaInfantilQuery = deleteReservaInfantilQuery;
    }

    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getPistaQuery() {
        return getPistaQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setPistaQuery(String getPistaQuery) {
        this.getPistaQuery = getPistaQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getRegistrarPistaQuery() {
        return registrarPistaQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setRegistrarPistaQuery(String registrarPistaQuery) {
        this.registrarPistaQuery = registrarPistaQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getDeletePistaQuery() {
        return deletePistaQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setDeletePistaQuery(String deletePistaQuery) {
        this.deletePistaQuery = deletePistaQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getDeleteReservasFromPistaQuery() {
        return deleteReservasFromPistaQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setDeleteReservasFromPistaQuery(String deleteReservasFromPistaQuery) {
        this.deleteReservasFromPistaQuery = deleteReservasFromPistaQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getModificarPistaQuery() {
        return modificarPistaQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setModificarPistaQuery(String modificarPistaQuery) {
        this.modificarPistaQuery = modificarPistaQuery;
    }
    
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getKartsQuery() {
        return getKartsQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setKartsQuery(String KartsQuery) {
        this.getKartsQuery = KartsQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getRegistrarKartQuery() {
        return registrarKartsQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setRegistrarKartQuery(String registrarKartsQuery) {
        this.registrarKartsQuery = registrarKartsQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getdeleteKartQuery() {
        return deleteKartQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setdeleteKartQuery(String deleteKartQuery) {
        this.deleteKartQuery = deleteKartQuery;
    }
    
    /**
     * Método público para obtener una query
     * @param none
     * @return String Query buscada
     */

    public String getModificarKartQuery() {
        return modificarKartQuery;
    }
    
    /**
     * Método público para modificar una query
     * @param String Query a modificar
     * @return none
     */

    public void setModificarKartQuery(String modificarKartQuery) {
        this.modificarKartQuery = modificarKartQuery;
    }
    

}