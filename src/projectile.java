import java.awt.Color;
import java.awt.Graphics;

public class projectile extends GameObject{

	projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = 10;
		// TODO Auto-generated constructor stub
	}
	void update() {
		y-=speed;
	}
	void draw(Graphics g) {
		g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
	}
}

