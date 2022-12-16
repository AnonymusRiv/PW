package es.uco.pw.data.DAO;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;

import es.uco.pw.business.DTO.KartDTO;
import es.uco.pw.business.DTO.KartDTO.status;
import es.uco.pw.business.DTO.PistaDTO;
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
        
        public void registrarPista(String name, boolean status, dificulty dif, int max) {
            try{
                DBmanager DBm = DBmanager.getInstance();
                Connection connection = DBm.getConnection();
                PreparedStatement ps = null;
            
                Statement stmt = connection.createStatement();
                String query= MessageFormat.format(DBm.getRegistrarPistaQuery(), "'",name,"'","'",status,"'","'",dif,"'","'",max,"'");

                String aux = null;
                if(dif == dificulty.infantil) {
                    aux = "infantil";
                }
                if(dif == dificulty.familiar) {
                    aux = "familiar";
                }
                if(dif == dificulty.adultos) {
                    aux = "adultos";
                }
                ps = connection.prepareStatement(query);
                ps.setString(1, name);
                ps.setBoolean(2, status);
                ps.setString(3, aux);
                ps.setInt(4, max);
                
                ps.executeUpdate();
                if (stmt != null) {
                    stmt.close();
                }            }catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
          }
        }
        
        /**
         * Borra una pista del sistema
         * @param email
         * @return none
         */
        
        public void deletePista(String pistaId) {
            try {
                DBmanager DBm = DBmanager.getInstance();
                Connection connection = DBm.getConnection();
                PreparedStatement ps = null;
                
                Statement stmt = connection.createStatement();
                String query= MessageFormat.format(DBm.getDeletePistaQuery(), "'",pistaId,"'");
                ps = connection.prepareStatement(query);
                ps.setString(1, pistaId);
                
                
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
         * Modifica una pista del sistema
         * @param email
         * @return none
         */
        
        public void modificarPista(PistaDTO pista, String pistaId) {
            try {
                DBmanager DBm = DBmanager.getInstance();
                Connection connection = DBm.getConnection();
                PreparedStatement ps = null;
            
                Statement stmt = connection.createStatement();
                String query= MessageFormat.format(DBm.getModificarPistaQuery(),"'",pista.getName(),"'","'",pista.isStatus(),"'","'",pista.getDif(),"'","'",pista.getMax(),"'");
                String aux = null;
                if(pista.getDif() == dificulty.infantil) {
                    aux = "infantil";
                }
                if(pista.getDif() == dificulty.familiar) {
                    aux = "familiar";
                }
                if(pista.getDif() == dificulty.adultos) {
                    aux = "adultos";
                }
                ps = connection.prepareStatement(query);
                ps.setBoolean(1, pista.isStatus()); 
                ps.setString(2, aux);
                ps.setInt(3, pista.getMax());
                ps.setString(4, pistaId);
                
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
        
        /**
         * Modifica un kart del sistema
         * @param email
         * @return none
         */
        
        public void modificarKart(KartDTO kart, int id) {
            try {
                DBmanager DBm = DBmanager.getInstance();
                Connection connection = DBm.getConnection();
                PreparedStatement ps = null;
            
                Statement stmt = connection.createStatement();
                String query= MessageFormat.format(DBm.getModificarKartQuery(),"'",kart.isType(),"'","'",kart.getStat(),"'","'",kart.getpistaId(),"'","'",kart.getId(),"'");
                String aux = null;
                if(kart.getStat() == KartDTO.status.disponible) {
                    aux = "disponible";
                }
                if(kart.getStat() == KartDTO.status.reservado) {
                    aux = "reservado";
                }
                if(kart.getStat() == KartDTO.status.mantenimiento) {
                    aux = "mantenimiento";
                }
                ps = connection.prepareStatement(query);
                ps.setBoolean(1, kart.isType());
                ps.setString(2, aux);
                ps.setString(3, kart.getpistaId());
                ps.setInt(4, id);
                
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
         * Asocia un kart a una pista
         * @param email
         * @return none
         */
        
        public void asociarKaP(KartDTO kart, int id) {
            try {
                DBmanager DBm = DBmanager.getInstance();
                Connection connection = DBm.getConnection();
                PreparedStatement ps = null;
            
                Statement stmt = connection.createStatement();
                String query= MessageFormat.format(DBm.getasociarKaPQuery(),"'",kart.getStat(),"'","'",kart.getpistaId(),"'","'",kart.getId(),"'");
                String aux = null;
                if(kart.getStat() == KartDTO.status.disponible) {
                    aux = "disponible";
                }
                if(kart.getStat() == KartDTO.status.reservado) {
                    aux = "reservado";
                }
                if(kart.getStat() == KartDTO.status.mantenimiento) {
                    aux = "mantenimiento";
                }
                ps = connection.prepareStatement(query);
                ps.setString(1, aux);
                ps.setString(2, kart.getpistaId());
                ps.setInt(3, id);
                
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
         * Borra un kart del sistema
         * @param email
         * @return none
         */
        
        public void deleteKart(int id) {
            try {
                DBmanager DBm = DBmanager.getInstance();
                Connection connection = DBm.getConnection();
                PreparedStatement ps = null;
                
                Statement stmt = connection.createStatement();
                String query= MessageFormat.format(DBm.getdeleteKartQuery(), "'",id,"'");
                ps = connection.prepareStatement(query);
                ps.setInt(1, id);
                
                
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
