package Model;

import java.sql.Date;

public class CauThu {
	
	private int  id;
	private String name;
	private Date dob;
	private int countryId;
	private String soAo;
	private int viTriId;
	private int chieuCao;
	private int canNang;
	private int mucLuong;
	private int namGiaNhap;
	private int hanHopDong;
	
	public CauThu() {
		// TODO Auto-generated constructor stub
	}

	public CauThu(int id, String name, Date dob, int countryId, String soAo, int viTriId, int chieuCao, int canNang,
			int mucLuong, int namGiaNhap, int hanHopDong) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.countryId = countryId;
		this.soAo = soAo;
		this.viTriId = viTriId;
		this.chieuCao = chieuCao;
		this.canNang = canNang;
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

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getSoAo() {
		return soAo;
	}

	public void setSoAo(String soAo) {
		this.soAo = soAo;
	}

	public int getViTriId() {
		return viTriId;
	}

	public void setViTriId(int viTriId) {
		this.viTriId = viTriId;
	}

	public int getChieuCao() {
		return chieuCao;
	}

	public void setChieuCao(int chieuCao) {
		this.chieuCao = chieuCao;
	}

	public int getCanNang() {
		return canNang;
	}

	public void setCanNang(int canNang) {
		this.canNang = canNang;
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

	@Override
	public String toString() {
		return "CauThu [id=" + id + ", name=" + name + ", dob=" + dob + ", countryId=" + countryId + ", soAo=" + soAo
				+ ", viTriId=" + viTriId + ", chieuCao=" + chieuCao + ", canNang=" + canNang + ", mucLuong=" + mucLuong
				+ ", namGiaNhap=" + namGiaNhap + ", hanHopDong=" + hanHopDong + "]";
	}
	
	
}
