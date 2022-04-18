package Model;

import java.sql.Date;

public class HLV {
	private int  id;
	private String tenHLV;
	private Date dob;
	private int countryId;
	private int chucVuId;
	private int mucLuong;
	private int namGiaNhap;
	private int hanHopDong;
	
	public HLV() {
		// TODO Auto-generated constructor stub
	}

	public HLV(int id, String tenHLV, Date dob, int countryId, int chucVuId, int mucLuong, int namGiaNhap,
			int hanHopDong) {
		super();
		this.id = id;
		this.tenHLV = tenHLV;
		this.dob = dob;
		this.countryId = countryId;
		this.chucVuId = chucVuId;
		this.mucLuong = mucLuong;
		this.namGiaNhap = namGiaNhap;
		this.hanHopDong = hanHopDong;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenHLV() {
		return tenHLV;
	}

	public void setTenHLV(String tenHLV) {
		this.tenHLV = tenHLV;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getChucVuId() {
		return chucVuId;
	}

	public void setChucVuId(int chucVuId) {
		this.chucVuId = chucVuId;
	}

	public int getMucLuong() {
		return mucLuong;
	}

	public void setMucLuong(int mucLuong) {
		this.mucLuong = mucLuong;
	}

	public int getNamGiaNhap() {
		return namGiaNhap;
	}

	public void setNamGiaNhap(int namGiaNhap) {
		this.namGiaNhap = namGiaNhap;
	}

	public int getHanHopDong() {
		return hanHopDong;
	}

	public void setHanHopDong(int hanHopDong) {
		this.hanHopDong = hanHopDong;
	}
	public Object[] toArray() {
		return new Object[] {id,tenHLV,dob,countryId,chucVuId,mucLuong,namGiaNhap,hanHopDong};
	}
	
}
