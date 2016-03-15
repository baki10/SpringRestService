package ru.bakigoal.model;

/**
 * Created by ilmir on 15.03.16.
 */
public class Message {

    private final long id;
    private final String content;

    public Message(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
