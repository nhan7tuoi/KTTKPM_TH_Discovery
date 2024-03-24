package com.fit.se.Gateway.valid;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class RouterValid {
public static final List<String> endpointsNoAuth = List.of("auth/register", "auth/login");
	
	public Predicate<ServerHttpRequest> isSecured = request  -> endpointsNoAuth.stream()
			.noneMatch(uri -> request.getURI().getPath().contains(uri));
}
