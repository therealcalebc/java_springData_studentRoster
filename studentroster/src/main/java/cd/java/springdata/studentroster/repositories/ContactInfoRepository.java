/**
 * 
 */
package cd.java.springdata.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cd.java.springdata.studentroster.models.ContactInfo;

/**
 * @author ccomstock
 *
 */
@Repository
public interface ContactInfoRepository extends CrudRepository<ContactInfo, Long> {

	// this method retrieves all the contactInfos from the database
	List<ContactInfo> findAll();
	
	// this method finds contactInfos associated with students with first name containing the search string
	List<ContactInfo> findByStudentFirstNameContainingIgnoreCase(String search);
	
	// this method finds contactInfos associated with students with last name containing the search string
	List<ContactInfo> findByStudentLastNameContainingIgnoreCase(String search);
	
	// this method counts how many contactInfos have city containing the search string
	Long countByCityContaining(String search);
	
	// this method counts how many contactInfos have state containing the search string
	Long countByStateContaining(String search);
	
	// this method deletes a contactInfo that has address, city, & state matching the search strings
	Long deleteByAddressIsAndCityIsAndStateIsAllIgnoringCase(String address, String city, String state);
	
}
