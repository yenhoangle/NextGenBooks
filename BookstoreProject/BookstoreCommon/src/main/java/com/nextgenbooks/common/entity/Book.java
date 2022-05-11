package com.nextgenbooks.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true, length = 256, nullable = false)
	private String name; //title of book
	@Column(unique = true, length = 100, nullable = false)
	private String alias;
	@Column(length = 50, nullable = false, name = "author_first")
	private String authorFirst;
	@Column(length = 50, nullable = false, name = "author_last")
	private String authorLast;
	@Column(length = 512, nullable = false)
	private String quote;
	@Column(length = 512, nullable = false)
	private String description;
	
	@Column(name = "in_stock")
	private boolean inStock;
	@Column(nullable = false)
	private float price;
	@Column(nullable = false, name = "page_count")
	private int pageCount;
	@Column(length = 100)
	private String image; //image name ex: sun.png
	
	@ManyToOne
	@JoinColumn(name = "genres_id")
	private Genre genre;
	@ManyToOne
	@JoinColumn(name = "perspectives_id")
	private Perspective perspective;
	
	private boolean enabled;
	
	//constructor
	public Book() {
		enabled = true;
		inStock = true;
	}
	
	//getters and setters
	public String getAuthorFullName() {
		return authorFirst + " " + authorLast;
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
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getAuthorFirst() {
		return authorFirst;
	}
	public void setAuthorFirst(String authorFirst) {
		this.authorFirst = authorFirst;
	}
	public String getAuthorLast() {
		return authorLast;
	}
	public void setAuthorLast(String authorLast) {
		this.authorLast = authorLast;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isInStock() {
		return inStock;
	}
	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public Perspective getPerspective() {
		return perspective;
	}
	public void setPerspective(Perspective perspective) {
		this.perspective = perspective;
	}

	@Override
	public String toString() {
		return name;
	}
	
}
