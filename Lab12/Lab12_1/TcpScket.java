package Lab12.Lab12_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpScket {
	private BufferedReader reader; //�����ֽ�������reader
	private ServerSocket server ; //����ServerSocket����
	private Socket socket; //����socket����
	
	void getserver() {
		try {
			server = new ServerSocket(8998); //ʵ����socket����
			System.out.println("�������׽����Ѿ������ɹ�");
			while(true) {
				System.out.println("�ȴ��ͻ�������");
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
			while(true) {  //����׽���������״̬
				System.out.println("�ͻ���" + reader.readLine()); //��ȡ�ͻ�����Ϣ
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			if(reader != null) {
				reader.close(); //�ر���
			}
			if(socket != null) {
				socket.close(); //�ر��׽���
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
