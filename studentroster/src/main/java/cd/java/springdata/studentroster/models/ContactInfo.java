/**
 * 
 */
package cd.java.springdata.studentroster.models;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ccomstock
 *
 */
@Entity
@Table(name="contactInfos")
public class ContactInfo implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3082289536109330559L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String address;
	private String city;
    private String state;
    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp updatedAt;
	@JsonIgnore
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="student_id")
    private Student student;
    
    public ContactInfo() {}
    
    public ContactInfo(String address, String city, String state, Student student) {
    	this.address = address;
    	this.city = city;
    	this.state = state;
    	this.student = student;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	
	/**
	 * @return the createdAt
	 */
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	
	/**
	 * @return the updatedAt
	 */
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}
	
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	

	@JsonProperty("studentName")
	public String getStudentName() {
		return String.format("%s %s", student.getFirstName(), student.getLastName());
	}

	@PrePersist
	protected void onCreate() {
		this.createdAt = Timestamp.valueOf(LocalDateTime.now());
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = Timestamp.valueOf(LocalDateTime.now());
	}
	
}
