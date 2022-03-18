package swd20.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import swd20.Bookstore.domain.Category;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title, author, isb;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;
	
	
	public Book(String title, String author, String isb, double price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.isb = isb;
		this.price = price;
		this.category = category;
	}
	public Book() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getIsb() {
		return isb;
	}
	public void setIsb(String isb) {
		this.isb = isb;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		if (this.category != null)
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isb=" + isb + ", price=" + price + " category="
				+ this.getCategory() + "]";
		else 
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isb=" + isb + ", price=" + price + "]";
	}
	
}