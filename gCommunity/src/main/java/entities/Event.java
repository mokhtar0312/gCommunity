package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	   
	
	private Integer id;
	private Date date ;
	private String name;
	private int numberOfParticipants;
	private String description;
	private Float fee;
	private static final long serialVersionUID = 1L;
	
	private List<ActiveMember> activeMembers ;
	private List<SimpleMember> simpleMembers ;

	public Event() {
		super();
	}   
	@Id
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
	public int getNumberOfParticipants() {
		return this.numberOfParticipants;
	}

	public void setNumberOfParticipants(int numberOfParticipants) {
		this.numberOfParticipants = numberOfParticipants;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public Float getFee() {
		return this.fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@ManyToMany(mappedBy="events")
	public List<ActiveMember> getActiveMembers() {
		return activeMembers;
	}
	public void setActiveMembers(List<ActiveMember> activeMembers) {
		this.activeMembers = activeMembers;
	}
	@ManyToMany(mappedBy="events")
	public List<SimpleMember> getSimpleMembers() {
		return simpleMembers;
	}
	public void setSimpleMembers(List<SimpleMember> simpleMembers) {
		this.simpleMembers = simpleMembers;
	}
   
}
