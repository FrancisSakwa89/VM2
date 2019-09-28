package com.franco.vm.websockets;

import com.google.gson.Gson;

import javax.json.Json;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class MessageEncoder implements Encoder.Text<Message> {

    @Override
    public String encode(Message message) throws EncodeException {
        Gson gson = new Gson();
        gson.newBuilder();
        return Json.createObjectBuilder()
                .add("content", message.getContent())
                .add("from", message.getFrom())
//                .add("recipient", message.getRecipient())
                .add("status", message.isStatus())
                .add("received", message.getReceived().toString()).build()
                .toString();
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
