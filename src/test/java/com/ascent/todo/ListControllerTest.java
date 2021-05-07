package com.ascent.todo;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class ListControllerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  ListService listService;

  ArrayList<ListItem> itemList;

  @BeforeEach
  void setUp() {
    itemList = new ArrayList<>();
    for (int i = 0; i < 10; i++){
      itemList.add(new ListItem());
    }
  }

  @Test
  void getList() throws Exception{
    when(listService.getListItems()).thenReturn(itemList);
    mockMvc.perform(get("/list"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(10)));
  }



}
