package com.capgemini.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Faculties")
public class FacultyEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="faculties_generations")
	@SequenceGenerator(name="faculties_generations", sequenceName = "faculties_sequences", allocationSize=1)
	private int facultyId;
	
    @Column(name = "faculty_user_name") 
	@NotEmpty
	@Size(min=5, max = 30, message = "Not a valid name")
    private String facultyName;
    
    @OneToMany(cascade=CascadeType.ALL,mappedBy="faculty")
	private List<StudentEntity> studentList;

	public List<StudentEntity> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<StudentEntity> studentList) {
		this.studentList = studentList;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}

	public FacultyEntity(int facultyId,
			@NotEmpty @Size(min = 5, max = 30, message = "Not a valid name") String facultyName,
			List<StudentEntity> studentList) {
		super();
		this.facultyId = facultyId;
		this.facultyName = facultyName;
		this.studentList = studentList;
	}

	@Override
	public String toString() {
		return "FacultyEntity [facultyId=" + facultyId + ", facultyName=" + facultyName + ", studentList=" + studentList
				+ "]";
	}
	



	
	
	
}