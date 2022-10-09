package es.uco.pw.utilities;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import es.uco.pw.classes.Pista;
import es.uco.pw.classes.Usuario;
import es.uco.pw.factory.Reserva;
import es.uco.pw.manage.GestorPistas;
import es.uco.pw.manage.GestorUsuarios;

public final class Functions {
	private static Scanner scanner;
	
	/**
	 * Constructor que lanza una excepción ya que esta clase no se puede instanciar
	 * @param none
	 */
	
	public Functions() {
	    throw new UnsupportedOperationException();
	}
	
	/**
	 * Imprime el menú de incio
	 * @param none
	 * @return int Elección del usuario
	 */
	
	public static int printUserLoginScreen() {
	    Functions.clearConsole();
	    scanner = new Scanner(System.in);
	    System.out.println("Bienvenido al Gestor de Usuarios:");
	    System.out.println(" - Pulse 1 para Registrarse");
	    System.out.println(" - Pulse 2 para Iniciar Sesión");
	    System.out.println(" - Pulse 0 para Salir");
	    System.out.print("Escoja una opción y pulse enter: ");
	    return scanner.nextInt();
	}
	
	/**
	 * Imprime el menú de reservas
	 * @param none
	 * @return int Elección del usuario
	 */
	
	public static int printReservaMenuScreen() {
	    Functions.clearConsole();
	    scanner = new Scanner(System.in);
	    GestorUsuarios usuario = GestorUsuarios.getInstance();
	    System.out.println("Bienvenido " + usuario.getUsuarioActivo().getName());
	    System.out.println("¿Qué desea hacer?");
	    System.out.println(" - Pulse 1 para crear una reserva");
	    System.out.println(" - Pulse 2 para modificar una reserva");
	    System.out.println(" - Pulse 3 para borrar una reserva");
	    System.out.println(" - Pulse 4 para moificar sus datos");
	    System.out.println(" - Pulse 0 para Salir");
	    System.out.print("Escoja una opción y pulse enter: ");
	    return scanner.nextInt();
	}
	
	/**
	 * Imprime la salida del sistema
	 * @param none
	 * @return none
	 */
	
	public static void printExitScreen() {
	    System.out.println("Apagando el sistema, por favor espere...");
	}
	
	/**
	 * Imprime el menú de login
	 * @param none
	 * @return boolean True si se ha podido completar el login
	 */
	
	public static Boolean loginUser() {
	    Functions.clearConsole();
	    GestorUsuarios usuario = GestorUsuarios.getInstance();
	    ArrayList<Usuario> usuarios = usuario.getUsuarios();
	    scanner = new Scanner(System.in);

	    System.out.print(" - Email: ");
	    String email = scanner.nextLine();

	    for (int i = 0; i < usuarios.size(); i++) {
	      if (usuarios.get(i).getEmail().equals(email)){
	        usuario.setUsuarioActivo(usuarios.get(i));
	        return true;
	      }
	    }
	    return false;
	}
	
	/**
	 * Imprime el menú de registro de usuarios
	 * @param none
	 * @return boolean True si se ha podido registrar
	 */
	
	public static Boolean registerUser(String type) throws ParseException {
	    Functions.clearConsole();
	    Usuario usuario =new Usuario();
	    scanner = new Scanner(System.in);
	    GestorUsuarios user = GestorUsuarios.getInstance();

	    System.out.println("Introduzca los siguientes datos: ");
	    System.out.print(" - Nombre: ");
	    usuario.setName(scanner.nextLine());
	    System.out.print(" - Email: ");
	    usuario.setEmail(scanner.nextLine());
	    System.out.print(" - Fecha de nacimiento: ");
	    usuario.setDateOfBirth(scanner.nextLine());

	    user.addUsuario(usuario);
	    return true;
	}
	
	/**
	 * Lista los usuarios del sistema
	 * @param none
	 * @return none
	 */
	
	public void listarUsuarios() {
	    Functions.clearConsole();
	    GestorUsuarios usuario = GestorUsuarios.getInstance();
	    ArrayList<Usuario> users = usuario.getUsuarios();
	    System.out.println("Email ");
	    System.out.println("-------");
	    for (int i = 0; i < users.size(); i++) {
	      System.out.println("   " + users.get(i).getEmail());
	    }
	}
	
	/**
	 * Imprime el menú de registro de pistas
	 * @param none
	 * @return boolean True si se ha podido registrar
	 */
	
	public static Boolean registerPista(String type) throws ParseException {
	    Functions.clearConsole();
	    Pista pista=new Pista();
	    scanner = new Scanner(System.in);
	    GestorPistas pistas = GestorPistas.getInstance();

	    System.out.println("Introduzca los siguientes datos: ");
	    System.out.print(" - Nombre: ");
	    pista.setName(scanner.nextLine());
	    System.out.print(" - Estado: ");
	    pista.setStatus(scanner.nextBoolean());
	    System.out.print(" - Dificultad: ");
	    //pista.setDificulty(scanner.nextLine());

	    pistas.addPista(pista);
	    return true;
	}
	
	/**
	 * Lista las pistas del sistema
	 * @param none
	 * @return none
	 */
	
	public void listarPistas() {
		Functions.clearConsole();
		GestorPistas pista=GestorPistas.getInstance();
		ArrayList<Pista> pistas=pista.getPistas();
		System.out.println("Pistas  ");
		System.out.println("----------");
		for(int i=0;i<pistas.size();i++) {
			System.out.println("  "+pistas.get(i).getName());
		}
	}
	
	/**
	 * Imprime el menú de registro de reservas
	 * @param none
	 * @return boolean True si se ha podido registrar
	 */
	
	
	public static Boolean registrarReserva() throws ParseException{
		Functions.clearConsole();
		System.out.println("¿Qué tipo de espectáculo desea crear?");
	    System.out.println(" - Pulse 1 para crear una reserva infantil");
	    System.out.println(" - Pulse 2 para crear una reserva familiar");
	    System.out.println(" - Pulse 3 para crear una reserva adultos");
	    System.out.println(" - Pulse 0 para cancelar");
	    System.out.print("Escoja una opción y pulse enter: ");
	    int choice = scanner.nextInt();
	    while (choice < 0 || choice > 3) {
	      System.out.print(" - Error escoja una opción valida: ");
	      choice = scanner.nextInt();
	    }
	    
	    if (choice != 0) {
	        if (choice == 1) {
	          return Functions.createRInfantil();
	        }
	        if (choice == 2) {
	          return Functions.createRFamiliar();
	        }
	        if (choice == 3) {
	          return Functions.createRAdultos();
	        }
	      }
	      return false;
	}
	
	/**
	 * Crea una reserva infantil
	 * @param none
	 * @return boolean True si se ha podido registrar
	 */

	private static Boolean createRInfantil() throws ParseException{
		Functions.clearConsole();
		scanner = new Scanner(System.in);
		Reserva reserva=new Reserva();
		System.out.println("Introduzca los siguientes datos: ");
		System.out.print("- Email: ");
		reserva.setUserId(scanner.nextLine());
		System.out.print("- Fecha: ");
		//reserva.setDate(scanner.nextLine());
		System.out.print("- Duración: ");
		reserva.setDuration(scanner.nextInt());
		System.out.print("- ID de la pista: ");
		reserva.setPistId(scanner.nextLine());
		//reserva.setTypeRes(infantil);
		return true;
	}
	
	/**
	 * Crea una reserva familiar
	 * @param none
	 * @return boolean True si se ha podido registrar
	 */
	
	private static Boolean createRFamiliar() throws ParseException{
		Functions.clearConsole();
		scanner = new Scanner(System.in);
		Functions.clearConsole();
		scanner = new Scanner(System.in);
		Reserva reserva=new Reserva();
		System.out.println("Introduzca los siguientes datos: ");
		System.out.print("- Email: ");
		reserva.setUserId(scanner.nextLine());
		System.out.print("- Fecha: ");
		//reserva.setDate(scanner.nextLine());
		System.out.print("- Duración: ");
		reserva.setDuration(scanner.nextInt());
		System.out.print("- ID de la pista: ");
		reserva.setPistId(scanner.nextLine());
		//reserva.setTypeRes(familiar);
		return true;
	}
	
	/**
	 * Crea una reserva adultos
	 * @param none
	 * @return boolean True si se ha podido registrar
	 */
	
	private static Boolean createRAdultos() throws ParseException{
		Functions.clearConsole();
		scanner = new Scanner(System.in);
		Functions.clearConsole();
		scanner = new Scanner(System.in);
		Reserva reserva=new Reserva();
		System.out.println("Introduzca los siguientes datos: ");
		System.out.print("- Email: ");
		reserva.setUserId(scanner.nextLine());
		System.out.print("- Fecha: ");
		//reserva.setDate(scanner.nextLine());
		System.out.print("- Duración: ");
		reserva.setDuration(scanner.nextInt());
		System.out.print("- ID de la pista: ");
		reserva.setPistId(scanner.nextLine());
		//reserva.setTypeRes(adultos);
		return true;
	}
	
	/**
	 * Función que modifica una reserva del sistema
	 * @param none
	 * @return none
	 */
	
	public void modificarReserva() {
		Functions.clearConsole();
		scanner = new Scanner(System.in);
		//Necesita del gestor de reservas
	}
	
	/**
	 * Función que limpia la pantalla
	 * @param none
	 * @return none
	 */
		
	public static final void clearConsole() {
	    try {
	      final String os = System.getProperty("os.name");

	      if (os.contains("Windows")) {
	        Runtime.getRuntime().exec("cls");
	      } 
	      else {
	        Runtime.getRuntime().exec("clear");
	      }
	    } catch (final Exception e) {
	      //  Handle any exceptions.
	   }
	}
}