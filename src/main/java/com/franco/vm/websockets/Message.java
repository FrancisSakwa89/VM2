package com.franco.vm.websockets;

import java.util.Date;

public class Message {
   private String recipient;
   private String content;
   private String from;
   private boolean status;
    private Date received;

    public Message(String recipient, String content, String from, boolean status, Date received) {
        this.recipient = recipient;
        this.content = content;
        this.from = from;
        this.status = status;
        this.received = received;
    }

    public Message() {
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }

    @Override
    public String toString() {
        return "Message{" +
                "recipient='" + recipient + '\'' +
                ", content='" + content + '\'' +
                ", from='" + from + '\'' +
                ", status=" + status +
                ", received=" + received +
                '}';
    }
}
