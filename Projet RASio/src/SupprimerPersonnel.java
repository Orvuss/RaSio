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
 * Classe SupprimerPersonnel
 * @author ldatchi
 *
 */
public class SupprimerPersonnel extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe SupprimerPersonnel
	 */
	//Attributs privés
	//Panel
	private JPanel panelPersonnel;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
  	private JLabel lblMessage;
	private JLabel lblNomPersonnel;
	private JLabel lblPrenomPersonnel;
	private JLabel lblInsertion;
  	
  	//JTextField
  	private JTextField jtfSuppressionNom;
  	private JTextField jtfSuppressionPrenom;
  	
  	//Bouton
  	private JButton btnValider;
  	
  	public SupprimerPersonnel() {
	    /**
	     * Instanciation de mes panels "panelPersonnel", "panelMessage", "panelChamps" et "panelBtnQuitter"
	     */
	    //Instanciation des panels
	    this.panelPersonnel = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelPersonnel", "panelMessage", "panelChamps" et "panelBtnQuitter"
	     */
	    //Background des panels
	    this.panelPersonnel.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(Color.white);

	    /**
	     * Mise en place des dispositions des panels "panelPersonnel", "panelMessage", "panelChamps" et "panelBtnQuitter"
	     */
	    //Disposition des panels
        this.panelPersonnel.setLayout(new BorderLayout());
        this.panelMessage.setLayout(new FlowLayout());
        this.panelChamps.setLayout(new FlowLayout());

        /**
	     * Instanciation des label "lblMessage", "lblNomPersonnel" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Suppression des personnels.");
	    this.lblNomPersonnel = new JLabel("Entrez le nom :");
	    this.lblPrenomPersonnel = new JLabel("Entrez le prénom :");
	    this.lblInsertion = new JLabel("");

	    /**
	     * Instanciation des entrées "jtfSuppressionNom" et "jtfSuppressionPrenom"
	     */
	    //Instanciation des entrées
	    this.jtfSuppressionNom = new JTextField();
	    this.jtfSuppressionNom.setPreferredSize(new Dimension(150, 30));
	    this.jtfSuppressionPrenom = new JTextField();
	    this.jtfSuppressionPrenom.setPreferredSize(new Dimension(150, 30));
	    
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
	    this.panelPersonnel.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelPersonnel.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblNomPersonnel);
	    this.panelChamps.add(jtfSuppressionNom);
	    this.panelChamps.add(lblPrenomPersonnel);
	    this.panelChamps.add(jtfSuppressionPrenom);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);

	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
  	}
  	
  	public JPanel getMonPanelPersonnelSupprimer() {
    	return panelPersonnel;
    }
  	
  	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
		 //Si la source de l'évènement est le JButton appelé 
        if(e.getSource() == btnValider) {
            String nomPersonnel = jtfSuppressionNom.getText();
            String prenomPersonnel = jtfSuppressionPrenom.getText();
            JTextField result = new JTextField ("Erreur");
            if(Modele.suppressionPersonnel(nomPersonnel, prenomPersonnel)) {
                lblInsertion.setText("Suppression effectuée."); 
            }
            else {
                lblInsertion.setText("Suppression non effectuée."); 
            }
        }
	}
}
