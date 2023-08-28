
public class Grid {
	
	private int width, height;
	private Cell [][] cells;
	
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	
	public Cell[][] getCells() { return cells; }
	
	Grid(int width, int height, double activeCellsPct) {
		this.width = width;
		this.height = height;
		
		cells = new Cell[width][height];
		
		for(int y=0; y<height; y++) {
			for(int x=0; x<width; x++) {
				boolean rndState  = Math.random() < activeCellsPct;
				cells[x][y] = new Cell(x, y, rndState, this);
			}
		}
	}
	
	void update() {
		for(Cell[] row : cells) {
			for(Cell cell : row) {
				cell.applyRule();
			}
		}
		
		for(Cell[] row : cells) {
			for(Cell cell : row) {
				cell.update();
			}
		}
	}
}
