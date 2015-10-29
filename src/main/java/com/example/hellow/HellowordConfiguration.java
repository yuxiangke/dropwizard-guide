package com.example.hellow;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;

public class HellowordConfiguration extends Configuration {
	@NotEmpty
	private String template;
	@NotEmpty
	private String defaultName = "Stranger";

	@Valid
	private TestConfiguration test;

	@JsonProperty
	public String getTemplate() {
		return template;
	}

	@JsonProperty
	public void setTemplate(String template) {
		this.template = template;
	}

	@JsonProperty
	public String getDefaultName() {
		return defaultName;
	}

	@JsonProperty
	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

	@JsonProperty
	public TestConfiguration getTest() {
		return test;
	}

	public void setTest(TestConfiguration test) {
		this.test = test;
	}

}
