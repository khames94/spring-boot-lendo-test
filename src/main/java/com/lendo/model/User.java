package com.lendo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class User {

	private Long id;
	private String name;
	private String email;
	private String gender;
	private String status;
	

}
