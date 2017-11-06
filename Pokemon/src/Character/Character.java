package Character;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Character extends MovingImage {

	//Fields
	private Image[] images;
	private double xVelocity, yVelocity;
	protected double xAcc, yAcc;
	
	//Constructor
	//FileNames order: Walk right, face right, walk left, ,face left, walk up, face up, walk down, face down
	public Character(String[] filenames, int x, int y, int w, int h) {
		super(filenames[filenames.length - 1], x, y, w, h);
		images = new Image[filenames.length];
		for(int i = 0; i < filenames.length; i++) {
			images[i] = new ImageIcon(filenames[i]).getImage();
		}
		xVelocity = 0;
		yVelocity = 0;
	}
	
	//Methods	
	public void walkX(double amount) {
		double xCoord = getX();
		double width = getWidth();
		
		xAcc = amount;		
		
		if(xAcc > 0 && xCoord + width < 800) { //Moves right
			super.setImage(images[0]);
			xVelocity = 5;
		}
		else if (xAcc < 0 && xCoord > 0){ //Moves left
			super.setImage(images[2]);
			xVelocity = -5;
		}
		moveToLocation(xCoord + xVelocity, getY());
		xVelocity = 0;
	}
	
	public void walkY(double amount) {
		yAcc = amount;
		
		double yCoord = getY();
		double height = getHeight();
		
		if(yAcc > 0 && yCoord > 0) { //Moves up
			super.setImage(images[4]);
			yVelocity = -5;
		}
		else if(yAcc < 0 && yCoord + height < 600) { //Moves down
			super.setImage(images[6]);
			yVelocity = 5;
		}
		
		moveToLocation(getX(), yCoord + yVelocity);
		yVelocity = 0;
	}
	
	public Image getCertainImage(int i) {
		return images[i];
	}
}