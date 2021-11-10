package edu.bpb.oops.pattern.ch9.facade.ott;

import java.util.LinkedList;
import java.util.List;

import edu.bpb.oops.pattern.ch9.facade.auth.AccessControlService;
import edu.bpb.oops.pattern.ch9.facade.auth.AuthResponse;
import edu.bpb.oops.pattern.ch9.facade.content.Content;
import edu.bpb.oops.pattern.ch9.facade.content.ContentService;
import edu.bpb.oops.pattern.ch9.facade.payment.PaymentMode;
import edu.bpb.oops.pattern.ch9.facade.payment.PaymentOrder;
import edu.bpb.oops.pattern.ch9.facade.payment.PaymentResponse;
import edu.bpb.oops.pattern.ch9.facade.payment.PaymentService;
import edu.bpb.oops.pattern.ch9.facade.subscription.SubscriptionService;
import edu.bpb.oops.pattern.ch9.facade.user.User;
import edu.bpb.oops.pattern.ch9.facade.user.UserAccessService;
import edu.bpb.oops.pattern.ch9.facade.user.UserCredentials;

/**
 * @author Lalit Mehra
 *
 */
public class GrandMovies implements OverTheTopService {

	private AccessControlService accessControlS;
	private ContentService contentS;
	private SubscriptionService subscriptionS;
	private UserAccessService userAccessS;
	private PaymentService paymentS;
	
	public GrandMovies(AccessControlService acs, ContentService cs, 
			SubscriptionService ss, UserAccessService uas, PaymentService ps) {
		accessControlS = acs;
		contentS = cs;
		subscriptionS = ss;
		userAccessS = uas;
		paymentS = ps;
	}
	
	@Override
	public Content getContent(String contentId) {
		Content content = null;
		User user = userAccessS.getCurrentUser();
		String accessToken = accessControlS.getAccessToken(user);
		AuthResponse authR = accessControlS.authorize(user, accessToken);
		if(authR.isAuthorized()) {
			boolean premiumContent = contentS.isPremiumContent(contentId);
			if(premiumContent) {
				if(user.isPremiumMember()) {
					content = contentS.fetchContent(accessToken, contentId, false);
				} else {
					content = contentS.fetchContent(accessToken, contentId, true);
				}
			} else {
				content = contentS.fetchContent(accessToken, contentId, false);
			}
		}
		return content;
	}

	@Override
	public void subscribe(UserCredentials credentials, PaymentMode payMode) {
		AuthResponse authR = accessControlS.authenticate(credentials);
		User user = userAccessS.getCurrentUser();
		if(authR.isAuthenticated()) {
			PaymentOrder payOrder = paymentS.prepareOrder(payMode, subscriptionS.getSubscriptionCharge(), user);
			PaymentResponse paymentR = paymentS.pay(payOrder);
			if(paymentR.isSuccessful()) {
				subscriptionS.subscribe(user);
			}
		}
	}

	@Override
	public List<Content> visitSegment(String segmentId) {
		List<Content> contentL = new LinkedList<>();
		User user = userAccessS.getCurrentUser();
		String accessToken = accessControlS.getAccessToken(user);
		AuthResponse authR = accessControlS.authorize(user, accessToken);
		if(authR.isAuthorized()) {
			if(user.isPremiumMember()) {
				contentL.addAll(contentS.fetchContent(segmentId, true));
			} else {
				contentL.addAll(contentS.fetchContent(segmentId, false));
				contentL.addAll(contentS.fetchTrailers(segmentId));
			}
			contentL.addAll(contentS.fetchSponsoredContent(segmentId));
		}
		
		return contentL;
	}

}
