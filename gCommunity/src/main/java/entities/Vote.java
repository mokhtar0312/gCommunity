package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Entity implementation class for Entity: Vote
 *
 */
@Entity
public class Vote implements Serializable {

	private Integer id;
	private ActiveMember member;
	private Boolean voted;
	private Integer year;
	private static final long serialVersionUID = 1L;

	private ActiveMember activeMember;

	public Vote() {
		super();
	}

	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ActiveMember getMember() {
		return this.member;
	}

	public void setMember(ActiveMember member) {
		this.member = member;
	}

	public Boolean getVoted() {
		return this.voted;
	}

	public void setVoted(Boolean voted) {
		this.voted = voted;
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@OneToOne(mappedBy = "vote")
	public ActiveMember getActiveMember() {
		return activeMember;
	}

	public void setActiveMember(ActiveMember activeMember) {
		this.activeMember = activeMember;
	}

}
