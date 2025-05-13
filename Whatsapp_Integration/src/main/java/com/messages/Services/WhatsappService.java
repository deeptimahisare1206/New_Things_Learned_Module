package com.messages.Services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WhatsappService {

    @Value("${whatsapp.access.token}")
    private String accessToken;

    @Value("${whatsapp.phone.number.id}")
    private String phoneNumberId;

    @Value("${whatsapp.template.name}")
    private String templateName;  // e.g., greeting_template

    private final WebClient webClient = WebClient.create("https://graph.facebook.com/v22.0/");
    private final ObjectMapper mapper = new ObjectMapper();

//    public void processIncomingMessage(JsonNode payload) {
//        try {
//            JsonNode messages = payload.path("entry").get(0)
//                    .path("changes").get(0)
//                    .path("value").path("messages");
//
//            if (messages.isArray() && messages.size() > 0) {
//                JsonNode message = messages.get(0);
//                String from = message.path("from").asText();
//                String messageType = message.path("type").asText();
//
//                // Handle text messages
//                if ("text".equals(messageType)) {
//                    String text = message.path("text").path("body").asText().trim().toLowerCase();
//
//                    if ("hi".equals(text)) {
//                        sendTemplateMessage(from);
//                    } else {
////                        sendTextMessage(from, "Thanks for your message. We'll get back to you soon.");
//                    	sendListMessage(from);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    ================================================================================
    
    
    private void sendListMessage(String to) {
        String url = phoneNumberId + "/messages";

        ObjectNode messageBody = mapper.createObjectNode();
        messageBody.put("messaging_product", "whatsapp");
        messageBody.put("to", to);
        messageBody.put("type", "interactive");

        ObjectNode interactive = messageBody.putObject("interactive");
        interactive.put("type", "list");

        // Header
        ObjectNode header = interactive.putObject("header");
        header.put("type", "text");
        header.put("text", "Welcome!");

        // Body
        ObjectNode body = interactive.putObject("body");
        body.put("text", " Are you already registered in our app?? \n Please choose an option from the menu:  ");

        // Footer
        ObjectNode footer = interactive.putObject("footer");
        footer.put("text", "Powered by Deepmahi");

        // Action
        ObjectNode action = interactive.putObject("action");
        action.put("button", "Show Options");

        var sections = action.putArray("sections");

        ObjectNode section1 = mapper.createObjectNode();
        section1.put("title", "Select");

        var rows1 = section1.putArray("rows");
        rows1.add(mapper.createObjectNode()
                .put("id", "login")
                .put("title", "🔑 Log In")
                .put("description", "If already a user"));
        rows1.add(mapper.createObjectNode()
                .put("id", "register")
                .put("title", "🧾 Registration")
                .put("description", "First time using"));

//        ObjectNode section2 = mapper.createObjectNode();
//        section2.put("title", "Support");
//
//        var rows2 = section2.putArray("rows");
//        rows2.add(mapper.createObjectNode()
//                .put("id", "talk_agent")
//                .put("title", "👤 Talk to Agent")
//                .put("description", "Live support assistance"));
//        rows2.add(mapper.createObjectNode()
//                .put("id", "faq")
//                .put("title", "📄 FAQs")
//                .put("description", "Common questions answered"));

        sections.add(section1);
//        sections.add(section2);

        webClient.post()
                .uri(url)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(messageBody)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> System.out.println("List message sent: " + response));
    }

    
//  ========================================================================================================
  // Sending response to the list message
    
    
    public void processIncomingMessage(JsonNode payload) {
        try {
            JsonNode messages = payload.path("entry").get(0)
                    .path("changes").get(0)
                    .path("value").path("messages");

            if (messages.isArray() && messages.size() > 0) {
                JsonNode message = messages.get(0);
                String from = message.path("from").asText();
                String messageType = message.path("type").asText();

                switch (messageType) {
                    case "text":
                        String text = message.path("text").path("body").asText().trim().toLowerCase();
                        if ("hi".equals(text)) {
                            sendListMessage(from); // Send list on "hi"
                        } else {
                            sendTextMessage(from, "Thanks for your message.");
                        }
                        break;

                    case "interactive":
                        String interactiveType = message.path("interactive").path("type").asText();
                        if ("list_reply".equals(interactiveType)) {
                            String selectedId = message.path("interactive").path("list_reply").path("id").asText();

                            // Respond based on selected option
                            switch (selectedId) {
                                case "login":
                                    sendTextMessage(from, "You can login your account at: https://deepti-mahisare.netlify.app");
                                    break;
                                case "register":
                                    sendTextMessage(from, "Your can register yourself at: https://yogesh-rajput.netlify.app");
                                    break;
//                                case "talk_agent":
//                                    sendTextMessage(from, "Connecting you to a live agent...");
//                                    break;
//                                case "faq":
//                                    sendTextMessage(from, "View FAQs here: https://example.com/faqs");
//                                    break;
                                default:
                                    sendTextMessage(from, "Sorry, I didn't understand that option.");
                            }
                        }
                        break;

                    default:
                        sendTextMessage(from, "Unsupported message type.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    
//    ========================================================================================================
    
    
    
    // For regular plain text replies
    private void sendTextMessage(String to, String messageText) {
        String url = phoneNumberId + "/messages";

        ObjectNode messageBody = mapper.createObjectNode();
        messageBody.put("messaging_product", "whatsapp");
        messageBody.put("to", to);
        messageBody.put("type", "text");

        ObjectNode textNode = messageBody.putObject("text");
        textNode.put("body", messageText);

        webClient.post()
                .uri(url)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(messageBody)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> System.out.println("Text message sent: " + response));
    }
    
    
    
//  ========================================================================================================
  

    // For sending a template message when user sends "hi"
    private void sendTemplateMessage(String to) {
        String url = phoneNumberId + "/messages";

        ObjectNode messageBody = mapper.createObjectNode();
        messageBody.put("messaging_product", "whatsapp");
        messageBody.put("to", to);
        messageBody.put("type", "template");

        ObjectNode templateNode = messageBody.putObject("template");
        templateNode.put("name", templateName);

        ObjectNode languageNode = templateNode.putObject("language");
        languageNode.put("code", "en");

        webClient.post()
                .uri(url)
                .header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(messageBody)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> System.out.println("Template message sent: " + response));
    }
    
    
//  ========================================================================================================
  
}
