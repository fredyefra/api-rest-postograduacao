package br.com.rest.fab.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/ws")
public class ApplicationWS extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>();
		set.add(FabResources.class);
		return set;
	}

	@Override
	public Map<String, Object> getProperties() {

		Map<String, Object> properties = new HashMap<>();

		properties.put("jersey.config.server.provider.packages", "br.com.rest.fab");

		return properties;
	}
}