package es.uco.pw.business.managers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.data.DAO.UsuarioDAO;

/**
 * Clase GestorUsuarios
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldán Flores
 * @version 1.0
 */

public class GestorUsuarios {
	private static GestorUsuarios instance=null;
	private ArrayList<UsuarioDTO> usuarios=new ArrayList<UsuarioDTO>();
	private UsuarioDTO usuarioActivo;
	
	/**
	 * Método público para obtener una instancia
	 * @param none
	 * @return instance
	 */
	
	public static GestorUsuarios getInstance() {
		if(instance==null) {
			instance=new GestorUsuarios();
		}
		return instance;
	}

	/**
	 * Método público para obtener los usuarios
	 * @param none
	 * @return usuarios
	 */

	public ArrayList<UsuarioDTO> getUsuarios(){
	        UsuarioDAO usuarios = new UsuarioDAO();
	        return usuarios.getUsuarios();
	    }

	/**
	 * Método público para asignar los usuarios
	 * @param usuarios
	 * @return none
	 */
	
	public void setUsuarios(ArrayList<UsuarioDTO> usuarios) {
		this.usuarios = usuarios;
	}
	
	/**
	 * Método público para añadir un usuario
	 * @param user
	 * @return none
	 */
	
	public boolean addUsuario(ArrayList<UsuarioDTO> usuarios, UsuarioDTO user){
        for(int i=0; i<usuarios.size(); i++){
			if(usuarios.get(i).getEmail() == user.getEmail()){
				return false;
			}
		}
		usuarios.add(user);
        return true;
    }
	
	/**
	 * Método público para modificar un usuario
	 * @param user
	 * @return none
	 */
	
	public Boolean modificarUsuario(UsuarioDTO user, String mail) {
		UsuarioDAO usuario = new UsuarioDAO();
		usuario.modificarUsuario(user, mail);
		if(usuarioActivo.getEmail().equals(user.getEmail())) {
		    setUsuarioActivo(user);
		}
		return true;
	}
	
	/**
	 * Método público para listar los usuarios
	 * @param usuarios
	 * @return none
	 */
	
	public void listarUsuarios(ArrayList<UsuarioDTO> usuarios) {
		for(int i=0;i<usuarios.size();i++) {
			System.out.println(usuarios.get(i).toString());
		}
	}
	
	/**
	 * Método público para obtener un usuario activo
	 * @param none
	 * @return usuarioActivo
	 */
	
	public UsuarioDTO getUsuarioActivo(){
		return usuarioActivo;
	}
	
	/**
	 * Método público para asignar un usuarioActivo
	 * @param usuario
	 * @return none
	 */
	
	public void setUsuarioActivo(UsuarioDTO usuario) {
	    this.usuarioActivo = usuario;
	}
	
	/**
     * Método público para loguear un usuario
     * @param email
     * @return true o false
     */
	
    public Boolean loginUser(String email, String password) {
        ArrayList<UsuarioDTO> usuarios = getUsuarios();
        for(int i=0; i<usuarios.size(); i++) {
            if(usuarios.get(i).getEmail().equals(email) && (usuarios.get(i).getPassword().equals(password))) {
               setUsuarioActivo(usuarios.get(i));
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método público para registrar un usuario
     * @param user
     * @return true o false
     */
    
    public boolean registerUser(UsuarioDTO user) {
        GestorUsuarios gestor = new GestorUsuarios();
        ArrayList<UsuarioDTO> users = gestor.getUsuarios();
        for (int i = 0; i < users.size(); i++) {
          if (users.get(i).getEmail().equals(user.getEmail())) {
            return false;
          }
        }
        UsuarioDAO userDAO = new UsuarioDAO();
        new SimpleDateFormat("yyyy-MM-dd");
        //DateTimeFormatter registerDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        //registerDate.format(LocalDateTime.now());
        String registerDate = "2022-11-23";
        userDAO.registrarUsuario(
          user.getName(),
          user.getDateOfBirth(),
          registerDate,
          user.getEmail()
        );
        return true;
      }
    
    /**
     * Método público para eliminar un usuario
     * @param mail
     * @return true o false
     */
    
    public Boolean deleteUsuario(String mail) {
        if(usuarioActivo.getEmail().equals(mail)) {
            return false;
        }
        ArrayList<UsuarioDTO> usuarios = getUsuarios();
        for(int i=0; i<usuarios.size(); i++) {
            if(usuarios.get(i).getEmail().equals(mail)) {
                UsuarioDAO usuario = new UsuarioDAO();
                usuario.deleteUsuario(mail);
                return true;
            }
        }
        return false;
    }
}
