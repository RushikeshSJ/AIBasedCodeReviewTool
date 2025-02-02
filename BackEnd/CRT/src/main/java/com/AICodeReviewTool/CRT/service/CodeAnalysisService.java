package com.AICodeReviewTool.CRT.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.AICodeReviewTool.CRT.model.CodeReviewResponse;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@Service
public class CodeAnalysisService {
    private static final Logger logger = LoggerFactory.getLogger(CodeAnalysisService.class);
    private final OkHttpClient client;

    @Value("${openai.api.key}")
    private String apiKey;

    public CodeAnalysisService(OkHttpClient client) {
        this.client = client;
    }

    public CodeReviewResponse analyzeCode(String code) throws IOException {
        if (code == null || code.trim().isEmpty()) {
            throw new IllegalArgumentException("Code cannot be empty");
        }

        logger.info("Starting code analysis...");
        String url = "https://api.openai.com/v1/chat/completions";

        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("model", "gpt-3.5-turbo");

        JsonArray messages = new JsonArray();
        JsonObject message = new JsonObject();
        message.addProperty("role", "user");
        message.addProperty("content", "Analyze the following code and provide feedback: " + code);
        messages.add(message);

        jsonBody.add("messages", messages);

        RequestBody body = RequestBody.create(new Gson().toJson(jsonBody), MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Content-Type", "application/json")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("OpenAI API error: " + response.code() + " - " + response.message());
            }

            String responseBody = response.body().string();
            logger.info("OpenAI API Response: " + responseBody);

            JsonObject jsonResponse = new Gson().fromJson(responseBody, JsonObject.class);

            JsonArray choices = jsonResponse.getAsJsonArray("choices");
            if (choices == null || choices.size() == 0) {
                throw new IOException("Invalid OpenAI response: No choices found.");
            }

            JsonObject firstChoice = choices.get(0).getAsJsonObject();
            JsonObject messageObj = firstChoice.getAsJsonObject("message");
            if (messageObj == null || !messageObj.has("content")) {
                throw new IOException("Invalid OpenAI response: Missing 'content' field.");
            }

            String feedback = messageObj.get("content").getAsString();

            CodeReviewResponse reviewResponse = new CodeReviewResponse();
            reviewResponse.addFeedback("Analysis", feedback);
            return reviewResponse;
        } catch (IOException e) {
            logger.error("Error in OpenAI API communication: " + e.getMessage(), e);
            throw new IOException("Error communicating with OpenAI API: " + e.getMessage(), e);
        }
    }
}
