/**
 * 
 */
package cd.java.springdata.studentroster.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cd.java.springdata.studentroster.models.Dorm;

/**
 * @author ccomstock
 *
 */
@Repository
public interface DormRepository extends CrudRepository<Dorm, Long> {

	// this method retrieves all the dorms from the database
	List<Dorm> findAll();
	
	// this method finds dorms with name containing the search string ignoring case
	List<Dorm> findByNameContainingIgnoringCase(String search);
	
	// this method deletes a dorm that has name matching the search strings
	Long deleteByNameIs(String name);
	
}
