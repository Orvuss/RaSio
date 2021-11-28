import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.ArrayList;
/**
 * Classe AffichageEcurieCSV
 * @author ldatchi
 *
 */
public class AffichageEcurieCSV extends JFrame implements ActionListener {
	/**
     * Attributs privés de la classe AffichageEcurieCSV
     */
    //Attributs privés
    //Panel
    private JPanel panelEcurieCSV;
    private JPanel panelMessage;
    private JPanel panelBtnQuitter;
    
    //Label
    private JLabel lblMessage;
    
    //TextArea
    private TextArea taAffichage;
      
    //Constructeur
    public AffichageEcurieCSV(ArrayList<ConstrEcurie> uneListeEcurie) {
        
    	ArrayList<ConstrEcurie> lesEcuries = Modele.affichageEcurie();        
        /**
         * Instanciation de mes panels "panelEcurieCSV", "panelMessage", "panelTableau" et "panelBtnQuitter"
         */
        //Instanciation des panels
        this.panelEcurieCSV = new JPanel();
        this.panelMessage = new JPanel();
        this.panelBtnQuitter = new JPanel();
        
        /**
         * Mise en place des background des panels "panelEcurieCSV", "panelMessage", "panelTableau" et "panelBtnQuitter"
         */
        //Background des panels
        this.panelEcurieCSV.setBackground(Color.white);
        this.panelMessage.setBackground(Color.black);
        this.panelBtnQuitter.setBackground(Color.black);

        /**
         * Mise en place des dispositions des panels "panelEcurieCSV", "panelMessage", "panelTableau" et "panelBtnQuitter"
         */
        //Disposition des panels
        this.panelEcurieCSV.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelBtnQuitter.setLayout(new FlowLayout());
        
        /**
	     * Instanciation du label "lblMessage"
	     */
        //Instanciation des messages
	    this.lblMessage = new JLabel("Affichage du CSV des écuries.");
	    
	    /**
	     * Mise en place de la couleur d'écriture du label "lblMessage"
	     */
	 	//Couleur de la police
	    this.lblMessage.setForeground(Color.white);
      
        /**
         * Création du tableau pour afficher les éléments dans le tableau
         */
        //Tableau
        String resultat = "";    
        int i = 0;
        //Boucle foreach qui parcours la collection et ajoute chaque élement au précédent en utilisant la méthode toXML
        for (ConstrEcurie uneEcurie : lesEcuries) {
            resultat += uneEcurie.toCSV();
        }   
        this.taAffichage = new TextArea(resultat);

        /**
         * Ajout des attributs à mes panels
         */
        //Ajout des attributs aux panels
        this.panelEcurieCSV.add(panelMessage, BorderLayout.PAGE_START);
        this.panelEcurieCSV.add(panelBtnQuitter, BorderLayout.PAGE_END);
        
        this.panelMessage.add(lblMessage);
        
        this.panelEcurieCSV.add(taAffichage);

        //Toujours à la fin
        /**
         * Rendu visible de l'app etc.. toujours à la fin de la classe
         */
        this.setAlwaysOnTop(true);
        this.getContentPane().add(panelEcurieCSV);
    }

    /**
     * Permet de retourner le panel circuit pour l'affichage
     * @return
     */
    public JPanel getMonPanelEcurieCSV() {
        return panelEcurieCSV;
    }
    /**
     * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
     */
    public void actionPerformed(ActionEvent e) {
        
    }   
}