package es.uco.pw.display;

    import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
    import java.util.Scanner;

import es.uco.pw.business.DTO.KartDTO;
import es.uco.pw.business.DTO.PistaDTO;
import es.uco.pw.business.DTO.UsuarioDTO;
import es.uco.pw.business.classes.*;
    import es.uco.pw.business.factory.*;
    import es.uco.pw.business.managers.*;

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
            System.out.println(" - Pulse 4 para listar sus reservas");
            System.out.println(" - Pulse 5 para ver sus datos");
            System.out.println(" - Pulse 6 para modificar sus datos");
            System.out.println(" - Pulse 7 para eliminar un usuario");
            System.out.println(" - Pulse 8 para crear una pista");
            System.out.println(" - Pulse 9 para modificar una pista");
            System.out.println(" - Pulse 10 para eliminar una pista");
            System.out.println(" - Pulse 11 para listar las pistas");
            System.out.println(" - Pulse 12 para crear un kart");
            System.out.println(" - Pulse 13 para modificar un kart");
            System.out.println(" - Pulse 14 para eliminar un kart");
            System.out.println(" - Pulse 15 para listar los karts");
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
            scanner = new Scanner(System.in);

            System.out.print(" - Email: ");
            String email = scanner.nextLine();
            
            return usuario.loginUser(email);
        }
        
        /**
         * Imprime el menú de registro de usuarios
         * @param none
         * @return boolean True si se ha podido registrar
         */
        
        public static Boolean registerUser() throws ParseException {
            Functions.clearConsole();
            UsuarioDTO usuario =new UsuarioDTO();
            scanner = new Scanner(System.in);
            GestorUsuarios user = GestorUsuarios.getInstance();

            System.out.println("Introduzca los siguientes datos: ");
            System.out.print(" - Nombre: ");
            usuario.setName(scanner.nextLine());
            System.out.print(" - Email: ");
            usuario.setEmail(scanner.nextLine());
            System.out.print(" - Fecha de nacimiento con el formato \"yyyy-MM-dd\" : ");
            String date = scanner.nextLine();
            usuario.setDateOfBirth(date);
            
            if(user.registerUser(usuario)) {
                System.out.println("Registro correcto");
                return true;
            }
            System.out.println("Error al registrarse");
            return false;
        }
        
        /**
         * Lista los usuarios del sistema
         * @param none
         * @return none
         */
        
        public static void listarUsuarios() {
            Functions.clearConsole();
            GestorUsuarios usuario = GestorUsuarios.getInstance();
            ArrayList<UsuarioDTO> users = usuario.getUsuarios();
            System.out.println("     Email    ");
            System.out.println("------------------");
            for (int i = 0; i < users.size(); i++) {
              System.out.println("   " + users.get(i).getEmail());
            }
        }
        
        /**
         * Imprime el menú de registro de reservas
         * @param none
         * @return TypeRes -1 se ha podido registrar
         */
        
        
        public static int registrarReserva() throws ParseException{
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
                return choice;
              }
              return -1;
        }
        
        /**
         * Crea una reserva infantil
         * @param none
         * @return boolean True si se ha podido registrar
         */

        public static Boolean createRInfantil() throws ParseException{
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            ReservaInfantil reserva = new ReservaInfantil();
            System.out.println("Introduzca los siguientes datos: ");
            System.out.print("- Email: ");
            reserva.setUserId(scanner.nextLine());
            System.out.print("- Fecha: ");
            reserva.setDate(scanner.nextLine());
            System.out.print("- Duración: ");
            reserva.setDuration(scanner.nextInt());
            System.out.print("- ID de la pista: ");
            reserva.setPistId(scanner.nextLine());
            return true;
        }
        
        /**
         * Crea una reserva familiar
         * @param none
         * @return boolean True si se ha podido registrar
         */
        
        public static Boolean createRFamiliar() throws ParseException{
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            ReservaFamiliar reserva = new ReservaFamiliar();
            System.out.println("Introduzca los siguientes datos: ");
            System.out.print("- Email: ");
            reserva.setUserId(scanner.nextLine());
            System.out.print("- Fecha: ");
            reserva.setDate(scanner.nextLine());
            System.out.print("- Duración: ");
            reserva.setDuration(scanner.nextInt());
            System.out.print("- ID de la pista: ");
            reserva.setPistId(scanner.nextLine());
            return true;
        }
        
        /**
         * Crea una reserva adultos
         * @param none
         * @return boolean True si se ha podido registrar
         */
        
        public static Boolean createRAdultos() throws ParseException{
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            ReservaAdultos reserva=new ReservaAdultos();
            System.out.println("Introduzca los siguientes datos: ");
            System.out.print("- Email: ");
            reserva.setUserId(scanner.nextLine());
            System.out.print("- Fecha: ");
            reserva.setDate(scanner.nextLine());
            System.out.print("- Duración: ");
            reserva.setDuration(scanner.nextInt());
            System.out.print("- ID de la pista: ");
            reserva.setPistId(scanner.nextLine());
            return true;
        }
        
        /**
         * Función que modifica un usuario
         * @param none
         * @return none
         */
        
        public static Boolean modificarUsuario() throws ParseException {
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            GestorUsuarios usuario = GestorUsuarios.getInstance();
        
            Functions.listarUsuarios();
        
            System.out.println(
              "Introduzca el correo del usuario que desea modificar: "
            );
            String mail = scanner.nextLine();
            
            UsuarioDTO user = usuario.findUser(mail);
            
            if (user != null) {
              System.out.println("Introduzca los siguientes datos: ");
              System.out.print(" - Nombre: ");
              user.setName(scanner.nextLine());
              //SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy-MM-dd");
              System.out.print(" - Fecha de nacimiento con el formato \"yyyy-MM-dd\" : ");
              String date = scanner.nextLine();
              user.setDateOfBirth(date);
              System.out.print(" - Email: ");
              user.setEmail(scanner.nextLine());
        
              return usuario.modificarUsuario(user, mail);
            }
        
            return false;
        }
        
        /**
         * Elimina un usuario del sistema
         * @param none
         * @return none
         */
        
        public static Boolean deleteUsuario(){
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            GestorUsuarios gestor = GestorUsuarios.getInstance();

            Functions.listarUsuarios();
            System.out.print("Introduzca el identificador del usuario que desea borrar: ");
            String iduser = scanner.next();

            return gestor.deleteUsuario(iduser);

        }
        
        /**
         * Lista las pistas del sistema
         * @param none
         * @return none
         */
        
        public static void listarPistas() {
            Functions.clearConsole();
            GestorPistas gestor = GestorPistas.getInstance();
            ArrayList<PistaDTO> pistas = gestor.getPistas();
            System.out.println("            Pistas            ");
            System.out.println("------------------------------");
            for (int i = 0; i < pistas.size(); i++) {
                System.out.println("\t"+pistas.get(i).getName());
            }            
        }        
        
        /**
         * Función que modifica una reserva del sistema
         * @param none
         * @return none
         */
        
        public static void modificarReserva() {
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
        
        /**
         * Función que elimina una reserva
         * @param none
         * @return none
         */
        
        public static Boolean deleteReserva(){
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            GestorReservas reserva = GestorReservas.getInstance();
            ArrayList <Reserva> reservas = reserva.getReservas();

            Functions.listarReservas();
            System.out.print("Introduzca el identificador del usuario cuya reserva desea borrar: ");
            String iduser = scanner.next();

            return reserva.deleteReserva(reservas, iduser);

        }
        
        /**
         * Función que lista las reservas
         * @param none
         * @return none
         */
        
        public static void listarReservas(){
            Functions.clearConsole();
            GestorReservas reserva = GestorReservas.getInstance();
            ArrayList<Reserva> reservas = reserva.getReservas();
            System.out.println("Reservas ");
            System.out.println("---------- ");
            for(int i=0; i<reservas.size(); i++){
                System.out.println(" " + reservas.get(i).getUserId());
            }
        }
        
        /**
         * Función que imprime el menu de pista
         * @param none
         * @return none
         */
        
        public static int printPistaMenuScreen() { 
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            System.out.println("Bienvenido ");
            System.out.println(" - Pulse 1 para Listar Pistas");
            System.out.println(" - Pulse 2 para Registrar Pista");
            System.out.println(" - Pulse 0 para Salir");
            System.out.print("Escoja una opción y pulse enter: ");
            return scanner.nextInt();
        }
        
        /**
         * Registra una pista
         * @param none
         * @return boolean True si se ha podido registrar
         */
        
        public static Boolean CreatePista() throws ParseException {
            Functions.clearConsole();
            PistaDTO pista =new PistaDTO();
            scanner = new Scanner(System.in);
            GestorPistas gestor = GestorPistas.getInstance();
            ArrayList<PistaDTO> pistas = gestor.getPistas();

            System.out.println("Introduzca los siguientes datos: ");
            System.out.print(" - Nombre: ");
            pista.setName(scanner.nextLine());
            System.out.print(" - Estado (disponible o ocupado): ");
            if(scanner.nextLine() == "disponible") {
                pista.setStatus(true);
            }
            if(scanner.nextLine() == "ocupado") {
                pista.setStatus(false);
            }
            System.out.print(" - Dificultad (infantil, familiar o adultos): ");
            pista.setDificulty(scanner.nextLine());
            System.out.print(" - Número máximo de karts: ");
            pista.setMax(scanner.nextInt());
            //System.out.print(" - Karts asociados a dicha pista: ");
            //listar karts
            
            if(gestor.addPista(pistas, pista)) {
                System.out.println("Registro correcto");
                return true;
            }
            System.out.println("Error al registrar la pista");
            return false;
        }
        
        
        /**
         * Registra un kart
         * @param none
         * @return boolean True si se ha podido registrar
         */
        
        public static Boolean CreateKart() throws ParseException {
            Functions.clearConsole();
            KartDTO kart =new KartDTO();
            scanner = new Scanner(System.in);
            GestorPistas gestor = GestorPistas.getInstance();
            ArrayList<KartDTO> karts = gestor.getKarts();

            System.out.println("Introduzca los siguientes datos: ");
            System.out.print(" - Tipo (infantil o adulto): ");
            if(scanner.nextLine().equals("infantil")) {
                kart.setType(true);
            }
            if(scanner.nextLine().equals("adulto")) {
                kart.setType(false);
            }
            System.out.print(" - Estado (disponible, reservado o mantenimiento): ");
            kart.setStat(scanner.nextLine());
            System.out.print(" - Pista (Seleccione una o deje vacio): ");
            listarPistas();
            kart.setpistaId(scanner.nextLine());
            
            if(gestor.addKart(karts, kart)) {
                System.out.println("Registro correcto");
                return true;
            }
            System.out.println("Error al registrar la pista");
            return false;
        }
        
        /**
         * Registra un kart
         * @param none
         * @return boolean True si se ha podido registrar
         */
        
        public static void listarUser() throws ParseException {
            Functions.clearConsole();
            GestorUsuarios usuario = GestorUsuarios.getInstance();
            System.out.println("Nombre:  " + usuario.getUsuarioActivo().getName());
            System.out.println("Email: " + usuario.getUsuarioActivo().getEmail());
            System.out.println("Cumpleaños: " + usuario.getUsuarioActivo().getDateOfBirth());
            System.out.println("Fecha de inscripción: " + usuario.getUsuarioActivo().getInscription());
        }
        
        /**
         * Lista los karts del sistema
         * @param none
         * @return none
         */
        
        public static void listarKarts() {
            Functions.clearConsole();
            GestorPistas gestor = GestorPistas.getInstance();
            ArrayList<KartDTO> karts = gestor.getKarts();
            System.out.println("             karts            ");
            System.out.println("  id  |  tipo  |    estado    |  pista");
            System.out.println("----------------------------------------");
            for (int i = 0; i < karts.size(); i++) {
              System.out.println("   " + karts.get(i).getId() + "  | " + karts.get(i).isType() + "    " + karts.get(i).getStat() + "   " + karts.get(i).getpistaId());
            }
        }
        
}
