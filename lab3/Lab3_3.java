package lab3;

import java.util.Scanner;

public class Lab3_3 {
	public static void main(String[] args) {
		String s1 = "[1-9][\\d]{5,9}";
		Scanner input = new Scanner(System.in);
		System.out.println("请输入您的号码");
		
		String s2 = input.next();
		boolean k1 = s2.matches(s1);
		System.out.println("判断QQ号的结果为：" + k1);
		
	}
}
