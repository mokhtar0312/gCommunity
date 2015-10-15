package entities;

import entities.SimpleMember;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
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
   
}
