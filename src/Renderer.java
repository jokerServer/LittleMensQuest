import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Renderer extends Canvas {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferStrategy bf;
	
	public Renderer(){
		setBackground(Color.WHITE);
		setForeground(Color.BLACK);
		JFrame gui = new JFrame("Little Mens Quest");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(800, 600);
		gui.setLayout(new BorderLayout());
		gui.add(this, BorderLayout.CENTER);
		gui.setVisible(true);
		gui.createBufferStrategy(2);
		createBufferStrategy(2);
		bf = getBufferStrategy();
	}

	public void render(Graphics g) {
		ArrayList<Entity> entitys = Entity.getEntitys();
		for (int i = 0; i < entitys.size(); i++) {
			entitys.get(i).drawYourself(g);
		}
	}

	@Override
	public void paint(Graphics a) {
		Graphics g = null;
		try {
			g = bf.getDrawGraphics();
			g.setColor(getBackground());
			g.fillRect(0, 0, getSize().width, getSize().height);
			g.setColor(getForeground());
			render(g);
		} finally {
			g.dispose();
		}
		bf.show();
		Toolkit.getDefaultToolkit().sync();
	}
}
