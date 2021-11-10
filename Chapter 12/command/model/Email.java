package edu.bpb.oops.pattern.ch12.command.model;

import java.util.List;

/**
 * Custom object that describes an email
 * 
 * @author Lalit Mehra
 *
 */
public class Email {

	private String to;
	private List<String> ccTo;
	private String subject;
	private String content;

	public Email(String to, String subject, String content) {
		this.to = to;
		this.subject = subject;
		this.content = content;
	}

	public String getTo() {
		return to;
	}

	public String getSubject() {
		return subject;
	}

	public String getContent() {
		return content;
	}

	public List<String> getCcTo() {
		return ccTo;
	}

	public void setCcTo(List<String> ccTo) {
		this.ccTo = ccTo;
	}

}
