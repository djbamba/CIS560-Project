package com.dj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Created by DJ on 11/15/16.
 */

@Entity
@DiscriminatorValue("DEV")
public class Developer extends Company {
	
	@Column(name = "lead_designer", nullable = false)
	private String leadDesigner;
	
	/*** relations ***/
	@OneToMany(mappedBy = "developer")
	private List<Game> games = new ArrayList<>();
	
	public Developer() {
		super();
	}
	
	public Developer(String name, String leadDesigner) {
		super(name);
		this.leadDesigner = leadDesigner;
	}
	
	public void setLeadDesigner(String leadDesigner) {
		this.leadDesigner = leadDesigner;
	}
	
	public String getLeadDesigner() {
		return leadDesigner;
	}
	
	public void addGame(Game game) {
		games.add(game);
	}
	
	public List<Game> getGames() {
		return games;
	}
	
	@Override
	public String toString() {
		return String.format("Developer[id: %d name: %s leadDesigner: %s]", id, name, leadDesigner);
	}
	
}

