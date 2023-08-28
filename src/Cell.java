
public class Cell {
	
	int x, y;
	
	private boolean state;
	private boolean nextState;
	
	private Grid grid;
	
	boolean getState() { return state; }
	
	Cell(int x, int y, boolean state, Grid grid) {
		this.x = x;
		this.y = y;
		this.state = state;
		this.grid = grid;
	}

	private int getActiveNeighbours() {
		int active = 0;
		Cell[][] cells = grid.getCells();
		
		for(int oy = -1; oy <= 1; oy++) {
			for(int ox = -1; ox <= 1; ox++) {
				try {
					active += cells[x+ox][y+oy].state ? 1 : 0;					
				} catch (Exception e) { continue; }
			}
		}
		active -= this.state ? 1 : 0; // Subtract self state
		
		return active;
	}
	
	void applyRule() {
		int activeNeighbours = getActiveNeighbours();
		if(state) { // is on
			if(activeNeighbours <= 1 || activeNeighbours >= 4) nextState = false;
			else if(activeNeighbours == 2 || activeNeighbours == 3) nextState = true;
		}
		else { // is off
			if(activeNeighbours == 3) nextState = true;
		}
	}
	
	void update() {
		state = nextState;
	}
}
