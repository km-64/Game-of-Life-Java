import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	
	private final static int WINDOW_WIDTH = 1000;
	private final static int WINDOW_HEIGHT = 1000;
	
	private final static int GRID_WIDTH = 500;
	private final static int GRID_HEIGHT = 500;
	
	public static void main(String[] args) {
		Grid grid = new Grid(GRID_WIDTH, GRID_HEIGHT, 0.2);
		GFX gfx = new GFX(WINDOW_WIDTH, WINDOW_HEIGHT, grid);
		while(true) {	
			
			try {			
				TimeUnit.MILLISECONDS.sleep(20);
			} catch(InterruptedException e) {}
			
			grid.update();
			gfx.repaint();
		}
	}
}
