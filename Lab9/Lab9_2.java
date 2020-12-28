package Lab9;

import java.util.Iterator;
import java.util.TreeSet;

public class Lab9_2 implements Comparable<Object> {
	String name;
	long id;
	
	public Lab9_2 (String name,long id) {
		this.id = id;
		this.name = name;
	}
	
	public int compareTo(Object o) {
		Lab9_2 stu1 = (Lab9_2) o;
		int result = id>stu1.id ? 1 : (id == stu1.id ? 0 :-1);
		return result;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public static void main(String[] args) {
		Lab9_2 stu1 = new Lab9_2("吴凡",01011);
		Lab9_2 stu2 = new Lab9_2("吴凡2",01021);
		Lab9_2 stu3 = new Lab9_2("吴凡3",01051);
		Lab9_2 stu4 = new Lab9_2("吴凡4",01061);
		Lab9_2 stu5 = new Lab9_2("吴凡5",01031);
		
		//把数据添加到数据中
		TreeSet<Lab9_2> tree = new TreeSet<>();
		tree.add(stu1);
		tree.add(stu2);
		tree.add(stu3);
		tree.add(stu4);
		tree.add(stu5);
		
		Iterator<Lab9_2> it = tree.iterator();
		System.out.println("Set 集合中的所有元素:");
		while(it.hasNext()) {
			Lab9_2 stu = (Lab9_2)it.next();
			System.out.println(stu.getId() + " " + stu.getName());
		}
		
		it = tree.headSet(stu2).iterator();
		//截取stu2前面的
		
		System.out.println("截取前面部分的集合");
		while(it.hasNext()) {
			Lab9_2 stu = (Lab9_2)it.next();
			System.out.println(stu.getId() + " " + stu.getName());
		}
		
		it = tree.subSet(stu2,stu3).iterator();
		//截取stu2前面的
		
		System.out.println("截取前面部分的集合");
		while(it.hasNext()) {
			Lab9_2 stu = (Lab9_2)it.next();
			System.out.println(stu.getId() + " " + stu.getName());
		}
		
	}
	
}