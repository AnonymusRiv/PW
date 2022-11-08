package es.uco.pw.business.DTO;

import java.util.ArrayList;

/**
 * DTO para el concepto pista
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class PistaDTO {
    private String name;
    private boolean status;
    private dificulty dif;
    public enum dificulty{
        infantil, familiar, adultos
    };
    private int max;
    private ArrayList<KartDTO> karts = new ArrayList<KartDTO>();
    
    /**
     * Constructor sin parámetros
     * @param none
     */
    
    public PistaDTO() {
        
    }
    
    /**
     * Constructor con parámetros
     * @param name
     * @param status
     * @param difficult
     * @param max
     * @param karts
     */
    
    public PistaDTO(String name, boolean status, dificulty dif, int max, ArrayList<KartDTO> karts) {
        super();
        this.name = name;
        this.status = status;
        this.dif = dif;
        this.max = max;
        this.karts = karts;
    }
    
    /**
     * Método público para obtener el nombre 
     * @param none
     * @return name
     */

    public String getName() {
        return name;
    }
    
    /**
     * Método público para establecer el nombre 
     * @param name
     * @return none
     */

    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Método público para obtener el estado 
     * @param none
     * @return status
     */

    public boolean isStatus() {
        return status;
    }
    
    /**
     * Método público para establecer el estado 
     * @param status
     * @return none
     */

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    /**
     * Método público para obtener la dificultad 
     * @param none
     * @return dif
     */

    public dificulty getDif() {
        return dif;
    }
    
    /**
     * Método público para establecer la dificultad 
     * @param difficulty
     * @return none
     */
    
    public void setDificulty(String dificulty) {
        if(dificulty == "infantil") {
            dif = es.uco.pw.business.DTO.PistaDTO.dificulty.infantil;
        }
        if(dificulty == "familiar") {
            dif = es.uco.pw.business.DTO.PistaDTO.dificulty.familiar;
        }
        if(dificulty == "adultos") {
            dif = es.uco.pw.business.DTO.PistaDTO.dificulty.adultos;
        }
    }
    
    /**
     * Método público para obtener el número de karts máximo 
     * @param none
     * @return max
     */
    
    public int getMax() {
        return max;
    }
    
    /**
     * Método público para establecer el número máximo de karts 
     * @param max
     * @return none
     */

    public void setMax(int max) {
        this.max = max;
    }
    
    /**
     * Método público para obtener la lista de karts asociados 
     * @param none
     * @return karts
     */

    public ArrayList<KartDTO> getKarts() {
        return karts;
    }
    
    /**
     * Método público para establecer los karts asociados 
     * @param karts
     * @return none
     */

    public void setKarts(ArrayList<KartDTO> karts) {
        this.karts = karts;
    }
    
    /**
     * Método público para imprimir la información
     * @param none
     * @return Pista info de la pista
     */

    @Override
    public String toString() {
        return "PistaDTO [name=" + name + ", status=" + status + ", dif=" + dif + ", max=" + max + ", karts=" + karts
                + "]";
    }
    
}