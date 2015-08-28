package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the USERPROFILE database table.
 * 
 */
@Entity
@Table(name="Userprofile", schema="testdb")
@NamedQuery(name="Userprofile.findAll", query="SELECT u FROM Userprofile u")
public class Userprofile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "userProfileSeq", sequenceName = "userprofile_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userProfileSeq")
	private long userprofileid;

	private String firstname;

	private String joindate;

	private String lastname;

	private String moto;

	private String username;

	public Userprofile() {
	}

	public long getUserprofileid() {
		return this.userprofileid;
	}

	public void setUserprofileid(long userprofileid) {
		this.userprofileid = userprofileid;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getJoindate() {
		return this.joindate;
	}

	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMoto() {
		return this.moto;
	}

	public void setMoto(String moto) {
		this.moto = moto;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}