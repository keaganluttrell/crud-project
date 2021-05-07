package com.ascent.todo;

public class ListItem {

    private String name = "item";

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
}
