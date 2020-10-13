package connexionMySQL.java;

import java.sql.DriverManager;  // gestion des pilotes
import java.sql.PreparedStatement;
import java.sql.Connection;     // une connexion à la BDD
import java.sql.Statement;      // une instruction
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

import java.sql.ResultSet;	// un résultat (lignes/colonnes)
import java.sql.SQLException;   // pour les exeptions


public class ConnectMySQL {
	Connection conn = null;

	//constructeur
	public ConnectMySQL() {    

		String ip="127.0.0.1";
		String base = "continuum";
		String url = "jdbc:mysql://"+ip+":3306/"+base;
		String user = "user";
		String passwd = "root";	

		try {
			conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Driver : OK");
				if (conn != null) {
					System.out.println("Connexion à la Base : Ok");
				} else {
					System.out.println("Connexion à la Base : Echec !");
				}
		} catch (SQLException ex) {
			// gestion des erreurs
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}	
	}



public void afficherAuteur() {
	
Statement stmt = null;
ResultSet rs = null;
String requete =  "SELECT * FROM auteur" ;

		try {
		    stmt = conn.createStatement();
		    rs = stmt.executeQuery(requete);
		
		    /*
		     * Traitement du résultat
		     */
		          while (rs.next()) {
		            System.out.println("id auteur : "+rs.getString("id_auteur")) ;
		            System.out.println("nom : " + rs.getString("nom")) ;
		            System.out.println("prenom : " + rs.getString("prenom")) ;
		            System.out.println("email : " + rs.getString("email")) ;
		            System.out.println("spécialité : "+rs.getString("specialite")) ;
		         }
		}
		catch (SQLException ex){
		    // gestion des erreurs
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    // Libérartion des ressources
		
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore
		
		        rs = null;
		    }
		
		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore
		
		        stmt = null;
		    }
		}
	}
	public void ajouterAuteur(Integer idAuteur, String nom, String prenom, String email, String specialite) {
		PreparedStatement stmt = null;
		PreparedStatement rs = null;
		String requete =  "INSERT INTO `auteur` (`id_auteur`, `nom`, `prenom`, `email`, `specialite`) VALUES (? , ?, ?, ?, ?)";
		
		/*try {
			PreparedStatement stmt = conn.prepareStatement(requete);
			idAuteur = (Integer) null;
			
			//stmt.setInt(0, idAuteur);
			stmt.setString(2, nom);
			stmt.setString(3, prenom);
			stmt.setString(4, email);
			stmt.setString(5, specialite);
			   int nbMaj = stmt.executeUpdate(requete);
			   System.out.println("nb mise a jour = "+nbMaj);}
			/*} catch (SQLException e) {
			   e.printStackTrace();
			}*/
		try {
		    stmt = conn.prepareStatement(requete);
		    rs = conn.prepareStatement(requete);
			
		    /*
		     * Traitement du résultat
		     */
		    
		    
		          /*while (((ResultSet) rs).) {
		        	  stmt.setString(1, nom.getV);
		            System.out.println("id auteur : "+((ResultSet) rs).getString(idAuteur)) ;
		            System.out.println("nom : " + ((ResultSet) rs).getString(nom)) ;
		            System.out.println("prenom : " + ((ResultSet) rs).getString(prenom)) ;
		            System.out.println("email : " + ((ResultSet) rs).getString(email)) ;
		            System.out.println("spécialité : "+((ResultSet) rs).getString(specialite)) ;
		         }*/
		    rs.setInt(1, idAuteur);
		    rs.setString(2, nom);
		    rs.setString(3, prenom);
		    rs.setString(4, email);
		    rs.setString(5, specialite);
		    int nb = rs.executeUpdate();
		    
		    rs.close();
		}
		catch (SQLException ex){
		    // gestion des erreurs
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	public void supprimerAuteur(Integer idAuteur) {
		String requete = "DELETE FROM `auteur` WHERE `auteur`.`id_auteur` = 9;";
		try {
			   Statement stmt = conn.createStatement();
			   int nbMaj = stmt.executeUpdate(requete);
			   System.out.println("nb mise a jour = "+nbMaj);
			} catch (SQLException e) {
			   e.printStackTrace();
	}
	}

}

