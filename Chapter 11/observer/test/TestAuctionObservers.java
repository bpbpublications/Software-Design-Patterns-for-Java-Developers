package edu.bpb.oops.pattern.ch11.observer.test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import edu.bpb.oops.pattern.ch11.observer.ArticleRepository;
import edu.bpb.oops.pattern.ch11.observer.Auction;
import edu.bpb.oops.pattern.ch11.observer.Observer;
import edu.bpb.oops.pattern.ch11.observer.model.Article;
import edu.bpb.oops.pattern.ch11.observer.observers.impl.Auctioneer;
import edu.bpb.oops.pattern.ch11.observer.observers.impl.Buyer;

/**
 * Functional Test to verify Observer Design Patter functionality
 * 
 * @author Lalit Mehra
 *
 */
public class TestAuctionObservers {

	public static void main(String[] args) {
		
		/* Initialise Observers */
		Observer auctioneer = new Auctioneer();
		
		List<Observer> buyers = new ArrayList<>();
		IntStream.range(0, 4).forEach(x -> buyers.add(new Buyer()));
		
		List<Article> articles = ArticleRepository.getArticles();

		/* Initialise Auction */
		Auction auction = new Auction(articles);
		auction.registerObserver(auctioneer);
		buyers.stream().forEach(x -> auction.registerObserver(x));
		auction.start();
		articles.stream().forEach(x -> auction.next());
		
	}

}
