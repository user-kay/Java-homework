package Lab9;

import java.util.*;

class Emp {
	private String e_id;
	private String e_name;
	public Emp(String e_id,String e_name) {
		this.e_id = e_id;
		this.e_name = e_name;
	}
	
	public String getE_name() {
		return e_name;
	}
	
	public String getE_id() {
		return e_id;
	}
	
	
}


public class Lab9_3{
	public static void main(String[] args) {
		Map<String,String> map1 = new HashMap<>();
		
		//����emp����
		Emp emp =  new Emp("351","apple");
		Emp emp2 =  new Emp("512","boy");
		Emp emp3 =  new Emp("863","cat");
		Emp emp4 =  new Emp("873","dog");
		Emp emp5 =  new Emp("1023","e");
		Emp emp6 =  new Emp("1063","f");
		Emp emp7 =  new Emp("1073","g");
		Emp emp8 =  new Emp("1123","h");
		Emp emp9 =  new Emp("1163","i");
		Emp emp10 =  new Emp("1173","j");
		
		//��ӵ�������
		map1.put(emp.getE_id() , emp.getE_name() );
		map1.put(emp2.getE_id() , emp2.getE_name() );
		map1.put(emp3.getE_id() , emp3.getE_name() );
		map1.put(emp4.getE_id() , emp4.getE_name() );
		map1.put(emp5.getE_id() , emp5.getE_name() );
		map1.put(emp6.getE_id() , emp6.getE_name() );
		map1.put(emp7.getE_id() , emp7.getE_name() );
		map1.put(emp8.getE_id() , emp8.getE_name() );
		map1.put(emp9.getE_id() , emp9.getE_name() );
		map1.put(emp10.getE_id() , emp10.getE_name() );
		
		Set <String> set = map1.keySet(); //��ȡmap1�����key���󼯺�
		
		Iterator<String>iter = set.iterator();
		System.out.println("HashMapʵ�ֵ�Map��,��˳��");
		
		//����HashMap����
		while(iter.hasNext()) {
			String str = (String) iter.next();
			String name = (String) map1.get(str);
			System.out.println(str + " " + name);
		}
		
		//���濪ʼTreeMap��
		
		TreeMap<String,String> treemap = new TreeMap<>();
		//�������϶���
		treemap.putAll(map1);
		Iterator<String>it = treemap.keySet().iterator();//����������
		System.out.println("TreeMapʵ�ֵ�Map��,��˳��");
		while(it.hasNext()) {
			String str = (String) it.next();
			String name = (String) treemap.get(str);
			System.out.println(str + " " + name);
		}
	}
	
	//HashMap���ǹ̶�û��˳��ģ���treemap�����һ����˳����д洢
}
