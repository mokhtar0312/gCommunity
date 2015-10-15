package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vote {
	
	private Integer id;

	public Vote() {
		super();
	}

	@Id
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
