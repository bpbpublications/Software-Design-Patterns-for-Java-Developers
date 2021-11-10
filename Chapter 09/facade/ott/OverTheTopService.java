package edu.bpb.oops.pattern.ch9.facade.ott;

import java.util.List;

import edu.bpb.oops.pattern.ch9.facade.content.Content;
import edu.bpb.oops.pattern.ch9.facade.payment.PaymentMode;
import edu.bpb.oops.pattern.ch9.facade.user.UserCredentials;

/**
 * @author Lalit Mehra
 *
 */
public interface OverTheTopService {

	public Content getContent(String contentId);

	public List<Content> visitSegment(String segmentId);

	void subscribe(UserCredentials credentials, PaymentMode payMode);

}