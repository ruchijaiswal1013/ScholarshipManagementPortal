package com.davv.scholarship.davv.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Table(name = "personal_info")
@Entity
public class PersonalInfo implements Serializable {

	// Defining entity for PersonalInfo class
	@Id
	@Column(name = "user_name")
	private String userName;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "sName")
	private String sName;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "fName")
	private String fName;

	@NotNull
	@Size(message = "is required")
	@Column(name = "dob")
	private String Dob;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "gender")
	private String gender;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "catagory")
	private String catagory;

	@NotNull
	@Pattern(regexp = "(^$|[0-9]{12})", message = "enter a valid number and length must be 12 ")
	@Column(name = "aadhra_no")
	private String aadhar_no;

	@NotNull
	@Pattern(regexp = "(^$|[0-9]{10})", message = "enter a valid number")
	@Column(name = "phone")
	private String phone;

	@NotEmpty(message = "is required")
	@Email(message = "invalid email address")
	@Column(name = "email")
	private String email;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "city")
	private String city;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "state")
	private String state;

//	//@Pattern(regexp="(^$|[0-9]{6})", message="enter a valid number and length must be 6 ") 
//	@Size(min=1, message="is required")
//	@Column(name="pin")
//	private int pin;
//	

	@Min(value = 100000, message = "must be 6 digit")
	@Max(value=999999,message="must be 6 digit")
	@Column(name = "pin")
	private int pin;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "hs_school")
	private String hs_school;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "hs_board")
	private String hs_board;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "hs_year")
	private String hs_year;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "hs_mars")
	private String hs_mars;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "h_school")
	private String h_school;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "h_board")
	private String h_board;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "h_year")
	private String h_year;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "h_mars")
	private String h_mars;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "bName")
	private String bName;

	@NotNull
	@Pattern(regexp = "(^$|[A-Z]{4}[0-9]{7})", message = "enter a valid number")
	@Column(name = "ifsc")
	private String ifsc;

//	@NotNull
//	@Pattern(regexp="[a-zA-Z0-9]{11}", message="Enter a valid 11-digit alphanumeric IFSC code")
//	@Column(name="ifsc")
//	private String ifsc;

	@NotNull
	@Size(min = 1, message = "is required")
	@Column(name = "branch")
	private String branch;

	@NotNull
	@Pattern(regexp = "(^$|[0-9]{12})", message = "enter a valid number and length must be 12 ")
	@Column(name = "ac_no")
	private String ac_no;

	// ------------------------------------------------------------------------------------
	// Getters and setters for PersonalInfo class
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getDob() {
		return Dob;
	}

	public void setDob(String dob) {
		Dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public String getAadhar_no() {
		return aadhar_no;
	}

	public void setAadhar_no(String aadhar_no) {
		this.aadhar_no = aadhar_no;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public String getHs_school() {
		return hs_school;
	}

	public void setHs_school(String hs_school) {
		this.hs_school = hs_school;
	}

	public String getHs_board() {
		return hs_board;
	}

	public void setHs_board(String hs_board) {
		this.hs_board = hs_board;
	}

	public String getHs_year() {
		return hs_year;
	}

	public void setHs_year(String hs_year) {
		this.hs_year = hs_year;
	}

	public String getHs_mars() {
		return hs_mars;
	}

	public void setHs_mars(String hs_mars) {
		this.hs_mars = hs_mars;
	}

	public String getH_school() {
		return h_school;
	}

	public void setH_school(String h_school) {
		this.h_school = h_school;
	}

	public String getH_board() {
		return h_board;
	}

	public void setH_board(String h_board) {
		this.h_board = h_board;
	}

	public String getH_year() {
		return h_year;
	}

	public void setH_year(String h_year) {
		this.h_year = h_year;
	}

	public String getH_mars() {
		return h_mars;
	}

	public void setH_mars(String h_mars) {
		this.h_mars = h_mars;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getAc_no() {
		return ac_no;
	}

	public void setAc_no(String ac_no) {
		this.ac_no = ac_no;
	}

//-----------------------------------------------------------------------------------------
	// Constructor for PersonalInfo
	public PersonalInfo(String username, String sName, String fName, String dob, String gender, String catagory,
			String aadhar_no, String phone, String email, String city, String state, int pin, String hs_school,
			String hs_board, String hs_year, String hs_mars, String h_school, String h_board, String h_year,
			String h_mars, String bName, String ifsc, String branch, String ac_no) {
		super();
		// this.application_number = application_number;
		this.userName = username;
		this.sName = sName;
		this.fName = fName;
		Dob = dob;
		this.gender = gender;
		this.catagory = catagory;
		this.aadhar_no = aadhar_no;
		this.phone = phone;
		this.email = email;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.hs_school = hs_school;
		this.hs_board = hs_board;
		this.hs_year = hs_year;
		this.hs_mars = hs_mars;
		this.h_school = h_school;
		this.h_board = h_board;
		this.h_year = h_year;
		this.h_mars = h_mars;
		this.bName = bName;
		this.ifsc = ifsc;
		this.branch = branch;
		this.ac_no = ac_no;
	}

	public PersonalInfo() {
		// TODO Auto-generated constructor stub
	}

}
