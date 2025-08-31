package com.login.interfaces;

public interface MailSenderPort {

    void sendResentLink(String mail, String token) throws Exception;

}
