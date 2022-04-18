package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DataBase;
import Model.HLV;


public class hlvDAO {
	
	public List<HLV> searchByName(String search) {
		String sql = "SELECT * FROM HLV where TenHLV like '%"+search+"%'";

        List<HLV> list = new ArrayList<>();
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	HLV emp = new HLV();
                emp.setId(rs.getInt("ID"));
                emp.setTenHLV(rs.getString("TenHLV"));
                emp.setDob(rs.getDate("DOB"));
                emp.setCountryId(rs.getInt("CountryId"));
                emp.setChucVuId(rs.getInt("ChucVuId"));
                emp.setMucLuong(rs.getInt("Luong"));
                emp.setNamGiaNhap(rs.getInt("NamGiaNhap"));
                emp.setHanHopDong(rs.getInt("HanHopDong"));
                
                list.add(emp);
            }
            con.close();
            return list;
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return null;
    }
	
	public HLV searchById(int id) {
		String sql = "SELECT * FROM HLV where Id=?";

        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	HLV emp = new HLV();
                emp.setId(rs.getInt("ID"));
                emp.setTenHLV(rs.getString("TenHLV"));
                emp.setDob(rs.getDate("DOB"));
                emp.setCountryId(rs.getInt("CountryId"));
                emp.setChucVuId(rs.getInt("ChucVuId"));
                emp.setMucLuong(rs.getInt("Luong"));
                emp.setNamGiaNhap(rs.getInt("NamGiaNhap"));
                emp.setHanHopDong(rs.getInt("HanHopDong"));
                
                return emp;
            }
            con.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return null;
    }
	
	public boolean addHLV(HLV e) throws Exception {
        String sql = "Insert into HLV values(?,?,?,?,?,?,?,?)";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, e.getId());
            pstmt.setString(2, e.getTenHLV());
            pstmt.setDate(3, e.getDob());
            pstmt.setInt(4, e.getCountryId());
            pstmt.setInt(5, e.getChucVuId());
            pstmt.setInt(6, e.getMucLuong());
            pstmt.setInt(7, e.getNamGiaNhap());
            pstmt.setInt(8, e.getHanHopDong());
            

            return pstmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return false;
    }
	
	public boolean delHLV(int id) throws Exception{
        String sql = "DELETE FROM HLV WHERE Id='"+id+"';";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
            return true;
        } catch (Exception ed) {
            System.err.println(ed);
        }
        return false;
    }
	public boolean updateHLV(int id, HLV e) throws Exception{
        String sql="Update HLV set TenHLV=?,DOB=?,CountryID=?,ChucVuId=?,Luong=?,NamGiaNhap=?,HanHopDong=? where Id='"+id+"';";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, e.getTenHLV());
            pstmt.setDate(2, e.getDob());
            pstmt.setInt(3, e.getCountryId());
            pstmt.setInt(4, e.getChucVuId());
            pstmt.setInt(5, e.getMucLuong());
            pstmt.setInt(6, e.getNamGiaNhap());
            pstmt.setInt(7, e.getHanHopDong());
            
            return pstmt.executeUpdate() > 0;
        } catch (Exception eu) {
            System.err.println("Update error: "+eu);
        }return false;
    }
	
	
}
