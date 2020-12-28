package lab3;

public class Lab3_1 {
	public static void main(String[] args) {
		String s1 = new String("cjq,yyds");
		//string类的构造
		int size = s1.length();
		System.out.println("s1的长度为：" + size);
		//下面开始字符串的搜索
		int pos = s1.indexOf("j");
		System.out.println("j的位置为" + (pos + 1)); 
		int pos2 = s1.lastIndexOf("y");
		System.out.println("最后一个y的位置为：" + (pos2 + 1));
		//下面开始返回字符
		String s2 = "heddo world";
		char mychar = s2.charAt(2);
		System.out.println("s2中位置为2的字符串为：" + mychar);
		//下面开始截取字符
		String s4 = s2.substring(5);
		System.out.println(s4);
		String s5 = s2.substring(5,8);
		System.out.println(s5);
		//下面开始去空格
		String s6 = "     java   class    ";
		System.out.println("去掉前后空格以后的值为" + s6.trim());
		//下面开始换字词
		String s7 = "asdasd";
		String newstr = s7.replace("d", "D");
		System.out.println("新的字符串为" + newstr);
		//判断是否相等
		String s8 = "ABD";
		String s9 =  "ABD";
		String s10 = "ABG";
		boolean k = s8.equals(s9);
		boolean k2 = s8.equals(s10);
		System.out.println("s8和s9判断是否相等的结果为：" + k );
		System.out.println("s8和s10判断是否相等的结果为：" + k2 );
		//比较大小
		String s11 = new String("d");
		String s12 = new String("k");
		System.out.println("s12和s12大小的判断结果为：" + s11.compareTo(s12));
		//下面开始进行字符串的分割
		String s13 = "123.123.454";
		String []firstArrays = s13.split("\\.");
		String []secondArrays = s13.split("\\.",2);
		for(String a: firstArrays) {
			System.out.print("[" + a + "]");
		}
		System.out.println("");
		System.out.println("分割两次的结果如下");
		for(String a: secondArrays) {
			System.out.print("[" + a + "]");
		}
		
		
		
	}
}