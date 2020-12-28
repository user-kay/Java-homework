package Lab11;

import java.awt.Container;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class test extends JFrame {
	int N = 40;
	private JLabel jl[] = new JLabel[N]; //����һ��JLabel��ǩ
	private static Thread t;
	private int count = 0;
	private Container container = getContentPane();
	
	
	public class snowFall extends Thread {
		int step = 1;
		int sleepTime = 100;
		int sec = -1;
		Random num1 = new Random(); //����һ�������
		snowFall(int sec) {
			this.sec = sec;
			sleepTime = 15 + num1.nextInt(15);
			count = -150 + (sec / 10) * 50 ;
			
		}
		
		public void run() {
			while(true) {
				jl[sec].setBounds(15 + (sec % 10) * 35, count, 30, 30);
				try {
					Thread.sleep(100);
				} catch(Exception e) {
					e.printStackTrace();
				}
				count += step;
				if(count == 330) {
					count -= 50;
					sleepTime = 15 + num1.nextInt(15);
				}		
			}
		}
	}
	
	
	public test() {
		setBounds(300,200,250,100);
		container.setLayout(null);
		URL url = test.class.getResource("1.gif");
		Icon icon = new ImageIcon(url);
		for(int i = 0 ; i < 40 ; i++) {
			jl[i] = new JLabel();
			jl[i].setIcon(icon);
			jl[i].setBounds(15 + (i % 10) * 40 ,-150 + (i / 10) * 50  ,30,30); //����λ��
			jl[i].setOpaque(true);
			t = new snowFall(i); //�½�һ��snowFall����
			t.start();
			container.add(jl[i]);
		}
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		new test();
	}
}
