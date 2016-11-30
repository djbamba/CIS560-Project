package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

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
	private Set<Genre> genres = new HashSet<>();
	
	@OneToMany(targetEntity = Website.class, cascade = CascadeType.ALL)
	@JoinTable(name = "game_purchase_site", joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
	 inverseJoinColumns = @JoinColumn(name = "website_id", referencedColumnName = "id"))
	@JsonProperty("websites")
	private Set<Website> websites = new HashSet<>();
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private Set<Score> scores = new HashSet<>();
	
	@ManyToMany(mappedBy = "games")
	private Set<System> systems = new HashSet<>();
	
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
	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}
	
	@JsonProperty("genres")
	public Set<Genre> getGenres() {
		return genres;
	}
	
	@JsonProperty("websites")
	public void setWebsites(Set<Website> websites) {
		this.websites = websites;
	}
	
	@JsonProperty("websites")
	public Set<Website> getWebsites() {
		return websites;
	}
	
	@JsonProperty("scores")
	public void setScores(Set<Score> scores) {
		this.scores = scores;
	}
	
	@JsonProperty("scores")
	public Set<Score> getScores() {
		return scores;
	}
	
	@JsonProperty("systems")
	public void setSystems(Set<System> systems) {
		this.systems = systems;
	}
	
	@JsonProperty("systems")
	public Set<System> getSystems() {
		return systems;
	}
	
	@Override
	public String toString() {
		return String.format("Game[id: %d name: %s release: %s]",
		                     id, name, release);
	}
}
