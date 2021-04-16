package com.capgemini.entity;


import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;



@Entity
@Table(name = "Attendances")
public class AttendanceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="attendances_generations")
	@SequenceGenerator(name="attendances_generations",sequenceName="attendances_sequences",allocationSize=1)
	private int attendanceId;

    @NotEmpty(message="Please Enter Valid Semester")
	private String semester;
	
    @NotNull
    private LocalDate currentDate;
	
    @NotEmpty(message="Please Enter Valid Status (Present/Absent)")
    @Pattern(regexp="(absent|Absent|present|Present)", message="Please enter valid Status")
	private String status;
    
    @ManyToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="roll_no")
	private StudentEntity student;
    
    
    public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public int getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(int attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(LocalDate currentDate) {
		this.currentDate = currentDate;
	}

	public AttendanceEntity(int attendanceId, @NotEmpty(message = "Please Enter Valid Semester") String semester,
			@NotNull LocalDate currentDate,
			@NotEmpty(message = "Please Enter Valid Status (Present/Absent)") @Pattern(regexp = "(absent|Absent|present|Present)", message = "Please enter valid Status") String status,
			StudentEntity student) {
		super();
		this.attendanceId = attendanceId;
		this.semester = semester;
		this.currentDate = currentDate;
		this.status = status;
		this.student = student;
	}

	@Override
	public String toString() {
		return "AttendanceEntity [attendanceId=" + attendanceId + ", semester=" + semester + ", currentDate="
				+ currentDate + ", status=" + status + ", student=" + student + "]";
	}
	
	

}




