package com.daiancosta.ms.notification.application.ports;

import com.daiancosta.ms.notification.application.domain.Email;

public interface SendEmailServicePort {

    void sendEmailSmtp(Email email);
}
