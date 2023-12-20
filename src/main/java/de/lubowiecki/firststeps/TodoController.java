package de.lubowiecki.firststeps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller // liefert HTML aus
public class TodoController {

    @Autowired
    private TodoRepository repository;

    /*
    private List<Todo> todos = new ArrayList<>();

    TodoController() {
        // Beispieldaten
        todos.add(new Todo("Essen mit Peter", "Arbeitsbesprechung"));
        todos.add(new Todo("Golfen mit Olaf", "Nachölen ;-)"));
        todos.add(new Todo("Kaffee besorgen", "Ist fast alle"));
    }
    */

    @GetMapping("/")
    public String start() {
        return "standard"; // Name des HTML-Templates
    }

    @GetMapping("/todos")
    public String todoList(Model ui) { // über das Model kann man Daten an die HTML-Vorlage übertragen
        //ui.addAttribute("todos", todos); // Die Liste der Todos wird an das list-Template übertragen
        ui.addAttribute("todos", repository.findAll()); // Liest alle Objekte aus der DB
        return "list";
    }

    @GetMapping("/form")
    public String todoForm(Model ui) {
        ui.addAttribute("todo", new Todo());
        return "form";
    }


    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model ui) {

        Optional<Todo> opt = repository.findById(id);
        if(opt.isPresent()) {
            ui.addAttribute("todo", opt.get()); // Objekt wurde gefunden
        }
        else {
            ui.addAttribute("todo", new Todo()); // Wurde nicht gefunden
        }
        return "form";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable int id) {
        repository.deleteById(id);
        return "redirect:/todos";
    }

    /*
    @PostMapping("/save")
    public String saveTodo(int id, String name, String description, boolean done) {
        Todo todo = new Todo(name, description);
        todo.setDone(done);
        //todos.add(todo);
        repository.save(todo); // Speichert das Objekt in der DB
        return "redirect:/todos";
    }
    */

    @PostMapping("/save")
    public String saveTodo(Todo todo) {
        todo.setCreatedAt(LocalDateTime.now());
        repository.save(todo); // Speichert das Objekt in der DB
        return "redirect:/todos";
    }
}
