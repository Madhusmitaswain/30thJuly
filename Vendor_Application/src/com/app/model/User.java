package com.app.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
@Entity
@Table(name="usr_tab")
public class User {
	
	@Id
	@Column(name="u_id")
	@GeneratedValue(generator="usrgen")
	@GenericGenerator(name="usrgen",strategy="increment")
	private int userId;
	
	@Column(name="u_name")
	private String userName;
	@Column(name="u_mail")
	private String userEmail;
	@Column(name="u_cnt")
	private String userContact;
	@Column(name="u_pwd")
	private String userPwd;
	@Column(name="u_addr")
	private String userAddr;
	
	public User() {
		super();
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserContact() {
		return userContact;
	}
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserAddr() {
		return userAddr;
	}
	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", userEmail=" + userEmail + ", userContact=" + userContact
				+ ", userPwd=" + userPwd + ", userAddr=" + userAddr + "]";
	}
	
	
}
