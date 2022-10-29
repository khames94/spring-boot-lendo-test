package com.lendo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonFormat.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lendo.model.Comment;
import com.lendo.model.Post;
import com.lendo.model.User;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class DataDetailsService {

	@Value("${api.host.baseurl}")
	private String baseurl;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ObjectMapper mapper;

	//Get all the users
	@SneakyThrows
	public List<User> getUsers() throws URISyntaxException {
		URI uri = new URI(baseurl + "/users");
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		List<User> usersList = mapper.readValue(result.getBody(), new TypeReference<List<User>>() {
		});
		log.info("==users:" + result);
		return usersList;
	}

	//Get all the posts
	@SneakyThrows
	public List<Post> getPosts() throws URISyntaxException {
		URI uri = new URI(baseurl + "/posts");
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		List<Post> PostList = mapper.readValue(result.getBody(), new TypeReference<List<Post>>() {
		});
		log.info("==Posts:" + result);
		return PostList;
	}

	//Get all the comments
	@SneakyThrows
	public List<Comment> getComments() throws URISyntaxException {
		URI uri = new URI(baseurl + "/comments");
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		List<Comment> PostList = mapper.readValue(result.getBody(), new TypeReference<List<Comment>>() {
		});
		log.info("==Comments:" + result);
		return PostList;
	}

	//Filter the posts for a user
	public List<Post> getPostsForUser(long userId) throws Exception {

		List<Post> response = new ArrayList<>();
		List<Post> postsList = getPosts();
		for (Post post : postsList) {
			if (post.getUser_id().equalsIgnoreCase(String.valueOf(userId)))
				response.add(post);
		}

		return response;

	}
 //Filter the comments of a post
	public List<Comment> findCommentsByPostId(long id) throws URISyntaxException {
		List<Comment> response = new ArrayList<>();
		List<Comment> commentsList = getComments();
		for (Comment comment : commentsList) {
			if (comment.getPost_id().equalsIgnoreCase(String.valueOf(id)))
				response.add(comment);
		}

		return response;
	}

}