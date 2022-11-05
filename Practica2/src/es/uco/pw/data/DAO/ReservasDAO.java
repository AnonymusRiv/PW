package es.uco.pw.data.DAO;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;

//import com.mysql.jdbc.ResultSet;
import es.uco.pw.business.DTO.ReservaAdultosDTO;
import es.uco.pw.business.DTO.ReservaFamiliarDTO;
import es.uco.pw.business.DTO.ReservaInfantilDTO;
import es.uco.pw.business.managers.DBmanager;


/**
 * DAO para reservas que hace uso de la base de datos con una conexión via JDBC
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */


public class ReservasDAO {

    /**
     * Devuelve todas las reservas de adultos de la base de datos
     * @param none
     * @return ArrayList<ReservaAdultosDTO> Vector con las reservas de adultos de la base de datos
     */

    public ArrayList<ReservaAdultosDTO> getReservaAdultos(){
        ArrayList<ReservaAdultosDTO> adultos = new ArrayList<ReservaAdultosDTO>();

        try{

            DBmanager DBm = DBmanager.getInstance();
            Connection connection = DBm.getConnection();
          
            String query = DBm.getReservaAdultosQuery();
          
            Statement stmt = connection.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery(query);
            

            while (rs.next()) {
                String userId = rs.getString("userId");
                java.sql.Timestamp timetamp = rs.getTimestamp("date"); // O/P: DD:MM:YYYY HH:mm:ss
                java.util.Date date = new java.util.Date(timetamp.getTime());
                int duration = rs.getInt("duration");
                String pistaId = rs.getString("pistaId");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                int nParticipants = rs.getInt("nParticipants");
                
                adultos.add(new ReservaAdultosDTO(userId,date,duration,pistaId, price, discount, nParticipants));
            }

            if (stmt != null){ 
                stmt.close(); 
            }
            DBm.closeConnection();

        }catch(Exception e){
            System.err.println(e);
            e.printStackTrace();
        }

        return adultos;
    }


    /**
    * Añade una reserva de adultos a la base de datos
    * @param userId
    * @param date
    * @param duration
    * @param pistaId
    * @param price
    * @param discount
    * @param nParticipants
    * @return none
    */

    public void registrarReservaAdultos(String userId, Date date, int duration, String pistaId, float price, float discount, int nParticipants) {
      try {

        DBmanager DBm = DBmanager.getInstance();
        Connection connection = DBm.getConnection();

        Statement stmt = connection.createStatement();
        String query = MessageFormat.format(DBm.getRegistrarReservaAdultosQuery(),
            "'",userId,"'",
            "'",date,"'",
            "'",duration,"'",
            "'",pistaId,"'",
            "'",price,"'",
            "'",discount,"'",
            "'",nParticipants,"'"
        );
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
   * Modifica una reserva de adultos de la base de datos
   * @param ReservaAdultosDTO Reserva de adultos que se desea modifciar
   * @return none
   */

  public void modificarReservaAdultos(ReservaAdultosDTO adultos) {
      try {

        DBmanager DBm = DBmanager.getInstance();
        Connection connection = DBm.getConnection();

        String query = MessageFormat.format(DBm.getModificarReservaAdultosQuery(),
            "'",adultos.getUserId(),"'",
            "'",adultos.getDate(),"'",
            "'",adultos.getDuration(),"'",
            "'",adultos.getPistId(),"'",
            "'",adultos.getPrice(),"'",
            "'",adultos.getDiscount(),"'",
            "'",adultos.getnParticipants(),"'"
        );

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

 

  /**
   * Borra una reserva de adultos de la base de datos
   * @param userId Identificador de la resrva de adultos que se desea borrar
   * @return none
   */

  public void deleteReservaAdultos(int userId) {
      try {

        DBmanager DBm = DBmanager.getInstance();
        Connection connection = DBm.getConnection();
        
        Statement stmt = connection.createStatement();
        String query= MessageFormat.format(DBm.getDeleteReservaAdultosQuery(), "'",userId,"'");

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
     * Devuelve todas las reservas familiares de la base de datos
     * @param none
     * @return ArrayList<ReservaFamiliarDTO> Vector con las reservas familiares de la base de datos
     */

    public ArrayList<ReservaFamiliarDTO> getReservaFamiliar(){
      ArrayList<ReservaFamiliarDTO> familiar = new ArrayList<ReservaFamiliarDTO>();

      try{

          DBmanager DBm = DBmanager.getInstance();
          Connection connection = DBm.getConnection();
        
          String query = DBm.getReservaFamiliarQuery();
        
          Statement stmt = connection.createStatement();
          ResultSet rs = (ResultSet) stmt.executeQuery(query);
          

          while (rs.next()) {
              String userId = rs.getString("userId");
              java.sql.Timestamp timetamp = rs.getTimestamp("date"); // O/P: DD:MM:YYYY HH:mm:ss
              java.util.Date date = new java.util.Date(timetamp.getTime());
              int duration = rs.getInt("duration");
              String pistaId = rs.getString("pistaId");
              float price = rs.getFloat("price");
              float discount = rs.getFloat("discount");
              int nChildren = rs.getInt("nChildren");
              int nAdults = rs.getInt("nAdults");
              
              familiar.add(new ReservaFamiliarDTO(userId,date,duration,pistaId, price, discount, nChildren, nAdults));
          }

          if (stmt != null){ 
              stmt.close(); 
          }
          DBm.closeConnection();

      }catch(Exception e){
          System.err.println(e);
          e.printStackTrace();
      }

      return familiar;
  }


  /**
  * Añade una reserva de adultos a la base de datos
  * @param userId
  * @param date
  * @param duration
  * @param pistaId
  * @param price
  * @param discount
  * @param nChildren
  * @param nAdults
  * @return none
  */

  public void registrarReservaFamiliar(String userId, Date date, int duration, String pistaId, float price, float discount, int nChildren, int nAdults) {
    try {

      DBmanager DBm = DBmanager.getInstance();
      Connection connection = DBm.getConnection();

      Statement stmt = connection.createStatement();
      String query = MessageFormat.format(DBm.getRegistrarReservaFamiliarQuery(),
          "'",userId,"'",
          "'",date,"'",
          "'",duration,"'",
          "'",pistaId,"'",
          "'",price,"'",
          "'",discount,"'",
          "'",nChildren,"'",
          "'",nAdults,"'"
      );
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
  * Modifica una reserva familiar de la base de datos
  * @param ReservaFamiliarDTO Reserva familiar que se desea modifciar
  * @return none
  */

  public void modificarReservaFamiliar(ReservaFamiliarDTO familiar) {
    try {

      DBmanager DBm = DBmanager.getInstance();
      Connection connection = DBm.getConnection();

      String query = MessageFormat.format(DBm.getModificarReservaFamiliarQuery(),
          "'",familiar.getUserId(),"'",
          "'",familiar.getDate(),"'",
          "'",familiar.getDuration(),"'",
          "'",familiar.getPistId(),"'",
          "'",familiar.getPrice(),"'",
          "'",familiar.getDiscount(),"'",
          "'",familiar.getnChildren(),"'",
          "'",familiar.getnAdults(),"'"
      );

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



  /**
  * Borra una reserva familiar de la base de datos
  * @param userId Identificador de la resrva familiar que se desea borrar
  * @return none
  */

  public void deleteReservaFamiliar(int userId) {
    try {

      DBmanager DBm = DBmanager.getInstance();
      Connection connection = DBm.getConnection();
      
      Statement stmt = connection.createStatement();
      String query= MessageFormat.format(DBm.getDeleteReservaFamiliarQuery(), "'",userId,"'");

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
     * Devuelve todas las reservas de niños de la base de datos
     * @param none
     * @return ArrayList<ReservaInfantilDTO> Vector con las reservas de niños de la base de datos
     */

    public ArrayList<ReservaInfantilDTO> getReservaInfantil(){
      ArrayList<ReservaInfantilDTO> infantil = new ArrayList<ReservaInfantilDTO>();

      try{

          DBmanager DBm = DBmanager.getInstance();
          Connection connection = DBm.getConnection();
        
          String query = DBm.getReservaInfantilQuery();
        
          Statement stmt = connection.createStatement();
          ResultSet rs = (ResultSet) stmt.executeQuery(query);
          

          while (rs.next()) {
              String userId = rs.getString("userId");
              java.sql.Timestamp timetamp = rs.getTimestamp("date"); // O/P: DD:MM:YYYY HH:mm:ss
              java.util.Date date = new java.util.Date(timetamp.getTime());
              int duration = rs.getInt("duration");
              String pistaId = rs.getString("pistaId");
              float price = rs.getFloat("price");
              float discount = rs.getFloat("discount");
              int nChildren = rs.getInt("nChildren");
              
              infantil.add(new ReservaInfantilDTO(userId,date,duration,pistaId, price, discount, nChildren));
          }

          if (stmt != null){ 
              stmt.close(); 
          }
          DBm.closeConnection();

      }catch(Exception e){
          System.err.println(e);
          e.printStackTrace();
      }

      return infantil;
  }


  /**
  * Añade una reserva de niños a la base de datos
  * @param userId
  * @param date
  * @param duration
  * @param pistaId
  * @param price
  * @param discount
  * @param nChildren
  * @return none
  */

  public void registrarReservaInfantil(String userId, Date date, int duration, String pistaId, float price, float discount, int nChildren) {
    try {

      DBmanager DBm = DBmanager.getInstance();
      Connection connection = DBm.getConnection();

      Statement stmt = connection.createStatement();
      String query = MessageFormat.format(DBm.getRegistrarReservaInfantilQuery(),
          "'",userId,"'",
          "'",date,"'",
          "'",duration,"'",
          "'",pistaId,"'",
          "'",price,"'",
          "'",discount,"'",
          "'",nChildren,"'"
      );
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
  * Modifica una reserva infantil de la base de datos
  * @param ReservaInfantilDTO Reserva infantil que se desea modifciar
  * @return none
  */

  public void modificarReservaInfantil(ReservaInfantilDTO infantil) {
    try {

      DBmanager DBm = DBmanager.getInstance();
      Connection connection = DBm.getConnection();

      String query = MessageFormat.format(DBm.getModificarReservaInfantilQuery(),
          "'",infantil.getUserId(),"'",
          "'",infantil.getDate(),"'",
          "'",infantil.getDuration(),"'",
          "'",infantil.getPistId(),"'",
          "'",infantil.getPrice(),"'",
          "'",infantil.getDiscount(),"'",
          "'",infantil.getnChildren(),"'"
      );

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



  /**
  * Borra una reserva infantil de la base de datos
  * @param userId Identificador de la resrva infantil que se desea borrar
  * @return none
  */

  public void deleteReservaInfantil(int userId) {
    try {

      DBmanager DBm = DBmanager.getInstance();
      Connection connection = DBm.getConnection();
      
      Statement stmt = connection.createStatement();
      String query= MessageFormat.format(DBm.getDeleteReservaInfantilQuery(), "'",userId,"'");

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