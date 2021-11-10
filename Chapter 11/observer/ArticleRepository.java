package edu.bpb.oops.pattern.ch11.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import edu.bpb.oops.pattern.ch11.observer.model.Article;

/**
 * Dummy implementation of a repository, that provides articles for an auction 
 * 
 * @author Lalit Mehra
 *
 */
public class ArticleRepository {

	public static List<Article>  getArticles() {
		List<Article> articles = new ArrayList<>();
		IntStream.range(0, 6).forEach(x -> articles.add(new Article()));
		return articles;
	}
	
}
