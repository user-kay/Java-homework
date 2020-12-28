package Lab7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

interface Icon {
	public int getIconHeight();
	public int getIconWidth();
	public void paintIcon(Component arg0,Graphics arg1,int ag1,int arg2);
}

class MyJDialog extends JDialog {
	MyJDialog(Lab7_1 frame) {
		super(frame,"��һ������",true);
		Container container = getContentPane();
		container.add(new JLabel("����һ���Ի���"));
		setBounds(10,10,100,21);
	}
}

//�����Ի���Ĺ���ʵ����

class DrawIcon implements Icon, javax.swing.Icon {
	private int width, height;
	
	public DrawIcon(int x,int y) {
		this.width = x;
		this.height = y;
	}
	
	public int getIconHeight() {
		return this.height;
	}
	
	public int getIconWidth() {
		return this.width;
	}
	
	public void paintIcon(Component arg0,Graphics arg1,int x,int y) {
		arg1.fillOval(x,y,width,height);
	}
	
	
}

public class Lab7_1 extends JFrame implements Icon{
	private int width, height;
	public int getIconHeight() {
		return this.height;
	}
	
	public int getIconWidth() {
		return this.width;
	}
	
	public void paintIcon(Component arg0,Graphics arg1,int x,int y) {
		arg1.fillOval(x,y,width,height);
	}
	
	
	public static void main(String[] args) {
		new Lab7_1();
	}
	

	public  Lab7_1() {
		DrawIcon icon =new DrawIcon(15,15);
		Container container = getContentPane();
		container.setLayout(null);
		JLabel jl = new JLabel("����һ��JFrame����",icon ,SwingConstants.CENTER);
		container.add(jl);
		JButton bl = new JButton("����һ���Ի���");
		bl.setBounds(20, 20, 100, 21);
		bl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					new MyJDialog(Lab7_1.this).setVisible(true);
				}
			}
		);
		container.add(bl);
		setVisible(true);
	}
}
