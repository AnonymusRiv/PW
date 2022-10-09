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
	
	public static GestorUsuarios getInstance() {
		if(instance==null) {
			instance=new GestorUsuarios();
		}
		return instance;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public boolean addUsuario(Usuario user){
        usuarios.add(user);
        return true;
    }
	
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
	
	public void listarUsuarios(ArrayList<Usuario> usuarios) {
		for(int i=0;i<usuarios.size();i++) {
			System.out.println(usuarios.get(i).toString());
		}
	}
	
	public Usuario getUsuarioActivo(){
		return usuarioActivo;
	}
	
	public void setUsuarioActivo(Usuario usuario) {
	    this.usuarioActivo = usuario;
	}
}
