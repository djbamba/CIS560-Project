package com.dj.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

import static com.sun.tools.doclint.Entity.ge;

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
	
	@JsonProperty("release")
	private String release;
	
	//relations
	@ManyToMany(targetEntity = Genre.class, cascade = CascadeType.ALL)
	@JoinTable(name = "game_genre", joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
	 inverseJoinColumns = @JoinColumn(name = "genre_id", referencedColumnName = "id"))
	@JsonProperty("genres")
	private Set<Genre> genres;

	@OneToMany(targetEntity = Website.class, cascade = CascadeType.ALL)
	@JoinTable(name = "game_purchase_site", joinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"),
	 inverseJoinColumns = @JoinColumn(name = "website_id", referencedColumnName = "id"))
	@JsonProperty("websites")
	private Set<Website> websites;
	
	
	@ManyToMany(targetEntity = System.class,cascade = CascadeType.ALL)
	private Set<System> systems;
	
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

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setWebsites(Set<Website> websites) {
		this.websites = websites;
	}

	public Set<Website> getWebsites() {
		return websites;
	}
	
	@Override
	public String toString() {
		return String.format("id: %d name: %s release: %s",
		                     id, name, release);
	}
}
