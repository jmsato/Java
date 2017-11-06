package Character;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.Timer;

public class Lucas implements ActionListener {
	
	private final int ACTION_TIMEOUT = 500;
	private Image sprites;
	private Rectangle[] spriteRects;
	
	// The bottom left corner of link.
	// We are drawing by the bottom left because the sprites have different heights, and we want different actions to change the y coordinate 
	// of his head rather than his feet.
	private int x, y;
	private int width, height;
		  
	private int action;
		  
	private JComponent surface; // for repainting when we make changes to his image
		  
	private Timer actionTimer;
	
	public Lucas(int x, int y, JComponent surface) {
		sprites = new ImageIcon("lib//MaleTrainer//Lucas.png").getImage();
		  
		spriteRects = new Rectangle[3]; // Coordinates of each action within the sprite sheet image
		spriteRects[0] = new Rectangle(0,77,41,46);
		spriteRects[1] = new Rectangle(468,86,61,59);
		spriteRects[2] = new Rectangle(413,90,53,55);
		  
		this.x = x;
		this.y = y;
		width =  spriteRects[0].width;   // Default width and height is the width and height of the first image loaded from the sprite sheet
		height =  spriteRects[0].height;
				
		width *= 4;  // We scale the size of Link up x4 for visibility
		height *= 4;
		  
		action = 0;
		  
		this.surface = surface;
		actionTimer = new Timer(ACTION_TIMEOUT,this);
		actionTimer.setRepeats(false);
	}
	
	public void stand() {
		action = 0;
	}
	
	public void walk() {
		action = 1;
	}
	
	/*
	 * Draw Lucas using the correct sprite.
	 */
	public void draw(Graphics2D g2, ImageObserver io) {
		AffineTransform at = g2.getTransform();
	    double xScale = (double)width / spriteRects[0].width;
	    double yScale = (double)height / spriteRects[0].height;
	    g2.drawImage(sprites, 
	    		x,
	    		(int)(y-yScale*spriteRects[action].height),
	    		(int)(x+xScale*spriteRects[action].width),
	    		y,
	    		spriteRects[action].x,
	    		spriteRects[action].y,
	    		spriteRects[action].x+spriteRects[action].width,
	    		spriteRects[action].y+spriteRects[action].height,
	    		io);
	}
	
	//When key is no longer being pressed, the character drawn standing
	public void actionPerformed(ActionEvent e) {
		  stand();
		  surface.repaint();
	  }
}
