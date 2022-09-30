package com.abhi.blogsapp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.blogsapp.entity.Blog;
import com.abhi.blogsapp.repository.BlogRepository;

@Service
public class BlogServiceImpl implements BlogService {

	private static Logger LOGGER = LoggerFactory.getLogger(BlogServiceImpl.class);

	@Autowired
	private BlogRepository blogRepository;

	@Override
	public Blog saveBlog(Blog blog) {
		blog.setBlogId(UUID.randomUUID().toString());
		LOGGER.debug("saveBlog()  method is called in service");
		return blogRepository.save(blog);
	}

	@Override
	public Optional<Blog> findBlogById(Long id) {
		LOGGER.debug("findBlogById()  method is called in service");
		return blogRepository.findById(id);
	}

	@Override
	public List<Blog> findAllBlogs() {
		LOGGER.debug("findAllBlogs()  method is called in service");
		return blogRepository.findAll();
	}

	@Override
	public Blog updateBlog(Long id, Blog blog) {
		LOGGER.debug("updateBlog()  method is called in service");
		Optional<Blog> optionalBlog = blogRepository.findById(id);
		Blog updateBlog = optionalBlog.get();
		updateBlog.setTitle(blog.getTitle());
		updateBlog.setDescription(blog.getDescription());
		return blogRepository.save(updateBlog);
	}

	@Override
	public void deleteBlogById(Long id) {
		LOGGER.debug("deleteBlogById()  method is called in service");
		blogRepository.deleteById(id);
	}

}
