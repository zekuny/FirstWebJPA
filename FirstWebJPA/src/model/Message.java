package model;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the "MESSAGE" database table.
 * 
 */
@Entity
@Table(name="\"MESSAGE\"")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "messageSeq", sequenceName = "message_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "messageSeq")
	private long messageid;

	@Column(name="\"MESSAGE\"")
	private String message;

	private String receiver;

	private String sender;

	public Message() {
	}

	public long getMessageid() {
		return this.messageid;
	}

	public void setMessageid(long messageid) {
		this.messageid = messageid;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return this.sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

}