package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Streams
 *
 */
@Entity
public class Streams implements Serializable {

	private Integer id;
	private Date date_diffusion;
	private String winner;
	private Integer viewers;
	private static final long serialVersionUID = 1L;

	
	
	public Streams() {
		super();
	}

	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate_diffusion() {
		return this.date_diffusion;
	}

	public void setDate_diffusion(Date date_diffusion) {
		this.date_diffusion = date_diffusion;
	}

	public String getWinner() {
		return this.winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public Integer getViewers() {
		return this.viewers;
	}

	public void setViewers(Integer viewers) {
		this.viewers = viewers;
	}

	

}
