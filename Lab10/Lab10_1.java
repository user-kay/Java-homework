package Lab10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Lab10_1 {
	public static void main(String[] args) {
		File file = new File("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\guess.txt");
//		if(file.exists()) {
//			System.out.println("文件已存在");
//		}
//		else {
//			try {
//				file.createNewFile();
//				System.out.println("文件已创建");
//				//建立一个文件输入流
//				FileOutputStream out = new FileOutputStream(file);
//				byte by[] = "Java程序设计".getBytes();
//				out.write(by);
//				out.close();
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
			try {
				FileInputStream in = new FileInputStream(file);
				byte byt[] = new byte[1024];
				int len = in.read(byt);
				System.out.println("文件中的信息为：" + new String(byt,0,len));
				in.close();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
//}
