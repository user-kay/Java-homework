package Lab12.Lab12_1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class Myclien extends JFrame {
	private PrintWriter writer; //����PrintWriter����
	Socket socket;
	private JTextArea ta = new JTextArea() ; //����JTextArea����
	private JTextField tf = new JTextField() ; //����JTextField����
	Container cc ;
	
	public Myclien(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cc = this.getContentPane();
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        cc.add(tf,"South");
        tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				writer.println(); //���ı�����Ϣд������
				ta.append(tf.getText()); //���ı����е���Ϣ��ʾ����������
				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); //���ı������
			}
        	
        });
	}
	
	//�����׽��ֵķ���
	private void connect() {
		ta.append("��������\n");
		try {
			socket = new Socket("127.0.0.1", 8998);
			writer = new PrintWriter(socket.getOutputStream());
			ta.append("�������\n");
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	public static void main(String[] args) {
		Myclien clien = new Myclien("���������������");
		clien.setSize(200,200);
		clien.setVisible(true);
		clien.connect();
	}
	
}
