/**
 * @file FonctionsSQL.java
 * @brief classe pour pour lancer l'application
 * @author Stefan (devgit@factooor.fr)
 * @date 22 mai 2012
 * @version 1.0
 * @details cette classe contient toutes les fontions pour utiliser le programme
 *          sauf les foncitons de connection à la base de données sqlite
 */
package Interface;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class FonctionsSQL {

    private String requete;
     
      public void creation(){
        
         System.out.println("1");
          try {
           Connection con = SourceDonneesSqlite.getConnection();
              //String requete = "CREATE IF NOT EXISTS database test";
            String req = "CREATE TABLE test (colonne1 INT , colonne2 INT)";
            Statement stmt = con.createStatement() ;
            stmt.execute(req);
            con.close();
        } catch (Exception e) {
            System.out.println("Erreur:Anomalie lors de l'execution de la requête : " + e);
        }
    }

      // focntions static qui permet d'envoyer vers la class fenetre la somme par taux !  
          public static String requetTVA196(String requete) {
 String texte196 = "";
             requete = "select sum(MontantTva) from recu where TauxTVa = '19.6' and Date >= '2012-04-01' and Date <= '2012-07-01'";
 try {
            Connection con = SourceDonneesSqlite.getConnection();             
             //requete = "SELECT idRais, MonEnseigne FROM `raisonSoc`";             
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(requete);
                 while (rs.next()) {
                texte196 = rs.getString(1);
                }
            rs.close();
        } catch (Exception e) {
            System.out.println("Erreur:Anomalie lors de l'execution de la requête : " + e);
        }
        
 return texte196 ;
    }
          
      public static String requetTVA7(String requete){
          String texte7 = "";
          //requete = "select sum(MontantTva) from recu where Date >= '"+year+"-01-01' and Date <= '"+year+"-04-01' ";
          requete = "select sum(MontantTva) from recu where TauxTva = '7' and  Date >= '2012-04-01' and Date <= '2012-07-01' ";
 try {
            Connection con = SourceDonneesSqlite.getConnection();           
           
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(requete);
                 while (rs.next()) {
                texte7 = rs.getString(1);
                }
            rs.close();
        } catch (Exception e) {
            System.out.println("Erreur:Anomalie lors de l'execution de la requête : " + e);
        }        
 return texte7;
      }
   
      public static String requetTVA55(String requete){
          String texte55 = "";  
          requete = "select sum(MontantTva) from recu where TauxTva = '5.5' and Date >= '2012-04-01' and Date <= '2012-07-01' ";
 try {
           Connection con = SourceDonneesSqlite.getConnection();             
            
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(requete);
                 while (rs.next()) {
                texte55 = rs.getString(1);
                }
            rs.close();
        } catch (Exception e) {
            System.out.println("Erreur:Anomalie lors de l'execution de la requête : " + e);
        }    
 return texte55;
}
       /*     public static String totalannuelTVA(String requete){
          String texteAnnuel = ""; 
          requete = "select sum(MontantTva) from recu Date <= 2110-12-31 and Date >= 2112-01-01";
 try {
           Connection con = SourceDonneesSqlite.getConnection();             
            
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(requete);
                 while (rs.next()) {
                texteAnnuel = rs.getString(1);
                }
            rs.close();
        } catch (Exception e) {
            System.out.println("Erreur:Anomalie lors de l'execution de la requête : " + e);
        }    
 return texteAnnuel;
}*/
          public Object[] Trim2Tva196(){
          String TVA2trim = "";
          SimpleDateFormat year = new SimpleDateFormat("yyyy", Locale.FRANCE);
        //java.sql.Date sqlDate = new java.sql.Date(DateChoix.getTime());
       //Object year = null;
          requete = "select sum(MontantTva) from recu Date <= 2110-12-31 and Date >= '"+year+"-01-01' and Date <= '"+year+"-04-01'";
 try {
           Connection con = SourceDonneesSqlite.getConnection();             
            
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(requete);
                 while (rs.next()) {
                TVA2trim = rs.getString(1);
                }
            rs.close();
        } catch (Exception e) {
            System.out.println("Erreur:Anomalie lors de l'execution de la requête : " + e);
        }    
 Object[] retour = {TVA2trim, year};
 return retour;
}
}
