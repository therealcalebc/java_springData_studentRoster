/**
 * 
 */
package cd.java.springdata.studentroster.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author ccomstock
 *
 */
@Entity
@Table(name="dorms")
public class Dorm implements java.io.Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -6980913891072756471L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private LocalDateTime createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss a")
    private LocalDateTime updatedAt;
    @OneToMany(mappedBy="dorm", fetch = FetchType.LAZY)
    private List<Student> students;
    
    public Dorm() {}
    
    public Dorm(String name) {
    	this.name = name;
    }

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the createdAt
	 */
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	/**
	 * @param student the student to add to the students list
	 * @return the result of adding student to the collection
	 */
	public boolean addStudent(Student student) {
		return students.add(student);
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
    
}
