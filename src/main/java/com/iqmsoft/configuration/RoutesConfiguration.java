package com.iqmsoft.configuration;

import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import com.iqmsoft.model.Client;
import com.iqmsoft.repository.ClientRepository;

@Configuration
public class RoutesConfiguration {

	@Bean
	RouterFunction<?> routes(ClientRepository personRespository) {
		return nest(path("/client"),

				route(RequestPredicates.GET("/{id}"),
						request -> ok().body(personRespository.findById(request.pathVariable("id")), Client.class))

								.andRoute(method(HttpMethod.POST), request -> {
									personRespository.insert(request.bodyToMono(Client.class)).subscribe();
									return ok().build();
								}));
	}

}
