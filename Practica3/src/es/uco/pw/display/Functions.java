package es.uco.pw.display;

    import java.text.ParseException;
    import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

    import es.uco.pw.business.DTO.KartDTO;
    import es.uco.pw.business.DTO.PistaDTO;
import es.uco.pw.business.DTO.ReservaAdultosDTO;
import es.uco.pw.business.DTO.ReservaFamiliarDTO;
import es.uco.pw.business.DTO.ReservaInfantilDTO;
    import es.uco.pw.business.DTO.UsuarioDTO;
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
            usuario.setDateOfBirth(scanner.nextLine());
            
            if(user.registerUser(usuario)) {
                System.out.println("Registro correcto");
                return true;
            }
            System.out.println("Error al registrarse. El correo ya se ecuentra en el sistema");
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
        
        public static int PrintRegistrarReserva() throws ParseException{
            Functions.clearConsole();
            System.out.println("¿Qué tipo de reserva desea crear?");
            System.out.println(" - Pulse 1 para crear una reserva infantil");
            System.out.println(" - Pulse 2 para crear una reserva familiar");
            System.out.println(" - Pulse 3 para crear una reserva adultos");
            System.out.println(" - Pulse 0 para cancelar");
            System.out.print("Escoja una opción y pulse enter: ");
            return scanner.nextInt();
        }
        
        /**
         * Imprime el menú de tipo de reservas
         * @param none
         * @return TypeRes -1 se ha podido registrar
         */
        
        public static int PrintTipoReserva() throws ParseException{
            Functions.clearConsole();
            System.out.println("¿Qué tipo de reserva desea crear?");
            System.out.println(" - Pulse 1 para crear una reserva individual");
            System.out.println(" - Pulse 2 para crear un bono");
            System.out.println(" - Pulse 0 para cancelar");
            System.out.print("Escoja una opción y pulse enter: ");
            return scanner.nextInt();
        }
        
        /**
         * Crea una reserva infantil individual
         * @param none
         * @return boolean True si se ha podido registrar
         */

        public static Boolean createRIndividualInfantil() throws ParseException{
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            ReservaInfantilDTO reserva = new ReservaInfantilDTO();
            GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
            GestorPistas gestorPistas = GestorPistas.getInstance();
            GestorReservas gestorReservas = GestorReservas.getInstance();
            UsuarioDTO usuario = gestorUsuarios.getUsuarioActivo();
            
            String nacimiento = usuario.getDateOfBirth();
            String año = nacimiento.substring(0, 4);
            int añonacimiento = Integer.parseInt(año);
            if(añonacimiento < 18) {
                System.out.println("No puede realizar reservas ya que no es mayor de edad.");
                return false;
            }
            
            System.out.println("Introduzca los siguientes datos: ");
            reserva.setUserId(usuario.getEmail());
            System.out.print("- Fecha de la reserva con el formato \"yyyy-MM-dd\" : ");
            reserva.setDate(scanner.nextLine());
            System.out.print("- Duración (60, 90 o 120 minutos): ");
            reserva.setDuration(scanner.nextInt());
            if(reserva.getDuration() == 60) {
                reserva.setPrice(20);
            }
            if(reserva.getDuration() == 90) {
                reserva.setPrice(30);
            }
            if(reserva.getDuration() == 120) {
                reserva.setPrice(40);
            }
            Date antiguedad = usuario.getInscription();
            @SuppressWarnings("deprecation")
            int ant = antiguedad.getYear();
            if(ant > 2) {
                reserva.setDiscount(10);
            }
            else{
                reserva.setDiscount(0);
            }
            System.out.print("- Seleccione una pista: ");
            ArrayList<PistaDTO> pistas = gestorPistas.getPistas();
            System.out.println("      Pistas     ");
            System.out.println("------------------");
            for (int i = 0; i < pistas.size(); i++) {
                if(pistas.get(i).getDif().equals(PistaDTO.dificulty.infantil)) {
                    System.out.println("   " + pistas.get(i).getName());   
                }
            }
            System.out.print("- Nombre de la pista: ");
            String aux = scanner.nextLine();
            reserva.setPistId(scanner.nextLine());
            System.out.print("- Introduzca el número de niños de la reserva: ");
            reserva.setnChildren(scanner.nextInt());
            if(gestorReservas.hacerReservaIndividualInfantil(reserva)) {
                System.out.print("Reserva realizada correctamente ");
                return true;
            }
            System.out.print("No se ha podido realizar la reserva ");
            return false;
        }
        
        /**
         * Crea una reserva familiar individual
         * @param none
         * @return boolean True si se ha podido registrar
         */
        
        public static Boolean createRIndividualFamiliar() throws ParseException{
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            ReservaFamiliarDTO reserva = new ReservaFamiliarDTO();
            GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
            GestorPistas gestorPistas = GestorPistas.getInstance();
            GestorReservas gestorReservas = GestorReservas.getInstance();
            UsuarioDTO usuario = gestorUsuarios.getUsuarioActivo();
            
            String nacimiento = usuario.getDateOfBirth();
            String año = nacimiento.substring(0, 4);
            int añonacimiento = Integer.parseInt(año);
            if(añonacimiento < 18) {
                System.out.println("No puede realizar reservas ya que no es mayor de edad.");
                return false;
            }
            
            System.out.println("Introduzca los siguientes datos: ");
            reserva.setUserId(usuario.getEmail());
            System.out.print("- Fecha de la reserva con el formato \"yyyy-MM-dd\" : ");
            reserva.setDate(scanner.nextLine());
            System.out.print("- Duración (60, 90 o 120 minutos): ");
            reserva.setDuration(scanner.nextInt());
            if(reserva.getDuration() == 60) {
                reserva.setPrice(20);
            }
            if(reserva.getDuration() == 90) {
                reserva.setPrice(30);
            }
            if(reserva.getDuration() == 120) {
                reserva.setPrice(40);
            }
            Date antiguedad = usuario.getInscription();
            @SuppressWarnings("deprecation")
            int ant = antiguedad.getYear();
            if(ant > 2) {
                reserva.setDiscount(10);
            }
            else{
                reserva.setDiscount(0);
            }
            System.out.print("- Seleccione una pista: ");
            ArrayList<PistaDTO> pistas = gestorPistas.getPistas();
            System.out.println("      Pistas     ");
            System.out.println("------------------");
            for (int i = 0; i < pistas.size(); i++) {
                if(pistas.get(i).getDif().equals(PistaDTO.dificulty.familiar)) {
                    System.out.println("   " + pistas.get(i).getName());   
                }
            }
            System.out.print("- Nombre de la pista: ");
            String aux = scanner.nextLine();
            reserva.setPistId(scanner.nextLine());
            System.out.print("- Introduzca el número de niños de la reserva: ");
            reserva.setnChildren(scanner.nextInt());
            System.out.print("- Introduzca el número de adultos de la reserva: ");
            reserva.setnAdults(scanner.nextInt());
            if(gestorReservas.hacerReservaIndividualFamiliar(reserva)) {
                System.out.print("Reserva realizada correctamente ");
                return true;
            }
            System.out.print("No se ha podido realizar la reserva ");
            return false;
        }
        
        /**
         * Crea una reserva adultos individual
         * @param none
         * @return boolean True si se ha podido registrar
         */
        
        public static Boolean createRIndividualAdultos() throws ParseException{
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            ReservaAdultosDTO reserva = new ReservaAdultosDTO();
            GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
            GestorPistas gestorPistas = GestorPistas.getInstance();
            GestorReservas gestorReservas = GestorReservas.getInstance();
            UsuarioDTO usuario = gestorUsuarios.getUsuarioActivo();
            
            String nacimiento = usuario.getDateOfBirth();
            String año = nacimiento.substring(0, 4);
            int añonacimiento = Integer.parseInt(año);
            if(añonacimiento < 18) {
                System.out.println("No puede realizar reservas ya que no es mayor de edad.");
                return false;
            }
            
            System.out.println("Introduzca los siguientes datos: ");
            reserva.setUserId(usuario.getEmail());
            System.out.print("- Fecha de la reserva con el formato \"yyyy-MM-dd\" : ");
            reserva.setDate(scanner.nextLine());
            System.out.print("- Duración (60, 90 o 120 minutos): ");
            reserva.setDuration(scanner.nextInt());
            if(reserva.getDuration() == 60) {
                reserva.setPrice(20);
            }
            if(reserva.getDuration() == 90) {
                reserva.setPrice(30);
            }
            if(reserva.getDuration() == 120) {
                reserva.setPrice(40);
            }
            Date antiguedad = usuario.getInscription();
            @SuppressWarnings("deprecation")
            int ant = antiguedad.getYear();
            if(ant > 2) {
                reserva.setDiscount(10);
            }
            else{
                reserva.setDiscount(0);
            }
            System.out.print("- Seleccione una pista: ");
            ArrayList<PistaDTO> pistas = gestorPistas.getPistas();
            System.out.println("      Pistas     ");
            System.out.println("------------------");
            for (int i = 0; i < pistas.size(); i++) {
                if(pistas.get(i).getDif().equals(PistaDTO.dificulty.adultos)) {
                    System.out.println("   " + pistas.get(i).getName());   
                }
            }
            System.out.print("- Nombre de la pista: ");
            String aux = scanner.nextLine();
            reserva.setPistId(scanner.nextLine());
            System.out.print("- Introduzca el número de adultos de la reserva: ");
            reserva.setnParticipants(scanner.nextInt());
            if(gestorReservas.hacerReservaIndividualAdultos(reserva)) {
                System.out.print("Reserva realizada correctamente ");
                return true;
            }
            System.out.print("No se ha podido realizar la reserva ");
            return false;
        }
        
        /**
         * Crea una reserva infantil de bono
         * @param none
         * @return boolean True si se ha podido registrar
         */

        public static Boolean createRBonoInfantil() throws ParseException{
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            ReservaInfantilDTO reserva = new ReservaInfantilDTO();
            GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
            GestorPistas gestorPistas = GestorPistas.getInstance();
            GestorReservas gestorReservas = GestorReservas.getInstance();
            UsuarioDTO usuario = gestorUsuarios.getUsuarioActivo();
            
            String nacimiento = usuario.getDateOfBirth();
            String año = nacimiento.substring(0, 4);
            int añonacimiento = Integer.parseInt(año);
            if(añonacimiento < 18) {
                System.out.println("No puede realizar reservas ya que no es mayor de edad.");
                return false;
            }
            for(int i=0; i<5; i++) {
                System.out.println("Introduzca los siguientes datos para su " + (i + 1) + " reserva.");
                reserva.setUserId(usuario.getEmail());
                System.out.print("- Fecha de la reserva con el formato \"yyyy-MM-dd\" : ");
                reserva.setDate(scanner.nextLine());
                System.out.print("- Duración (60, 90 o 120 minutos): ");
                reserva.setDuration(scanner.nextInt());
                if(reserva.getDuration() == 60) {
                    reserva.setPrice(20);
                }
                if(reserva.getDuration() == 90) {
                    reserva.setPrice(30);
                }
                if(reserva.getDuration() == 120) {
                    reserva.setPrice(40);
                }
                reserva.setDiscount(5);
                System.out.print("- Seleccione una pista: ");
                ArrayList<PistaDTO> pistas = gestorPistas.getPistas();
                System.out.println("      Pistas     ");
                System.out.println("------------------");
                for (int j = 0; j < pistas.size(); j++) {
                    if(pistas.get(j).getDif().equals(PistaDTO.dificulty.infantil)) {
                        System.out.println("   " + pistas.get(j).getName());   
                    }
                }
                System.out.print("- Nombre de la pista: ");
                String aux = scanner.nextLine();
                reserva.setPistId(scanner.nextLine());
                System.out.print("- Introduzca el número de niños de la reserva: ");
                reserva.setnChildren(scanner.nextInt());
                aux = scanner.nextLine();
                if(gestorReservas.hacerReservaBonoInfantil(reserva)) {
                    System.out.print("Reserva realizada correctamente ");
                }
                else{
                    System.out.print("No se ha podido realizar la reserva ");
                }
                
            }
            return true;
            
        }
        
        /**
         * Crea una reserva familiar de bono
         * @param none
         * @return boolean True si se ha podido registrar
         */
        
        public static Boolean createRBonoFamiliar() throws ParseException{
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            ReservaFamiliarDTO reserva = new ReservaFamiliarDTO();
            GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
            GestorPistas gestorPistas = GestorPistas.getInstance();
            GestorReservas gestorReservas = GestorReservas.getInstance();
            UsuarioDTO usuario = gestorUsuarios.getUsuarioActivo();
            
            String nacimiento = usuario.getDateOfBirth();
            String año = nacimiento.substring(0, 4);
            int añonacimiento = Integer.parseInt(año);
            if(añonacimiento < 18) {
                System.out.println("No puede realizar reservas ya que no es mayor de edad.");
                return false;
            }
            for(int i=0; i<5; i++) {
                System.out.println("Introduzca los siguientes datos para su " + (i + 1) + " reserva.");
                reserva.setUserId(usuario.getEmail());
                System.out.print("- Fecha de la reserva con el formato \"yyyy-MM-dd\" : ");
                reserva.setDate(scanner.nextLine());
                System.out.print("- Duración (60, 90 o 120 minutos): ");
                reserva.setDuration(scanner.nextInt());
                String aux = scanner.nextLine();
                if(reserva.getDuration() == 60) {
                    reserva.setPrice(20);
                }
                if(reserva.getDuration() == 90) {
                    reserva.setPrice(30);
                }
                if(reserva.getDuration() == 120) {
                    reserva.setPrice(40);
                }
                reserva.setDiscount(5);
                System.out.print("- Seleccione una pista: ");
                ArrayList<PistaDTO> pistas = gestorPistas.getPistas();
                System.out.println("      Pistas     ");
                System.out.println("------------------");
                for (int j = 0; j < pistas.size(); j++) {
                    if(pistas.get(j).getDif().equals(PistaDTO.dificulty.familiar)) {
                        System.out.println("   " + pistas.get(j).getName());   
                    }
                }
                System.out.print("- Nombre de la pista: ");
                reserva.setPistId(scanner.nextLine());
                System.out.print("- Introduzca el número de adultos de la reserva: ");
                reserva.setnAdults(scanner.nextInt());
                aux = scanner.nextLine();
                System.out.print("- Introduzca el número de niños de la reserva: ");
                reserva.setnChildren(scanner.nextInt());
                aux = scanner.nextLine();
                if(gestorReservas.hacerReservaBonoFamiliar(reserva)) {
                    System.out.print("Reserva realizada correctamente ");
                }
                else{
                    System.out.print("No se ha podido realizar la reserva ");
                }
                
            }
            return true;
        }
        
        /**
         * Crea una reserva adultos de bono
         * @param none
         * @return boolean True si se ha podido registrar
         */
        
        public static Boolean createRBonoAdultos() throws ParseException{
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            ReservaAdultosDTO reserva = new ReservaAdultosDTO();
            GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
            GestorPistas gestorPistas = GestorPistas.getInstance();
            GestorReservas gestorReservas = GestorReservas.getInstance();
            UsuarioDTO usuario = gestorUsuarios.getUsuarioActivo();
            
            String nacimiento = usuario.getDateOfBirth();
            String año = nacimiento.substring(0, 4);
            int añonacimiento = Integer.parseInt(año);
            if(añonacimiento < 18) {
                System.out.println("No puede realizar reservas ya que no es mayor de edad.");
                return false;
            }
            for(int i=0; i<5; i++) {
                System.out.println("Introduzca los siguientes datos para su " + (i + 1) + " reserva.");
                reserva.setUserId(usuario.getEmail());
                System.out.print("- Fecha de la reserva con el formato \"yyyy-MM-dd\" : ");
                reserva.setDate(scanner.nextLine());
                System.out.print("- Duración (60, 90 o 120 minutos): ");
                reserva.setDuration(scanner.nextInt());
                String aux = scanner.nextLine();
                if(reserva.getDuration() == 60) {
                    reserva.setPrice(20);
                }
                if(reserva.getDuration() == 90) {
                    reserva.setPrice(30);
                }
                if(reserva.getDuration() == 120) {
                    reserva.setPrice(40);
                }
                reserva.setDiscount(5);
                System.out.print("- Seleccione una pista: ");
                ArrayList<PistaDTO> pistas = gestorPistas.getPistas();
                System.out.println("      Pistas     ");
                System.out.println("------------------");
                for (int j = 0; j < pistas.size(); j++) {
                    if(pistas.get(j).getDif().equals(PistaDTO.dificulty.familiar)) {
                        System.out.println("   " + pistas.get(j).getName());   
                    }
                }
                System.out.print("- Nombre de la pista: ");
                reserva.setPistId(scanner.nextLine());
                System.out.print("- Introduzca el número de adultos de la reserva: ");
                reserva.setnParticipants(scanner.nextInt());
                aux = scanner.nextLine();
                if(gestorReservas.hacerReservaBonoAdultos(reserva)) {
                    System.out.print("Reserva realizada correctamente ");
                }
                else{
                    System.out.print("No se ha podido realizar la reserva ");
                }
                
            }
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
            
            UsuarioDTO user = usuario.getUsuarioActivo();
            String mail = user.getEmail();
            
            System.out.println("Introduzca los siguientes datos: ");
            System.out.print(" - Nombre: ");
            user.setName(scanner.nextLine());
            System.out.print(" - Fecha de nacimiento con el formato \"yyyy-MM-dd\" : ");
            String date = scanner.nextLine();
            user.setDateOfBirth(date);
            System.out.print(" - Email: ");
            user.setEmail(scanner.nextLine());
        
            return usuario.modificarUsuario(user, mail);
        
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
        
        @SuppressWarnings("deprecation")
        public static void listarReservas(){
            Functions.clearConsole();
            GestorReservas gestor = GestorReservas.getInstance();
            GestorUsuarios usuario = GestorUsuarios.getInstance();
            ArrayList<ReservaInfantilDTO> reservasInfantil = gestor.reservasFuturasInfantil();
            ArrayList<ReservaFamiliarDTO> reservasFamiliar = gestor.reservasFuturasFamiliar();
            ArrayList<ReservaAdultosDTO> reservasAdultos = gestor.reservasFuturasAdultos();
            System.out.println("             Reservas            ");
            System.out.println("  id  |  tipo  |    día    |  pista");
            System.out.println("----------------------------------------");
            for(int i=0; i<reservasInfantil.size(); i++) {
                if(reservasInfantil.get(i).getUserId().equals(usuario.getUsuarioActivo().getEmail())) {
                    java.util.Date hoy = new Date();
                    String año = reservasInfantil.get(i).getDate().substring(0, 4);
                    int añoreserva = Integer.parseInt(año);
                    String mes = reservasInfantil.get(i).getDate().substring(5, 7);
                    int mesreserva = Integer.parseInt(mes);
                    String dia = reservasInfantil.get(i).getDate().substring(8, 10);
                    int diareserva = Integer.parseInt(dia);
                    if(añoreserva >= hoy.getYear() && mesreserva >= hoy.getMonth() && diareserva >= hoy.getDay()) {
                        System.out.println("   " + reservasInfantil.get(i).getId() + "   infantil   " + reservasInfantil.get(i).getDate().substring(0, 11) + "   " + reservasInfantil.get(i).getPistId()); 
                        //ESTO NO FUNCIONA Y NO SE PQ NO COGE LA FECHA BIEN CON GET YEARS Y ESO
                        //System.out.println(hoy);
                        //System.out.println(hoy.getYear());
                        //System.out.println(hoy.getMonth());
                        //System.out.println(hoy.getDay());
                    }
                }
            }
            for(int i=0; i<reservasFamiliar.size(); i++) {
                if(reservasFamiliar.get(i).getUserId().equals(usuario.getUsuarioActivo().getEmail())) {
                    Date hoy = new Date();
                    String año = reservasFamiliar.get(i).getDate().substring(0, 4);
                    int añoreserva = Integer.parseInt(año);
                    String mes = reservasFamiliar.get(i).getDate().substring(5, 7);
                    int mesreserva = Integer.parseInt(mes);
                    String dia = reservasFamiliar.get(i).getDate().substring(8, 10);
                    int diareserva = Integer.parseInt(dia);
                    if(añoreserva >= hoy.getYear() && mesreserva >= hoy.getMonth() && diareserva >= hoy.getDay()) {
                        System.out.println("   " + reservasFamiliar.get(i).getId() + "   familiar   " + reservasFamiliar.get(i).getDate().substring(0, 11) + "   " + reservasFamiliar.get(i).getPistId()); 
                    }
                }
            }
            for(int i=0; i<reservasAdultos.size(); i++) {
                if(reservasAdultos.get(i).getUserId().equals(usuario.getUsuarioActivo().getEmail())) {
                    Date hoy = new Date();
                    String año = reservasAdultos.get(i).getDate().substring(0, 4);
                    int añoreserva = Integer.parseInt(año);
                    String mes = reservasAdultos.get(i).getDate().substring(5, 7);
                    int mesreserva = Integer.parseInt(mes);
                    String dia = reservasAdultos.get(i).getDate().substring(8, 10);
                    int diareserva = Integer.parseInt(dia);
                    if(añoreserva >= hoy.getYear() && mesreserva >= hoy.getMonth() && diareserva >= hoy.getDay()) {
                        System.out.println("   " + reservasAdultos.get(i).getId() + "   adultos   " + reservasAdultos.get(i).getDate().substring(0, 11) + "   " + reservasAdultos.get(i).getPistId()); 
                    }
                }
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

            System.out.println("Introduzca los siguientes datos: ");
            System.out.print(" - Nombre: ");
            pista.setName(scanner.nextLine());
            System.out.print(" - Estado (disponible o ocupado): ");
            String aux = scanner.nextLine();
            if(aux.equals("disponible") == true) {
                pista.setStatus(true);
            }
            if(aux.equals("ocupado") == true) {
                pista.setStatus(false);
            }
            System.out.print(" - Dificultad (infantil, familiar o adultos): ");
            aux = scanner.nextLine();
            if(aux.equals("infantil") == true) {
                pista.setDificulty(PistaDTO.dificulty.infantil);
            }
            if(aux.equals("familiar") == true) {
                pista.setDificulty(PistaDTO.dificulty.familiar);
            }
            if(aux.equals("adultos") == true) {
                pista.setDificulty(PistaDTO.dificulty.adultos);
            }
            System.out.print(" - Número máximo de karts: ");
            pista.setMax(scanner.nextInt());
            
            if(gestor.registerPista(pista)) {
                System.out.println("Registro correcto");
                return true;
            }
            System.out.println("Error al registrar la pista");
            return false;
        }
        
        /**
         * Función que modifica una pista
         * @param none
         * @return none
         */
        
        public static Boolean modificarPista() throws ParseException {
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            GestorPistas gestor = GestorPistas.getInstance();
            ArrayList<PistaDTO> pistas = gestor.getPistas();
        
            Functions.listarPistas();
        
            System.out.println("Introduzca el nombre de la pista que desea modificar: ");
            String name = scanner.nextLine();
            
            PistaDTO pista = null;
            
            for (int i=0; i<pistas.size(); i++) {
                if(pistas.get(i).getName().equals(name)) {
                    pista = pistas.get(i);
                }
            }
            
            if (pista != null) {
                System.out.println("Introduzca los siguientes datos: ");
                System.out.print(" - Estado (disponible o ocupado): ");
                String aux = scanner.nextLine();
                if(aux.equals("disponible") == true) {
                    pista.setStatus(true);
                }
                if(aux.equals("ocupado") == true) {
                    pista.setStatus(false);
                }
                System.out.print(" - Dificultad (infantil, familiar o adultos): ");
                aux = scanner.nextLine();
                if(aux.equals("infantil") == true) {
                    pista.setDificulty(PistaDTO.dificulty.infantil);
                }
                if(aux.equals("familiar") == true) {
                    pista.setDificulty(PistaDTO.dificulty.familiar);
                }
                if(aux.equals("adultos") == true) {
                    pista.setDificulty(PistaDTO.dificulty.adultos);
                }
                System.out.print(" - Número máximo de karts: ");
                pista.setMax(scanner.nextInt());        
              return gestor.modificarPista(pista, name);
            }
        
            return false;
        }
        
        /**
         * Elimina una pista del sistema
         * @param none
         * @return none
         */
        
        public static Boolean deletePista(){
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            GestorPistas gestor = GestorPistas.getInstance();

            Functions.listarPistas();
            System.out.print("Introduzca el identificador de la pista que desea borrar: ");
            String pistaId = scanner.next();

            return gestor.deletePista(pistaId);

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

            System.out.println("Introduzca los siguientes datos: ");
            System.out.print(" - Tipo (infantil o adulto): ");
            String aux = scanner.nextLine();
            if(aux.equals("infantil") == true) {
                kart.setType(true);
            }
            
            if(aux.equals("adulto") == true) {
                kart.setType(false);
            }
            System.out.print(" - Estado (disponible, reservado o mantenimiento): ");
            aux = scanner.nextLine();
            if(aux.equals("disponible") == true) {
                kart.setStat(KartDTO.status.disponible);
            }
            if(aux.equals("reservado") == true) {
                kart.setStat(KartDTO.status.reservado);
            }
            if(aux.equals("mantenimiento") == true) {
                kart.setStat(KartDTO.status.mantenimiento);
            }
            listarPistas();
            System.out.print(" - Pista (Seleccione una o deje vacio): ");
            kart.setpistaId(scanner.nextLine());
            
            ArrayList<KartDTO> karts = gestor.getKarts();
            int n=0;
            for(int i=0; i<karts.size(); i++) {
                if(karts.get(i).getpistaId().equals(kart.getpistaId())) {
                    n++;
                }
            }
            
            ArrayList<PistaDTO> pistas = gestor.getPistas();
            for(int i=0; i<pistas.size(); i++) {
                if(pistas.get(i).getName().equals(kart.getpistaId())) {
                    if(pistas.get(i).getMax() <= n) {
                        System.out.println("El número máximo de karts de esa pista se ha excedido");
                        return false;
                    }
                    if(pistas.get(i).getDif() == PistaDTO.dificulty.infantil && kart.isType() == false) {
                        System.out.println("No se puede añadir el tipo de kart adulto a una pista infantil");
                        return false;
                    }
                    if(pistas.get(i).getDif() == PistaDTO.dificulty.adultos && kart.isType() == true) {
                        System.out.println("No se puede añadir el tipo de kart infantil a una pista para adultos");
                        return false;
                    }
                }
            }
            
            if(gestor.registerKart(kart)) {
                System.out.println("Registro correcto");
                return true;
            }
            System.out.println("Error al registrar la pista");
            return false;
        }
        
        /**
         * listar el usuario actual
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
        
        /**
         * Función que modifica un kart
         * @param none
         * @return none
         */
        
        public static Boolean modificarKart() throws ParseException {
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            GestorPistas gestor = GestorPistas.getInstance();
            ArrayList<KartDTO> karts = gestor.getKarts();
        
            Functions.listarKarts();
        
            System.out.println("Introduzca el identificador del kart que desea modificar: ");
            String x = scanner.nextLine();
            int id = Integer.parseInt(x);
            
            KartDTO kart = null;
            
            for (int i=0; i<karts.size(); i++) {
                if(karts.get(i).getId() == id) {
                    kart = karts.get(i);
                }
            }
            
            if (kart != null) {
                System.out.println("Introduzca los siguientes datos: ");
                System.out.print(" - Tipo (infantil o adulto): ");
                String aux = scanner.nextLine();
                if(aux.equals("infantil") == true) {
                    kart.setType(true);
                }
                
                if(aux.equals("adulto") == true) {
                    kart.setType(false);
                }
                System.out.print(" - Estado (disponible, reservado o mantenimiento): ");
                aux = scanner.nextLine();
                if(aux.equals("disponible") == true) {
                    kart.setStat(KartDTO.status.disponible);
                }
                if(aux.equals("reservado") == true) {
                    kart.setStat(KartDTO.status.reservado);
                }
                if(aux.equals("mantenimiento") == true) {
                    kart.setStat(KartDTO.status.mantenimiento);
                }
                listarPistas();
                System.out.print(" - Pista (Seleccione una o deje vacio): ");
                kart.setpistaId(scanner.nextLine());
                
                int n=0;
                for(int i=0; i<karts.size(); i++) {
                    if(karts.get(i).getpistaId().equals(kart.getpistaId())) {
                        n++;
                    }
                }
                
                ArrayList<PistaDTO> pistas = gestor.getPistas();
                for(int i=0; i<pistas.size(); i++) {
                    if(pistas.get(i).getName().equals(kart.getpistaId())) {
                        if(pistas.get(i).getMax() <= n) {
                            System.out.println("El número máximo de karts de esa pista se ha excedido");
                            return false;
                        }
                        if(pistas.get(i).getDif() == PistaDTO.dificulty.infantil && kart.isType() == false) {
                            System.out.println("No se puede añadir el tipo de kart adulto a una pista infantil");
                            return false;
                        }
                        if(pistas.get(i).getDif() == PistaDTO.dificulty.adultos && kart.isType() == true) {
                            System.out.println("No se puede añadir el tipo de kart infantil a una pista para adultos");
                            return false;
                        }
                    }
                }
        
              return gestor.modificarKart(kart, id);
            }
        
            return false;
            
        }
        
        /**
         * Elimina un usuario del sistema
         * @param none
         * @return none
         */
        
        public static Boolean deleteKart(){
            Functions.clearConsole();
            scanner = new Scanner(System.in);
            GestorPistas gestor = GestorPistas.getInstance();

            Functions.listarKarts();
            System.out.print("Introduzca el identificador del kart que desea borrar: ");
            int id = scanner.nextInt();

            return gestor.deleteKart(id);

        }
        
}
