package fcit.cpit251.todoBaraaAPI;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("todos")
@CrossOrigin(origins ="*", allowedHeaders = "*")
public class TodoController {

    List<ToDo> todoList = new ArrayList<ToDo>();

    // HTTP GET method that returns a todo item by its Id.
    @GetMapping(value="/{id}", produces = "application/json")
    public @ResponseBody ToDo getToDo(@PathVariable String id) {
        System.out.println("Finding a todo item with id " + id);
        return findToDoById(id);
    }

    // HTTP POST method that creates a new todo item.
    @PostMapping(value="/", consumes = "application/json", produces = "application/json")
    public @ResponseBody boolean createToDo(@RequestBody ToDo todo) {
        System.out.println("Adding a todo item  " + todo);
        return addToDoItem(todo);
    }

    // HTTP DELETE method that deletes a todo item by its Id.
    @DeleteMapping(value="/{id}", produces = "application/json")
    public @ResponseBody boolean deleteToDo(@PathVariable String id) {
        System.out.println("Deleting a todo item with id " + id);
        return deleteToDoById(id);
    }

    private ToDo findToDoById(String id) {
        return todoList.stream().filter(todo -> id.equals(todo.getId())).findFirst().orElse(null);
    }

    private boolean addToDoItem(ToDo todo) {
        return todoList.add(todo);
    }

    private boolean deleteToDoById(String id) {
        return todoList.removeIf(todoItem -> todoItem.getId().equals(id));
    }
}
