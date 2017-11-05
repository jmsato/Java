package Panel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class TitlePanel extends JPanel {

	//Fields
	private Image image;
	private TitleButton start;
	
	//Constructor
	public TitlePanel(Window w) {
		start = new TitleButton(w);
		BorderLayout b = new BorderLayout();
		setLayout(b);
		add(start, BorderLayout.SOUTH);
		
		image = new ImageIcon("lib//pokeball.png").getImage();
	}
	
	//Methods
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
}
