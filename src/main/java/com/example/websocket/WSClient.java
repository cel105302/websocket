package com.example.websocket;

import javax.websocket.*;

@ClientEndpoint()
public class WSClient {
    @OnOpen
    public void onOpen(Session session) {}
    @OnMessage
    public void onMessage(String message) {
        System.out.println("Client onMessage: " + message);
    }
    @OnClose
    public void onClose() {}
}

