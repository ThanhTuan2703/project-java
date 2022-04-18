package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DataBase;
import Model.Country;


public class CountryDAO {
	
	public List<Country> searchByName(String search) {
		String sql = "SELECT * FROM Country where CountryName like '%"+search+"%'";

        List<Country> list = new ArrayList<>();
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	Country emp = new Country();
                emp.setId(rs.getInt("Id"));
                emp.setCountry(rs.getString("CountryName"));
                
                list.add(emp);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return null;
    }
	
	public Country searchById(int id) {
		String sql = "SELECT * FROM Country where Id="+id+"";

        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	Country emp = new Country();
                emp.setId(rs.getInt("Id"));
                emp.setCountry(rs.getString("CountryName"));
                
                return emp;
            }
            con.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return null;
    }
	
	public boolean addCountry(Country e) throws Exception {
        String sql = "Insert into Country values(?)";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, e.getCountry());
            
            return pstmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return false;
    }
	
//	public boolean delHLV(String id) throws Exception{
//        String sql = "DELETE FROM ChucVu WHERE Id='"+id+"';";
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
	public boolean updateCountry(int id, Country e) throws Exception{
        String sql="Update Country set CountryName=? where Id=?";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, e.getCountry());
            pstmt.setInt(2, id);
            
            System.out.println("Oke");
            return pstmt.executeUpdate() > 0;
        } catch (Exception eu) {
            System.err.println("Update error");
        }return false;
    }
	
	
}
