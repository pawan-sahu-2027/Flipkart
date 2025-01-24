package com.scaler.flipkart.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDto {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
