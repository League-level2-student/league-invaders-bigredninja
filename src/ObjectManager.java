import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager implements ActionListener{
	Random rnd = new Random();
	ArrayList<Alien> aliens;

	ArrayList<Projectile> projectiles;
	Rocketship spaceship;
	public ObjectManager( Rocketship spaceship) {
		this.spaceship = spaceship;
		projectiles = new ArrayList<Projectile>();	
		aliens = new ArrayList<Alien>();
	}
	public void addProjectile(Projectile projectile ) {
		projectiles.add(projectile);
	}
	public void addAlien() {
		aliens.add(new Alien(rnd.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	void update() {
		for (Iterator iterator = aliens.iterator(); iterator.hasNext();) {
			Alien alien = (Alien) iterator.next();
			alien.update();	
			if (alien.y > LeagueInvaders.HEIGHT) {
				alien.isActive = false;
			}

		}
		for (Iterator iterator = projectiles.iterator(); iterator.hasNext();) {
			Projectile projectile = (Projectile) iterator.next();
			projectile.update();
			if (projectile.y < 0) {
				projectile.isActive = false;
			}
		}
	}
	void draw(Graphics g) {
		spaceship.draw(g);
		for (Iterator iterator = aliens.iterator(); iterator.hasNext();) {
			Alien alien = (Alien) iterator.next();
			alien.draw(g);

		}
		for (Iterator iterator = projectiles.iterator(); iterator.hasNext();) {
			Projectile projectile = (Projectile) iterator.next();
			projectile.draw(g);
		}
	}
	void purgeObjects() {
		for (Iterator iterator = aliens.iterator(); iterator.hasNext();) {
			Alien alien = (Alien) iterator.next();
			if (alien.isActive == false) {
				iterator.remove();
			}
		}
		for (Iterator iterator = projectiles.iterator(); iterator.hasNext();) {
			Projectile projectile = (Projectile) iterator.next();
			if (projectile.isActive == false) {
				iterator.remove();
			}
		}			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		addAlien();
	}
}

