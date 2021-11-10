package edu.bpb.oops.pattern.ch9.facade.content;

import java.util.List;

/**
 * @author Lalit Mehra
 *
 */
public interface ContentService {

	public Content fetchContent(String accessToken, String contentId, boolean advertize);
	
	public List<Content> fetchContent(String segment, boolean premium);
	
	public List<Content> fetchTrailers();
	
	public List<Content> fetchTrailers(String segment);
	
	public List<Content> fetchSponsoredContent();
	
	public List<Content> fetchSponsoredContent(String segment);
	
	public boolean isPremiumContent(String contentId);
	
}
