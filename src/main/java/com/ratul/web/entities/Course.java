package com.ratul.web.entities;

public class Course {

	int course_id;
	String c_name,c_desp,c_fees,c_resource;
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_desp() {
		return c_desp;
	}
	public void setC_desp(String c_desp) {
		this.c_desp = c_desp;
	}
	public String getC_fees() {
		return c_fees;
	}
	public void setC_fees(String c_fees) {
		this.c_fees = c_fees;
	}
	public String getC_resource() {
		return c_resource;
	}
	public void setC_resource(String c_resource) {
		this.c_resource = c_resource;
	}
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", c_name=" + c_name + ", c_desp=" + c_desp + ", c_fees=" + c_fees
				+ ", c_resource=" + c_resource + "]";
	}
	
	
	
}
