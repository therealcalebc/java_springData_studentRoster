/**
 * 
 */
package cd.java.springdata.studentroster.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cd.java.springdata.studentroster.models.Student;
import cd.java.springdata.studentroster.services.StudentService;

/**
 * @author ccomstock
 *
 */
@RestController
public class StudentsApi {

	private final StudentService studentService;
	
	public StudentsApi(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/api/students")
	public List<Student> readAll() {
		return studentService.readAll();
	}
	
	@PostMapping("/api/students")
	public Student create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer age) {
		Student student = new Student(firstName, lastName, age);
		return studentService.createOne(student);
	}
	
	@GetMapping("/api/students/{id}")
	public Student readOne(@PathVariable Long id) {
		Student student = studentService.readOne(id);
		return student;
	}
	
	@PutMapping("/api/students/{id}")
	public Student update(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName, @RequestParam Integer age) {
		Student student = studentService.readOne(id);
		if(student != null) {
			student.setFirstName(firstName);
			student.setLastName(lastName);
			student.setAge(age);
		}
		return studentService.updateOne(student);
	}
	
	@DeleteMapping("/api/students/{id}")
	public void destroy(@PathVariable Long id) {
		studentService.destroyOneById(id);
	}
	
}
