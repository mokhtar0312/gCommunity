package entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: Vote
 *
 */
@Entity
public class Vote implements Serializable {

	private VoteID voteid;
	private ActiveMember activemembervoter;
	private ActiveMember activemembervoted;

	@ManyToOne
	@JoinColumn(name = "voter", referencedColumnName = "id", updatable = false, insertable = false)
	public ActiveMember getActivemembervoter() {
		return activemembervoter;
	}

	public void setActivemembervoter(ActiveMember activemembervoter) {
		this.activemembervoter = activemembervoter;
	}

	@ManyToOne
	@JoinColumn(name = "voted", referencedColumnName = "id", updatable = false, insertable = false)
	public ActiveMember getActivemembervoted() {
		return activemembervoted;
	}

	public void setActivemembervoted(ActiveMember activemembervoted) {
		this.activemembervoted = activemembervoted;
	}

	@EmbeddedId
	public VoteID getVoteid() {
		return voteid;
	}

	public void setVoteid(VoteID voteid) {
		this.voteid = voteid;
	}

	private Integer year;
	private static final long serialVersionUID = 1L;

	public Vote() {
		super();
	}

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
