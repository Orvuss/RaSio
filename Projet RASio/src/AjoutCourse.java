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
 * Classe AjoutCourse
 * @author ldatchi
 *
 */
public class AjoutCourse extends JPanel implements ActionListener{

	/**
	 * Attributs privés de la classe AjoutCourse
	 */
	//Attributs privés
	//Panel
	private JPanel panelAjoutCourse;
	private JPanel panelMessage;
	private JPanel panelChamps;
	
	//Label
	private JLabel lblMessage;
	private JLabel lblNomCourse;
	private JLabel lblTypeCourse;
	private JLabel lblNbSpectateur;
	private JLabel lblInsertion;
	
	//JTextField
	private JTextField jtfNomCourse;
	private JTextField jtfTypeCourse;
	private JTextField jtfNbSpectateur;
	
	//Bouton
	private JButton btnValider;
	
	//Constructeur
	public AjoutCourse() {	
	    /**
	     * Instanciation de mes panels "panelAjoutCourse", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Instanciation des panels
	    this.panelAjoutCourse = new JPanel();
	    this.panelMessage = new JPanel();
	    this.panelChamps = new JPanel();

	    /**
	     * Mise en place des background des panels "panelAjoutCourse", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Background des panels
	    this.panelAjoutCourse.setBackground(Color.white);
	    this.panelMessage.setBackground(Color.black);
	    this.panelChamps.setBackground(Color.white);

	    /**
	     * Mise en place des dispositions des panels "panelAjoutCourse", "panelMessage", "panelBtnQuitter" et "panelChamps"
	     */
	    //Disposition des panels
	    this.panelAjoutCourse.setLayout(new BorderLayout());
	    this.panelMessage.setLayout(new FlowLayout());
	    this.panelChamps.setLayout(new FlowLayout());

	    /**
	     * Instanciation des label "lblMessage", "lblNomCourse", "lblTypeCourse", "lblNbSpectateur" et "lblInsertion"
	     */
	    //Instanciation des messages
	    this.lblMessage = new JLabel("Veuillez remplir les champs.");
	    this.lblNomCourse = new JLabel("Nom de la course :");
	    this.lblTypeCourse = new JLabel("Type de la course :");
	    this.lblNbSpectateur = new JLabel("Nombre de spectateurs :");
	    this.lblInsertion = new JLabel();
	    this.lblInsertion.setText("");

	    /**
	     * Instanciation des entrées "jtfNomCourse", "jtfTypeCourse" et "jtfNbSpectateur"
	     */
	    //Instanciation des entrées
	    this.jtfNomCourse = new JTextField();
	    this.jtfNomCourse.setPreferredSize(new Dimension(150, 30));
	    this.jtfTypeCourse = new JTextField();
	    this.jtfTypeCourse.setPreferredSize(new Dimension(150, 30));
	    this.jtfNbSpectateur = new JTextField();
	    this.jtfNbSpectateur.setPreferredSize(new Dimension(150, 30));

	    /**
	     * Mise en place de la couleur d'écriture des label "lblMessage", "lblNomCourse", "lblTypeCourse" et "lblNbSpectateur"
	     */
	    //Couleur de la police
	    this.lblMessage.setForeground(Color.white);
	    this.lblNomCourse.setForeground(Color.black);
	    this.lblTypeCourse.setForeground(Color.black);
	    this.lblNbSpectateur.setForeground(Color.black);
	    
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
	    this.panelAjoutCourse.add(panelMessage, BorderLayout.PAGE_START);
	    this.panelAjoutCourse.add(panelChamps, BorderLayout.CENTER);
	    
	    this.panelMessage.add(lblMessage);
	    
	    this.panelChamps.add(lblNomCourse);
	    this.panelChamps.add(jtfNomCourse);
	    this.panelChamps.add(lblTypeCourse);
	    this.panelChamps.add(jtfTypeCourse);
	    this.panelChamps.add(lblNbSpectateur);
	    this.panelChamps.add(jtfNbSpectateur);
	    this.panelChamps.add(btnValider);
	    this.panelChamps.add(lblInsertion);
		
	    //Toujours à la fin
  		/**
  		 * Rendu visible de l'app etc.. toujours à la fin de la classe
  		 */
  		this.setVisible(true);
	}
	
	public JPanel getMonPanelCourseAjout() {
    	return panelAjoutCourse;
    }
	
	/**
	 * Action performed permettant la navigation entre les différentes classe pour permettre l'affichage
	 */
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnValider) {
            String nomCourse = jtfNomCourse.getText();
            String typeCourse = jtfTypeCourse.getText();
            int nbSpectateurs = Integer.parseInt(jtfNbSpectateur.getText());
            boolean rep = Modele.ajoutCourse(nomCourse, typeCourse, nbSpectateurs);
            if(rep) {
            	lblInsertion.setText("Une nouvelle course a été ajoutée");
            }
            else {
            	lblInsertion.setText("ERREUR, la course n'a pas pu être ajoutée");
            }
        }
	}
}


