package Model;

public class Country {
	private int id;
	private String country;
	
	public Country() {
		// TODO Auto-generated constructor stub
	}

	public Country(int id, String country) {
		super();
		this.id = id;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}
