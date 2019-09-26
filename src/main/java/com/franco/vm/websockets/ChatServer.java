package com.franco.vm.websockets;


import com.google.gson.Gson;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ServerEndpoint("/chat/{phone}")
public class ChatServer {
    Map<String, Session> sessionList = new HashMap<>();


    @OnOpen
    public void onOpen(Session session, @PathParam("phone") String phone) throws IOException {
        System.out.println("connection established from phone...."+ phone);
        sessionList.put(phone,session);


    }

    @OnMessage
    public void onMessage(Session session, String message, @PathParam("phone") String phone) throws IOException {
        Message msg = new Gson().fromJson(message, Message.class);
        if (sessionList.get(phone).equals(session)) {
            msg.setFrom(phone);
            this.logMessage(msg);
            deliverMessage(msg);
            System.out.println("messsage sent :"+ msg);
        }else {
            System.out.println("Wrong info on phone number provided....");
        }

    }

    public void logMessage(Message msg){


    }

    private void deliverMessage(Message msg) {

        Session recipientSession = sessionList.get(msg.getRecipient());
        try {
            recipientSession.getBasicRemote().sendObject(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        System.out.println("connection closed from "+ session.getId());
        sessionList.remove(session);

    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("Got an errror..."+ session.getId());


    }
}