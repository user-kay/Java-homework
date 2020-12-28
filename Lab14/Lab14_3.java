package Lab14;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Lab14.Lab14_1.CanvasPanel;

public class Lab14_3 extends JFrame {
private static final long serialVersionUID = 1L;
	
	public Lab14_3() {
		super();
		initialize();
		
	}
	
	private void initialize() {
		// TODO 自动生成的方法存根
		this.setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new CanvasPanel());
		
		this.setTitle("作业3");
	}

	
	
	public static void main(String[] args) {
		new Lab14_3().setVisible(true);
	}
	
	class CanvasPanel extends JPanel {
		public void paint(Graphics g) {
			setBackground(new java.awt.Color( 0,128,255));
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			g.setColor(Color.BLUE);
			Shape[] shapes = new Shape[6];
			
			shapes[0] = new Rectangle2D.Double(15, 25 , 600, 400);
			shapes[1] = new Ellipse2D.Double(100, 80, 150, 150);
			shapes[2] = new Ellipse2D.Double(200, 80, 150, 150);
			shapes[3] = new Ellipse2D.Double(300, 80, 150, 150);
			shapes[4] = new Ellipse2D.Double(140, 180, 150, 150);
			shapes[5] = new Ellipse2D.Double(240, 180, 150, 150);
			
			g2.setColor(Color.WHITE);
			g2.fill(shapes[0]);
			g2.draw(shapes[0]);
			
			g2.setColor(Color.BLUE);
			g2.draw(shapes[1]);
			
			g2.setColor(Color.BLACK);
			g2.draw(shapes[2]);
			
			g2.setColor(Color.RED);
			g2.draw(shapes[3]);
			
			g2.setColor(Color.YELLOW);
			g2.draw(shapes[4]);
			
			g2.setColor(Color.GREEN);
			g2.draw(shapes[5]);
			
			Font font = new Font("幼圆",Font.BOLD,16);
			
			g2.setFont(font);
			g2.setColor(Color.BLACK);
			g2.drawString("Olympic",240,390);
			
		
		}
	}
	
}
