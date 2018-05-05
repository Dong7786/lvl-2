import java.awt.Color;
import java.util.Random;

import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

public class GridWorld {
	static Random rand = new Random();
	
int color;
	public static void main(String[] args) {
	if(rand.nextInt(6) == 0) {
		
		
	}

		World world = new World();
		Bug bug = new Bug(Color.blue);
		bug.turn();
		bug.turn();
		world.show();
		
			
		for(int i = 0; i <= 9; i ++) {
			Flower f = new Flower();
			f.setColor(Color.red);
			Location l = new Location(0 ,i);
			
		world.add(l , f);
		for(int d = 0; d <= 9; d ++) {
			Flower h = new Flower();
			h.setColor(Color.white);
			Location j = new Location(1,d);
			
		world.add(j , h);
		}
		
		
	
		world.add(new Location(rand.nextInt(9), rand.nextInt(9)), new Bug());
		world.add(new Location(rand.nextInt(9), rand.nextInt(9)), bug);
}
}
}