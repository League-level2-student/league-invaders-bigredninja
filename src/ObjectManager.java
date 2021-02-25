import java.util.ArrayList;

public class ObjectManager {
	public void addProjectile(Projectile projectile ) {
		projectiles.add(projectile);
		
		
		
		
		
		
	}
	ArrayList<Projectile> projectiles;
	Rocketship spaceship;
	public ObjectManager( Rocketship spaceship) {
		this.spaceship = spaceship;
		projectiles = new ArrayList<Projectile>();	
}
}
