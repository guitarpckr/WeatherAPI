package com.tts.Weather.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Zipcode {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "zipcode_id")
	private Long id;
	
	private String zipcode;
	
	@CreationTimestamp
	private Date createdAt;
	
	public Zipcode() {}

	public Zipcode(String zipcode, Date createdAt) {
		this.zipcode = zipcode;
		this.createdAt = createdAt;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	public Long getId() {
		return id;
	}
}
