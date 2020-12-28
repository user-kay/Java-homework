package Lab12.Lab12_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpScket {
	private BufferedReader reader; //创建字节流对象reader
	private ServerSocket server ; //创建ServerSocket对象
	private Socket socket; //创建socket对象
	
	void getserver() {
		try {
			server = new ServerSocket(8998); //实例化socket对象
			System.out.println("服务器套接字已经创建成功");
			while(true) {
				System.out.println("等待客户机连接");
				socket = server.accept();
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				getClientMessage(); 
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getClientMessage() {
		try {
			while(true) {  //如果套接字是连接状态
				System.out.println("客户机" + reader.readLine()); //获取客户端信息
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(reader != null) {
				reader.close(); //关闭流
			}
			if(socket != null) {
				socket.close(); //关闭套接字
			}
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TcpScket tcp = new TcpScket();
		tcp.getserver();
	}
	
	
}
