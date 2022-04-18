package View;

import java.awt.BorderLayout; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Home extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {
		setTitle("Football Club");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1030, 611);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1014, 90);
		panel_1.setBackground(new Color(0, 255, 0));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFootballClubManagement = new JLabel("Football Club Management System");
		lblFootballClubManagement.setForeground(new Color(255, 0, 0));
		lblFootballClubManagement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lblFootballClubManagement.setBounds(283, 11, 448, 35);
		panel_1.add(lblFootballClubManagement);
		
		JLabel lblMain = new JLabel("Main Form");
		lblMain.setForeground(Color.RED);
		lblMain.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblMain.setBounds(442, 57, 122, 22);
		panel_1.add(lblMain);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 88, 1014, 483);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnPlayer = new JButton("Player");
		btnPlayer.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\person_user_icon.png"));
		btnPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Player play = new Player();
				play.setVisible(true);
				exit();
			}
		});
		btnPlayer.setBackground(Color.MAGENTA);
		btnPlayer.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnPlayer.setBounds(350, 373, 146, 50);
		panel_2.add(btnPlayer);
		
		JButton btnCoach = new JButton("Coach");
		btnCoach.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\person_user_icon.png"));
		btnCoach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Coach coach = new Coach();
				coach.setVisible(true);
				exit();
			}
		});
		btnCoach.setBackground(Color.MAGENTA);
		btnCoach.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnCoach.setBounds(154, 373, 146, 50);
		panel_2.add(btnCoach);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\logout.png"));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignIn log = new SignIn();
				log.setVisible(true);
				exit();
			}
			
		});
		btnLogout.setBackground(Color.MAGENTA);
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnLogout.setBounds(541, 373, 146, 50);
		panel_2.add(btnLogout);

		JButton btnExit = new JButton("EXIT");
		btnExit.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\exit-icon.png"));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(729, 373, 146, 51);
		panel_2.add(btnExit);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(0, 0, 1014, 483);
		panel_2.add(lblImage);
		lblImage.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\cau-thu-bong-da-luong-cao-nhat.jpg"));
		
	}
	private void exit() {
		this.setVisible(false);
	}
}
