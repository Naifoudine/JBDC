package connexionMySQL.java;

import java.util.*;

public class TestJDBC {
	public static void main(String[] args) { ConnectMySQL testConnexion =new ConnectMySQL(); 
	
	Scanner sc = new Scanner(System.in);
	System.out.println("Veuillez saisir le nom :");
	String nom1 = sc.nextLine();
	
	System.out.println("Veuillez saisir le prenom :");
	String prenom1 = sc.nextLine();
	
	System.out.println("Veuillez saisir l'email :");
	String email1 = sc.nextLine();
	
	System.out.println("Veuillez saisir la specialite :");
	String specialite1 = sc.nextLine();
	
	String nom = nom1;
	String prenom = prenom1;
	String email = email1;
	String specialite = specialite1;
	
	
	/*String nom = nom1;
	String specialite = specialite1;
	String prenom = prenom1;
	String email = email1;*/
	//testConnexion.ajouterAuteur( null, nom.getText(), prenom.get, email.getBytes(), specialite.getBytes());
	
	testConnexion.ajouterAuteur(16, nom, prenom, email, specialite);
	

	
	
	
	
	//testConnexion.supprimerAuteur(9);
	testConnexion.afficherAuteur(); 
	}
	

}



