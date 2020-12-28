package Lab4;

public class Lab4_2 {
	public static void main(String[] args) {
		//下面为integer类的使用方法
		Integer number = new Integer("45");
		System.out.println("这个数返回的值为：" + number.intValue());		//下面是parseInt的作用
		String str[] = {"23","43","90","13","90"};
		int sum = 0;
		for(int i = 0 ; i < str.length ; i++) {
			int k1 = Integer.parseInt(str[i]);
			sum += k1;
		}
		System.out.println("数组里的数的总和为：" + sum);
		String k2 = Integer.toString(700);
		System.out.println("'700'这个的值在十进制的表示为：" + k2);
		
		//下面开始是boolean值的
		Boolean b = new Boolean(true);
		System.out.println("b对象的boolean值为：" + b);
		Boolean k3 = new Boolean("ok");
		System.out.println("k3:" + k3.booleanValue());
		System.out.println("k3对应的布尔值的boolean对象为" + k3.toString());
		
		//下面开始Byte类的
		byte mybyte =45;
		Byte h = new Byte(mybyte);
		System.out.println("byte类对象的值为： "+ h);
		
		//下面开始Character类的
		Character mychar1 = new Character('A');
		Character mychar2 = new Character('B');
		System.out.println(mychar1 + "是大写字母吗？" + Character.isUpperCase(mychar1));
		System.out.println(mychar2 + "是小写字母吗？" + Character.isLowerCase(mychar2));
		
		//下面开始Double类的
		Double num1 = new Double(2.234);
		System.out.println("Double对象的值为：" + num1);
		int t = num1.intValue();
		System.out.println("Double对象转化为int后的值为" + t);
		Double num2 = new Double(3.56);
		System.out.println("num1 和 num2 对象是否相等：" + num2.equals(num1));
		
		//下面开始是Number类的
		Number num3 = new Double(2.252);
		//必须采用上述的方法实例化
		System.out.println("Number类对象转换为int类的值为：" + num3.intValue());
		System.out.println("Number类对象转换为double类的值为：" + num3.doubleValue());
		System.out.println("Number类对象转换为float类的值为：" + num3.floatValue());
	}
}
