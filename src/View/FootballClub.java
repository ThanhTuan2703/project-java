package View;
import java.awt.*;
import javax.swing.*;

public class FootballClub {
	JFrame frame = new JFrame();
	JProgressBar bar = new JProgressBar();
	JPanel jpn = new JPanel();
	
	FootballClub(){
		ImageIcon icon = new ImageIcon("D:\\Java\\FootballProject\\image\\images.jpg");
		frame.setFont(new Font("Times New Roman", Font.ITALIC, 14));
		frame.setTitle("Football Club");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(376, 300);
		frame.setLocationRelativeTo(null);
		frame.add(jpn);
		frame.setVisible(true);	
		
		jpn.setSize(360, 261);
		jpn.setBackground(Color.WHITE);
		
		JLabel lblWelcome = new JLabel("WELCOME TO CLUB");
		lblWelcome.setForeground(new Color(30, 144, 255));
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblWelcome.setBounds(35, 11, 302, 59);
		jpn.add(lblWelcome);
		
		JLabel lblYmage = new JLabel(icon);
		lblYmage.setBounds(59, 21, 249, 202);
		jpn.add(lblYmage);
		
		bar.setForeground(Color.BLUE);
		bar.setBounds(84, 241, 200, 14);
		bar.setStringPainted(true);
		bar.setValue(0);
		jpn.add(bar);
					
		fill();
	}
	private void exit() {
		frame.setVisible(false);
	}
	public void fill() {
		int x = 0;
		while(x<=100) {
			bar.setValue(x);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			x+=20;
		}
		SignIn lg = new SignIn();
        lg.setVisible(true);
        exit();

	}
	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new FootballClub();
//	}

}
