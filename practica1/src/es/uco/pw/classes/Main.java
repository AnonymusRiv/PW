package es.uco.pw.classes;

import utilities.SystemFunctions;
import java.util.Scanner;
import java.util.ArrayList;

public final class Main {

	private static Scanner scanner;

/**
 * Imprime el menú de inicio
 * @param none
 * @return int Elección de usuario
 */


	public static int printLogin(){
    SystemFunctions.clearConsole();
    scanner = new Scanner(System.in);
    System.out.println("Bienvenido, al Gestor de Usuarios.");
    System.out.println("Seleccione 1 para Registrase.");
    System.out.println("Seleccione 2 para Iniciar sesión.");
    System.out.println("Seleccione 0 para salir.");
    System.out.println("Después de seleccionar una opción pulse enter.");
    return scanner.nextInt();
}

public static boolean registerUser(){
    SystemFunctions.clearConsole();
    Usuario usuario;
    scanner = new Scanner(System.in);


    System.out.println("Introduzca sus datos:");
    System.out.println("  Nombre:");
    usuario.setname(scanner.nextLine());
    System.out.println("  Fecha de nacimiento:");
    usuario.setbirthday(scanner.nextLine());
    System.out.println("  Email:");
    usuario.setmail(scanner.nextLine());
    System.out.println("Después de seleccionar una opción pulse enter.");
    return scanner.nextInt();
}



public static Boolean loginUser() {
    SystemFunctions.clearConsole();
    Usuario usuario = usuario.getInstance();
    ArrayList<Usuario> usuarios = usuario.getUsers();
    scanner = new Scanner(System.in);

    System.out.print(" - Email: ");
    String mail = scanner.nextLine();

    System.out.print(" - Contraseña: ");
    String password = scanner.nextLine();

    for (int i = 0; i < usuarios.size(); i++) {
      if (
        (usuarios.get(i).getmail().equals(mail)) &&
        (usuarios.get(i).getPassword().equals(password))
      ) {
        usuario.setActiveUser(usuarios.get(i));
        return true;
      }
    }
    return false;
  }



  public static Boolean modifyUsers() {
    SystemFunctions.clearConsole();
    Usuario usuario = usuario.getInstance();
    SystemFunctions.listUsers();
    scanner = new Scanner(System.in);


    System.out.print(" - Introduzca el email del usuario: ");

    int mail = scanner.nextInt();
    scanner.nextLine();
    Usuario usuarios = usuario.findUser(mail);
    if(usuarios != null){
        System.out.println("Introduzca los siguientes datos: ");
        System.out.print(" - Nombre: ");
        usuarios.setname(scanner.nextLine());
        System.out.print(" - Fecha de nacimiento: ");
        usuarios.setbirthday(scanner.nextLine());
        System.out.print(" - Email: ");
        usuarios.setmail(scanner.nextLine());
        usuarios.setCategory(SystemFunctions.choiceCategory());

        return usuario.modifyUsers(usuarios);
    }
    return false;
  }


  private static void listUsers() {
    SystemFunctions.clearConsole();
    Usuario usuario = usuario.getInstance();

    ArrayList<Usuario> usuarios = usuario.getUsers();
    System.out.println("Fecha de nacimiento | Email ");
    System.out.println("------------------");
    for (int i = 0; i < usuarios.size(); i++) {
      System.out.println(
        "   " + usuarios.get(i).getbirthday() + "  | " + usuarios.get(i).getmail()
      );
    }
  }





  public static boolean addPista(){
    SystemFunctions.clearConsole();
    Pista pista
    scanner = new Scanner(System.in);


    System.out.println("Introduzca los datos:");
    System.out.println("  Nombre:");
    pista.setname(scanner.nextLine());
    System.out.println("  Estado:");
    pista.setstatus(scanner.nextLine());
    System.out.println("  Dificultad:");
    pista.setdifficulty(scanner.nextLine());
    System.out.println("  Número máximo de karts:");
    pista.setnumber(scanner.nextLine());
    System.out.println("Después de seleccionar una opción pulse enter.");
    return scanner.nextInt();
}


public static bool addKart(){
    SystemFunctions.clearConsole();
    Kart kart
    scanner = new Scanner(System.in);


    System.out.println("Introduzca los datos:");
    System.out.println("  Identificador:");
    kart.setid(scanner.nextLine());
    System.out.println("  Tipo:");
    kart.settype(scanner.nextLine());
    System.out.println("  Estado:");
    kart.setstatus(scanner.nextLine());
    System.out.println("Después de seleccionar una opción pulse enter.");
    return scanner.nextInt();
}


private static void listPista() {
    SystemFunctions.clearConsole();
    Pista pista = pista.getInstance();

    ArrayList<Pista> pistas = pista.getname();
    System.out.println("Nombre | Estado | Dificulatd | Número máximo de karts ");
    System.out.println("------------------");
    for (int i = 0; i < pistas.size(); i++) {
      System.out.println(
        "   " + pistas.get(i).getname() + "  | " + pistas.get(i).getstatus()  + " | " + pistas.get(i).getdifficulty()  + " | " + pistas.get(i).getnumber()
      );
    }
  }



  public static int printE1SpectatorMenuScreen() {
    SystemFunctions.clearConsole();
    scanner = new Scanner(System.in);
    UserManager userManager = UserManager.getInstance();
    System.out.println("Bienvenido " + userManager.getActiveUser().getName());
    System.out.println("¿Qué desea hacer?");
    System.out.println(" - Pulse 1 para crear una crítica");
    System.out.println(
      " - Pulse 2 para consultar todas las críticas disponibles"
    );
    System.out.println(" - Pulse 3 para borrar una crítica");
    System.out.println(" - Pulse 4 para valorar una crítica");
    System.out.println(" - Pulse 5 para buscar las críticas de un usuario");
    System.out.println(" - Pulse 0 para salir");
    System.out.print("Escoja una opción y pulse enter: ");
    return scanner.nextInt();
  }










  private static Boolean createReserve() throws ParseException {
    SystemFunctions.clearConsole();
    Reserva reserva = (SpectacleFactory).getReserve("Reserva");
    scanner = new Scanner(System.in);

    SpectacleManager spectacleManager = SpectacleManager.getInstance();
    SesionManager sesionManager = SesionManager.getInstance();

    spectacle.setSpectacleId(spectacleManager.getSpectacleId());
    System.out.println("Introduzca los siguientes datos: ");
    System.out.print(" - Hora de la reserva: ");
    reserva.setReserve(scanner.nextLine());
    System.out.print(" - Duración: ");
    reserva.setDuration(scanner.nextLine());
    System.out.print(" - Id de la pista: ");
    reserva.setPistaid(scanner.nextLine());
    System.out.print(" - Precio: ");
    reserva.setPrice(scanner.nextLine());
    System.out.print(" - Descuento: ");
    reserva.setDiscount(scanner.nextLine());

  }


  /**
   * Este no se necesita
   */
  public static void searchUser() {
    SystemFunctions.clearConsole();
    SystemFunctions.listUsers();
    System.out.print(
      "Introduzca el identificador del usuario del cual desea ver la información: "
    );
    int userId = scanner.nextInt();
    User user = user.findUser(userId);

    System.out.println("------------------");
    System.out.println(" - Nombre: " + user.getname());
    System.out.println(" - Fecha de nacimiento: " + user.getbirthday());
    System.out.println(" - Email: " + user.getmail());
    System.out.println("------------------");
  }







}
