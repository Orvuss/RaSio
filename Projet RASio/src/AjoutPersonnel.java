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
 * Classe AjoutPersonnel
 * @author ldatchi
 *
 */
public class AjoutPersonnel extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe AjoutPersonnel
	 */
	//Attributs privés
	//Panel
	private JPanel panelAjoutPersonnel;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblNomPersonnel;
	private JLabel lblPrenomPersonnel;
	private JLabel lblAdressePersonnel;
	private JLabel lblVillePersonnel;
	private JLabel lblCpPersonnel;
	private JLabel lblInsertion;
	
	//JTextField
	private JTextField jtfNomPersonnel;
	private JTextField jtfPrenomPersonnel;
	private JTextField jtfAdressePersonnel;
	private JTextField jtfVillePersonnel;
	private JTextField jtfCpPersonnel;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public AjoutPersonnel() {
	    /**
	     * Instanciation de mes panels "panelAjoutPersonnel", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelAjoutPersonnel = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAjoutPersonnel", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Background des panels
	    this.panelAjoutPersonnel.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(Color.white);

	    /**
	     * Mise en place des dispositions des panels "panelAjoutPersonnel", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelAjoutPersonnel.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblNomPersonnel", "lblPrenomPersonnel", "lblAdressePersonnel",
	     * "lblVillePersonnel", "lblCpPersonnel" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez remplir les champs pour ajouter un personnel.");
	    this.lblNomPersonnel = new JLabel("Nom du personnel :");
	    this.lblPrenomPersonnel = new JLabel("Prenom du personnel :");
	    this.lblAdressePersonnel = new JLabel("Adresse du personnel :");
	    this.lblVillePersonnel = new JLabel("Ville du personnel :");
	    this.lblCpPersonnel = new JLabel("CP du personnel :");
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    /**
	     * Instanciation des entrées "jtfNomPersonnel", "jtfPrenomPersonnel", "jtfAdressePersonnel", "jtfVillePersonnel"
	     * et "jtfCpPersonnel"
	     */
	    //Instanciation des entrées
	    this.jtfNomPersonnel = new JTextField();
	    this.jtfNomPersonnel.setPreferredSize(new Dimension(150, 30));
	    this.jtfPrenomPersonnel = new JTextField();
	    this.jtfPrenomPersonnel.setPreferredSize(new Dimension(150, 30));
	    this.jtfAdressePersonnel = new JTextField();
	    this.jtfAdressePersonnel.setPreferredSize(new Dimension(150, 30));
	    this.jtfVillePersonnel = new JTextField();
	    this.jtfVillePersonnel.setPreferredSize(new Dimension(150, 30));
	    this.jtfCpPersonnel = new JTextField();
	    this.jtfCpPersonnel.setPreferredSize(new Dimension(150, 30));

	    /**
	     * Mise en place de la couleur d'écriture des label "lblMessage", "lblNomPersonnel", "lblPrenomPersonnel"
	     *  et "lblAdressePersonnel"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);
	    this.lblNomPersonnel.setForeground(Color.black);
	    this.lblPrenomPersonnel.setForeground(Color.black);
	    this.lblAdressePersonnel.setForeground(Color.black);
	    this.lblVillePersonnel.setForeground(Color.black);
	    this.lblCpPersonnel.setForeground(Color.black);
	    
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
	    this.panelAjoutPersonnel.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelAjoutPersonnel.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblNomPersonnel);
	    this.panelChamps.add(jtfNomPersonnel);
	    this.panelChamps.add(lblPrenomPersonnel);
	    this.panelChamps.add(jtfPrenomPersonnel);
	    this.panelChamps.add(lblAdressePersonnel);
	    this.panelChamps.add(jtfAdressePersonnel);
	    this.panelChamps.add(lblVillePersonnel);
	    this.panelChamps.add(jtfVillePersonnel);
	    this.panelChamps.add(lblCpPersonnel);
	    this.panelChamps.add(jtfCpPersonnel);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelPersonnelAjout() {
    	return panelAjoutPersonnel;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
            String nomPersonnel = jtfNomPersonnel.getText();
            String prenomPersonnel = jtfPrenomPersonnel.getText();
            String adressePersonnel = jtfAdressePersonnel.getText();
            String villePersonnel = jtfVillePersonnel.getText();
            String cpPersonnel = jtfCpPersonnel.getText();
            boolean rep = Modele.ajoutPersonnel(nomPersonnel, prenomPersonnel, adressePersonnel, villePersonnel, cpPersonnel);
            if(rep) {
            	lblInsertion.setText("Un nouveau personnel a été ajouté");
            }
            else {
            	lblInsertion.setText("ERREUR, le personnel n'a pas pu être ajouté");
            }
        }
	}
}