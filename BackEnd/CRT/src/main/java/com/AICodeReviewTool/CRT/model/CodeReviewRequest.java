package com.AICodeReviewTool.CRT.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;

@Getter
@Setter
@ToString
public class CodeReviewRequest {
    @NotNull
    private String code;

    public CodeReviewRequest() { }
}
