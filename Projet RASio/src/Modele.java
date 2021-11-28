import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Pattern;
/**
 * Classe Modele
 * @author ldatchi
 */
public class Modele {
	
	/**
	 * Attributs privés static de la classe Modele
	 */
	//Déclaration des variables
	private static Connection connexion;
	private static Statement st;
	private static ResultSet rs;
	private static PreparedStatement statement;
	
	//Méthode seConnecter
	/**
	 * Méthode pour se connecter à la BDD
	 */
	public static void connexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://127.0.0.1/rasio?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC", "root", "");
			st = connexion.createStatement();
		} catch (ClassNotFoundException erreur) {
			//Message d'erreur
			System.out.println("Le driver n'a pas pu être chargé");
			erreur.printStackTrace();
		} catch (SQLException erreur) {
			//Message d'erreur
			System.out.println("La connexion à la base de données a échoué ou Erreur SQL…" + erreur);
			erreur.printStackTrace();
		}
	}
	
	//Méthode seDeconnecter
	/**
	 * Méthode pour se déconnecter de la BDD
	 */
	public static void deconnexion() {
		try {
			connexion.close();
		} catch(SQLException erreur) {
			//Message d'erreur
			System.out.println("La déconnexion n'a pas été effectuée.");
			erreur.printStackTrace();
		}
	}
	
	/**
	 * Méthode pour se connecter avec l'utilisateur
	 * @param unLogin
	 * @param unMDP
	 * @return
	 */
	public static boolean connexionUtilisateur(String unLogin, String unMDP) {
		Modele.connexion();
		boolean rep = false;
		int count = 0;
		try {
			statement = connexion.prepareStatement ("SELECT COUNT(*) AS count FROM connexion WHERE loginConnexion = ? AND mdpConnexion = ?;");
			statement.setString(1, unLogin);
			statement.setString(2, unMDP);
			rs = statement.executeQuery();
			while(rs.next()){
				count = rs.getInt("count");
			}
			rs.close();
			if(count == 1) {
				rep = true;
			}
		} catch (SQLException erreur) {
			//Message d'erreur
			System.out.println("");
		}
		return rep;
	}
	
	/**
	 * Méthode pour pouvoir ajouter des courses
	 * @param unNomCourse
	 * @param unTypeCourse
	 * @param unNbSpectateurs
	 * @return
	 */
	public static boolean ajoutCourse(String unNomCourse, String unTypeCourse, int unNbSpectateurs) {
        boolean rep = true;
        int count;
        try {
        	statement = connexion.prepareStatement("INSERT INTO course VALUES (?,?,?);");
        	statement.setString(1, unNomCourse);
        	statement.setString(2, unTypeCourse);
        	statement.setInt(3, unNbSpectateurs);
            count = statement.executeUpdate();
        }
        catch (SQLException erreur) {
            rep = false;
            System.out.println("Insertion échoué");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir ajouter des circuits
	 * @param unNomCircuit
	 * @param uneTailleCircuit
	 * @param unPaysCircuit
	 * @return
	 */
	public static boolean ajoutCircuit(String unNomCircuit, String uneTailleCircuit, String unPaysCircuit) {
        boolean rep = true;
        int count;
        try {
        	statement = connexion.prepareStatement("INSERT INTO circuit VALUES (?,?,?);");
        	statement.setString(1, unNomCircuit);
        	statement.setString(2, uneTailleCircuit);
        	statement.setString(3, unPaysCircuit);
            count = statement.executeUpdate();
        }
        catch (SQLException erreur) {
            rep = false;
            System.out.println("Insertion échoué");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir ajouter des ecuries
	 * @param unNomEcurie
	 * @param unSponsorEcurie
	 * @param unMotoristeEcurie
	 * @return
	 */
	public static boolean ajoutEcurie(String unNomEcurie, String unSponsorEcurie, String unMotoristeEcurie) {
        boolean rep = true;
        int count;
        try {
        	statement = connexion.prepareStatement("INSERT INTO ecurie VALUES (?,?,?);");
        	statement.setString(1, unNomEcurie);
        	statement.setString(2, unSponsorEcurie);
        	statement.setString(3, unMotoristeEcurie);
            count = statement.executeUpdate();
        }
        catch (SQLException erreur) {
            rep = false;
            System.out.println("Insertion échoué");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir ajouter des personnels
	 * @param unNomPersonnel
	 * @param unPrenomPersonnel
	 * @param uneAdressePersonnel
	 * @param unVillePersonnel
	 * @param unCpPersonnel
	 * @return
	 */
	public static boolean ajoutPersonnel(String unNomPersonnel, String unPrenomPersonnel, String uneAdressePersonnel, String unVillePersonnel, String unCpPersonnel) {
        boolean rep = true;
        int count;
        try {
        	statement = connexion.prepareStatement("INSERT INTO personnel VALUES (?,?,?,?,?);");
        	statement.setString(1, unNomPersonnel);
        	statement.setString(2, unPrenomPersonnel);
        	statement.setString(3, uneAdressePersonnel);
        	statement.setString(4, unVillePersonnel);
        	statement.setString(5, unCpPersonnel);
            count = statement.executeUpdate();
        }
        catch (SQLException erreur) {
            rep = false;
            System.out.println("Insertion échoué");
            erreur.printStackTrace();
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir afficher les courses
	 * @return
	 */
	public static ArrayList<ConstrCourse> affichageCourse(){
        Modele.connexion();
        ArrayList <ConstrCourse> listeConstrCourse;
        listeConstrCourse = new ArrayList<ConstrCourse>();
        try {
            rs = st.executeQuery("SELECT * FROM course, circuit WHERE course.idCircuit = circuit.idCircuit;");
            while (rs.next()) {
                String nomCourse = rs.getString("nomCourse");
                String typeCourse = rs.getString("typeCourse");
                int nbSpectateurs = rs.getInt("nbSpectateur");
                String nomCircuit = rs.getString("nomCircuit");
                String tailleCircuit = rs.getString("tailleCircuit"); 
                String paysCircuit = rs.getString("paysCircuit");
                ConstrCircuit monCircuit = new ConstrCircuit(nomCircuit, tailleCircuit, paysCircuit);
                listeConstrCourse.add(new ConstrCourse(nomCourse, typeCourse, nbSpectateurs, monCircuit));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return listeConstrCourse;
    }
	
	/**
	 * Méthode pour pouvoir afficher les circuits
	 * @return
	 */
	public static ArrayList<ConstrCircuit> affichageCircuit(){
        Modele.connexion();
        ArrayList <ConstrCircuit> listeConstrCircuit;
        listeConstrCircuit = new ArrayList<ConstrCircuit>();
        try {
            rs = st.executeQuery("SELECT * FROM circuit");
            while (rs.next()) {
                String nomCircuit = rs.getString(1);
                String tailleCircuit = rs.getString(2);
                String paysCircuit = rs.getString(3);
                listeConstrCircuit.add(new ConstrCircuit(nomCircuit, tailleCircuit, paysCircuit));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return listeConstrCircuit;
    }
	
	/**
	 * Méthode pour pouvoir afficher les ecuries
	 * @return
	 */
	public static ArrayList<ConstrEcurie> affichageEcurie(){
        Modele.connexion();
        ArrayList <ConstrEcurie> listeConstrEcurie;
        listeConstrEcurie = new ArrayList<ConstrEcurie>();
        try {
            rs = st.executeQuery("SELECT * FROM ecurie");
            while (rs.next()) {
                String nomEcurie = rs.getString(1);
                String sponsorEcurie = rs.getString(2);
                String motoristeEcurie = rs.getString(3);
                listeConstrEcurie.add(new ConstrEcurie(nomEcurie, sponsorEcurie, motoristeEcurie));
            }
        } catch (Exception e) {
        }
        return listeConstrEcurie;
    }
	
	/**
	 * Méthode pour pouvoir afficher les personnels
	 * @return
	 */
	public static ArrayList<ConstrPersonnel> affichagePersonnel(){
        Modele.connexion();
        ArrayList <ConstrPersonnel> listeConstrPersonnel;
        listeConstrPersonnel = new ArrayList<ConstrPersonnel>();
        try {
            rs = st.executeQuery("SELECT * FROM personnel");
            while (rs.next()) {
                String nomPersonnel = rs.getString(1);
                String prenomPersonnel = rs.getString(2);
                String adressePersonnel = rs.getString(3);
                String villePersonnel = rs.getString(4);
                String cpPersonnel = rs.getString(5);
                listeConstrPersonnel.add(new ConstrPersonnel(nomPersonnel, prenomPersonnel, adressePersonnel, villePersonnel, cpPersonnel));
            }
        } catch (Exception e) {
            //TODO: handle exception
        }
        return listeConstrPersonnel;
    }
	
	/**
	 * Méthode pour supprimer un circuit
	 * @param unNom
	 * @return
	 */
	public static boolean suppressionCircuit(String unNom) {
        Modele.connexion();
        boolean rep; 
        int nbLogin;
        rep = false;
        nbLogin = 0;
        int count;
        try {
            //Requête préparé
            statement = connexion.prepareStatement( "DELETE FROM circuit WHERE nomCircuit = ?");
            statement.setString(1, unNom);
            count = statement.executeUpdate();
            if (count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur de suppression");
        }
        return rep;
    }
	
	/**
	 * Méthode pour supprimer une course
	 * @param unNom
	 * @return
	 */
	public static boolean suppressionCourse(String unNom) {
        Modele.connexion();
        boolean rep; 
        int nbLogin;
        rep = false;
        nbLogin = 0;
        int count;
        try {
            //Requête préparé
            statement = connexion.prepareStatement( "DELETE FROM course WHERE nomCourse = ?");
            statement.setString(1, unNom);
            count = statement.executeUpdate();
            if (count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur de suppression");
        }
        return rep;
    }
	
	/**
	 * Méthode pour supprimer une ecurie
	 * @param unNom
	 * @return
	 */
	public static boolean suppressionEcurie(String unNom) {
        Modele.connexion();
        boolean rep; 
        int nbLogin;
        rep = false;
        nbLogin = 0;
        int count;
        try {
            //Requête préparé
            statement = connexion.prepareStatement( "DELETE FROM ecurie WHERE nomEcurie = ?");
            statement.setString(1, unNom);
            count = statement.executeUpdate();
            if (count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur de suppression");
        }
        return rep;
    }
	
	/**
	 * Méthode pour supprimer un personnel
	 * @param unNom
	 * @return
	 */
	public static boolean suppressionPersonnel(String unNom, String unPrenom) {
        Modele.connexion();
        boolean rep; 
        int nbLogin;
        rep = false;
        nbLogin = 0;
        int count;
        try {
            //Requête préparé
            statement = connexion.prepareStatement( "DELETE FROM personnel WHERE nomPersonnel = ? AND prenomPersonnel = ?");
            statement.setString(1, unNom);
            statement.setString(2, unPrenom);
            count = statement.executeUpdate();
            if (count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur de suppression");
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir rechercher un circuit à l'aide du nom
	 * @param unNom
	 * @return
	 */
	public static boolean rechercherCircuit(String unNom) {
        Modele.connexion();
        boolean rep = false;
        int count = 0;
        try {
        	statement = connexion.prepareStatement("SELECT COUNT(*) AS count FROM circuit WHERE nomCircuit = ?");
        	statement.setString(1, unNom);
			rs = statement.executeQuery();
            while(rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();
            if(count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur.");
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir rechercher une course à l'aide du nom
	 * @param unNom
	 * @return
	 */
	public static boolean rechercherCourse(String unNom) {
        Modele.connexion();
        boolean rep = false;
        int count = 0;
        try {
        	statement = connexion.prepareStatement("SELECT COUNT(*) AS count FROM course WHERE nomCourse = ?");
        	statement.setString(1, unNom);
			rs = statement.executeQuery();
            while(rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();
            if(count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur.");
        }
        return rep;
    }

	/**
	 * Méthode pour pouvoir rechercher une ecurie à l'aide du nom
	 * @param unNom
	 * @return
	 */
	public static boolean rechercherEcurie(String unNom) {
        Modele.connexion();
        boolean rep = false;
        int count = 0;
        try {
        	statement = connexion.prepareStatement("SELECT COUNT(*) AS count FROM ecurie WHERE nomEcurie = ?");
        	statement.setString(1, unNom);
			rs = statement.executeQuery();
            while(rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();
            if(count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur.");
        }
        return rep;
    }
	
	/**
	 * Méthode pour pouvoir rechercher un personnel à l'aide du nom
	 * @param unNom
	 * @return
	 */
	public static boolean rechercherPersonnel(String unNom) {
        Modele.connexion();
        boolean rep = false;
        int count = 0;
        try {
        	statement = connexion.prepareStatement("SELECT COUNT(*) AS count FROM personnel WHERE nomPersonnel = ?");
        	statement.setString(1, unNom);
			rs = statement.executeQuery();
            while(rs.next()) {
                count = rs.getInt("count");
            }
            rs.close();
            if(count == 1) {
                rep = true;
            }
        } catch (SQLException erreur) {
            System.out.println("Erreur.");
        }
        return rep;
    }
}