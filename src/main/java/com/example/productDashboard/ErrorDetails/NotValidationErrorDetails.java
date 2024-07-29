package com.example.productDashboard.ErrorDetails;

import org.springframework.http.HttpStatus;

import java.util.Map;

public class NotValidationErrorDetails {
    private HttpStatus status;
    private Map<String, String> messages;

    public NotValidationErrorDetails(){}

    public NotValidationErrorDetails(HttpStatus status, Map<String, String> messages) {
        this.status = status;
        this.messages = messages;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Map<String, String> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, String> messages) {
        this.messages = messages;
    }

}
