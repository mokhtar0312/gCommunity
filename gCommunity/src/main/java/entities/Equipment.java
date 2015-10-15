package entities;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Equipment
 *
 */
@Entity

public class Equipment implements Serializable {

	
	private Integer Id;
	private String reference;
	private String name;
	private Boolean state;
	private static final long serialVersionUID = 1L;

	public Equipment() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}   
	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public Boolean getState() {
		return this.state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}
   
}
