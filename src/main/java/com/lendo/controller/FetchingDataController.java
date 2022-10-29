package com.lendo.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.lendo.model.Comment;
import com.lendo.model.Post;
import com.lendo.service.DataDetailsService;

@RestController
@CrossOrigin()
public class FetchingDataController {

	@Autowired
	private DataDetailsService service;
	
	@GetMapping({ "/users" })
	public Object getUsers() throws URISyntaxException {
		
		return new ResponseEntity<>(service.getUsers(), HttpStatus.OK);
	}
		
	@GetMapping({ "/posts" })
	public Object getPosts() throws URISyntaxException {
		
		return new ResponseEntity<>(service.getPosts(), HttpStatus.OK);
	}
	
	@GetMapping({ "/comments" })
	public Object getComments() throws URISyntaxException {
		
		return new ResponseEntity<>(service.getComments(), HttpStatus.OK);
	}
	
	 @GetMapping("/users/{id}")
	 List<Post> getPostsForUser( @PathVariable("id") long id) throws Exception {
	    
	    return service.getPostsForUser(id);
	  }

	 @GetMapping("/comment/{id}")
	 List<Comment> getPostComments( @PathVariable("id") long id) throws Exception {
	    
	    return service.findCommentsByPostId(id);
	  }


}
