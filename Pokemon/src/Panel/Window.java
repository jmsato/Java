package Panel;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	/**
	 * Contains all the panels and switches between them when needed
	 */
	JPanel cardPanel;
	private TitlePanel title;
	private GamePanel game;
	private BattlePanel battle;
	
	public Window(){
		super("Pokemon Professor");
		title = new TitlePanel(this);
		game = new GamePanel();
		battle = new BattlePanel(this);
		
	    addKeyListener(game.new KeyHandler());
		setResizable(false);
		
		setBounds(100, 100, 800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
	    cardPanel.add(title,"1");
	    cardPanel.add(game, "2");
	    cardPanel.add(battle, "3");
	    
	    add(cardPanel);
	
	    setVisible(true);
	    
	}
	
	/**
	 * Switches panels to the next in the list of panels
	 * might change it so it changes to the panel specified in the parameters
	 */
	public void changePanel(int panelNum){
		
		if(panelNum == 1){
			((CardLayout)cardPanel.getLayout()).show(cardPanel,"1");
			requestFocus();
		}
		else if(panelNum == 2){
			((CardLayout)cardPanel.getLayout()).show(cardPanel,"2");
			requestFocus();
		}
		else if(panelNum == 3) {
			((CardLayout)cardPanel.getLayout()).show(cardPanel, "3");
			requestFocus();
		}
	}

}
