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
	private List<Equipment>equipments;
	private List<News>news;
	private List<Sponsor>sponsors;

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
	@ManyToMany
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	@ManyToMany
	public List<News> getNews() {
		return news;
	}
	public void setNews(List<News> news) {
		this.news = news;
	}
	@ManyToMany
	public List<Sponsor> getSponsors() {
		return sponsors;
	}
	public void setSponsors(List<Sponsor> sponsors) {
		this.sponsors = sponsors;
	}
   
}
