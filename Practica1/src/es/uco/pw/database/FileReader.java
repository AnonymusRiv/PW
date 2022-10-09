package es.uco.pw.database;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import es.uco.pw.classes.*;
import es.uco.pw.classes.Pista.dificulty;
import es.uco.pw.factory.Reserva;
import es.uco.pw.manage.*;

/**
 * Implementación de la interfaz repository para trabajar con ficheros
 * @author Moisés Moyano Cejudo
 * @author Alba Palomino Jiménez
 * @author Carlos Rivero Talavera
 * @authos Silvia Roldán Flores
 * @version 1.0
 */

public abstract class FileReader implements IRepository{
	
	
	/**
	 * Función encargada de cargar el sistema
	 * @param none
	 * @return none
	 * @throws IOException
	 * @throws ParseException
	 */
	
	@Override
	  public boolean loadSystem() throws IOException, ParseException {
	    File usuarios= new File("usuarios.txt");
	    File pistas = new File("pistas.txt");
	    File reservas = new File("reservastxt");

	    if (!usuarios.exists()) {
	      FileWriter newUsuarios = new FileWriter("usuarios.txt");
	      newUsuarios.close();
	    }

	    Scanner userReader = new Scanner(usuarios);

	    GestorUsuarios userManager = GestorUsuarios.getInstance();

	    if (userReader.hasNextLine()) {
	      String data = userReader.nextLine();

	      while (userReader.hasNextLine()) {
	        data = userReader.nextLine();
	        String[] parts = data.split(",");

	        Usuario user = new Usuario();
	        user.setEmail(parts[0]);
	        user.setName(parts[1]);
	        user.setDateOfBirth(parts[2]);
	        userManager.addUsuario(user);
	      }
	    }
	    userReader.close();
	    
	    if(!pistas.exists()) {
	    	FileWriter newPistas=new FileWriter("pistas.txt");
	    	newPistas.close();
	    }
	    
	    Scanner pistasReader=new Scanner(pistas);
	    
	    GestorPistas pistasManager=GestorPistas.getInstance();
	    
	    if(pistasReader.hasNextLine()) {
	    	String data = pistasReader.nextLine();
	    	
	    	while(pistasReader.hasNextLine()) {
	    		data=pistasReader.nextLine();
	    		String[] parts=data.split(",");
	    		
	    		Pista pista=new Pista();
	    		pista.setName(parts[0]);
	    		pista.setStatus(Boolean.parseBoolean(parts[1]));
	    		//pista.setDificulty(dificulty.parseDificulty(parts[2]));
	    		pistasManager.addPista(pista);
	    	}
	    }
	    pistasReader.close();
	    
	    if(!reservas.exists()) {
	    	FileWriter newReservas=new FileWriter("reservas.txt");
	    	newReservas.close();
	    }
	    
	    Scanner reservasReader=new Scanner(reservas);
	    
	    //GestorReservas reservasManager=GestorReservas.getInstance();
	    
	    if(reservasReader.hasNextLine()) {
	    	String data = reservasReader.nextLine();
	    	
	    	while(reservasReader.hasNextLine()) {
	    		data = reservasReader.nextLine();
	    		String[] parts=data.split(",");
	    		
	    		Reserva reserva=new Reserva();
	    		reserva.setUserId(parts[0]);
	    		//reserva.setDate(parts[1]);
	    		reserva.setDuration(Integer.parseInt(parts[2]));
	    		reserva.setPistId(parts[3]);
	    		reserva.setPrice(Float.parseFloat(parts[4]));
	    		reserva.setDiscount(Float.parseFloat(parts[5]));
	    		//reserva.setTypeRes(parts[6]);
	    		//GestorReservas.addReserva(reserva);
	    	}
	    }
	    reservasReader.close();
	    
	    return true;
	}
	
	/**
	 * Función encargada de guardar el estado del sistema en almacenamiento
	 * @param none
	 * @return none
	 * @throws IOException
	 */
	
	public boolean saveSystem() throws IOException{
		FileWriter usuarios= new FileWriter("usuarios.txt");
	    FileWriter pistas = new FileWriter("pistas.txt");
	    FileWriter reservas = new FileWriter("reservastxt");
	    
	    GestorUsuarios userManager=GestorUsuarios.getInstance();
	    ArrayList<Usuario> userList=userManager.getUsuarios();
	    for(int i=0;i<userList.size();i++) {
	    	usuarios.write(userList.get(i).getEmail()+","+userList.get(i).getName()+","+userList.get(i).getDateOfBirth()+"\n");
	    }
	    usuarios.close();
	    
	    GestorPistas pistManager=GestorPistas.getInstance();
	    ArrayList<Pista> pistList=pistManager.getPistas();
	    for(int i=0;i<pistList.size();i++) {
	    	pistas.write(pistList.get(i).getName()+","+pistList.get(i).isStatus()+","+pistList.get(i).getDificulty()+","+pistList.get(i).getMax()+","+pistList.get(i).getKarts());
	    }
	    pistas.close();
	    
	    //TODO: Gestor de reservas
	    //GestorReservas resManager=GestorReservas.getInstance();
	    //ArrayList<Reserva> resList=resManager.getReservas();
	    return true;
	}
}

