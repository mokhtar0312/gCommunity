package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class vote {
	
	private Integer id;

	public vote() {
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
