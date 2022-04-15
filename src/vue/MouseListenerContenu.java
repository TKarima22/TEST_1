package vue;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

public class MouseListenerContenu implements MouseListener {

	private DashBoard dashBoard;
	private JComponent panelTitre;

	private Color couleurNormale = Color.WHITE;
	private Color couleurSelectionne = new Color(245, 245, 245);

	public MouseListenerContenu(DashBoard dashBoard, JComponent panelTitre) {
		this.dashBoard = dashBoard;
		this.panelTitre = panelTitre;
	}

	public void mouseClicked(MouseEvent arg0) {

	}

	public void mouseEntered(MouseEvent arg0) {
		dashBoard.passerPremierPlan(panelTitre);
		if(dashBoard.getDragLocation()==null){
			panelTitre.setBackground(couleurSelectionne);
		}

	}

	public void mouseExited(MouseEvent arg0) {
		panelTitre.setBackground(couleurNormale);
	}

	public void mousePressed(MouseEvent arg0) {
		dashBoard.setDragLocation(arg0.getPoint());

	}

	public void mouseReleased(MouseEvent arg0) {
		dashBoard.setDragLocation(null);
		//System.out.println(dashBoard.getComponentsInLayer(0).length);
	}

}
