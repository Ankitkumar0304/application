package com.backend.demo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "credentials")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	private ObjectId id;
	
	private String username;
	
	private String password;
}
