package edu.bpb.oops.pattern.ch9.facade.auth;

/**
 * @author Lalit Mehra
 *
 */
public class AuthResponse {
	
	private String accessToken;
	private boolean authenticated;
	private boolean authorized;
	
	public String getAccessToken() {
		return accessToken;
	}
	
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
	public boolean isAuthenticated() {
		return authenticated;
	}
	
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	
	public boolean isAuthorized() {
		return authorized;
	}
	
	public void setAuthorized(boolean authorized) {
		this.authorized = authorized;
	}

}
