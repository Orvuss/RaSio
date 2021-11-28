import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe Accueil
 * @author ldatchi
 *
 */
public class Accueil extends JFrame implements ActionListener{

	/**
	 * Attributs privés de la classe Accueil
	 */
	//Attributs privés
	//Panel
	private JPanel panelAccueil;
	private JPanel panelBouton;
	private JPanel panelBtnQuitter;
	
	//Bouton
	private JButton btnEcurie;
	private JButton btnCourse;
	private JButton btnCircuit;
	private JButton btnPersonnel;
	private JButton btnQuitter;
	
	//Constructeur
	public Accueil() {
		//Configuration fenetre
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
		 */
	    this.setTitle("Accueil");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(false);
	    /**
	     * Instanciation de mes panels "panelAccueil", "panelBouton" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelAccueil = new JPanel();
	    this.panelBouton = new JPanel();
	    this.panelBtnQuitter = new JPanel();
	    
	    /**
	     * Mise en place des background des panels "panelAccueil", "panelBouton" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelAccueil.setBackground(Color.white);
	    this.panelBouton.setBackground(Color.black);
	    this.panelBtnQuitter.setBackground(Color.black);
	    
	    /**
	     * Mise en place des dispositions des panels "panelAccueil", "panelBouton" et "panelBtnQuitter"
	     */
	    //Disposition des panels
	    this.panelAccueil.setLayout(new BorderLayout());
	    this.panelBouton.setLayout(new FlowLayout());
	    this.panelBtnQuitter.setLayout(new FlowLayout());
	    
	    /**
	     * Instanciation de mes boutons "btnEcurie", "btnCourse", "btnCircuit", "btnPersonnel" et "btnQuitter"
	     * avec l'écoute des boutons
	     */
	    //Instanciation des boutons
	    this.btnEcurie = new JButton("Ecurie");
	    this.btnEcurie.addActionListener(this);
	    
	    this.btnCourse = new JButton("Course");
	    this.btnCourse.addActionListener(this);
	    
	    this.btnCircuit = new JButton("Circuit");
	    this.btnCircuit.addActionListener(this);
	    
	    this.btnPersonnel = new JButton("Personnel");
	    this.btnPersonnel.addActionListener(this);
	    
	    this.btnQuitter = new JButton("Quitter");
	    this.btnQuitter.addActionListener(this);

	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelAccueil.add(panelBouton, BorderLayout.PAGE_START);
	    this.panelAccueil.add(panelBtnQuitter, BorderLayout.PAGE_END);
	    
	    this.panelBouton.add(btnEcurie);
	    this.panelBouton.add(btnCourse);
	    this.panelBouton.add(btnCircuit);
	    this.panelBouton.add(btnPersonnel);
	    
	    this.panelBtnQuitter.add(btnQuitter);
	    
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
	    this.setAlwaysOnTop(true);
	    this.getContentPane().add(panelAccueil);
  		this.setVisible(true);
	}	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnEcurie) {
			this.dispose();
			Ecurie monEcurie = new Ecurie();
		}
		if(e.getSource() == btnCourse) {
			this.dispose();
			Course maCourse = new Course();
		}
		if(e.getSource() == btnCircuit) {
			this.dispose();
			Circuit monCircuit = new Circuit();
		}
		if(e.getSource() == btnPersonnel) {
			this.dispose();
			Personnel monPersonnel = new Personnel();
		}
		if(e.getSource() == btnQuitter) {
			this.dispose();
		}
	}
}