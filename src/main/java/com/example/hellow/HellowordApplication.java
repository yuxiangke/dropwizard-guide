package com.example.hellow;

import com.example.helloword.health.TemplateHealthCheck;
import com.example.helloword.resources.HelloWordResource;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HellowordApplication extends Application<HellowordConfiguration> {
	public static void main(String[] args) throws Exception {
		new HellowordApplication().run(args);

	}

	@Override
	public String getName() {
		return "Helloword";
	}

	@Override
	public void initialize(Bootstrap<HellowordConfiguration> bootstrap) {
	}

	@Override
	public void run(HellowordConfiguration configuration, Environment environment) throws Exception {
		final HelloWordResource resource = new HelloWordResource(configuration.getTemplate(),
				configuration.getDefaultName());
		final TemplateHealthCheck healthCheck = new TemplateHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
	}

}
