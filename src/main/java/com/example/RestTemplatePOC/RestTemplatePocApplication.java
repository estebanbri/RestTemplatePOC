package com.example.RestTemplatePOC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestTemplatePocApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestTemplatePocApplication.class, args);


		RestTemplate restTemplate = new RestTemplate();

		String url = "https://jsonplaceholder.typicode.com/todos";

		/**
		 *  getForEntity() : Retrieving JSON
		 */

		ResponseEntity<String> response = restTemplate.getForEntity(url + "/1", String.class);

		// getStatusCode()
		HttpStatus status = response.getStatusCode();
		System.out.println(status.toString());

		// getHeaders()
		HttpHeaders httpHeaders = response.getHeaders();
		System.out.println(httpHeaders.toString());

		// getBody() : Returns the body in type T format of the ResponseEntity<T>
		String json1 = response.getBody();
		System.out.println(json1);



		ResponseEntity<Todos> responseTodos = restTemplate.getForEntity(url + "/1", Todos.class);

		// getStatusCode()
		HttpStatus status2 = responseTodos.getStatusCode();
		System.out.println(status.toString());

		// getHeaders()
		HttpHeaders httpHeaders2 = responseTodos.getHeaders();
		System.out.println(httpHeaders.toString());

		// getBody() : Returns the body in type T format of the ResponseEntity<T>
		Todos todos2 = responseTodos.getBody();
		System.out.println(todos2);


		/**
		 *  getForObject() : Retrieving POJO Instead of JSON
		 */

		Todos todos = restTemplate.getForObject(url + "/1", Todos.class);

		System.out.println(todos);

		/**
		 *  exchange() : Execute the HTTP method to the given URI template, writing the given request entity to the request, and returns the response as ResponseEntity.
		 */
		ResponseEntity<String> res = restTemplate.exchange(url + "/1", HttpMethod.GET, null, String.class);
		String json = res.getBody();
		System.out.println(json);

		ResponseEntity<Todos> res2 = restTemplate.exchange(url + "/1", HttpMethod.GET, null, Todos.class);
		Todos todos3 = res2.getBody();
		System.out.println(todos3);
	}

}
