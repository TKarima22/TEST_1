package vue;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * <b>Classe definissant un panel avec une zone de titre</b>
 * <p>
 * Cette classe est caracterisee par les informations suivantes
 * <ul>
 * <li>Un JLabel de titre</li>
 * <li>Un contenu</b>
 * </ul>
 * <p>
 * 
 * @author Julien
 * @version 1.0
 *
 */
public class PanelTitre extends JPanel {
	
	/**
	 * l'uid
	 */
	private static final long serialVersionUID = -631126394886933120L;
	
	/**
	 * Le label de titre
	 */
	private LabelTitre labelTitre;
	
	/**
	 * Le contenu du panel
	 */
	private Container contenu;

	/**
	 * Constructeur de PanelTitre
	 * @param titre
	 * 	Le titre a afficher dans la zone reservee
	 * @param contenu
	 * 	Le contenu du panel
	 */
	public PanelTitre(String titre, Container contenu){
		this.contenu=contenu;
		setLayout(null);
		setBackground(Color.WHITE);
		labelTitre = new LabelTitre("   "+titre);
		setBorder(new LineBorder(labelTitre.getCouleurHaut()));
		labelTitre.setFont(new Font("Calibri", Font.BOLD, 19));
		labelTitre.setBounds(4, 4, getWidth()-8, Math.max(Math.min(getHeight()/5, 60), 30));
		add(labelTitre);
		contenu.setBounds(labelTitre.getHeight()+5, 0, getWidth(), getHeight()-labelTitre.getHeight()-5);
		add(contenu);
	}   

    @Override
    public void paintComponent(Graphics g){
    	labelTitre.setBounds(4, 4, getWidth()-8, Math.max(Math.min(getHeight()/5, 60), 30));
    	contenu.setBounds(10, labelTitre.getHeight()+5+labelTitre.getY(), getWidth(), getHeight()-labelTitre.getHeight()-5);
		super.paintComponent(g);
    }
    
    @Override
    public void addMouseListener(MouseListener ml){
    	super.addMouseListener(ml);
    	labelTitre.addMouseListener(ml);
    	contenu.addMouseListener(ml);
    }
    
    @Override
    public void addMouseMotionListener(MouseMotionListener ml){
    	super.addMouseMotionListener(ml);
    	labelTitre.addMouseMotionListener(ml);
    	contenu.addMouseMotionListener(ml);
    }
}
