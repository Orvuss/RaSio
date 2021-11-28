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
 * Classe Circuit
 * @author ldatchi
 *
 */
public class Circuit extends JFrame implements ActionListener{

	/**
	 * Attributs privés de la classe Circuit
	 */
	//Attributs privés
	//Panel
	private JPanel panelCircuit;
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
	
	//Label
	private JLabel lblMessage;

	//Bouton
	private JButton btnQuitter;
	
	//Constructeur
	public Circuit() {
		//Configuration
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
		 */
	    this.setTitle("Circuit");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(false);
	    
	    /**
	     * Instanciation de mes panels "panelCircuit", "panelMessage" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelCircuit = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelBtnQuitter = new JPanel();

	    /**
	     * Mise en place des background des panels "panelCircuit", "panelMessage" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelCircuit.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelBtnQuitter.setBackground(Color.black);

	    /**
	     * Mise en place des dispositions des panels "panelCircuit", "panelMessage" et "panelBtnQuitter"
	     */
	    //Disposition des panels
	    this.panelCircuit.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelBtnQuitter.setLayout(new FlowLayout());

	    /**
	     * Instanciation du tableau avec l'option ajouter, afficher, supprimer et rechercher
	     */
	    //Instanciation 
	    this.jmMenu = new JMenu("Circuit");
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
	    this.panelCircuit.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelCircuit.add(panelBtnQuitter, BorderLayout.PAGE_END);

	    this.panelMessage.add(lblMessage);
	    
	    this.panelBtnQuitter.add(btnQuitter);

	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelCircuit);
  		this.setVisible(true);
	}

	public JPanel getMonPanelCircuit() {
    	return panelCircuit;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(jmiAjouter)) {
			this.panelCircuit.removeAll();
			this.panelCircuit.add(new AjoutCircuit().getMonPanelCircuitAjout());
			this.panelCircuit.revalidate();
			this.panelCircuit.repaint();
		}
		if(e.getSource().equals(jmiAffichage)) {
			ArrayList<ConstrCircuit> listeConstrCircuit;
			listeConstrCircuit = new ArrayList<ConstrCircuit>();
			listeConstrCircuit = Modele.affichageCircuit();
			this.panelCircuit.removeAll();
			this.panelCircuit.add(new AffichageCircuit(listeConstrCircuit).getMonPanelCircuitAffichage());
			this.panelCircuit.revalidate();
			this.panelCircuit.repaint();
		}
		if(e.getSource() == jmiSupprimer) {
			this.panelCircuit.removeAll();
			this.panelCircuit.add(new SupprimerCircuit().getMonPanelCircuitSupprimer());
			this.panelCircuit.revalidate();
			this.panelCircuit.repaint();
		}
		if(e.getSource() == jmiRechercher) {
			this.panelCircuit.removeAll();
			this.panelCircuit.add(new RechercherCircuit().getMonPanelCircuitRechercher());
			this.panelCircuit.revalidate();
			this.panelCircuit.repaint();
		}
		if(e.getSource() == jmiQuitter) {
			this.dispose();
			Circuit monCircuit = new Circuit();
		}
		if(e.getSource() == btnQuitter) {
			this.dispose();
			Accueil monAccueil = new Accueil();
		}
	}


}
