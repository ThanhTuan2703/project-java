package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.UserDAO;
import javax.swing.JPasswordField;

public class SignIn extends JFrame implements ActionListener{
	
	private JPanel contentPane;
	private JTextField jtfUser;
	private JPasswordField pw;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignIn() {
		setFont(new Font("Times New Roman", Font.ITALIC, 14));
		setTitle("Login Account");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JLabel lblFootball = new JLabel("Football Club Manager");
		lblFootball.setForeground(Color.BLUE);
		lblFootball.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		lblFootball.setBounds(77, 40, 204, 26);
		contentPane.add(lblFootball);
		
		jtfUser = new JTextField();
		jtfUser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jtfUser.setBounds(125, 77, 140, 26);
		contentPane.add(jtfUser);
		jtfUser.setColumns(10);

		pw = new JPasswordField();
		pw.setBounds(125, 122, 137, 26);
		contentPane.add(pw);
		
		JLabel lblUser = new JLabel("User Name");
		lblUser.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\username3.png"));
		lblUser.setForeground(new Color(255, 0, 0));
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUser.setBounds(6, 73, 120, 30);
		contentPane.add(lblUser);
		
		JLabel lblPass = new JLabel("Password   ");
		lblPass.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\password2.png"));
		lblPass.setForeground(new Color(255, 0, 0));
		lblPass.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPass.setBounds(6, 119, 112, 30);
		contentPane.add(lblPass);
		
		JButton btnSigin = new JButton("SIGN IN");
		btnSigin.addActionListener(this);
		btnSigin.setBackground(new Color(0, 255, 255));
		btnSigin.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSigin.setBounds(51, 188, 101, 23);
		contentPane.add(btnSigin);
		
		
		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp sg = new SignUp();
				sg.setVisible(true);
				exit();
			}
		});
		
		btnSignUp.setBackground(new Color(0, 255, 255));
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnSignUp.setBounds(190, 188, 101, 23);
		contentPane.add(btnSignUp);
		
		JLabel lbImage = new JLabel("");
		lbImage.setBounds(60, 11, 254, 239);
		contentPane.add(lbImage);
		lbImage.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\images.jpg"));
		lbImage.setForeground(Color.RED);
		lbImage.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
				
	}
	private void exit() {
		this.setVisible(false);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		UserDAO uDao = new UserDAO();
		if(e.getActionCommand().equals("SIGN IN")) {
			String username = jtfUser.getText();
			String password = new String(pw.getPassword());
			if (uDao.login(username,password)!= null) {
				Home hf = new Home();
				hf.setVisible(true);
				contentPane.setVisible(false);
				exit();
			}else {
				JOptionPane.showConfirmDialog(null, "Account is incorrect.Please sign up again or contact to owner");
				
			}
		}
		if(e.getActionCommand().equals("SIGN UP")) { 
			String usename = jtfUser.getText();
			String password = new String(pw.getPassword());
			if (usename.trim().equals("")&& password.trim().equals("")) {
				JOptionPane.showMessageDialog(null, "Please sign up to start program."
						+ "If you don't have account ,"
						+ " You should contact with owner to sign up ");
		        
			}
		}
	}
}