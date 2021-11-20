package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	int id;
	String title;
	String description;
	String releaseYear;
	int languageId;
	String languageName;
	int rentalDuration;
	double rentalRate;
	int length;
	double replacementCost;
	String rating;
	String specialFeatures;
	private List<Actor> actors;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getReleaseYear() {
		return releaseYear;
	}
	
	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}
	
	public int getLanguageId() {
		return languageId;
	}
	
	public void setLanguageId(int language_id) {
		this.languageId = language_id;
	}
	
	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}
	
	public Film(int id, String title, String description, String releaseYear, int languageId, String languageName,
			int rentalDuration, double rentalRate, int length, double replacementCost, String rating,
			String specialFeatures, List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = languageId;
		this.languageName = languageName;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actors = actors;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}
	
	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}
	
	public double getRentalRate() {
		return rentalRate;
	}
	
	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public double getReplacementCost() {
		return replacementCost;
	}
	
	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}
	
	public String getRating() {
		return rating;
	}
	
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	public String getSpecialFeatures() {
		return specialFeatures;
	}
	
	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}
	
	public List<Actor> getActors() {
		return actors;
	}
	
	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(actors, description, id, languageId, languageName, length, rating, releaseYear,
				rentalDuration, rentalRate, replacementCost, specialFeatures, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(description, other.description) && id == other.id
				&& languageId == other.languageId && Objects.equals(languageName, other.languageName)
				&& length == other.length && Objects.equals(rating, other.rating)
				&& Objects.equals(releaseYear, other.releaseYear) && rentalDuration == other.rentalDuration
				&& Double.doubleToLongBits(rentalRate) == Double.doubleToLongBits(other.rentalRate)
				&& Double.doubleToLongBits(replacementCost) == Double.doubleToLongBits(other.replacementCost)
				&& Objects.equals(specialFeatures, other.specialFeatures) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Film id: ").append(id).append(" title: ").append(title).append(", ")
				.append(description).append(", released in: ").append(releaseYear).append(", language_id=")
				.append(languageId).append(", rentalDuration=").append(rentalDuration).append(", rentalRate=")
				.append(rentalRate).append(", length=").append(length).append(", replacementCost=")
				.append(replacementCost).append(", rating=").append(rating).append(", specialFeatures=")
				.append(specialFeatures).append(", actors=").append(actors).append("]\n");
		return builder.toString();
		
		//title, year, rating, description, language written out not the number 
	}
	
	public Film(int id, String title, String description, String releaseYear, int language_id, int rentalDuration,
			double rentalRate, int length, double replacementCost, String rating, String specialFeatures,
			List<Actor> actors) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.languageId = language_id;
		this.rentalDuration = rentalDuration;
		this.rentalRate = rentalRate;
		this.length = length;
		this.replacementCost = replacementCost;
		this.rating = rating;
		this.specialFeatures = specialFeatures;
		this.actors = actors;
	}
	
	public Film() {
		
	}
}
