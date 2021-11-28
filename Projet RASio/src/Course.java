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
 * Classe Course
 * @author ldatchi
 *
 */
public class Course extends JFrame implements ActionListener{

	/**
	 * Attributs privés de la classe Course
	 */
	//Attributs privés
	//Panel
	private JPanel panelCourse;
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
	private JMenuItem jmiAffichageXML;
	private JMenuItem jmiQuitter;
	
	//Label
	private JLabel lblMessage;

	//Bouton
	private JButton btnQuitter;
	
	//Constructeur
	public Course() {
		//Configuration
		/**
		 * Titre, localisation, taille etc.. indispensable au début de chaque page IHM
		 */
	    this.setTitle("Course");
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setSize(700, 500);
	    this.setResizable(false);
	    
	    /**
	     * Instanciation de mes panels "panelCourse", "panelMessage" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelCourse = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelBtnQuitter = new JPanel();

	    /**
	     * Mise en place des background des panels "panelCourse", "panelMessage" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelCourse.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelBtnQuitter.setBackground(Color.black);

	    /**
	     * Mise en place des dispositions des panels "panelCourse", "panelMessage" et "panelBtnQuitter"
	     */
	    //Disposition des panels
	    this.panelCourse.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelBtnQuitter.setLayout(new FlowLayout());

	    /**
	     * Instanciation du tableau avec l'option ajouter, afficher, supprimer et rechercher
	     */
	    //Instanciation 
	    this.jmMenu = new JMenu("Course");
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
	    this.jmiAffichageXML = new JMenuItem("Affichage XML");
	    this.jmiAffichageXML.addActionListener(this);
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
	    this.jmMenu.add(jmiAffichageXML);
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
	    this.panelCourse.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelCourse.add(panelBtnQuitter, BorderLayout.PAGE_END);

	    this.panelMessage.add(lblMessage);
	    
	    this.panelBtnQuitter.add(btnQuitter);

	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setAlwaysOnTop(true);
  		this.getContentPane().add(panelCourse);
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelCourse() {
    	return panelCourse;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(jmiAjouter)) {
			this.panelCourse.removeAll();
			this.panelCourse.add(new AjoutCourse().getMonPanelCourseAjout());
			this.panelCourse.revalidate();
			this.panelCourse.repaint();
		}
		if(e.getSource().equals(jmiAffichage)) {
			ArrayList<ConstrCourse> listeConstrCourse;
			listeConstrCourse = new ArrayList<ConstrCourse>();
			listeConstrCourse = Modele.affichageCourse();
			this.panelCourse.removeAll();
			this.panelCourse.add(new AffichageCourse(listeConstrCourse).getMonPanelCourseAffichage());
			this.panelCourse.revalidate();
			this.panelCourse.repaint();
		}
		if(e.getSource().equals(jmiSupprimer)) {
			this.panelCourse.removeAll();
			this.panelCourse.add(new SupprimerCourse().getMonPanelCourseSupprimer());
			this.panelCourse.revalidate();
			this.panelCourse.repaint();
		}
		if(e.getSource().equals(jmiRechercher)) {
			this.panelCourse.removeAll();
			this.panelCourse.add(new RechercherCourse().getMonPanelCourseRechercher());
			this.panelCourse.revalidate();
			this.panelCourse.repaint();
		}
		if(e.getSource().equals(jmiAffichageXML)) {
			ArrayList<ConstrCourse> lesCourses;
			lesCourses = new ArrayList<ConstrCourse>();
			lesCourses = Modele.affichageCourse();
			this.panelCourse.removeAll();
			this.panelCourse.add(new AffichageCourseXML(lesCourses).getMonPanelCourseXML());
			this.panelCourse.revalidate();
			this.panelCourse.repaint();
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
