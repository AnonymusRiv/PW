package es.uco.pw.data.DAO;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;

import es.uco.pw.business.DTO.BonoDTO;
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

  public void modificarReservaAdultos(ReservaAdultosDTO reserva, int id) {
      try {

    	  DBmanager DBm = DBmanager.getInstance();
          Connection connection = DBm.getConnection();
          PreparedStatement ps = null;

          Statement stmt = connection.createStatement();
          String query = MessageFormat.format(DBm.getModificarReservaAdultosQuery(),
                  "'",reserva.getDate(),"'",
                  "'",reserva.getDuration(),"'",
                  "'",reserva.getPistId(),"'",
                  "'",reserva.getPrice(),"'",
                  "'",reserva.getDiscount(),"'",
                  "'",reserva.getnParticipants(),"'",
                  "'",reserva.getBonoId(),"'"
                  );
          ps = connection.prepareStatement(query);
          ps.setString(1, reserva.getDate());
          ps.setInt(2, reserva.getDuration());
          ps.setString(3, reserva.getPistId());
          ps.setFloat(4, reserva.getPrice());
          ps.setFloat(5, reserva.getDiscount());
          ps.setInt(6, reserva.getnParticipants());
          ps.setInt(7, reserva.getBonoId());
          ps.setInt(8, id);
          
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
   * Borra una reserva de adultos de la base de datos
   * @param userId Identificador de la resrva de adultos que se desea borrar
   * @return none
   */

  public void deleteReservaAdultos(ReservaAdultosDTO reserva) {
	  try {
          DBmanager DBm = DBmanager.getInstance();
          Connection connection = DBm.getConnection();
          PreparedStatement ps = null;
          
          Statement stmt = connection.createStatement();
          String query= MessageFormat.format(DBm.getDeleteReservaAdultosQuery(), "'",reserva.getId(),"'");
          ps = connection.prepareStatement(query);
          ps.setInt(1, reserva.getId());
          
          
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
          String query = MessageFormat.format(DBm.getModificarReservaFamiliarQuery(),
                  "'",reserva.getDate(),"'",
                  "'",reserva.getDuration(),"'",
                  "'",reserva.getPistId(),"'",
                  "'",reserva.getPrice(),"'",
                  "'",reserva.getDiscount(),"'",
                  "'",reserva.getnAdults(),"'",
                  "'",reserva.getnChildren(),"'",
                  "'",reserva.getBonoId(),"'"
                  );
          ps = connection.prepareStatement(query);
          ps.setString(1, reserva.getDate());
          ps.setInt(2, reserva.getDuration());
          ps.setString(3, reserva.getPistId());
          ps.setFloat(4, reserva.getPrice());
          ps.setFloat(5, reserva.getDiscount());
          ps.setInt(6, reserva.getnAdults());
          ps.setInt(7, reserva.getnChildren());
          ps.setInt(8, reserva.getBonoId());
          ps.setInt(9, id);
          
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

  public void deleteReservaFamiliar(ReservaFamiliarDTO reserva) {
	  try {
          DBmanager DBm = DBmanager.getInstance();
          Connection connection = DBm.getConnection();
          PreparedStatement ps = null;
          
          Statement stmt = connection.createStatement();
          String query= MessageFormat.format(DBm.getDeleteReservaFamiliarQuery(), "'",reserva.getId(),"'");
          ps = connection.prepareStatement(query);
          ps.setInt(1, reserva.getId());
          
          
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
                  "'",reserva.getnChildren(),"'",
                  "'",reserva.getBonoId(),"'"
                  );
          ps = connection.prepareStatement(query);
          ps.setString(1, reserva.getDate());
          ps.setInt(2, reserva.getDuration());
          ps.setString(3, reserva.getPistId());
          ps.setFloat(4, reserva.getPrice());
          ps.setFloat(5, reserva.getDiscount());
          ps.setInt(6, reserva.getnChildren());
          ps.setInt(7, reserva.getBonoId());
          ps.setInt(8, id);
          
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

  public void deleteReservaInfantil(ReservaInfantilDTO reserva) {
	  try {
          DBmanager DBm = DBmanager.getInstance();
          Connection connection = DBm.getConnection();
          PreparedStatement ps = null;
          
          Statement stmt = connection.createStatement();
          String query= MessageFormat.format(DBm.getDeleteReservaInfantilQuery(), "'",reserva.getId(),"'");
          ps = connection.prepareStatement(query);
          ps.setInt(1, reserva.getId());
          
          
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
           ps.setString(8, "familiar");
           ps.setInt(9, reserva.getnChildren());
           ps.setInt(10, reserva.getnAdults());
           ps.setInt(11, reserva.getBonoId());
           
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
            String query = MessageFormat.format(DBm.getRegistrarReservaBonoAdultosQuery(),
                    "'",reserva.getId(),"'",
                    "'",reserva.getUserId(),"'",
                    "'",reserva.getDate(),"'",
                    "'",reserva.getDuration(),"'",
                    "'",reserva.getPistId(),"'",
                    "'",reserva.getPrice(),"'",
                    "'",reserva.getDiscount(),"'",
                    "'",reserva.getnParticipants(),"'",
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
            ps.setString(8, "adultos");
            ps.setInt(9, reserva.getnParticipants());
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
      * Devuelve todas los bonos de la base de datos
      * @param none
      * @return ArrayList<BonoDTO> Vector con los bonos de la base de datos
      */

     public ArrayList<BonoDTO> getBonos(){
         ArrayList<BonoDTO> bonos = new ArrayList<BonoDTO>();

         try{

             DBmanager DBm = DBmanager.getInstance();
             Connection connection = DBm.getConnection();
           
             String query = DBm.getBonoQuery();
           
             Statement stmt = connection.createStatement();
             ResultSet rs = (ResultSet) stmt.executeQuery(query);
             

             while (rs.next()) {
                 int id = rs.getInt("bonoId");
                 String userId = rs.getString("userId");
                 String date = rs.getString("caducity");
                 int session = rs.getInt("session");
                 String typeRes = rs.getString("typeRes");
                 BonoDTO.type typ;
                 if(typeRes.equals("infantil")) {
                	 typ = BonoDTO.type.infantil;
                 }
                 else if(typeRes.equals("familiar")) {
                	 typ = BonoDTO.type.familiar;
                 }
                 else {
                	 typ = BonoDTO.type.adultos;
                 }
                 
                 bonos.add(new BonoDTO(id, userId, date, session, typ));
             }

             if (stmt != null){ 
                 stmt.close(); 
             }
             DBm.closeConnection();

         }catch(Exception e){
             System.err.println(e);
             e.printStackTrace();
         }

         return bonos;
     }
     
     /**
      * Añade una reserva bono a la base de datos
      * @param reserva
      * @return none
      */

      public void registrarBono(BonoDTO bono) {
          try {

              DBmanager DBm = DBmanager.getInstance();
              Connection connection = DBm.getConnection();
              PreparedStatement ps = null;

              Statement stmt = connection.createStatement();
              String query = MessageFormat.format(DBm.getregistrarBonoQuery(),
                      "'",bono.getId(),"'",
                      "'",bono.getTypeRes(),"'",
                      "'",bono.getUserID(),"'",
                      "'",bono.getSession(),"'",
                      "'",bono.getCaducity(),"'"
                      );
              ps = connection.prepareStatement(query);
              ps.setInt(1, bono.getId());
              if(bono.getTypeRes().equals(BonoDTO.type.adultos)) {
            	  ps.setString(2, "adultos");
              }
              else if(bono.getTypeRes().equals(BonoDTO.type.familiar)) {
            	  ps.setString(2, "familiar");
              }
              else {
            	  ps.setString(2, "infantil");
              }
              ps.setString(3, bono.getUserID());
              ps.setInt(4, bono.getSession());
              ps.setString(5, bono.getCaducity());
              
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

       public void modificarBono(BonoDTO bono, int id) {
           try {

               DBmanager DBm = DBmanager.getInstance();
               Connection connection = DBm.getConnection();
               PreparedStatement ps = null;

               Statement stmt = connection.createStatement();
               String query = MessageFormat.format(DBm.getmodificarBonoQuery(),
                       "'",bono.getSession(),"'",
                       "'",bono.getCaducity(),"'",
                       "'",bono.getId(),"'"
                       );
               ps = connection.prepareStatement(query);
               ps.setInt(1, bono.getSession());
               ps.setString(2, bono.getCaducity());
               ps.setInt(3, bono.getId());
               
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