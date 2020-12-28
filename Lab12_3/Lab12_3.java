package Lab12_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Lab12_3  {
	

	public static void main(String[] args) throws MalformedURLException {
		try {
			URL page = new URL("https://www.qq.com");
			HttpURLConnection conn = (HttpURLConnection) page.openConnection();
			InputStreamReader in = new InputStreamReader((InputStream)conn.getContent());
			BufferedReader buff = new BufferedReader(in);
			String s = null;
			int i = 0;
			while((s = buff.readLine()) != null) {
				i++;
				System.out.println("第" + i + "行" + s);
			}
			buff.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
