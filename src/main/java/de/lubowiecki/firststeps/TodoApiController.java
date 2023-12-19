package de.lubowiecki.firststeps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1") // wird allen URLs dieses Controllers vorangestellt
public class TodoApiController {

    @GetMapping("/haus")
    public String sagHallo() {
        return "Das ist das Haus von Nikigraus!";
    }

    @GetMapping("/list")
    public List<String> getNameList() {

        List<String> list = new ArrayList<>();
        list.add("Peter");
        list.add("Carol");
        list.add("Natasha");
        list.add("Bruce");
        list.add("Tony");
        list.add("Scott");

        return list;
    }

    @GetMapping("/map")
    public Map<String, Integer> getCityMap() {

        Map<String, Integer> map = new HashMap<>();
        map.put("Hamburg", 1900000);
        map.put("Nürnberg", 600000);
        map.put("Berlin", 3500000);
        map.put("Kiel", 200000);

        return map;
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {

        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Essen mit Peter", "Arbeitsbesprechung"));
        todos.add(new Todo("Golfen mit Olaf", "Nachölen ;-)"));
        todos.add(new Todo("Kaffee besorgen", "Ist fast alle"));

        return todos;
    }
}
