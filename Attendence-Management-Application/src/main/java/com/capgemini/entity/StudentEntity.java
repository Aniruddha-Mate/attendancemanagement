package com.capgemini.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="Students")
public class StudentEntity {
	
	@Id
	@Column(name = "roll_no")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="students_generations")
	@SequenceGenerator(name="students_generations", sequenceName = "students_sequences", allocationSize=1)	
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
	
	@NotEmpty
	@Pattern(regexp="^(?:m|M|male|Male|f|F|female|Female)$", message="Invalid Entry")
	private String gender;
	
	@Column(name = "mobile_no")
	@NotEmpty
	@Pattern(regexp="(^[6-9][0-9]{9}$)", message="Invalid Mobile Number")
	private String mobileNumber;
	
	@NotEmpty
	private String semester;
	
	@Column(name = "email_id")
	@Email(message = "invalid email")
	private String emailId;
	
	@Column(name = "father_email_id")
	@Email(message = "invalid email")
	private String fatherEmailId;
	
	@Column(name = "father_mobile_number")
	@NotEmpty
	@Pattern(regexp="(^[6-9][0-9]{9}$)", message="Invalid Mobile Number")
	private String fatherMobileNumber;
	
	@NotNull
	private int subjectId;
	
	@NotEmpty
	private String subjectName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="faculty_id")
	private FacultyEntity faculty;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="student")
	private List<AttendanceEntity> attendanceList;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="Student_Course",joinColumns= {@JoinColumn(name="student_id")},
	inverseJoinColumns= {@JoinColumn(name="course_id")})
	private CourseEntity course;
	
	

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public FacultyEntity getFaculty() {
		return faculty;
	}

	public void setFaculty(FacultyEntity faculty) {
		this.faculty = faculty;
	}

	public List<AttendanceEntity> getAttendanceList() {
		return attendanceList;
	}

	public void setAttendanceList(List<AttendanceEntity> attendanceList) {
		this.attendanceList = attendanceList;
	}

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
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

	public String getFatherMobileNumber() {
		return fatherMobileNumber;
	}

	public void setFatherMobileNumber(String fatherMobileNumber) {
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

	public StudentEntity(int studentId, @NotEmpty @Size(min = 2, message = "Not a valid first name") String firstName,
			@NotEmpty @Size(min = 2, message = "Not a valid last name") String lastName, Date dateOfBirth,
			@NotEmpty @Pattern(regexp = "^(?:m|M|male|Male|f|F|female|Female)$", message = "Invalid Entry") String gender,
			@NotEmpty @Pattern(regexp = "(^[6-9][0-9]{9}$)", message = "Invalid Mobile Number") String mobileNumber,
			@NotEmpty String semester, @Email(message = "invalid email") String emailId,
			@Email(message = "invalid email") String fatherEmailId,
			@NotEmpty @Pattern(regexp = "(^[6-9][0-9]{9}$)", message = "Invalid Mobile Number") String fatherMobileNumber,
			@NotNull int subjectId, @NotEmpty String subjectName, FacultyEntity faculty,
			List<AttendanceEntity> attendanceList, CourseEntity course) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.mobileNumber = mobileNumber;
		this.semester = semester;
		this.emailId = emailId;
		this.fatherEmailId = fatherEmailId;
		this.fatherMobileNumber = fatherMobileNumber;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.faculty = faculty;
		this.attendanceList = attendanceList;
		this.course = course;
	}

	@Override
	public String toString() {
		return "StudentEntity [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", mobileNumber=" + mobileNumber
				+ ", semester=" + semester + ", emailId=" + emailId + ", fatherEmailId=" + fatherEmailId
				+ ", fatherMobileNumber=" + fatherMobileNumber + ", subjectId=" + subjectId + ", subjectName="
				+ subjectName + ", faculty=" + faculty + ", attendanceList=" + attendanceList + ", course=" + course
				+ "]";
	}
	
	
	
}