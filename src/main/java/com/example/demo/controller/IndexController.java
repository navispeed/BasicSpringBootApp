package com.example.demo.controller;

import com.example.demo.dao.FakeDao;
import com.example.demo.model.CalcForm;
import com.example.demo.model.User;
import com.example.demo.repository.FakeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class IndexController {
    private final FakeRepository repository;

    public IndexController(FakeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public List<User> index() {
        return repository.findAll();
    }

    @GetMapping("/toto")
    public String dynamic(Model model, @RequestParam String text) {
        model.addAttribute("message", text);
        return "index";
    }

    @PostMapping("/calc")
    public String dynamic(Model model, @RequestParam CalcForm f) {
        model.addAttribute("message", "resultat: " + (f.getA() + f.getB()));
        return "index";
    }

    @PostMapping("/user")
    public ResponseEntity<Void> createUser(@RequestBody User user) {
        this.repository.put(user);
        return ResponseEntity.ok().build();
    }


}
