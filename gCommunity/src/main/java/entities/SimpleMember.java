package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: simpleMember
 *
 */
@Entity(name="simpleMember")

public class SimpleMember implements Serializable {

	private Integer id;
	private String name; 	
	private String surname;
	private String username;
	private String password;
	private String summonerName;
	private String server;
	private Double xp;
	private String email;
	private static final long serialVersionUID = 1L;
	
	private List<Streams> streamss;
	private List<Tutorial> tutorials;
	private List<Event>events;
	private List<Model3D>model3Ds;
	private List<Packs> packss;

	public SimpleMember() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}  
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
	@ManyToMany
	public List<Model3D> getModel3Ds() {
		return model3Ds;
	}
	public void setModel3Ds(List<Model3D> model3Ds) {
		this.model3Ds = model3Ds;
	}
	@ManyToMany
	public List<Tutorial> getTutorials() {
		return tutorials;
	}
	public void setTutorials(List<Tutorial> tutorials) {
		this.tutorials = tutorials;
	}
	@ManyToMany
	public List<Packs> getPackss() {
		return packss;
	}
	public void setPackss(List<Packs> packss) {
		this.packss = packss;
	}
	@ManyToMany
	public List<Streams> getStreamss() {
		return streamss;
	}
	public void setStreamss(List<Streams> streamss) {
		this.streamss = streamss;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}

   
}
