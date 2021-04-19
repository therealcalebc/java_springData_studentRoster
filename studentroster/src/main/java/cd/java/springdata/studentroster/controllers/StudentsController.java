/**
 * 
 */
package cd.java.springdata.studentroster.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cd.java.springdata.studentroster.models.Student;
import cd.java.springdata.studentroster.services.StudentService;

/**
 * @author ccomstock
 *
 */
@Controller
@RequestMapping("/students")
public class StudentsController {

	private final StudentService studentService;
	
	public StudentsController(StudentService studentServ) {
		studentService = studentServ;
	}
	
	@GetMapping("/new")
	public String viewNew(@ModelAttribute Student student) {
		return "students/new.jsp";
	}
	
	@PostMapping
	public String addNew(@Valid @ModelAttribute Student student, BindingResult result) {
		if(result.hasErrors()) return "students/new.jsp";
		studentService.createOne(student);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/{id}")
	public String viewShow(@PathVariable Long id, Model model) {
		Student student = studentService.readOne(id);
		if(student == null) return "redirect:/dashboard";
		model.addAttribute("student", student);
		return "students/show.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String viewEdit(@PathVariable Long id, Model model) {
		Student student = studentService.readOne(id);
		if(student == null) return "redirect:/dashboard";
		model.addAttribute("student", student);
		return "students/edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute Student student, BindingResult result) {
		if(result.hasErrors()) return "students/edit.jsp";
		studentService.updateOne(student);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		studentService.destroyOneById(id);
		return "redirect:/dashboard";
	}
	
}
