package Model;

import java.sql.Date;

public class User {
	
	private int id;
	private String name;
	private Date dob;
	private String userName;
	private String password;
	private boolean isAdmin;
	private String sdt;
	private String email;
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, Date dob, String userName, String password, boolean isAdmin, String sdt,
			String email) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.userName = userName;
		this.password = password;
		this.isAdmin = isAdmin;
		this.sdt = sdt;
		this.email = email;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
