import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.ArrayList;
/**
 * Classe AffichagePersonnelJSON
 * @author ldatchi
 *
 */
public class AffichagePersonnelJSON extends JFrame implements ActionListener {
	/**
     * Attributs privés de la classe AffichagePersonnelJSON
     */
    //Attributs privés
    //Panel
    private JPanel panelPersonnelJson;
    private JPanel panelMessage;
    private JPanel panelBtnQuitter;
    
    //Label
    private JLabel lblMessage;
    
    //TextArea
    private TextArea taAffichage;
      
    //Constructeur
    public AffichagePersonnelJSON(ArrayList<ConstrPersonnel> uneListePersonnel) {
        
    	ArrayList<ConstrPersonnel> lesPersonnels = Modele.affichagePersonnel();        
        /**
         * Instanciation de mes panels "panelPersonnelJson", "panelMessage", "panelTableau" et "panelBtnQuitter"
         */
        //Instanciation des panels
        this.panelPersonnelJson = new JPanel();
        this.panelMessage = new JPanel();
        this.panelBtnQuitter = new JPanel();
        
        /**
         * Mise en place des background des panels "panelPersonnelJson", "panelMessage", "panelTableau" et "panelBtnQuitter"
         */
        //Background des panels
        this.panelPersonnelJson.setBackground(Color.white);
        this.panelMessage.setBackground(Color.black);
        this.panelBtnQuitter.setBackground(Color.black);

        /**
         * Mise en place des dispositions des panels "panelPersonnelJson", "panelMessage", "panelTableau" et "panelBtnQuitter"
         */
        //Disposition des panels
        this.panelPersonnelJson.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelBtnQuitter.setLayout(new FlowLayout());
        
        /**
	     * Instanciation du label "lblMessage"
	     */
        //Instanciation des messages
	    this.lblMessage = new JLabel("Affichage du JSON des personnels.");
	    
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
        resultat += "[";
        int i = 0;
        //Boucle foreach qui parcours la collection et ajoute chaque élement au précédent en utilisant la méthode toXML
        for (ConstrPersonnel unPersonnel : lesPersonnels) {
            resultat += unPersonnel.toJSON();
        }   
        resultat += "\n]";
        this.taAffichage = new TextArea(resultat);

        /**
         * Ajout des attributs à mes panels
         */
        //Ajout des attributs aux panels
        this.panelPersonnelJson.add(panelMessage, BorderLayout.PAGE_START);
        this.panelPersonnelJson.add(panelBtnQuitter, BorderLayout.PAGE_END);
        
        this.panelMessage.add(lblMessage);
        
        this.panelPersonnelJson.add(taAffichage);

        //Toujours à la fin
        /**
         * Rendu visible de l'app etc.. toujours à la fin de la classe
         */
        this.setAlwaysOnTop(true);
        this.getContentPane().add(panelPersonnelJson);
    }

    /**
     * Permet de retourner le panel circuit pour l'affichage
     * @return
     */
    public JPanel getMonPanelPersonnelJson() {
        return panelPersonnelJson;
    }
    /**
     * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
     */
    public void actionPerformed(ActionEvent e) {
        
    }   
}