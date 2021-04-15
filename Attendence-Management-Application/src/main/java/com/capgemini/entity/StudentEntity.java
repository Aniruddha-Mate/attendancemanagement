package com.capgemini.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Students")
public class StudentEntity {
	
	@Id
	@Column(name = "roll_no")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	
	@Column(name = "first_name")
	@NotEmpty
	@Size(min=2, message="Not a valid first name")
	private String firstName;
	
	
	@Column(name = "last_name")
	@NotEmpty
	@Size(min=2, message="Not a valid last name")
	private String lastName;
	
	@Column(name = "DOB")
	private Date dateOfBirth;
	
	private String gender;
	
	@Column(name = "mobile_no")
	@NotNull
	@Min(value = 99999999, message="invalid number")
	@Max(value = 999999999, message="invalid number")
	private long mobileNumber;
	
	@NotNull
	private int semester;
	
	@Column(name = "email_id")
	@Email(message = "invalid email")
	private String emailId;
	
	@Column(name = "father_email_id")
	@Email(message = "invalid email")
	private String fatherEmailId;
	
	@Column(name = "father_mobile_number")
	@NotNull
	@Min(value = 99999999, message="invalid number")
	@Max(value = 999999999, message="invalid number")
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