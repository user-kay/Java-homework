package lab3;

import java.util.Scanner;

public class Lab3_3 {
	public static void main(String[] args) {
		String s1 = "[1-9][\\d]{5,9}";
		Scanner input = new Scanner(System.in);
		System.out.println("���������ĺ���");
		
		String s2 = input.next();
		boolean k1 = s2.matches(s1);
		System.out.println("�ж�QQ�ŵĽ��Ϊ��" + k1);
		
	}
}
