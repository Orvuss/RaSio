import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * Classe Connexion
 * @author ldatchi
 *
 */
public class Connexion extends JFrame implements ActionListener{
	
	/**
	 * Attributs privés de la classe Connexion
	 */
	//Attributs privés
	//Panel
	private JPanel panelConnexion;
	private JPanel panelMessageAccueil;
	private JPanel panelChamps;
	private JPanel panelBouton;
	
	//Message
	private JLabel lblAccueil;
	private JLabel lblLogin;
	private JLabel lblMotDePasse;
	
	//Entrées de texte
	private JTextField jtfLogin;
	private JPasswordField jtfMotDePasse;
	
	//Bouton
	private JButton boutonConnexion;
	
	//Constructeur
	public Connexion() {
		//Configuration fenetre
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
		 */
	    this.setTitle("RaSio");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(false);
	    /**
	     * Instanciation de mes panels "panelConnexion", "panelMessageAccueil", "panelChamps" et "panelBouton"
	     */
	    //Instanciation des panels
	    this.panelConnexion = new JPanel();
	    this.panelMessageAccueil = new JPanel();
	    this.panelChamps = new JPanel();
	    this.panelBouton = new JPanel();
	    
	    /**
	     * Mise en place des background des panels "panelConnexion", "panelMessageAccueil", "panelChamps" et "panelBouton"
	     */
	    //Disposition des panels
	    this.panelConnexion.setLayout(new BorderLayout());
	    this.panelMessageAccueil.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());
	    this.panelBouton.setLayout(new FlowLayout()); 
	    
	    /**
	     * Mise en place des dispositions des panels "panelMessageAccueil" et "panelBouton"
	     */
	    //Background des panels
	    this.panelMessageAccueil.setBackground(Color.black);
	    this.panelBouton.setBackground(Color.black);
	    
	    /**
	     * Mise en place des dispositions des panels "lblAccueil", "lblLogin" et "lblMotDePasse"
	     */
	    //Instanciation des labels
	    this.lblAccueil = new JLabel("Bienvenue, veuillez vous connecter");
	    this.lblLogin = new JLabel("Login : ");
	    this.lblMotDePasse = new JLabel("Mot de passe : ");
	    
	    /**
	     * Mise en place de la couleur d'écriture du label "lblAccueil"
	     */
	    //Couleur de la police
	    this.lblAccueil.setForeground(Color.white);
	    
	    /**
	     * Instanciation des entrées "jtfLogin" et "jtfMotDePasse"
	     */
	    //Instanciation des entrées de texte
	    this.jtfLogin = new JTextField("");
	    this.jtfLogin.setPreferredSize(new Dimension(150, 25));
	    this.jtfMotDePasse = new JPasswordField("");
	    this.jtfMotDePasse.setPreferredSize(new Dimension(150, 25));
	    
	    /**
         * Instanciation du bouton "boutonConnexion"
         */
	    //Instanciation des boutons
	    this.boutonConnexion = new JButton("Connexion");
	    this.boutonConnexion.addActionListener(this);
	    
	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelConnexion.add(panelMessageAccueil, BorderLayout.PAGE_START);
	    this.panelMessageAccueil.add(lblAccueil);
	    
	    this.panelConnexion.add(panelChamps);
	    this.panelChamps.add(lblLogin); 
	    this.panelChamps.add(jtfLogin);
	    this.panelChamps.add(lblMotDePasse);
	    this.panelChamps.add(jtfMotDePasse);
	    
	    this.panelConnexion.add(panelBouton, BorderLayout.SOUTH);
	    this.panelBouton.add(boutonConnexion);
	    
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
	    this.getRootPane().setDefaultButton(boutonConnexion);
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelConnexion);
  		this.setVisible(true);
	}
	/**
	 * Action performed permettant la connexion à l'utilisateur
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boutonConnexion) {
			String login = jtfLogin.getText();
			String mdp = jtfMotDePasse.getText();
			JLabel lblMessage = new JLabel("Erreur de connexion");
		    lblMessage.setForeground(Color.white);
			if(Modele.connexionUtilisateur(login, mdp)) {
				this.panelMessageAccueil.remove(lblAccueil);
				this.dispose();
				Accueil monAccueil = new Accueil();
			}
//			String regex = "^[^0-9](?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[{@#$%^+=}]).{5,9}$";
//			boolean b = Pattern.matches(regex, mdp);
//			System.out.println(b);
			this.panelMessageAccueil.removeAll();
			this.panelMessageAccueil.add(lblMessage);
			this.panelMessageAccueil.revalidate();
			this.panelMessageAccueil.repaint();
		}
	}
}