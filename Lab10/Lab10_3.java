package Lab10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

//a、使用writeUTF()方法创建并保存一个名为MyText.txt的文件 （参考例15.6）
//
//b、将MyText.txt压缩成MyText.zip文件 （参考例15.7）
//
//c、将MyText.zip解压缩成NewText.txt文件（参考例15.8）
//
//d、使用readUTF（）方法读取NewTxt.txt的内容，并显示在控制台中。（参考例15.6）

public class Lab10_3 {
	
	private void zip(String zipFileName,File inputFile) throws Exception {
		//参数为压缩后的文件（带有位置的) 和 要压缩的文件名
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));//创建一个ZipOutputStream的对象
		zip2(out,inputFile,"");//进入函数zip2中进行具体的相关操作
		System.out.println("压缩中....");
		out.close();
	}
	
	
	private void zip2(ZipOutputStream out, File f, String base)  throws Exception {
		//如果file是个目录文件
		if(f.isDirectory()) {
			File[] fl = f.listFiles();//获取路径数组
			if(base.length() != 0) {
				out.putNextEntry(new ZipEntry(base + "/")); // 写入该目录的位置
			}
			//如果没有
			for(int i = 0 ; i < fl.length ; i++) {
				zip2(out,fl[i],base + fl[i]);
			}
		}
		//只是一个普通文件的情况
		else {
			out.putNextEntry(new ZipEntry(base));//创建新的接入点
			FileInputStream in = new FileInputStream(f); //in是一个文件输入流对象
			int k;
			System.out.println(base + " ");
			while((k = in.read()) != - 1) {// 没有到达文件流的地步 
				out.write(k);
			}
			in.close();
 		}	
	}


	public static void main(String[] args) {
		try {
			FileOutputStream fs = new FileOutputStream("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\MyText.txt"); //创建FileOutputStream类对象
			DataOutputStream ds = new DataOutputStream(fs); //创建DataOutput类对象
			ds.writeUTF("cjq,yyds");
			ds.close();//创建并写入了
			
			//下面开始进行压缩文档
			Lab10_3 kk = new Lab10_3();
			File m1 = new File("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\MyText.txt");
			kk.zip("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\MyText.zip", m1);
			System.out.println("压缩成功");	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		File m2 = new File("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\MyText.zip");
		//下面开始解压缩文档
		
		System.out.println("开始解压");
		ZipInputStream zin; //创建ZipInputSream对象
		try {
			ZipFile zipFile =  new ZipFile(m2);//创建压缩文件对象
			zin = new ZipInputStream(new FileInputStream(m2));
			ZipEntry entry = zin.getNextEntry();
//			while((   (entry = zin.getNextEntry()) != null) && !entry.isDirectory() ) {
				//如果entry不为空，且不在同一目录下
				System.out.println("进入循环");
				File tmp = new File("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\NewText.txt");
				if(!tmp.exists()) {
					tmp.getParentFile().mkdirs(); //如果该文件不存在
					OutputStream os = new FileOutputStream(tmp);
					//下面用输入流读取压缩文件中指定目录中的文件
					InputStream in = zipFile.getInputStream(entry);
					int count = 0 ;
					while( (count = in.read()) != -1) {
						//如果有输入流，可以读取到数值
						os.write(count); //输入流写入
					}
					os.close();
					in.close();
				}
				zin.closeEntry();
				System.out.println("NewText解压缩成功");
//			}
			zin.close();
		} catch(Exception e) {
			System.out.println("这里错了");
			e.printStackTrace();
		}
		
		//下面开始输出文件内容
		try {
			FileInputStream fis = new FileInputStream("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\NewText.txt");
			DataInputStream dis = new DataInputStream(fis);
			System.out.println(dis.readUTF());
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
