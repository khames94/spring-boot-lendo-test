package com.lendo.model;

import lombok.Data;

@Data
public class Comment {

	private long id;
	private String post_id;
	private String name;
	private String email;
	private String body;


}
