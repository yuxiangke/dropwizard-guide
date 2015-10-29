package com.example.helloword.resources;

import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;
import com.example.helloword.api.Saying;
import com.google.common.base.Optional;

@Path("/hello-word")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWordResource {
	private final String template;
	private final String defaultName;
	private final AtomicLong counter;
	public HelloWordResource(String template, String defaultName) {
		super();
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
	}
	@GET
	@Timed
	public Saying Hello(@QueryParam("name") Optional<String> name){
		final String value=String.format(template, name.or(defaultName));
		return new Saying(counter.incrementAndGet(),value);
	}
	

}
