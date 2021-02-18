import java.awt.Color;
import java.awt.Graphics;

public class Rocketship  extends GameObject {
boolean UP = false;
boolean DOWN = false;
boolean LEFT = false;
boolean RIGHT = false;
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
	}
void draw(Graphics g) {
	 g.setColor(Color.BLUE);
     g.fillRect(x, y, width, height);	
}
public void right() {
	if (x < 450) {
		x+=speed;
	}
}public void left() {
	if (x > 0) {
		x-=speed;
	}
}public void up() {
	if (y > 0) {
		y-=speed;
	}
}public void down() {
    if (y < 600) {
    	y+=speed;
	}
}
void update() {
	super.update();
	if (UP) {
		up();
	}
	if (DOWN) {
		down();
	}
	if (LEFT) {
		left();
	}
	if (RIGHT) {
		right();
	}
}
}
