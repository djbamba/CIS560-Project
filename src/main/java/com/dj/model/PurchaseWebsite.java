package com.dj.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Created by DJ on 12/10/16.
 */

@Entity
public class PurchaseWebsite {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "url", nullable = false)
	private String url;
	
	@Column(name = "price", nullable = false)
	private String price;
	
	@ManyToMany(mappedBy = "purchaseSites")
	private List<Game> games = new ArrayList<>();
	
	public PurchaseWebsite() {
		
	}
	
	public PurchaseWebsite(String name, String url, String price) {
		this.name = name;
		this.url = url;
		this.price = price;
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
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
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
