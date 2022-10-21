package com.example.ZeroneMailingMicroservice.service;

import com.example.ZeroneMailingMicroservice.exception.EmailNotSentException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Component
public class ZeroneMailSenderService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;

    private boolean send(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailSender.send(mailMessage);
        return true;
    }

    public Boolean emailSend(String email, String title, String message) throws EmailNotSentException {
        try {
            if (email != null) {
                return send(email, title, message);
            }
        } catch (Exception e) {
            throw new EmailNotSentException(String.format("Ошибка отправки письма с темой: %s. Ошибка: %s", title, e.getMessage()));
        }
        return false;
    }
}
