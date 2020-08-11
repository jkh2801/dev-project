package logic;

import java.util.Date;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {
	private int uno;
	@Size(min=2, max=10, message="2자 이상 10자 이하입니다.")
	private String name;
	@Size(min=4, max=10, message="4자 이상 10자 이하입니다.")
	private String id;
	@Size(min=4, message="4자 이상입니다.")
	private String pw;
	@Email(message="Email 형식으로 입력하세요.")
	@NotEmpty(message="Email은 필수 입력사항입니다.")
	private String email;
	@NotEmpty(message="연락처는 필수 입력사항입니다.")
	private String phone;
	private Date regdate;
	private String auth;
	
	public int getUno() {
		return uno;
	}
	public void setUno(int uno) {
		this.uno = uno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
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
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "User [uno=" + uno + ", name=" + name + ", id=" + id + ", pw=" + pw + ", email=" + email + ", phone="
				+ phone + ", regdate=" + regdate + ", auth=" + auth + "]";
	}
}
