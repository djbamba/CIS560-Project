package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonProperty("id")
	private int id; // primary key
	
	@Column(unique = true)
	@JsonProperty("name")
	private String name;
	
	@Column(name = "release_date")
	@JsonProperty("release_date")
	private String release;
	
	@Column(name = "image_url")
	@JsonProperty("image_url")
	private String imageUrl;
	
	//relations
	@ManyToMany(targetEntity = Genre.class, cascade = CascadeType.ALL)
	@JoinTable(name = "game_genre", joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
	 inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
	@JsonProperty("genres")
	private List<Genre> genres;
	
	@OneToMany(targetEntity = Website.class, cascade = CascadeType.ALL)
	@JoinTable(name = "game_purchase_site", joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
	 inverseJoinColumns = @JoinColumn(name = "website_id", referencedColumnName = "id"))
	@JsonProperty("websites")
	private List<Website> websites;
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<Score> scores;
	
	@ManyToMany(mappedBy = "games")
	private List<System> systems;
	
	public Game() {
	}
	
	public Game(String name, String release) {
		this.name = name;
		this.release = release;
	}
	
	@JsonProperty("id")
	public void setId(int id) {
		this.id = id;
	}
	
	@JsonProperty("id")
	public int getId() {
		return this.id;
	}
	
	@JsonProperty
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("name")
	public String getName() {
		return this.name;
	}
	
	@JsonProperty("release")
	public void setRelease(String release) {
		this.release = release;
	}
	
	@JsonProperty("release")
	public String getRelease() {
		return this.release;
	}
	
	@JsonProperty("image_url")
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@JsonProperty("image_url")
	public String getImageUrl() {
		return imageUrl;
	}
	
	@JsonProperty("genres")
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	@JsonProperty("genres")
	public List<Genre> getGenres() {
		return genres;
	}
	
	@JsonProperty("websites")
	public void setWebsites(List<Website> websites) {
		this.websites = websites;
	}
	
	@JsonProperty("websites")
	public List<Website> getWebsites() {
		return websites;
	}
	
	@JsonProperty("scores")
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
	@JsonProperty("scores")
	public List<Score> getScores() {
		return scores;
	}
	
	@JsonProperty("systems")
	public void setSystems(List<System> systems) {
		this.systems = systems;
	}
	
	@JsonProperty("systems")
	public List<System> getSystems() {
		return systems;
	}
	
	@Override
	public String toString() {
		return String.format("Game[id: %d name: %s release: %s]",
		                     id, name, release);
	}
}
