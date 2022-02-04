package io.github.bartmy.GroupS.additionals.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/todos")
class TodoServlet{

    private TodoRepository repository;

    TodoServlet(TodoRepository repository){
        this.repository = repository;
    }

    @GetMapping
    ResponseEntity<List<Todo>> findAllTodos(){
        log.info("Got get todo request ");
        return ResponseEntity.ok(repository.findAll());
    }

    @PutMapping("/{id}")
    ResponseEntity<Todo> toggleTodo(@PathVariable Integer id){
        log.info("Got put todo request ");
        var todo = repository.findById(id);
        todo.ifPresent(t -> {
            t.setDone(!t.isDone());
            repository.save(t);
        });
        return todo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    ResponseEntity<Todo> saveTodo(@RequestBody Todo todo){
        log.info("Got post todo request ");
        return ResponseEntity.ok(repository.save(todo));
    }
}

