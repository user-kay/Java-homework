package Lab10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Lab10_1 {
	public static void main(String[] args) {
		File file = new File("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\guess.txt");
//		if(file.exists()) {
//			System.out.println("�ļ��Ѵ���");
//		}
//		else {
//			try {
//				file.createNewFile();
//				System.out.println("�ļ��Ѵ���");
//				//����һ���ļ�������
//				FileOutputStream out = new FileOutputStream(file);
//				byte by[] = "Java�������".getBytes();
//				out.write(by);
//				out.close();
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
			try {
				FileInputStream in = new FileInputStream(file);
				byte byt[] = new byte[1024];
				int len = in.read(byt);
				System.out.println("�ļ��е���ϢΪ��" + new String(byt,0,len));
				in.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
//}
