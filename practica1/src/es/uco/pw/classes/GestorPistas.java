package es.uco.pw.classes;

import java.util.ArrayList;

public class GestorPistas{
    private static GestorPistas instance=null;
    private ArrayList<Pista> pistas = new ArrayList<Pista>();
    private int id;
    private ArrayList<Kart> karts = new ArrayList<Kart>();

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
        return pistas;
    }

    public void setPistas(ArrayList<Pista> pistas){
        this.pistas=pistas;
    }

    public boolean addPista(Pista pista){
        pistas.add(pista);
        return true;
    }
    
    public boolean addKart(Kart kart) {
    	karts.add(kart);
    	return true;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public void asociarKartAPistaDisponibles(Kart kart, Pista pista) {
        if((pista.getdifficulty().equals(Pista.difficult.infantil) == true) && (kart.gettype() == false) && (pista.getstatus() == true) && ((pista.getkarts().size()+1) < pista.getnumber())) {
            karts.add(kart);
        }
        if((pista.getdifficulty().equals(Pista.difficult.familiar) == true) && (pista.getstatus() == true) && ((pista.getkarts().size()+1) < pista.getnumber())) {
            karts.add(kart);
        }
        if((pista.getdifficulty().equals(Pista.difficult.adultos) == true) && (kart.gettype() == true) && (pista.getstatus() == true) && ((pista.getkarts().size()+1) < pista.getnumber())) {
            karts.add(kart);
        }
    }

    public void listarPistas(){
    	for(int i = 0; i< pistas.size(); i++)
    	{
    		System.out.println(pistas.get(i).toString());
    	}
    }

    public ArrayList <Pista> pistasLibres(Pista pista, int numKart){
        ArrayList<Pista> pistasLibres = new ArrayList<Pista>();
        for(int i = 0; i < pistas.size(); i++){
            if((pistas.get(i).getnumber() >= numKart) && (pistas.get(i).getstatus() == true)){
                pistasLibres.add(pistas.get(i));
            }
        }
    	return pistasLibres;
    }
}
