/**
 * @file SourceDonneesSqlite.java
 * @brief classe pour lancer la connexion  à la base de données SQLITE
 * @author Stefan (devgit@factooor.fr)
 * @date 22 mai 2012
 * @version 1.0
 * @details cette classe contient toutes les fonctions et ou méthodes pour 
 * utiliser la connection à la base de données sqlite \a recuBase.db
 */
package Interface;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SourceDonneesSqlite {

 /**
 * @brief Affiche un message
 * @param System.out.println(message)
 * @details Affiche le message est passé en paramètre 
 */
   public static void affiche(String message) {
    System.out.println(message);
  }
 /**
 * @brief Affiche un message d'erreur
 * @param System.err.println(message)
 * @param System.exit(99)
 * @details Affiche le message passé en paramètre et stop l'action s'il y a 
 * une erreur 
 */
  public static void arret(String message) {
    System.err.println(message);
    System.exit(99);
  }
  
 /**
 * @brief créer la connexion  
 * @param Connection con
 * @param Class<?> forName
 * @param con = DriverManager.getConnection(url, user, password)
 * @param Statement stmt
 * @details Affiche le message passé en paramètre et stop l'action si erreur 
 */
   public static Connection getConnection() {
    Connection con = null;/*! Initialise la variable \a Connection à nul*/
    try {
      Class<?> forName = Class.forName("org.sqlite.JDBC"); 
      String url = "jdbc:sqlite:Donnees/recuBase.db"; 
      String user = ""; /*! Pour le login pour la connexion */
      String password = "";/*! Pour le mdp pour la connexion */
      con = DriverManager.getConnection(url, user, password);
      Statement stmt = con.createStatement();/*! Création du statement */
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(SourceDonneesSqlite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
      Interface.SourceDonneesSqlite.arret("Connection à la base de donnees impossible mon gros !" + e);
    }		
		return con;
}
   /**
     * @param args the command line arguments
     */
 public static void main(java.lang.String[] args) {
    ResultSet resultats = null;
    String requete = "";

     /*! chargement du pilote*/

    try {
      Class.forName("org.sqlite.JDBC");
    } catch (ClassNotFoundException e) {
      arret("Impossible de charger le pilote jdbc pour mySQL");
    }

    /* connection a la base de données */

    affiche("connection a la base de donnees"); 
    Connection con = getConnection(); 
    affiche("fin du programme");
    System.exit(0);
  }
}