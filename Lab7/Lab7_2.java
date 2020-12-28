package Lab7;

import java.awt.Container;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

class MyDialog extends JDialog {
	public MyDialog(Lab7_2 frame) {
		super(frame,"九九乘法表",true);
		Container container = getContentPane();
		String o = "<html>";
		for(int i = 1; i <= 9 ; i++) {
			for(int j = 1 ; j <= 9 ; j++) {
			String k = String.valueOf(i);
			String t = "X";
			String k2 = String.valueOf(j);
			String t2 = "=";
			String sum = String.valueOf(i * j);
			o += (k + t + k2 + t2 + sum + "      ");
			if(j == 5 || j == 9) {
				o += "<br>";
			}
			}
		}
		o += "</html>";
		container.add(new JLabel(o));
		setBounds(120,120,500,500);
	}
}


public class Lab7_2 extends JFrame {
	public static void main(String[] arfs) {
		new Lab7_2();
	}
	public Lab7_2() {
		Container container = getContentPane();
		container.setLayout(null);
		JLabel jl = new JLabel("九九乘法表");
		setTitle("九九表");
		jl.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(jl);
		JButton bl = new JButton("点开即可查看九九乘法表");
		bl.setBounds(10, 10, 300, 300);
		bl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				new MyDialog(Lab7_2.this).setVisible(true);				
			}
		});
		container.add(bl);
		setVisible(true);
	}
}
