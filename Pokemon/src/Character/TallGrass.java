package Character;

import javax.swing.ImageIcon;

public class TallGrass extends MovingImage {

	//Fields
	boolean battle;
	
	//Constructor
	public TallGrass(int x, int y) {
		super(new ImageIcon("lib//Tall_Grass.png").getImage(), x, y, 24, 24);
		battle = false;
	}
	
	//Methods
	public void initiateBattle() {
		
	}
}
