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
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="Course")
	private List<SubjectEntity> subList;

	public List<SubjectEntity> getSubList() {
		return subList;
	}

	public void setSubList(List<SubjectEntity> subList) {
		this.subList = subList;
	}

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

	public CourseEntity(int courseId,
			@NotEmpty(message = "Please Enter Valid Course Name") @Size(min = 2, max = 50, message = "Course Name length should be between 2 to 50 characters") String courseName,
			@NotEmpty(message = "Please Enter Valid Course Description") @Size(min = 10, max = 100, message = "Description length should be between 10 to 100 characters") String description,
			List<SubjectEntity> subList) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
		this.subList = subList;
	}

	@Override
	public String toString() {
		return "CourseEntity [courseId=" + courseId + ", courseName=" + courseName + ", description=" + description
				+ ", subList=" + subList + "]";
	}

	
}
