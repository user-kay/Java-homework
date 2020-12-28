package Lab13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lab13_2 {
	static Connection con;
	static PreparedStatement sql; //声明PreparedStatement对象
	static ResultSet res; //声明ResultSet对象
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
			sql = con.prepareStatement("select * from tb_stu"); //查询数据库
			res = sql.executeQuery();
			System.out.println("执行增加、修改、删除前的数据");
			//遍历查询结果集
			while(res.next()) {
				String id = res.getString(1);
				String name = res.getString("name");
				String sex = res.getString("sex");
				String birthday = res.getString("birthday");
				System.out.println("编号" + id);
				System.out.println("姓名" + name);
				System.out.println("性别" + sex);
				System.out.println("生日" + birthday);
			} 
			//预处理添加数据
			sql = con.prepareStatement("insert into tb_stu" + " values(?,?,?)" );
			sql.setString(1, "张一");
			sql.setString(2,"女");
			sql.setString(3,"2012-12-1");
			sql.executeUpdate();
			//更新数据
			sql = con.prepareStatement("delete from tb_stu set birthday" + "=? where id = (select min(id)  from tb_stu)");
			sql.setString(1, "2020-12-02");
			sql.executeUpdate(); // => 更新一下数据
			//删除数据
			sql.setInt(1, 1);
			sql.executeUpdate();
			sql = con.prepareStatement("select * from tb_stu");
			res = sql.executeQuery(); //查询修改数据后tb_stu表中的数据
			System.out.println("执行增加、修改、删除欧虎的操作");
			while(res.next()) {
				String id = res.getString(1);
				String name = res.getString("name");
				String sex = res.getString("sex");
				String birthday = res.getString("birthday");
				System.out.println("编号" + id);
				System.out.println("姓名" + name);
				System.out.println("性别" + sex);
				System.out.println("生日" + birthday);
			}
		}  catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
