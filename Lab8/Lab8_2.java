package Lab8;


import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class f2 {
	f2() {
		JFrame k1 = new JFrame();
		k1.setTitle("投票系统");
		k1.setBounds(400,200,800,870);
		Container container = k1.getContentPane();
		container.setLayout(null); //绝对布局
		//下面是投票系统的划分
		
		//第一个人的按钮设置
		JLabel name1 = new JLabel();
		name1.setBounds(100,50,50,20);
		name1.setText("黄少天");
		JButton bt1 = new JButton("投票");
		bt1.setBounds(150, 39, 70, 40);
		final JLabel color1 = new JLabel();
		color1.setOpaque(true);
		color1.setBounds(230,45,10,30);
		color1.setBackground(Color.RED);
		final int i = 10;
		bt1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					k  += 10;
					color1.setBounds(230,45, k ,30);
				}
				
				public int k = 10;
			
			
			}
		);
		container.add(color1);
		container.add(bt1);
		container.add(name1);
		
		//第二个人的按钮设置
		JLabel name2 = new JLabel();
		name2.setBounds(100,100,50,20);
		name2.setText("黄小淇");
		JButton bt2 = new JButton("投票");
		bt2.setBounds(150, 89, 70, 40);
		final JLabel color2 = new JLabel();
		color2.setOpaque(true);
		color2.setBounds(230,95,10,30);
		color2.setBackground(Color.RED);
		bt2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					k2  += 10;
					color2.setBounds(230, 95, k2 ,30);
				}
				
				public int k2 = 10;
			
			
			}
		);
		container.add(color2);
		container.add(bt2);
		container.add(name2);
		
		//第三个人的按钮设置
		JLabel name3 = new JLabel();
		name3.setBounds(100,150,50,20);
		name3.setText("黄小");
		JButton bt3 = new JButton("投票");
		bt3.setBounds(150, 139, 70, 40);
		final JLabel color3 = new JLabel();
		color3.setOpaque(true);
		color3.setBounds(230,145,10,30);
		color3.setBackground(Color.RED);
		bt3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					k3  += 10;
					color3.setBounds(230, 145, k3 ,30);
				}
				
				public int k3 = 10;
			
			
			}
		);
		container.add(color3);
		container.add(bt3);
		container.add(name3);
		
		
		//第四个人的按钮设置
		JLabel name4 = new JLabel();
		name4.setBounds(100,200,50,20);
		name4.setText("黄小小");
		JButton bt4 = new JButton("投票");
		bt4.setBounds(150, 189, 70, 40);
		final JLabel color4 = new JLabel();
		color4.setOpaque(true);
		color4.setBounds(230,195,10,30);
		color4.setBackground(Color.RED);
		bt4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					k4  += 10;
					color4.setBounds(230, 195, k4 ,30);
				}
				
				public int k4 = 10;
			
			
			}
		);
		container.add(color4);
		container.add(bt4);
		container.add(name4);
		
		
		
		k1.setVisible(true);
		
		
		
	}

	private void setVisible(boolean b) {
		// TODO 自动生成的方法存根
		
	}
}


public class Lab8_2 {
	public static void main(String[] args) {
		new f2();
	}
}
