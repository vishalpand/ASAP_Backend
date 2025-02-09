package com.spring.asap.dto;

public class AuthLoginDTO {
	
	private String userName;
	private String password;
	private String confirmPassword;
	private String mobileNumber;
	private String emailid;
    private String	newPassword;
    
    
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "AuthLoginDTO [userName=" + userName + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", mobileNumber=" + mobileNumber + ", emailid=" + emailid + ", newPassword=" + newPassword + "]";
	}
	
	
	
}
