package Library;

public class Customer {
	int id;
	String name;
	private String address;
	private String email;
	private String tel;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return ("*" + email.substring(email.length() - 15, email.length()));
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return ("******" + tel.substring(tel.length() - 3, tel.length()));
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
