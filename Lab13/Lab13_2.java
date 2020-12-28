package Lab13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lab13_2 {
	static Connection con;
	static PreparedStatement sql; //����PreparedStatement����
	static ResultSet res; //����ResultSet����
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql:" + "//127.0.0.1:3308/test","root","123456");
		} catch(Exception e) { 
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		Lab13_2 c = new Lab13_2();
		con = c.getConnection();
		try {
			sql = con.prepareStatement("select * from tb_stu"); //��ѯ���ݿ�
			res = sql.executeQuery();
			System.out.println("ִ�����ӡ��޸ġ�ɾ��ǰ������");
			//������ѯ�����
			while(res.next()) {
				String id = res.getString(1);
				String name = res.getString("name");
				String sex = res.getString("sex");
				String birthday = res.getString("birthday");
				System.out.println("���" + id);
				System.out.println("����" + name);
				System.out.println("�Ա�" + sex);
				System.out.println("����" + birthday);
			} 
			//Ԥ�����������
			sql = con.prepareStatement("insert into tb_stu" + " values(?,?,?)" );
			sql.setString(1, "��һ");
			sql.setString(2,"Ů");
			sql.setString(3,"2012-12-1");
			sql.executeUpdate();
			//��������
			sql = con.prepareStatement("delete from tb_stu set birthday" + "=? where id = (select min(id)  from tb_stu)");
			sql.setString(1, "2020-12-02");
			sql.executeUpdate(); // => ����һ������
			//ɾ������
			sql.setInt(1, 1);
			sql.executeUpdate();
			sql = con.prepareStatement("select * from tb_stu");
			res = sql.executeQuery(); //��ѯ�޸����ݺ�tb_stu���е�����
			System.out.println("ִ�����ӡ��޸ġ�ɾ��ŷ���Ĳ���");
			while(res.next()) {
				String id = res.getString(1);
				String name = res.getString("name");
				String sex = res.getString("sex");
				String birthday = res.getString("birthday");
				System.out.println("���" + id);
				System.out.println("����" + name);
				System.out.println("�Ա�" + sex);
				System.out.println("����" + birthday);
			}
		}  catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
