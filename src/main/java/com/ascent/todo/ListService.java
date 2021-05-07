package com.ascent.todo;

import java.util.ArrayList;
import java.util.List;

public class ListService {

    private ArrayList<ListItem> itemList = new ArrayList<>();

    public ListService() {
    }

    public ArrayList<ListItem> getListItems() {
        return itemList;
    }

    public ListItem addListItem(ListItem listItem) {
        itemList.add(listItem);
        return listItem;
    }

    public ListItem getItemById(int id) {
        for(ListItem item : itemList) {
            if(item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public ListItem updateBody(int anyInt, String anyString) {
        ListItem updated = itemList.get(anyInt);
        updated.setBody(anyString);
        return updated;
    }

    public ArrayList<ListItem> deleteItemById(int id) {
        ListItem deletedItem = itemList.get(id);
        itemList.remove(deletedItem);
        return itemList;
    }
}
