/**
 * 
 */
package cd.java.springdata.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cd.java.springdata.studentroster.models.ContactInfo;
import cd.java.springdata.studentroster.repositories.ContactInfoRepository;

/**
 * @author ccomstock
 *
 */
@Service
public class ContactInfoService {

	private final ContactInfoRepository contactInfoRepository;
	
	public ContactInfoService(ContactInfoRepository contactInfoRepo) {
		contactInfoRepository = contactInfoRepo;
	}
	
	/**
	 * @param l the new ContactInfo to create in the db
	 * @return the newly created student
	 */
	public ContactInfo createOne(ContactInfo p) {
		return contactInfoRepository.save(p);
	}
	
	/**
	 * @return list of all the ContactInfos in the db
	 */
	public List<ContactInfo> readAll() {
		return contactInfoRepository.findAll();
	}
	
	/**
	 * @param search the first name to search for students by
	 * @return list of the students in the db containing the first name
	 */
	public List<ContactInfo> readManyByFirstName(String search) {
		return contactInfoRepository.findByStudentFirstNameContainingIgnoreCase(search);
	}
	
	/**
	 * @param search the last name to search for students by
	 * @return list of the students in the db containing the last name
	 */
	public List<ContactInfo> readManyByLastName(String search) {
		return contactInfoRepository.findByStudentLastNameContainingIgnoreCase(search);
	}
	
	/**
	 * @param id the id of the ContactInfo to retrieve from the db
	 * @return the ContactInfo that was retrieved
	 */
	public ContactInfo readOne(Long id) {
		Optional<ContactInfo> optContactInfo = contactInfoRepository.findById(id);
		if(optContactInfo.isPresent())
			return optContactInfo.get();
		else
			return null;
	}
	
	/**
	 * @param p the ContactInfo to update in the db
	 * @return the updated student
	 */
	public ContactInfo updateOne(ContactInfo p) {
		return contactInfoRepository.save(p);
	}
	
	/**
	 * @param id the id of the ContactInfo to delete from the db
	 */
	public void destroyOneById(Long id) {
		if(contactInfoRepository.existsById(id)) {
			contactInfoRepository.deleteById(id);
		}
	}
	
}
