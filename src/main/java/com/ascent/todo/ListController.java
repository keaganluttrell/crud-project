package com.ascent.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

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

}
