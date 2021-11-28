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
 * Classe Personnel
 * @author ldatchi
 *
 */
public class Personnel extends JFrame implements ActionListener{

	/**
	 * Attributs privés de la classe Personnel
	 */
	//Attributs privés
	//Panel
	private JPanel panelPersonnel;
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
	private JMenuItem jmiAffichageJSON;
	
	//Label
	private JLabel lblMessage;

	//Bouton
	private JButton btnQuitter;
	
	//Constructeur
	public Personnel() {
		//Configuration
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
		 */
	    this.setTitle("Personnel");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(false);
	    
	    /**
	     * Instanciation de mes panels "panelPersonnel", "panelMessage" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelPersonnel = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelBtnQuitter = new JPanel();

	    /**
	     * Mise en place des background des panels "panelPersonnel", "panelMessage" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelPersonnel.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelBtnQuitter.setBackground(Color.black);

	    /**
	     * Mise en place des dispositions des panels "panelPersonnel", "panelMessage" et "panelBtnQuitter"
	     */
	    //Disposition des panels
	    this.panelPersonnel.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelBtnQuitter.setLayout(new FlowLayout());

	    /**
	     * Instanciation du tableau avec l'option ajouter, afficher, supprimer et rechercher
	     */
	    //Instanciation 
	    this.jmMenu = new JMenu("Personnel");
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
	    this.jmiAffichageJSON = new JMenuItem("Affichage JSON");
	    this.jmiAffichageJSON.addActionListener(this);
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
	    this.jmMenu.add(jmiAffichageJSON);
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
	    this.panelPersonnel.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelPersonnel.add(panelBtnQuitter, BorderLayout.PAGE_END);

	    this.panelMessage.add(lblMessage);
	    
	    this.panelBtnQuitter.add(btnQuitter);

	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelPersonnel);
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelPersonnel() {
    	return panelPersonnel;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(jmiAjouter)) {
			this.panelPersonnel.removeAll();
			this.panelPersonnel.add(new AjoutPersonnel().getMonPanelPersonnelAjout());
			this.panelPersonnel.revalidate();
			this.panelPersonnel.repaint();
		}
		if(e.getSource().equals(jmiAffichage)) {
			ArrayList<ConstrPersonnel> listeConstrPersonnel;
			listeConstrPersonnel = new ArrayList<ConstrPersonnel>();
			listeConstrPersonnel = Modele.affichagePersonnel();
			this.panelPersonnel.removeAll();
			this.panelPersonnel.add(new AffichagePersonnel(listeConstrPersonnel).getMonPanelPersonnelAffichage());
			this.panelPersonnel.revalidate();
			this.panelPersonnel.repaint();
		}
		if(e.getSource().equals(jmiSupprimer)) {
			this.panelPersonnel.removeAll();
			this.panelPersonnel.add(new SupprimerPersonnel().getMonPanelPersonnelSupprimer());
			this.panelPersonnel.revalidate();
			this.panelPersonnel.repaint();
		}
		if(e.getSource().equals(jmiRechercher)) {
			this.panelPersonnel.removeAll();
			this.panelPersonnel.add(new RechercherPersonnel().getMonPanelPersonnelRechercher());
			this.panelPersonnel.revalidate();
			this.panelPersonnel.repaint();
		}
		if(e.getSource().equals(jmiAffichageJSON)) {
			ArrayList<ConstrPersonnel> lesPersonnels;
			lesPersonnels = new ArrayList<ConstrPersonnel>();
			lesPersonnels = Modele.affichagePersonnel();
			this.panelPersonnel.removeAll();
			this.panelPersonnel.add(new AffichagePersonnelJSON(lesPersonnels).getMonPanelPersonnelJson());
			this.panelPersonnel.revalidate();
			this.panelPersonnel.repaint();
		}
		if(e.getSource() == btnQuitter) {
			this.dispose();
			Accueil monAccueil = new Accueil();
		}
		if(e.getSource() == jmiQuitter) {
			this.dispose();
			Accueil monAccueil = new Accueil();
		}
	}


}
