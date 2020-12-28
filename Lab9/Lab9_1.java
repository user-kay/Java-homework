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
		System.out.println("请输入你要添加的单词");
		Scanner input1 = new Scanner(System.in);
		String str1 = input1.next();
		int flag1 = 1;
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).equals(str1)) {
				//不能用等于号，尽量用equal
				System.out.println("该单词已经存在");
				flag1 = 0;
				break;
			}
		}
		if(flag1 == 1) {
			list.add(str1);
			System.out.println(str1 + "已经添加");
		}
		
		System.out.println("请输入你要删除的单词");
		Scanner input2 = new Scanner(System.in);
		String str2 = input2.next();
		int flag2 = 1;
		for(int i = 0 ; i < list.size() ; i++) {
			if(list.get(i).equals(str2)) {
				list.remove(i);
				System.out.println(str2 + "已经删除");
				flag2 = 0;
				break;
			}
		}
		if(flag2 == 1) {
			System.out.println(str2 + "不在列表内");
		}
		
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
