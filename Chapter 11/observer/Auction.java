package edu.bpb.oops.pattern.ch11.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import edu.bpb.oops.pattern.ch11.observer.model.Article;

/**
 * Auction is an {@code Observable} entity that updates its {@code Observer}
 * 
 * @author Lalit Mehra
 * @since May 10, 2021
 *
 */
public class Auction implements Observable, Event {

	private List<Observer> observers;
	private List<Article> articles;
	private int articleCount;
	private int totalArticles;

	public Auction(List<Article> articles) {
		this.observers = new ArrayList<Observer>();
		this.articles = articles;
		this.articleCount = 0;
		this.totalArticles = articles.size();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void deregisterObserver(Observer observer) {
		Iterator<Observer> iterator = observers.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().equals(observer)) {
				iterator.remove();
			}
		}

	}

	@Override
	public void notifyObservers(Article article) {
		observers.forEach((o) -> {
			try {
				o.update((Article) article.clone());
			} catch (CloneNotSupportedException e) {
				log(e);
			}
		});
	}

	private void log(CloneNotSupportedException e) {
		// dummy implementation 
		// create a separate logger implementation for logging requirements 
	}

	@Override
	public void start() {
		next();
	}

	@Override
	public void next() {
		Optional<Article> article = getArticle();
		if (!article.isEmpty()) {
			notifyObservers(article.get());
		} else {
			end();
		}
	}

	private Optional<Article> getArticle() {
		if (totalArticles > articleCount) {
			return Optional.ofNullable(articles.get(articleCount++));
		} else {
			return Optional.empty();
		}
	}

}
