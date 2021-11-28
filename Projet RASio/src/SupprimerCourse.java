import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Classe SupprimerCourse
 * @author ldatchi
 *
 */
public class SupprimerCourse extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe SupprimerCourse
	 */
	//Attributs privés
	//Panel
	private JPanel panelCourse;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
  	private JLabel lblMessage;
	private JLabel lblNomCourse;
	private JLabel lblInsertion;
  	
  	//JTextField
  	private JTextField jtfSuppression;
  	
  	//Bouton
  	private JButton btnValider;
  	
  	public SupprimerCourse() {	
	    /**
	     * Instanciation de mes panels "panelCourse", "panelMessage", "panelChamps" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelCourse = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelCourse", "panelMessage", "panelChamps" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelCourse.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(Color.white);

	    /**
	     * Mise en place des dispositions des panels "panelCourse", "panelMessage", "panelChamps" et "panelBtnQuitter"
	     */
	    //Disposition des panels
        this.panelCourse.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());

        /**
	     * Instanciation des label "lblMessage", "lblNomCourse" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Suppression des courses.");
	    this.lblNomCourse = new JLabel("Entrez le nom :");
	    this.lblInsertion = new JLabel("");

	    /**
	     * Instanciation de l'entrée "jtfSuppression"
	     */
	    //Instanciation des entrées
	    this.jtfSuppression = new JTextField();
	    this.jtfSuppression.setPreferredSize(new Dimension(150, 30));
	    
	    /**
	     * Mise en place de la couleur d'écriture du label "lblMessage"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);
	    
	    /**
         * Instanciation des boutons "btnValider" et "btnRetour"
         */
	    //Instanciation des boutons
	    this.btnValider = new JButton("Valider");
	    this.btnValider.addActionListener(this);
	    
	    /**
	     * Ajout des attributs à mes panels
	     */
	    //Ajout des attributs aux panels
	    this.panelCourse.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelCourse.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblNomCourse);
	    this.panelChamps.add(jtfSuppression);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);


	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
  	}
  	
  	public JPanel getMonPanelCourseSupprimer() {
    	return panelCourse;
    }
  	
  	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		 //Si la source de l'évènement est le JButton appelé 
        if(e.getSource() == btnValider) {
            String nomCourse = jtfSuppression.getText();
            JTextField result = new JTextField ("Erreur");
            if(Modele.suppressionCourse(nomCourse)) {
                lblInsertion.setText("Suppression effectuée."); 
            }
            else {
                lblInsertion.setText("Suppression non effectuée."); 
            }
        }
	}
	
}
