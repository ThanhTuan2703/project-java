package View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Controller.ChucVuDAO;
import Controller.CountryDAO;
import Controller.hlvDAO;
import Model.ChucVu;
import Model.Country;
import Model.HLV;
import com.toedter.calendar.JDateChooser;

public class Coach extends JFrame {

	private JPanel contentPane;
	private JTextField jtfIDCoach;
	private JTextField jtfName;
	private JTextField jtfYoB; 
	private JTextField jtfYear;
	private JTextField jtfDuration;
	private JTable tableCoach;
	DefaultTableModel model;
	private JTextField jtfSalary;
	private hlvDAO hlvDao = new hlvDAO(); 
	private CountryDAO countryDao = new CountryDAO();
	private ChucVuDAO chucvuDao = new ChucVuDAO();
	private List<Country> listCountry = countryDao.searchByName("");
	private List<ChucVu> listChucVu = chucvuDao.searchByName("");
	private int countryIndexCbb = listCountry.get(0).getId();
	private int positionIndexCbb = listChucVu.get(0).getId();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Coach frame = new Coach();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void table() {
		DefaultTableModel model = new DefaultTableModel();
		Object[] column = {"ID","Name","Day of birth","Country","Position","Salary(USD)","Year joined","Duration"};
		model.setColumnIdentifiers(column);
		List<HLV> listHLV = new ArrayList<>();
		listHLV = hlvDao.searchByName("");
		for (HLV hlv : listHLV) {
			model.addRow(new Object[] {
					hlv.getId(),
					hlv.getTenHLV(),
					hlv.getDob(),
					countryDao.searchById(hlv.getCountryId()).getId()+"- "+countryDao.searchById(hlv.getCountryId()).getCountry(),
					chucvuDao.searchById(hlv.getChucVuId()).getId()+ "- "+chucvuDao.searchById(hlv.getChucVuId()).getChucVu(),
					hlv.getMucLuong(),
					hlv.getNamGiaNhap(),
					hlv.getHanHopDong()});
		}
		tableCoach.setModel(model);
	}
	public void clearTb() {
		jtfIDCoach.setText("");
		jtfName.setText("");
		jtfSalary.setText("");
		jtfYear.setText("");
		jtfDuration.setText("");
	}

	public Coach() {
		setTitle("Manage Coach");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 1184, 90);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblFootballClubManagement = new JLabel("Football Club Management System");
		lblFootballClubManagement.setBounds(382, 0, 439, 58);
		lblFootballClubManagement.setForeground(Color.RED);
		lblFootballClubManagement.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblFootballClubManagement);
		
		JLabel lblManageCoach = new JLabel("MANAGE COACH");
		lblManageCoach.setBounds(509, 55, 173, 24);
		lblManageCoach.setForeground(new Color(0, 100, 0));
		lblManageCoach.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblManageCoach);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 90, 1184, 521);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCoachInformation = new JLabel("Coach Information");
		lblCoachInformation.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\information_icon.png"));
		lblCoachInformation.setBounds(481, 0, 235, 38);
		lblCoachInformation.setForeground(Color.RED);
		lblCoachInformation.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel_1.add(lblCoachInformation);

		JLabel lblIDCoach = new JLabel("ID Coach");
		lblIDCoach.setForeground(Color.BLACK);
		lblIDCoach.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblIDCoach.setBounds(282, 54, 66, 14);
		panel_1.add(lblIDCoach);
		
		JLabel lblName = new JLabel("Full Name");
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblName.setBounds(282, 87, 66, 14);
		panel_1.add(lblName);
		
		JLabel lblYoB = new JLabel("Day of Birth");
		lblYoB.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblYoB.setBounds(282, 125, 77, 14);
		panel_1.add(lblYoB);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblCountry.setBounds(282, 156, 54, 14);
		panel_1.add(lblCountry);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPosition.setBounds(650, 54, 66, 14);
		panel_1.add(lblPosition);
		
		JLabel lblYear = new JLabel("Year joined");
		lblYear.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblYear.setBounds(650, 125, 77, 14);
		panel_1.add(lblYear);
		
		JLabel lblDuration = new JLabel("Duration");
		lblDuration.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblDuration.setBounds(650, 156, 71, 14);
		panel_1.add(lblDuration);

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblSalary.setBounds(650, 87, 46, 14);
		panel_1.add(lblSalary);

		jtfIDCoach = new JTextField();
		jtfIDCoach.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jtfIDCoach.setBounds(369, 49, 172, 25);
		panel_1.add(jtfIDCoach);
		jtfIDCoach.setColumns(10);
		
		jtfName = new JTextField();
		jtfName.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jtfName.setBounds(369, 82, 172, 25);
		panel_1.add(jtfName);
		jtfName.setColumns(10);

		JDateChooser jdcYOB = new JDateChooser();
		jdcYOB.setBounds(369, 118, 172, 25);
		panel_1.add(jdcYOB);

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
		jcbCountry.setBounds(369, 151, 172, 25);
		panel_1.add(jcbCountry);

		JComboBox jcbPosition = new JComboBox();
		jcbPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jcbPosition.getSelectedIndex() != -1) {
					String po = ""+jcbPosition.getItemAt(jcbPosition.getSelectedIndex());
					positionIndexCbb = Integer.parseInt(po.split("-")[0]);
				}
			}
		});
		DefaultComboBoxModel cbbPosition = new DefaultComboBoxModel();
		for (ChucVu p : listChucVu) {
			String po = p.getId()+ "- "+p.getChucVu();
			cbbPosition.addElement(po);
		}
		jcbPosition.setModel(cbbPosition);
		jcbPosition.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jcbPosition.setBounds(751, 49, 172, 25);
		panel_1.add(jcbPosition);
		
		jtfYear = new JTextField();
		jtfYear.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jtfYear.setBounds(751, 122, 172, 25);
		panel_1.add(jtfYear);
		jtfYear.setColumns(10);
		
		jtfDuration = new JTextField();
		jtfDuration.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jtfDuration.setBounds(751, 153, 172, 25);
		panel_1.add(jtfDuration);
		jtfDuration.setColumns(10);

		jtfSalary = new JTextField();
		jtfSalary.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		jtfSalary.setBounds(751, 84, 172, 25);
		panel_1.add(jtfSalary);
		jtfSalary.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(jdcYOB.getDate() != null) {
					int id = Integer.parseInt(jtfIDCoach.getText());
					String name = jtfName.getText();
					Date yob = new Date(jdcYOB.getDate().getTime());
					int countryid = countryIndexCbb;
					int positionid = positionIndexCbb;
					int salary = Integer.parseInt(jtfSalary.getText());
					int yearjoin = Integer.parseInt(jtfYear.getText());
					int duration = Integer.parseInt(jtfDuration.getText());
					
					HLV empHlv = new HLV(id, name, yob, countryid, positionid, salary, yearjoin, duration);
					try {
						if(hlvDao.addHLV(empHlv)) {
							JOptionPane.showMessageDialog(null, "Add Coach information successfull!");
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
		btnAdd.setBackground(Color.CYAN);
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnAdd.setBounds(260, 205, 120, 30);
		panel_1.add(btnAdd);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(jtfIDCoach.getText());
				String name = jtfName.getText();
				Date yob = new Date(jdcYOB.getDate().getTime());
				int countryid = countryIndexCbb;
				int positionid = positionIndexCbb;
				int salary = Integer.parseInt(jtfSalary.getText());
				int yearjoin = Integer.parseInt(jtfYear.getText());
				int duration = Integer.parseInt(jtfDuration.getText());
				
				HLV empHlv = new HLV(id, name, yob, countryid, positionid, salary, yearjoin, duration);
				try {
					if(hlvDao.updateHLV(id,empHlv)) {
						JOptionPane.showMessageDialog(null, "Update Coach information successfull!");
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
		btnUpdate.setBackground(new Color(0, 255, 255));
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdate.setBounds(415, 205, 120, 30);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(jtfIDCoach.getText());
				int click = JOptionPane.showConfirmDialog(null, "Are you sure want to delete this Coach!");
                if (click==JOptionPane.YES_OPTION) {
                     try {
						if(hlvDao.delHLV(id)) {
							JOptionPane.showMessageDialog(null, "Delete Coach information successfull!");
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
		btnDelete.setBackground(new Color(0, 255, 255));
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnDelete.setBounds(569, 205, 120, 30);
		panel_1.add(btnDelete);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		panel_2.setBounds(0, 264, 1184, 38);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCoachList = new JLabel("Coach List");
		lblCoachList.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\list.png"));
		lblCoachList.setBounds(501, 0, 156, 38);
		lblCoachList.setForeground(Color.BLUE);
		lblCoachList.setFont(new Font("Times New Roman", Font.BOLD, 24));
		panel_2.add(lblCoachList);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 301, 1164, 179);
		panel_1.add(scrollPane);
		
		tableCoach = new JTable();
		tableCoach.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tableCoach.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel model = (DefaultTableModel)tableCoach.getModel();
				int index = tableCoach.getSelectedRow();
				jtfIDCoach.setText(model.getValueAt(index, 0).toString());
				jtfName.setText(model.getValueAt(index, 1).toString());
				try {
					jdcYOB.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(model.getValueAt(index, 2).toString()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.err.println("loi "+ e1);
				}   
				jcbCountry.setSelectedItem(model.getValueAt(index, 3).toString());
				jcbPosition.setSelectedItem(model.getValueAt(index, 4).toString());
				jtfSalary.setText(model.getValueAt(index, 5).toString());
				jtfYear.setText(model.getValueAt(index, 6).toString());
				jtfDuration.setText(model.getValueAt(index, 7).toString());
				
			}
		});
		tableCoach.setBackground(Color.YELLOW);
		model = new DefaultTableModel();
		Object[] column = {"ID","Name","Day of birth","Country","Position","Salary(USD)","Year joined","Duration"};
		Object[] row = new Object[8];
		model.setColumnIdentifiers(column);
		tableCoach.setModel(model);
		scrollPane.setViewportView(tableCoach);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 479, 1184, 42);
		panel_1.add(panel_3);
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
		btnHome.setBounds(538, 5, 110, 30);
		btnHome.setBackground(new Color(0, 255, 255));
		btnHome.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_3.add(btnHome);
		
		JLabel lblimage = new JLabel("");
		lblimage.setIcon(new ImageIcon("E:\\Park-Hang-Seo.jpg"));
		lblimage.setBounds(-62, 22, 441, 246);
		panel_1.add(lblimage);
		
		JButton btnSearch = new JButton("SEARCH");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = jtfName.getText();
				DefaultTableModel model = new DefaultTableModel();
				Object[] column = {"ID","Name","Day of birth","Country","Position","Salary(USD)","Year joined","Duration"};
				model.setColumnIdentifiers(column);
				List<HLV> listHLV = new ArrayList<>();
				listHLV = hlvDao.searchByName(name);
				for (HLV hlv : listHLV) {
					model.addRow(new Object[] {
							hlv.getId(),
							hlv.getTenHLV(),
							hlv.getDob(),
							countryDao.searchById(hlv.getCountryId()).getId()+"- "+countryDao.searchById(hlv.getCountryId()).getCountry(),
							chucvuDao.searchById(hlv.getChucVuId()).getId()+ "- "+chucvuDao.searchById(hlv.getChucVuId()).getChucVu(),
							hlv.getMucLuong(),
							hlv.getNamGiaNhap(),
							hlv.getHanHopDong()});
				}
				tableCoach.setModel(model);
			}
		});
		btnSearch.setIcon(new ImageIcon("D:\\Java\\FootballProject\\image\\search_magnifier_icon.png"));
		btnSearch.setBackground(Color.CYAN);
		btnSearch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnSearch.setBounds(718, 205, 120, 30);
		panel_1.add(btnSearch);
		
		JButton jbtUndo = new JButton("REFRESH");
		jbtUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table();
				clearTb();
			}
		});
		jbtUndo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		jbtUndo.setBackground(Color.CYAN);
		jbtUndo.setBounds(873, 205, 120, 30);
		panel_1.add(jbtUndo);
		
		
		table();
		
	}
	private void exit() {
		this.setVisible(false);
	}
}
