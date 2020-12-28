package Lab10;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Lab10_2 extends JFrame {
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane = null;
	private JPanel jContentPane = null;
	private JTextArea jTextArea = null;
	private JPanel controlPanel = null;
	private JButton openButton = null;
	private JButton closeButton = null;
	
	private JButton getOpenButton() {
		if(openButton == null) {
			openButton = new JButton();
			openButton.setText("д���ļ�");
			openButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO �Զ����ɵķ������
					File file = new File("word.txt"); //�����ļ�����
					try {
						FileWriter out = new FileWriter(file);
						String s = jTextArea.getText();
						out.write(s);
						out.close();
					} catch(Exception e1) {
						e1.printStackTrace();
					}
				}
					
			});
		}
		return openButton;
	}
	
	private JButton getCloseButton() {
		if(closeButton == null) {
			closeButton = new JButton();
			closeButton.setText("��ȡ�ļ�");
			closeButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO �Զ����ɵķ������
						File file = new File("word.txt");
						try {
							FileReader in = new FileReader(file);
							char byt[] = new char[1024];
							int len = in.read(byt);
							jTextArea.setText(new String(byt,0,len));
							in.close();
						} catch(Exception e1) {
							e1.printStackTrace();
						}
					}
				
			});
		}
		return closeButton;
	}
	
	public Lab10_2() {
		super();
		initialize();
	}
	
	//����Ĵ���
	private void initialize() {
		// TODO �Զ����ɵķ������
		this.setBounds(100,100,400,300);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	private JPanel getJContentPane() {
		// TODO �Զ����ɵķ������
		if(jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout(5,5));
			jContentPane.add(getJTextArea(),BorderLayout.CENTER);
			jContentPane.add(getControlPanel(),BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	
	//����д
	private JPanel getControlPanel() {
		// TODO �Զ����ɵķ������
		if(controlPanel == null) {
			FlowLayout flowlayout = new FlowLayout(); // ʹ��������
			flowlayout.setVgap(1);
			controlPanel = new JPanel();
			controlPanel.setLayout(flowlayout);
			JButton open1 = getOpenButton();
			JButton close1 = getCloseButton();
			controlPanel.add(open1,null);
			controlPanel.add(close1,null);
			
		}
		return controlPanel;
	}

	private JTextArea getJTextArea() {
		// TODO �Զ����ɵķ������
		if(jTextArea == null) {
				jTextArea = new JTextArea();
		}
		return jTextArea;
	}

	//���첹����
	
	public static void main(String[] args) {
		Lab10_2 k = new Lab10_2();
		k.setDefaultCloseOperation(	JFrame.EXIT_ON_CLOSE);
		k.setVisible(true);
	}
}
