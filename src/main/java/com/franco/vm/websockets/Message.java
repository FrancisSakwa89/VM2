package com.franco.vm.websockets;

public class Message {
   private String recipient;
   private String content;
   private String from;
   private boolean status;

    public Message(String recipient, String content, String from, boolean status) {
        this.recipient = recipient;
        this.content = content;
        this.from = from;
        this.status = status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Message() {
    }

    public boolean isStatus() {
        return status;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
