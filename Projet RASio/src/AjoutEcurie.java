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
 * Classe AjoutEcurie
 * @author ldatchi
 *
 */
public class AjoutEcurie extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe AjoutEcurie
	 */
	//Attributs privés
	//Panel
	private JPanel panelAjoutEcurie;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblNomEcurie;
	private JLabel lblSponsorEcurie;
	private JLabel lblMotoristeEcurie;
	private JLabel lblInsertion;
	
	//JTextField
	private JTextField jtfNomEcurie;
	private JTextField jtfSponsorEcurie;
	private JTextField jtfMotoristeEcurie;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public AjoutEcurie() {
	    /**
	     * Instanciation de mes panels "panelAjoutEcurie", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelAjoutEcurie = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAjoutEcurie", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Background des panels
	    this.panelAjoutEcurie.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(Color.white);

	    /**
	     * Mise en place des dispositions des panels "panelAjoutEcurie", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelAjoutEcurie.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblNomEcurie", "lblSponsorEcurie", "lblMotoristeEcurie" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez remplir les champs pour ajouter une ecurie.");
	    this.lblNomEcurie = new JLabel("Nom de l'écurie :");
	    this.lblSponsorEcurie = new JLabel("Sponsor de l'écurie :");
	    this.lblMotoristeEcurie = new JLabel("Motoriste de l'écurie :");
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    /**
	     * Instanciation des entrées "jtfNomEcurie", "jtfSponsorEcurie" et "jtfMotoristeEcurie"
	     */
	    //Instanciation des entrées
	    this.jtfNomEcurie = new JTextField();
	    this.jtfNomEcurie.setPreferredSize(new Dimension(150, 30));
	    this.jtfSponsorEcurie = new JTextField();
	    this.jtfSponsorEcurie.setPreferredSize(new Dimension(150, 30));
	    this.jtfMotoristeEcurie = new JTextField();
	    this.jtfMotoristeEcurie.setPreferredSize(new Dimension(150, 30));

	    /**
	     * Mise en place de la couleur d'écriture des label "lblMessage", "lblNomEcurie", "lblSponsorEcurie" et "lblMotoristeEcurie"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);
	    this.lblNomEcurie.setForeground(Color.black);
	    this.lblSponsorEcurie.setForeground(Color.black);
	    this.lblMotoristeEcurie.setForeground(Color.black);
	    
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
	    this.panelAjoutEcurie.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelAjoutEcurie.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblNomEcurie);
	    this.panelChamps.add(jtfNomEcurie);
	    this.panelChamps.add(lblSponsorEcurie);
	    this.panelChamps.add(jtfSponsorEcurie);
	    this.panelChamps.add(lblMotoristeEcurie);
	    this.panelChamps.add(jtfMotoristeEcurie);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}

	public JPanel getMonPanelEcurieAjout() {
    	return panelAjoutEcurie;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
            String nomEcurie = jtfNomEcurie.getText();
            String SPonsorEcurie = jtfSponsorEcurie.getText();
            String MotoristeEcurie = jtfMotoristeEcurie.getText();
            boolean rep = Modele.ajoutEcurie(nomEcurie, SPonsorEcurie, MotoristeEcurie);
            if(rep) {
            	lblInsertion.setText("Une nouvelle écurie a été ajoutée");
            }
            else {
            	lblInsertion.setText("ERREUR, l'écurie n'a pas pu être ajoutée");
            }
        }
	}
}