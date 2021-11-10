package edu.bpb.oops.pattern.ch11.observer.model;

/**
 * Stores information of an article 
 * 
 * @author Lalit Mehra
 *
 */
public class Article implements Cloneable {

	private long id;
	private String name;
	private double basePrice;
	private String description;
	private String trivia;
	private String imageUrl;

	public Article() {
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTrivia() {
		return trivia;
	}

	public void setTrivia(String trivia) {
		this.trivia = trivia;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", basePrice=");
		builder.append(basePrice);
		builder.append(", description=");
		builder.append(description);
		builder.append(", trivia=");
		builder.append(trivia);
		builder.append(", imageUrl=");
		builder.append(imageUrl);
		builder.append("]");
		return builder.toString();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
