package whapp;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WhatsApp {
	@Id
	private int id;
	private String username;
	private String email;
	private long phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "WhatsApp [id=" + id + ", username=" + username + ", email=" + email + ", phone=" + phone + "]";
	}
	
}
