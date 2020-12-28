package Lab11;

import java.awt.Container;
import java.net.URL;
import java.util.Random;

import javax.swing.*;



public class lab11_1 extends JFrame {
	private JLabel jl = new JLabel(); //����JLabel����
	private static Thread t;//�����̶߳���
	private int count = 0 ; //������������
	private Container container = getContentPane();
	private final int num = 40;
	private JLabel js[] = new JLabel[num];
	
	class Snowfall extends Thread {
		int step = 1;
		int sleeptime = 100; //��������ʱ��
		int count = 0; //ѩ��������
		int wh = -1; //��ʼ����ֵ
		Random num1 = new Random();
		Snowfall(int wh) { 
			this.wh = wh;
			sleeptime = 15 + num1.nextInt(15); //��1��15����ѡ�����
			count = -150 + ( wh / 10 ) * 50;
		}
		
		public void run() {
			while(count <= 330) {
				js[wh].setBounds(15 + (wh % 10) * 35, count, 30, 30);
				try {
					Thread.sleep(sleeptime);
				} catch(Exception e) {
					e.printStackTrace();
				}
				count += step;
				if(count == 330) {
					count -= 50;
					sleeptime = 15 + num1.nextInt(15);
				}
			}
		}
	}
	
	public lab11_1() {
		setBounds(300,200,250,100);
		container.setLayout(null);
		URL url = lab11_1.class.getResource("1.gif");
		Icon icon = new ImageIcon(url);
	
		
		for(int i = 0 ; i < num ; i++) {
			js[i] = new JLabel();
			js[i].setIcon(icon); //��ͼƬ�ŵ���ǩ��
			js[i].setBounds(15 + (i % 10) * 40 ,-150 + (i / 10) * 50  ,30,30);
			js[i].setOpaque(true);
			t = new Snowfall(i);
			t.start(); //�����߳�
			container.add(js[i]);
		}
		
		
		setVisible(true);
		//���ô���Ĺرշ�ʽ
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String[] args) {
			new lab11_1();
	}


}
