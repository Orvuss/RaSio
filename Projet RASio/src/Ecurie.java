import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
/**
 * Classe Ecurie
 * @author ldatchi
 *
 */
public class Ecurie extends JFrame implements ActionListener{

	/**
	 * Attributs privés de la classe Course
	 */
	//Attributs privés
	//Panel
	private JPanel panelEcurie;
	private JPanel panelMessage;
	private JPanel panelBtnQuitter;
	
	//Jmenu
	private JMenu jmMenu;
	
	//JMenuBar
	private JMenuBar jmbBarre;
	
	//JmenuItem
	private JMenuItem jmiAjouter;
	private JMenuItem jmiAffichage;
	private JMenuItem jmiSupprimer;
	private JMenuItem jmiRechercher;
	private JMenuItem jmiQuitter;
	private JMenuItem jmiAffichageCSV;
	
	//Label
	private JLabel lblMessage;

	//Bouton
	private JButton btnQuitter;
	
	//Constructeur
	public Ecurie() {
		//Configuration
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
		 */
	    this.setTitle("Ecurie");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(false);
	    
	    /**
	     * Instanciation de mes panels "panelEcurie", "panelMessage" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelEcurie = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelBtnQuitter = new JPanel();

	    /**
	     * Mise en place des background des panels "panelEcurie", "panelMessage" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelEcurie.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelBtnQuitter.setBackground(Color.black);

	    /**
	     * Mise en place des dispositions des panels "panelEcurie", "panelMessage" et "panelBtnQuitter"
	     */
	    //Disposition des panels
	    this.panelEcurie.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelBtnQuitter.setLayout(new FlowLayout());

	    /**
	     * Instanciation du tableau avec l'option ajouter, afficher, supprimer et rechercher
	     */
	    //Instanciation 
	    this.jmMenu = new JMenu("Ecurie");
	    //Instanciation JMenuBar
	    this.jmbBarre = new JMenuBar();
	    //Instanciation des éléments JMenuItem
	    this.jmiAjouter = new JMenuItem("Ajouter");
	    this.jmiAjouter.addActionListener(this);
	    this.jmiAffichage = new JMenuItem("Afficher");
	    this.jmiAffichage.addActionListener(this);
	    this.jmiSupprimer = new JMenuItem("Supprimer");
	    this.jmiSupprimer.addActionListener(this);
	    this.jmiRechercher = new JMenuItem("Rechercher");
	    this.jmiRechercher.addActionListener(this);
	    this.jmiAffichageCSV = new JMenuItem("Affichage CSV");
	    this.jmiAffichageCSV.addActionListener(this);
	    this.jmiQuitter = new JMenuItem("Quitter");
	    this.jmiQuitter.addActionListener(this);
	    
	    /**
	     * Ajout des boutons au menu
	     */
	    //Ajout des boutons au menu
	    this.jmMenu.add(jmiAjouter);
	    this.jmMenu.add(jmiAffichage);
	    this.jmMenu.add(jmiSupprimer);
	    this.jmMenu.add(jmiRechercher);
	    this.jmMenu.add(jmiAffichageCSV);
	    this.jmMenu.add(jmiQuitter);
	    //Ajout du JMenu à la barre
	    this.jmbBarre.add(jmMenu);
	    this.setJMenuBar(jmbBarre);
	    
	    /**
	     * Instanciation du label "lblMessage"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez choisir une option.");
	    
	    /**
	     * Mise en place de la couleur d'écriture du label "lblMessage"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);
	   
	    /**
	     * Instanciation du bouton "btnQuitter"
	     */
	    //Instanciation des boutons
	    this.btnQuitter = new JButton("Quitter");
	    this.btnQuitter.addActionListener(this);
	    
	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelEcurie.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelEcurie.add(panelBtnQuitter, BorderLayout.PAGE_END);

	    this.panelMessage.add(lblMessage);
	    
	    this.panelBtnQuitter.add(btnQuitter);

	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelEcurie);
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelEcurie() {
    	return panelEcurie;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(jmiAjouter)) {
			this.panelEcurie.removeAll();
			this.panelEcurie.add(new AjoutEcurie().getMonPanelEcurieAjout());
			this.panelEcurie.revalidate();
			this.panelEcurie.repaint();
		}
		if(e.getSource().equals(jmiAffichage)) {
			ArrayList<ConstrEcurie> listeConstrEcurie;
			listeConstrEcurie = new ArrayList<ConstrEcurie>();
			listeConstrEcurie = Modele.affichageEcurie();
			this.panelEcurie.removeAll();
			this.panelEcurie.add(new AffichageEcurie(listeConstrEcurie).getMonPanelEcurieAffichage());
			this.panelEcurie.revalidate();
			this.panelEcurie.repaint();
		}
		if(e.getSource().equals(jmiSupprimer)) {
			this.panelEcurie.removeAll();
			this.panelEcurie.add(new SupprimerEcurie().getMonPanelEcurieSupprimer());
			this.panelEcurie.revalidate();
			this.panelEcurie.repaint();
		}
		if(e.getSource().equals(jmiRechercher)) {
			this.panelEcurie.removeAll();
			this.panelEcurie.add(new RechercherEcurie().getMonPanelEcurieRechercher());
			this.panelEcurie.revalidate();
			this.panelEcurie.repaint();
		}
		if(e.getSource().equals(jmiAffichageCSV)) {
			ArrayList<ConstrEcurie> lesEcuries;
			lesEcuries = new ArrayList<ConstrEcurie>();
			lesEcuries = Modele.affichageEcurie();
			this.panelEcurie.removeAll();
			this.panelEcurie.add(new AffichageEcurieCSV(lesEcuries).getMonPanelEcurieCSV());
			this.panelEcurie.revalidate();
			this.panelEcurie.repaint();
		}
		if(e.getSource() == jmiQuitter) {
			this.dispose();
			Accueil monAccueil = new Accueil();		
		}
		if(e.getSource() == btnQuitter) {
			this.dispose();
			Accueil monAccueil = new Accueil();		
		}
	}


}
