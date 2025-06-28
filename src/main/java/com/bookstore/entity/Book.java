package com.bookstore.entity;

import java.util.Base64;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity(name = "book")
@Table(name = "book")
@NamedQueries({
	@NamedQuery(name = "book.findAll", query="SELECT b FROM book b"),
	@NamedQuery(name = "book.findByTitle", query = "SELECT b FROM book b WHERE b.title = :title"),
	@NamedQuery(name = "book.countAll", query = "SELECT COUNT(*) FROM book b"),
	@NamedQuery(name = "book.findByCategory", query = "SELECT b FROM book b JOIN category c ON b.category.category_id = c.category_id WHERE c.category_id= :categoryId"),
	@NamedQuery(name = "book.listNewBooks", query = "SELECT b FROM book b ORDER BY b.publish_date DESC"),
	@NamedQuery(name = "book.findWithQueryString", query = "SELECT b FROM book b WHERE b.title LIKE LOWER(CONCAT('%', :queryString, '%')) OR b.author LIKE LOWER(CONCAT('%', :queryString, '%'))"),
	@NamedQuery(name = "book.countByCategory", query = "SELECT COUNT(b) FROM book b JOIN category c ON b.category.category_id = c.category_id WHERE c.category_id = :categoryID")
})
public class Book {
	
	private int book_id;
	private String title;
	private String author;
	private String description;
	private String isbn;
	private byte[] image;
	private String base64Image;
	private float price;
	private Date publish_date;
	private Date last_update_time;
	private Category category;
	private Set<Review> review_ids = new HashSet<Review>(0);
	private Set<OrderDetail> order_ids = new HashSet<OrderDetail>(0);;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String author, String description, String isbn, byte[] image, float price,
			Date publish_date, Date last_update_time, Category category, Set<Review> review_ids,
			Set<OrderDetail> order_ids) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.image = image;
		this.price = price;
		this.publish_date = publish_date;
		this.last_update_time = last_update_time;
		this.category = category;
		this.review_ids = review_ids;
		this.order_ids = order_ids;
	}

	public Book(String title, String author, String description, String isbn, byte[] image, float price,
			Date publish_date, Date last_update_time, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		this.isbn = isbn;
		this.image = image;
		this.price = price;
		this.publish_date = publish_date;
		this.last_update_time = last_update_time;
		this.category = category;
	}

	@Id
	@Column(name = "book_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getBook_id() {
		return book_id;
	}
	
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	@Column(name = "title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "author")
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "isbn")
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Lob
	@Column(name = "image")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Column(name = "price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "publish_date")
	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_update_time")
	public Date getLast_update_time() {
		return last_update_time;
	}

	public void setLast_update_time(Date last_update_time) {
		this.last_update_time = last_update_time;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
	public Set<Review> getReview_ids() {
		TreeSet<Review> sortedReviews = new TreeSet<Review>(new Comparator<Review>() {
			@Override
			public int compare(Review o1, Review o2) {
				
				return o2.getReview_time().compareTo(o1.getReview_time());
			}
		});
		sortedReviews.addAll(review_ids);
		
		return sortedReviews;
	}

	public void setReview_ids(Set<Review> review_ids) {
		this.review_ids = review_ids;
	}
	
	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
	public Set<OrderDetail> getOrder_ids() {
		return order_ids;
	}

	public void setOrder_ids(Set<OrderDetail> order_ids) {
		this.order_ids = order_ids;
	}
	
	@Transient
	public String getBase64Image() {
		this.base64Image = Base64.getEncoder().encodeToString(this.image);
		return this.base64Image;
	}
	
	@Transient
	public void setBase64Image(String base64) {
		this.base64Image = base64;
	}

	@Override
	public int hashCode() {
		return Objects.hash(book_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return book_id == other.book_id;
	}
	
	
	@Transient
	public float getAverageRating() {
		float averageRating = 0.0f;	
		float sum = 0.0f;
		
		if(review_ids.isEmpty()) {
			return 0.0f;
		}
		
		for(Review review: review_ids) {
			sum += review.getRating();
		}
		
		averageRating = sum/review_ids.size();
		
		return averageRating;
	}
	
	@Transient
	public String getRatingString(float averageRating) {
		String result = "";
		int numberOfStars = (int) averageRating;
		
		for(int i = 1 ; i <=numberOfStars; i++) {
			result += "on,";
		}
		int next = numberOfStars + 1;
		if(averageRating > numberOfStars) {
			result += "half,";
			next++;
		}
		
		for(int i = next ; i <=5 ; i++) {
			result += "off,";
		}
		
		return result.substring(0, result.length()-1);
	}
	
	@Transient
	public String getRatingStars() {
		float averageRating = getAverageRating();
		return getRatingString(averageRating);
	}
	
}
