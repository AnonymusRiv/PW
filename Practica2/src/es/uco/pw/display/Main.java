package es.uco.pw.display;

import java.text.ParseException;

public class Main {
    public static void main(String args[]) throws ParseException
    {

        int choice, choice1, choice2, choice3;

        choice = Functions.printUserLoginScreen();

        while(choice != 0){
            if(choice == 1){
               Functions.registerUser();
            }

            if(choice == 2){
                if (Functions.loginUser()){
            
                    choice1 = Functions.printReservaMenuScreen();

                    while(choice1 != 0){
                        if(choice1 == 1){
                            choice2 = Functions.registrarReserva();

                            while(choice2 != 0){
                                if(choice2 == 1){ 
                                    if(Functions.createRInfantil()){

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
                                        }
                                    }
                                }
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
                    }
                }
            }
            else{
                System.out.println("Error");
            }
            choice = Functions.printUserLoginScreen();
        }
    }
}