package Lab12_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class Receive extends JFrame implements Runnable , ActionListener{
	int port;
	InetAddress group = null; //  声明InetAddress对象
	MulticastSocket socket = null; //创建多点广播套接字对象
	JButton ince = new JButton("开始接收");
	JButton stop = new JButton("停止接收");
	JTextArea inceAr = new JTextArea(10,10);
	JTextArea inced = new JTextArea(10,10);
	Thread thread ; 
	boolean b = false;
	
	public Receive() {
		super("广播数据报");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		thread = new Thread(this);
		ince.addActionListener(this);
		stop.addActionListener(this);
		
		inceAr.setForeground(Color.blue);
		JPanel north = new JPanel();
		north.add(ince);
		north.add(stop);
		add(north,BorderLayout.NORTH);
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(1,2));
		center.add(inceAr);
		center.add(inced);
		add(center,BorderLayout.CENTER);
		validate(); //刷新界面
		port = 9899;
		
		try {
			group = InetAddress.getByName("255.255.10.0");
			socket = new MulticastSocket(port);
			socket.joinGroup(group);              //加入广播组
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		setBounds(100,50,360,380);
		setVisible(true);
	}
	
	public void run() {
		while(true) {
			byte data[] = new byte[1024];
			DatagramPacket packet = null;
			packet = new DatagramPacket(data,data.length,group, port);
			try {
				socket.receive(packet);
				String message = new String(packet.getData(),0,packet.getLength());
				inceAr.setText("正在接收的内容：\n" + message);
				inced.append(message + "\n");
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			if(b == true) {
				break;
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == ince) {
			ince.setBackground(Color.RED);
			stop.setBackground(Color.yellow);
			if(!(thread.isAlive())) {
				thread = new Thread(this);
			}
			thread.start();
			b = false;
		}
		
		if(e.getSource() == stop) {
			ince.setBackground(Color.yellow);
			stop.setBackground(Color.RED);
			b = true;
		}
	}
	
	public static void main(String[] args) {
		Receive rec = new Receive();
		rec.setSize(460,200);
		
	}
	
}
