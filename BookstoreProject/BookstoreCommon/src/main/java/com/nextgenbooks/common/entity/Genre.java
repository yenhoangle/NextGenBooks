package com.nextgenbooks.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="genres")
public class Genre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 100, nullable = false, unique = true)
	private String name;
	@Column(length = 100, nullable = false, unique = true)
	private String alias;
	private boolean enabled;
	
	@OneToOne
	@JoinColumn(name= "parent_id")
	private Genre parent;
	
	public Genre() {
	}
	
	public Genre(Integer id) {
		this.id = id;
	}
	public Genre(String name) {
		this.name = name;
		this.alias = name;
		this.enabled = true;
	}
	
	public Genre(String name, String alias) {
		this.name = name;
		this.alias = alias;
		this.enabled = true;
	}
	@OneToMany(mappedBy = "parent")
	private Set<Genre> children = new HashSet<>();
	
	//getters and setters
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
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Genre getParent() {
		return parent;
	}
	public void setParent(Genre parent) {
		this.parent = parent;
	}
	public Set<Genre> getChildren() {
		return children;
	}
	public void setChildren(Set<Genre> children) {
		this.children = children;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
