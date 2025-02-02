package com.AICodeReviewTool.CRT.controller;

import com.AICodeReviewTool.CRT.model.CodeReviewRequest;
import com.AICodeReviewTool.CRT.model.CodeReviewResponse;
import com.AICodeReviewTool.CRT.service.CodeAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class CodeReviewController {

    private final CodeAnalysisService codeAnalysisService;

    @Autowired
    public CodeReviewController(CodeAnalysisService codeAnalysisService) {
        this.codeAnalysisService = codeAnalysisService;
    }

    @PostMapping("/analyze")
    public ResponseEntity<CodeReviewResponse> analyzeCode(@RequestBody @Valid CodeReviewRequest request) {
        try {
            CodeReviewResponse response = codeAnalysisService.analyzeCode(request.getCode());
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new CodeReviewResponse("Invalid input: " + e.getMessage()));
        } catch (IOException e) {
            return ResponseEntity.status(500).body(new CodeReviewResponse("Server error: " + e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new CodeReviewResponse("Unexpected error: " + e.getMessage()));
        }
    }
}
