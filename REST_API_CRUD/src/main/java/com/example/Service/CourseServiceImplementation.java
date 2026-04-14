package com.example.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Model.Course;
import com.example.Repository.CourseRepository;

@Service
public class CourseServiceImplementation implements CourseService{

	@Autowired
	private CourseRepository repo;
	
	public Course addCourse(Course course) {
		return repo.save(course);
	}
	
	public Course updateCourse(Long id, Course course) {
		Course existing = repo.findById(id).orElse(null);
		
		if(existing != null) {
			existing.setTitle(course.getTitle());
			existing.setDuration(course.getDuration());
			existing.setFee(course.getFee());
			return repo.save(existing);
		}
		return null;
	}
	
	public void deleteCourse(Long id) {
		repo.deleteById(id);
	}
	
	public Course getCourseById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public List<Course> getAllCourses() {
		return repo.findAll();
	}
	
	public List<Course> searchByTitle(String title) {
		return repo.findByTitleContainingIgnoreCase(title);
	}
}
