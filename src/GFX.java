import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GFX extends JPanel {

	private int width, height;
	private Grid grid;
	
	GFX(int width, int height, Grid grid) {
		this.width = width;
		this.height = height;
		this.grid = grid;
		
		setPreferredSize(new Dimension(this.width, this.height));
		JFrame frame = new JFrame();
		frame.setTitle("Conway's Game of Life");
		GFX objGFX = this;
		frame.setContentPane(objGFX);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.BLACK);
		Cell[][] cells = grid.getCells();
		int gWidth = grid.getWidth();
		int gHeight = grid.getHeight();
		int cellX = width/gWidth;
		int cellY = height/gWidth;
		for(int y=0; y<gHeight; y++) {
			for(int x=0; x<gWidth; x++) {
				Cell cell = cells[x][y];
				if(cell.getState() == true) {
					g.fillRect(x*cellX, y*cellY, cellX, cellY);
				}
			}
		}
	}
}
