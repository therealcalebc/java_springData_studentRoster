/**
 * 
 */
package cd.java.springdata.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cd.java.springdata.studentroster.models.Student;
import cd.java.springdata.studentroster.repositories.StudentRepository;

/**
 * @author ccomstock
 *
 */
@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
//	private final StudentRepository studentRepository;
	
//	public StudentService(StudentRepository studentRepo) {
//		studentRepository = studentRepo;
//	}
	
	/**
	 * @param l the new Student to create in the db
	 * @return the newly created student
	 */
	public Student createOne(Student p) {
		return studentRepository.save(p);
	}
	
	/**
	 * @return list of all the Students in the db
	 */
	public List<Student> readAll() {
		return studentRepository.findAll();
	}
	
	/**
	 * @param search the first name to search for students by
	 * @return list of the students in the db containing the first name
	 */
	public List<Student> readManyByFirstName(String search) {
		return studentRepository.findByFirstNameContainingIgnoreCase(search);
	}
	
	/**
	 * @param search the last name to search for students by
	 * @return list of the students in the db containing the last name
	 */
	public List<Student> readManyByLastName(String search) {
		return studentRepository.findByLastNameContainingIgnoreCase(search);
	}
	
	/**
	 * @return list of the students in the db with no associated dorm
	 */
	public List<Student> readManyByNullDorm() {
		return studentRepository.findByDormIsNull();
	}
	
	/**
	 * @param id the id of the Student to retrieve from the db
	 * @return the Student that was retrieved
	 */
	public Student readOne(Long id) {
		Optional<Student> optLang = studentRepository.findById(id);
		if(optLang.isPresent())
			return optLang.get();
		else
			return null;
	}
	
	/**
	 * @param p the Student to update in the db
	 * @return the updated student
	 */
	public Student updateOne(Student p) {
		return studentRepository.save(p);
	}
	
	/**
	 * @param id the id of the Student to delete from the db
	 */
	public void destroyOneById(Long id) {
		if(studentRepository.existsById(id)) {
			studentRepository.deleteById(id);
		}
	}
	
	/**
	 * @param first the first name of the Student to delete from the db
	 * @param last the last name of the Student to delete from the db
	 */
	public void destroyOneByFirstAndLastName(String first, String last) {
		studentRepository.deleteByFirstNameAndLastNameIgnoringCase(first, last);
	}
	
}
