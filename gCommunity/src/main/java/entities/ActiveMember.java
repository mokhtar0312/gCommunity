package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.sun.mail.handlers.message_rfc822;

/**
 * Entity implementation class for Entity: ActiveMember
 *
 */
@Entity
public class ActiveMember extends SimpleMember implements Serializable {

	private Integer phone;
	private String role;
	private Boolean approved;
	private static final long serialVersionUID = 1L;

	private List<Event> events;
	private Membership membership;
	private List<Equipment> equipments;
	private List<News> news;
	private List<Sponsor> sponsors;
	private List<Streams> streamsss;
	private List<Vote> voters;
	private List<Vote> voteds;
	private List<Message> messages ;
	private List<Notification> notifications ;
	
	@OneToMany(mappedBy="activemembervoter")
	public List<Vote> getVoters() {
		return voters;
	}

	public void setVoters(List<Vote> voters) {
		this.voters = voters;
	}
	
	@OneToMany(mappedBy="activemembervoted")
	public List<Vote> getVoteds() {
		return voteds;
	}

	public void setVoteds(List<Vote> voteds) {
		this.voteds = voteds;
	}

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

	@ManyToMany
	public List<Streams> getStreamsss() {
		return streamsss;
	}

	public void setStreamsss(List<Streams> streamsss) {
		this.streamsss = streamsss;
	}
@OneToMany(mappedBy="activeMember")
	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	@OneToMany(mappedBy="activeMember")
	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}


	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}



}
