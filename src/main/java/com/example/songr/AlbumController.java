package com.example.songr;

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
    SongrRepository AlbumRepository;

    @GetMapping("/addAlbum")
    public String getAlbumList(Model model) {
        model.addAttribute("Albums", AlbumRepository.findAll());
        return "addAlbum";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(@ModelAttribute Album album, Model model) {
        model.addAttribute("Album", album);
        AlbumRepository.save(album);
        return new RedirectView("/albums");
    }
}
