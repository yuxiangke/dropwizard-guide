package com.example.helloword.health;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck{
	private final String template;

	public TemplateHealthCheck(String template) {
		super();
		this.template = template;
	}

	@Override
	protected Result check() throws Exception {
		// TODO Auto-generated method stub
		final String saying=String.format(template, "TEST");
		if(!saying.contains("TEST")){
			return Result.unhealthy("template doesn't include a name");
		}
		return Result.healthy();
	}
	

}
