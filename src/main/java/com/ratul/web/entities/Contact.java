package com.ratul.web.entities;

public class Contact {

	int user_id,contact_id;
	long phone_no;
	String name,email,messege;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
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
	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
	@Override
	public String toString() {
		return "Contact [user_id=" + user_id + ", contact_id=" + contact_id + ", phone_no=" + phone_no + ", name="
				+ name + ", email=" + email + ", message=" + messege + "]";
	}
	
	
	
}
