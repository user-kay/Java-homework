package Lab4;

import java.math.BigInteger;

public class Lab4_4 {
	public static void main(String[] args) {
		BigInteger value1 = new BigInteger("100000000010");
		System.out.println("加法操作：" + value1.add(new BigInteger("100000000010")));
		System.out.println("减法操作：" + value1.subtract(new BigInteger("1000000")) );
		BigInteger sum = new BigInteger("0");//标记数量
		BigInteger num1 = new BigInteger("1");//标记增加的量
		BigInteger num2 = new BigInteger("2");//标记因子
		for(BigInteger i = num2 ; i.compareTo(value1) < 0 ; i = i.add(num1)) { 
			if((value1.remainder(i).compareTo(BigInteger.ZERO) == 0)) { 
				sum = sum.add(num1);
				System.out.println(" " + i.toString());
				if(sum.compareTo(new BigInteger("10")) == 0) {
					break;
				}
			}
		}
	}
}
