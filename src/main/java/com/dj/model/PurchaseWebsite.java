package com.dj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Created by DJ on 12/10/16.
 */

@Entity
@Table(name = "purchase_website")
public class PurchaseWebsite extends Website{
	
	@Column(name = "price", nullable = false)
	private String price;
	
	/***	relations ***/
	@ManyToMany(mappedBy = "purchaseWebsites")
	private List<Game> games = new ArrayList<>();
	
	public PurchaseWebsite() {
		super();
	}
	
	public PurchaseWebsite(String name, String url, String price) {
		super(name, url);
		this.price = price;
	}
	
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getPrice() {
		return price;
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
	
	@Override
	public String toString() {
		return String.format("PurchaseWebsite[id: %d name: %s url: %s]",id, name, url);
	}
}
