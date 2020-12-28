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

//a��ʹ��writeUTF()��������������һ����ΪMyText.txt���ļ� ���ο���15.6��
//
//b����MyText.txtѹ����MyText.zip�ļ� ���ο���15.7��
//
//c����MyText.zip��ѹ����NewText.txt�ļ����ο���15.8��
//
//d��ʹ��readUTF����������ȡNewTxt.txt�����ݣ�����ʾ�ڿ���̨�С����ο���15.6��

public class Lab10_3 {
	
	private void zip(String zipFileName,File inputFile) throws Exception {
		//����Ϊѹ������ļ�������λ�õ�) �� Ҫѹ�����ļ���
		ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));//����һ��ZipOutputStream�Ķ���
		zip2(out,inputFile,"");//���뺯��zip2�н��о������ز���
		System.out.println("ѹ����....");
		out.close();
	}
	
	
	private void zip2(ZipOutputStream out, File f, String base)  throws Exception {
		//���file�Ǹ�Ŀ¼�ļ�
		if(f.isDirectory()) {
			File[] fl = f.listFiles();//��ȡ·������
			if(base.length() != 0) {
				out.putNextEntry(new ZipEntry(base + "/")); // д���Ŀ¼��λ��
			}
			//���û��
			for(int i = 0 ; i < fl.length ; i++) {
				zip2(out,fl[i],base + fl[i]);
			}
		}
		//ֻ��һ����ͨ�ļ������
		else {
			out.putNextEntry(new ZipEntry(base));//�����µĽ����
			FileInputStream in = new FileInputStream(f); //in��һ���ļ�����������
			int k;
			System.out.println(base + " ");
			while((k = in.read()) != - 1) {// û�е����ļ����ĵز� 
				out.write(k);
			}
			in.close();
 		}	
	}


	public static void main(String[] args) {
		try {
			FileOutputStream fs = new FileOutputStream("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\MyText.txt"); //����FileOutputStream�����
			DataOutputStream ds = new DataOutputStream(fs); //����DataOutput�����
			ds.writeUTF("cjq,yyds");
			ds.close();//������д����
			
			//���濪ʼ����ѹ���ĵ�
			Lab10_3 kk = new Lab10_3();
			File m1 = new File("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\MyText.txt");
			kk.zip("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\MyText.zip", m1);
			System.out.println("ѹ���ɹ�");	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		File m2 = new File("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\MyText.zip");
		//���濪ʼ��ѹ���ĵ�
		
		System.out.println("��ʼ��ѹ");
		ZipInputStream zin; //����ZipInputSream����
		try {
			ZipFile zipFile =  new ZipFile(m2);//����ѹ���ļ�����
			zin = new ZipInputStream(new FileInputStream(m2));
			ZipEntry entry = zin.getNextEntry();
//			while((   (entry = zin.getNextEntry()) != null) && !entry.isDirectory() ) {
				//���entry��Ϊ�գ��Ҳ���ͬһĿ¼��
				System.out.println("����ѭ��");
				File tmp = new File("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\NewText.txt");
				if(!tmp.exists()) {
					tmp.getParentFile().mkdirs(); //������ļ�������
					OutputStream os = new FileOutputStream(tmp);
					//��������������ȡѹ���ļ���ָ��Ŀ¼�е��ļ�
					InputStream in = zipFile.getInputStream(entry);
					int count = 0 ;
					while( (count = in.read()) != -1) {
						//����������������Զ�ȡ����ֵ
						os.write(count); //������д��
					}
					os.close();
					in.close();
				}
				zin.closeEntry();
				System.out.println("NewText��ѹ���ɹ�");
//			}
			zin.close();
		} catch(Exception e) {
			System.out.println("�������");
			e.printStackTrace();
		}
		
		//���濪ʼ����ļ�����
		try {
			FileInputStream fis = new FileInputStream("G:\\eclipse-workspace\\JavaSE\\src\\Lab10\\NewText.txt");
			DataInputStream dis = new DataInputStream(fis);
			System.out.println(dis.readUTF());
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
