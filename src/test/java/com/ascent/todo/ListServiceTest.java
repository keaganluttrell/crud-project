package com.ascent.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ListServiceTest {

    ListService listService;

    ArrayList<ListItem> testItems;

    @BeforeEach
    void setUp() {
        testItems = new ArrayList<>();
        listService = new ListService();

        for (int i = 0; i < 25; i++) {
            testItems.add(listService.addListItem(new ListItem(i)));
        }
    }

    @Test
    void geListItems() {
        assertEquals(25, listService.getListItems().size());
    }

    @Test
    void addItemToList() {
        listService.addListItem(new ListItem(25));
        assertEquals(26, listService.getListItems().size());
    }

    @Test
    void getById() {
        ListItem actual = testItems.get(10);
        assertEquals(listService.getItemById(actual.getId()), actual);
    }

    @Test
    void updateItemBody() {
        ListItem item = testItems.get(5);
        item.setBody("old body");
        String newBody = "new body";

        item = listService.updateBody(5, newBody);
        assertEquals(newBody, item.getBody());
    }

    @Test
    void deleteItemById(){
        listService.deleteItemById(5);
        assertNull(listService.getItemById(5));
    }
}
