package com.daiancosta.ms.notification.adapters.outbound.smtp;

import com.daiancosta.ms.notification.application.domain.Email;
import com.daiancosta.ms.notification.application.ports.SendEmailServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
class SmtpSendEmailServiceImpl implements SendEmailServicePort {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendEmailSmtp(Email email){
            final SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(email.getEmailFrom());
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            emailSender.send(message);
    }
}
