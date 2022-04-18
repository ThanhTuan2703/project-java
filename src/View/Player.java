package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import Controller.ViTriDAO;
import Controller.CountryDAO;
import Controller.CauThuDAO;
import Controller.ChucVuDAO;
import Model.ViTri;
import Model.Country;
import Model.HLV;
import Model.CauThu;
import Model.ChucVu;

public class Player extends JFrame {

	private JPanel contentPane;
	private JTextField jtfIDPlayer;
	private JTextField jtfName;
	private JTextField jtfYoB;
	private JTextField jtfCountry;
	private JTextField jtfNumber;
	private JTextField jtfWeight;
	private JTextField jtfHeight;
	private JTextField jtfYear;
	private JTextField jtfPlay;
	private JTable tablePlay;
	DefaultTableModel model;
	private JTextField jtfSalary;
	private JTextField jtfDuration;
	
	private CauThuDAO CauThuDao = new CauThuDAO();
	private CountryDAO countryDao = new CountryDAO();
	private ViTriDAO vitriDao = new ViTriDAO();
	private List<Country> listCountry = countryDao.searchByName("");
	private List<ViTri> listViTri = vitriDao.searchByName("");
	private int countryIndexCbb = listCountry.get(0).getId();
	private int plPositionIndexCbb = listViTri.get(0).getId();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player frame = new Player();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void table() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = {"ID","Name","Day of birth","Country","Play Position","Shirt number","Height (Cm)","Weight (Kg)","Salary(USD)","Year joined","Duration"};
		model.setColumnIdentifiers(column);
		List<CauThu> list = new ArrayList<>();
		list = CauThuDao.searchByName("");
		for (CauThu cauthu : list) {
			model.addRow(new Object[] {
					cauthu.getId(),
					cauthu.getName(),
					cauthu.getDob(),
					countryDao.searchById(cauthu.getCountryId()).getId()+"- "+countryDao.searchById(cauthu.getCountryId()).getCountry(),
					vitriDao.searchById(cauthu.getViTriId()).getId()+ "- "+vitriDao.searchById(cauthu.getViTriId()).getViTri(),
					cauthu.getSoAo(),
					cauthu.getChieuCao(),
					cauthu.getCanNang(),
					cauthu.getMucLuong(),
					cauthu.getNamGiaNhap(),
					cauthu.getHanHopDong()});
		}
		tablePlay.setModel(model);
	}
	public void clearTb() {
		jtfIDPlayer.setText("");
		jtfName.setText("");
		jtfNumber.setText("");
		jtfHeight.setText("");
		jtfWeight.setText("");
		jtfSalary.setText("");
		jtfYear.setText("");
		jtfDuration.setText("");
	}

	public Player() {
		setTitle("Manage Player");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1250, 750);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(0, 0, 1234, 90);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblFootballClubManagement = new JLabel("Football Club Management System");
		lblFootballClubManagement.setBounds(405, 0, 439, 54);
		lblFootballClubManagement.setForeground(Color.RED);
		lblFootballClubManagement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel_1.add(lblFootballClubManagement);
		
		JLabel lblManage = new JLabel("MANAGE PLAYER");
		lblManage.setForeground(Color.BLUE);
		lblManage.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblManage.setBounds(514, 53, 187, 26);
		panel_1.add(lblManage);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 88, 1234, 623);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPlayInfor = new JLabel("Player Information");
		lblPlayInfor.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\information_icon.png"));
		lblPlayInfor.setBounds(492, 7, 233, 38);
		lblPlayInfor.setForeground(new Color(255, 0, 0));
		lblPlayInfor.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel_2.add(lblPlayInfor);
		
		JLabel lblIDPlayer = new JLabel("ID Player");
		lblIDPlayer.setForeground(Color.BLACK);
		lblIDPlayer.setBounds(261, 57, 61, 14);
		lblIDPlayer.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblIDPlayer);
		
		JLabel lblName = new JLabel("Full Name");
		lblName.setForeground(Color.BLACK);
		lblName.setBounds(261, 90, 69, 14);
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblName);
		
		JLabel lblYoB = new JLabel("Day of Birth");
		lblYoB.setForeground(Color.BLACK);
		lblYoB.setBounds(261, 125, 89, 14);
		lblYoB.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblYoB);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setForeground(Color.BLACK);
		lblCountry.setBounds(261, 157, 56, 14);
		lblCountry.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblCountry);
		
		JLabel lblNumber = new JLabel("Shirt Number");
		lblNumber.setBounds(261, 228, 89, 14);
		lblNumber.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblNumber);
		
		JLabel lblWeight = new JLabel("Weight");
		lblWeight.setBounds(563, 90, 83, 14);
		lblWeight.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblWeight);
		
		JLabel lblHeight = new JLabel("Height");
		lblHeight.setBounds(563, 56, 73, 14);
		lblHeight.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblHeight);

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSalary.setBounds(563, 125, 46, 14);
		panel_2.add(lblSalary);
		
		JLabel lblYear = new JLabel("Year joined");
		lblYear.setBounds(563, 157, 73, 14);
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblYear);
		
		JLabel lblPlay = new JLabel("Play Position");
		lblPlay.setBounds(261, 192, 83, 14);
		lblPlay.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblPlay);

		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDuration.setBounds(563, 192, 73, 14);
		panel_2.add(lblDuration);
		
		jtfIDPlayer = new JTextField();
		jtfIDPlayer.setBounds(354, 50, 172, 25);
		jtfIDPlayer.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(jtfIDPlayer);
		jtfIDPlayer.setColumns(10);
		
		jtfName = new JTextField();
		jtfName.setBounds(354, 85, 172, 25);
		jtfName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(jtfName);
		jtfName.setColumns(10);

		JDateChooser jdcYoB = new JDateChooser();
		jdcYoB.setBounds(354, 119, 172, 25);
		panel_2.add(jdcYoB);
		
		JComboBox jcbCountry = new JComboBox();
		jcbCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcbCountry.getSelectedIndex() != -1) {
					String co = ""+jcbCountry.getItemAt(jcbCountry.getSelectedIndex());
					countryIndexCbb = Integer.parseInt(co.split("-")[0]);
				}
			}
		});
		DefaultComboBoxModel cbbCountry = new DefaultComboBoxModel();
		for (Country c : listCountry) {
			String co = c.getId()+ "- "+c.getCountry();
			cbbCountry.addElement(co);
		}
		jcbCountry.setModel(cbbCountry);
		jcbCountry.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jcbCountry.setBounds(354, 153, 172, 25);
		panel_2.add(jcbCountry);

		JComboBox jcbPlay = new JComboBox();
		jcbPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcbPlay.getSelectedIndex() != -1) {
					String po = ""+jcbPlay.getItemAt(jcbPlay.getSelectedIndex());
					plPositionIndexCbb = Integer.parseInt(po.split("-")[0]);
				}
			}
		});
		DefaultComboBoxModel cbbPlay = new DefaultComboBoxModel();
		for (ViTri p : listViTri) {
			String pl = p.getId()+ "- "+p.getViTri();
			cbbPlay.addElement(pl);
		}
		jcbPlay.setModel(cbbPlay);
		jcbPlay.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jcbPlay.setBounds(354, 187, 172, 25);
		panel_2.add(jcbPlay);
		
		jtfNumber = new JTextField();
		jtfNumber.setBounds(354, 223, 172, 25);
		jtfNumber.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(jtfNumber);
		jtfNumber.setColumns(10);
		
		jtfWeight = new JTextField();
		jtfWeight.setBounds(646, 85, 172, 25);
		jtfWeight.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(jtfWeight);
		jtfWeight.setColumns(10);
		
		jtfHeight = new JTextField();
		jtfHeight.setBounds(646, 51, 172, 25);
		jtfHeight.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(jtfHeight);
		jtfHeight.setColumns(10);

		jtfSalary = new JTextField();
		jtfSalary.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jtfSalary.setBounds(646, 120, 172, 25);
		panel_2.add(jtfSalary);
		jtfSalary.setColumns(10);
		
		jtfYear = new JTextField();
		jtfYear.setBounds(646, 152, 172, 25);
		jtfYear.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		panel_2.add(jtfYear);
		jtfYear.setColumns(10);
		
		jtfDuration = new JTextField();
		jtfDuration.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jtfDuration.setBounds(646, 188, 172, 25);
		panel_2.add(jtfDuration);
		jtfDuration.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jdcYoB.getDate() != null) {
					int id = Integer.parseInt(jtfIDPlayer.getText());
					String name = jtfName.getText();
					Date yob = new Date(jdcYoB.getDate().getTime());
					int countryid = countryIndexCbb;
					int playPositionid = plPositionIndexCbb;
					String soAo = jtfNumber.getText();
					int chieuCao = Integer.parseInt(jtfHeight.getText());
					int canNang = Integer.parseInt(jtfWeight.getText());
					int salary = Integer.parseInt(jtfSalary.getText());
					int yearjoin = Integer.parseInt(jtfYear.getText());
					int duration = Integer.parseInt(jtfDuration.getText());
					
					CauThu empCauThu = new CauThu(id, name, yob, countryid, soAo, playPositionid, chieuCao, canNang, salary, yearjoin, duration);
					try {
						if(CauThuDao.addCauThu(empCauThu)) {
							JOptionPane.showMessageDialog(null, "Add Player information successfull!");
							table();
							clearTb();
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "Error!");
					}
				}else {
					JOptionPane.showMessageDialog(null, "Please enter YoB!");
				}
			}
		});
		btnAdd.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\add-icon.png"));
		btnAdd.setBounds(876, 49, 120, 30);
		btnAdd.setBackground(new Color(0, 255, 255));
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(jtfIDPlayer.getText());
				String name = jtfName.getText();
				Date yob = new Date(jdcYoB.getDate().getTime());
				int countryid = countryIndexCbb;
				int playPositionid = plPositionIndexCbb;
				String soAo = jtfNumber.getText();
				int chieuCao = Integer.parseInt(jtfHeight.getText());
				int canNang = Integer.parseInt(jtfWeight.getText());
				int salary = Integer.parseInt(jtfSalary.getText());
				int yearjoin = Integer.parseInt(jtfYear.getText());
				int duration = Integer.parseInt(jtfDuration.getText());
				
				CauThu empCauThu = new CauThu(id, name, yob, countryid, soAo, playPositionid, chieuCao, canNang, salary, yearjoin, duration);
				try {
					if(CauThuDao.updateCauThu(id,empCauThu)) {
						JOptionPane.showMessageDialog(null, "Update Player information successfull!");
						table();
						clearTb();
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error!");
				}
			}
		});
		btnUpdate.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\update.png"));
		btnUpdate.setBounds(876, 99, 120, 30);
		btnUpdate.setBackground(new Color(0, 255, 255));
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(jtfIDPlayer.getText());
				int click = JOptionPane.showConfirmDialog(null, "Are you sure want to delete this Player!");
                if (click==JOptionPane.YES_OPTION) {
                     try {
						if(CauThuDao.delCauThu(id)) {
							JOptionPane.showMessageDialog(null, "Delete player information successfull!");
							table();
							clearTb();
						}else {
							JOptionPane.showMessageDialog(null, "Error!");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						System.err.println(e1);
					}
                }
			}
		});
		btnDelete.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\delete.png"));
		btnDelete.setBounds(876, 145, 120, 30);
		btnDelete.setBackground(new Color(0, 255, 255));
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(btnDelete);

		JLabel lblimage = new JLabel("");
		lblimage.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\images (2).jpg"));
		lblimage.setBounds(-15, 50, 306, 221);
		panel_2.add(lblimage);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 300, 1234, 38);
		panel.setBackground(Color.PINK);
		panel_2.add(panel);
		panel.setLayout(null);
		
		JLabel lblPlayList = new JLabel("Player List");
		lblPlayList.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\list.png"));
		lblPlayList.setForeground(Color.BLUE);
		lblPlayList.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblPlayList.setBounds(543, 0, 156, 38);
		panel.add(lblPlayList);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 337, 1214, 246);
		panel_2.add(scrollPane);
		
		tablePlay = new JTable();
		tablePlay.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tablePlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)tablePlay.getModel();
				int index = tablePlay.getSelectedRow();
				jtfIDPlayer.setText(model.getValueAt(index, 0).toString());
				jtfName.setText(model.getValueAt(index, 1).toString());
				try {
					jdcYoB.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index, 2).toString()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.err.println("loi "+ e1);
				}   
				jcbCountry.setSelectedItem(model.getValueAt(index, 3).toString());
				jcbPlay.setSelectedItem(model.getValueAt(index, 4).toString());
				jtfNumber.setText(model.getValueAt(index, 5).toString());
				jtfHeight.setText(model.getValueAt(index, 6).toString());
				jtfWeight.setText(model.getValueAt(index, 7).toString());
				jtfSalary.setText(model.getValueAt(index, 8).toString());
				jtfYear.setText(model.getValueAt(index, 9).toString());
				jtfDuration.setText(model.getValueAt(index, 10).toString());
								
			}
		});
		tablePlay.setBackground(Color.YELLOW);
		model = new DefaultTableModel();
		Object[] column = {"ID","Name","Day of birth","Country","Play Position","Shirt number","Height (Cm)","Weight (Kg)","Salary(USD)","Year joined","Duration"};
		Object[] row = new Object[11];
		model.setColumnIdentifiers(column);
		tablePlay.setModel(model);
		scrollPane.setViewportView(tablePlay);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 583, 1234, 40);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnHome = new JButton("HOME");
		btnHome.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\home.png"));
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home = new Home();
				home.setVisible(true);
				exit();
			}
		});
		btnHome.setBounds(561, 5, 110, 30);
		btnHome.setBackground(new Color(0, 255, 255));
		btnHome.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_3.add(btnHome);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = jtfName.getText();
				DefaultTableModel model = new DefaultTableModel();
				Object[] column = {"ID","Name","Day of birth","Country","Play Position","Shirt number","Height (Cm)","Weight (Kg)","Salary(USD)","Year joined","Duration"};
				model.setColumnIdentifiers(column);
				List<CauThu> list = new ArrayList<>();
				list = CauThuDao.searchByName(name);
				for (CauThu cauthu : list) {
					model.addRow(new Object[] {
							cauthu.getId(),
							cauthu.getName(),
							cauthu.getDob(),
							countryDao.searchById(cauthu.getCountryId()).getId()+"- "+countryDao.searchById(cauthu.getCountryId()).getCountry(),
							vitriDao.searchById(cauthu.getViTriId()).getId()+ "- "+vitriDao.searchById(cauthu.getViTriId()).getViTri(),
							cauthu.getSoAo(),
							cauthu.getChieuCao(),
							cauthu.getCanNang(),
							cauthu.getMucLuong(),
							cauthu.getNamGiaNhap(),
							cauthu.getHanHopDong()});
				}
				tablePlay.setModel(model);
			}
		});
		btnSearch.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\search_magnifier_icon.png"));
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearch.setBackground(Color.CYAN);
		btnSearch.setBounds(876, 191, 120, 30);
		panel_2.add(btnSearch);
		
		JButton jbtUndo = new JButton("REFRESH");
		jbtUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table();
				clearTb();
			}
		});
		jbtUndo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jbtUndo.setBackground(Color.CYAN);
		jbtUndo.setBounds(876, 232, 120, 30);
		panel_2.add(jbtUndo);
		
		table();
		
	}
	private void exit() {
		this.setVisible(false);
	}
}
