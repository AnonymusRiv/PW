package es.uco.pw.data.DAO;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;

import es.uco.pw.business.DTO.KartDTO;
import es.uco.pw.business.DTO.KartDTO.status;
import es.uco.pw.business.DTO.PistaDTO;
import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.business.DTO.PistaDTO.dificulty;
import es.uco.pw.business.managers.DBmanager;

/**
 * DAO para pistas y karts que hace uso de la base de datos con una conexión via JDBC
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
                    String dif = rs.getString("difficulty");
                    dificulty difi = null;
                    if(dif.equals("infantil")) {
                        difi = PistaDTO.dificulty.infantil;
                    }
                    if(dif.equals("familiar")) {
                        difi = PistaDTO.dificulty.familiar;
                    }
                    if(dif.equals("adultos")) {
                        difi = PistaDTO.dificulty.adultos;
                    }
                    int max = rs.getInt("max");
                    
                    pistas.add(new PistaDTO(name,status,difi,max));
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
            
                String query= MessageFormat.format(DBm.getModificarPistaQuery(),"'",pista.getName(),"'","'",pista.isStatus(),"'","'",pista.getDif(),"'","'",pista.getMax(),"'");
                
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
         * Devuelve todos los karts de la base de datos
         * @param none
         * @return Lista de karts
         */
        
        public ArrayList<KartDTO> getKarts() {
            ArrayList<KartDTO> karts = new ArrayList<KartDTO>();
            try {
                DBmanager DBm = DBmanager.getInstance();
                Connection connection = DBm.getConnection();
                
                String query = DBm.getKartsQuery();
                
                Statement stmt = connection.createStatement();
                ResultSet rs = (ResultSet) stmt.executeQuery(query);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    Boolean type = rs.getBoolean("type");
                    String status = rs.getString("status");
                    status stat = null;
                    if(status.equals("disponible")) {
                        stat = KartDTO.status.disponible;
                    }
                    if(status.equals("reservado")) {
                        stat = KartDTO.status.reservado;
                    }
                    if(status.equals("mantenimiento")) {
                        stat = KartDTO.status.mantenimiento;
                    }
                    String pistaId = rs.getString("pistaId");
                    
                    karts.add(new KartDTO(id,type,stat,pistaId));
                }

                if (stmt != null){ 
                    stmt.close(); 
                }
                DBm.closeConnection();
            } catch (Exception e){
                System.err.println(e);
                e.printStackTrace();
            }
            return karts;
        }
        
        /**
         * Registra un kart en el sistema
         * @param name
         * @param dateOfBirth
         * @param registerDate
         * @param email
         * @return none
         */
        
        public void registrarKart(int id, Boolean type, status stat, String pistaId) {
            try{
                DBmanager DBm = DBmanager.getInstance();
                Connection connection = DBm.getConnection();
                PreparedStatement ps = null;
            
                Statement stmt = connection.createStatement();
                String query= MessageFormat.format(DBm.getRegistrarKartQuery(), "'", id,"'","'", type,"'","'", stat,"'","'",pistaId,"'");
                String aux = null;
                if(stat == status.disponible) {
                    aux = "disponible";
                }
                if(stat == status.reservado) {
                    aux = "reservado";
                }
                if(stat == status.mantenimiento) {
                    aux = "mantenimiento";
                }
                ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                ps.setBoolean(2, type);
                ps.setString(3, aux);
                ps.setString(4, pistaId);
                
                ps.executeUpdate();
                if (stmt != null) {
                    stmt.close();
                }
            
            }catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
          }
        }
        
    }
