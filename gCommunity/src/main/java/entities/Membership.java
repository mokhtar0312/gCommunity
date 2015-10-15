package entities;

import java.io.Serializable;
import java.lang.Float;
import java.lang.Integer;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Membership
 *
 */
@Entity

public class Membership implements Serializable {

	
	private Integer id;
	private Float fee;
	private static final long serialVersionUID = 1L;

	public Membership() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Float getFee() {
		return this.fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}
   
}
