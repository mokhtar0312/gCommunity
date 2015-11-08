package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Tutorial
 *
 */
@Entity
public class Tutorial implements Serializable {

	private Integer id;
	private String name;
	private String description;
	private Integer rate;
	private static final long serialVersionUID = 1L;
	
	private List<SimpleMember> simpleMembers;


	public Tutorial() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRate() {
		return this.rate;
	}

	public void setRate(Integer rate) {
		this.rate = rate;
	}
@ManyToMany(mappedBy="tutorials")
	public List<SimpleMember> getSimpleMembers() {
		return simpleMembers;
	}

	public void setSimpleMembers(List<SimpleMember> simpleMembers) {
		this.simpleMembers = simpleMembers;
	}

	

}
