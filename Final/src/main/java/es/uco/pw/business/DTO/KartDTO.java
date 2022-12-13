package es.uco.pw.business.DTO;

/**
 * DTO para el concepto kart
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class KartDTO {
    private int id;       
    private boolean type;
    private status stat;
    public enum status{
        disponible, reservado, mantenimiento
    }
    private String pistaId;
    
    /**
     * Constructor sin parámetros
     * @param none
     */
    
    public KartDTO() {
        
    }
    
    /**
     * Constructor con parámetros
     * @param id
     * @param type
     * @param status
     * @param pistaId
     */

    public KartDTO(int id, boolean type, status stat, String pistaId) {
        super();
        this.id = id;
        this.type = type;
        this.stat = stat;
        this.pistaId = pistaId;
    }
    
    /**
     * Método público para obtener el id 
     * @param none
     * @return id
     */

    public int getId() {
        return id;
    }
    
    /**
     * Método público para establecer el id 
     * @param id
     * @return none
     */

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Método público para obtener el tipo 
     * @param none
     * @return type
     */

    public boolean isType() {
        return type;
    }
    
    /**
     * Método público para establecer el tipo 
     * @param type
     * @return none
     */

    public void setType(boolean type) {
        this.type = type;
    }
    
    /**
     * Método público para obtener el estado 
     * @param none
     * @return stat
     */

    public status getStat() {
        return stat;
    }
    
    /**
     * Método público para establecer el estado 
     * @param status
     * @return none
     */

    public void setStat(status stat) {
        this.stat = stat;
    }
    
    /**
     * Método público para obtener el pistaId 
     * @param none
     * @return id
     */

    public String getpistaId() {
        return pistaId;
    }
    
    /**
     * Método público para establecer el pistaId 
     * @param id
     * @return none
     */

    public void setpistaId(String pistaId) {
        this.pistaId = pistaId;
    }
    
    /**
     * Método público para imprimir la información
     * @param none
     * @return kart info del kart
     */

    @Override
    public String toString() {
        return "KartDTO [id=" + id + ", type=" + type + ", stat=" + stat + "]";
    };
    
}