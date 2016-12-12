package com.dj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by DJ on 11/15/16.
 */

@Entity
@Table(name = "publisher")
public class Publisher extends Company {
	
	@Column(name = "content_rating")
	private String contentRating;
	
	/*** relations ***/
	@OneToMany(mappedBy = "publisher")
	private List<Game> games = new ArrayList<>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Country country;
	
	public Publisher() {
		super();
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Publisher(String name, String contentRating) {
		super(name);
		this.contentRating = contentRating;
	}
	
	public void setContentRating(String contentRating) {
		this.contentRating = contentRating;
	}
	
	public String getContentRating() {
		return contentRating;
	}
	
	public void addGame(Game game) {
		games.add(game);
	}
	
	public List<Game> getGames() {
		return games;
	}
	
	@Override
	public String toString() {
		return String.format("Publisher[id: %d name: %s contentRating: %s]",
		                     id, name, contentRating);
	}
	
}
