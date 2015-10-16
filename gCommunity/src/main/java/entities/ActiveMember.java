package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: ActiveMember
 *
 */
@Entity
public class ActiveMember extends SimpleMember implements Serializable {

	private Integer phone;
	private String role;
	private static final long serialVersionUID = 1L;

	private List<Vote> votes;
	private List<Event> events;
	private Membership membership;
	private List<Equipment> equipments;
	private List<News> news;
	private List<Sponsor> sponsors;
	private List<Streams> streamsss;
	private Vote vote;

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

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	@OneToOne
	public Vote getVote() {
		return vote;
	}

	public void setVote(Vote vote) {
		this.vote = vote;
	}

}
