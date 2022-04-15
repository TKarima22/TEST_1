package lancement;



import vue.DashBoard;
import vue.PanelTitre;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Lanceur {

	public static void main(String[] args) {
		List<JComponent> panels = new ArrayList<JComponent>();
		for(int i=0; i<8; i++) {
			panels.add(new PanelTitre("Panel "+i, creerTextArea(i)));
		}
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(new GridLayout(1,0));
		f.add(new DashBoard(panels));
		f.setSize(650, 450);
		f.setVisible(true);
	}

	private static JTextArea creerTextArea(int i){
		JTextArea texte = new JTextArea("Texte du Panel num�ro "+i+".");
		texte.setEditable(false);
		texte.setOpaque(false);
		return texte;
	}

}
