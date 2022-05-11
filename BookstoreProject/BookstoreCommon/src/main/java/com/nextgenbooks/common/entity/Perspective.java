package com.nextgenbooks.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "perspectives")
public class Perspective {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, length = 50, unique = true)
	private String name;
	@Column(length = 100, nullable = false, unique = true)
	private String alias;
	//store as hash set for fast access
	@ManyToMany
	@JoinTable(
				name = "perspectives_genres", 
				joinColumns = @JoinColumn(name = "perspective_id"),
				inverseJoinColumns = @JoinColumn(name = "genre_id")
				)
	
	
	
	private Set<Genre> genres = new HashSet<>();
	
	
	public Perspective() {}
	
	public Perspective(String name, String alias) {
		this.name = name;
		this.alias = alias;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public void addGenres(Genre genre) {
		this.genres.add(genre);
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	

}
