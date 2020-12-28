package Lab6;

interface behaviour {
	public void say();
	public void drive();
}

class Person {
	Person(String x, String y,int age1) {
		name = x;
		gender = y;
		age1 = age;
	}
	public String name, gender;
	public int age;
	public void say(Father k) {
		System.out.println("Chinese");
	}
	public void drive(Father k) {
		System.out.println("car");
	}
	public void say(son k) {
		System.out.println("Chinese and English");
	}
	public void drive(son k) {
		System.out.println("airplane");
	}
}

class Father extends Person implements behaviour {
	Father(String name1,String gender1,int age1) {
		super(name1,gender1,age1);
		System.out.println("父亲的信息为" + name1 + " " + gender + " " + age1 );
	}
	public void say() {
		System.out.println("Chinese");
	}
	public void drive() {
		System.out.println("car");
	}
	
	public void f2() {
		Father k2 = new Father("cjq","男",19); 
		k2.say(k2);
		k2.drive(k2);
//		System.out.println("Chinese and English");
	}
	
}


class son extends Person implements behaviour {
	son(String name1,String gender1,int age1) {
		super(name1,gender1,age1);
		System.out.println("儿子的信息为" + name1 + " " + gender + " " + age1 );
	}
	public void f() {
		son k2 = new son("吴凡","男",19); 
		k2.say(k2);
		k2.drive(k2);
//		System.out.println("Chinese and English");
	}
	
	public void say() {
		
	}
	
	public void drive() {
		System.out.println("airplane");
	}
}

public class Lab6_1 {
	public static void main(String [] args) {
		Father k = new Father("cjq","男",19);
		k.f2();
		son k2 = new son("吴凡","男",19); 
		k2.f();
		
	}
	
}
