package com.franco.vm.websockets;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;
import java.util.Date;

public class MessageDecoder implements Decoder.Text<Message> {
    @Override
    public Message decode(String s) throws DecodeException {
        Message msg = new Message();
        JsonObject obj = Json.createReader(new StringReader(s))
                .readObject();
        msg.setContent(obj.getString("content"));
        msg.setFrom(obj.getString("from"));
        msg.setRecipient(obj.getString("recipient"));
        msg.setReceived(new Date());
        msg.setStatus(obj.getBoolean("true"));
        return msg;
    }


    @Override
    public boolean willDecode(String s) {
        return false;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
