package com.example.websocket;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;

public class TestClient {
    private static String uri = "ws://localhost:8080/websocket/1";
    private static Session session;
    private void start() {
        WebSocketContainer container = null;
        try {
            container = ContainerProvider.getWebSocketContainer();
        } catch (Exception ex) {
            System.out.println("error" + ex);
        }
        try {
            URI r = URI.create(uri);
            session = container.connectToServer(WSClient.class, r);
        } catch (DeploymentException | IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void mainTest1() throws InterruptedException {
        TestClient client = new TestClient();
        client.start();

        int count = 0;
        try {
            do {
                count++;
                Thread.sleep(3000);
                    client.session.getBasicRemote().sendText("javaclient1: "+count);
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void mainTest2() throws InterruptedException {
        TestClient client = new TestClient();
        client.start();

        int i = 0;
        try {
            do {
                i++;
                    Thread.sleep(3000);
                    client.session.getBasicRemote().sendText("javaclient2：" + i);
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
