package vue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

public class MouseMotionListenerContenu implements MouseMotionListener{

	
	private DashBoard dashboard;
	private JComponent panelTitre;
	

	public MouseMotionListenerContenu(DashBoard dashboard, JComponent panelTitre) {
		super();
		this.dashboard = dashboard;
		this.panelTitre = panelTitre;
	}

	public void mouseDragged(MouseEvent e) {
		panelTitre.setLocation(
				(int)(e.getX()-dashboard.getDragLocation().getX()+panelTitre.getX()),
				(int)(e.getY()-dashboard.getDragLocation().getY()+panelTitre.getY())
				); 
		dashboard.repaint();
	}

	public void mouseMoved(MouseEvent arg0) {
		
	}

}
