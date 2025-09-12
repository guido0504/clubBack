package com.login.service;

import com.login.model.ApiResponse;
import jakarta.mail.MessagingException;

public interface EmailService {

    ApiResponse<String>  sendPasswordResetEmail(String mail, String token) throws MessagingException;
}
