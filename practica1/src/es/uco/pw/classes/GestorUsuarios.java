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

    public boolean addUsuario(Usuario usuario){
        usuarios.add(usuario);
        return true;
    }

    public boolean registrarUsuario(Usuario usuario){ //Queda comprobar que no exista previamente
        usuarios.add(usuario);
        id+=1;
        return true;
    }

    public boolean modificarUsuario(usuario usuario){
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getId()==usuario.getId()){
                usuarios.get(i).setname(usuario.getname());
                usuario.get(i).setbirthday(usuario.getbirthday());
                usuario.get(i).setreserve(usuario.getreserve());
                usuario.get(i).setmail(usuario.getmail());
            }
        }
    }

    public Usuario buscarUsuario(int id){
        for(int i=0;i<usuarios.size();i++){
            if(usuarios.get(i).getId()==id){
                Usuario usuario=usuarios.get(i);
                return usuario;
            }
        }
        return null;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }
}