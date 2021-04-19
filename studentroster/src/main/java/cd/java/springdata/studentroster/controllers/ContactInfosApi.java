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

import cd.java.springdata.studentroster.models.ContactInfo;
import cd.java.springdata.studentroster.services.ContactInfoService;
import cd.java.springdata.studentroster.services.StudentService;

/**
 * @author ccomstock
 *
 */
@RestController
public class ContactInfosApi {

	private final ContactInfoService contactInfoService;
	private final StudentService studentService;
	
	public ContactInfosApi(ContactInfoService contactInfoService, StudentService studentService) {
		this.contactInfoService = contactInfoService;
		this.studentService = studentService;
	}
	
	@GetMapping("/api/contactInfos")
	public List<ContactInfo> readAll() {
		return contactInfoService.readAll();
	}
	
	@PostMapping("/api/contactInfos")
	public ContactInfo create(@RequestParam String address, @RequestParam String city, @RequestParam String state, @RequestParam Long studentId) {
		ContactInfo contactInfo = new ContactInfo(address, city, state, studentService.readOne(studentId));
		return contactInfoService.createOne(contactInfo);
	}
	
	@GetMapping("/api/contactInfos/{id}")
	public ContactInfo readOne(@PathVariable Long id) {
		ContactInfo contactInfo = contactInfoService.readOne(id);
		return contactInfo;
	}
	
	@PutMapping("/api/contactInfos/{id}")
	public ContactInfo update(@PathVariable Long id, @RequestParam String address, @RequestParam String city, @RequestParam String state, @RequestParam Long studentId) {
		ContactInfo contactInfo = contactInfoService.readOne(id);
		if(contactInfo != null) {
			contactInfo.setAddress(address);
			contactInfo.setCity(city);
			contactInfo.setState(state);
			contactInfo.setStudent(studentService.readOne(studentId));
		}
		return contactInfoService.updateOne(contactInfo);
	}
	
	@DeleteMapping("/api/contactInfos/{id}")
	public void destroy(@PathVariable Long id) {
		contactInfoService.destroyOneById(id);
	}
	
}
