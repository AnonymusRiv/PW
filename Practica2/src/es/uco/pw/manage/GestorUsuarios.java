package es.uco.pw.manage;

import java.util.ArrayList;

import es.uco.pw.classes.*;

/**
 * Clase GestorUsuarios
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @author Silvia Roldan Flores
 * @version 1.0
 */

public class GestorUsuarios {
	private static GestorUsuarios instance=null;
	private ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
	private Usuario usuarioActivo;
	
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
	
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	/**
	 * Método público para asignar los usuarios
	 * @param usuarios
	 * @return none
	 */
	
	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	/**
	 * Método público para añadir un usuario
	 * @param user
	 * @return none
	 */
	
	public boolean addUsuario(ArrayList<Usuario> usuarios, Usuario user){
        for(int i=0; i<usuarios.size(); i++){
			if(usuarios.get(i).getName() == user.getName()){
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
	
	public void modificarUsuario(Usuario user) {
		for(int i=0;i<usuarios.size();i++) {
			if(usuarios.get(i).getEmail()==user.getEmail()) {
				usuarios.get(i).setName(user.getName());
				usuarios.get(i).setDateOfBirth(user.getDateOfBirth());
				usuarios.get(i).setInscription(user.getInscription());
				usuarios.get(i).setEmail(user.getEmail());
			}
		}
	}
	
	/**
	 * Método público para listar los usuarios
	 * @param usuarios
	 * @return none
	 */
	
	public void listarUsuarios(ArrayList<Usuario> usuarios) {
		for(int i=0;i<usuarios.size();i++) {
			System.out.println(usuarios.get(i).toString());
		}
	}
	
	/**
	 * Método público para obtener un usuario activo
	 * @param none
	 * @return usuarioActivo
	 */
	
	public Usuario getUsuarioActivo(){
		return usuarioActivo;
	}
	
	/**
	 * Método público para asignar un usuarioActivo
	 * @param usuario
	 * @return none
	 */
	
	public void setUsuarioActivo(Usuario usuario) {
	    this.usuarioActivo = usuario;
	}
}
