package com.capgemini.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Students")
public class StudentEntity {
	
	@Id
	@Column(name = "roll_no")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "DOB")
	private Date dateOfBirth;
	
	private String gender;
	
	@Column(name = "mobile_no")
	private long mobileNumber;
	
	private int semester;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "father_email_id")
	private String fatherEmailId;
	
	@Column(name = "father_mobile_number")
	private long fatherMobileNumber;
	
	private int subjectId;
	
	private String subjectName;

	public int getId() {
		return studentId;
	}

	public void setId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFatherEmailId() {
		return fatherEmailId;
	}

	public void setFatherEmailId(String fatherEmailId) {
		this.fatherEmailId = fatherEmailId;
	}

	public long getFatherMobileNumber() {
		return fatherMobileNumber;
	}

	public void setFatherMobileNumber(long fatherMobileNumber) {
		this.fatherMobileNumber = fatherMobileNumber;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + ", mobileNumber=" + mobileNumber + ", semester=" + semester
				+ ", emailId=" + emailId + ", fatherEmailId=" + fatherEmailId + ", fatherMobileNumber="
				+ fatherMobileNumber + ", subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}
	
}