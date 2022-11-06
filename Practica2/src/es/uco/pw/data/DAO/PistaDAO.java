package es.uco.pw.data.DAO;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;

import es.uco.pw.business.DTO.KartDTO;
import es.uco.pw.business.DTO.PistaDTO;
import es.uco.pw.business.DTO.PistaDTO.dificulty;
import es.uco.pw.business.managers.DBmanager;

/**
 * DAO para pistas que hace uso de la base de datos con una conexión via JDBC
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */


public class PistaDAO {
    
      /**
       * Devuelve todas las pistas de la base de datos
       * @param none
       * @return Lista de pistas
       */
    
       public ArrayList<PistaDTO> getPistas() {
            ArrayList<PistaDTO> pistas = new ArrayList<PistaDTO>();
            try {
                DBmanager DBm = DBmanager.getInstance();
                Connection connection = DBm.getConnection();
                
                String query = DBm.getPistaQuery();
                
                Statement stmt = connection.createStatement();
                ResultSet rs = (ResultSet) stmt.executeQuery(query);

                while (rs.next()) {
                    String name = rs.getString("name");
                    Boolean status = rs.getBoolean("status");
                    //dificulty dif = rs.getType("dificulty");
                    int max = rs.getInt("max");
                    @SuppressWarnings("unchecked")
                    ArrayList<KartDTO> karts = (ArrayList<KartDTO>) rs.getArray("karts");
                    
                    //pistas.add(new PistaDTO(name,status,dif,max, karts));
                }

                if (stmt != null){ 
                    stmt.close(); 
                }
                DBm.closeConnection();
            } catch (Exception e){
                System.err.println(e);
                e.printStackTrace();
            }
            return pistas;
        }
        
        /**
         * Registra una pista en el sistema
         * @param name
         * @param status
         * @param dif
         * @param max
         * @param karts
         * @return none
         */
        
        public void registrarPista(String name, String status, String dif, String max, String karts) {
            try{
                DBmanager DBm = DBmanager.getInstance();
                Connection connection = DBm.getConnection();
            
                String query= MessageFormat.format(DBm.getRegistrarPistaQuery(), "'",name,"'","'",status,"'","'",dif,"'","'",max,"'","'",karts,"'");
            
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
         * Borra una pista del sistema
         * @param name
         * @return none
         */
        
        public void deletePista(String name) {
            try {
                DBmanager DBm = DBmanager.getInstance();
                Connection connection = DBm.getConnection();
            
                Statement stmt = connection.createStatement();
                String query= MessageFormat.format(DBm.getDeletePistaQuery(), "'",name,"'");
                
                stmt.executeUpdate(query);
                query=MessageFormat.format(DBm.getDeleteReservasFromPistaQuery(), "'",name,"'");
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
         * Modifica una pista del sistema
         * @param name
         * @return none
         */
        
        public void modificarPista(PistaDTO pista) {
            try {
                DBmanager DBm = DBmanager.getInstance();
                Connection connection = DBm.getConnection();
            
                String query= MessageFormat.format(DBm.getModificarPistaQuery(),"'",pista.getName(),"'","'",pista.isStatus(),"'","'",pista.getDif(),"'","'",pista.getMax(),"'","'",pista.getKarts(),"'");
                
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
