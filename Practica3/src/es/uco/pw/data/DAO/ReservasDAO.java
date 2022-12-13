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
          
            String query = DBm.getReservasAdultosQuery();
          
            Statement stmt = connection.createStatement();
            ResultSet rs = (ResultSet) stmt.executeQuery(query);
            

            while (rs.next()) {
                int id = rs.getInt("Id");
                String userId = rs.getString("userId");
                String date = rs.getString("date");
                int duration = rs.getInt("duration");
                String pistaId = rs.getString("pistaId");
                float price = rs.getFloat("price");
                float discount = rs.getFloat("discount");
                int nParticipants = rs.getInt("nAdults");
                int BonoId = rs.getInt("bonoId");
                
                adultos.add(new ReservaAdultosDTO(id,userId,date,duration,pistaId, price, discount, nParticipants, BonoId));
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

    public void registrarReservaAdultos(ReservaAdultosDTO reserva) {
        try {

            DBmanager DBm = DBmanager.getInstance();
            Connection connection = DBm.getConnection();
            PreparedStatement ps = null;

            Statement stmt = connection.createStatement();
            String query = MessageFormat.format(DBm.getRegistrarReservaAdultosQuery(),
                    "'",reserva.getId(),"'",
                    "'",reserva.getUserId(),"'",
                    "'",reserva.getDate(),"'",
                    "'",reserva.getDuration(),"'",
                    "'",reserva.getPistId(),"'",
                    "'",reserva.getPrice(),"'",
                    "'",reserva.getDiscount(),"'",
                    "'",reserva.getnParticipants(),"'"
                    );
            ps = connection.prepareStatement(query);
            ps.setInt(1, reserva.getId());
            ps.setString(2, reserva.getUserId());
            ps.setString(3, reserva.getDate());
            ps.setInt(4, reserva.getDuration());
            ps.setString(5, reserva.getPistId());
            ps.setFloat(6, reserva.getPrice());
            ps.setFloat(7, reserva.getDiscount());
            ps.setString(8, "adultos");
            ps.setInt(9, reserva.getnParticipants());
            
            ps.executeUpdate();
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
              int id = rs.getInt("Id");
              String userId = rs.getString("userId");
              String date = rs.getString("date");
              int duration = rs.getInt("duration");
              String pistaId = rs.getString("pistaId");
              float price = rs.getFloat("price");
              float discount = rs.getFloat("discount");
              int nChildren = rs.getInt("nChilds");
              int nAdults = rs.getInt("nAdults");
              int BonoId = rs.getInt("bonoId");
              
              familiar.add(new ReservaFamiliarDTO(id, userId,date,duration,pistaId, price, discount, nChildren, nAdults, BonoId));
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
  * @param reserva
  * @return none
  */

  public void registrarReservaFamiliar(ReservaFamiliarDTO reserva) {
      try {

          DBmanager DBm = DBmanager.getInstance();
          Connection connection = DBm.getConnection();
          PreparedStatement ps = null;

          Statement stmt = connection.createStatement();
          String query = MessageFormat.format(DBm.getRegistrarReservaFamiliarQuery(),
                  "'",reserva.getId(),"'",
                  "'",reserva.getUserId(),"'",
                  "'",reserva.getDate(),"'",
                  "'",reserva.getDuration(),"'",
                  "'",reserva.getPistId(),"'",
                  "'",reserva.getPrice(),"'",
                  "'",reserva.getDiscount(),"'",
                  "'",reserva.getnChildren(),"'",
                  "'",reserva.getnAdults(),"'"
                  );
          ps = connection.prepareStatement(query);
          ps.setInt(1, reserva.getId());
          ps.setString(2, reserva.getUserId());
          ps.setString(3, reserva.getDate());
          ps.setInt(4, reserva.getDuration());
          ps.setString(5, reserva.getPistId());
          ps.setFloat(6, reserva.getPrice());
          ps.setFloat(7, reserva.getDiscount());
          ps.setString(8, "familiar");
          ps.setInt(9, reserva.getnChildren());
          ps.setInt(10, reserva.getnAdults());
          
          ps.executeUpdate();
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

  public void modificarReservaFamiliar(ReservaFamiliarDTO reserva, int id) {
      try {

          DBmanager DBm = DBmanager.getInstance();
          Connection connection = DBm.getConnection();
          PreparedStatement ps = null;

          Statement stmt = connection.createStatement();
          String query = MessageFormat.format(DBm.getModificarReservaInfantilQuery(),
                  "'",reserva.getId(),"'",
                  "'",reserva.getUserId(),"'",
                  "'",reserva.getDate(),"'",
                  "'",reserva.getDuration(),"'",
                  "'",reserva.getPistId(),"'",
                  "'",reserva.getPrice(),"'",
                  "'",reserva.getDiscount(),"'",
                  "'",reserva.getnChildren(),"'"
                  );
          ps = connection.prepareStatement(query);
          ps.setString(1, reserva.getDate());
          ps.setInt(2, reserva.getDuration());
          ps.setString(3, reserva.getPistId());
          ps.setFloat(4, reserva.getPrice());
          ps.setFloat(5, reserva.getDiscount());
          ps.setInt(6, reserva.getnChildren());
          ps.setInt(7, id);
          
          ps.executeUpdate();
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
              int id = rs.getInt("Id");
              String userId = rs.getString("userId");
              String date = rs.getString("date");
              int duration = rs.getInt("duration");
              String pistaId = rs.getString("pistaId");
              float price = rs.getFloat("price");
              float discount = rs.getFloat("discount");
              int nChildren = rs.getInt("nChilds");
              int BonoId = rs.getInt("bonoID");
              
              infantil.add(new ReservaInfantilDTO(id, userId,date,duration,pistaId, price, discount, nChildren, BonoId));
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
  * @param reserva
  * @return none
  */

    public void registrarReservaInfantil(ReservaInfantilDTO reserva) {  
        try {

            DBmanager DBm = DBmanager.getInstance();
            Connection connection = DBm.getConnection();
            PreparedStatement ps = null;

            Statement stmt = connection.createStatement();
            String query = MessageFormat.format(DBm.getRegistrarReservaInfantilQuery(),
                    "'",reserva.getId(),"'",
                    "'",reserva.getUserId(),"'",
                    "'",reserva.getDate(),"'",
                    "'",reserva.getDuration(),"'",
                    "'",reserva.getPistId(),"'",
                    "'",reserva.getPrice(),"'",
                    "'",reserva.getDiscount(),"'",
                    "'",reserva.getnChildren(),"'"
                    );
            ps = connection.prepareStatement(query);
            ps.setInt(1, reserva.getId());
            ps.setString(2, reserva.getUserId());
            ps.setString(3, reserva.getDate());
            ps.setInt(4, reserva.getDuration());
            ps.setString(5, reserva.getPistId());
            ps.setFloat(6, reserva.getPrice());
            ps.setFloat(7, reserva.getDiscount());
            ps.setString(8, "infantil");
            ps.setInt(9, reserva.getnChildren());
            
            ps.executeUpdate();
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

  public void modificarReservaInfantil(ReservaInfantilDTO reserva, int id) {
      try {

          DBmanager DBm = DBmanager.getInstance();
          Connection connection = DBm.getConnection();
          PreparedStatement ps = null;

          Statement stmt = connection.createStatement();
          String query = MessageFormat.format(DBm.getModificarReservaInfantilQuery(),
                  "'",reserva.getId(),"'",
                  "'",reserva.getUserId(),"'",
                  "'",reserva.getDate(),"'",
                  "'",reserva.getDuration(),"'",
                  "'",reserva.getPistId(),"'",
                  "'",reserva.getPrice(),"'",
                  "'",reserva.getDiscount(),"'",
                  "'",reserva.getnChildren(),"'"
                  );
          ps = connection.prepareStatement(query);
          ps.setString(1, reserva.getDate());
          ps.setInt(2, reserva.getDuration());
          ps.setString(3, reserva.getPistId());
          ps.setFloat(4, reserva.getPrice());
          ps.setFloat(5, reserva.getDiscount());
          ps.setInt(6, reserva.getnChildren());
          ps.setInt(7, id);
          
          ps.executeUpdate();
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
  
  /**
   * Añade una reserva bono familiar a la base de datos
   * @param reserva
   * @return none
   */

   public void registrarReservaBonoFamiliar(ReservaFamiliarDTO reserva) {
       try {

           DBmanager DBm = DBmanager.getInstance();
           Connection connection = DBm.getConnection();
           PreparedStatement ps = null;

           Statement stmt = connection.createStatement();
           int BonoId = 0;
           String query = MessageFormat.format(DBm.getRegistrarReservaBonoFamiliarQuery(),
                   "'",reserva.getId(),"'",
                   "'",reserva.getUserId(),"'",
                   "'",reserva.getDate(),"'",
                   "'",reserva.getDuration(),"'",
                   "'",reserva.getPistId(),"'",
                   "'",reserva.getPrice(),"'",
                   "'",reserva.getDiscount(),"'",
                   "'",reserva.getnChildren(),"'",
                   "'",reserva.getnAdults(),"'",
                   "'",BonoId,"'"
                   );
           ps = connection.prepareStatement(query);
           ps.setInt(1, reserva.getId());
           ps.setString(2, reserva.getUserId());
           ps.setString(3, reserva.getDate());
           ps.setInt(4, reserva.getDuration());
           ps.setString(5, reserva.getPistId());
           ps.setFloat(6, reserva.getPrice());
           ps.setFloat(7, reserva.getDiscount());
           ps.setString(8, "familiar");
           ps.setInt(9, reserva.getnChildren());
           ps.setInt(10, reserva.getnAdults());
           ps.setInt(11, BonoId);
           
           ps.executeUpdate();
           if (stmt != null) {
               stmt.close();
           }
       } catch (Exception e) {
           System.err.println(e);
           e.printStackTrace();
       }
   }
   
   /**
    * Añade una reserva bono de adultos a la base de datos
    * @param reserva
    * @return none
    */

    public void registrarReservaBonoAdultos(ReservaAdultosDTO reserva) {
        try {

            DBmanager DBm = DBmanager.getInstance();
            Connection connection = DBm.getConnection();
            PreparedStatement ps = null;

            Statement stmt = connection.createStatement();
            int BonoId = 0;
            String query = MessageFormat.format(DBm.getRegistrarReservaBonoFamiliarQuery(),
                    "'",reserva.getId(),"'",
                    "'",reserva.getUserId(),"'",
                    "'",reserva.getDate(),"'",
                    "'",reserva.getDuration(),"'",
                    "'",reserva.getPistId(),"'",
                    "'",reserva.getPrice(),"'",
                    "'",reserva.getDiscount(),"'",
                    "'",reserva.getnParticipants(),"'",
                    "'",BonoId,"'"
                    );
            ps = connection.prepareStatement(query);
            ps.setInt(1, reserva.getId());
            ps.setString(2, reserva.getUserId());
            ps.setString(3, reserva.getDate());
            ps.setInt(4, reserva.getDuration());
            ps.setString(5, reserva.getPistId());
            ps.setFloat(6, reserva.getPrice());
            ps.setFloat(7, reserva.getDiscount());
            ps.setString(8, "adultos");
            ps.setInt(9, reserva.getnParticipants());
            ps.setInt(10, BonoId);
            
            ps.executeUpdate();
            if (stmt != null) {
                stmt.close();
            }
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
    
    /**
     * Añade una reserva bono infantil a la base de datos
     * @param reserva
     * @return none
     */

     public void registrarReservaBonoInfantil(ReservaInfantilDTO reserva) {
         try {

             DBmanager DBm = DBmanager.getInstance();
             Connection connection = DBm.getConnection();
             PreparedStatement ps = null;

             Statement stmt = connection.createStatement();
             String query = MessageFormat.format(DBm.getRegistrarReservaBonoInfantilQuery(),
                     "'",reserva.getId(),"'",
                     "'",reserva.getUserId(),"'",
                     "'",reserva.getDate(),"'",
                     "'",reserva.getDuration(),"'",
                     "'",reserva.getPistId(),"'",
                     "'",reserva.getPrice(),"'",
                     "'",reserva.getDiscount(),"'",
                     "'",reserva.getnChildren(),"'",
                     "'",reserva.getBonoId(),"'"
                     );
             ps = connection.prepareStatement(query);
             ps.setInt(1, reserva.getId());
             ps.setString(2, reserva.getUserId());
             ps.setString(3, reserva.getDate());
             ps.setInt(4, reserva.getDuration());
             ps.setString(5, reserva.getPistId());
             ps.setFloat(6, reserva.getPrice());
             ps.setFloat(7, reserva.getDiscount());
             ps.setString(8, "infantil");
             ps.setInt(9, reserva.getnChildren());
             ps.setInt(10, reserva.getBonoId());
             
             ps.executeUpdate();
             if (stmt != null) {
                 stmt.close();
             }
         } catch (Exception e) {
             System.err.println(e);
             e.printStackTrace();
         }
     }
     
     /**
      * Añade una reserva bono a la base de datos
      * @param reserva
      * @return none
      */

      public void registrarReservaBono(ReservaInfantilDTO reserva) {
          try {

              DBmanager DBm = DBmanager.getInstance();
              Connection connection = DBm.getConnection();
              PreparedStatement ps = null;

              Statement stmt = connection.createStatement();
              String query = MessageFormat.format(DBm.getRegistrarReservaBonoInfantilQuery(),
                      "'",reserva.getId(),"'",
                      "'",reserva.getUserId(),"'",
                      "'",reserva.getDate(),"'",
                      "'",reserva.getDuration(),"'",
                      "'",reserva.getPistId(),"'",
                      "'",reserva.getPrice(),"'",
                      "'",reserva.getDiscount(),"'",
                      "'",reserva.getnChildren(),"'",
                      "'",reserva.getBonoId(),"'"
                      );
              ps = connection.prepareStatement(query);
              ps.setInt(1, reserva.getId());
              ps.setString(2, reserva.getUserId());
              ps.setString(3, reserva.getDate());
              ps.setInt(4, reserva.getDuration());
              ps.setString(5, reserva.getPistId());
              ps.setFloat(6, reserva.getPrice());
              ps.setFloat(7, reserva.getDiscount());
              ps.setString(8, "infantil");
              ps.setInt(9, reserva.getnChildren());
              ps.setInt(10, reserva.getBonoId());
              
              ps.executeUpdate();
              if (stmt != null) {
                  stmt.close();
              }
          } catch (Exception e) {
              System.err.println(e);
              e.printStackTrace();
          }
      }

}