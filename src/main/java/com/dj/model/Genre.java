package com.dj.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
@Table(name = "genre")
public class Genre {
	
	private static List<String> ignore = Arrays.asList(new String[]{"GAME", "VIDEO", "4X", "[11]"});
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "genre", nullable = false, unique = true)
	private String genre;
	
	/*relations*/
	@ManyToMany(mappedBy = "genres")
	private List<Game> games = new ArrayList<>();
	
	public Genre() {
		
	}
	
	public Genre(String genre) {
		this.genre = genre;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void addGame(Game game) {
		games.add(game);
	}
	
	public void setGames(List<Game> games) {
		this.games = games;
	}
	
	public List<Game> getGames() {
		return games;
	}
	
	public String cleanGenre(String genre) {
		StringBuilder sb = new StringBuilder();
		for (String section : genre.split("[ |-]")) {
			for (String ig : ignore) {
				if (section.equalsIgnoreCase(ig)) {
					continue;
				}
				sb.append(section + " ");
			}
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return String.format("Genre[id: %d genre: %s]", id, genre);
	}
	
}
