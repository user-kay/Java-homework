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
			openButton.setText("写入文件");
			openButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
					File file = new File("word.txt"); //创建文件对象
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
			closeButton.setText("读取文件");
			closeButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO 自动生成的方法存根
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
	
	//主体的窗口
	private void initialize() {
		// TODO 自动生成的方法存根
		this.setBounds(100,100,400,300);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
	}

	private JPanel getJContentPane() {
		// TODO 自动生成的方法存根
		if(jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout(5,5));
			jContentPane.add(getJTextArea(),BorderLayout.CENTER);
			jContentPane.add(getControlPanel(),BorderLayout.SOUTH);
		}
		return jContentPane;
	}

	
	//明天写
	private JPanel getControlPanel() {
		// TODO 自动生成的方法存根
		if(controlPanel == null) {
			FlowLayout flowlayout = new FlowLayout(); // 使用流布局
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
		// TODO 自动生成的方法存根
		if(jTextArea == null) {
				jTextArea = new JTextArea();
		}
		return jTextArea;
	}

	//明天补充完
	
	public static void main(String[] args) {
		Lab10_2 k = new Lab10_2();
		k.setDefaultCloseOperation(	JFrame.EXIT_ON_CLOSE);
		k.setVisible(true);
	}
}
