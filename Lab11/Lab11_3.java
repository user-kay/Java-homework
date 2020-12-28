package Lab11;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JProgressBar;

public class Lab11_3 extends JFrame {
	private Thread threadA;
	private Thread threadB; //���������߳�
	final JProgressBar progressBar = new JProgressBar();
	final JProgressBar progressBar2 = new JProgressBar();//��������������������Ƚ�ֱ��
	int count = 0 ;
	
	public static void main(String[] args) {
		System.out.println("���������ڳ���״̬");
		init(new Lab11_3() , 100,100);	
		System.out.println("");
	}
	
	//��ʼ��һ�´���
	private static void init(JFrame jf, int i, int j) {
		// TODO �Զ����ɵķ������
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(i, j);
		jf.setVisible(true);
	}

	public Lab11_3() {
		super();
		getContentPane().add(progressBar,BorderLayout.NORTH);
		getContentPane().add(progressBar2,BorderLayout.SOUTH);
		//�����ý�������ʾ�����ַ�
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
						System.out.println("�̱߳��ж�");
						break;
					}
				}
			}	
		});
		System.out.println("�߳�A����");
		threadA.start();
		System.out.println("�߳�A����");
		
		threadB = new Thread(new Runnable() {
			int count = 0;
			@Override
			public void run() {
				// TODO �Զ����ɵķ������
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
		System.out.println("�߳�B����");
		threadA.interrupt();
	}
}
