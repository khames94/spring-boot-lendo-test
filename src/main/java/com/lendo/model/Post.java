package com.lendo.model;

import lombok.Data;

@Data
public class Post {

	private long id;
	private String title;
	private String body;
	private String gender;
	private String user_id;

}
