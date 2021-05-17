package com.moss.project.eneasy.core.email.service;


import com.moss.project.eneasy.core.email.context.*;
import com.sun.xml.internal.messaging.saaj.packaging.mime.*;

public interface EmailService {

    void sendMail(final AbstractEmailContext email) throws MessagingException;
}
