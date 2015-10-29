package com.example.helloword.api;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Saying {
	private long id;
	
	@Length(max=3)
	private String context;
	
	public Saying(long id, String context) {
		super();
		this.id = id;
		this.context = context;
	}
	public Saying() {
		super();
	}
    @JsonProperty
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	@JsonProperty
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	

}
