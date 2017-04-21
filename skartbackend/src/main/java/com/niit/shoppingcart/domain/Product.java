package com.niit.shoppingcart.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Component
@Table(name="Product")
public class Product {

	@Id
	private String id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	@JsonIgnore
	private Double price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="category_id")
	private String category_id;
	
	@Column(name="supplier_id")
	private String supplier_id;
	
	@Transient
	private MultipartFile Image;

	public MultipartFile getImage() {
		return Image;
	}

	public void setImage(MultipartFile Image) {
		this.Image = Image;
	}

	@ManyToOne
	@JoinColumn(name="category_id", updatable=false,insertable=false,nullable=false)
	@JsonIgnore
	private Category category;
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@ManyToOne
	@JoinColumn(name="supplier_id",updatable=false,insertable=false,nullable=false)
	@JsonIgnore
	private Supplier supplier;
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory_id() {
		return category_id;
	}

	public void setCategory_id(String category_id) {
		this.category_id = category_id;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}
	
	
}
