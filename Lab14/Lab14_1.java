package Lab14;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lab14_1 extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public Lab14_1() {
		super();
		initialize();
		
	}
	
	private void initialize() {
		// TODO 自动生成的方法存根
		this.setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new CanvasPanel());
		this.setTitle("作业1");
	}

	
	
	public static void main(String[] args) {
		new Lab14_1().setVisible(true);
	}
	
	class CanvasPanel extends JPanel {
		public void paint(Graphics g) {
			super.paint(g);
			Graphics2D g2 = (Graphics2D)g;
			Shape[] shapes = new Shape[4];
			shapes[0] = new Ellipse2D.Double(300, 100, 100, 100);
		
//			g2.setColor(Color.RED);
			g2.draw(shapes[0]);
//			g2.fill(shapes[0]);
			g2.drawOval(200, 70, 230, 200);  
			Font font = new Font("幼圆",Font.BOLD,16);
			
			g2.setFont(font);
			g2.drawString("Sun",340,150);
			g2.setColor(Color.BLUE);
		
			g2.drawString("★",198,200);
		}
	}
	
}
