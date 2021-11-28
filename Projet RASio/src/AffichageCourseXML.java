import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.ArrayList;
/**
 * Classe AffichageCourseXML
 * @author ldatchi
 *
 */
public class AffichageCourseXML extends JFrame implements ActionListener {
	/**
     * Attributs priv�s de la classe AffichageCourseXML
     */
    //Attributs priv�s
    //Panel
    private JPanel panelCourseXML;
    private JPanel panelMessage;
    private JPanel panelBtnQuitter;
    
    //Label
    private JLabel lblMessage;
    
    //TextArea
    private TextArea taAffichage;
      
    //Constructeur
    public AffichageCourseXML(ArrayList<ConstrCourse> uneListeCourse) {
        
    	ArrayList<ConstrCourse> lesCourses = Modele.affichageCourse();        
        /**
         * Instanciation de mes panels "panelCourseXML", "panelMessage", "panelTableau" et "panelBtnQuitter"
         */
        //Instanciation des panels
        this.panelCourseXML = new JPanel();
        this.panelMessage = new JPanel();
        this.panelBtnQuitter = new JPanel();
        
        /**
         * Mise en place des background des panels "panelCourseXML", "panelMessage", "panelTableau" et "panelBtnQuitter"
         */
        //Background des panels
        this.panelCourseXML.setBackground(Color.white);
        this.panelMessage.setBackground(Color.black);
        this.panelBtnQuitter.setBackground(Color.black);

        /**
         * Mise en place des dispositions des panels "panelCourseXML", "panelMessage", "panelTableau" et "panelBtnQuitter"
         */
        //Disposition des panels
        this.panelCourseXML.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelBtnQuitter.setLayout(new FlowLayout());
        
        /**
	     * Instanciation du label "lblMessage"
	     */
        //Instanciation des messages
	    this.lblMessage = new JLabel("Affichage du XML des courses.");
	    
	    /**
	     * Mise en place de la couleur d'�criture du label "lblMessage"
	     */
	 	//Couleur de la police
	    this.lblMessage.setForeground(Color.white);
      
        /**
         * Cr�ation du tableau pour afficher les �l�ments dans le tableau
         */
        //Tableau
        String resultat = "";    
        int i = 0;
        //Boucle foreach qui parcours la collection et ajoute chaque �lement au pr�c�dent en utilisant la m�thode toXML
        for (ConstrCourse uneCourse : lesCourses) {
            resultat += uneCourse.toXML();
        }   
        this.taAffichage = new TextArea(resultat);

        /**
         * Ajout des attributs � mes panels
         */
        //Ajout des attributs aux panels
        this.panelCourseXML.add(panelMessage, BorderLayout.PAGE_START);
        this.panelCourseXML.add(panelBtnQuitter, BorderLayout.PAGE_END);
        
        this.panelMessage.add(lblMessage);
        
        this.panelCourseXML.add(taAffichage);

        //Toujours � la fin
        /**
         * Rendu visible de l'app etc.. toujours � la fin de la classe
         */
        this.setAlwaysOnTop(true);
        this.getContentPane().add(panelCourseXML);
    }

    /**
     * Permet de retourner le panel circuit pour l'affichage
     * @return
     */
    public JPanel getMonPanelCourseXML() {
        return panelCourseXML;
    }
    /**
     * Action performed permettant la navigation entre les diff�rentes classe pour permettre l'affichage
     */
    public void actionPerformed(ActionEvent e) {
        
    }   
}