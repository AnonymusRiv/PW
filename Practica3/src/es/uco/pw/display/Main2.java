package es.uco.pw.display;

import java.text.ParseException;

import es.uco.pw.business.managers.DBmanager;
import es.uco.pw.data.common.DBConnection;

public class Main {
    public static void main(String args[]) throws ParseException
    {

        DBConnection BaseConnection = DBConnection.getInstance();
        BaseConnection.getConnection();
        DBmanager BaseManager = DBmanager.getInstance();
        
        
        int choice, choice1, choice2, choice3;

        choice = Functions.printUserLoginScreen();

        while(choice != 0){
            if(choice <0 && choice>2){
                System.out.println("Seleccione una opción válida.");
            }
            if(choice == 1){
               Functions.registerUser();
            }

            if(choice == 2){
                if (Functions.loginUser()){
            
                    choice1 = Functions.printReservaMenuScreen();

                    if(choice1 < 0 || choice1 > 5) {
                        System.out.println("Seleccione una opción válida.");
                    }
                    while(choice1 != 0){
                        if(choice1 == 1){
                            choice2 = Functions.registrarReserva();

                            if(choice2 < 0 || choice2 > 3) {
                                System.out.println("Seleccione una opción válida.");
                            }
                            while(choice2 != 0){
                                if(choice2 == 1){ 
                                    if(Functions.createRInfantil()){

                                        choice3 = Functions.printPistaMenuScreen();
                                        
                                        if(choice3 < 0 || choice3 > 2) {
                                            System.out.println("Seleccione una opción válida.");
                                        }

                                        while(choice3 != 0){
                                            if(choice3 == 1){
                                                Functions.listarPistas();
                                            }
                                            if(choice3 == 2){
                                                Functions.registerPista();
                                            }
                                        }
                                    }
                                }
                                if(choice2 == 2){
                                    if(Functions.createRFamiliar()){

                                        choice3 = Functions.printPistaMenuScreen();

                                        while(choice3 != 0){
                                            if(choice3 == 1){
                                                Functions.listarPistas();
                                            }
                                            if(choice3 == 2){
                                                Functions.registerPista();
                                            }
                                        }
                                    }
                                }
                                if(choice2 == 3){
                                    if(Functions.createRAdultos()){

                                        choice3 = Functions.printPistaMenuScreen();

                                        while(choice3 != 0){
                                            if(choice3 == 1){
                                                Functions.listarPistas();
                                            }
                                            if(choice3 == 2){
                                                Functions.registerPista();
                                            }
                                            choice3 = Functions.printPistaMenuScreen();
                                        }
                                    }
                                }
                                choice2 = Functions.registrarReserva();
                            }
                        }
                        if(choice1 == 2){
                            Functions.modificarReserva();
                        }
                        if(choice1 == 3){ 
                            Functions.deleteReserva();
                        }
                        if(choice1 == 4){ 
                            Functions.modificarUsuario();
                        }
                        if(choice1 == 5){ 
                            Functions.deleteUsuario();
                        }
                        choice1 = Functions.printReservaMenuScreen();
                    }
                }
            }
            choice = Functions.printUserLoginScreen();
        }
    }
}
