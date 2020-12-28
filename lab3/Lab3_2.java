package lab3;

import java.util.Scanner;

public class Lab3_2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("ÇëÊäÈë×Ö·û´®");
		String str = input.next();
		char []ch = str.toCharArray();
		
		int key[] = new int[10000];
		for(char c : ch) {
			if(c >= 'a' && c <= 'z') {
				int k = c - 32;
				key[k]++;
			}
			
			else 
				key[c]++;
		}
		for(int i = 0 ; i < 10000 ; i++) {
			if(key[i] != 0) {
				String k = String.valueOf(i);
				System.out.println( (char)i + ": " + key[i]);
			}
		}
	}
}
