package com.messages.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.messages.WhatsappIntegrationApplication;
import com.messages.Services.WhatsappService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webhook")
public class WhatsappWebhookController {

//    private final WhatsappIntegrationApplication whatsappIntegrationApplication;
	
	 @Value("${whatsapp.verify.token}")
	    private String verifyToken;

	 private final WhatsappService whatsAppService;

	    public WhatsappWebhookController(WhatsappService whatsAppService) {
	        this.whatsAppService = whatsAppService;
	    }

	    // Meta Webhook verification
	    @GetMapping 
	    public ResponseEntity<String> verifyWebhook(
	            @RequestParam("hub.mode") String mode,
	            @RequestParam("hub.challenge") String challenge,
	            @RequestParam("hub.verify_token") String token) {

	        if ("subscribe".equals(mode) && verifyToken.equals(token)) {
	            return ResponseEntity.ok(challenge);
	        } else {
	            return ResponseEntity.status(403).body("Verification failed");
	        }
	    }

	    // Handle incoming message
	    @PostMapping
	    public ResponseEntity<Void> receiveMessage(@RequestBody JsonNode payload) {
	        whatsAppService.processIncomingMessage(payload);
	        return ResponseEntity.ok().build();
	    }
	

}
