package com.abhi.blogsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.abhi.blogsapp.entity.Blog;

@Repository
@Transactional
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
