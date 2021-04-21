/**
 * 
 */
package cd.java.springdata.studentroster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cd.java.springdata.studentroster.models.Dorm;
import cd.java.springdata.studentroster.models.Student;
import cd.java.springdata.studentroster.services.DormService;
import cd.java.springdata.studentroster.services.StudentService;

/**
 * @author ccomstock
 *
 */
@RestController
public class DormsApi {
	
	@Autowired
	private DormService dormService;
	@Autowired
	private StudentService studentService;

//	private final DormService dormService;
//	private final StudentService studentService;
//	
//	public DormsApi(DormService dormServ, StudentService studServ) {
//		dormService = dormServ;
//		studentService = studServ;
//	}
	
	@GetMapping("/api/dorms")
	public List<Dorm> readAll() {
		return dormService.readAll();
	}
	
	@PostMapping("/api/dorms")
	public Dorm create(@RequestParam String name) {
		Dorm dorm = new Dorm(name);
		return dormService.createOne(dorm);
	}
	
	@GetMapping("/api/dorms/{id}")
	public Dorm readOne(@PathVariable Long id) {
		Dorm dorm = dormService.readOne(id);
		return dorm;
	}
	
	@GetMapping("/api/dorms/{id}/addStudent")
	public Dorm readOneAndAddStudent(@PathVariable Long id, @RequestParam(value="studentToAdd") Long studentId) {
		Dorm dorm = dormService.readOne(id);
		Student student = studentService.readOne(studentId);
		student.setDorm(dorm);
		studentService.updateOne(student);
		return dorm;
	}
	
	@GetMapping("/api/dorms/{id}/removeStudent")
	public Dorm readOneAndRemoveStudent(@PathVariable Long id, @RequestParam(value="studentToAdd") Long studentId) {
		Student student = studentService.readOne(studentId);
		student.setDorm(null);
		studentService.updateOne(student);
		Dorm dorm = dormService.readOne(id);
		return dorm;
	}
	
	@PutMapping("/api/dorms/{id}")
	public Dorm update(@PathVariable Long id, @RequestParam String name) {
		Dorm dorm = dormService.readOne(id);
		if(dorm != null) {
			dorm.setName(name);
		}
		return dormService.updateOne(dorm);
	}
	
	@DeleteMapping("/api/dorms/{id}")
	public void destroy(@PathVariable Long id) {
		dormService.destroyOneById(id);
	}
	
}
