package es.uco.pw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import es.uco.pw.classes.Kart;
import es.uco.pw.classes.Pista.dificulty;
import es.uco.pw.factory.Reserva.type;

public class FileProperties {
	public static void main(String[] args) {
		
		Properties prop = new Properties();
		String filename = "usuarios.txt";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));
			prop.load(reader);
			
			System.out.println(prop.get("nombre"));
			System.out.println(prop.get("email"));
			System.out.println(prop.get("fecha de nacimiento"));
			System.out.println(prop.get("fecha primera reserva"));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop2 = new Properties();
		String filename2 = "pistas.txt";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename2)));
			prop2.load(reader);
			
			System.out.println(prop.get("nombre"));
			System.out.println(prop.get("estado"));
			System.out.println(prop.get("dificultad"));
			System.out.println(prop.get("número máximo de karts"));
			System.out.println(prop.get("lista de karts asociados"));
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop3 = new Properties();
		String filename3 = "reservas.txt";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(filename3)));
			prop3.load(reader);
			
			System.out.println(prop.get("ID de usuario"));
			System.out.println(prop.get("fecha"));
			System.out.println(prop.get("duración"));
			System.out.println(prop.get("ID de pista"));
			System.out.println(prop.get("precio"));
			System.out.println(prop.get("descuento"));
			System.out.println(prop.get("tipo de reserva"));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
