package com.example.songr;

import com.example.songr.Album;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String greetings(@RequestParam(name = "name", required = false, defaultValue = "world") String name,
            Model model) {
        model.addAttribute("name", name); // this is passed to the template automatically
        return "hello"; // this represents the name of the html template which will be rendered
    }

    @GetMapping("/")
    public String homepage() {
        return "index";
    }

    @GetMapping("/capitalize/{hello}")
    public String capitalize(Model model, @PathVariable String hello) {
        model.addAttribute("hello", hello.toUpperCase(Locale.ROOT));
        return "capitalize";
    }


}
