package com.AICodeReviewTool.CRT.model;

import java.util.ArrayList;
import java.util.List;

public class CodeReviewResponse {
    private List<CodeReviewFeedback> feedbackList = new ArrayList<>();
    private String message;

    public CodeReviewResponse() {}

    public CodeReviewResponse(String message) {
        this.message = message;
    }

    public void addFeedback(String category, String message) {
        feedbackList.add(new CodeReviewFeedback(category, message));
    }

    public List<CodeReviewFeedback> getFeedbackList() {
        return feedbackList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "CodeReviewResponse{" +
                "feedbackList=" + feedbackList +
                ", message='" + message + '\'' +
                '}';
    }

    public static class CodeReviewFeedback {
        private String category;
        private String message;

        public CodeReviewFeedback(String category, String message) {
            this.category = category;
            this.message = message;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return "CodeReviewFeedback{" +
                    "category='" + category + '\'' +
                    ", message='" + message + '\'' +
                    '}';
        }
    }
}
