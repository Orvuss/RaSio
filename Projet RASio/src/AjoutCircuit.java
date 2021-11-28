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
 * Classe AjoutCircuit
 * @author ldatchi
 *
 */
public class AjoutCircuit extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe AjoutCircuit
	 */
	//Attributs privés
	//Panel
	private JPanel panelAjoutCircuit;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblNomCircuit;
	private JLabel lblTailleCircuit;
	private JLabel lblPaysCircuit;
	private JLabel lblInsertion;
	
	//JTextField
	private JTextField jtfNomCircuit;
	private JTextField jtfTailleCircuit;
	private JTextField jtfNbSpectateur;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public AjoutCircuit() {	
	    /**
	     * Instanciation de mes panels "panelAjoutCircuit", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelAjoutCircuit = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAjoutCircuit", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Background des panels
	    this.panelAjoutCircuit.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(Color.white);

	    /**
	     * Mise en place des dispositions des panels "panelAjoutCircuit", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelAjoutCircuit.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblNomCircuit", "lblTailleCircuit", "lblPaysCircuit" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez remplir les champs pour ajouter un circuit.");
	    this.lblNomCircuit = new JLabel("Nom du circuit :");
	    this.lblTailleCircuit = new JLabel("Taille du circuit :");
	    this.lblPaysCircuit = new JLabel("Pays du circuit :");
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    /**
	     * Instanciation des entrées "jtfNomCircuit", "jtfTailleCircuit" et "jtfNbSpectateur"
	     */
	    //Instanciation des entrées
	    this.jtfNomCircuit = new JTextField();
	    this.jtfNomCircuit.setPreferredSize(new Dimension(150, 30));
	    this.jtfTailleCircuit = new JTextField();
	    this.jtfTailleCircuit.setPreferredSize(new Dimension(150, 30));
	    this.jtfNbSpectateur = new JTextField();
	    this.jtfNbSpectateur.setPreferredSize(new Dimension(150, 30));

	    /**
	     * Mise en place de la couleur d'écriture des label "lblMessage", "lblNomCircuit", "lblTailleCircuit" et "lblPaysCircuit"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);
	    this.lblNomCircuit.setForeground(Color.black);
	    this.lblTailleCircuit.setForeground(Color.black);
	    this.lblPaysCircuit.setForeground(Color.black);
	    
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
	    this.panelAjoutCircuit.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelAjoutCircuit.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblNomCircuit);
	    this.panelChamps.add(jtfNomCircuit);
	    this.panelChamps.add(lblTailleCircuit);
	    this.panelChamps.add(jtfTailleCircuit);
	    this.panelChamps.add(lblPaysCircuit);
	    this.panelChamps.add(jtfNbSpectateur);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelCircuitAjout() {
    	return panelAjoutCircuit;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
            String nomCircuit = jtfNomCircuit.getText();
            String tailleCircuit = jtfTailleCircuit.getText();
            String paysCircuit = jtfNbSpectateur.getText();
            boolean rep = Modele.ajoutCircuit(nomCircuit, tailleCircuit, paysCircuit);
            if(rep) {
            	lblInsertion.setText("Un nouveau circuit a été ajouté");
            }
            else {
            	lblInsertion.setText("ERREUR, le circuit n'a pas pu être ajouté");
            }
        }
	}
}