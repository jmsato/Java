package Panel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BattlePanel extends JPanel {

	//Fields
	private BattleButtons options;
	
	//Constructor
	public BattlePanel (Window w) {
		super();
		options = new BattleButtons(w);
		BorderLayout b = new BorderLayout();
		setLayout(b);
		add(options, BorderLayout.SOUTH);
	}
	
	//Methods
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	}
}
