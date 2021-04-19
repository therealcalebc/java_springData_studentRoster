/**
 * 
 */
package cd.java.springdata.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cd.java.springdata.studentroster.models.Student;

/**
 * @author ccomstock
 *
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

	// this method retrieves all the students from the database
	List<Student> findAll();
	
	// this method finds students with first name containing the search string
	List<Student> findByFirstNameContainingIgnoreCase(String search);
	
	// this method finds students with last name containing the search string
	List<Student> findByLastNameContainingIgnoreCase(String search);
	
	// this method finds the 10 students with the lowest age in ascending order
	List<Student> findFirst10ByOrderByAgeAsc();
	
	// this method finds the 10 students with the highest age in descending order
	List<Student> findFirst10ByOrderByAgeDesc();
	
	// this method counts how many students have contactInfo with city containing the search string
	Long countByContactInfoCityContaining(String search);
	
	// this method counts how many students have contactInfo with state containing the search string
	Long countByContactInfoStateContaining(String search);
	
	// this method deletes a student by matching firstName and lastName
	Long deleteByFirstNameAndLastNameIgnoringCase(@Param("firstName") String firstName, @Param("lastName") String lastName);
	
}
