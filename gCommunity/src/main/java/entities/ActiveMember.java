package entities;

import entities.SimpleMember;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ActiveMember
 *
 */
@Entity

public class ActiveMember extends SimpleMember implements Serializable {

	
	private Integer phone;
	private String role;
	private static final long serialVersionUID = 1L;
	
	private List<Event> events;
	private Membership membership;

	public ActiveMember() {
		super();
	}   
	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}   
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@OneToOne
	public Membership getMembership() {
		return membership;
	}
	public void setMembership(Membership membership) {
		this.membership = membership;
	}
	@ManyToMany
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
   
}
