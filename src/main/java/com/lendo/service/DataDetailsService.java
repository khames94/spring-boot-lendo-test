package com.lendo.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

	@SneakyThrows
	public List<User>  getUsers() throws URISyntaxException {
		URI uri = new URI(baseurl + "/users");
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		List<User> usersList = mapper.readValue(result.getBody(), new TypeReference<List<User>>(){});
		log.info("==users:" + result);
		return usersList;
	}

	@SneakyThrows
	public List<Post> getPosts() throws URISyntaxException {
		URI uri = new URI(baseurl + "/posts");
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		List<Post> PostList = mapper.readValue(result.getBody(), new TypeReference<List<Post>>(){});
		log.info("==Posts:" + result);
		return PostList;
	}
	
	@SneakyThrows
	public List<Comment> getComments() throws URISyntaxException {
		URI uri = new URI(baseurl + "/comments");
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		List<Comment> PostList = mapper.readValue(result.getBody(), new TypeReference<List<Comment>>(){});
		log.info("==Comments:" + result);
		return PostList;
	}

	public User findUserById(Long id) throws Exception {
		
		List<User>  users=getUsers();
		
		Optional<User> matchingObject = users.stream().
			    filter(user -> user.getId().equals(id)).
			    findFirst();
		return matchingObject.get();
		
		
	}

}