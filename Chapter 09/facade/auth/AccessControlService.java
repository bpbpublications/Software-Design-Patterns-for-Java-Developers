package edu.bpb.oops.pattern.ch9.facade.auth;

import edu.bpb.oops.pattern.ch9.facade.user.User;
import edu.bpb.oops.pattern.ch9.facade.user.UserCredentials;

/**
 * @author Lalit Mehra
 *
 */
public interface AccessControlService {

	public String getAccessToken(User user);
	
	public AuthResponse authenticate(UserCredentials credentials);
	
	public AuthResponse authenticate(User user);
	
	public AuthResponse authorize(User user, String accessToken);
	
}
