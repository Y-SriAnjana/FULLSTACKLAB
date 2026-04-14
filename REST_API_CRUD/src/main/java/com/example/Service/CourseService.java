package com.example.Service;
import java.util.List;
import com.example.Model.Course;

public interface CourseService {
	Course addCourse(Course course);
	
	Course updateCourse(Long id, Course course);
	void deleteCourse(Long id);
	Course getCourseById(Long id);
	List<Course> getAllCourses();
	List<Course> searchByTitle(String title);
}
