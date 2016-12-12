package com.dj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Created by DJ on 11/10/16.
 */

@Entity
public class System {
	
	private final static List<String> IGNORE = new ArrayList<String>() {{
		add("PLAYSTATION NETWORK");
		add("XBOX LIVE");
		add("ESHOP");
		add("MOBILE");
		add("MOBILE PHONE");
		add("MOBILE PHONES");
		add("VERIZON");
		add("CLOUD");
		
	}};
	
	private final static List<String> MAC_OS = new ArrayList<String>() {{
		add("CLASSIC MAC OS");
		add("MAC");
		add("MAC OS");
		add("MACOS");
		add("MAC OS X");
		add("OS X");
		add("MACINTOSH");
	}};
	
	private final static List<String> WINDOWS = new ArrayList<String>() {{
		add("WINDOWS");
		add("MICROSOFT WINDOWS");
	}};
	
	private final static List<String> WINDOWS_PHONE = new ArrayList<String>() {{
		add("WINDOWS MOBILE");
		add("WINDOWS PHONE");
	}};
	
	private final static List<String> XBOX_LIVE_ARCADE = new ArrayList<String>() {{
		add("XBOX LIVE ARCADE");
		add("XBLA");
	}};
	
	private final static String PS2 = "PS2";
	
	private final static String PS3 = "PS3";
	
	private final static String PSP = "PSP";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; // primary key
	
	@Column(unique = true)
	private String name;
	
	/***	relations ***/
	@ManyToMany(mappedBy = "systems", cascade = CascadeType.ALL)
	private List<Game> games = new ArrayList<>();
	
	public System() {
		
	}
	
	public System(String name) {
		this.name = cleanName(name);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
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
	
	public static boolean shouldIgnore(String name) {
		for (String ignore : IGNORE) {
			if (name.trim().equalsIgnoreCase(ignore)) {
				return true;
			}
		}
		return false;
	}
	
	private String cleanName(String name) {
		String trimmedName = name.trim().toUpperCase();
		
		if (PSP.equals(trimmedName))
			return "PlayStation Portable";
		if (PS2.equals(trimmedName))
			return "PlayStation 2";
		if (PS3.equals(trimmedName))
			return "PlayStation 3";
		if (MAC_OS.contains(trimmedName))
			return "Mac OS X";
		if (WINDOWS_PHONE.contains(trimmedName))
			return "Windows Phone";
		if (WINDOWS.contains(trimmedName))
			return "Windows";
		if (XBOX_LIVE_ARCADE.contains(trimmedName))
			return "Xbox Live Arcade";
		return name;
	}
	
	@Override
	public String toString() {
		return String.format("System[id: %d name: %s]", id, name);
	}
	
}
