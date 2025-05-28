package com.messages;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class WhatsappIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(WhatsappIntegrationApplication.class, args);
//		private static final Logger logger = LoggerFactory.getLogger(WhatsappIntegrationApplication.class);
//		try {
//			HttpRequest request = HttpRequest.newBuilder()
//					.uri(new URI("https://graph.facebook.com/v22.0/<PHONENUMBER_ID>/messages"))
//					.header("Authorization",
//							"Bearer <BEARER_TOKEN>")
//					.header("Content-Type", "application/json")
////					.POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", \"to\": \"<NUMBER SENT>\", \"type\": \"template\", \"template\": { \"name\": \"hello_world\", \"language\": { \"code\": \"en_US\" } } }"))
////
////					.POST(HttpRequest.BodyPublishers.ofString(
////							"{ \"messaging_product\": \"whatsapp\", \"recipient_type\": \"individual\", \"to\": \"<NUMBER SENT>\", \"type\": \"text\", \"text\": { \"preview_url\": false, \"body\": \"Hello , Welcome to the meta developer testing messages under Api messages section\" } }"))
//
//					.POST(HttpRequest.BodyPublishers.ofString("{ \"messaging_product\": \"whatsapp\", "
//							+ "\"to\": \"<NUMBER SENT>\", " + "\"type\": \"template\", " + "\"template\": { "
//							+ "\"name\": \"feedback_survey_2\", " + "\"language\": { \"code\": \"en_US\" }, "
//							+ "\"components\": [" + "{\"type\": \"body\", \"parameters\": ["
//							+ "{\"type\": \"text\", \"text\": \"Anthony Gon Salvis\"}, "
//							+ "{\"type\": \"text\", \"text\": \"73 annpurna road\"}" + "]}]" + "} }"))
//					
//					
//					.build();
//
//			HttpClient http = HttpClient.newHttpClient();
//			HttpResponse<String> response = http.send(request, BodyHandlers.ofString());
//			System.out.println(response.body());
//		} catch (URISyntaxException | InterruptedException | IOException e) {
//			System.out.println(e.getMessage());
//		}
		System.out.println("running");

	}

}
