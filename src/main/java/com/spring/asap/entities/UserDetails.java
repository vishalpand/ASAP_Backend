package com.spring.asap.entities;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "UserDetails")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "full_Name", nullable = false)
	private String fullName;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "phone_number", nullable = true)
	private String phoneNumber;

	@Column(name = "address", nullable = true)
	private String address;

	@Column(name = "city", nullable = true)
	private String city;

	@Column(name = "state", nullable = true)
	private String state;

	@Column(name = "zip_code", nullable = true)
	private String zipCode;

	@Column(name = "country", nullable = true)
	private String country;

	@Column(name = "file_name", nullable = false)
	private String fileName;

	@Column(name = "file_type", nullable = false)
	private String fileType;
	
	@Lob
	@Column(name = "file_data", columnDefinition = "LONGBLOB")
	private byte[] fileData;
	
	@Column(name = "aboutyour_Self", nullable = true)
	private String aboutyourSelf;
	@Column(name = "description", nullable = true)
	private String description;
	
	
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public String getAboutyourSelf() {
		return aboutyourSelf;
	}
	public void setAboutyourSelf(String aboutyourSelf) {
		this.aboutyourSelf = aboutyourSelf;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", fullName=" + fullName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode
				+ ", country=" + country + ", fileName=" + fileName + ", fileType=" + fileType + ", fileData="
				+ Arrays.toString(fileData) + ", aboutyourSelf=" + aboutyourSelf + ", description=" + description + "]";
	}

	
	
	
	

}
