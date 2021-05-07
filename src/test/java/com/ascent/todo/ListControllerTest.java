package com.ascent.todo;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
      itemList.add(new ListItem(i));
    }
  }

  @Test
  void getList() throws Exception{
    when(listService.getListItems()).thenReturn(itemList);

    mockMvc.perform(get("/list"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(10)));
  }

  @Test
  void addListItem() throws Exception {
    when(listService.addListItem(any(ListItem.class))).thenReturn(new ListItem("New Item"));

    mockMvc.perform(post("/listItem")
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"name\":\"New Item\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("name").value("New Item"));
  }

  @Test
  void getItemById() throws Exception {
    ListItem actual = new ListItem("GotTheItem");
    actual.setId(727);
    when(listService.getItemById(anyInt())).thenReturn(actual);
    mockMvc.perform(get("/listItem/" + actual.getId()))
        .andExpect(status().isOk())
        .andExpect(jsonPath("id").value(727));
  }

  @Test
  void updateBody() throws Exception {
    ListItem actual= new ListItem("bodyTest");
    actual.setId(9);
    actual.setBody("this is the body");
    when(listService.updateBody(anyInt(), anyString())).thenReturn(actual);

    mockMvc.perform(patch("/listItem/" + actual.getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content("{\"body\":\"this is the body\"}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("body").value("this is the body"));
  }

  @Test
  void deleteListItem() throws Exception {

    when(listService.deleteItemById(anyInt())).thenReturn(itemList);

    mockMvc.perform(delete("/listItem/3"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(10)));
  }


}
