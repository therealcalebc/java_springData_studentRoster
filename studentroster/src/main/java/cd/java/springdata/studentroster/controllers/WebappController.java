/**
 * 
 */
package cd.java.springdata.studentroster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cd.java.springdata.studentroster.services.ContactInfoService;
import cd.java.springdata.studentroster.services.DormService;
import cd.java.springdata.studentroster.services.StudentService;

/**
 * @author ccomstock
 *
 */
@Controller
public class WebappController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private ContactInfoService contactInfoService;
	@Autowired
	private DormService dormService;

//	private final StudentService studentService;
//	private final ContactInfoService contactInfoService;
//	
//	public WebappController(StudentService studentServ, ContactInfoService contactInfoServ) {
//		studentService = studentServ;
//		contactInfoService = contactInfoServ;
//	}
	
	@GetMapping("/dashboard")
	public String viewDashboard(Model model) {
//		List<Student> studentList = studentService.readAll();
//		List<ContactInfo> contactInfoList = contactInfoService.readAll();
		model.addAttribute("students", studentService.readAll());
		model.addAttribute("contactInfos", contactInfoService.readAll());
		model.addAttribute("dorms", dormService.readAll());
		return "dashboard/index.jsp";
	}
	
}
