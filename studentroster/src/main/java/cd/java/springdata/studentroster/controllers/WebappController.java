/**
 * 
 */
package cd.java.springdata.studentroster.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cd.java.springdata.studentroster.models.ContactInfo;
import cd.java.springdata.studentroster.models.Student;
import cd.java.springdata.studentroster.services.ContactInfoService;
import cd.java.springdata.studentroster.services.StudentService;

/**
 * @author ccomstock
 *
 */
@Controller
public class WebappController {

	private final StudentService studentService;
	private final ContactInfoService contactInfoService;
	
	public WebappController(StudentService studentServ, ContactInfoService contactInfoServ) {
		studentService = studentServ;
		contactInfoService = contactInfoServ;
	}
	
	@GetMapping("/dashboard")
	public String viewDashboard(Model model) {
		List<Student> studentList = studentService.readAll();
		List<ContactInfo> contactInfoList = contactInfoService.readAll();
		model.addAttribute("students", studentList);
		model.addAttribute("contactInfos", contactInfoList);
		return "dashboard/index.jsp";
	}
	
}
