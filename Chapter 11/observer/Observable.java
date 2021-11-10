package edu.bpb.oops.pattern.ch11.observer;

import edu.bpb.oops.pattern.ch11.observer.model.Article;

/**
 * An {@code Observable} is an entity that wraps content and allows to observer the content.<br>
 * The implementation must override the notifyObservers method to notify the registered {@code Observer} about any changes
 * 
 * @author Lalit Mehra
 * @since Dec 20, 2019
 * @see Observer
 *
 */
public interface Observable {
	
	/**
	 * Adds an observer to the registration list. <br>
	 * Once added the new observer will be notified of all the changes.
	 * @param observer
	 */
	public void registerObserver(Observer observer);
	
	/**
	 * Remove an observer from the registration list
	 * @param observer
	 */
	public void deregisterObserver(Observer observer);
	
	/**
	 * Notify observers about the new article
	 * @param txn
	 */
	public void notifyObservers(Article article);

}
