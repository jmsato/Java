package Panel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BattleButtons extends JPanel implements ActionListener {

	private Window myWindow;
	private JButton attack;
	private JButton items;
	private JButton pokemon;
	private JButton run;
	
	public BattleButtons(Window w) {
		BoxLayout b = new BoxLayout(this, BoxLayout.X_AXIS);
		setLayout(b);
		setOpaque(false);
		//Attack Button
		attack = new JButton(new ImageIcon("lib//Buttons//AttackButton.png"));
		attack.setAlignmentX(Component.LEFT_ALIGNMENT);
		attack.setAlignmentY(Component.TOP_ALIGNMENT);
		attack.addActionListener(this);
		attack.add(this);
		
		//items = new JButton();
		//pokemon = new JButton();
		//run = new JButton();

		myWindow = w;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == attack) {
			
		}
		else if(source == items) {
			
		}
		else if(source == pokemon) {
			
		}
		else if(source == run) {
			
		}
	}
}
