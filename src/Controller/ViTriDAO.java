package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DataBase;
import Model.ChucVu;
import Model.ViTri;


public class ViTriDAO {
	
	public List<ViTri> searchByName(String search) {
		String sql = "SELECT * FROM ViTri where TenViTri like '%"+search+"%'";

        List<ViTri> list = new ArrayList<>();
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	ViTri emp = new ViTri();
                emp.setId(rs.getInt("ID"));
                emp.setViTri(rs.getString("TenViTri"));
                
                list.add(emp);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return null;
    }

	public ViTri searchById(int id) {
		String sql = "SELECT * FROM ViTri where Id="+id+"";

        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	ViTri emp = new ViTri();
                emp.setId(rs.getInt("ID"));
                emp.setViTri(rs.getString("TenViTri"));
                
                return emp;
            }
            con.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return null;
    }
	
	public boolean addViTri(ViTri e) throws Exception {
        String sql = "Insert into ViTri values(?)";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, e.getViTri());
            
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
	public boolean updateViTri(int id, ViTri e) throws Exception{
        String sql="Update ViTri set TenViTri=?";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, e.getViTri());
            
            System.out.println("Oke");
            return pstmt.executeUpdate() > 0;
        } catch (Exception eu) {
            System.err.println("Update error");
        }return false;
    }
	
	
}
