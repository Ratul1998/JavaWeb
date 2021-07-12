package com.ratul.web.entities;

public class User {

	int user_id;
	long phone_no;
	String name,email,address,password,upload_photo;
	
	public int getUser_id() {
		return user_id;
	}
	
	public long getPhone_no() {
		return phone_no;
	}
	
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getUpload_photo() {
		return upload_photo;
	}

	public void setUpload_photo(String upload_photo) {
		this.upload_photo = upload_photo;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", phone_no=" + phone_no + ", name=" + name + ", email=" + email
				+ ", address=" + address + ", password=" + password + ", upload_photo=" + upload_photo + "]";
	}

	
	
	
	
}
