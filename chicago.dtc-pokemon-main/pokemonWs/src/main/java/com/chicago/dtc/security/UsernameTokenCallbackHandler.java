package com.chicago.dtc.security;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.beans.factory.annotation.Value;

public class UsernameTokenCallbackHandler implements CallbackHandler {

  @Value("${username}")
  private String username;

  @Value("${password}")
  private String password;

  public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
    WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
    if (pc.getIdentifier().equals("admin")) {
      pc.setPassword("pwd123");
    }
  }

}