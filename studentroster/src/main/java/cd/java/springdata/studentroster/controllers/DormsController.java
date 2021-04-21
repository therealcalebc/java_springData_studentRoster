/**
 * 
 */
package cd.java.springdata.studentroster.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;

import cd.java.springdata.studentroster.models.Dorm;
import cd.java.springdata.studentroster.models.Student;
import cd.java.springdata.studentroster.services.DormService;
import cd.java.springdata.studentroster.services.StudentService;

/**
 * @author ccomstock
 *
 */
@Controller
@RequestMapping("/dorms")
public class DormsController {

	@Autowired
	private DormService dormService;
	@Autowired
	private StudentService studentService;

//	private final DormService dormService;
//	private final StudentService studentService;
//	
//	public DormsController(DormService dormServ, StudentService studServ) {
//		dormService = dormServ;
//		studentService = studServ;
//	}
	
	@GetMapping("/new")
	public String viewNew(@ModelAttribute Dorm dorm, Model model) {
		return "dorms/new.jsp";
	}
	
	@PostMapping
	public String addNew(@Valid @ModelAttribute Dorm dorm, BindingResult result) {
		if(result.hasErrors()) return "dorms/new.jsp";
		dormService.createOne(dorm);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/{id}")
	public String viewShow(@PathVariable Long id, Model model) {
		Dorm dorm = dormService.readOne(id);
		if(dorm == null) return "redirect:/dashboard";
		model.addAttribute("dorm", dorm);
		model.addAttribute("unassignedStudents", studentService.readManyByNullDorm());
		return "dorms/show.jsp";
	}
	
	@GetMapping("/{id}/addStudent")
	public String addStudent(@PathVariable Long id, @RequestParam(value="studentToAddId") Long studentId) {
		Dorm dorm = dormService.readOne(id);
		if(dorm == null) return "redirect:/dashboard";
//		System.out.printf("DormsController.addStudent(id=%d, studentId=%d)\n", id, studentId);
		Student student = studentService.readOne(studentId);
		student.setDorm(dorm);
		studentService.updateOne(student);
		return String.format("redirect:/dorms/%d", id);
	}
	
	@GetMapping("/{id}/removeStudent")
	public String removeStudent(@PathVariable Long id, @RequestParam(value="studentToRemoveId") Long studentId) {
		Dorm dorm = dormService.readOne(id);
		if(dorm == null) return "redirect:/dashboard";
		System.out.printf("DormsController.removeStudent(id=%d, studentId=%d)\n", id, studentId);
		Student student = studentService.readOne(studentId);
		student.setDorm(null);
		studentService.updateOne(student);
		return String.format("redirect:/dorms/%d", id);
	}
	
	@GetMapping("/{id}/edit")
	public String viewEdit(@PathVariable Long id, Model model) {
		Dorm dorm = dormService.readOne(id);
		if(dorm == null) return "redirect:/dashboard";
		model.addAttribute("dorm", dorm);
		return "dorms/edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute Dorm dorm, BindingResult result) {
		if(result.hasErrors()) return "dorms/edit.jsp";
		dormService.updateOne(dorm);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		dormService.destroyOneById(id);
		return "redirect:/dashboard";
	}
	
}
