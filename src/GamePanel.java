import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener
{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;
	final int MENU = 0;
	final int GAME = 1;
	final int END = 2;
	int currentState = MENU;
	Font titleFont;
	Font tiitleFont;
	Font tiiitleFont;
	Font EndFont;
	Timer frameDraw;
	Timer alienspawn;
	Rocketship rocketship;
	ObjectManager objectManager;
	void startGame() {
		alienspawn = new Timer(1000 , objectManager);
		alienspawn.start();
	}
	GamePanel(){
		titleFont = new Font("Arial", Font.PLAIN, 48);
		tiitleFont = new Font("Arial", Font.PLAIN, 15);
		tiiitleFont = new Font("Arial", Font.PLAIN, 15);
		EndFont = new Font("Arial", Font.PLAIN, 48);
		frameDraw = new Timer(1000/60,this);
		frameDraw.start();
		rocketship = new Rocketship(200,550,50,50);
		objectManager = new ObjectManager(rocketship);
		if (needImage) {
			loadImage ("space.png");
		}
	}
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
			drawMenuState(g);

		}else if(currentState == GAME){
			drawGameState(g);
		}else if(currentState == END){
			drawEndState(g);
		}	
	}
	public void updateMenuState() {  }
	public void updateGameState() {rocketship.update(); 
	objectManager.update();
	if (rocketship.isActive == false) {
		currentState = END;
	}
	}
	public void updateEndState()  {  }
	public void drawMenuState(Graphics g) { 
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("league Invaders", 75, 55);
		g.setFont(tiitleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press ENTER to start", 125, 250);
		g.setFont(tiiitleFont);
		g.setColor(Color.YELLOW);
		g.drawString("Press SPACE For Instructions", 125, 400);

	}
	public void drawGameState(Graphics g) { 


		if (gotImage) {
			g.drawImage(image, 0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT-110, null);
		} else {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		}
		objectManager.draw(g);
	}
	public void drawEndState(Graphics g)  {  
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(EndFont);
		g.setColor(Color.GREEN);
		g.drawString("GAME OVER", 75, 55);
		g.setFont(tiiitleFont);
		g.drawString("You Killed  Enemies "+ objectManager.getScore(), 150, 250);
		g.setFont(tiiitleFont);
		g.drawString("Press ENTER to restart", 175, 300);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(currentState == MENU){
			updateMenuState();
		}else if(currentState == GAME){
			updateGameState();
		}else if(currentState == END){
			updateEndState();
		}
		repaint();
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode()==KeyEvent.VK_ENTER) {
			if (currentState == END) {
				currentState = MENU;
				rocketship = new Rocketship(200,550,50,50);
				objectManager = new ObjectManager(rocketship);
			} 
			else if (currentState == MENU) {
				currentState = GAME;
				startGame();
			}
			else {
				currentState++;
			}
		}   
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			System.out.println("UP");
			rocketship.UP = true;
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			rocketship.LEFT = true;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			rocketship.RIGHT = true;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			rocketship.DOWN = true;
		}
		if (e.getKeyCode()==KeyEvent.VK_SPACE) {
			objectManager.addProjectile(rocketship.getProjectile());
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			System.out.println("UP");
			rocketship.UP = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {
			System.out.println("LEFT");
			rocketship.LEFT = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
			System.out.println("RIGHT");
			rocketship.RIGHT = false;
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {
			System.out.println("DOWN");
			rocketship.DOWN = false;
		}

	}
	void loadImage(String imageFile) {
		if (needImage) {
			try {
				image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
				gotImage = true;
			} catch (Exception e) {

			}
			needImage = false;
		}
	}
}
