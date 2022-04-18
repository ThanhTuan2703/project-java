package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DataBase;
import Model.User;


public class UserDAO {
	
	public User login(String user, String pass) {
		String sql = "  select * from TaiKhoan where UserName = ? and Password = ?";
		try {
			Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            User emp = new User();
            while(rs.next()) {
            	emp.setId(rs.getInt("ID"));
                emp.setName(rs.getString("Name"));
                emp.setDob(rs.getDate("DOB"));
                emp.setUserName(rs.getString("UserName"));
                emp.setPassword(rs.getString("Password"));
                emp.setAdmin(rs.getBoolean("IsAdmin"));
                emp.setSdt(rs.getString("SDT"));
                emp.setEmail(rs.getString("Email"));
            	return emp;
            }
            con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return null;
	}

	public User getUser(String user) {
		String sql = "  select * from TaiKhoan where UserName = ? ";
		try {
			Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, user);
            ResultSet rs = pstmt.executeQuery();
            User emp = new User();
            while(rs.next()) {
            	emp.setId(rs.getInt("ID"));
                emp.setName(rs.getString("Name"));
                emp.setDob(rs.getDate("DOB"));
                emp.setUserName(rs.getString("UserName"));
                emp.setPassword(rs.getString("Password"));
                emp.setAdmin(rs.getBoolean("IsAdmin"));
                emp.setSdt(rs.getString("SDT"));
                emp.setEmail(rs.getString("Email"));
            	return emp;
            }
            con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return null;
	}
	
	public List<User> searchByName(String search) {
		String sql = "SELECT * FROM User where Name like '%"+search+"%'";

        List<User> list = new ArrayList<>();
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	User emp = new User();
                emp.setId(rs.getInt("ID"));
                emp.setName(rs.getString("Name"));
                emp.setDob(rs.getDate("DOB"));
                emp.setUserName(rs.getString("UserName"));
                emp.setPassword(rs.getString("Password"));
                emp.setAdmin(rs.getBoolean("IsAdmin"));
                emp.setSdt(rs.getString("SDT"));
                emp.setEmail(rs.getString("Email"));
                
                list.add(emp);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return null;
    }
	
	
	public boolean addUser(User e) throws Exception {
        String sql = "Insert into TaiKhoan values(?,?,?,?,?,?,?)";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, e.getName());
            pstmt.setDate(2, e.getDob());
            pstmt.setString(3, e.getUserName());
            pstmt.setString(4, e.getPassword());
            pstmt.setBoolean(5, e.isAdmin());
            pstmt.setString(6, e.getSdt());
            pstmt.setString(7, e.getEmail());
            
            pstmt.executeUpdate();

            return true;
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return false;
    }
	
//	public boolean delHLV(String id) throws Exception{
//        String sql = "DELETE FROM HLV WHERE Id='"+id+"';";
//        try {
//            Connection con = DataBase.openConnection();
//            PreparedStatement pstmt = con.prepareStatement(sql);
//            pstmt.executeUpdate();
//            return pstmt.executeUpdate() > 0;
//        } catch (Exception ed) {
//            System.err.println(ed);
//        }
//        return false;
//    }
	public boolean updateUser(String id, User e) throws Exception{
        String sql="Update TaiKhoan set Name=?,DOB=?,UserName=?,Password=?"
        		+ "IsAdmin=?,SDT=?,Email=? where Id='"+id+"';";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, e.getName());
            pstmt.setDate(2, e.getDob());
            pstmt.setString(3, e.getUserName());
            pstmt.setString(4, e.getPassword());
            pstmt.setBoolean(5, e.isAdmin());
            pstmt.setString(6, e.getSdt());
            pstmt.setString(7, e.getEmail());
            
            System.out.println("Oke");
            return pstmt.executeUpdate() > 0;
        } catch (Exception eu) {
            System.err.println("Update error");
        }return false;
    }
	
	
}
