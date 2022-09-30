package com.abhi.blogsapp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "blogs")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;

	@Column(name = "blog_id")
	private String blogId;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@CreationTimestamp
	@Column(name = "created_date")
	private Date createdDate;

	@UpdateTimestamp
	@Column(name = "updated_date")
	private Date updatedDate;

	@Column(name = "status")
	private boolean status;

}
