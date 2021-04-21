/**
 * 
 */
package cd.java.springdata.studentroster.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="students")
public class Student implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 603317268753372596L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    @Column(updatable=false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    @OneToOne(mappedBy="student", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    private ContactInfo contactInfo;
	@JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dorm dorm;
    
    public Student() {}
    
    public Student(String fn, String ln, Integer age) {
    	firstName = fn;
    	lastName = ln;
    	this.age = age;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the contactInfo
	 */
//	@JsonProperty
	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	/**
	 * @param contactInfo the contactInfo to set
	 */
//	@JsonIgnore
	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	/**
	 * @return the dorm
	 */
	public Dorm getDorm() {
		return dorm;
	}

	/**
	 * @param dorm the dorm to set
	 */
	public void setDorm(Dorm dorm) {
		this.dorm = dorm;
	}

	@JsonProperty("dormName")
	public String getDormName() {
		if(dorm != null)
			return dorm.getName();
		else
			return "null";
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
