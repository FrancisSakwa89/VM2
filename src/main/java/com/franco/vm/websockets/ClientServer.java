package com.franco.vm.websockets;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import java.io.IOException;
import java.text.SimpleDateFormat;

@ClientEndpoint(encoders = MessageEncoder.class, decoders = MessageDecoder.class)
public class ClientServer {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    @OnMessage
    public void onMessage(Message message) {
        System.out.println(String.format("[%s:%s] %s",
                simpleDateFormat.format(message.getReceived()), message.getFrom(), message.getContent()));
    }

}
