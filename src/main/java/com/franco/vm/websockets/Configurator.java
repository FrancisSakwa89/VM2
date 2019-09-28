package com.franco.vm.websockets;

import javax.websocket.HandshakeResponse;
import java.util.List;
import java.util.Map;

public class Configurator {

    public void beforeRequest(Map<String, List<String>> headers) {
        //affect the headers before request is sent
    }

    public void afterResponse(HandshakeResponse hr) {
        //process the handshake response
    }
}
