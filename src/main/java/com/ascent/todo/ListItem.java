package com.ascent.todo;

public class ListItem {

    private String name = "item";
    private int id;
    private String body;

    public ListItem() {
    }

    public ListItem(int id) {
        this.id = id;
    }

    public ListItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "item";
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setName(String name) {
        this.name = name;
    }
}
