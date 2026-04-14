package com.example.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.example.Model.Course;
import com.example.Service.CourseService;

  @RestController
  @RequestMapping("/courses")
  public class CourseController {

   
    @Autowired
    private CourseService service;

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody Course course) 
    {
      return new ResponseEntity<>(service.addCourse(course), HttpStatus.CREATED);
    }

    @PutMapping("courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Long id,
      @RequestBody Course course) 
    {
        Course updated = service.updateCourse(id, course);
        if (updated != null)
            return ResponseEntity.ok(updated);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
        return ResponseEntity.ok("Course deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourse(@PathVariable Long id) {
        Course course = service.getCourseById(id);
        if (course != null)
            return ResponseEntity.ok(course);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Course not found");
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(service.getAllCourses());
    }

    @GetMapping("/search/{title}")
   public ResponseEntity<List<Course>> search(@PathVariable String title) {
        return ResponseEntity.ok(service.searchByTitle(title));
    }
}