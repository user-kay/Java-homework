package lab3;

import java.util.Random;

public class Lab3_4 {
	public static void main(String[] args) {
		String str = "";
		long starttime = System.currentTimeMillis();
		for(int i = 0 ; i < 10000 ; i++ ) {
			Random random = new Random();
			int s = random.nextInt(10000);
			str += s;
		}
		long endtime = System.currentTimeMillis();
		long time = endtime - starttime ;
		System.out.println("Stirng消耗的时间为:"  + time);
		StringBuilder builder = new StringBuilder("");
		starttime = System.currentTimeMillis();
		for(int i = 0 ; i < 10000 ; i++ ) {
			Random random = new Random();
			int s = random.nextInt(10000);
			builder.append(s);
		}
		endtime = System.currentTimeMillis();
		time = endtime - starttime ;
		System.out.println("StirngBuilder消耗的时间为:"  + time);
	}
}
