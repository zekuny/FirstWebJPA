package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the USERJPA database table.
 * 
 */
@Entity
@Table(name="Userjpa", schema="testdb")
@NamedQuery(name="Userjpa.findAll", query="SELECT u FROM Userjpa u")
public class Userjpa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "userJPASeq", sequenceName = "userjpa_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userJPASeq")
	private long twitterid;

	private String post;

	private String postdate;

	private String username;

	public Userjpa() {
	}

	public long getTwitterid() {
		return this.twitterid;
	}

	public void setTwitterid(long twitterid) {
		this.twitterid = twitterid;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getPostdate() {
		return this.postdate;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}