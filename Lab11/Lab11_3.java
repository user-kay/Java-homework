package Lab11;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Lab11_3 extends JFrame {
	private Thread threadA;
	private Thread threadB; //定义两个线程
	final JProgressBar progressBar = new JProgressBar();
	final JProgressBar progressBar2 = new JProgressBar();//定义两个进度条组件，比较直观
	int count = 0 ;
	
	public static void main(String[] args) {
		System.out.println("现在正处于出生状态");
		init(new Lab11_3() , 100,100);	
		System.out.println("");
	}
	
	//初始化一下窗体
	private static void init(JFrame jf, int i, int j) {
		// TODO 自动生成的方法存根
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(i, j);
		jf.setVisible(true);
	}

	public Lab11_3() {
		super();
		getContentPane().add(progressBar,BorderLayout.NORTH);
		getContentPane().add(progressBar2,BorderLayout.SOUTH);
		//下面让进度条显示数字字符
		progressBar.setStringPainted(true);
		progressBar2.setStringPainted(true);
		
		threadA = new Thread(new Runnable() {
			int count = 0;
			@Override
			public void run() {
				while(true) {
					
					progressBar.setValue(++count);
					try {
						Thread.sleep(10);
						threadB.join();
					} catch(InterruptedException e) {
						System.out.println("线程被中断");
						break;
					}
				}
			}	
		});
		System.out.println("线程A就绪");
		threadA.start();
		System.out.println("线程A启动");
		
		threadB = new Thread(new Runnable() {
			int count = 0;
			@Override
			public void run() {
				// TODO 自动生成的方法存根
				while(true) {
					progressBar2.setValue(++count);
					try {
						Thread.sleep(100);
					} catch(Exception e) {
						e.printStackTrace();
					}
					if(count == 100) {
						break;
					}
				}
			}
	
		});
		threadB.start();
		System.out.println("线程B启动");
		threadA.interrupt();
	}
}
