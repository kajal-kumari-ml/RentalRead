package com.rental.rent.dto;


public class AuthResponse {

    private String message = "Success";

    public String getMessage() {
        return message;
    }

    public AuthResponse() {
    }

    public AuthResponse(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
}
