package com.abhi.blogsapp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.blogsapp.entity.Blog;
import com.abhi.blogsapp.service.BlogService;

@RestController
@RequestMapping("api/v1")
public class BlogController {
	private static Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

	@Autowired
	private BlogService blogService;

	@PostMapping("/blog")
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
		LOGGER.debug("createBlog()  method is called in controller");
		return new ResponseEntity<Blog>(blogService.saveBlog(blog), HttpStatus.CREATED);
	}

	@GetMapping("/blog/{id}")
	public ResponseEntity<Blog> getBlogById(@PathVariable Long id) {
		LOGGER.debug("getBlogById()  method is called in controller");
		return new ResponseEntity<Blog>(blogService.findBlogById(id).get(), HttpStatus.OK);
	}

	@GetMapping("/blogs")
	public ResponseEntity<List<Blog>> getAllBlogs() {
		LOGGER.debug("getAllBlogs()  method is called in controller");
		return new ResponseEntity<List<Blog>>(blogService.findAllBlogs(), HttpStatus.OK);
	}

	@PutMapping("blog/{id}")
	public ResponseEntity<Blog> updateBlog(@PathVariable Long id, @RequestBody Blog blog) {
		LOGGER.debug("updateBlog()  method is called in controller");
		return new ResponseEntity<Blog>(blogService.updateBlog(id, blog), HttpStatus.OK);
	}

	@DeleteMapping("blog/{id}")
	public ResponseEntity<?> deleteBlog(@PathVariable Long id) {
		LOGGER.debug("deleteBlog()  method is called in controller");
		Map<String, Long> map = new HashMap<>();
		map.put("deleted successfully", id);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}

}
