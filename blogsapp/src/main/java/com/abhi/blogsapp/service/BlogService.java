package com.abhi.blogsapp.service;

import java.util.List;
import java.util.Optional;

import com.abhi.blogsapp.entity.Blog;

public interface BlogService {

	public Blog saveBlog(Blog blog);

	public Optional<Blog> findBlogById(Long id);

	public List<Blog> findAllBlogs();

	public Blog updateBlog(Long id, Blog blog);

	public void deleteBlogById(Long id);
}
