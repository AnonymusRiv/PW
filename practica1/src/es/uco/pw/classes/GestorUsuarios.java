package es.uco.pw.classes;

import java.util.ArrayList;

public class GestorUsuarios{
    private static GestorUsuarios instance=null;
    private ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
    private int id;

    private GestorUsuarios(){
        id=0;
    }

    public static GestorUsuarios getInstance(){
        if(instance==null){
            instance=new GestorUsuarios();
        }
        return instance;
    }

    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios){
        this.usuarios=usuarios;
    }

    public boolean addUsuario(Usuario usuario, ArrayList<Usuario> usuarios){
    	for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getid()==usuario.getid()){
                return false;
            }
        }
        usuarios.add(usuario);
        return true;
    }

    public void modificarUsuario(Usuario usuario){
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getid()==usuario.getid()){
                usuarios.get(i).setname(usuario.getname());
                usuarios.get(i).setbirthday(usuario.getbirthday());
                usuarios.get(i).setreserve(usuario.getreserve());
                usuarios.get(i).setmail(usuario.getmail());
            }
        }
    }

    public void listarusuarios (ArrayList<Usuario> usuarios) {
    	for(int i=0; i<usuarios.size(); i++) {
    		System.out.println(usuarios.get(i).toString());
    	}
    }
    
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }
}