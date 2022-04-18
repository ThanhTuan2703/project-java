package Model;

public class ChucVu {
	private int id;
	private String chucVu;
	public ChucVu() {
		// TODO Auto-generated constructor stub
	}
	public ChucVu(int id, String chucVu) {
		super();
		this.id = id;
		this.chucVu = chucVu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
}
