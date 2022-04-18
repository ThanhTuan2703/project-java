package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DataBase;
import Model.ChucVu;


public class ChucVuDAO {
	
	public List<ChucVu> searchByName(String search) {
		String sql = "SELECT * FROM ChucVu where ChucVu like '%"+search+"%'";

        List<ChucVu> list = new ArrayList<>();
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	ChucVu emp = new ChucVu();
                emp.setId(rs.getInt("Id"));
                emp.setChucVu(rs.getString("ChucVu"));
                
                list.add(emp);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return null;
    }
	
	public ChucVu searchById(int id) {
		String sql = "SELECT * FROM ChucVu where Id="+id+"";

        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	ChucVu emp = new ChucVu();
                emp.setId(rs.getInt("Id"));
                emp.setChucVu(rs.getString("ChucVu"));
                
                return emp;
            }
            con.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return null;
    }
	
	
	public boolean addChucVu(ChucVu e) throws Exception {
        String sql = "Insert into ChucVu values(?)";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, e.getChucVu());
            
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
	public boolean updateChucVu(String id, ChucVu e) throws Exception{
        String sql="Update ChucVu set ChucVu=?";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, e.getChucVu());
            
            System.out.println("Oke");
            return pstmt.executeUpdate() > 0;
        } catch (Exception eu) {
            System.err.println("Update error");
        }return false;
    }
	
	
}
