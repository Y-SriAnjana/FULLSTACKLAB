package com.example.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Course {
	
	@Id
	private Long courseId;
	private String title;
	private int duration;
	private double fee;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(Long courseId, String title, int duration, double fee) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.duration = duration;
		this.fee = fee;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", duration=" + duration + ", fee=" + fee + "]";
	}
	
	
	
}
