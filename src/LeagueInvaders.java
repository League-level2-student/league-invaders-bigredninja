import javax.swing.JFrame;

public class LeagueInvaders {

public static int WIDTH = 500;
public static int HEIGHT = 800;
JFrame frame;
GamePanel panel;

LeagueInvaders(){
	frame = new JFrame();
	panel = new GamePanel();
}
void setup() {
	frame.add(panel);
	frame.setSize(WIDTH, HEIGHT);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[] args) {
	LeagueInvaders invaders = new LeagueInvaders();
	invaders.setup();	
}
}
