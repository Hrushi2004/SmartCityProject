package entity;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="smartcity_user_details")
public class Details implements Serializable  {
	private static final long serialVersionUID = 1L;
	@Column(nullable = false)
	 private String fullName ;
	@Column(nullable = false) 
	private String dob;
	@Column(nullable = false)
	 private String gender;
	@Column(nullable = false)
	 private String email;
	@Column(nullable = false, unique = true)
	 private String phone;
	 @Id
	 private String username;
	 @Column(nullable = false)
	 private String password;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	 public void setPassword(String password) {
	        this.password = hashPassword(password);
	    }
	  private String hashPassword(String password) {
	        try {
	            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	            byte[] hash = digest.digest(password.getBytes("UTF-8"));
	            StringBuilder hexString = new StringBuilder();
	            for (byte b : hash) {
	                String hex = Integer.toHexString(0xff & b);
	                if (hex.length() == 1) {
	                    hexString.append('0');
	                }
	                hexString.append(hex);
	            }
	            return hexString.toString();
	        } catch (Exception e) {
	            throw new RuntimeException("Error hashing password", e);
	        }
	    }
	

}
