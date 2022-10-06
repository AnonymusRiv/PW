package es.uco.pw.classes;

import java.util.ArrayList;
import Pista.Pista;

public class GestorPistas{
    private static GestorPistas instance=null;
    private ArrayList<Pista> pistas=new ArrayList<Pista>();
    private int id;
    private ArrayList<Kart> karts=new ArrayList<Kart>();

    private GestorPistas(){
        id=0;
    }

    public static GestorPistas getInstance(){
        if(instance==null){
            instance=new GestorPistas();
        }
        return instance;
    }

    public ArrayList<Pista> getPistas(){
        return pista;
    }

    public void setPistas(ArrayList<Pista> pista){
        this.pista=pista;
    }

    public boolean addPista(Pista pista){
        pista.add(pista);
        return true;
    }

    public boolean registrarPista(Pista pista){ //Queda comprobar que no exista previamente
        pista.add(pista);
        id+=1;
        return true;
    }

    public Pista buscarPista(int id){
        for(int i=0; i<pistas.size(); i++){
            if(pistas.get(i).getId()==id){
                Pista pista=pistas.get(i);
                return null;
            }
            else
            {
            	asociarPista(Pista pista, Karts karts);
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

    public void listarPistas(ArrayList<Pista> pista){
    	for(int i = 0; i< pista.size(); i++)
    	{
    		System.out.println(pista[i]);
    	}
    }

    public int pistasLibres(Pista pista){
    	int libres=0;
    	if(pista != registradas || pista != mantenimiento){
    		libres++;
    	}
    	return libres;
    }
}