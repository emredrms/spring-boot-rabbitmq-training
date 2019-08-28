package com.course.rabbitmqproducer.utility;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RabbitmqQueue {

    // message count
    @JsonProperty
    private long messages;

    @JsonProperty
    private String name;

    public long getMessages() {
        return messages;
    }

    public String getName() {
        return name;
    }

    public boolean isDirty() {
        return messages > 0;
    }

    public void setMessages(long messages) {
        this.messages = messages;
    }

    public void setName(String name) {
        this.name = name;
    }

}
