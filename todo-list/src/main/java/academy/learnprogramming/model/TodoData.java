package academy.learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;


public class TodoData {
    private static int idValue = 1;
    private final List<TodoItem> items = new ArrayList<TodoItem>();

    public TodoData() {
        addItem(new TodoItem("First", "This is a first item", LocalDate.now()));
        addItem(new TodoItem("Second", "This is a second item", LocalDate.now()));
        addItem(new TodoItem("Third", "This is a third item", LocalDate.now()));
    }

    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void addItem(@NonNull TodoItem item) {
        item.setId(idValue);
        items.add(item);
        idValue++;
    }

    public void removeItem(int id) {
        ListIterator<TodoItem> iterator = items.listIterator();
        while(iterator.hasNext()) {
            TodoItem item = iterator.next();
            if(item.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public TodoItem getTodo(int id) {
        for(TodoItem i: items) {
            if(i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public void updateItem(@NonNull  TodoItem item) {
        ListIterator<TodoItem> iterator = items.listIterator();
        while (iterator.hasNext()) {
            TodoItem i = iterator.next();
            if(item.getId() == i.getId()) {
                iterator.set(item);
                break;
            }
        }
    }
}
