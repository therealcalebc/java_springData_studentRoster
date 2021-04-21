/**
 * 
 */
package cd.java.springdata.studentroster.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cd.java.springdata.studentroster.models.Dorm;
import cd.java.springdata.studentroster.repositories.DormRepository;

/**
 * @author ccomstock
 *
 */
@Service
public class DormService {

	private final DormRepository dormRepository;
	
	public DormService(DormRepository dormRepo) {
		dormRepository = dormRepo;
	}
	
	/**
	 * @param l the new Dorm to create in the db
	 * @return the newly created person
	 */
	public Dorm createOne(Dorm d) {
		return dormRepository.save(d);
	}
	
	/**
	 * @return list of all the Dorms in the db
	 */
	public List<Dorm> readAll() {
		return dormRepository.findAll();
	}
	
	/**
	 * @param search the name to search for dorms by
	 * @return list of the dorms in the db with name containing the search string
	 */
	public List<Dorm> readManyByName(String search) {
		return dormRepository.findByNameContainingIgnoringCase(search);
	}
	
	/**
	 * @param id the id of the Dorm to retrieve from the db
	 * @return the Dorm that was retrieved
	 */
	public Dorm readOne(Long id) {
		Optional<Dorm> optDorm = dormRepository.findById(id);
		if(optDorm.isPresent())
			return optDorm.get();
		else
			return null;
	}
	
	/**
	 * @param d the Dorm to update in the db
	 * @return the updated Dorm
	 */
	public Dorm updateOne(Dorm d) {
		return dormRepository.save(d);
	}
	
	/**
	 * @param id the id of the Dorm to delete from the db
	 */
	public void destroyOneById(Long id) {
		if(dormRepository.existsById(id)) {
			dormRepository.deleteById(id);
		}
	}
	
	/**
	 * 
	 * 
	 */
	public void destroyByName(String name) {
		dormRepository.deleteByNameIs(name);
	}
	
}
