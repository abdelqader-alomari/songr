package com.example.songr.controller;

import com.example.songr.model.Album;

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

    Album albums[] = {
            new Album("MyWay", "Frank Sinatra", 10, 1947,
                    "https://th.bing.com/th/id/R.30f669b2967e9ab95bf74268c52f0f8a?rik=my6BBb79N6n%2bLQ&pid=ImgRaw&r=0"),
            new Album("L-O-V-E", "Nat King Cole", 16, 2558,
                    "https://th.bing.com/th/id/R.23144b7b337175c9b7b23c0ce35e2b32?rik=Ep0xStSXR3jxJw&riu=http%3a%2f%2fcps-static.rovicorp.com%2f3%2fJPG_400%2fMI0000%2f012%2fMI0000012214.jpg%3fpartner%3dallrovi.com&ehk=LczjV1TPUSSnn3bSm0ERWB0xlTjYucj7ts4deE16LLI%3d&risl=&pid=ImgRaw&r=0"),
            new Album("parachutes", "Coldplay", 10, 2489,
                    "https://th.bing.com/th/id/R.7df771f6610835736b113a810e301ead?rik=FO0S7N69jpw6qQ&riu=http%3a%2f%2f3.bp.blogspot.com%2f-wJ1hDEcCWkA%2fUUYpYtbpvuI%2fAAAAAAAABxM%2fimRLmzbjRV4%2fs1600%2fcoldplay-parachutes_cd.jpg&ehk=lxmfBlkqGj9bBNNDZn7B1TM%2bQ2RAi5vVlNZ7hbn%2bt2M%3d&risl=&pid=ImgRaw&r=0") };

    // @GetMapping("/albums")
    // public String albums(Model model) {
    // model.addAttribute("album", albums);
    // return "albums";
    // }

}
