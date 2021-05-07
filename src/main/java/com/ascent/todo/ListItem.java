package com.ascent.todo;

public class ListItem {

    private String name = "item";
    private int id;

    public ListItem() {
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
}
