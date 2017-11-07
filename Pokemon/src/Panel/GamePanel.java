package Panel;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

import Character.Lucas;

public class GamePanel extends JPanel implements Runnable {

	public static final int DRAWING_WIDTH = 800;
	public static final int DRAWING_HEIGHT = 600;
			
	private Lucas player = new Lucas(400, 300);
	
	public GamePanel() {
		super();
		setBackground(Color.GREEN);
		new Thread(this).start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		int width = getWidth();
		int height = getHeight();
		
		double ratioX = (double)width/DRAWING_WIDTH;
		double ratioY = (double)height/DRAWING_HEIGHT;
		
		AffineTransform at = g2.getTransform();
		g2.scale(ratioX, ratioY);
		
		//Background image
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("lib//grass.jpg"));
		} catch(IOException e) {
			e.printStackTrace();
		}
		g2.drawImage(img, 0, 0, DRAWING_WIDTH, DRAWING_HEIGHT, this);
		
		//g2.drawImage(new ImageIcon("lib//Tall_Grass.png").getImage(), 0, 0, 24, 24, this);
		player.draw(g2, null);
		g2.setTransform(at);
	}
	
	@Override
	public void run() {
		while (true) {
			repaint();
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				
			}
	
		}
	}

	public class KeyHandler implements KeyListener {
		private boolean right, down;
		
		public void reset() {
			right = false;
			down = false;
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int code = e.getKeyCode();
			if(code == KeyEvent.VK_LEFT) {
				right = false;
				player.walkX(-10);
			}
			else if(code == KeyEvent.VK_RIGHT) {
				right = true;
				player.walkX(10);
			}
			else if(code == KeyEvent.VK_UP) {
				down = false;
				player.walkY(10);
			}
			else if(code == KeyEvent.VK_DOWN) {
				down = true;
				player.walkY(-10);
			}
			else {
				player.setImage(player.getCertainImage(1));
			}
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				right = false;
				player.setImage(player.getCertainImage(3));
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				right = false;
				player.setImage(player.getCertainImage(1));
			}
			else if(e.getKeyCode() == KeyEvent.VK_UP) {
				right  = false;
				player.setImage(player.getCertainImage(5));
			}
			else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				down = false;
				player.setImage(player.getCertainImage(7));
			}
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}