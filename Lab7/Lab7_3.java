package Lab7;

import java.awt.Container;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

class ImgFrame extends JFrame{
	int i=1;
	int w=400,h=400;
	public ImgFrame() {
		setSize(400,400);
		setTitle("图片浏览器");
		Container container = getContentPane();
		setLayout(null);
		
		final JLabel imgJL = new JLabel();
		imgJL.setBounds(10,10,300,300);
		URL url = Lab7_3.class.getResource("images/"+i+".jpg");
		ImageIcon icon = new ImageIcon(url);
		icon.setImage(icon.getImage().getScaledInstance(w, h,Image.SCALE_DEFAULT ));
		imgJL.setIcon(icon);
		container.add(imgJL);
		
		//上一张按钮
		JButton bt1 = new JButton("上一张");
		bt1.setBounds(30,320,100,21);
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(i<=1) {
					i = 3;
				}
				else {
					i--;
				}
				URL url = Lab7_3.class.getResource("images/"+i+".jpg");
				ImageIcon icon = new ImageIcon(url);
				icon.setImage(icon.getImage().getScaledInstance(w, h,Image.SCALE_DEFAULT ));
				imgJL.setIcon(icon);
			}
		});
		container.add(bt1);
		
		//下一张按钮
		JButton bt2 = new JButton("下一张");
		bt2.setBounds(170,320,100,21);
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(i>=3) {
					i = 1;
				}
				else {
					i++;
				}
				URL url = Lab7_3.class.getResource("images/"+i+".jpg");
				ImageIcon icon = new ImageIcon(url);
				icon.setImage(icon.getImage().getScaledInstance(w, h,Image.SCALE_DEFAULT ));
				imgJL.setIcon(icon);
			}
		});
		container.add(bt2);
		
		setVisible(true);
	}
	
	
}

public class Lab7_3 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new ImgFrame();
	}

}
