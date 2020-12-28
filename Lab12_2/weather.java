package Lab12_2;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class weather extends Thread {
	String weather1 = "节目预报:吴凡，yyds";
	int port = 9898; //定义端口
	InetAddress iaddress = null; //创建InetAddress对象
	MulticastSocket socket = null; //声明多点广播套接字
	
	//构造函数
	weather() {
		try {
			iaddress = InetAddress.getByName("224.255.10.0");
			socket = new MulticastSocket(port);
			socket.setTimeToLive(1);
			socket.joinGroup(iaddress); 
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
			DatagramPacket packet = null;
			byte data[] = weather1.getBytes();
			packet = new DatagramPacket(data,data.length,iaddress,port);
			System.out.println(new String(data)); //输出广播信息
			try {
				socket.send(packet);
				sleep(3000);
			} catch(Exception e) {
			  e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		weather w = new weather();
		w.start();
	}
	
}
