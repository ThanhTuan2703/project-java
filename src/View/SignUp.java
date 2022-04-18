package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import Controller.UserDAO;
import Model.User;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
//import javax.swing.JPasswordField;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField jtfName;
	private JTextField jtfUser;
	private JTextField jtfSDT;
	private JTextField jtfEmail;
	private UserDAO uDao = new UserDAO();
	private JPasswordField pw;
	//private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setTitle("Sign Up");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSignUp = new JLabel("Sign up for an account");
		lblSignUp.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\username3.png"));
		lblSignUp.setForeground(Color.RED);
		lblSignUp.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblSignUp.setBounds(74, 31, 281, 36);
		contentPane.add(lblSignUp);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(74, 92, 46, 14);
		contentPane.add(lblName);

		JLabel lblDOB = new JLabel("Day of birth");
		lblDOB.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDOB.setBounds(74, 136, 82, 14);
		contentPane.add(lblDOB);

		JLabel lblUser = new JLabel("User name");
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUser.setBounds(74, 182, 82, 14);
		contentPane.add(lblUser);

		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPass.setBounds(74, 228, 69, 14);
		contentPane.add(lblPass);

		JLabel lblAdmin = new JLabel("Is Admin");
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblAdmin.setBounds(74, 279, 69, 14);
		contentPane.add(lblAdmin);

		JLabel lblSDT = new JLabel("Telephone");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSDT.setBounds(74, 333, 69, 14);
		contentPane.add(lblSDT);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblEmail.setBounds(74, 384, 46, 14);
		contentPane.add(lblEmail);

		jtfName = new JTextField();
		jtfName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jtfName.setBounds(174, 90, 166, 20);
		contentPane.add(jtfName);
		jtfName.setColumns(10);

		JDateChooser jdcDOB = new JDateChooser();
		jdcDOB.setDateFormatString("y-MM-dd");
		jdcDOB.setBounds(176, 136, 164, 20);
		contentPane.add(jdcDOB);

		JCheckBox jcbYes = new JCheckBox("Yes");
		jcbYes.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jcbYes.setBounds(174, 275, 46, 23);
		contentPane.add(jcbYes);

		jtfUser = new JTextField();
		jtfUser.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jtfUser.setBounds(174, 180, 166, 20);
		contentPane.add(jtfUser);
		jtfUser.setColumns(10);

		jtfSDT = new JTextField();
		jtfSDT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jtfSDT.setBounds(174, 331, 166, 20);
		contentPane.add(jtfSDT);
		jtfSDT.setColumns(10);

		jtfEmail = new JTextField();
		jtfEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		jtfEmail.setBounds(174, 382, 166, 20);
		contentPane.add(jtfEmail);
		jtfEmail.setColumns(10);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jdcDOB.getDate() != null) {
					String name = jtfName.getText();
					Date dob = new Date(jdcDOB.getDate().getTime());
					String userName = jtfUser.getText();
					String pass = new String(pw.getPassword());
					Boolean cb = jcbYes.isSelected();
					String tel = jtfSDT.getText();
					String email = jtfEmail.getText();
					
					User user = new User(0,name,dob,userName,pass,cb,tel,email);
					if(uDao.getUser(userName)==null) {
						try {
							if( uDao.addUser(user)) {
								JOptionPane.showMessageDialog(null, "Sign up successfull!");
								
								SignIn sig = new SignIn();
								sig.setVisible(true);
								exit();
							}else {
								JOptionPane.showMessageDialog(null, "Error!");
							}
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Username available!");
					}
					

				} else {
					JOptionPane.showMessageDialog(null, "Please enter DOB");
				}
			}
		});
		btnSignUp.setBackground(Color.CYAN);
		btnSignUp.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSignUp.setBounds(98, 427, 89, 23);
		contentPane.add(btnSignUp);

		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn sig = new SignIn();
				sig.setVisible(true);
				exit();
			}
		});
		btnSignIn.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSignIn.setBackground(Color.CYAN);
		btnSignIn.setBounds(251, 428, 89, 23);
		contentPane.add(btnSignIn);
		
		pw = new JPasswordField();
		pw.setBounds(174, 226, 166, 20);
		contentPane.add(pw);
		
	}

	private void exit() {
		this.setVisible(false);
	}
}
