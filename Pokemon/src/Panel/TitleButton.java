package Panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TitleButton extends JPanel implements ActionListener {

	private Window myWindow;
	private JButton start;
	
	public TitleButton(Window w) {
		BoxLayout b = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(b);
		setOpaque(false);
		start = new JButton(new ImageIcon("lib//Buttons//Start.png"));
		start.setBackground(Color.WHITE);
		start.setBorder(null);
		start.setOpaque(false);
		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		start.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		start.addActionListener(this);
		add(start);
		myWindow = w;
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == start) {
			myWindow.changePanel(2);
		}
	}
}
