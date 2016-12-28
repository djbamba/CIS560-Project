package com.dj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; // primary key
	
	@Column(unique = true)
	private String name;
	
	@Column(name = "release_date")
	private String release;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	/*** relations ***/
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "game_genre", joinColumns = @JoinColumn(name = "game_id"),
	 inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre> genres = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "game_score_website", joinColumns = @JoinColumn(name = "game_id"),
	 inverseJoinColumns = @JoinColumn(name = "score_website_id"))
	private List<ScoreWebsite> scoreWebsites = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "game_purchase_website", joinColumns = @JoinColumn(name = "game_id"),
	 inverseJoinColumns = @JoinColumn(name = "purchase_website_id"))
	private List<PurchaseWebsite> purchaseWebsites = new ArrayList<>();
	
	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private List<Score> scores = new ArrayList<>();
	
	@ManyToMany
	@JoinTable(name = "game_system", joinColumns = @JoinColumn(name = "game_id"),
	 inverseJoinColumns = @JoinColumn(name = "system_id"))
	private List<System> systems = new ArrayList<>();
	
	@ManyToOne(targetEntity = Developer.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "developer_id")
	private Developer developer;
	
	@ManyToOne(targetEntity = Publisher.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "publisher_id")
	private Publisher publisher;
	
	@OneToMany(targetEntity = Comment.class, cascade = CascadeType.ALL)
	@JoinTable(name = "game_comment", joinColumns = @JoinColumn(name = "game_id"),
	 inverseJoinColumns = @JoinColumn(name = "comment_id"))
	private List<Comment> comments;
	
	public Game() {
	}
	
	public Game(String name, String release) {
		this.name = name;
		this.release = release;
	}
	/*constructor for seeding*/
	public Game(String id, String name, String release, String imageUrl) {
		this.id = Integer.parseInt(id);
		this.name = name;
		this. release = release;
		this.imageUrl = imageUrl;
	}
	
	public Developer getDeveloper() {
		return developer;
	}
	
	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}
	
	public Publisher getPublisher() {
		return publisher;
	}
	
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setRelease(String release) {
		this.release = release;
	}
	
	public String getRelease() {
		return this.release;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void addGenres(List<Genre> genres) {
		this.genres.addAll(genres);
	}
	
	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}
	
	public List<Genre> getGenres() {
		return genres;
	}
	
	public void addScoreWebsites(List<ScoreWebsite> scoreWebsites) {
		this.scoreWebsites.addAll(scoreWebsites);
	}
	
	public void setScoreWebsites(List<ScoreWebsite> scoreWebsites) {
		this.scoreWebsites = scoreWebsites;
	}
	
	public List<ScoreWebsite> getScoreWebsites() {
		return scoreWebsites;
	}
	
	public void addScores(List<Score> scores) {
		
		this.scores.addAll(scores);
	}
	
	public void setPurchaseWebsites(List<PurchaseWebsite> purchaseWebsites) {
		this.purchaseWebsites = purchaseWebsites;
	}
	
	public List<PurchaseWebsite> getPurchaseWebsites() {
		return purchaseWebsites;
	}
	
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
	public List<Score> getScores() {
		return scores;
	}
	
	public void addSystems(List<System> systems) {
		this.systems.addAll(systems);
	}
	
	public void setSystems(List<System> systems) {
		this.systems = systems;
	}
	
	public List<System> getSystems() {
		return systems;
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	@Override
	public String toString() {
		return String.format("Game[id: %d name: %s release: %s]",
		                     id, name, release);
	}
}
