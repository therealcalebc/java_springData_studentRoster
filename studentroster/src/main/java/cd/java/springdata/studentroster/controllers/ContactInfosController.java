/**
 * 
 */
package cd.java.springdata.studentroster.controllers;

import java.util.List;

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

import cd.java.springdata.studentroster.models.ContactInfo;
import cd.java.springdata.studentroster.models.Student;
import cd.java.springdata.studentroster.services.ContactInfoService;
import cd.java.springdata.studentroster.services.StudentService;

/**
 * @author ccomstock
 *
 */
@Controller
@RequestMapping("/contactInfos")
public class ContactInfosController {

	private final StudentService studentService;
	private final ContactInfoService contactInfoService;
	
	public ContactInfosController(StudentService studentServ, ContactInfoService contactInfoServ) {
		studentService = studentServ;
		contactInfoService = contactInfoServ;
	}
	
	@GetMapping("/new")
	public String viewNew(@ModelAttribute ContactInfo contactInfo, Model model) {
		List<Student> studentList = studentService.readAll();
		model.addAttribute("students", studentList);
		return "contactInfos/new.jsp";
	}
	
	@PostMapping
	public String addNew(@Valid @ModelAttribute ContactInfo contactInfo, BindingResult result) {
		if(result.hasErrors()) return "contactInfos/new.jsp";
		contactInfoService.createOne(contactInfo);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/{id}")
	public String viewShow(@PathVariable Long id, Model model) {
		ContactInfo contactInfo = contactInfoService.readOne(id);
		if(contactInfo == null) return "redirect:/dashboard";
		model.addAttribute("contactInfo", contactInfo);
		return "contactInfos/show.jsp";
	}
	
	@GetMapping("/{id}/edit")
	public String viewEdit(@PathVariable Long id, Model model) {
		ContactInfo contactInfo = contactInfoService.readOne(id);
		if(contactInfo == null) return "redirect:/dashboard";
		model.addAttribute("contactInfo", contactInfo);
		List<Student> studentList = studentService.readAll();
		model.addAttribute("students", studentList);
		return "contactInfos/edit.jsp";
	}
	
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute ContactInfo contactInfo, BindingResult result) {
		if(result.hasErrors()) return "contactInfos/edit.jsp";
		contactInfoService.updateOne(contactInfo);
		return "redirect:/dashboard";
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		contactInfoService.destroyOneById(id);
		return "redirect:/dashboard";
	}
	
}
