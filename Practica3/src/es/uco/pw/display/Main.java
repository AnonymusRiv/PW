package es.uco.pw.display;

import java.text.ParseException;

import es.uco.pw.business.managers.DBmanager;
import es.uco.pw.data.common.DBConnection;

public class Main {
    public static void main(String args[]) throws ParseException{
        
        DBConnection BaseConnection = DBConnection.getInstance();
        BaseConnection.getConnection();
        DBmanager BaseManager = DBmanager.getInstance();
        
        int choice;
        
        choice = Functions.printUserLoginScreen();
        
        while(choice != 0) {
            if(choice <0 || choice>2){
                System.out.println("Seleccione una opción válida.");
            }
            if(choice == 1) {
                Functions.registerUser();
            }
            if(choice == 2) {
                if(Functions.loginUser()){
                    choice = Functions.printReservaMenuScreen();
                    
                    if(choice <0 || choice >15) {
                        System.out.println("Seleccione una opción válida.");
                        choice = Functions.printReservaMenuScreen();
                    }
                    
                    while(choice != 0) {
                        
                        if(choice == 1) {
                            choice = Functions.registrarReserva();
                            
                            if(choice < 0 || choice > 3) {
                                System.out.println("Seleccione una opción válida.");
                                choice = Functions.registrarReserva();
                            }
                            
                            while(choice != 0) {
                                if(choice == 1) {
                                    Functions.createRInfantil();
                                }
                                
                                if(choice == 2) {
                                    Functions.createRFamiliar();
                                }
                                
                                if(choice == 3) {
                                    Functions.createRAdultos();
                                }
                                
                                choice = Functions.registrarReserva();
                            }
                            
                        }
                        
                        if(choice == 2) {
                            Functions.modificarReserva();
                        }
                        
                        if(choice == 3) {
                            Functions.deleteReserva();
                        }
                        
                        if(choice == 4) {
                            Functions.listarReservas();
                        }
                        
                        if(choice == 5) {
                            Functions.listarUser();
                        }
                        
                        if(choice == 6) {
                            Functions.modificarUsuario();
                        }
                        
                        if(choice == 7) {
                            Functions.deleteUsuario();
                        }
                        
                        if(choice == 8) {
                            Functions.CreatePista();
                        }
                        
                        if(choice == 9) {
                            //modificar pista
                        }
                        
                        if(choice == 10) {
                            //eliminar pista
                        }
                        
                        if(choice == 11) {
                            Functions.listarPistas();
                        }
                        
                        if(choice == 12) {
                            Functions.CreateKart();
                        }
                        
                        if(choice == 13) {
                            //modificar kart
                        }
                        
                        if(choice == 14) {
                            //eliminar kart
                        }
                        
                        if(choice == 15) {
                            Functions.listarKarts();
                        }
                        
                        choice = Functions.printReservaMenuScreen();
                    }
                }
                else {
                    System.out.println("Usuario no válido.");
                }
            }
            choice = Functions.printUserLoginScreen();
        }
        Functions.printExitScreen();
    }
}
