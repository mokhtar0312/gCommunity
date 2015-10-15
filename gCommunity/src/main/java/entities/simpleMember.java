package entities;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: simpleMember
 *
 */
@Entity(name="simpleMember")

public class simpleMember implements Serializable {

	
	private String name;   
	
	private Integer id;
	private String surname;
	private String username;
	private String password;
	private String summonerName;
	private Double xp;
	private String email;
	private static final long serialVersionUID = 1L;

	public simpleMember() {
		super();
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	@Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}   
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getSummonerName() {
		return this.summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}   
	public Double getXp() {
		return this.xp;
	}

	public void setXp(Double xp) {
		this.xp = xp;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
}
