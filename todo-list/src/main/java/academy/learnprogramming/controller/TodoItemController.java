package academy.learnprogramming.controller;

import academy.learnprogramming.model.TodoData;
import academy.learnprogramming.model.TodoItem;
import academy.learnprogramming.service.TodoItemService;
import academy.learnprogramming.util.AttributeNames;
import academy.learnprogramming.util.Mapping;
import academy.learnprogramming.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    private TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    @ModelAttribute("todoItem")
    public TodoData todoData() {
        TodoData tData = todoItemService.getData();
        // tData.addItem(new TodoItem("Fourth", "Fourth Item Details !", LocalDate.now()));
        return tData;
    }

    @GetMapping(Mapping.ITEMS)
    public String items() {
        return ViewNames.ITEM_NAMES;
    }

    @GetMapping(Mapping.ADD_ITEM)
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model) {
        TodoItem todoItem = todoItemService.getItem(id);
        if(todoItem == null) {
            todoItem = new TodoItem("", "", LocalDate.now());
        }

        model.addAttribute(AttributeNames.TODO_ITEMS, todoItem);
        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mapping.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEMS) TodoItem todoItem) {
        log.info("Todo Item {}", todoItem);
        if(todoItem.getId() == 0) {
            todoItemService.addItem(todoItem);
        }
        else {
            todoItemService.updateItem(todoItem);
        }
        return "redirect:/" + Mapping.ITEMS;
    }

    @GetMapping(Mapping.DELETE_ITEM)
    public String deleteItem(@RequestParam("id") int id) {
        log.info("Todo Item Id {}", id);
        todoItemService.removeItem(id);
        log.info("Removed item with id {}", id);
        return "redirect:/" + Mapping.ITEMS;
    }

    @GetMapping(Mapping.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model) {
        log.info("View item with id {}", id);
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute("todoItem", todoItem);
        return ViewNames.VIEW_ITEM;
    }
}
