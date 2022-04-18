package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Database.DataBase;
import Model.CauThu;


public class CauThuDAO {
	
	public List<CauThu> searchByName(String search) {
		String sql = "SELECT * FROM CauThu where Name like '%"+search+"%'";

        List<CauThu> list = new ArrayList<>();
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            	CauThu emp = new CauThu();
                emp.setId(rs.getInt("Id"));
                emp.setName(rs.getString("Name"));
                emp.setDob(rs.getDate("DOB"));
                emp.setCountryId(rs.getInt("CountryID"));
                emp.setSoAo(rs.getString("SoAo"));
                emp.setViTriId(rs.getInt("ViTriId"));
                emp.setChieuCao(rs.getInt("ChieuCao"));
                emp.setCanNang(rs.getInt("CanNang"));
                emp.setMucLuong(rs.getInt("MucLuong"));
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
	
	public boolean addCauThu(CauThu e) throws Exception {
        String sql = "Insert into CauThu values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, e.getId());
            pstmt.setString(2, e.getName());
            pstmt.setDate(3, e.getDob());
            pstmt.setInt(4, e.getCountryId());
            pstmt.setString(5, e.getSoAo());
            pstmt.setInt(6, e.getViTriId());
            pstmt.setInt(7, e.getChieuCao());
            pstmt.setInt(8, e.getCanNang());
            pstmt.setInt(9, e.getMucLuong());
            pstmt.setInt(10, e.getNamGiaNhap());
            pstmt.setInt(11, e.getHanHopDong());
            

            return pstmt.executeUpdate() > 0;
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return false;
    }
	
	public boolean delCauThu(int id) throws Exception{
        String sql = "DELETE FROM CauThu WHERE Id='"+id+"';";
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
	public boolean updateCauThu(int id, CauThu e) throws Exception{
        String sql="Update CauThu set Name=?,DOB=?,CountryID=?,SoAo=?,ViTriId=?,ChieuCao=?,CanNang=?,MucLuong=?,NamGiaNhap=?,HanHopDong=? where Id='"+id+"';";
        try {
            Connection con = DataBase.openConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, e.getName());
            pstmt.setDate(2, e.getDob());
            pstmt.setInt(3, e.getCountryId());
            pstmt.setString(4, e.getSoAo());
            pstmt.setInt(5, e.getViTriId());
            pstmt.setInt(6, e.getChieuCao());
            pstmt.setInt(7, e.getCanNang());
            pstmt.setInt(8, e.getMucLuong());
            pstmt.setInt(9, e.getNamGiaNhap());
            pstmt.setInt(10, e.getHanHopDong());
            
            pstmt.executeUpdate();
            return  true;
        } catch (Exception eu) {
            System.err.println("Update error: "+eu);
        }return false;
    }
	
	
}
