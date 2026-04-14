package com.example.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	List<Course> findByTitleContainingIgnoreCase(String title);
}
