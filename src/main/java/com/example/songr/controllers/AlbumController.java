package com.example.songr.controllers;

import com.example.songr.model.Album;
import com.example.songr.repository.SongrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;
@Controller
public class AlbumController {
    @Autowired
    SongrRepository songrRepository;

//    @GetMapping("/addAlbum")
//    public String addAlbumForm(){
//        return "addAlbum";
//    }


    @GetMapping("/addAlbum")
    public String getAlbumList(Model model) {
        model.addAttribute("album", songrRepository.findAll());
        return "addAlbum";
    }


    @PostMapping("/addAlbum")
    public RedirectView addAlbum(@ModelAttribute Album album, Model model) {
        model.addAttribute("Albums", album);
        songrRepository.save(album);
        return new RedirectView("/addAlbum");
    }
}
