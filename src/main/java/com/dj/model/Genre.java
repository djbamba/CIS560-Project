package com.dj.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Created by DJ on 11/10/16.
 */
// TODO: 12/15/16 Write cleanGenre better
@Entity
@Table(name = "genre")
public class Genre {
	
	private final static List<String> IGNORE = new ArrayList<String>() {{
		add("4X");
		add("[11]");
		add("[2]");
		add("[4]");
		add("[6]");
		add("[7]");
	}};
	
	private final static List<String> FILTER = new ArrayList<String>() {{
		add("GAME");
		add("VIDEO");
	}};
	
	private final static List<String> PLATFORMER = new ArrayList<String>() {{
		add("PLATFORMER");
		add("PLATFORM");
		add("PLATFORMING");
	}};
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "genre", nullable = false, unique = true)
	private String genre;
	
	/***	relations ***/
	@ManyToMany(mappedBy = "genres",fetch = FetchType.LAZY)
	private List<Game> games = new ArrayList<>();
	
	public Genre(String genre) {
		this.genre = cleanGenre(genre);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Genre() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setGenre(String genre) {
		
		this.genre = cleanGenre(genre);
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	public void addGame(Game game) {
		games.add(game);
	}
	
	public String getGenre() {
		return genre;
	}
	
	private String cleanGenre(String genre) {
		ArrayList<String> genreX = new ArrayList<>();
		String[] genreName = genre.split("[ |-]");
		
		for (String section : genreName) {
			if (FILTER.contains(section.toUpperCase()))
				continue;
			else if (genreX.contains(section.toUpperCase()))
				continue;
			else if (PLATFORMER.contains(section.toUpperCase()) && !genreX.contains(section.toUpperCase()))
				genreX.add("PLATFORMER");
			else
				genreX.add(section.toUpperCase());
		}
		return genreX.stream().collect(Collectors.joining(" "));
	}
	
	public static boolean shouldIgnore(String name) {
		for (String ignore : IGNORE) {
			if (IGNORE.contains(name.trim().toUpperCase())) {
				return true;
			}
		}
		return false;
	}
	
	public List<Game> getGames() {
		return games;
	}
	
	@Override
	public String toString() {
		return String.format("Genre[id: %d genre: %s]", id, genre);
	}
	
}
