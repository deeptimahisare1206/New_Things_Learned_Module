package com.messages;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WhatsappMessagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatsappMessagingApplication.class, args);

//================================================================================

		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(new URI("https://graph.facebook.com/v22.0/<code>/messages"))
					.header("Authorization", "Bearer <Token>")
					.header("Content-Type", "aplication/json")
					.POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"to\":<number>\"\", \"type\": \"template\", \"template\": { \"name\": \"hello_world\", \"language\": { \"code\": \"en_US\" } } }"))
					.build();
			
			HttpClient http = HttpClient.newHttpClient();
			HttpResponse<String> response = http.send(request, BodyHandlers.ofString());
			System.out.println(response.body());
			
		} catch (URISyntaxException | IOException | InterruptedException  e) {
			System.out.println("Error: " + e.getMessage());
		}

//================================================================================

	}

}
