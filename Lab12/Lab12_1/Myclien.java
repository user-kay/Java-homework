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
	private PrintWriter writer; //声明PrintWriter对象
	Socket socket;
	private JTextArea ta = new JTextArea() ; //创建JTextArea对象
	private JTextField tf = new JTextField() ; //创建JTextField对象
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
				// TODO 自动生成的方法存根
				writer.println(); //将文本框信息写入流中
				ta.append(tf.getText()); //把文本框中的信息显示在文字域中
				ta.setSelectionEnd(ta.getText().length());
				tf.setText(""); //将文本框清空
			}
        	
        });
	}
	
	//连接套接字的方法
	private void connect() {
		ta.append("尝试连接\n");
		try {
			socket = new Socket("127.0.0.1", 8998);
			writer = new PrintWriter(socket.getOutputStream());
			ta.append("完成连接\n");
		} catch(Exception e) {
			e.printStackTrace();
		}
	} 
	
	public static void main(String[] args) {
		Myclien clien = new Myclien("向服务器传递数据");
		clien.setSize(200,200);
		clien.setVisible(true);
		clien.connect();
	}
	
}
