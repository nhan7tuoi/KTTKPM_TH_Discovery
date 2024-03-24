package com.fit.se.Gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.fit.se.Gateway.util.JWTUtil;
import com.fit.se.Gateway.valid.RouterValid;



@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {
	public static class Config {

	}

	@Autowired
	private RouterValid routerValid;
	@Autowired
	private JWTUtil jwtUtil;
	
	public AuthFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		// TODO Auto-generated method stub
		return ((exchange, chain) -> {
			if (routerValid.isSecured.test(exchange.getRequest())) {
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("not found authorization header");
				}
				String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if (authHeader != null && authHeader.startsWith("Bearer ")) {
					authHeader = authHeader.substring(7);
				}
				try {
					jwtUtil.validateToken(authHeader);
				} catch (Exception e) {
					// TODO: handle exception
					throw new RuntimeException("invalid access");
				}
			}
			return chain.filter(exchange);
		});
	}
}
