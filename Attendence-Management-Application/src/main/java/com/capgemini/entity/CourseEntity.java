package com.capgemini.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "Courses")
public class CourseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="courses_generations")
	@SequenceGenerator(name="courses_generations", sequenceName = "courses_sequences", allocationSize=1)	
	private int courseId;
	
	@Column(name = "course_name")
	@NotEmpty(message="Please Enter Valid Course Name")
	@Size(min = 2, max=50, message="Course Name length should be between 2 to 50 characters")
	private String courseName;
    
	@NotEmpty(message = "Please Enter Valid Course Description")
	@Size(min = 10, max = 100, message = "Description length should be between 10 to 100 characters")
	private String description;
	
	/*
	 * @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy =
	 * "courseId") private List<SubjectEntity> subjectId;
	 * 
	 * @OneToOne(mappedBy = "courseId") private StudentEntity studentId;
	 */

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/*
	 * public List<SubjectEntity> getSubjectId() { return subjectId; }
	 * 
	 * public void setSubjectId(List<SubjectEntity> subjectId) { this.subjectId =
	 * subjectId; }
	 * 
	 * public StudentEntity getStudentId() { return studentId; }
	 * 
	 * public void setStudentId(StudentEntity studentId) { this.studentId =
	 * studentId; }
	 */
	
	@Override
	public String toString() {
		return "CoursesEntity [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ",]";
	}

}
