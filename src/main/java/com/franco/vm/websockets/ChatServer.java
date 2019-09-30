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
import java.util.logging.Level;
import java.util.logging.Logger;


@ServerEndpoint(value = "/chat/{phone}" , encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ChatServer {
    Map<String, Session> sessionList = new HashMap<>();


    @OnOpen
    public void onOpen(Session session, @PathParam("phone") String phone) throws IOException {
        try {
            System.out.println("connection established from phone...." + phone + " (and your session id is): " + session.getId());
            sessionList.put(phone, session);
            session.getUserProperties().put(phone, session);
        }catch (Exception e){
            System.out.println("got an error in connection to server");
            e.printStackTrace();
        }

    }

    @OnMessage
    public void onMessage(Session session, String message, @PathParam("phone") String phone) throws IOException {
//        Message msg = new Gson().fromJson(message, Message.class);
//        if (sessionList.get(phone).equals(session)) {
//            msg.setFrom(phone);
//            this.logMessage(msg);
//            deliverMessage(msg);
//            System.out.println("messsage sent :"+ msg);
//        }else {
//            System.out.println("Wrong info on phone number provided....");
//        }



        try {
            if (sessionList.get(phone).equals(session)) {
                if (session.isOpen()
                        && session.equals(session.getUserProperties().get(phone))) {
                    session.getBasicRemote().sendObject(message);
                    System.out.println("messsage sent :"+ message);
                }

                else {
                    System.out.println("Wrong info on phone number provided....");
                }
            }
        } catch (Exception e) {
            System.out.println("you got an onMessage error..."); e.printStackTrace();
        }
    }






    public void logMessage(Message msg){
        msg.toString();


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
        System.out.println("session list: "+sessionList.toString());

    }

    @OnError
    public void onError(Session session, Throwable t) {
        System.out.println("Got an error posting message..."+session.getUserProperties().get(sessionList));
        t.printStackTrace();


    }
}