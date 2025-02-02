package com.AICodeReviewTool.CRT.repository;

import com.AICodeReviewTool.CRT.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {
    // Custom query can be added if needed
}
