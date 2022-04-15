package vue;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;

import javax.swing.JLabel;

public class LabelTitre extends JLabel {

	private static final long serialVersionUID = 2798175802739491746L;

	private Color couleurHaut = new Color(175, 175, 175);
	private Color couleurBas = new Color(235, 235, 235);
	
	public LabelTitre(String titre){
		super(titre);
	}

	@Override
	public void paintComponent(Graphics g){
		Paint paint;
		Graphics2D g2d;
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
		}
		else {
			System.out.println("Error");
			return;
		}
		paint = new GradientPaint(0,0, couleurHaut, 0, getHeight(), couleurBas);
		g2d.setPaint(paint);
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		g2d.setColor(couleurHaut);
		g2d.drawRoundRect(1, 1, getWidth()-2, getHeight()-2, 15, 15);
		super.paintComponent(g);
	}

	public Color getCouleurHaut() {
		return couleurHaut;
	}
	
	

}
