package LeagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	public int score = 0;
	long enemyTimer;
	int enemySpawnTime = 1000;
	Rocketship rocket;
	ArrayList<Projectiles> projectiles = new ArrayList<Projectiles>();
	ArrayList<Aliens> aliens = new ArrayList<Aliens>();

	ObjectManager(Rocketship rs) {
		rocket = rs;

	}

	void update() {
		rocket.update();
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();

		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
	}

	void addProjectile(Projectiles p) {
		projectiles.add(p);
	}

	void addAlien(Aliens a) {
		aliens.add(a);
	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAlien(new Aliens(new Random().nextInt(LeagueInvaders.WIDTH - 50), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}

	}

	void purgeObjects() {
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).isAlive == false) {
				aliens.remove(i);
			}
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isAlive == false) {
				projectiles.remove(i);
			}
		}
	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {

			if (rocket.collisionBox.intersects(aliens.get(i).collisionBox)) {

				rocket.isAlive = false;

			}

		}
		for (int i = 0; i < projectiles.size(); i++) {
			for (int x = 0; x < aliens.size(); x++) {
				if (projectiles.get(i).collisionBox.intersects(aliens.get(x).collisionBox)) {
					aliens.get(x).isAlive = false;
					projectiles.get(i).isAlive = false;
					score++;
				}
			}
		}

	}

}
