package Lab9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab9_1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println("��������Ҫ��ӵĵ���");
		Scanner input1 = new Scanner(System.in);
		String str1 = input1.next();
		int flag1 = 1;
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).equals(str1)) {
				//�����õ��ںţ�������equal
				System.out.println("�õ����Ѿ�����");
				flag1 = 0;
				break;
			}
		}
		if(flag1 == 1) {
			list.add(str1);
			System.out.println(str1 + "�Ѿ����");
		}
		
		System.out.println("��������Ҫɾ���ĵ���");
		Scanner input2 = new Scanner(System.in);
		String str2 = input2.next();
		int flag2 = 1;
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).equals(str2)) {
				list.remove(i);
				System.out.println(str2 + "�Ѿ�ɾ��");
				flag2 = 0;
				break;
			}
		}
		if(flag2 == 1) {
			System.out.println(str2 + "�����б���");
		}
		
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
