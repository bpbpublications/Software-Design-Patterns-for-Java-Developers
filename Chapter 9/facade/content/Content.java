package edu.bpb.oops.pattern.ch9.facade.content;

/**
 * @author Lalit Mehra
 *
 */
public class Content {

	private String contentId;
	private boolean premium;
	
	public String getContentId() {
		return contentId;
	}
	
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	
	public boolean isPremium() {
		return premium;
	}
	
	public void setPremium(boolean premium) {
		this.premium = premium;
	}
	
}
