package vue;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Point;
import java.util.List;
print
import javax.swing.JComponent;
import javax.swing.JLayeredPane;

/**
 * <b>Classe definissant le tableau de bord contenut plusieurs PanelTitre d�placables</b>
 * <p>
 * Cette classe est caracterisee par les informations suivantes
 * <ul>
 * <li>le nombre de colonnes du tableau</li>
 * <li>La largeur d'une colonne</li>
 * <li>La hauteur d'une colonne</li>
 * <li>L'espacement horizontal</li>
 * <li>L'espacement vertical</li>
 * </ul>
 * </p>
 * 
 * @author Julien
 * @version 1.0
 *
 */
public class DashBoard extends Container{
	
	/**
	 * L'uid
	 */
	private static final long serialVersionUID = -371405288311867330L;
	
	/**
	 * Le nombre de colonnes du tableau
	 */
	private int nbCol=3;
	
	/**
	 * La largeur d'une colonne
	 */
	private int largeur=200;
	
	/**
	 * La hauteur d'une colonne
	 */
	private int hauteur=100;
	
	/**
	 * L'espacement horizontal entre les colonnes
	 */
	private int espacementX=5;
	
	/**
	 * L'espacement vertical entre les colonnes
	 */
	private int espacementY=5;
	
	/**
	 * Un point servant de r�f�rence lors du drag des PanelTitre
	 * (non caracteristique de la classe)
	 */
	private Point dragLocation;
	
	/**
	 * Un layer pane utilis� pour passer la fen�tre courante au premier plan
	 * (non caracteristique de la classe non accessible � l'ext�rieur)
	 */
	private JLayeredPane layerPane;

	/**
	 * Constructeur de DahBorad
	 * @param contenu
	 * 	Les panels � afficher
	 */
	public DashBoard(List<JComponent> contenu){
		setLayout(new BorderLayout());
		layerPane = new JLayeredPane();
		layerPane.setLayout(null);
		for(int i=0; i<contenu.size(); i++){
			contenu.get(i).addMouseListener(new MouseListenerContenu(this, contenu.get(i)));
			contenu.get(i).addMouseMotionListener(new MouseMotionListenerContenu(this, contenu.get(i)));
			layerPane.add(contenu.get(i));
		}
		aligner();
		add(layerPane);
	}

	/**
	 * M�thode qui permet d'aligner les composant sur le dashBoard
	 */
	public void aligner(){
		int numCol=0;
		int numLigne=0;
		for(int i=0; i<layerPane.getComponents().length; i++){
			int x=espacementX+(largeur+espacementX)*numCol;
			int y=espacementY+(hauteur+espacementY)*numLigne;
			layerPane.getComponents()[i].setBounds(x, y, largeur, hauteur);
			if(++numCol>=nbCol){
				numCol=0;
				numLigne++;
			}
		}
	}
	
	/**
	 * M�thode qui permet de passer un composant au premier plan
	 * @param composant
	 * 	Le composant a passer au premier plan
	 */
	public void passerPremierPlan(JComponent composant) {
		for(Component c : layerPane.getComponents()){
			layerPane.setLayer(c, 0);
		}
		layerPane.setLayer(composant, 1);
	}

	public Point getDragLocation() {
		return dragLocation;
	}

	public void setDragLocation(Point dragLocation) {
		this.dragLocation = dragLocation;
	}
}
