package com.ascent.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ListController {
    ListService listService;

    public ListController(ListService listService) {
        this.listService = listService;
    }

    @GetMapping("list")
    public ArrayList<ListItem> getList() {
        return listService.getListItems();
    }

    @GetMapping("listItem/{id}")
    public ListItem getItemById(@PathVariable int id) {
        return listService.getItemById(id);
    }

    @PostMapping("/listItem")
    public ListItem addListItem(@RequestBody ListItem listItem) {
        return listService.addListItem(listItem);
    }

    @PatchMapping("listItem/{id}")
    public ListItem updateListItemBody(@PathVariable int id, @RequestBody String body) {
        return listService.updateBody(id, body);
    }

    @DeleteMapping("listItem/{id}")
    public ArrayList<ListItem> deleteItemById(@PathVariable int id) {
        return listService.deleteItemById(id);
    }


}
